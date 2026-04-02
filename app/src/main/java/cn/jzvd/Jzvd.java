package cn.jzvd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class Jzvd extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    public static Jzvd CURRENT_JZVD = null;
    public static final int SCREEN_FULLSCREEN = 1;
    public static final int SCREEN_NORMAL = 0;
    public static final int SCREEN_TINY = 2;
    public static final int STATE_AUTO_COMPLETE = 6;
    public static final int STATE_ERROR = 7;
    public static final int STATE_IDLE = -1;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_PAUSE = 5;
    public static final int STATE_PLAYING = 4;
    public static final int STATE_PREPARED = 3;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_PREPARING_CHANGING_URL = 2;
    public static final String TAG = "JZVD";
    public static final int THRESHOLD = 80;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    protected Timer UPDATE_PROGRESS_TIMER;
    public ViewGroup bottomContainer;
    public TextView currentTimeTextView;
    public ImageView fullscreenButton;
    protected long gobakFullscreenTime;
    public int heightRatio;
    public JZDataSource jzDataSource;
    protected AudioManager mAudioManager;
    protected boolean mChangeBrightness;
    protected boolean mChangePosition;
    protected boolean mChangeVolume;
    protected float mDownX;
    protected float mDownY;
    protected float mGestureDownBrightness;
    protected long mGestureDownPosition;
    protected int mGestureDownVolume;
    protected ProgressTimerTask mProgressTimerTask;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected long mSeekTimePosition;
    protected boolean mTouchingProgressBar;
    public JZMediaInterface mediaInterface;
    public Class mediaInterfaceClass;
    public int positionInList;
    public boolean preloading;
    public SeekBar progressBar;
    public int screen;
    public long seekToInAdvance;
    public int seekToManulPosition;
    public ImageView startButton;
    public int state;
    public JZTextureView textureView;
    public ViewGroup textureViewContainer;
    public ViewGroup topContainer;
    public TextView totalTimeTextView;
    public int videoRotation;
    public int widthRatio;
    public static LinkedList<ViewGroup> CONTAINER_LIST = new LinkedList<>();
    public static boolean TOOL_BAR_EXIST = true;
    public static int FULLSCREEN_ORIENTATION = 6;
    public static int NORMAL_ORIENTATION = 1;
    public static boolean SAVE_PROGRESS = false;
    public static boolean WIFI_TIP_DIALOG_SHOWED = false;
    public static int VIDEO_IMAGE_DISPLAY_TYPE = 0;
    public static long lastAutoFullscreenTime = 0;
    public static int ON_PLAY_PAUSE_TMP_STATE = 0;
    public static AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: cn.jzvd.Jzvd.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (i2 != -2) {
                if (i2 != -1) {
                    return;
                }
                Jzvd.releaseAllVideos();
                String str = "AUDIOFOCUS_LOSS [" + hashCode() + "]";
                return;
            }
            try {
                Jzvd jzvd = Jzvd.CURRENT_JZVD;
                if (jzvd != null && jzvd.state == 4) {
                    jzvd.startButton.performClick();
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            String str2 = "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]";
        }
    };

    public static class JZAutoFullscreenListener implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if ((f2 < -12.0f || f2 > 12.0f) && System.currentTimeMillis() - Jzvd.lastAutoFullscreenTime > 2000) {
                Jzvd jzvd = Jzvd.CURRENT_JZVD;
                if (jzvd != null) {
                    jzvd.autoFullscreen(f2);
                }
                Jzvd.lastAutoFullscreenTime = System.currentTimeMillis();
            }
        }
    }

    public class ProgressTimerTask extends TimerTask {
        public ProgressTimerTask() {
        }

        public /* synthetic */ void a() {
            long currentPositionWhenPlaying = Jzvd.this.getCurrentPositionWhenPlaying();
            long duration = Jzvd.this.getDuration();
            Jzvd.this.onProgress((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2 = Jzvd.this.state;
            if (i2 == 4 || i2 == 5) {
                Jzvd.this.post(new Runnable() { // from class: cn.jzvd.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a();
                    }
                });
            }
        }
    }

    public Jzvd(Context context) {
        super(context);
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.gobakFullscreenTime = 0L;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        init(context);
    }

    public static boolean backPress() {
        Jzvd jzvd;
        Jzvd jzvd2;
        if (CONTAINER_LIST.size() != 0 && (jzvd2 = CURRENT_JZVD) != null) {
            jzvd2.gotoScreenNormal();
            return true;
        }
        if (CONTAINER_LIST.size() != 0 || (jzvd = CURRENT_JZVD) == null || jzvd.screen == 0) {
            return false;
        }
        jzvd.clearFloatScreen();
        return true;
    }

    public static void clearSavedProgress(Context context, String str) {
        JZUtils.clearSavedProgress(context, str);
    }

    public static void goOnPlayOnPause() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd != null) {
            int i2 = jzvd.state;
            if (i2 == 6 || i2 == 0 || i2 == 1 || i2 == 7) {
                releaseAllVideos();
                return;
            }
            ON_PLAY_PAUSE_TMP_STATE = i2;
            jzvd.onStatePause();
            CURRENT_JZVD.mediaInterface.pause();
        }
    }

    public static void goOnPlayOnResume() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd == null || jzvd.state != 5) {
            return;
        }
        if (ON_PLAY_PAUSE_TMP_STATE == 5) {
            jzvd.onStatePause();
            CURRENT_JZVD.mediaInterface.pause();
        } else {
            jzvd.onStatePlaying();
            CURRENT_JZVD.mediaInterface.start();
        }
        ON_PLAY_PAUSE_TMP_STATE = 0;
    }

    public static void releaseAllVideos() {
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd != null) {
            jzvd.reset();
            CURRENT_JZVD = null;
        }
    }

    public static void setCurrentJzvd(Jzvd jzvd) {
        Jzvd jzvd2 = CURRENT_JZVD;
        if (jzvd2 != null) {
            jzvd2.reset();
        }
        CURRENT_JZVD = jzvd;
    }

    public static void setTextureViewRotation(int i2) {
        JZTextureView jZTextureView;
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd == null || (jZTextureView = jzvd.textureView) == null) {
            return;
        }
        jZTextureView.setRotation(i2);
    }

    public static void setVideoImageDisplayType(int i2) {
        JZTextureView jZTextureView;
        VIDEO_IMAGE_DISPLAY_TYPE = i2;
        Jzvd jzvd = CURRENT_JZVD;
        if (jzvd == null || (jZTextureView = jzvd.textureView) == null) {
            return;
        }
        jZTextureView.requestLayout();
    }

    public static void startFullscreenDirectly(Context context, Class cls, String str, String str2) {
        startFullscreenDirectly(context, cls, new JZDataSource(str, str2));
    }

    public void addTextureView() {
        String str = "addTextureView [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            this.textureViewContainer.removeView(jZTextureView);
        }
        this.textureView = new JZTextureView(getContext().getApplicationContext());
        this.textureView.setSurfaceTextureListener(this.mediaInterface);
        this.textureViewContainer.addView(this.textureView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void autoFullscreen(float f2) {
        int i2;
        if (CURRENT_JZVD != null) {
            int i3 = this.state;
            if ((i3 != 4 && i3 != 5) || (i2 = this.screen) == 1 || i2 == 2) {
                return;
            }
            if (f2 > 0.0f) {
                JZUtils.setRequestedOrientation(getContext(), 0);
            } else {
                JZUtils.setRequestedOrientation(getContext(), 8);
            }
            gotoScreenFullscreen();
        }
    }

    public void autoQuitFullscreen() {
        if (System.currentTimeMillis() - lastAutoFullscreenTime > 2000 && this.state == 4 && this.screen == 1) {
            lastAutoFullscreenTime = System.currentTimeMillis();
            backPress();
        }
    }

    public void cancelProgressTimer() {
        Timer timer = this.UPDATE_PROGRESS_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        ProgressTimerTask progressTimerTask = this.mProgressTimerTask;
        if (progressTimerTask != null) {
            progressTimerTask.cancel();
        }
    }

    public void changeUrl(String str, String str2, long j2) {
        changeUrl(new JZDataSource(str, str2), j2);
    }

    public void clearFloatScreen() {
        JZUtils.showStatusBar(getContext());
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        JZUtils.showSystemUI(getContext());
        ((ViewGroup) JZUtils.scanForActivity(getContext()).getWindow().getDecorView()).removeView(this);
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
        CURRENT_JZVD = null;
    }

    public void cloneAJzvd(ViewGroup viewGroup) {
        try {
            Jzvd jzvd = (Jzvd) getClass().getConstructor(Context.class).newInstance(getContext());
            jzvd.setId(getId());
            viewGroup.addView(jzvd);
            jzvd.setUp(this.jzDataSource.cloneMe(), 0, this.mediaInterfaceClass);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public void dismissBrightnessDialog() {
    }

    public void dismissProgressDialog() {
    }

    public void dismissVolumeDialog() {
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.state;
        if (i2 != 4 && i2 != 5) {
            return 0L;
        }
        try {
            return this.mediaInterface.getCurrentPosition();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return this.mediaInterface.getDuration();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public abstract int getLayoutId();

    public void gotoScreenFullscreen() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeView(this);
        cloneAJzvd(viewGroup);
        CONTAINER_LIST.add(viewGroup);
        ((ViewGroup) JZUtils.scanForActivity(getContext()).getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
        setScreenFullscreen();
        JZUtils.hideStatusBar(getContext());
        JZUtils.setRequestedOrientation(getContext(), FULLSCREEN_ORIENTATION);
        JZUtils.hideSystemUI(getContext());
    }

    public void gotoScreenNormal() {
        this.gobakFullscreenTime = System.currentTimeMillis();
        ((ViewGroup) JZUtils.scanForActivity(getContext()).getWindow().getDecorView()).removeView(this);
        CONTAINER_LIST.getLast().removeAllViews();
        CONTAINER_LIST.getLast().addView(this, new FrameLayout.LayoutParams(-1, -1));
        CONTAINER_LIST.pop();
        setScreenNormal();
        JZUtils.showStatusBar(getContext());
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        JZUtils.showSystemUI(getContext());
    }

    public void init(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.startButton = (ImageView) findViewById(R.id.start);
        this.fullscreenButton = (ImageView) findViewById(R.id.fullscreen);
        this.progressBar = (SeekBar) findViewById(R.id.bottom_seek_progress);
        this.currentTimeTextView = (TextView) findViewById(R.id.current);
        this.totalTimeTextView = (TextView) findViewById(R.id.total);
        this.bottomContainer = (ViewGroup) findViewById(R.id.layout_bottom);
        this.textureViewContainer = (ViewGroup) findViewById(R.id.surface_container);
        this.topContainer = (ViewGroup) findViewById(R.id.layout_top);
        this.startButton.setOnClickListener(this);
        this.fullscreenButton.setOnClickListener(this);
        this.progressBar.setOnSeekBarChangeListener(this);
        this.bottomContainer.setOnClickListener(this);
        this.textureViewContainer.setOnClickListener(this);
        this.textureViewContainer.setOnTouchListener(this);
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        this.state = -1;
    }

    public void onAutoCompletion() {
        Runtime.getRuntime().gc();
        String str = "onAutoCompletion  [" + hashCode() + "] ";
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateAutoComplete();
        this.mediaInterface.release();
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), 0L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.start) {
            if (id == R.id.fullscreen) {
                String str = "onClick fullscreen [" + hashCode() + "] ";
                if (this.state == 6) {
                    return;
                }
                if (this.screen == 1) {
                    backPress();
                    return;
                }
                String str2 = "toFullscreenActivity [" + hashCode() + "] ";
                gotoScreenFullscreen();
                return;
            }
            return;
        }
        String str3 = "onClick start [" + hashCode() + "] ";
        JZDataSource jZDataSource = this.jzDataSource;
        if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
            Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
            return;
        }
        int i2 = this.state;
        if (i2 == 0) {
            if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith("/") || JZUtils.isWifiConnected(getContext()) || WIFI_TIP_DIALOG_SHOWED) {
                startVideo();
                return;
            } else {
                showWifiDialog();
                return;
            }
        }
        if (i2 == 4) {
            String str4 = "pauseVideo [" + hashCode() + "] ";
            this.mediaInterface.pause();
            onStatePause();
            return;
        }
        if (i2 == 5) {
            this.mediaInterface.start();
            onStatePlaying();
        } else if (i2 == 6) {
            startVideo();
        }
    }

    public void onError(int i2, int i3) {
        String str = "onError " + i2 + " - " + i3 + " [" + hashCode() + "] ";
        if (i2 == 38 || i3 == -38 || i2 == -38 || i3 == 38 || i3 == -19) {
            return;
        }
        onStateError();
        this.mediaInterface.release();
    }

    public void onInfo(int i2, int i3) {
        String str = "onInfo what - " + i2 + " extra - " + i3;
        if (i2 == 3) {
            int i4 = this.state;
            if (i4 == 3 || i4 == 2) {
                onStatePlaying();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = this.screen;
        if (i4 == 1 || i4 == 2) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.widthRatio == 0 || this.heightRatio == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = (int) ((size * this.heightRatio) / this.widthRatio);
        setMeasuredDimension(size, i5);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    public void onPrepared() {
        String str = "onPrepared  [" + hashCode() + "] ";
        this.state = 3;
        if (!this.preloading) {
            this.mediaInterface.start();
            this.preloading = false;
        }
        if (this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("mp3") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wma") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("aac") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("m4a") || this.jzDataSource.getCurrentUrl().toString().toLowerCase().contains("wav")) {
            onStatePlaying();
        }
    }

    public void onProgress(int i2, long j2, long j3) {
        if (!this.mTouchingProgressBar) {
            int i3 = this.seekToManulPosition;
            if (i3 != -1) {
                if (i3 > i2) {
                    return;
                } else {
                    this.seekToManulPosition = -1;
                }
            } else if (i2 != 0) {
                this.progressBar.setProgress(i2);
            }
        }
        if (j2 != 0) {
            this.currentTimeTextView.setText(JZUtils.stringForTime(j2));
        }
        this.totalTimeTextView.setText(JZUtils.stringForTime(j3));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (z) {
            this.currentTimeTextView.setText(JZUtils.stringForTime((((long) i2) * getDuration()) / 100));
        }
    }

    public void onSeekComplete() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStartTrackingTouch [" + hashCode() + "] ";
        cancelProgressTimer();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onStateAutoComplete() {
        String str = "onStateAutoComplete  [" + hashCode() + "] ";
        this.state = 6;
        cancelProgressTimer();
        this.progressBar.setProgress(100);
        this.currentTimeTextView.setText(this.totalTimeTextView.getText());
    }

    public void onStateError() {
        String str = "onStateError  [" + hashCode() + "] ";
        this.state = 7;
        cancelProgressTimer();
    }

    public void onStateNormal() {
        String str = "onStateNormal  [" + hashCode() + "] ";
        this.state = 0;
        cancelProgressTimer();
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
    }

    public void onStatePause() {
        String str = "onStatePause  [" + hashCode() + "] ";
        this.state = 5;
        startProgressTimer();
    }

    public void onStatePlaying() {
        String str = "onStatePlaying  [" + hashCode() + "] ";
        if (this.state == 3) {
            long j2 = this.seekToInAdvance;
            if (j2 != 0) {
                this.mediaInterface.seekTo(j2);
                this.seekToInAdvance = 0L;
            } else {
                long savedProgress = JZUtils.getSavedProgress(getContext(), this.jzDataSource.getCurrentUrl());
                if (savedProgress != 0) {
                    this.mediaInterface.seekTo(savedProgress);
                }
            }
        }
        this.state = 4;
        startProgressTimer();
    }

    public void onStatePreparing() {
        String str = "onStatePreparing  [" + hashCode() + "] ";
        this.state = 1;
        resetProgressAndTime();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStopTrackingTouch [" + hashCode() + "] ";
        startProgressTimer();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.state;
        if (i2 == 4 || i2 == 5) {
            long progress = (((long) seekBar.getProgress()) * getDuration()) / 100;
            this.seekToManulPosition = seekBar.getProgress();
            this.mediaInterface.seekTo(progress);
            String str2 = "seekTo " + progress + " [" + hashCode() + "] ";
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                String str = "onTouch surfaceContainer actionDown [" + hashCode() + "] ";
                this.mTouchingProgressBar = true;
                this.mDownX = x;
                this.mDownY = y;
                this.mChangeVolume = false;
                this.mChangePosition = false;
                this.mChangeBrightness = false;
            } else if (action == 1) {
                String str2 = "onTouch surfaceContainer actionUp [" + hashCode() + "] ";
                this.mTouchingProgressBar = false;
                dismissProgressDialog();
                dismissVolumeDialog();
                dismissBrightnessDialog();
                if (this.mChangePosition) {
                    this.mediaInterface.seekTo(this.mSeekTimePosition);
                    long duration = getDuration();
                    long j2 = this.mSeekTimePosition * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.progressBar.setProgress((int) (j2 / duration));
                }
                startProgressTimer();
            } else if (action == 2) {
                String str3 = "onTouch surfaceContainer actionMove [" + hashCode() + "] ";
                float f2 = x - this.mDownX;
                float f3 = y - this.mDownY;
                float fAbs = Math.abs(f2);
                float fAbs2 = Math.abs(f3);
                if (this.screen == 1 && !this.mChangePosition && !this.mChangeVolume && !this.mChangeBrightness && (fAbs > 80.0f || fAbs2 > 80.0f)) {
                    cancelProgressTimer();
                    if (fAbs >= 80.0f) {
                        if (this.state != 7) {
                            this.mChangePosition = true;
                            this.mGestureDownPosition = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.mDownX < this.mScreenWidth * 0.5f) {
                        this.mChangeBrightness = true;
                        float f4 = JZUtils.getWindow(getContext()).getAttributes().screenBrightness;
                        if (f4 < 0.0f) {
                            try {
                                this.mGestureDownBrightness = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                String str4 = "current system brightness: " + this.mGestureDownBrightness;
                            } catch (Settings.SettingNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            this.mGestureDownBrightness = f4 * 255.0f;
                            String str5 = "current activity brightness: " + this.mGestureDownBrightness;
                        }
                    } else {
                        this.mChangeVolume = true;
                        this.mGestureDownVolume = this.mAudioManager.getStreamVolume(3);
                    }
                }
                if (this.mChangePosition) {
                    long duration2 = getDuration();
                    this.mSeekTimePosition = (int) (this.mGestureDownPosition + ((duration2 * f2) / this.mScreenWidth));
                    if (this.mSeekTimePosition > duration2) {
                        this.mSeekTimePosition = duration2;
                    }
                    showProgressDialog(f2, JZUtils.stringForTime(this.mSeekTimePosition), this.mSeekTimePosition, JZUtils.stringForTime(duration2), duration2);
                }
                if (this.mChangeVolume) {
                    f3 = -f3;
                    this.mAudioManager.setStreamVolume(3, this.mGestureDownVolume + ((int) (((this.mAudioManager.getStreamMaxVolume(3) * f3) * 3.0f) / this.mScreenHeight)), 0);
                    showVolumeDialog(-f3, (int) (((this.mGestureDownVolume * 100) / r0) + (((f3 * 3.0f) * 100.0f) / this.mScreenHeight)));
                }
                if (this.mChangeBrightness) {
                    float f5 = -f3;
                    WindowManager.LayoutParams attributes = JZUtils.getWindow(getContext()).getAttributes();
                    float f6 = this.mGestureDownBrightness;
                    float f7 = (int) (((f5 * 255.0f) * 3.0f) / this.mScreenHeight);
                    if ((f6 + f7) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f6 + f7) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f6 + f7) / 255.0f;
                    }
                    JZUtils.getWindow(getContext()).setAttributes(attributes);
                    showBrightnessDialog((int) (((this.mGestureDownBrightness * 100.0f) / 255.0f) + (((f5 * 3.0f) * 100.0f) / this.mScreenHeight)));
                }
            }
        }
        return false;
    }

    public void onVideoSizeChanged(int i2, int i3) {
        String str = "onVideoSizeChanged  [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.textureView;
        if (jZTextureView != null) {
            int i4 = this.videoRotation;
            if (i4 != 0) {
                jZTextureView.setRotation(i4);
            }
            this.textureView.setVideoSize(i2, i3);
        }
    }

    public void reset() {
        String str = "reset  [" + hashCode() + "] ";
        int i2 = this.state;
        if (i2 == 4 || i2 == 5) {
            JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), getCurrentPositionWhenPlaying());
        }
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateNormal();
        this.textureViewContainer.removeAllViews();
        ((AudioManager) getApplicationContext().getSystemService("audio")).abandonAudioFocus(onAudioFocusChangeListener);
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZMediaInterface jZMediaInterface = this.mediaInterface;
        if (jZMediaInterface != null) {
            jZMediaInterface.release();
        }
    }

    public void resetProgressAndTime() {
        this.progressBar.setProgress(0);
        this.progressBar.setSecondaryProgress(0);
        this.currentTimeTextView.setText(JZUtils.stringForTime(0L));
        this.totalTimeTextView.setText(JZUtils.stringForTime(0L));
    }

    public void setBufferProgress(int i2) {
        if (i2 != 0) {
            this.progressBar.setSecondaryProgress(i2);
        }
    }

    public void setMediaInterface(Class cls) {
        reset();
        this.mediaInterfaceClass = cls;
    }

    public void setScreen(int i2) {
        if (i2 == 0) {
            setScreenNormal();
        } else if (i2 == 1) {
            setScreenFullscreen();
        } else {
            if (i2 != 2) {
                return;
            }
            setScreenTiny();
        }
    }

    public void setScreenFullscreen() {
        this.screen = 1;
    }

    public void setScreenNormal() {
        this.screen = 0;
    }

    public void setScreenTiny() {
        this.screen = 2;
    }

    public void setState(int i2) {
        setState(i2, 0, 0);
    }

    public void setUp(String str, String str2) {
        setUp(new JZDataSource(str, str2), 0);
    }

    public void showBrightnessDialog(int i2) {
    }

    public void showProgressDialog(float f2, String str, long j2, String str2, long j3) {
    }

    public void showVolumeDialog(float f2, int i2) {
    }

    public void showWifiDialog() {
    }

    public void startPreloading() {
        this.preloading = true;
        startVideo();
    }

    public void startProgressTimer() {
        String str = "startProgressTimer:  [" + hashCode() + "] ";
        cancelProgressTimer();
        this.UPDATE_PROGRESS_TIMER = new Timer();
        this.mProgressTimerTask = new ProgressTimerTask();
        this.UPDATE_PROGRESS_TIMER.schedule(this.mProgressTimerTask, 0L, 300L);
    }

    public void startVideo() {
        String str = "startVideo [" + hashCode() + "] ";
        setCurrentJzvd(this);
        try {
            this.mediaInterface = (JZMediaInterface) this.mediaInterfaceClass.getConstructor(Jzvd.class).newInstance(this);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        addTextureView();
        this.mAudioManager = (AudioManager) getApplicationContext().getSystemService("audio");
        this.mAudioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
        JZUtils.scanForActivity(getContext()).getWindow().addFlags(128);
        onStatePreparing();
    }

    public void startVideoAfterPreloading() {
        if (this.state == 3) {
            this.mediaInterface.start();
        } else {
            this.preloading = false;
            startVideo();
        }
    }

    public static void startFullscreenDirectly(Context context, Class cls, JZDataSource jZDataSource) {
        JZUtils.hideStatusBar(context);
        JZUtils.setRequestedOrientation(context, FULLSCREEN_ORIENTATION);
        JZUtils.hideSystemUI(context);
        ViewGroup viewGroup = (ViewGroup) JZUtils.scanForActivity(context).getWindow().getDecorView();
        try {
            Jzvd jzvd = (Jzvd) cls.getConstructor(Context.class).newInstance(context);
            viewGroup.addView(jzvd, new FrameLayout.LayoutParams(-1, -1));
            jzvd.setUp(jZDataSource, 1);
            jzvd.startVideo();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void changeUrl(int i2, long j2) {
        this.state = 2;
        this.seekToInAdvance = j2;
        this.jzDataSource.currentUrlIndex = i2;
        this.mediaInterface.setSurface(null);
        this.mediaInterface.release();
        this.mediaInterface.prepare();
    }

    public void setState(int i2, int i3, int i4) {
        if (i2 == 0) {
            onStateNormal();
            return;
        }
        if (i2 == 1) {
            onStatePreparing();
            return;
        }
        if (i2 == 2) {
            changeUrl(i3, i4);
            return;
        }
        if (i2 == 4) {
            onStatePlaying();
            return;
        }
        if (i2 == 5) {
            onStatePause();
        } else if (i2 == 6) {
            onStateAutoComplete();
        } else {
            if (i2 != 7) {
                return;
            }
            onStateError();
        }
    }

    public void setUp(String str, String str2, int i2) {
        setUp(new JZDataSource(str, str2), i2);
    }

    public void setUp(JZDataSource jZDataSource, int i2) {
        setUp(jZDataSource, i2, JZMediaSystem.class);
    }

    public void setUp(String str, String str2, int i2, Class cls) {
        setUp(new JZDataSource(str, str2), i2, cls);
    }

    public void setUp(JZDataSource jZDataSource, int i2, Class cls) {
        if (System.currentTimeMillis() - this.gobakFullscreenTime < 200) {
            return;
        }
        this.jzDataSource = jZDataSource;
        this.screen = i2;
        onStateNormal();
        this.mediaInterfaceClass = cls;
    }

    public void changeUrl(JZDataSource jZDataSource, long j2) {
        this.state = 2;
        this.seekToInAdvance = j2;
        this.jzDataSource = jZDataSource;
        this.mediaInterface.setSurface(null);
        this.mediaInterface.release();
        this.mediaInterface.prepare();
    }

    public Jzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.state = -1;
        this.screen = -1;
        this.widthRatio = 0;
        this.heightRatio = 0;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.gobakFullscreenTime = 0L;
        this.seekToManulPosition = -1;
        this.seekToInAdvance = 0L;
        this.preloading = false;
        init(context);
    }
}
