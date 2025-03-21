package cn.jzvd;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.jzvd.Jzvd;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public abstract class Jzvd extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    /* renamed from: L */
    public static final String f2717L = "JZVD";

    /* renamed from: M */
    public static Jzvd f2718M = null;

    /* renamed from: O */
    public static final int f2720O = 0;

    /* renamed from: b0 */
    public static final int f2721b0 = 1;

    /* renamed from: c0 */
    public static final int f2722c0 = 2;

    /* renamed from: d0 */
    public static final int f2723d0 = -1;

    /* renamed from: e0 */
    public static final int f2724e0 = 0;

    /* renamed from: f0 */
    public static final int f2725f0 = 1;

    /* renamed from: g0 */
    public static final int f2726g0 = 2;

    /* renamed from: h0 */
    public static final int f2727h0 = 3;

    /* renamed from: i0 */
    public static final int f2728i0 = 4;

    /* renamed from: j0 */
    public static final int f2729j0 = 5;

    /* renamed from: k0 */
    public static final int f2730k0 = 6;

    /* renamed from: l0 */
    public static final int f2731l0 = 7;

    /* renamed from: m0 */
    public static final int f2732m0 = 0;

    /* renamed from: n0 */
    public static final int f2733n0 = 1;

    /* renamed from: o0 */
    public static final int f2734o0 = 2;

    /* renamed from: p0 */
    public static final int f2735p0 = 3;

    /* renamed from: x0 */
    public static final int f2743x0 = 80;

    /* renamed from: A */
    protected boolean f2746A;

    /* renamed from: B */
    protected float f2747B;

    /* renamed from: C */
    protected float f2748C;

    /* renamed from: D */
    protected boolean f2749D;

    /* renamed from: E */
    protected boolean f2750E;

    /* renamed from: F */
    protected boolean f2751F;

    /* renamed from: G */
    protected long f2752G;

    /* renamed from: H */
    protected int f2753H;

    /* renamed from: I */
    protected float f2754I;

    /* renamed from: J */
    protected long f2755J;

    /* renamed from: K */
    public boolean f2756K;

    /* renamed from: a */
    public int f2757a;

    /* renamed from: b */
    public int f2758b;

    /* renamed from: c */
    public C1280v f2759c;

    /* renamed from: d */
    public int f2760d;

    /* renamed from: e */
    public int f2761e;

    /* renamed from: f */
    public Class f2762f;

    /* renamed from: g */
    public AbstractTextureViewSurfaceTextureListenerC1281w f2763g;

    /* renamed from: h */
    public int f2764h;

    /* renamed from: i */
    public int f2765i;

    /* renamed from: j */
    protected long f2766j;

    /* renamed from: k */
    public int f2767k;

    /* renamed from: l */
    public long f2768l;

    /* renamed from: m */
    public ImageView f2769m;

    /* renamed from: n */
    public SeekBar f2770n;

    /* renamed from: o */
    public ImageView f2771o;

    /* renamed from: p */
    public TextView f2772p;

    /* renamed from: q */
    public TextView f2773q;

    /* renamed from: r */
    public ViewGroup f2774r;

    /* renamed from: s */
    public ViewGroup f2775s;

    /* renamed from: t */
    public ViewGroup f2776t;

    /* renamed from: u */
    public JZTextureView f2777u;

    /* renamed from: v */
    protected Timer f2778v;

    /* renamed from: w */
    protected int f2779w;

    /* renamed from: x */
    protected int f2780x;

    /* renamed from: y */
    protected AudioManager f2781y;

    /* renamed from: z */
    protected C1255c f2782z;

    /* renamed from: N */
    public static LinkedList<ViewGroup> f2719N = new LinkedList<>();

    /* renamed from: q0 */
    public static boolean f2736q0 = true;

    /* renamed from: r0 */
    public static int f2737r0 = 6;

    /* renamed from: s0 */
    public static int f2738s0 = 1;

    /* renamed from: t0 */
    public static boolean f2739t0 = false;

    /* renamed from: u0 */
    public static boolean f2740u0 = false;

    /* renamed from: v0 */
    public static int f2741v0 = 0;

    /* renamed from: w0 */
    public static long f2742w0 = 0;

    /* renamed from: y0 */
    public static int f2744y0 = 0;

    /* renamed from: z0 */
    public static AudioManager.OnAudioFocusChangeListener f2745z0 = new C1253a();

    /* renamed from: cn.jzvd.Jzvd$a */
    static class C1253a implements AudioManager.OnAudioFocusChangeListener {
        C1253a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (i2 != -2) {
                if (i2 != -1) {
                    return;
                }
                Jzvd.m2440F();
                String str = "AUDIOFOCUS_LOSS [" + hashCode() + "]";
                return;
            }
            try {
                Jzvd jzvd = Jzvd.f2718M;
                if (jzvd != null && jzvd.f2757a == 4) {
                    jzvd.f2769m.performClick();
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
            }
            String str2 = "AUDIOFOCUS_LOSS_TRANSIENT [" + hashCode() + "]";
        }
    }

    /* renamed from: cn.jzvd.Jzvd$b */
    public static class C1254b implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            if ((f2 < -12.0f || f2 > 12.0f) && System.currentTimeMillis() - Jzvd.f2742w0 > 2000) {
                Jzvd jzvd = Jzvd.f2718M;
                if (jzvd != null) {
                    jzvd.m2447a(f2);
                }
                Jzvd.f2742w0 = System.currentTimeMillis();
            }
        }
    }

    /* renamed from: cn.jzvd.Jzvd$c */
    public class C1255c extends TimerTask {
        public C1255c() {
        }

        /* renamed from: a */
        public /* synthetic */ void m2491a() {
            long currentPositionWhenPlaying = Jzvd.this.getCurrentPositionWhenPlaying();
            long duration = Jzvd.this.getDuration();
            Jzvd.this.mo2454a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2 = Jzvd.this.f2757a;
            if (i2 == 4 || i2 == 5) {
                Jzvd.this.post(new Runnable() { // from class: cn.jzvd.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        Jzvd.C1255c.this.m2491a();
                    }
                });
            }
        }
    }

    public Jzvd(Context context) {
        super(context);
        this.f2757a = -1;
        this.f2758b = -1;
        this.f2760d = 0;
        this.f2761e = 0;
        this.f2764h = -1;
        this.f2765i = 0;
        this.f2766j = 0L;
        this.f2767k = -1;
        this.f2768l = 0L;
        this.f2756K = false;
        mo2455a(context);
    }

    /* renamed from: C */
    public static boolean m2437C() {
        Jzvd jzvd;
        Jzvd jzvd2;
        if (f2719N.size() != 0 && (jzvd2 = f2718M) != null) {
            jzvd2.m2473i();
            return true;
        }
        if (f2719N.size() != 0 || (jzvd = f2718M) == null || jzvd.f2758b == 0) {
            return false;
        }
        jzvd.m2468d();
        return true;
    }

    /* renamed from: D */
    public static void m2438D() {
        Jzvd jzvd = f2718M;
        if (jzvd != null) {
            int i2 = jzvd.f2757a;
            if (i2 == 6 || i2 == 0 || i2 == 1 || i2 == 7) {
                m2440F();
                return;
            }
            f2744y0 = i2;
            jzvd.mo2480p();
            f2718M.f2763g.mo2530d();
        }
    }

    /* renamed from: E */
    public static void m2439E() {
        Jzvd jzvd = f2718M;
        if (jzvd == null || jzvd.f2757a != 5) {
            return;
        }
        if (f2744y0 == 5) {
            jzvd.mo2480p();
            f2718M.f2763g.mo2530d();
        } else {
            jzvd.mo2481q();
            f2718M.f2763g.mo2533g();
        }
        f2744y0 = 0;
    }

    /* renamed from: F */
    public static void m2440F() {
        Jzvd jzvd = f2718M;
        if (jzvd != null) {
            jzvd.mo2483s();
            f2718M = null;
        }
    }

    public static void setCurrentJzvd(Jzvd jzvd) {
        Jzvd jzvd2 = f2718M;
        if (jzvd2 != null) {
            jzvd2.mo2483s();
        }
        f2718M = jzvd;
    }

    public static void setTextureViewRotation(int i2) {
        JZTextureView jZTextureView;
        Jzvd jzvd = f2718M;
        if (jzvd == null || (jZTextureView = jzvd.f2777u) == null) {
            return;
        }
        jZTextureView.setRotation(i2);
    }

    public static void setVideoImageDisplayType(int i2) {
        JZTextureView jZTextureView;
        f2741v0 = i2;
        Jzvd jzvd = f2718M;
        if (jzvd == null || (jZTextureView = jzvd.f2777u) == null) {
            return;
        }
        jZTextureView.requestLayout();
    }

    /* renamed from: A */
    public void m2444A() {
        String str = "startVideo [" + hashCode() + "] ";
        setCurrentJzvd(this);
        try {
            this.f2763g = (AbstractTextureViewSurfaceTextureListenerC1281w) this.f2762f.getConstructor(Jzvd.class).newInstance(this);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        m2446a();
        this.f2781y = (AudioManager) getApplicationContext().getSystemService("audio");
        this.f2781y.requestAudioFocus(f2745z0, 3, 2);
        C1283y.m2558f(getContext()).getWindow().addFlags(128);
        mo2482r();
    }

    /* renamed from: B */
    public void m2445B() {
        if (this.f2757a == 3) {
            this.f2763g.mo2533g();
        } else {
            this.f2756K = false;
            m2444A();
        }
    }

    /* renamed from: a */
    public void mo2448a(float f2, int i2) {
    }

    /* renamed from: a */
    public void mo2449a(float f2, String str, long j2, String str2, long j3) {
    }

    /* renamed from: a */
    public void mo2450a(int i2) {
    }

    /* renamed from: a */
    public void mo2455a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f2769m = (ImageView) findViewById(C1258R.id.start);
        this.f2771o = (ImageView) findViewById(C1258R.id.fullscreen);
        this.f2770n = (SeekBar) findViewById(C1258R.id.bottom_seek_progress);
        this.f2772p = (TextView) findViewById(C1258R.id.current);
        this.f2773q = (TextView) findViewById(C1258R.id.total);
        this.f2776t = (ViewGroup) findViewById(C1258R.id.layout_bottom);
        this.f2774r = (ViewGroup) findViewById(C1258R.id.surface_container);
        this.f2775s = (ViewGroup) findViewById(C1258R.id.layout_top);
        this.f2769m.setOnClickListener(this);
        this.f2771o.setOnClickListener(this);
        this.f2770n.setOnSeekBarChangeListener(this);
        this.f2776t.setOnClickListener(this);
        this.f2774r.setOnClickListener(this);
        this.f2774r.setOnTouchListener(this);
        this.f2779w = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f2780x = getContext().getResources().getDisplayMetrics().heightPixels;
        this.f2757a = -1;
    }

    /* renamed from: b */
    public void m2465b(int i2, int i3) {
        String str = "onInfo what - " + i2 + " extra - " + i3;
        if (i2 == 3) {
            int i4 = this.f2757a;
            if (i4 == 3 || i4 == 2) {
                mo2481q();
            }
        }
    }

    /* renamed from: c */
    public void m2467c(int i2, int i3) {
        String str = "onVideoSizeChanged  [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.f2777u;
        if (jZTextureView != null) {
            int i4 = this.f2765i;
            if (i4 != 0) {
                jZTextureView.setRotation(i4);
            }
            this.f2777u.m2436a(i2, i3);
        }
    }

    /* renamed from: d */
    public void m2468d() {
        C1283y.m2559g(getContext());
        C1283y.m2550a(getContext(), f2738s0);
        C1283y.m2560h(getContext());
        ((ViewGroup) C1283y.m2558f(getContext()).getWindow().getDecorView()).removeView(this);
        AbstractTextureViewSurfaceTextureListenerC1281w abstractTextureViewSurfaceTextureListenerC1281w = this.f2763g;
        if (abstractTextureViewSurfaceTextureListenerC1281w != null) {
            abstractTextureViewSurfaceTextureListenerC1281w.mo2532f();
        }
        f2718M = null;
    }

    /* renamed from: e */
    public void mo2469e() {
    }

    /* renamed from: f */
    public void mo2470f() {
    }

    /* renamed from: g */
    public void mo2471g() {
    }

    public Context getApplicationContext() {
        Context applicationContext;
        Context context = getContext();
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.f2757a;
        if (i2 != 4 && i2 != 5) {
            return 0L;
        }
        try {
            return this.f2763g.mo2523a();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public long getDuration() {
        try {
            return this.f2763g.mo2528b();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public abstract int getLayoutId();

    /* renamed from: h */
    public void m2472h() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeView(this);
        m2456a(viewGroup);
        f2719N.add(viewGroup);
        ((ViewGroup) C1283y.m2558f(getContext()).getWindow().getDecorView()).addView(this, new FrameLayout.LayoutParams(-1, -1));
        mo2485u();
        C1283y.m2555c(getContext());
        C1283y.m2550a(getContext(), f2737r0);
        C1283y.m2556d(getContext());
    }

    /* renamed from: i */
    public void m2473i() {
        this.f2766j = System.currentTimeMillis();
        ((ViewGroup) C1283y.m2558f(getContext()).getWindow().getDecorView()).removeView(this);
        f2719N.getLast().removeAllViews();
        f2719N.getLast().addView(this, new FrameLayout.LayoutParams(-1, -1));
        f2719N.pop();
        mo2486v();
        C1283y.m2559g(getContext());
        C1283y.m2550a(getContext(), f2738s0);
        C1283y.m2560h(getContext());
    }

    /* renamed from: j */
    public void mo2474j() {
        Runtime.getRuntime().gc();
        String str = "onAutoCompletion  [" + hashCode() + "] ";
        m2466c();
        mo2469e();
        mo2470f();
        mo2471g();
        mo2477m();
        this.f2763g.mo2532f();
        C1283y.m2558f(getContext()).getWindow().clearFlags(128);
        C1283y.m2552a(getContext(), this.f2759c.m2522c(), 0L);
    }

    /* renamed from: k */
    public void m2475k() {
        String str = "onPrepared  [" + hashCode() + "] ";
        this.f2757a = 3;
        if (!this.f2756K) {
            this.f2763g.mo2533g();
            this.f2756K = false;
        }
        if (this.f2759c.m2522c().toString().toLowerCase().contains("mp3") || this.f2759c.m2522c().toString().toLowerCase().contains("wma") || this.f2759c.m2522c().toString().toLowerCase().contains("aac") || this.f2759c.m2522c().toString().toLowerCase().contains("m4a") || this.f2759c.m2522c().toString().toLowerCase().contains("wav")) {
            mo2481q();
        }
    }

    /* renamed from: l */
    public void m2476l() {
    }

    /* renamed from: m */
    public void mo2477m() {
        String str = "onStateAutoComplete  [" + hashCode() + "] ";
        this.f2757a = 6;
        m2466c();
        this.f2770n.setProgress(100);
        this.f2772p.setText(this.f2773q.getText());
    }

    /* renamed from: n */
    public void mo2478n() {
        String str = "onStateError  [" + hashCode() + "] ";
        this.f2757a = 7;
        m2466c();
    }

    /* renamed from: o */
    public void mo2479o() {
        String str = "onStateNormal  [" + hashCode() + "] ";
        this.f2757a = 0;
        m2466c();
        AbstractTextureViewSurfaceTextureListenerC1281w abstractTextureViewSurfaceTextureListenerC1281w = this.f2763g;
        if (abstractTextureViewSurfaceTextureListenerC1281w != null) {
            abstractTextureViewSurfaceTextureListenerC1281w.mo2532f();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != C1258R.id.start) {
            if (id == C1258R.id.fullscreen) {
                String str = "onClick fullscreen [" + hashCode() + "] ";
                if (this.f2757a == 6) {
                    return;
                }
                if (this.f2758b == 1) {
                    m2437C();
                    return;
                }
                String str2 = "toFullscreenActivity [" + hashCode() + "] ";
                m2472h();
                return;
            }
            return;
        }
        String str3 = "onClick start [" + hashCode() + "] ";
        C1280v c1280v = this.f2759c;
        if (c1280v == null || c1280v.f2861b.isEmpty() || this.f2759c.m2522c() == null) {
            Toast.makeText(getContext(), getResources().getString(C1258R.string.no_url), 0).show();
            return;
        }
        int i2 = this.f2757a;
        if (i2 == 0) {
            if (this.f2759c.m2522c().toString().startsWith("file") || this.f2759c.m2522c().toString().startsWith("/") || C1283y.m2557e(getContext()) || f2740u0) {
                m2444A();
                return;
            } else {
                mo2488x();
                return;
            }
        }
        if (i2 == 4) {
            String str4 = "pauseVideo [" + hashCode() + "] ";
            this.f2763g.mo2530d();
            mo2480p();
            return;
        }
        if (i2 == 5) {
            this.f2763g.mo2533g();
            mo2481q();
        } else if (i2 == 6) {
            m2444A();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = this.f2758b;
        if (i4 == 1 || i4 == 2) {
            super.onMeasure(i2, i3);
            return;
        }
        if (this.f2760d == 0 || this.f2761e == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int i5 = (int) ((size * this.f2761e) / this.f2760d);
        setMeasuredDimension(size, i5);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (z) {
            this.f2772p.setText(C1283y.m2549a((i2 * getDuration()) / 100));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStartTrackingTouch [" + hashCode() + "] ";
        m2466c();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        String str = "bottomProgress onStopTrackingTouch [" + hashCode() + "] ";
        m2490z();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i2 = this.f2757a;
        if (i2 == 4 || i2 == 5) {
            long progress = (seekBar.getProgress() * getDuration()) / 100;
            this.f2767k = seekBar.getProgress();
            this.f2763g.mo2526a(progress);
            String str2 = "seekTo " + progress + " [" + hashCode() + "] ";
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (view.getId() == C1258R.id.surface_container) {
            int action = motionEvent.getAction();
            if (action == 0) {
                String str = "onTouch surfaceContainer actionDown [" + hashCode() + "] ";
                this.f2746A = true;
                this.f2747B = x;
                this.f2748C = y;
                this.f2749D = false;
                this.f2750E = false;
                this.f2751F = false;
            } else if (action == 1) {
                String str2 = "onTouch surfaceContainer actionUp [" + hashCode() + "] ";
                this.f2746A = false;
                mo2470f();
                mo2471g();
                mo2469e();
                if (this.f2750E) {
                    this.f2763g.mo2526a(this.f2755J);
                    long duration = getDuration();
                    long j2 = this.f2755J * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.f2770n.setProgress((int) (j2 / duration));
                }
                m2490z();
            } else if (action == 2) {
                String str3 = "onTouch surfaceContainer actionMove [" + hashCode() + "] ";
                float f2 = x - this.f2747B;
                float f3 = y - this.f2748C;
                float abs = Math.abs(f2);
                float abs2 = Math.abs(f3);
                if (this.f2758b == 1 && !this.f2750E && !this.f2749D && !this.f2751F && (abs > 80.0f || abs2 > 80.0f)) {
                    m2466c();
                    if (abs >= 80.0f) {
                        if (this.f2757a != 7) {
                            this.f2750E = true;
                            this.f2752G = getCurrentPositionWhenPlaying();
                        }
                    } else if (this.f2747B < this.f2779w * 0.5f) {
                        this.f2751F = true;
                        float f4 = C1283y.m2554b(getContext()).getAttributes().screenBrightness;
                        if (f4 < 0.0f) {
                            try {
                                this.f2754I = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness");
                                String str4 = "current system brightness: " + this.f2754I;
                            } catch (Settings.SettingNotFoundException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            this.f2754I = f4 * 255.0f;
                            String str5 = "current activity brightness: " + this.f2754I;
                        }
                    } else {
                        this.f2749D = true;
                        this.f2753H = this.f2781y.getStreamVolume(3);
                    }
                }
                if (this.f2750E) {
                    long duration2 = getDuration();
                    this.f2755J = (int) (this.f2752G + ((duration2 * f2) / this.f2779w));
                    if (this.f2755J > duration2) {
                        this.f2755J = duration2;
                    }
                    mo2449a(f2, C1283y.m2549a(this.f2755J), this.f2755J, C1283y.m2549a(duration2), duration2);
                }
                if (this.f2749D) {
                    f3 = -f3;
                    this.f2781y.setStreamVolume(3, this.f2753H + ((int) (((this.f2781y.getStreamMaxVolume(3) * f3) * 3.0f) / this.f2780x)), 0);
                    mo2448a(-f3, (int) (((this.f2753H * 100) / r0) + (((f3 * 3.0f) * 100.0f) / this.f2780x)));
                }
                if (this.f2751F) {
                    float f5 = -f3;
                    WindowManager.LayoutParams attributes = C1283y.m2554b(getContext()).getAttributes();
                    float f6 = this.f2754I;
                    float f7 = (int) (((f5 * 255.0f) * 3.0f) / this.f2780x);
                    if ((f6 + f7) / 255.0f >= 1.0f) {
                        attributes.screenBrightness = 1.0f;
                    } else if ((f6 + f7) / 255.0f <= 0.0f) {
                        attributes.screenBrightness = 0.01f;
                    } else {
                        attributes.screenBrightness = (f6 + f7) / 255.0f;
                    }
                    C1283y.m2554b(getContext()).setAttributes(attributes);
                    mo2450a((int) (((this.f2754I * 100.0f) / 255.0f) + (((f5 * 3.0f) * 100.0f) / this.f2780x)));
                }
            }
        }
        return false;
    }

    /* renamed from: p */
    public void mo2480p() {
        String str = "onStatePause  [" + hashCode() + "] ";
        this.f2757a = 5;
        m2490z();
    }

    /* renamed from: q */
    public void mo2481q() {
        String str = "onStatePlaying  [" + hashCode() + "] ";
        if (this.f2757a == 3) {
            long j2 = this.f2768l;
            if (j2 != 0) {
                this.f2763g.mo2526a(j2);
                this.f2768l = 0L;
            } else {
                long m2553b = C1283y.m2553b(getContext(), this.f2759c.m2522c());
                if (m2553b != 0) {
                    this.f2763g.mo2526a(m2553b);
                }
            }
        }
        this.f2757a = 4;
        m2490z();
    }

    /* renamed from: r */
    public void mo2482r() {
        String str = "onStatePreparing  [" + hashCode() + "] ";
        this.f2757a = 1;
        mo2484t();
    }

    /* renamed from: s */
    public void mo2483s() {
        String str = "reset  [" + hashCode() + "] ";
        int i2 = this.f2757a;
        if (i2 == 4 || i2 == 5) {
            C1283y.m2552a(getContext(), this.f2759c.m2522c(), getCurrentPositionWhenPlaying());
        }
        m2466c();
        mo2469e();
        mo2470f();
        mo2471g();
        mo2479o();
        this.f2774r.removeAllViews();
        ((AudioManager) getApplicationContext().getSystemService("audio")).abandonAudioFocus(f2745z0);
        C1283y.m2558f(getContext()).getWindow().clearFlags(128);
        AbstractTextureViewSurfaceTextureListenerC1281w abstractTextureViewSurfaceTextureListenerC1281w = this.f2763g;
        if (abstractTextureViewSurfaceTextureListenerC1281w != null) {
            abstractTextureViewSurfaceTextureListenerC1281w.mo2532f();
        }
    }

    public void setBufferProgress(int i2) {
        if (i2 != 0) {
            this.f2770n.setSecondaryProgress(i2);
        }
    }

    public void setMediaInterface(Class cls) {
        mo2483s();
        this.f2762f = cls;
    }

    public void setScreen(int i2) {
        if (i2 == 0) {
            mo2486v();
        } else if (i2 == 1) {
            mo2485u();
        } else {
            if (i2 != 2) {
                return;
            }
            mo2487w();
        }
    }

    public void setState(int i2) {
        m2452a(i2, 0, 0);
    }

    /* renamed from: t */
    public void mo2484t() {
        this.f2770n.setProgress(0);
        this.f2770n.setSecondaryProgress(0);
        this.f2772p.setText(C1283y.m2549a(0L));
        this.f2773q.setText(C1283y.m2549a(0L));
    }

    /* renamed from: u */
    public void mo2485u() {
        this.f2758b = 1;
    }

    /* renamed from: v */
    public void mo2486v() {
        this.f2758b = 0;
    }

    /* renamed from: w */
    public void mo2487w() {
        this.f2758b = 2;
    }

    /* renamed from: x */
    public void mo2488x() {
    }

    /* renamed from: y */
    public void m2489y() {
        this.f2756K = true;
        m2444A();
    }

    /* renamed from: z */
    public void m2490z() {
        String str = "startProgressTimer:  [" + hashCode() + "] ";
        m2466c();
        this.f2778v = new Timer();
        this.f2782z = new C1255c();
        this.f2778v.schedule(this.f2782z, 0L, 300L);
    }

    /* renamed from: b */
    public void m2464b() {
        if (System.currentTimeMillis() - f2742w0 > 2000 && this.f2757a == 4 && this.f2758b == 1) {
            f2742w0 = System.currentTimeMillis();
            m2437C();
        }
    }

    /* renamed from: c */
    public void m2466c() {
        Timer timer = this.f2778v;
        if (timer != null) {
            timer.cancel();
        }
        C1255c c1255c = this.f2782z;
        if (c1255c != null) {
            c1255c.cancel();
        }
    }

    public Jzvd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2757a = -1;
        this.f2758b = -1;
        this.f2760d = 0;
        this.f2761e = 0;
        this.f2764h = -1;
        this.f2765i = 0;
        this.f2766j = 0L;
        this.f2767k = -1;
        this.f2768l = 0L;
        this.f2756K = false;
        mo2455a(context);
    }

    /* renamed from: a */
    public void m2460a(String str, String str2) {
        m2457a(new C1280v(str, str2), 0);
    }

    /* renamed from: a */
    public void m2461a(String str, String str2, int i2) {
        m2457a(new C1280v(str, str2), i2);
    }

    /* renamed from: a */
    public void m2457a(C1280v c1280v, int i2) {
        mo2458a(c1280v, i2, C1282x.class);
    }

    /* renamed from: a */
    public void m2462a(String str, String str2, int i2, Class cls) {
        mo2458a(new C1280v(str, str2), i2, cls);
    }

    /* renamed from: a */
    public void mo2458a(C1280v c1280v, int i2, Class cls) {
        if (System.currentTimeMillis() - this.f2766j < 200) {
            return;
        }
        this.f2759c = c1280v;
        this.f2758b = i2;
        mo2479o();
        this.f2762f = cls;
    }

    /* renamed from: a */
    public void m2451a(int i2, int i3) {
        String str = "onError " + i2 + " - " + i3 + " [" + hashCode() + "] ";
        if (i2 == 38 || i3 == -38 || i2 == -38 || i3 == 38 || i3 == -19) {
            return;
        }
        mo2478n();
        this.f2763g.mo2532f();
    }

    /* renamed from: a */
    public void m2452a(int i2, int i3, int i4) {
        if (i2 == 0) {
            mo2479o();
            return;
        }
        if (i2 == 1) {
            mo2482r();
            return;
        }
        if (i2 == 2) {
            mo2453a(i3, i4);
            return;
        }
        if (i2 == 4) {
            mo2481q();
            return;
        }
        if (i2 == 5) {
            mo2480p();
        } else if (i2 == 6) {
            mo2477m();
        } else {
            if (i2 != 7) {
                return;
            }
            mo2478n();
        }
    }

    /* renamed from: a */
    public void m2463a(String str, String str2, long j2) {
        mo2459a(new C1280v(str, str2), j2);
    }

    /* renamed from: a */
    public void mo2453a(int i2, long j2) {
        this.f2757a = 2;
        this.f2768l = j2;
        this.f2759c.f2860a = i2;
        this.f2763g.mo2527a((Surface) null);
        this.f2763g.mo2532f();
        this.f2763g.mo2531e();
    }

    /* renamed from: a */
    public void mo2459a(C1280v c1280v, long j2) {
        this.f2757a = 2;
        this.f2768l = j2;
        this.f2759c = c1280v;
        this.f2763g.mo2527a((Surface) null);
        this.f2763g.mo2532f();
        this.f2763g.mo2531e();
    }

    /* renamed from: a */
    public void m2446a() {
        String str = "addTextureView [" + hashCode() + "] ";
        JZTextureView jZTextureView = this.f2777u;
        if (jZTextureView != null) {
            this.f2774r.removeView(jZTextureView);
        }
        this.f2777u = new JZTextureView(getContext().getApplicationContext());
        this.f2777u.setSurfaceTextureListener(this.f2763g);
        this.f2774r.addView(this.f2777u, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* renamed from: a */
    public void mo2454a(int i2, long j2, long j3) {
        if (!this.f2746A) {
            int i3 = this.f2767k;
            if (i3 != -1) {
                if (i3 > i2) {
                    return;
                } else {
                    this.f2767k = -1;
                }
            } else if (i2 != 0) {
                this.f2770n.setProgress(i2);
            }
        }
        if (j2 != 0) {
            this.f2772p.setText(C1283y.m2549a(j2));
        }
        this.f2773q.setText(C1283y.m2549a(j3));
    }

    /* renamed from: a */
    public void m2456a(ViewGroup viewGroup) {
        try {
            Jzvd jzvd = (Jzvd) getClass().getConstructor(Context.class).newInstance(getContext());
            jzvd.setId(getId());
            viewGroup.addView(jzvd);
            jzvd.mo2458a(this.f2759c.m2517a(), 0, this.f2762f);
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

    /* renamed from: a */
    public void m2447a(float f2) {
        int i2;
        if (f2718M != null) {
            int i3 = this.f2757a;
            if ((i3 != 4 && i3 != 5) || (i2 = this.f2758b) == 1 || i2 == 2) {
                return;
            }
            if (f2 > 0.0f) {
                C1283y.m2550a(getContext(), 0);
            } else {
                C1283y.m2550a(getContext(), 8);
            }
            m2472h();
        }
    }

    /* renamed from: a */
    public static void m2442a(Context context, Class cls, String str, String str2) {
        m2441a(context, cls, new C1280v(str, str2));
    }

    /* renamed from: a */
    public static void m2441a(Context context, Class cls, C1280v c1280v) {
        C1283y.m2555c(context);
        C1283y.m2550a(context, f2737r0);
        C1283y.m2556d(context);
        ViewGroup viewGroup = (ViewGroup) C1283y.m2558f(context).getWindow().getDecorView();
        try {
            Jzvd jzvd = (Jzvd) cls.getConstructor(Context.class).newInstance(context);
            viewGroup.addView(jzvd, new FrameLayout.LayoutParams(-1, -1));
            jzvd.m2457a(c1280v, 1);
            jzvd.m2444A();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m2443a(Context context, String str) {
        C1283y.m2551a(context, str);
    }
}
