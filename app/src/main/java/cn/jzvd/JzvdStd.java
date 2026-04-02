package cn.jzvd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class JzvdStd extends Jzvd {
    protected static Timer DISMISS_CONTROL_VIEW_TIMER = null;
    public static int LAST_GET_BATTERYLEVEL_PERCENT = 70;
    public static long LAST_GET_BATTERYLEVEL_TIME;
    public ImageView backButton;
    private BroadcastReceiver battertReceiver;
    public ImageView batteryLevel;
    public LinearLayout batteryTimeLayout;
    public ProgressBar bottomProgressBar;
    public TextView clarity;
    public PopupWindow clarityPopWindow;
    private ArrayDeque<Runnable> delayTask;
    private long doubleTime;
    private long lastClickTime;
    public ProgressBar loadingProgressBar;
    protected Dialog mBrightnessDialog;
    protected ProgressBar mDialogBrightnessProgressBar;
    protected TextView mDialogBrightnessTextView;
    protected ImageView mDialogIcon;
    protected ProgressBar mDialogProgressBar;
    protected TextView mDialogSeekTime;
    protected TextView mDialogTotalTime;
    protected ImageView mDialogVolumeImageView;
    protected ProgressBar mDialogVolumeProgressBar;
    protected TextView mDialogVolumeTextView;
    protected DismissControlViewTimerTask mDismissControlViewTimerTask;
    protected Dialog mProgressDialog;
    public TextView mRetryBtn;
    public LinearLayout mRetryLayout;
    protected Dialog mVolumeDialog;
    public TextView replayTextView;
    public ImageView thumbImageView;
    public ImageView tinyBackImageView;
    public TextView titleTextView;
    public TextView videoCurrentTime;

    public class DismissControlViewTimerTask extends TimerTask {
        public DismissControlViewTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            JzvdStd.this.dissmissControlView();
        }
    }

    public JzvdStd(Context context) {
        super(context);
        this.lastClickTime = 0L;
        this.doubleTime = 200L;
        this.delayTask = new ArrayDeque<>();
        this.battertReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                    JzvdStd.this.setBatteryLevel();
                    try {
                        JzvdStd.this.getContext().unregisterReceiver(JzvdStd.this.battertReceiver);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
    }

    public /* synthetic */ void a(LinearLayout linearLayout, View view) {
        changeUrl(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.jzDataSource.currentUrlIndex) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.clarityPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public /* synthetic */ void b() {
        if (this.mChangePosition || this.mChangeVolume) {
            return;
        }
        onClickUiToggle();
    }

    public void cancelDismissControlViewTimer() {
        Timer timer = DISMISS_CONTROL_VIEW_TIMER;
        if (timer != null) {
            timer.cancel();
        }
        DismissControlViewTimerTask dismissControlViewTimerTask = this.mDismissControlViewTimerTask;
        if (dismissControlViewTimerTask != null) {
            dismissControlViewTimerTask.cancel();
        }
    }

    public void changeStartButtonSize(int i2) {
        ViewGroup.LayoutParams layoutParams = this.startButton.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        ViewGroup.LayoutParams layoutParams2 = this.loadingProgressBar.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.width = i2;
    }

    public void changeUiToComplete() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToError() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(4, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 4, 4, 0);
            updateStartImage();
        }
    }

    public void changeUiToNormal() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 4, 0, 4, 0, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPauseClear() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPauseShow() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPlayingClear() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(4, 4, 4, 4, 4, 0, 4);
        }
    }

    public void changeUiToPlayingShow() {
        int i2 = this.screen;
        if (i2 == 0) {
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        } else {
            if (i2 != 1) {
                return;
            }
            setAllControlsVisiblity(0, 0, 0, 4, 4, 4, 4);
            updateStartImage();
        }
    }

    public void changeUiToPreparing() {
        int i2 = this.screen;
        if (i2 == 0 || i2 == 1) {
            setAllControlsVisiblity(4, 4, 4, 0, 0, 4, 4);
            updateStartImage();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(int i2, long j2) {
        super.changeUrl(i2, j2);
        this.startButton.setVisibility(4);
        this.replayTextView.setVisibility(8);
        this.mRetryLayout.setVisibility(8);
    }

    public Dialog createDialogWithView(View view) {
        Dialog dialog = new Dialog(getContext(), R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // cn.jzvd.Jzvd
    public void dismissBrightnessDialog() {
        super.dismissBrightnessDialog();
        Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dissmissControlView() {
        int i2 = this.state;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: cn.jzvd.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.jz_layout_std;
    }

    @Override // cn.jzvd.Jzvd
    public void init(Context context) {
        super.init(context);
        this.batteryTimeLayout = (LinearLayout) findViewById(R.id.battery_time_layout);
        this.bottomProgressBar = (ProgressBar) findViewById(R.id.bottom_progress);
        this.titleTextView = (TextView) findViewById(R.id.title);
        this.backButton = (ImageView) findViewById(R.id.back);
        this.thumbImageView = (ImageView) findViewById(R.id.thumb);
        this.loadingProgressBar = (ProgressBar) findViewById(R.id.loading);
        this.tinyBackImageView = (ImageView) findViewById(R.id.back_tiny);
        this.batteryLevel = (ImageView) findViewById(R.id.battery_level);
        this.videoCurrentTime = (TextView) findViewById(R.id.video_current_time);
        this.replayTextView = (TextView) findViewById(R.id.replay_text);
        this.clarity = (TextView) findViewById(R.id.clarity);
        this.mRetryBtn = (TextView) findViewById(R.id.retry_btn);
        this.mRetryLayout = (LinearLayout) findViewById(R.id.retry_layout);
        this.thumbImageView.setOnClickListener(this);
        this.backButton.setOnClickListener(this);
        this.tinyBackImageView.setOnClickListener(this);
        this.clarity.setOnClickListener(this);
        this.mRetryBtn.setOnClickListener(this);
    }

    @Override // cn.jzvd.Jzvd
    public void onAutoCompletion() {
        super.onAutoCompletion();
        cancelDismissControlViewTimer();
    }

    public void onCLickUiToggleToClear() {
        int i2 = this.state;
        if (i2 == 1) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPreparing();
            }
        } else if (i2 == 4) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
            }
        } else if (i2 == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            }
        } else if (i2 == 6 && this.bottomContainer.getVisibility() == 0) {
            changeUiToComplete();
        }
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.thumb) {
            JZDataSource jZDataSource = this.jzDataSource;
            if (jZDataSource == null || jZDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
                Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                return;
            }
            int i2 = this.state;
            if (i2 != 0) {
                if (i2 == 6) {
                    onClickUiToggle();
                    return;
                }
                return;
            } else if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith("/") || JZUtils.isWifiConnected(getContext()) || Jzvd.WIFI_TIP_DIALOG_SHOWED) {
                startVideo();
                return;
            } else {
                showWifiDialog();
                return;
            }
        }
        if (id == R.id.surface_container) {
            startDismissControlViewTimer();
            return;
        }
        if (id == R.id.back) {
            Jzvd.backPress();
            return;
        }
        if (id == R.id.back_tiny) {
            clearFloatScreen();
            return;
        }
        if (id != R.id.clarity) {
            if (id == R.id.retry_btn) {
                if (this.jzDataSource.urlsMap.isEmpty() || this.jzDataSource.getCurrentUrl() == null) {
                    Toast.makeText(getContext(), getResources().getString(R.string.no_url), 0).show();
                    return;
                }
                if (!this.jzDataSource.getCurrentUrl().toString().startsWith("file") && !this.jzDataSource.getCurrentUrl().toString().startsWith("/") && !JZUtils.isWifiConnected(getContext()) && !Jzvd.WIFI_TIP_DIALOG_SHOWED) {
                    showWifiDialog();
                    return;
                } else {
                    addTextureView();
                    onStatePreparing();
                    return;
                }
            }
            return;
        }
        final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.jz_layout_clarity, (ViewGroup) null);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cn.jzvd.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.a(linearLayout, view2);
            }
        };
        for (int i3 = 0; i3 < this.jzDataSource.urlsMap.size(); i3++) {
            String keyFromDataSource = this.jzDataSource.getKeyFromDataSource(i3);
            TextView textView = (TextView) View.inflate(getContext(), R.layout.jz_layout_clarity_item, null);
            textView.setText(keyFromDataSource);
            textView.setTag(Integer.valueOf(i3));
            linearLayout.addView(textView, i3);
            textView.setOnClickListener(onClickListener);
            if (i3 == this.jzDataSource.currentUrlIndex) {
                textView.setTextColor(Color.parseColor("#fff85959"));
            }
        }
        this.clarityPopWindow = new PopupWindow((View) linearLayout, -2, -2, true);
        this.clarityPopWindow.setContentView(linearLayout);
        this.clarityPopWindow.showAsDropDown(this.clarity);
        linearLayout.measure(0, 0);
        this.clarityPopWindow.update(this.clarity, -(this.clarity.getMeasuredWidth() / 3), -(this.clarity.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    public void onClickUiToggle() {
        if (this.bottomContainer.getVisibility() != 0) {
            setSystemTimeAndBattery();
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
        }
        int i2 = this.state;
        if (i2 == 1) {
            changeUiToPreparing();
            if (this.bottomContainer.getVisibility() == 0) {
                return;
            }
            setSystemTimeAndBattery();
            return;
        }
        if (i2 == 4) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
                return;
            } else {
                changeUiToPlayingShow();
                return;
            }
        }
        if (i2 == 5) {
            if (this.bottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            } else {
                changeUiToPauseShow();
            }
        }
    }

    @Override // cn.jzvd.Jzvd
    public void onProgress(int i2, long j2, long j3) {
        super.onProgress(i2, j2, j3);
        if (i2 != 0) {
            this.bottomProgressBar.setProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        changeUiToComplete();
        cancelDismissControlViewTimer();
        this.bottomProgressBar.setProgress(100);
    }

    @Override // cn.jzvd.Jzvd
    public void onStateError() {
        super.onStateError();
        changeUiToError();
    }

    @Override // cn.jzvd.Jzvd
    public void onStateNormal() {
        super.onStateNormal();
        changeUiToNormal();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePause() {
        super.onStatePause();
        changeUiToPauseShow();
        cancelDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePlaying() {
        super.onStatePlaying();
        changeUiToPlayingClear();
    }

    @Override // cn.jzvd.Jzvd
    public void onStatePreparing() {
        super.onStatePreparing();
        changeUiToPreparing();
    }

    @Override // cn.jzvd.Jzvd, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        startDismissControlViewTimer();
    }

    @Override // cn.jzvd.Jzvd, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action != 0 && action == 1) {
                startDismissControlViewTimer();
                if (this.mChangePosition) {
                    long duration = getDuration();
                    long j2 = this.mSeekTimePosition * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.bottomProgressBar.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: cn.jzvd.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                };
                view.postDelayed(runnable, this.doubleTime + 20);
                this.delayTask.add(runnable);
                while (this.delayTask.size() > 2) {
                    this.delayTask.pollFirst();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.lastClickTime < this.doubleTime) {
                    Iterator<Runnable> it = this.delayTask.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.state;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.startButton.performClick();
                    }
                }
                this.lastClickTime = jCurrentTimeMillis;
            }
        } else if (id == R.id.bottom_seek_progress) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                cancelDismissControlViewTimer();
            } else if (action2 == 1) {
                startDismissControlViewTimer();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    @Override // cn.jzvd.Jzvd
    public void reset() {
        super.reset();
        cancelDismissControlViewTimer();
        PopupWindow popupWindow = this.clarityPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.bottomProgressBar.setProgress(0);
        this.bottomProgressBar.setSecondaryProgress(0);
    }

    public void setAllControlsVisiblity(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.topContainer.setVisibility(i2);
        this.bottomContainer.setVisibility(i3);
        this.startButton.setVisibility(i4);
        this.loadingProgressBar.setVisibility(i5);
        this.thumbImageView.setVisibility(i6);
        this.bottomProgressBar.setVisibility(i7);
        this.mRetryLayout.setVisibility(i8);
    }

    public void setBatteryLevel() {
        int i2 = LAST_GET_BATTERYLEVEL_PERCENT;
        if (i2 < 15) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_10);
            return;
        }
        if (i2 >= 15 && i2 < 40) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_30);
            return;
        }
        if (i2 >= 40 && i2 < 60) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_50);
            return;
        }
        if (i2 >= 60 && i2 < 80) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_70);
            return;
        }
        if (i2 >= 80 && i2 < 95) {
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_90);
        } else {
            if (i2 < 95 || i2 > 100) {
                return;
            }
            this.batteryLevel.setBackgroundResource(R.drawable.jz_battery_level_100);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i2) {
        super.setBufferProgress(i2);
        if (i2 != 0) {
            this.bottomProgressBar.setSecondaryProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        this.fullscreenButton.setImageResource(R.drawable.jz_shrink);
        this.backButton.setVisibility(0);
        this.tinyBackImageView.setVisibility(4);
        this.batteryTimeLayout.setVisibility(0);
        if (this.jzDataSource.urlsMap.size() == 1) {
            this.clarity.setVisibility(8);
        } else {
            this.clarity.setText(this.jzDataSource.getCurrentKey().toString());
            this.clarity.setVisibility(0);
        }
        changeStartButtonSize((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        setSystemTimeAndBattery();
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        this.fullscreenButton.setImageResource(R.drawable.jz_enlarge);
        this.backButton.setVisibility(8);
        this.tinyBackImageView.setVisibility(4);
        changeStartButtonSize((int) getResources().getDimension(R.dimen.jz_start_button_w_h_normal));
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenTiny() {
        super.setScreenTiny();
        this.tinyBackImageView.setVisibility(0);
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        this.batteryTimeLayout.setVisibility(8);
        this.clarity.setVisibility(8);
    }

    public void setSystemTimeAndBattery() {
        this.videoCurrentTime.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - LAST_GET_BATTERYLEVEL_TIME <= 30000) {
            setBatteryLevel();
        } else {
            LAST_GET_BATTERYLEVEL_TIME = System.currentTimeMillis();
            getContext().registerReceiver(this.battertReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setUp(JZDataSource jZDataSource, int i2, Class cls) {
        super.setUp(jZDataSource, i2, cls);
        this.titleTextView.setText(jZDataSource.title);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    public void showBrightnessDialog(int i2) {
        super.showBrightnessDialog(i2);
        if (this.mBrightnessDialog == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.mDialogBrightnessTextView = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.mDialogBrightnessProgressBar = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.mBrightnessDialog = createDialogWithView(viewInflate);
        }
        if (!this.mBrightnessDialog.isShowing()) {
            this.mBrightnessDialog.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.mDialogBrightnessTextView.setText(i2 + "%");
        this.mDialogBrightnessProgressBar.setProgress(i2);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showProgressDialog(float f2, String str, long j2, String str2, long j3) {
        super.showProgressDialog(f2, str, j2, str2, j3);
        if (this.mProgressDialog == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.mDialogProgressBar = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.mDialogSeekTime = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.mDialogTotalTime = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.mDialogIcon = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.mProgressDialog = createDialogWithView(viewInflate);
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        this.mDialogSeekTime.setText(str);
        this.mDialogTotalTime.setText(" / " + str2);
        this.mDialogProgressBar.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.mDialogIcon.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.mDialogIcon.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showVolumeDialog(float f2, int i2) {
        super.showVolumeDialog(f2, i2);
        if (this.mVolumeDialog == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.mDialogVolumeImageView = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.mDialogVolumeTextView = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.mDialogVolumeProgressBar = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.mVolumeDialog = createDialogWithView(viewInflate);
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        if (i2 <= 0) {
            this.mDialogVolumeImageView.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.mDialogVolumeImageView.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.mDialogVolumeTextView.setText(i2 + "%");
        this.mDialogVolumeProgressBar.setProgress(i2);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: cn.jzvd.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: cn.jzvd.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.jzvd.t
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        DISMISS_CONTROL_VIEW_TIMER = new Timer();
        this.mDismissControlViewTimerTask = new DismissControlViewTimerTask();
        DISMISS_CONTROL_VIEW_TIMER.schedule(this.mDismissControlViewTimerTask, 2500L);
    }

    public void updateStartImage() {
        int i2 = this.state;
        if (i2 == 4) {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_pause_selector);
            this.replayTextView.setVisibility(8);
        } else if (i2 == 7) {
            this.startButton.setVisibility(4);
            this.replayTextView.setVisibility(8);
        } else if (i2 != 6) {
            this.startButton.setImageResource(R.drawable.jz_click_play_selector);
            this.replayTextView.setVisibility(8);
        } else {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_replay_selector);
            this.replayTextView.setVisibility(0);
        }
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        clearFloatScreen();
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(JZDataSource jZDataSource, long j2) {
        super.changeUrl(jZDataSource, j2);
        this.titleTextView.setText(jZDataSource.title);
        this.startButton.setVisibility(4);
        this.replayTextView.setVisibility(8);
        this.mRetryLayout.setVisibility(8);
    }

    public JzvdStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastClickTime = 0L;
        this.doubleTime = 200L;
        this.delayTask = new ArrayDeque<>();
        this.battertReceiver = new BroadcastReceiver() { // from class: cn.jzvd.JzvdStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    JzvdStd.LAST_GET_BATTERYLEVEL_PERCENT = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                    JzvdStd.this.setBatteryLevel();
                    try {
                        JzvdStd.this.getContext().unregisterReceiver(JzvdStd.this.battertReceiver);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        startVideo();
        Jzvd.WIFI_TIP_DIALOG_SHOWED = true;
    }

    public /* synthetic */ void a() {
        this.bottomContainer.setVisibility(4);
        this.topContainer.setVisibility(4);
        this.startButton.setVisibility(4);
        PopupWindow popupWindow = this.clarityPopWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.screen != 2) {
            this.bottomProgressBar.setVisibility(0);
        }
    }
}
