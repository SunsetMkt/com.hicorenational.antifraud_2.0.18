package ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import cn.jzvd.JZDataSource;
import cn.jzvd.JZUtils;
import cn.jzvd.Jzvd;
import com.hicorenational.antifraud.R;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class RecordItemJzvd extends Jzvd {
    protected static Timer B;
    private ArrayDeque<Runnable> A;
    public ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f14586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f14587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f14588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f14589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f14590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f14591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f14592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PopupWindow f14593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f14594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f14595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected a f14596l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Dialog f14597m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected ProgressBar f14598n;
    protected TextView o;
    protected TextView p;
    protected ImageView q;
    protected Dialog r;
    protected ProgressBar s;
    protected TextView t;
    protected ImageView u;
    protected Dialog v;
    protected ProgressBar w;
    protected TextView x;
    private long y;
    private long z;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RecordItemJzvd.this.dissmissControlView();
        }
    }

    public RecordItemJzvd(Context context) {
        this(context, null);
    }

    public /* synthetic */ void a(LinearLayout linearLayout, View view) {
        changeUrl(((Integer) view.getTag()).intValue(), getCurrentPositionWhenPlaying());
        this.f14592h.setText(this.jzDataSource.getCurrentKey().toString());
        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
            if (i2 == this.jzDataSource.currentUrlIndex) {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
            } else {
                ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
            }
        }
        PopupWindow popupWindow = this.f14593i;
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
        Timer timer = B;
        if (timer != null) {
            timer.cancel();
        }
        a aVar = this.f14596l;
        if (aVar != null) {
            aVar.cancel();
        }
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
            setAllControlsVisiblity(0, 0, 0, 4, 4, 0, 4);
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
        this.f14591g.setVisibility(8);
        this.f14595k.setVisibility(8);
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
        Dialog dialog = this.v;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissProgressDialog() {
        super.dismissProgressDialog();
        Dialog dialog = this.f14597m;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void dismissVolumeDialog() {
        super.dismissVolumeDialog();
        Dialog dialog = this.r;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void dissmissControlView() {
        int i2 = this.state;
        if (i2 == 0 || i2 == 7 || i2 == 6) {
            return;
        }
        post(new Runnable() { // from class: ui.view.j
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        });
    }

    @Override // cn.jzvd.Jzvd
    public int getLayoutId() {
        return R.layout.record_layout_item;
    }

    @Override // cn.jzvd.Jzvd
    public void init(Context context) {
        super.init(context);
        this.f14586b = (ProgressBar) findViewById(R.id.bottom_progress);
        this.f14588d = (TextView) findViewById(R.id.title);
        this.a = (ImageView) findViewById(R.id.back);
        this.f14589e = (ImageView) findViewById(R.id.thumb);
        this.f14587c = (ProgressBar) findViewById(R.id.loading);
        this.f14590f = (ImageView) findViewById(R.id.back_tiny);
        this.f14591g = (TextView) findViewById(R.id.replay_text);
        this.f14592h = (TextView) findViewById(R.id.clarity);
        this.f14594j = (TextView) findViewById(R.id.retry_btn);
        this.f14595k = (LinearLayout) findViewById(R.id.retry_layout);
        this.f14589e.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.f14590f.setOnClickListener(this);
        this.f14592h.setOnClickListener(this);
        this.f14594j.setOnClickListener(this);
        this.f14591g.setOnClickListener(this);
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
                    startVideo();
                    return;
                }
                return;
            }
            if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") || this.jzDataSource.getCurrentUrl().toString().startsWith("/") || JZUtils.isWifiConnected(getContext()) || Jzvd.WIFI_TIP_DIALOG_SHOWED) {
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
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ui.view.k
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
        this.f14593i = new PopupWindow((View) linearLayout, -2, -2, true);
        this.f14593i.setContentView(linearLayout);
        this.f14593i.showAsDropDown(this.f14592h);
        linearLayout.measure(0, 0);
        this.f14593i.update(this.f14592h, -(this.f14592h.getMeasuredWidth() / 3), -(this.f14592h.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
    }

    public void onClickUiToggle() {
        int i2 = this.state;
        if (i2 == 1) {
            changeUiToPreparing();
            this.bottomContainer.getVisibility();
        } else if (i2 == 4) {
            changeUiToPlayingShow();
        } else if (i2 == 5) {
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
            this.f14586b.setProgress(i2);
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
        this.f14586b.setProgress(100);
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
                    this.f14586b.setProgress((int) (j2 / duration));
                }
                Runnable runnable = new Runnable() { // from class: ui.view.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                };
                view.postDelayed(runnable, this.z + 20);
                this.A.add(runnable);
                while (this.A.size() > 2) {
                    this.A.pollFirst();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.y < this.z) {
                    Iterator<Runnable> it = this.A.iterator();
                    while (it.hasNext()) {
                        view.removeCallbacks(it.next());
                    }
                    int i2 = this.state;
                    if (i2 == 4 || i2 == 5) {
                        String str = "doublClick [" + hashCode() + "] ";
                        this.startButton.performClick();
                    }
                }
                this.y = jCurrentTimeMillis;
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
        PopupWindow popupWindow = this.f14593i;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // cn.jzvd.Jzvd
    public void resetProgressAndTime() {
        super.resetProgressAndTime();
        this.f14586b.setProgress(0);
        this.f14586b.setSecondaryProgress(0);
    }

    public void setAllControlsVisiblity(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.topContainer.setVisibility(i2);
        this.bottomContainer.setVisibility(i3);
        this.startButton.setVisibility(i4);
        this.f14587c.setVisibility(i5);
        this.f14589e.setVisibility(i6);
        this.f14586b.setVisibility(i7);
        this.f14595k.setVisibility(i8);
    }

    @Override // cn.jzvd.Jzvd
    public void setBufferProgress(int i2) {
        super.setBufferProgress(i2);
        if (i2 != 0) {
            this.f14586b.setSecondaryProgress(i2);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenFullscreen() {
        super.setScreenFullscreen();
        this.fullscreenButton.setImageResource(R.drawable.jz_shrink);
        this.a.setVisibility(0);
        this.f14590f.setVisibility(4);
        if (this.jzDataSource.urlsMap.size() == 1) {
            this.f14592h.setVisibility(8);
        } else {
            this.f14592h.setText(this.jzDataSource.getCurrentKey().toString());
            this.f14592h.setVisibility(0);
        }
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenNormal() {
        super.setScreenNormal();
        this.fullscreenButton.setImageResource(R.drawable.jz_enlarge);
        this.a.setVisibility(8);
        this.f14590f.setVisibility(4);
        this.f14592h.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void setScreenTiny() {
        super.setScreenTiny();
        this.f14590f.setVisibility(0);
        setAllControlsVisiblity(4, 4, 4, 4, 4, 4, 4);
        this.f14592h.setVisibility(8);
    }

    @Override // cn.jzvd.Jzvd
    public void setUp(JZDataSource jZDataSource, int i2, Class cls) {
        super.setUp(jZDataSource, i2, cls);
        this.f14588d.setText(jZDataSource.title);
        setScreen(i2);
    }

    @Override // cn.jzvd.Jzvd
    public void showBrightnessDialog(int i2) {
        super.showBrightnessDialog(i2);
        if (this.v == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_brightness, (ViewGroup) null);
            this.x = (TextView) viewInflate.findViewById(R.id.tv_brightness);
            this.w = (ProgressBar) viewInflate.findViewById(R.id.brightness_progressbar);
            this.v = createDialogWithView(viewInflate);
        }
        if (!this.v.isShowing()) {
            this.v.show();
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.x.setText(i2 + "%");
        this.w.setProgress(i2);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showProgressDialog(float f2, String str, long j2, String str2, long j3) {
        super.showProgressDialog(f2, str, j2, str2, j3);
        if (this.f14597m == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_progress, (ViewGroup) null);
            this.f14598n = (ProgressBar) viewInflate.findViewById(R.id.duration_progressbar);
            this.o = (TextView) viewInflate.findViewById(R.id.tv_current);
            this.p = (TextView) viewInflate.findViewById(R.id.tv_duration);
            this.q = (ImageView) viewInflate.findViewById(R.id.duration_image_tip);
            this.f14597m = createDialogWithView(viewInflate);
        }
        if (!this.f14597m.isShowing()) {
            this.f14597m.show();
        }
        this.o.setText(str);
        this.p.setText(" / " + str2);
        this.f14598n.setProgress(j3 <= 0 ? 0 : (int) ((j2 * 100) / j3));
        if (f2 > 0.0f) {
            this.q.setBackgroundResource(R.drawable.jz_forward_icon);
        } else {
            this.q.setBackgroundResource(R.drawable.jz_backward_icon);
        }
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showVolumeDialog(float f2, int i2) {
        super.showVolumeDialog(f2, i2);
        if (this.r == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.jz_dialog_volume, (ViewGroup) null);
            this.u = (ImageView) viewInflate.findViewById(R.id.volume_image_tip);
            this.t = (TextView) viewInflate.findViewById(R.id.tv_volume);
            this.s = (ProgressBar) viewInflate.findViewById(R.id.volume_progressbar);
            this.r = createDialogWithView(viewInflate);
        }
        if (!this.r.isShowing()) {
            this.r.show();
        }
        if (i2 <= 0) {
            this.u.setBackgroundResource(R.drawable.jz_close_volume);
        } else {
            this.u.setBackgroundResource(R.drawable.jz_add_volume);
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 0;
        }
        this.t.setText(i2 + "%");
        this.s.setProgress(i2);
        onCLickUiToggleToClear();
    }

    @Override // cn.jzvd.Jzvd
    public void showWifiDialog() {
        super.showWifiDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: ui.view.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.a(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: ui.view.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.a.b(dialogInterface, i2);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ui.view.n
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void startDismissControlViewTimer() {
        cancelDismissControlViewTimer();
        B = new Timer();
        this.f14596l = new a();
        B.schedule(this.f14596l, 2500L);
    }

    public void updateStartImage() {
        int i2 = this.state;
        if (i2 == 4) {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_pause_selector);
            this.f14591g.setVisibility(8);
        } else if (i2 == 7) {
            this.startButton.setVisibility(4);
            this.f14591g.setVisibility(8);
        } else if (i2 != 6) {
            this.startButton.setImageResource(R.drawable.jz_click_play_selector);
            this.f14591g.setVisibility(8);
        } else {
            this.startButton.setVisibility(0);
            this.startButton.setImageResource(R.drawable.jz_click_replay_selector);
            this.f14591g.setVisibility(0);
        }
    }

    public RecordItemJzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 0L;
        this.z = 200L;
        this.A = new ArrayDeque<>();
    }

    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        clearFloatScreen();
    }

    @Override // cn.jzvd.Jzvd
    public void changeUrl(JZDataSource jZDataSource, long j2) {
        super.changeUrl(jZDataSource, j2);
        this.f14588d.setText(jZDataSource.title);
        this.startButton.setVisibility(4);
        this.f14591g.setVisibility(8);
        this.f14595k.setVisibility(8);
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
        PopupWindow popupWindow = this.f14593i;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        if (this.screen != 2) {
            this.f14586b.setVisibility(0);
        }
    }
}
