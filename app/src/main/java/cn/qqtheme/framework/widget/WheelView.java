package cn.qqtheme.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.core.view.GravityCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p023b.p024a.p025a.p026d.InterfaceC0914l;
import p023b.p024a.p025a.p029g.C0929b;
import p023b.p024a.p025a.p029g.C0931d;

/* loaded from: classes.dex */
public class WheelView extends View {

    /* renamed from: e0 */
    public static final float f2874e0 = 2.0f;

    /* renamed from: f0 */
    public static final int f2875f0 = -1;

    /* renamed from: g0 */
    public static final int f2876g0 = 16;

    /* renamed from: h0 */
    public static final int f2877h0 = -16611122;

    /* renamed from: i0 */
    public static final int f2878i0 = -4473925;

    /* renamed from: j0 */
    public static final int f2879j0 = -8139290;

    /* renamed from: k0 */
    public static final int f2880k0 = 220;

    /* renamed from: l0 */
    public static final float f2881l0 = 2.0f;

    /* renamed from: m0 */
    public static final int f2882m0 = 3;

    /* renamed from: n0 */
    private static final float f2883n0 = 13.0f;

    /* renamed from: o0 */
    private static final int f2884o0 = 1;

    /* renamed from: p0 */
    private static final int f2885p0 = 2;

    /* renamed from: q0 */
    private static final int f2886q0 = 3;

    /* renamed from: r0 */
    private static final int f2887r0 = 5;

    /* renamed from: s0 */
    private static final float f2888s0 = 0.8f;

    /* renamed from: A */
    private float f2889A;

    /* renamed from: B */
    private int f2890B;

    /* renamed from: C */
    private int f2891C;

    /* renamed from: D */
    private int f2892D;

    /* renamed from: E */
    private int f2893E;

    /* renamed from: F */
    private int f2894F;

    /* renamed from: G */
    private int f2895G;

    /* renamed from: H */
    private int f2896H;

    /* renamed from: I */
    private int f2897I;

    /* renamed from: J */
    private float f2898J;

    /* renamed from: K */
    private long f2899K;

    /* renamed from: L */
    private int f2900L;

    /* renamed from: M */
    private int f2901M;

    /* renamed from: N */
    private int f2902N;

    /* renamed from: O */
    private int f2903O;

    /* renamed from: a */
    private HandlerC1289f f2904a;

    /* renamed from: b */
    private GestureDetector f2905b;

    /* renamed from: b0 */
    private float f2906b0;

    /* renamed from: c */
    private InterfaceC1290g f2907c;

    /* renamed from: c0 */
    private boolean f2908c0;

    /* renamed from: d */
    private InterfaceC1291h f2909d;

    /* renamed from: d0 */
    private boolean f2910d0;

    /* renamed from: e */
    private boolean f2911e;

    /* renamed from: f */
    private ScheduledFuture<?> f2912f;

    /* renamed from: g */
    private Paint f2913g;

    /* renamed from: h */
    private Paint f2914h;

    /* renamed from: i */
    private Paint f2915i;

    /* renamed from: j */
    private Paint f2916j;

    /* renamed from: k */
    private List<InterfaceC0914l> f2917k;

    /* renamed from: l */
    private String f2918l;

    /* renamed from: m */
    private int f2919m;

    /* renamed from: n */
    private int f2920n;

    /* renamed from: o */
    private int f2921o;

    /* renamed from: p */
    private int f2922p;

    /* renamed from: q */
    private float f2923q;

    /* renamed from: r */
    private Typeface f2924r;

    /* renamed from: s */
    private int f2925s;

    /* renamed from: t */
    private int f2926t;

    /* renamed from: u */
    private C1286c f2927u;

    /* renamed from: v */
    private float f2928v;

    /* renamed from: w */
    private int f2929w;

    /* renamed from: x */
    private boolean f2930x;

    /* renamed from: y */
    private float f2931y;

    /* renamed from: z */
    private float f2932z;

    /* renamed from: cn.qqtheme.framework.widget.WheelView$a */
    class C1284a extends GestureDetector.SimpleOnGestureListener {
        C1284a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            WheelView.this.m2566a(f3);
            return true;
        }
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$b */
    class RunnableC1285b implements Runnable {
        RunnableC1285b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WheelView.this.f2907c != null) {
                WheelView.this.f2907c.mo848a(WheelView.this.f2891C);
            }
            if (WheelView.this.f2909d != null) {
                WheelView.this.f2909d.m2605a(true, WheelView.this.f2891C, ((InterfaceC0914l) WheelView.this.f2917k.get(WheelView.this.f2891C)).getName());
            }
        }
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$c */
    public static class C1286c {

        /* renamed from: i */
        public static final float f2935i = 0.0f;

        /* renamed from: j */
        public static final float f2936j = 1.0f;

        /* renamed from: a */
        protected boolean f2937a;

        /* renamed from: b */
        protected boolean f2938b;

        /* renamed from: c */
        protected int f2939c;

        /* renamed from: d */
        protected int f2940d;

        /* renamed from: e */
        protected int f2941e;

        /* renamed from: f */
        protected int f2942f;

        /* renamed from: g */
        protected float f2943g;

        /* renamed from: h */
        protected float f2944h;

        public C1286c() {
            this.f2937a = true;
            this.f2938b = false;
            this.f2939c = WheelView.f2879j0;
            this.f2940d = WheelView.f2878i0;
            this.f2941e = 100;
            this.f2942f = 220;
            this.f2943g = 0.1f;
            this.f2944h = 2.0f;
        }

        /* renamed from: a */
        public C1286c m2599a(boolean z) {
            this.f2938b = z;
            if (z && this.f2939c == -8139290) {
                this.f2939c = this.f2940d;
                this.f2942f = 255;
            }
            return this;
        }

        /* renamed from: b */
        public C1286c m2602b(boolean z) {
            this.f2937a = z;
            return this;
        }

        /* renamed from: c */
        public C1286c m2603c(@IntRange(from = 1, m294to = 255) int i2) {
            this.f2941e = i2;
            return this;
        }

        /* renamed from: d */
        public C1286c m2604d(@ColorInt int i2) {
            this.f2938b = true;
            this.f2940d = i2;
            return this;
        }

        public String toString() {
            return "visible=" + this.f2937a + ",color=" + this.f2939c + ",alpha=" + this.f2942f + ",thick=" + this.f2944h;
        }

        /* renamed from: b */
        public C1286c m2601b(@ColorInt int i2) {
            this.f2939c = i2;
            return this;
        }

        /* renamed from: b */
        public C1286c m2600b(float f2) {
            this.f2944h = f2;
            return this;
        }

        /* renamed from: a */
        public C1286c m2598a(@IntRange(from = 1, m294to = 255) int i2) {
            this.f2942f = i2;
            return this;
        }

        /* renamed from: a */
        public C1286c m2597a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
            this.f2943g = f2;
            return this;
        }

        public C1286c(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
            this.f2937a = true;
            this.f2938b = false;
            this.f2939c = WheelView.f2879j0;
            this.f2940d = WheelView.f2878i0;
            this.f2941e = 100;
            this.f2942f = 220;
            this.f2943g = 0.1f;
            this.f2944h = 2.0f;
            this.f2943g = f2;
        }
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$d */
    private static class C1287d extends TimerTask {

        /* renamed from: a */
        float f2945a = 2.1474836E9f;

        /* renamed from: b */
        final float f2946b;

        /* renamed from: c */
        final WheelView f2947c;

        C1287d(WheelView wheelView, float f2) {
            this.f2947c = wheelView;
            this.f2946b = f2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (this.f2945a == 2.1474836E9f) {
                if (Math.abs(this.f2946b) <= 2000.0f) {
                    this.f2945a = this.f2946b;
                } else if (this.f2946b > 0.0f) {
                    this.f2945a = 2000.0f;
                } else {
                    this.f2945a = -2000.0f;
                }
            }
            if (Math.abs(this.f2945a) >= 0.0f && Math.abs(this.f2945a) <= 20.0f) {
                this.f2947c.m2565a();
                this.f2947c.f2904a.sendEmptyMessage(2000);
                return;
            }
            int i2 = (int) ((this.f2945a * 10.0f) / 1000.0f);
            float f2 = i2;
            this.f2947c.f2889A -= f2;
            if (!this.f2947c.f2930x) {
                float f3 = this.f2947c.f2923q;
                float f4 = (-this.f2947c.f2890B) * f3;
                float itemCount = ((this.f2947c.getItemCount() - 1) - this.f2947c.f2890B) * f3;
                double d2 = f3 * 0.25d;
                if (this.f2947c.f2889A - d2 < f4) {
                    f4 = this.f2947c.f2889A + f2;
                } else if (this.f2947c.f2889A + d2 > itemCount) {
                    itemCount = this.f2947c.f2889A + f2;
                }
                if (this.f2947c.f2889A <= f4) {
                    this.f2945a = 40.0f;
                    this.f2947c.f2889A = (int) f4;
                } else if (this.f2947c.f2889A >= itemCount) {
                    this.f2947c.f2889A = (int) itemCount;
                    this.f2945a = -40.0f;
                }
            }
            float f5 = this.f2945a;
            if (f5 < 0.0f) {
                this.f2945a = f5 + 20.0f;
            } else {
                this.f2945a = f5 - 20.0f;
            }
            this.f2947c.f2904a.sendEmptyMessage(1000);
        }
    }

    @Deprecated
    /* renamed from: cn.qqtheme.framework.widget.WheelView$e */
    public static class C1288e extends C1286c {
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$f */
    private static class HandlerC1289f extends Handler {

        /* renamed from: b */
        static final int f2948b = 1000;

        /* renamed from: c */
        static final int f2949c = 2000;

        /* renamed from: d */
        static final int f2950d = 3000;

        /* renamed from: a */
        final WheelView f2951a;

        HandlerC1289f(WheelView wheelView) {
            this.f2951a = wheelView;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                this.f2951a.invalidate();
            } else if (i2 == 2000) {
                this.f2951a.m2573b(2);
            } else {
                if (i2 != 3000) {
                    return;
                }
                this.f2951a.m2580d();
            }
        }
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$g */
    public interface InterfaceC1290g {
        /* renamed from: a */
        void mo848a(int i2);
    }

    @Deprecated
    /* renamed from: cn.qqtheme.framework.widget.WheelView$h */
    public interface InterfaceC1291h {
        /* renamed from: a */
        void m2605a(boolean z, int i2, String str);
    }

    @Deprecated
    /* renamed from: cn.qqtheme.framework.widget.WheelView$i */
    public interface InterfaceC1292i extends InterfaceC1291h {
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$j */
    private static class C1293j extends TimerTask {

        /* renamed from: a */
        int f2952a = Integer.MAX_VALUE;

        /* renamed from: b */
        int f2953b = 0;

        /* renamed from: c */
        int f2954c;

        /* renamed from: d */
        final WheelView f2955d;

        C1293j(WheelView wheelView, int i2) {
            this.f2955d = wheelView;
            this.f2954c = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.f2952a == Integer.MAX_VALUE) {
                this.f2952a = this.f2954c;
            }
            int i2 = this.f2952a;
            this.f2953b = (int) (i2 * 0.1f);
            if (this.f2953b == 0) {
                if (i2 < 0) {
                    this.f2953b = -1;
                } else {
                    this.f2953b = 1;
                }
            }
            if (Math.abs(this.f2952a) <= 1) {
                this.f2955d.m2565a();
                this.f2955d.f2904a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            this.f2955d.f2889A += this.f2953b;
            if (!this.f2955d.f2930x) {
                float f2 = this.f2955d.f2923q;
                float itemCount = ((this.f2955d.getItemCount() - 1) - this.f2955d.f2890B) * f2;
                if (this.f2955d.f2889A <= (-this.f2955d.f2890B) * f2 || this.f2955d.f2889A >= itemCount) {
                    this.f2955d.f2889A -= this.f2953b;
                    this.f2955d.m2565a();
                    this.f2955d.f2904a.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
                    return;
                }
            }
            this.f2955d.f2904a.sendEmptyMessage(1000);
            this.f2952a -= this.f2953b;
        }
    }

    /* renamed from: cn.qqtheme.framework.widget.WheelView$k */
    private static class C1294k implements InterfaceC0914l {
        private String name;

        /* synthetic */ C1294k(String str, C1284a c1284a) {
            this(str);
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0914l
        public String getName() {
            return this.name;
        }

        private C1294k(String str) {
            this.name = str;
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    protected int getItemCount() {
        List<InterfaceC0914l> list = this.f2917k;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getSelectedIndex() {
        return this.f2891C;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<InterfaceC0914l> list = this.f2917k;
        if (list == null || list.size() == 0) {
            return;
        }
        String[] strArr = new String[this.f2893E];
        this.f2892D = this.f2890B + (((int) (this.f2889A / this.f2923q)) % this.f2917k.size());
        if (this.f2930x) {
            if (this.f2892D < 0) {
                this.f2892D = this.f2917k.size() + this.f2892D;
            }
            if (this.f2892D > this.f2917k.size() - 1) {
                this.f2892D -= this.f2917k.size();
            }
        } else {
            if (this.f2892D < 0) {
                this.f2892D = 0;
            }
            if (this.f2892D > this.f2917k.size() - 1) {
                this.f2892D = this.f2917k.size() - 1;
            }
        }
        float f2 = this.f2889A % this.f2923q;
        int i2 = 0;
        while (true) {
            int i3 = this.f2893E;
            if (i2 >= i3) {
                break;
            }
            int i4 = this.f2892D - ((i3 / 2) - i2);
            if (this.f2930x) {
                strArr[i2] = this.f2917k.get(m2562a(i4)).getName();
            } else if (i4 < 0) {
                strArr[i2] = "";
            } else if (i4 > this.f2917k.size() - 1) {
                strArr[i2] = "";
            } else {
                strArr[i2] = this.f2917k.get(i4).getName();
            }
            i2++;
        }
        C1286c c1286c = this.f2927u;
        if (c1286c.f2937a) {
            float f3 = c1286c.f2943g;
            int i5 = this.f2895G;
            float f4 = this.f2931y;
            float f5 = 1.0f - f3;
            canvas.drawLine(i5 * f3, f4, i5 * f5, f4, this.f2915i);
            int i6 = this.f2895G;
            float f6 = this.f2932z;
            canvas.drawLine(i6 * f3, f6, i6 * f5, f6, this.f2915i);
        }
        C1286c c1286c2 = this.f2927u;
        if (c1286c2.f2938b) {
            this.f2916j.setColor(c1286c2.f2940d);
            this.f2916j.setAlpha(this.f2927u.f2941e);
            canvas.drawRect(0.0f, this.f2931y, this.f2895G, this.f2932z, this.f2916j);
        }
        for (int i7 = 0; i7 < this.f2893E; i7++) {
            canvas.save();
            double d2 = ((this.f2923q * i7) - f2) / this.f2896H;
            float f7 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f7 >= 90.0f || f7 <= -90.0f) {
                canvas.restore();
            } else {
                String m2564a = m2564a((Object) strArr[i7]);
                String str = (this.f2911e || TextUtils.isEmpty(this.f2918l) || TextUtils.isEmpty(m2564a)) ? m2564a : m2564a + this.f2918l;
                if (this.f2910d0) {
                    m2578c(str);
                    this.f2901M = 17;
                } else {
                    this.f2901M = GravityCompat.START;
                }
                m2570a(str);
                m2574b(str);
                String str2 = m2564a;
                float cos = (float) ((this.f2896H - (Math.cos(d2) * this.f2896H)) - ((Math.sin(d2) * this.f2920n) / 2.0d));
                canvas.translate(0.0f, cos);
                float f8 = this.f2931y;
                if (cos > f8 || this.f2920n + cos < f8) {
                    float f9 = this.f2932z;
                    if (cos > f9 || this.f2920n + cos < f9) {
                        if (cos >= this.f2931y) {
                            int i8 = this.f2920n;
                            if (i8 + cos <= this.f2932z) {
                                canvas.clipRect(0, 0, this.f2895G, i8);
                                float f10 = this.f2920n - this.f2906b0;
                                Iterator<InterfaceC0914l> it = this.f2917k.iterator();
                                int i9 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String str3 = str2;
                                    if (it.next().getName().equals(str3)) {
                                        this.f2891C = i9;
                                        break;
                                    } else {
                                        i9++;
                                        str2 = str3;
                                    }
                                }
                                if (this.f2911e && !TextUtils.isEmpty(this.f2918l)) {
                                    str = str + this.f2918l;
                                }
                                canvas.drawText(str, this.f2902N, f10, this.f2914h);
                                canvas.restore();
                                this.f2914h.setTextSize(this.f2922p);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.f2895G, this.f2923q);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * f2888s0);
                        float pow = (float) Math.pow(Math.abs(f7) / 90.0f, 2.2d);
                        int i10 = this.f2921o;
                        if (i10 != 0) {
                            this.f2913g.setTextSkewX((i10 > 0 ? 1 : -1) * (f7 <= 0.0f ? 1 : -1) * 0.5f * pow);
                            this.f2913g.setAlpha((int) ((1.0f - pow) * 255.0f));
                        }
                        canvas.drawText(str, this.f2903O + (this.f2921o * pow), this.f2920n, this.f2913g);
                        canvas.restore();
                        canvas.restore();
                        this.f2914h.setTextSize(this.f2922p);
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.f2895G, this.f2932z - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(str, this.f2902N, this.f2920n - this.f2906b0, this.f2914h);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.f2932z - cos, this.f2895G, (int) this.f2923q);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * f2888s0);
                        canvas.drawText(str, this.f2903O, this.f2920n, this.f2913g);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.f2895G, this.f2931y - cos);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * f2888s0);
                    canvas.drawText(str, this.f2903O, this.f2920n, this.f2913g);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.f2931y - cos, this.f2895G, (int) this.f2923q);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(str, this.f2902N, this.f2920n - this.f2906b0, this.f2914h);
                    canvas.restore();
                }
                canvas.restore();
                this.f2914h.setTextSize(this.f2922p);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.f2900L = i2;
        m2586g();
        setMeasuredDimension(this.f2895G, this.f2894F);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f2905b.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2899K = System.currentTimeMillis();
            m2565a();
            this.f2898J = motionEvent.getRawY();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.f2896H;
                double acos = Math.acos((i2 - y) / i2) * this.f2896H;
                float f2 = this.f2923q;
                int i3 = (int) ((acos + (f2 / 2.0f)) / f2);
                this.f2897I = (int) (((i3 - (this.f2893E / 2)) * f2) - (((this.f2889A % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.f2899K > 120) {
                    m2573b(3);
                } else {
                    m2573b(1);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.f2898J - motionEvent.getRawY();
            this.f2898J = motionEvent.getRawY();
            this.f2889A += rawY;
            if (!this.f2930x) {
                float f3 = (-this.f2890B) * this.f2923q;
                float size = (this.f2917k.size() - 1) - this.f2890B;
                float f4 = this.f2923q;
                float f5 = size * f4;
                float f6 = this.f2889A;
                if (f6 - (f4 * 0.25d) < f3) {
                    f3 = f6 - rawY;
                } else if (f6 + (f4 * 0.25d) > f5) {
                    f5 = f6 - rawY;
                }
                float f7 = this.f2889A;
                if (f7 < f3) {
                    this.f2889A = (int) f3;
                } else if (f7 > f5) {
                    this.f2889A = (int) f5;
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setCycleDisable(boolean z) {
        this.f2930x = !z;
    }

    public void setDividerColor(@ColorInt int i2) {
        this.f2927u.m2601b(i2);
        this.f2915i.setColor(i2);
    }

    public void setDividerConfig(C1286c c1286c) {
        if (c1286c == null) {
            this.f2927u.m2602b(false);
            this.f2927u.m2599a(false);
            return;
        }
        this.f2927u = c1286c;
        this.f2915i.setColor(c1286c.f2939c);
        this.f2915i.setStrokeWidth(c1286c.f2944h);
        this.f2915i.setAlpha(c1286c.f2942f);
        this.f2916j.setColor(c1286c.f2940d);
        this.f2916j.setAlpha(c1286c.f2941e);
    }

    public final void setGravity(int i2) {
        this.f2901M = i2;
    }

    public final void setItems(List<?> list) {
        this.f2917k.clear();
        for (Object obj : list) {
            if (obj instanceof InterfaceC0914l) {
                this.f2917k.add((InterfaceC0914l) obj);
            } else {
                if (!(obj instanceof CharSequence) && !(obj instanceof Number)) {
                    throw new IllegalArgumentException("please implements " + InterfaceC0914l.class.getName());
                }
                this.f2917k.add(new C1294k(obj.toString(), null));
            }
        }
        m2586g();
        invalidate();
    }

    public final void setLabel(String str) {
        m2592a(str, true);
    }

    @Deprecated
    public void setLineConfig(C1286c c1286c) {
        setDividerConfig(c1286c);
    }

    public final void setLineSpaceMultiplier(@FloatRange(from = 2.0d, m293to = 4.0d) float f2) {
        this.f2928v = f2;
        m2582e();
    }

    public final void setOffset(@IntRange(from = 1, m294to = 5) int i2) {
        if (i2 < 1 || i2 > 5) {
            throw new IllegalArgumentException("must between 1 and 5");
        }
        int i3 = (i2 * 2) + 1;
        if (i2 % 2 != 0) {
            i2--;
        }
        setVisibleItemCount(i3 + i2);
    }

    public final void setOnItemSelectListener(InterfaceC1290g interfaceC1290g) {
        this.f2907c = interfaceC1290g;
    }

    @Deprecated
    public final void setOnWheelListener(InterfaceC1291h interfaceC1291h) {
        this.f2909d = interfaceC1291h;
    }

    @Deprecated
    public void setPadding(int i2) {
        setTextPadding(i2);
    }

    public final void setSelectedIndex(int i2) {
        List<InterfaceC0914l> list = this.f2917k;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f2917k.size();
        if (i2 == 0 || (i2 > 0 && i2 < size && i2 != this.f2891C)) {
            this.f2890B = i2;
            this.f2889A = 0.0f;
            this.f2897I = 0;
            invalidate();
        }
    }

    public void setTextColor(@ColorInt int i2) {
        this.f2925s = i2;
        this.f2926t = i2;
        this.f2913g.setColor(i2);
        this.f2914h.setColor(i2);
    }

    public void setTextPadding(int i2) {
        this.f2929w = C0929b.m1103b(getContext(), i2);
    }

    public final void setTextSize(float f2) {
        if (f2 > 0.0f) {
            this.f2922p = (int) (getContext().getResources().getDisplayMetrics().density * f2);
            this.f2913g.setTextSize(this.f2922p);
            this.f2914h.setTextSize(this.f2922p);
        }
    }

    public void setTextSizeAutoFit(boolean z) {
        this.f2910d0 = z;
    }

    public void setTextSkewXOffset(int i2) {
        this.f2921o = i2;
        if (i2 != 0) {
            this.f2914h.setTextScaleX(1.0f);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f2924r = typeface;
        this.f2913g.setTypeface(this.f2924r);
        this.f2914h.setTypeface(this.f2924r);
    }

    public void setUseWeight(boolean z) {
        this.f2908c0 = z;
    }

    public final void setVisibleItemCount(int i2) {
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("must be odd");
        }
        if (i2 != this.f2893E) {
            this.f2893E = i2;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2911e = true;
        this.f2917k = new ArrayList();
        this.f2921o = 0;
        this.f2922p = 16;
        this.f2924r = Typeface.DEFAULT;
        this.f2925s = f2878i0;
        this.f2926t = f2877h0;
        this.f2927u = new C1286c();
        this.f2928v = 2.0f;
        this.f2929w = -1;
        this.f2930x = true;
        this.f2889A = 0.0f;
        this.f2890B = -1;
        this.f2893E = 7;
        this.f2897I = 0;
        this.f2898J = 0.0f;
        this.f2899K = 0L;
        this.f2901M = 17;
        this.f2902N = 0;
        this.f2903O = 0;
        this.f2908c0 = false;
        this.f2910d0 = true;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.f2906b0 = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.f2906b0 = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.f2906b0 = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.f2906b0 = 6.0f;
        } else if (f2 >= 3.0f) {
            this.f2906b0 = f2 * 2.5f;
        }
        m2582e();
        m2567a(context);
    }

    /* renamed from: c */
    private void m2577c() {
        this.f2913g = new Paint();
        this.f2913g.setAntiAlias(true);
        this.f2913g.setColor(this.f2925s);
        this.f2913g.setTypeface(this.f2924r);
        this.f2913g.setTextSize(this.f2922p);
        this.f2914h = new Paint();
        this.f2914h.setAntiAlias(true);
        this.f2914h.setColor(this.f2926t);
        this.f2914h.setTextScaleX(1.0f);
        this.f2914h.setTypeface(this.f2924r);
        this.f2914h.setTextSize(this.f2922p);
        this.f2915i = new Paint();
        this.f2915i.setAntiAlias(true);
        this.f2915i.setColor(this.f2927u.f2939c);
        this.f2915i.setStrokeWidth(this.f2927u.f2944h);
        this.f2915i.setAlpha(this.f2927u.f2942f);
        this.f2916j = new Paint();
        this.f2916j.setAntiAlias(true);
        this.f2916j.setColor(this.f2927u.f2940d);
        this.f2916j.setAlpha(this.f2927u.f2941e);
        setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2580d() {
        if (this.f2907c == null && this.f2909d == null) {
            return;
        }
        postDelayed(new RunnableC1285b(), 200L);
    }

    /* renamed from: e */
    private void m2582e() {
        float f2 = this.f2928v;
        if (f2 < 1.5f) {
            this.f2928v = 1.5f;
        } else if (f2 > 4.0f) {
            this.f2928v = 4.0f;
        }
    }

    /* renamed from: f */
    private void m2584f() {
        Rect rect = new Rect();
        for (int i2 = 0; i2 < this.f2917k.size(); i2++) {
            String m2564a = m2564a(this.f2917k.get(i2));
            this.f2914h.getTextBounds(m2564a, 0, m2564a.length(), rect);
            int width = rect.width();
            if (width > this.f2919m) {
                this.f2919m = width;
            }
            this.f2914h.getTextBounds("测试", 0, 2, rect);
            this.f2920n = rect.height() + 2;
        }
        this.f2923q = this.f2928v * this.f2920n;
    }

    /* renamed from: g */
    private void m2586g() {
        int i2;
        if (this.f2917k == null) {
            return;
        }
        m2584f();
        int i3 = (int) (this.f2923q * (this.f2893E - 1));
        this.f2894F = (int) ((i3 * 2) / 3.141592653589793d);
        this.f2896H = (int) (i3 / 3.141592653589793d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f2908c0) {
            this.f2895G = View.MeasureSpec.getSize(this.f2900L);
        } else if (layoutParams == null || (i2 = layoutParams.width) <= 0) {
            this.f2895G = this.f2919m;
            if (this.f2929w < 0) {
                this.f2929w = C0929b.m1103b(getContext(), f2883n0);
            }
            this.f2895G += this.f2929w * 2;
            if (!TextUtils.isEmpty(this.f2918l)) {
                this.f2895G += m2563a(this.f2914h, this.f2918l);
            }
        } else {
            this.f2895G = i2;
        }
        C0931d.m1154b("measuredWidth=" + this.f2895G + ",measuredHeight=" + this.f2894F);
        int i4 = this.f2894F;
        float f2 = this.f2923q;
        this.f2931y = (((float) i4) - f2) / 2.0f;
        this.f2932z = (((float) i4) + f2) / 2.0f;
        if (this.f2890B == -1) {
            if (this.f2930x) {
                this.f2890B = (this.f2917k.size() + 1) / 2;
            } else {
                this.f2890B = 0;
            }
        }
        this.f2892D = this.f2890B;
    }

    /* renamed from: b */
    private void m2572b() {
        if (isInEditMode()) {
            setItems(new String[]{"李玉江", "男", "贵州", "穿青人"});
        }
    }

    /* renamed from: a */
    public final void m2593a(List<?> list, int i2) {
        setItems(list);
        setSelectedIndex(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2573b(int i2) {
        m2565a();
        if (i2 == 2 || i2 == 3) {
            float f2 = this.f2889A;
            float f3 = this.f2923q;
            this.f2897I = (int) (((f2 % f3) + f3) % f3);
            int i3 = this.f2897I;
            if (i3 > f3 / 2.0f) {
                this.f2897I = (int) (f3 - i3);
            } else {
                this.f2897I = -i3;
            }
        }
        this.f2912f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new C1293j(this, this.f2897I), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public final void m2594a(List<String> list, String str) {
        int indexOf = list.indexOf(str);
        if (indexOf == -1) {
            indexOf = 0;
        }
        m2593a(list, indexOf);
    }

    /* renamed from: a */
    public final void m2595a(String[] strArr, int i2) {
        m2593a(Arrays.asList(strArr), i2);
    }

    /* renamed from: a */
    public final void m2596a(String[] strArr, String str) {
        m2594a(Arrays.asList(strArr), str);
    }

    /* renamed from: a */
    public final void m2592a(String str, boolean z) {
        this.f2918l = str;
        this.f2911e = z;
    }

    public final void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr));
    }

    /* renamed from: a */
    public void m2591a(@ColorInt int i2, @ColorInt int i3) {
        this.f2925s = i2;
        this.f2926t = i3;
        this.f2913g.setColor(i2);
        this.f2914h.setColor(i3);
    }

    /* renamed from: b */
    private void m2574b(String str) {
        Rect rect = new Rect();
        this.f2913g.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.f2901M;
        if (i2 == 3) {
            this.f2903O = C0929b.m1103b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.f2903O = (this.f2895G - rect.width()) - ((int) this.f2906b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.f2903O = (int) ((this.f2895G - rect.width()) * 0.5d);
        }
    }

    /* renamed from: a */
    private void m2567a(Context context) {
        this.f2904a = new HandlerC1289f(this);
        this.f2905b = new GestureDetector(context, new C1284a());
        this.f2905b.setIsLongpressEnabled(false);
        m2577c();
        m2572b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2566a(float f2) {
        m2565a();
        this.f2912f = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new C1287d(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* renamed from: c */
    private void m2578c(String str) {
        Rect rect = new Rect();
        this.f2914h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.f2922p;
        for (int width = rect.width(); width > this.f2895G; width = rect.width()) {
            i2--;
            this.f2914h.setTextSize(i2);
            this.f2914h.getTextBounds(str, 0, str.length(), rect);
        }
        this.f2913g.setTextSize(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2565a() {
        ScheduledFuture<?> scheduledFuture = this.f2912f;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f2912f.cancel(true);
        this.f2912f = null;
    }

    /* renamed from: a */
    private int m2562a(int i2) {
        if (i2 < 0) {
            return m2562a(i2 + this.f2917k.size());
        }
        return i2 > this.f2917k.size() + (-1) ? m2562a(i2 - this.f2917k.size()) : i2;
    }

    /* renamed from: a */
    private String m2564a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof InterfaceC0914l) {
            return ((InterfaceC0914l) obj).getName();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    /* renamed from: a */
    private void m2570a(String str) {
        Rect rect = new Rect();
        this.f2914h.getTextBounds(str, 0, str.length(), rect);
        int i2 = this.f2901M;
        if (i2 == 3) {
            this.f2902N = C0929b.m1103b(getContext(), 8.0f);
        } else if (i2 == 5) {
            this.f2902N = (this.f2895G - rect.width()) - ((int) this.f2906b0);
        } else {
            if (i2 != 17) {
                return;
            }
            this.f2902N = (int) ((this.f2895G - rect.width()) * 0.5d);
        }
    }

    /* renamed from: a */
    private int m2563a(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += (int) Math.ceil(r2[i3]);
        }
        return i2;
    }
}
