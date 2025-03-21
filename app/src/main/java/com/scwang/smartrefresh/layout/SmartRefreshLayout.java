package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.C2900a;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2867a;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2868b;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2869c;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2871e;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2872f;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2874h;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2877k;
import com.scwang.smartrefresh.layout.p190c.EnumC2878a;
import com.scwang.smartrefresh.layout.p190c.EnumC2879b;
import com.scwang.smartrefresh.layout.p190c.EnumC2880c;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2883c;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2885e;
import com.scwang.smartrefresh.layout.p192e.AbstractC2892e;
import com.scwang.smartrefresh.layout.p192e.C2889b;
import com.scwang.smartrefresh.layout.p192e.InterpolatorC2893f;
import com.scwang.smartrefresh.layout.p192e.RunnableC2888a;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class SmartRefreshLayout extends ViewGroup implements InterfaceC2876j, NestedScrollingParent {

    /* renamed from: T0 */
    protected static InterfaceC2867a f8972T0;

    /* renamed from: U0 */
    protected static InterfaceC2868b f8973U0;

    /* renamed from: V0 */
    protected static InterfaceC2869c f8974V0;

    /* renamed from: A */
    protected boolean f8975A;

    /* renamed from: A0 */
    protected InterfaceC2874h f8976A0;

    /* renamed from: B */
    protected boolean f8977B;

    /* renamed from: B0 */
    protected InterfaceC2874h f8978B0;

    /* renamed from: C */
    protected boolean f8979C;

    /* renamed from: C0 */
    protected InterfaceC2871e f8980C0;

    /* renamed from: D */
    protected boolean f8981D;

    /* renamed from: D0 */
    protected Paint f8982D0;

    /* renamed from: E */
    protected boolean f8983E;

    /* renamed from: E0 */
    protected Handler f8984E0;

    /* renamed from: F */
    protected boolean f8985F;

    /* renamed from: F0 */
    protected InterfaceC2875i f8986F0;

    /* renamed from: G */
    protected boolean f8987G;

    /* renamed from: G0 */
    protected List<RunnableC2888a> f8988G0;

    /* renamed from: H */
    protected boolean f8989H;

    /* renamed from: H0 */
    protected EnumC2879b f8990H0;

    /* renamed from: I */
    protected boolean f8991I;

    /* renamed from: I0 */
    protected EnumC2879b f8992I0;

    /* renamed from: J */
    protected boolean f8993J;

    /* renamed from: J0 */
    protected long f8994J0;

    /* renamed from: K */
    protected boolean f8995K;

    /* renamed from: K0 */
    protected int f8996K0;

    /* renamed from: L */
    protected boolean f8997L;

    /* renamed from: L0 */
    protected int f8998L0;

    /* renamed from: M */
    protected boolean f8999M;

    /* renamed from: M0 */
    protected boolean f9000M0;

    /* renamed from: N */
    protected boolean f9001N;

    /* renamed from: N0 */
    protected boolean f9002N0;

    /* renamed from: O */
    protected boolean f9003O;

    /* renamed from: O0 */
    protected boolean f9004O0;

    /* renamed from: P0 */
    protected boolean f9005P0;

    /* renamed from: Q0 */
    protected MotionEvent f9006Q0;

    /* renamed from: R0 */
    protected Runnable f9007R0;

    /* renamed from: S0 */
    protected ValueAnimator f9008S0;

    /* renamed from: a */
    protected int f9009a;

    /* renamed from: b */
    protected int f9010b;

    /* renamed from: b0 */
    protected boolean f9011b0;

    /* renamed from: c */
    protected int f9012c;

    /* renamed from: c0 */
    protected boolean f9013c0;

    /* renamed from: d */
    protected int f9014d;

    /* renamed from: d0 */
    protected boolean f9015d0;

    /* renamed from: e */
    protected int f9016e;

    /* renamed from: e0 */
    protected boolean f9017e0;

    /* renamed from: f */
    protected int f9018f;

    /* renamed from: f0 */
    protected boolean f9019f0;

    /* renamed from: g */
    protected int f9020g;

    /* renamed from: g0 */
    protected boolean f9021g0;

    /* renamed from: h */
    protected float f9022h;

    /* renamed from: h0 */
    protected InterfaceC2884d f9023h0;

    /* renamed from: i */
    protected float f9024i;

    /* renamed from: i0 */
    protected InterfaceC2882b f9025i0;

    /* renamed from: j */
    protected float f9026j;

    /* renamed from: j0 */
    protected InterfaceC2883c f9027j0;

    /* renamed from: k */
    protected float f9028k;

    /* renamed from: k0 */
    protected InterfaceC2877k f9029k0;

    /* renamed from: l */
    protected float f9030l;

    /* renamed from: l0 */
    protected int f9031l0;

    /* renamed from: m */
    protected char f9032m;

    /* renamed from: m0 */
    protected boolean f9033m0;

    /* renamed from: n */
    protected boolean f9034n;

    /* renamed from: n0 */
    protected int[] f9035n0;

    /* renamed from: o */
    protected boolean f9036o;

    /* renamed from: o0 */
    protected NestedScrollingChildHelper f9037o0;

    /* renamed from: p */
    protected int f9038p;

    /* renamed from: p0 */
    protected NestedScrollingParentHelper f9039p0;

    /* renamed from: q */
    protected int f9040q;

    /* renamed from: q0 */
    protected int f9041q0;

    /* renamed from: r */
    protected int f9042r;

    /* renamed from: r0 */
    protected EnumC2878a f9043r0;

    /* renamed from: s */
    protected int f9044s;

    /* renamed from: s0 */
    protected int f9045s0;

    /* renamed from: t */
    protected int f9046t;

    /* renamed from: t0 */
    protected EnumC2878a f9047t0;

    /* renamed from: u */
    protected int f9048u;

    /* renamed from: u0 */
    protected int f9049u0;

    /* renamed from: v */
    protected int f9050v;

    /* renamed from: v0 */
    protected int f9051v0;

    /* renamed from: w */
    protected Scroller f9052w;

    /* renamed from: w0 */
    protected float f9053w0;

    /* renamed from: x */
    protected VelocityTracker f9054x;

    /* renamed from: x0 */
    protected float f9055x0;

    /* renamed from: y */
    protected Interpolator f9056y;

    /* renamed from: y0 */
    protected float f9057y0;

    /* renamed from: z */
    protected int[] f9058z;

    /* renamed from: z0 */
    protected float f9059z0;

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a */
    static /* synthetic */ class C2852a {

        /* renamed from: a */
        static final /* synthetic */ int[] f9060a = new int[EnumC2879b.values().length];

        static {
            try {
                f9060a[EnumC2879b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9060a[EnumC2879b.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9060a[EnumC2879b.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9060a[EnumC2879b.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9060a[EnumC2879b.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9060a[EnumC2879b.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9060a[EnumC2879b.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9060a[EnumC2879b.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9060a[EnumC2879b.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9060a[EnumC2879b.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9060a[EnumC2879b.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9060a[EnumC2879b.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9060a[EnumC2879b.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9060a[EnumC2879b.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9060a[EnumC2879b.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9060a[EnumC2879b.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9060a[EnumC2879b.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b */
    class C2853b extends AnimatorListenerAdapter {
        C2853b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.setStateDirectLoading(true);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$c */
    class C2854c extends AnimatorListenerAdapter {
        C2854c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.f8994J0 = System.currentTimeMillis();
            SmartRefreshLayout.this.m8631a(EnumC2879b.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            InterfaceC2884d interfaceC2884d = smartRefreshLayout.f9023h0;
            if (interfaceC2884d != null) {
                interfaceC2884d.mo8732a(smartRefreshLayout);
            } else if (smartRefreshLayout.f9027j0 == null) {
                smartRefreshLayout.mo8648d(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            InterfaceC2874h interfaceC2874h = smartRefreshLayout2.f8976A0;
            if (interfaceC2874h != null) {
                int i2 = smartRefreshLayout2.f9041q0;
                interfaceC2874h.mo8716a(smartRefreshLayout2, i2, (int) (smartRefreshLayout2.f9053w0 * i2));
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            InterfaceC2883c interfaceC2883c = smartRefreshLayout3.f9027j0;
            if (interfaceC2883c == null || !(smartRefreshLayout3.f8976A0 instanceof InterfaceC2873g)) {
                return;
            }
            interfaceC2883c.mo8732a(smartRefreshLayout3);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            InterfaceC2883c interfaceC2883c2 = smartRefreshLayout4.f9027j0;
            InterfaceC2873g interfaceC2873g = (InterfaceC2873g) smartRefreshLayout4.f8976A0;
            int i3 = smartRefreshLayout4.f9041q0;
            interfaceC2883c2.mo8731b(interfaceC2873g, i3, (int) (smartRefreshLayout4.f9053w0 * i3));
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$d */
    class C2855d extends AnimatorListenerAdapter {
        C2855d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f9008S0 = null;
            if (smartRefreshLayout.f9010b != 0) {
                EnumC2879b enumC2879b = smartRefreshLayout.f8990H0;
                if (enumC2879b != smartRefreshLayout.f8992I0) {
                    smartRefreshLayout.setViceState(enumC2879b);
                    return;
                }
                return;
            }
            EnumC2879b enumC2879b2 = smartRefreshLayout.f8990H0;
            EnumC2879b enumC2879b3 = EnumC2879b.None;
            if (enumC2879b2 == enumC2879b3 || enumC2879b2.isOpening) {
                return;
            }
            smartRefreshLayout.m8631a(enumC2879b3);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$e */
    class C2856e implements ValueAnimator.AnimatorUpdateListener {
        C2856e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.f8986F0.mo8689a(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$f */
    class RunnableC2857f implements Runnable {
        RunnableC2857f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            InterfaceC2882b interfaceC2882b = smartRefreshLayout.f9025i0;
            if (interfaceC2882b != null) {
                interfaceC2882b.mo8723b(smartRefreshLayout);
            } else if (smartRefreshLayout.f9027j0 == null) {
                smartRefreshLayout.mo8651e(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            InterfaceC2883c interfaceC2883c = smartRefreshLayout2.f9027j0;
            if (interfaceC2883c != null) {
                interfaceC2883c.mo8723b(smartRefreshLayout2);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$g */
    class RunnableC2858g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9066a;

        RunnableC2858g(boolean z) {
            this.f9066a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8990H0 != EnumC2879b.Refreshing || smartRefreshLayout.f8976A0 == null || smartRefreshLayout.f8980C0 == null) {
                return;
            }
            smartRefreshLayout.m8631a(EnumC2879b.RefreshFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int mo8713a = smartRefreshLayout2.f8976A0.mo8713a(smartRefreshLayout2, this.f9066a);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            InterfaceC2883c interfaceC2883c = smartRefreshLayout3.f9027j0;
            if (interfaceC2883c != null) {
                InterfaceC2874h interfaceC2874h = smartRefreshLayout3.f8976A0;
                if (interfaceC2874h instanceof InterfaceC2873g) {
                    interfaceC2883c.mo8728a((InterfaceC2873g) interfaceC2874h, this.f9066a);
                }
            }
            if (mo8713a < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.f9034n || smartRefreshLayout4.f9033m0) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.f9034n) {
                        smartRefreshLayout5.f9024i = smartRefreshLayout5.f9028k;
                        smartRefreshLayout5.f9014d = 0;
                        smartRefreshLayout5.f9034n = false;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.f9026j, (smartRefreshLayout6.f9028k + smartRefreshLayout6.f9010b) - (smartRefreshLayout6.f9009a * 2), 0));
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.f9026j, smartRefreshLayout7.f9028k + smartRefreshLayout7.f9010b, 0));
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.f9033m0) {
                        smartRefreshLayout8.f9031l0 = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout9.f9010b;
                if (i2 <= 0) {
                    if (i2 < 0) {
                        smartRefreshLayout9.m8613a(0, mo8713a, smartRefreshLayout9.f9056y, smartRefreshLayout9.f9018f);
                        return;
                    } else {
                        smartRefreshLayout9.f8986F0.mo8689a(0, false);
                        SmartRefreshLayout.this.m8671k();
                        return;
                    }
                }
                ValueAnimator m8613a = smartRefreshLayout9.m8613a(0, mo8713a, smartRefreshLayout9.f9056y, smartRefreshLayout9.f9018f);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener mo8703a = smartRefreshLayout10.f9001N ? smartRefreshLayout10.f8980C0.mo8703a(smartRefreshLayout10.f9010b) : null;
                if (m8613a == null || mo8703a == null) {
                    return;
                }
                m8613a.addUpdateListener(mo8703a);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h */
    class RunnableC2859h implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9068a;

        /* renamed from: b */
        final /* synthetic */ boolean f9069b;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f9071a;

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            class C7371a extends AnimatorListenerAdapter {
                C7371a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RunnableC2859h runnableC2859h = RunnableC2859h.this;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.f9004O0 = false;
                    if (runnableC2859h.f9069b) {
                        smartRefreshLayout.mo8629a(true);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f8990H0 == EnumC2879b.LoadFinish) {
                        smartRefreshLayout2.m8631a(EnumC2879b.None);
                    }
                }
            }

            a(int i2) {
                this.f9071a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator valueAnimator;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener mo8703a = (!smartRefreshLayout.f8999M || this.f9071a >= 0) ? null : smartRefreshLayout.f8980C0.mo8703a(smartRefreshLayout.f9010b);
                if (mo8703a != null) {
                    mo8703a.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                C7371a c7371a = new C7371a();
                RunnableC2859h runnableC2859h = RunnableC2859h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i2 = smartRefreshLayout2.f9010b;
                if (i2 > 0) {
                    valueAnimator = smartRefreshLayout2.f8986F0.mo8687a(0);
                } else {
                    if (mo8703a != null || i2 == 0) {
                        ValueAnimator valueAnimator2 = SmartRefreshLayout.this.f9008S0;
                        if (valueAnimator2 != null) {
                            valueAnimator2.cancel();
                            SmartRefreshLayout.this.f9008S0 = null;
                        }
                        SmartRefreshLayout.this.f8986F0.mo8689a(0, false);
                        SmartRefreshLayout.this.m8671k();
                    } else if (runnableC2859h.f9069b && smartRefreshLayout2.f8987G) {
                        int i3 = smartRefreshLayout2.f9045s0;
                        if (i2 >= (-i3)) {
                            smartRefreshLayout2.m8631a(EnumC2879b.None);
                        } else {
                            valueAnimator = smartRefreshLayout2.f8986F0.mo8687a(-i3);
                        }
                    } else {
                        valueAnimator = SmartRefreshLayout.this.f8986F0.mo8687a(0);
                    }
                    valueAnimator = null;
                }
                if (valueAnimator != null) {
                    valueAnimator.addListener(c7371a);
                } else {
                    c7371a.onAnimationEnd(null);
                }
            }
        }

        RunnableC2859h(boolean z, boolean z2) {
            this.f9068a = z;
            this.f9069b = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        
            if (r2.f8980C0.mo8710b() != false) goto L25;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 215
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.RunnableC2859h.run():void");
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$i */
    class RunnableC2860i implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f9074a;

        /* renamed from: b */
        final /* synthetic */ int f9075b;

        /* renamed from: c */
        final /* synthetic */ boolean f9076c;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$i$a */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.f8986F0.mo8689a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$i$b */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RunnableC2860i runnableC2860i = RunnableC2860i.this;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f9008S0 = null;
                if (!runnableC2860i.f9076c) {
                    EnumC2879b enumC2879b = smartRefreshLayout.f8990H0;
                    EnumC2879b enumC2879b2 = EnumC2879b.ReleaseToRefresh;
                    if (enumC2879b != enumC2879b2) {
                        smartRefreshLayout.f8986F0.mo8693a(enumC2879b2);
                    }
                } else if (smartRefreshLayout.f8990H0 == EnumC2879b.ReleaseToRefresh) {
                    smartRefreshLayout.f8986F0.mo8693a(EnumC2879b.PullDownToRefresh);
                }
                SmartRefreshLayout.this.m8668j();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f9026j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.f8986F0.mo8693a(EnumC2879b.PullDownToRefresh);
            }
        }

        RunnableC2860i(float f2, int i2, boolean z) {
            this.f9074a = f2;
            this.f9075b = i2;
            this.f9076c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f9008S0 = ValueAnimator.ofInt(smartRefreshLayout.f9010b, (int) (smartRefreshLayout.f9041q0 * this.f9074a));
            SmartRefreshLayout.this.f9008S0.setDuration(this.f9075b);
            SmartRefreshLayout.this.f9008S0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f9008S0.addUpdateListener(new a());
            SmartRefreshLayout.this.f9008S0.addListener(new b());
            SmartRefreshLayout.this.f9008S0.start();
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$j */
    class RunnableC2861j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f9080a;

        /* renamed from: b */
        final /* synthetic */ int f9081b;

        /* renamed from: c */
        final /* synthetic */ boolean f9082c;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$j$a */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.f8986F0.mo8689a(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
            }
        }

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$j$b */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RunnableC2861j runnableC2861j = RunnableC2861j.this;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f9008S0 = null;
                if (!runnableC2861j.f9082c) {
                    EnumC2879b enumC2879b = smartRefreshLayout.f8990H0;
                    EnumC2879b enumC2879b2 = EnumC2879b.ReleaseToLoad;
                    if (enumC2879b != enumC2879b2) {
                        smartRefreshLayout.f8986F0.mo8693a(enumC2879b2);
                    }
                } else if (smartRefreshLayout.f8990H0 == EnumC2879b.ReleaseToLoad) {
                    smartRefreshLayout.f8986F0.mo8693a(EnumC2879b.PullUpToLoad);
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.f8995K) {
                    smartRefreshLayout2.m8668j();
                    return;
                }
                smartRefreshLayout2.f8995K = false;
                smartRefreshLayout2.m8668j();
                SmartRefreshLayout.this.f8995K = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout.this.f9026j = r2.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.f8986F0.mo8693a(EnumC2879b.PullUpToLoad);
            }
        }

        RunnableC2861j(float f2, int i2, boolean z) {
            this.f9080a = f2;
            this.f9081b = i2;
            this.f9082c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f9008S0 = ValueAnimator.ofInt(smartRefreshLayout.f9010b, -((int) (smartRefreshLayout.f9045s0 * this.f9080a)));
            SmartRefreshLayout.this.f9008S0.setDuration(this.f9081b);
            SmartRefreshLayout.this.f9008S0.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f9008S0.addUpdateListener(new a());
            SmartRefreshLayout.this.f9008S0.addListener(new b());
            SmartRefreshLayout.this.f9008S0.start();
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$k */
    protected class RunnableC2862k implements Runnable {

        /* renamed from: c */
        int f9088c;

        /* renamed from: f */
        float f9091f;

        /* renamed from: a */
        int f9086a = 0;

        /* renamed from: b */
        int f9087b = 10;

        /* renamed from: e */
        float f9090e = 0.0f;

        /* renamed from: d */
        long f9089d = AnimationUtils.currentAnimationTimeMillis();

        RunnableC2862k(float f2, int i2) {
            this.f9091f = f2;
            this.f9088c = i2;
            SmartRefreshLayout.this.postDelayed(this, this.f9087b);
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f9007R0 != this || smartRefreshLayout.f8990H0.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.f9010b) < Math.abs(this.f9088c)) {
                double d2 = this.f9091f;
                this.f9086a = this.f9086a + 1;
                this.f9091f = (float) (d2 * Math.pow(0.949999988079071d, r4 * 2));
            } else if (this.f9088c != 0) {
                double d3 = this.f9091f;
                this.f9086a = this.f9086a + 1;
                this.f9091f = (float) (d3 * Math.pow(0.44999998807907104d, r4 * 2));
            } else {
                double d4 = this.f9091f;
                this.f9086a = this.f9086a + 1;
                this.f9091f = (float) (d4 * Math.pow(0.8500000238418579d, r4 * 2));
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f2 = this.f9091f * (((currentAnimationTimeMillis - this.f9089d) * 1.0f) / 1000.0f);
            if (Math.abs(f2) >= 1.0f) {
                this.f9089d = currentAnimationTimeMillis;
                this.f9090e += f2;
                SmartRefreshLayout.this.m8672k(this.f9090e);
                SmartRefreshLayout.this.postDelayed(this, this.f9087b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.f9007R0 = null;
            if (Math.abs(smartRefreshLayout2.f9010b) >= Math.abs(this.f9088c)) {
                int min = Math.min(Math.max((int) C2889b.m8734b(Math.abs(SmartRefreshLayout.this.f9010b - this.f9088c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.m8613a(this.f9088c, 0, smartRefreshLayout3.f9056y, min);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$l */
    protected class RunnableC2863l implements Runnable {

        /* renamed from: a */
        int f9093a;

        /* renamed from: d */
        float f9096d;

        /* renamed from: b */
        int f9094b = 0;

        /* renamed from: c */
        int f9095c = 10;

        /* renamed from: e */
        float f9097e = 0.98f;

        /* renamed from: f */
        long f9098f = 0;

        /* renamed from: g */
        long f9099g = AnimationUtils.currentAnimationTimeMillis();

        RunnableC2863l(float f2) {
            this.f9096d = f2;
            this.f9093a = SmartRefreshLayout.this.f9010b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
        
            if (r0 < (-r1.f9045s0)) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x004f, code lost:
        
            if (r0.f9010b > r0.f9041q0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0041, code lost:
        
            if (r0.f9010b >= (-r0.f9045s0)) goto L25;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable m8686a() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.f8990H0
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.f9010b
                if (r2 == 0) goto La8
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L22
                boolean r1 = r0.f9015d0
                if (r1 == 0) goto L51
                boolean r1 = r0.f8987G
                if (r1 == 0) goto L51
                boolean r1 = r0.f8977B
                boolean r0 = r0.m8685v(r1)
                if (r0 == 0) goto L51
            L22:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.f8990H0
                com.scwang.smartrefresh.layout.c.b r2 = com.scwang.smartrefresh.layout.p190c.EnumC2879b.Loading
                if (r1 == r2) goto L3a
                boolean r1 = r0.f9015d0
                if (r1 == 0) goto L43
                boolean r1 = r0.f8987G
                if (r1 == 0) goto L43
                boolean r1 = r0.f8977B
                boolean r0 = r0.m8685v(r1)
                if (r0 == 0) goto L43
            L3a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.f9010b
                int r0 = r0.f9045s0
                int r0 = -r0
                if (r1 < r0) goto L51
            L43:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r1 = r0.f8990H0
                com.scwang.smartrefresh.layout.c.b r2 = com.scwang.smartrefresh.layout.p190c.EnumC2879b.Refreshing
                if (r1 != r2) goto La8
                int r1 = r0.f9010b
                int r0 = r0.f9041q0
                if (r1 <= r0) goto La8
            L51:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f9010b
                float r2 = r11.f9096d
                r0 = r1
                r4 = 0
            L5a:
                int r5 = r1 * r0
                if (r5 <= 0) goto La8
                double r5 = (double) r2
                float r2 = r11.f9097e
                double r7 = (double) r2
                int r4 = r4 + 1
                int r2 = r11.f9095c
                int r2 = r2 * r4
                int r2 = r2 / 10
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.f9095c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto La4
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r2 = r1.f8990H0
                boolean r4 = r2.isOpening
                if (r4 == 0) goto La3
                com.scwang.smartrefresh.layout.c.b r4 = com.scwang.smartrefresh.layout.p190c.EnumC2879b.Refreshing
                if (r2 != r4) goto L96
                int r1 = r1.f9041q0
                if (r0 > r1) goto La3
            L96:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.c.b r2 = r1.f8990H0
                com.scwang.smartrefresh.layout.c.b r4 = com.scwang.smartrefresh.layout.p190c.EnumC2879b.Refreshing
                if (r2 == r4) goto La8
                int r1 = r1.f9045s0
                int r1 = -r1
                if (r0 >= r1) goto La8
            La3:
                return r3
            La4:
                float r0 = (float) r0
                float r0 = r0 + r5
                int r0 = (int) r0
                goto L5a
            La8:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f9098f = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r11.f9095c
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.RunnableC2863l.m8686a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f9007R0 != this || smartRefreshLayout.f8990H0.isFinishing) {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j2 = currentAnimationTimeMillis - this.f9099g;
            this.f9096d = (float) (this.f9096d * Math.pow(this.f9097e, (currentAnimationTimeMillis - this.f9098f) / (1000 / this.f9095c)));
            float f2 = this.f9096d * ((j2 * 1.0f) / 1000.0f);
            if (Math.abs(f2) <= 1.0f) {
                SmartRefreshLayout.this.f9007R0 = null;
                return;
            }
            this.f9099g = currentAnimationTimeMillis;
            this.f9093a = (int) (this.f9093a + f2);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i2 = smartRefreshLayout2.f9010b;
            int i3 = this.f9093a;
            if (i2 * i3 > 0) {
                smartRefreshLayout2.f8986F0.mo8689a(i3, true);
                SmartRefreshLayout.this.postDelayed(this, this.f9095c);
                return;
            }
            smartRefreshLayout2.f9007R0 = null;
            smartRefreshLayout2.f8986F0.mo8689a(0, true);
            AbstractC2892e.m8746a(SmartRefreshLayout.this.f8980C0.mo8711c(), (int) (-this.f9096d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.f9004O0 || f2 <= 0.0f) {
                return;
            }
            smartRefreshLayout3.f9004O0 = false;
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$n */
    public class C2865n implements InterfaceC2875i {

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$n$a */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.f8986F0.mo8693a(EnumC2879b.TwoLevel);
            }
        }

        public C2865n() {
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        @NonNull
        /* renamed from: a */
        public InterfaceC2871e mo8688a() {
            return SmartRefreshLayout.this.f8980C0;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: b */
        public InterfaceC2875i mo8695b() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8990H0 == EnumC2879b.TwoLevel) {
                smartRefreshLayout.f8986F0.mo8693a(EnumC2879b.TwoLevelFinish);
                if (SmartRefreshLayout.this.f9010b == 0) {
                    mo8689a(0, false);
                    SmartRefreshLayout.this.m8631a(EnumC2879b.None);
                } else {
                    mo8687a(0).setDuration(SmartRefreshLayout.this.f9016e);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        @NonNull
        /* renamed from: c */
        public InterfaceC2876j mo8698c() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8693a(@NonNull EnumC2879b enumC2879b) {
            switch (C2852a.f9060a[enumC2879b.ordinal()]) {
                case 1:
                    SmartRefreshLayout.this.m8671k();
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (!smartRefreshLayout.f8990H0.isOpening && smartRefreshLayout.m8685v(smartRefreshLayout.f8975A)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.PullDownToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.PullDownToRefresh);
                        break;
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.m8685v(smartRefreshLayout2.f8977B)) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                        EnumC2879b enumC2879b2 = smartRefreshLayout3.f8990H0;
                        if (!enumC2879b2.isOpening && !enumC2879b2.isFinishing && (!smartRefreshLayout3.f9015d0 || !smartRefreshLayout3.f8987G)) {
                            SmartRefreshLayout.this.m8631a(EnumC2879b.PullUpToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(EnumC2879b.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout4.f8990H0.isOpening && smartRefreshLayout4.m8685v(smartRefreshLayout4.f8975A)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.PullDownCanceled);
                        SmartRefreshLayout.this.m8671k();
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.PullDownCanceled);
                        break;
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.m8685v(smartRefreshLayout5.f8977B)) {
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout6.f8990H0.isOpening && (!smartRefreshLayout6.f9015d0 || !smartRefreshLayout6.f8987G)) {
                            SmartRefreshLayout.this.m8631a(EnumC2879b.PullUpCanceled);
                            SmartRefreshLayout.this.m8671k();
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(EnumC2879b.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout7.f8990H0.isOpening && smartRefreshLayout7.m8685v(smartRefreshLayout7.f8975A)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.ReleaseToRefresh);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.ReleaseToRefresh);
                        break;
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.m8685v(smartRefreshLayout8.f8977B)) {
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        EnumC2879b enumC2879b3 = smartRefreshLayout9.f8990H0;
                        if (!enumC2879b3.isOpening && !enumC2879b3.isFinishing && (!smartRefreshLayout9.f9015d0 || !smartRefreshLayout9.f8987G)) {
                            SmartRefreshLayout.this.m8631a(EnumC2879b.ReleaseToLoad);
                            break;
                        }
                    }
                    SmartRefreshLayout.this.setViceState(EnumC2879b.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout10.f8990H0.isOpening && smartRefreshLayout10.m8685v(smartRefreshLayout10.f8975A)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.ReleaseToTwoLevel);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.ReleaseToTwoLevel);
                        break;
                    }
                case 9:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.f8990H0.isOpening && smartRefreshLayout11.m8685v(smartRefreshLayout11.f8975A)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.RefreshReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.RefreshReleased);
                        break;
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.f8990H0.isOpening && smartRefreshLayout12.m8685v(smartRefreshLayout12.f8977B)) {
                        SmartRefreshLayout.this.m8631a(EnumC2879b.LoadReleased);
                        break;
                    } else {
                        SmartRefreshLayout.this.setViceState(EnumC2879b.LoadReleased);
                        break;
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.m8676m();
                    break;
                case 12:
                    SmartRefreshLayout.this.m8674l();
                    break;
                case 13:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (smartRefreshLayout13.f8990H0 == EnumC2879b.Refreshing) {
                        smartRefreshLayout13.m8631a(EnumC2879b.RefreshFinish);
                        break;
                    }
                    break;
                case 14:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.f8990H0 == EnumC2879b.Loading) {
                        smartRefreshLayout14.m8631a(EnumC2879b.LoadFinish);
                        break;
                    }
                    break;
                case 15:
                    SmartRefreshLayout.this.m8631a(EnumC2879b.TwoLevelReleased);
                    break;
                case 16:
                    SmartRefreshLayout.this.m8631a(EnumC2879b.TwoLevelFinish);
                    break;
                case 17:
                    SmartRefreshLayout.this.m8631a(EnumC2879b.TwoLevel);
                    break;
            }
            return null;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: b */
        public InterfaceC2875i mo8697b(@NonNull InterfaceC2874h interfaceC2874h, boolean z) {
            if (interfaceC2874h.equals(SmartRefreshLayout.this.f8976A0)) {
                SmartRefreshLayout.this.f9000M0 = z;
            } else if (interfaceC2874h.equals(SmartRefreshLayout.this.f8978B0)) {
                SmartRefreshLayout.this.f9002N0 = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: b */
        public InterfaceC2875i mo8696b(int i2) {
            SmartRefreshLayout.this.f9016e = i2;
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8694a(boolean z) {
            if (z) {
                a aVar = new a();
                ValueAnimator mo8687a = mo8687a(SmartRefreshLayout.this.getMeasuredHeight());
                if (mo8687a != null) {
                    if (mo8687a == SmartRefreshLayout.this.f9008S0) {
                        mo8687a.setDuration(r1.f9016e);
                        mo8687a.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (mo8687a(0) == null) {
                SmartRefreshLayout.this.m8631a(EnumC2879b.None);
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8689a(int i2, boolean z) {
            InterfaceC2883c interfaceC2883c;
            InterfaceC2883c interfaceC2883c2;
            InterfaceC2874h interfaceC2874h;
            InterfaceC2874h interfaceC2874h2;
            SmartRefreshLayout smartRefreshLayout;
            InterfaceC2874h interfaceC2874h3;
            InterfaceC2874h interfaceC2874h4;
            InterfaceC2874h interfaceC2874h5;
            InterfaceC2874h interfaceC2874h6;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.f9010b == i2 && (((interfaceC2874h5 = smartRefreshLayout2.f8976A0) == null || !interfaceC2874h5.mo8718a()) && ((interfaceC2874h6 = SmartRefreshLayout.this.f8978B0) == null || !interfaceC2874h6.mo8718a()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout3.f9010b;
            smartRefreshLayout3.f9010b = i2;
            if (z && smartRefreshLayout3.f8992I0.isDragging) {
                if (smartRefreshLayout3.f9010b > smartRefreshLayout3.f9041q0 * smartRefreshLayout3.f9057y0) {
                    if (smartRefreshLayout3.f8990H0 != EnumC2879b.ReleaseToTwoLevel) {
                        smartRefreshLayout3.f8986F0.mo8693a(EnumC2879b.ReleaseToRefresh);
                    }
                } else if ((-r2) > smartRefreshLayout3.f9045s0 * smartRefreshLayout3.f9059z0 && !smartRefreshLayout3.f9015d0) {
                    smartRefreshLayout3.f8986F0.mo8693a(EnumC2879b.ReleaseToLoad);
                } else {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.f9010b < 0 && !smartRefreshLayout4.f9015d0) {
                        smartRefreshLayout4.f8986F0.mo8693a(EnumC2879b.PullUpToLoad);
                    } else {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.f9010b > 0) {
                            smartRefreshLayout5.f8986F0.mo8693a(EnumC2879b.PullDownToRefresh);
                        }
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
            if (smartRefreshLayout6.f8980C0 != null) {
                Integer num = null;
                if (i2 >= 0 && (interfaceC2874h4 = smartRefreshLayout6.f8976A0) != null) {
                    if (smartRefreshLayout6.m8636a(smartRefreshLayout6.f8983E, interfaceC2874h4)) {
                        num = Integer.valueOf(i2);
                    } else if (i3 < 0) {
                        num = 0;
                    }
                }
                if (i2 <= 0 && (interfaceC2874h3 = (smartRefreshLayout = SmartRefreshLayout.this).f8978B0) != null) {
                    if (smartRefreshLayout.m8636a(smartRefreshLayout.f8985F, interfaceC2874h3)) {
                        num = Integer.valueOf(i2);
                    } else if (i3 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    InterfaceC2871e interfaceC2871e = SmartRefreshLayout.this.f8980C0;
                    int intValue = num.intValue();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    interfaceC2871e.mo8704a(intValue, smartRefreshLayout7.f9042r, smartRefreshLayout7.f9044s);
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    boolean z2 = (smartRefreshLayout8.f8979C && (interfaceC2874h2 = smartRefreshLayout8.f8976A0) != null && interfaceC2874h2.getSpinnerStyle() == EnumC2880c.FixedBehind) || SmartRefreshLayout.this.f8996K0 != 0;
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    boolean z3 = (smartRefreshLayout9.f8981D && (interfaceC2874h = smartRefreshLayout9.f8978B0) != null && interfaceC2874h.getSpinnerStyle() == EnumC2880c.FixedBehind) || SmartRefreshLayout.this.f8998L0 != 0;
                    if ((z2 && (num.intValue() >= 0 || i3 > 0)) || (z3 && (num.intValue() <= 0 || i3 < 0))) {
                        smartRefreshLayout3.invalidate();
                    }
                }
            }
            if ((i2 >= 0 || i3 > 0) && SmartRefreshLayout.this.f8976A0 != null) {
                int max = Math.max(i2, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout10.f9041q0;
                int i5 = (int) (i4 * smartRefreshLayout10.f9053w0);
                float f2 = (max * 1.0f) / (i4 == 0 ? 1 : i4);
                SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                if (smartRefreshLayout11.m8685v(smartRefreshLayout11.f8975A) || (SmartRefreshLayout.this.f8990H0 == EnumC2879b.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout12.f9010b) {
                        if (smartRefreshLayout12.f8976A0.getSpinnerStyle() == EnumC2880c.Translate) {
                            SmartRefreshLayout.this.f8976A0.getView().setTranslationY(SmartRefreshLayout.this.f9010b);
                            SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                            if (smartRefreshLayout13.f8996K0 != 0 && smartRefreshLayout13.f8982D0 != null && !smartRefreshLayout13.m8636a(smartRefreshLayout13.f8983E, smartRefreshLayout13.f8976A0)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.f8976A0.getSpinnerStyle() == EnumC2880c.Scale) {
                            SmartRefreshLayout.this.f8976A0.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.f8976A0.mo8717a(z, f2, max, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.f8976A0.mo8718a()) {
                        int i6 = (int) SmartRefreshLayout.this.f9026j;
                        int width = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout.this.f8976A0.mo8714a(SmartRefreshLayout.this.f9026j / (width == 0 ? 1 : width), i6, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout14.f9010b && (interfaceC2883c = smartRefreshLayout14.f9027j0) != null) {
                    InterfaceC2874h interfaceC2874h7 = smartRefreshLayout14.f8976A0;
                    if (interfaceC2874h7 instanceof InterfaceC2873g) {
                        interfaceC2883c.mo8729a((InterfaceC2873g) interfaceC2874h7, z, f2, max, i4, i5);
                    }
                }
            }
            if ((i2 <= 0 || i3 < 0) && SmartRefreshLayout.this.f8978B0 != null) {
                int i7 = -Math.min(i2, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i8 = smartRefreshLayout15.f9045s0;
                int i9 = (int) (i8 * smartRefreshLayout15.f9055x0);
                float f3 = (i7 * 1.0f) / (i8 == 0 ? 1 : i8);
                SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                if (smartRefreshLayout16.m8685v(smartRefreshLayout16.f8977B) || (SmartRefreshLayout.this.f8990H0 == EnumC2879b.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout17.f9010b) {
                        if (smartRefreshLayout17.f8978B0.getSpinnerStyle() == EnumC2880c.Translate) {
                            SmartRefreshLayout.this.f8978B0.getView().setTranslationY(SmartRefreshLayout.this.f9010b);
                            SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                            if (smartRefreshLayout18.f8998L0 != 0 && smartRefreshLayout18.f8982D0 != null && !smartRefreshLayout18.m8636a(smartRefreshLayout18.f8985F, smartRefreshLayout18.f8978B0)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.f8978B0.getSpinnerStyle() == EnumC2880c.Scale) {
                            SmartRefreshLayout.this.f8978B0.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.f8978B0.mo8717a(z, f3, i7, i8, i9);
                    }
                    if (z && SmartRefreshLayout.this.f8978B0.mo8718a()) {
                        int i10 = (int) SmartRefreshLayout.this.f9026j;
                        int width2 = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout.this.f8978B0.mo8714a(SmartRefreshLayout.this.f9026j / (width2 != 0 ? width2 : 1), i10, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout19.f9010b && (interfaceC2883c2 = smartRefreshLayout19.f9027j0) != null) {
                    InterfaceC2874h interfaceC2874h8 = smartRefreshLayout19.f8978B0;
                    if (interfaceC2874h8 instanceof InterfaceC2872f) {
                        interfaceC2883c2.mo8726a((InterfaceC2872f) interfaceC2874h8, z, f3, i7, i8, i9);
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public ValueAnimator mo8687a(int i2) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.m8613a(i2, 0, smartRefreshLayout.f9056y, smartRefreshLayout.f9018f);
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8691a(@NonNull InterfaceC2874h interfaceC2874h, int i2) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f8982D0 == null && i2 != 0) {
                smartRefreshLayout.f8982D0 = new Paint();
            }
            if (interfaceC2874h.equals(SmartRefreshLayout.this.f8976A0)) {
                SmartRefreshLayout.this.f8996K0 = i2;
            } else if (interfaceC2874h.equals(SmartRefreshLayout.this.f8978B0)) {
                SmartRefreshLayout.this.f8998L0 = i2;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8692a(@NonNull InterfaceC2874h interfaceC2874h, boolean z) {
            if (interfaceC2874h.equals(SmartRefreshLayout.this.f8976A0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.f9019f0) {
                    smartRefreshLayout.f9019f0 = true;
                    smartRefreshLayout.f8983E = z;
                }
            } else if (interfaceC2874h.equals(SmartRefreshLayout.this.f8978B0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.f9021g0) {
                    smartRefreshLayout2.f9021g0 = true;
                    smartRefreshLayout2.f8985F = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2875i
        /* renamed from: a */
        public InterfaceC2875i mo8690a(@NonNull InterfaceC2874h interfaceC2874h) {
            if (interfaceC2874h.equals(SmartRefreshLayout.this.f8976A0)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                EnumC2878a enumC2878a = smartRefreshLayout.f9043r0;
                if (enumC2878a.notified) {
                    smartRefreshLayout.f9043r0 = enumC2878a.unNotify();
                }
            } else if (interfaceC2874h.equals(SmartRefreshLayout.this.f8978B0)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                EnumC2878a enumC2878a2 = smartRefreshLayout2.f9047t0;
                if (enumC2878a2.notified) {
                    smartRefreshLayout2.f9047t0 = enumC2878a2.unNotify();
                }
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull InterfaceC2867a interfaceC2867a) {
        f8972T0 = interfaceC2867a;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull InterfaceC2868b interfaceC2868b) {
        f8973U0 = interfaceC2868b;
    }

    public static void setDefaultRefreshInitializer(@NonNull InterfaceC2869c interfaceC2869c) {
        f8974V0 = interfaceC2869c;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C2864m;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f9052w.getCurrY();
        if (this.f9052w.computeScrollOffset()) {
            int finalY = this.f9052w.getFinalY();
            if ((finalY >= 0 || !((this.f8993J || m8685v(this.f8975A)) && this.f8980C0.mo8708a())) && (finalY <= 0 || !((this.f8993J || m8685v(this.f8977B)) && this.f8980C0.mo8710b()))) {
                this.f9005P0 = true;
                invalidate();
            } else {
                if (this.f9005P0) {
                    m8669j(Build.VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.f9052w.getCurrVelocity() : this.f9052w.getCurrVelocity() : ((this.f9052w.getCurrY() - finalY) * 1.0f) / Math.max(this.f9052w.getDuration() - this.f9052w.timePassed(), 1));
                }
                this.f9052w.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ce, code lost:
    
        if (r4.isFinishing == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d4, code lost:
    
        if (r22.f8990H0.isHeader == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e2, code lost:
    
        if (r4.isFinishing == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e8, code lost:
    
        if (r22.f8990H0.isFooter == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0116, code lost:
    
        if (r6 != 3) goto L230;
     */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02cb  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        InterfaceC2871e interfaceC2871e = this.f8980C0;
        View view2 = interfaceC2871e != null ? interfaceC2871e.getView() : null;
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null && interfaceC2874h.getView() == view) {
            if (!m8685v(this.f8975A) || (!this.f8989H && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.f9010b, view.getTop());
                int i2 = this.f8996K0;
                if (i2 != 0 && (paint2 = this.f8982D0) != null) {
                    paint2.setColor(i2);
                    if (this.f8976A0.getSpinnerStyle() == EnumC2880c.Scale) {
                        max = view.getBottom();
                    } else if (this.f8976A0.getSpinnerStyle() == EnumC2880c.Translate) {
                        max = view.getBottom() + this.f9010b;
                    }
                    canvas.drawRect(view.getLeft(), view.getTop(), view.getRight(), max, this.f8982D0);
                }
                if (this.f8979C && this.f8976A0.getSpinnerStyle() == EnumC2880c.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        InterfaceC2874h interfaceC2874h2 = this.f8978B0;
        if (interfaceC2874h2 != null && interfaceC2874h2.getView() == view) {
            if (!m8685v(this.f8977B) || (!this.f8989H && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f9010b, view.getBottom());
                int i3 = this.f8998L0;
                if (i3 != 0 && (paint = this.f8982D0) != null) {
                    paint.setColor(i3);
                    if (this.f8978B0.getSpinnerStyle() == EnumC2880c.Scale) {
                        min = view.getTop();
                    } else if (this.f8978B0.getSpinnerStyle() == EnumC2880c.Translate) {
                        min = view.getTop() + this.f9010b;
                    }
                    canvas.drawRect(view.getLeft(), min, view.getRight(), view.getBottom(), this.f8982D0);
                }
                if (this.f8981D && this.f8978B0.getSpinnerStyle() == EnumC2880c.FixedBehind) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    public SmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f9039p0.getNestedScrollAxes();
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Nullable
    public InterfaceC2872f getRefreshFooter() {
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if (interfaceC2874h instanceof InterfaceC2872f) {
            return (InterfaceC2872f) interfaceC2874h;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Nullable
    public InterfaceC2873g getRefreshHeader() {
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h instanceof InterfaceC2873g) {
            return (InterfaceC2873g) interfaceC2874h;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    public EnumC2879b getState() {
        return this.f8990H0;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f9037o0.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        InterfaceC2874h interfaceC2874h;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (this.f8984E0 == null) {
                this.f8984E0 = new Handler();
            }
            List<RunnableC2888a> list = this.f8988G0;
            if (list != null) {
                for (RunnableC2888a runnableC2888a : list) {
                    this.f8984E0.postDelayed(runnableC2888a, runnableC2888a.f9114a);
                }
                this.f8988G0.clear();
                this.f8988G0 = null;
            }
            if (this.f8976A0 == null) {
                InterfaceC2868b interfaceC2868b = f8973U0;
                if (interfaceC2868b != null) {
                    mo8622a(interfaceC2868b.m8700a(getContext(), this));
                } else {
                    mo8622a(new BezierRadarHeader(getContext()));
                }
            }
            if (this.f8978B0 == null) {
                InterfaceC2867a interfaceC2867a = f8972T0;
                if (interfaceC2867a != null) {
                    mo8620a(interfaceC2867a.m8699a(getContext(), this));
                } else {
                    boolean z = this.f8977B;
                    mo8620a(new BallPulseFooter(getContext()));
                    this.f8977B = z;
                }
            } else {
                this.f8977B = this.f8977B || !this.f9017e0;
            }
            if (this.f8980C0 == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    InterfaceC2874h interfaceC2874h2 = this.f8976A0;
                    if ((interfaceC2874h2 == null || childAt != interfaceC2874h2.getView()) && ((interfaceC2874h = this.f8978B0) == null || childAt != interfaceC2874h.getView())) {
                        this.f8980C0 = new C2900a(childAt);
                    }
                }
            }
            if (this.f8980C0 == null) {
                int m8735b = C2889b.m8735b(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(C2851R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                this.f8980C0 = new C2900a(textView);
                this.f8980C0.getView().setPadding(m8735b, m8735b, m8735b, m8735b);
            }
            int i3 = this.f9038p;
            View findViewById = i3 > 0 ? findViewById(i3) : null;
            int i4 = this.f9040q;
            View findViewById2 = i4 > 0 ? findViewById(i4) : null;
            this.f8980C0.mo8707a(this.f9029k0);
            this.f8980C0.mo8709b(this.f9003O);
            this.f8980C0.mo8706a(this.f8986F0, findViewById, findViewById2);
            if (this.f9010b != 0) {
                m8631a(EnumC2879b.None);
                InterfaceC2871e interfaceC2871e = this.f8980C0;
                this.f9010b = 0;
                interfaceC2871e.mo8704a(0, this.f9042r, this.f9044s);
            }
        }
        int[] iArr = this.f9058z;
        if (iArr != null) {
            InterfaceC2874h interfaceC2874h3 = this.f8976A0;
            if (interfaceC2874h3 != null) {
                interfaceC2874h3.setPrimaryColors(iArr);
            }
            InterfaceC2874h interfaceC2874h4 = this.f8978B0;
            if (interfaceC2874h4 != null) {
                interfaceC2874h4.setPrimaryColors(this.f9058z);
            }
        }
        InterfaceC2871e interfaceC2871e2 = this.f8980C0;
        if (interfaceC2871e2 != null) {
            super.bringChildToFront(interfaceC2871e2.getView());
        }
        InterfaceC2874h interfaceC2874h5 = this.f8976A0;
        if (interfaceC2874h5 != null && interfaceC2874h5.getSpinnerStyle() != EnumC2880c.FixedBehind) {
            super.bringChildToFront(this.f8976A0.getView());
        }
        InterfaceC2874h interfaceC2874h6 = this.f8978B0;
        if (interfaceC2874h6 == null || interfaceC2874h6.getSpinnerStyle() == EnumC2880c.FixedBehind) {
            return;
        }
        super.bringChildToFront(this.f8978B0.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8986F0.mo8689a(0, true);
        m8631a(EnumC2879b.None);
        Handler handler = this.f8984E0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f8984E0 = null;
        }
        List<RunnableC2888a> list = this.f8988G0;
        if (list != null) {
            list.clear();
            this.f8988G0 = null;
        }
        this.f9017e0 = true;
        this.f9007R0 = null;
        ValueAnimator valueAnimator = this.f9008S0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f9008S0.removeAllUpdateListeners();
            this.f9008S0.cancel();
            this.f9008S0 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L9e
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = 0
        Lf:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L33
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = com.scwang.smartrefresh.layout.p192e.AbstractC2892e.m8748a(r9)
            if (r10 == 0) goto L24
            if (r6 < r7) goto L21
            if (r4 != r8) goto L24
        L21:
            r5 = r4
            r6 = 2
            goto L30
        L24:
            boolean r7 = r9 instanceof com.scwang.smartrefresh.layout.p189b.InterfaceC2874h
            if (r7 != 0) goto L30
            if (r6 >= r8) goto L30
            if (r4 <= 0) goto L2d
            goto L2e
        L2d:
            r8 = 0
        L2e:
            r5 = r4
            r6 = r8
        L30:
            int r4 = r4 + 1
            goto Lf
        L33:
            if (r5 < 0) goto L4d
            com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.f8980C0 = r4
            if (r5 != r8) goto L48
            if (r0 != r1) goto L46
            r1 = 0
            goto L4f
        L46:
            r1 = 0
            goto L4e
        L48:
            if (r0 != r7) goto L4d
            r1 = -1
            r7 = 1
            goto L4f
        L4d:
            r1 = -1
        L4e:
            r7 = -1
        L4f:
            r4 = 0
        L50:
            if (r4 >= r0) goto L9d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L8b
            if (r4 == r7) goto L65
            if (r1 != r2) goto L65
            com.scwang.smartrefresh.layout.b.h r6 = r11.f8976A0
            if (r6 != 0) goto L65
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p189b.InterfaceC2873g
            if (r6 == 0) goto L65
            goto L8b
        L65:
            if (r4 == r7) goto L6d
            if (r7 != r2) goto L9a
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p189b.InterfaceC2872f
            if (r6 == 0) goto L9a
        L6d:
            boolean r6 = r11.f8977B
            if (r6 != 0) goto L78
            boolean r6 = r11.f9017e0
            if (r6 != 0) goto L76
            goto L78
        L76:
            r6 = 0
            goto L79
        L78:
            r6 = 1
        L79:
            r11.f8977B = r6
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p189b.InterfaceC2872f
            if (r6 == 0) goto L82
            com.scwang.smartrefresh.layout.b.f r5 = (com.scwang.smartrefresh.layout.p189b.InterfaceC2872f) r5
            goto L88
        L82:
            com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L88:
            r11.f8978B0 = r5
            goto L9a
        L8b:
            boolean r6 = r5 instanceof com.scwang.smartrefresh.layout.p189b.InterfaceC2873g
            if (r6 == 0) goto L92
            com.scwang.smartrefresh.layout.b.g r5 = (com.scwang.smartrefresh.layout.p189b.InterfaceC2873g) r5
            goto L98
        L92:
            com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L98:
            r11.f8976A0 = r5
        L9a:
            int r4 = r4 + 1
            goto L50
        L9d:
            return
        L9e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            InterfaceC2871e interfaceC2871e = this.f8980C0;
            if (interfaceC2871e != null && interfaceC2871e.getView() == childAt) {
                boolean z2 = isInEditMode() && this.f8989H && m8685v(this.f8975A) && this.f8976A0 != null;
                View view = this.f8980C0.getView();
                C2864m c2864m = (C2864m) view.getLayoutParams();
                int i8 = ((ViewGroup.MarginLayoutParams) c2864m).leftMargin + paddingLeft;
                int i9 = ((ViewGroup.MarginLayoutParams) c2864m).topMargin + paddingTop;
                int measuredWidth = view.getMeasuredWidth() + i8;
                int measuredHeight = view.getMeasuredHeight() + i9;
                if (z2 && m8636a(this.f8983E, this.f8976A0)) {
                    int i10 = this.f9041q0;
                    i9 += i10;
                    measuredHeight += i10;
                }
                view.layout(i8, i9, measuredWidth, measuredHeight);
            }
            InterfaceC2874h interfaceC2874h = this.f8976A0;
            if (interfaceC2874h != null && interfaceC2874h.getView() == childAt) {
                boolean z3 = isInEditMode() && this.f8989H && m8685v(this.f8975A);
                View view2 = this.f8976A0.getView();
                C2864m c2864m2 = (C2864m) view2.getLayoutParams();
                int i11 = ((ViewGroup.MarginLayoutParams) c2864m2).leftMargin;
                int i12 = ((ViewGroup.MarginLayoutParams) c2864m2).topMargin + this.f9049u0;
                int measuredWidth2 = view2.getMeasuredWidth() + i11;
                int measuredHeight2 = view2.getMeasuredHeight() + i12;
                if (!z3 && this.f8976A0.getSpinnerStyle() == EnumC2880c.Translate) {
                    int i13 = this.f9041q0;
                    i12 -= i13;
                    measuredHeight2 -= i13;
                }
                view2.layout(i11, i12, measuredWidth2, measuredHeight2);
            }
            InterfaceC2874h interfaceC2874h2 = this.f8978B0;
            if (interfaceC2874h2 != null && interfaceC2874h2.getView() == childAt) {
                boolean z4 = isInEditMode() && this.f8989H && m8685v(this.f8977B);
                View view3 = this.f8978B0.getView();
                C2864m c2864m3 = (C2864m) view3.getLayoutParams();
                EnumC2880c spinnerStyle = this.f8978B0.getSpinnerStyle();
                int i14 = ((ViewGroup.MarginLayoutParams) c2864m3).leftMargin;
                int measuredHeight3 = ((ViewGroup.MarginLayoutParams) c2864m3).topMargin + getMeasuredHeight();
                int i15 = this.f9051v0;
                int i16 = measuredHeight3 - i15;
                if (spinnerStyle == EnumC2880c.MatchLayout) {
                    i16 = ((ViewGroup.MarginLayoutParams) c2864m3).topMargin - i15;
                } else {
                    if (z4 || spinnerStyle == EnumC2880c.FixedFront || spinnerStyle == EnumC2880c.FixedBehind) {
                        i6 = this.f9045s0;
                    } else if (spinnerStyle == EnumC2880c.Scale && this.f9010b < 0) {
                        i6 = Math.max(m8685v(this.f8977B) ? -this.f9010b : 0, 0);
                    }
                    i16 -= i6;
                }
                view3.layout(i14, i16, view3.getMeasuredWidth() + i14, view3.getMeasuredHeight() + i16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.f9037o0.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.f9004O0 && f3 > 0.0f) || m8635a(Float.valueOf(-f3)) || this.f9037o0.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        int i4;
        int i5 = this.f9031l0;
        if (i3 * i5 > 0) {
            if (Math.abs(i3) > Math.abs(this.f9031l0)) {
                i4 = this.f9031l0;
                this.f9031l0 = 0;
            } else {
                this.f9031l0 -= i3;
                i4 = i3;
            }
            m8672k(this.f9031l0);
            EnumC2879b enumC2879b = this.f8992I0;
            if (enumC2879b.isOpening || enumC2879b == EnumC2879b.None) {
                if (this.f9010b > 0) {
                    this.f8986F0.mo8693a(EnumC2879b.PullDownToRefresh);
                } else {
                    this.f8986F0.mo8693a(EnumC2879b.PullUpToLoad);
                }
            }
        } else if (i3 <= 0 || !this.f9004O0) {
            i4 = 0;
        } else {
            this.f9031l0 = i5 - i3;
            m8672k(this.f9031l0);
            i4 = i3;
        }
        this.f9037o0.dispatchNestedPreScroll(i2, i3 - i4, iArr, null);
        iArr[1] = iArr[1] + i4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        this.f9037o0.dispatchNestedScroll(i2, i3, i4, i5, this.f9035n0);
        int i6 = i5 + this.f9035n0[1];
        if (i6 != 0 && (this.f8993J || ((i6 < 0 && m8685v(this.f8975A)) || (i6 > 0 && m8685v(this.f8977B))))) {
            if (this.f8992I0 == EnumC2879b.None) {
                this.f8986F0.mo8693a(i6 > 0 ? EnumC2879b.PullUpToLoad : EnumC2879b.PullDownToRefresh);
            }
            int i7 = this.f9031l0 - i6;
            this.f9031l0 = i7;
            m8672k(i7);
        }
        if (!this.f9004O0 || i3 >= 0) {
            return;
        }
        this.f9004O0 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.f9039p0.onNestedScrollAccepted(view, view2, i2);
        this.f9037o0.startNestedScroll(i2 & 2);
        this.f9031l0 = this.f9010b;
        this.f9033m0 = true;
        m8657f(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.f8993J || m8685v(this.f8975A) || m8685v(this.f8977B));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.f9039p0.onStopNestedScroll(view);
        this.f9033m0 = false;
        this.f9031l0 = 0;
        m8668j();
        this.f9037o0.stopNestedScroll();
    }

    @Override // android.view.View
    public boolean post(@NonNull Runnable runnable) {
        Handler handler = this.f8984E0;
        if (handler != null) {
            return handler.post(new RunnableC2888a(runnable, 0L));
        }
        List<RunnableC2888a> list = this.f8988G0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f8988G0 = list;
        this.f8988G0.add(new RunnableC2888a(runnable, 0L));
        return false;
    }

    @Override // android.view.View
    public boolean postDelayed(@NonNull Runnable runnable, long j2) {
        if (j2 == 0) {
            new RunnableC2888a(runnable, 0L).run();
            return true;
        }
        Handler handler = this.f8984E0;
        if (handler != null) {
            return handler.postDelayed(new RunnableC2888a(runnable, 0L), j2);
        }
        List<RunnableC2888a> list = this.f8988G0;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f8988G0 = list;
        this.f8988G0.add(new RunnableC2888a(runnable, j2));
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: q */
    public InterfaceC2876j mo8680q(boolean z) {
        this.f8987G = z;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f9037o0.setNestedScrollingEnabled(z);
    }

    protected void setStateDirectLoading(boolean z) {
        if (this.f8990H0 != EnumC2879b.Loading) {
            this.f8994J0 = System.currentTimeMillis();
            this.f9004O0 = true;
            m8631a(EnumC2879b.Loading);
            InterfaceC2882b interfaceC2882b = this.f9025i0;
            if (interfaceC2882b != null) {
                if (z) {
                    interfaceC2882b.mo8723b(this);
                }
            } else if (this.f9027j0 == null) {
                mo8651e(2000);
            }
            InterfaceC2874h interfaceC2874h = this.f8978B0;
            if (interfaceC2874h != null) {
                int i2 = this.f9045s0;
                interfaceC2874h.mo8716a(this, i2, (int) (this.f9055x0 * i2));
            }
            InterfaceC2883c interfaceC2883c = this.f9027j0;
            if (interfaceC2883c == null || !(this.f8978B0 instanceof InterfaceC2872f)) {
                return;
            }
            if (interfaceC2883c != null && z) {
                interfaceC2883c.mo8723b(this);
            }
            InterfaceC2883c interfaceC2883c2 = this.f9027j0;
            InterfaceC2872f interfaceC2872f = (InterfaceC2872f) this.f8978B0;
            int i3 = this.f9045s0;
            interfaceC2883c2.mo8724a(interfaceC2872f, i3, (int) (this.f9055x0 * i3));
        }
    }

    protected void setViceState(EnumC2879b enumC2879b) {
        EnumC2879b enumC2879b2 = this.f8990H0;
        if (enumC2879b2.isDragging && enumC2879b2.isHeader != enumC2879b.isHeader) {
            m8631a(EnumC2879b.None);
        }
        if (this.f8992I0 != enumC2879b) {
            this.f8992I0 = enumC2879b;
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: u */
    public InterfaceC2876j mo8684u(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    /* renamed from: v */
    protected boolean m8685v(boolean z) {
        return z && !this.f8997L;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C2864m generateDefaultLayoutParams() {
        return new C2864m(-1, -1);
    }

    /* renamed from: j */
    protected void m8669j(float f2) {
        EnumC2879b enumC2879b;
        if (this.f9008S0 == null) {
            if (f2 > 0.0f && ((enumC2879b = this.f8990H0) == EnumC2879b.Refreshing || enumC2879b == EnumC2879b.TwoLevel)) {
                this.f9007R0 = new RunnableC2862k(f2, this.f9041q0);
                return;
            }
            if (f2 < 0.0f && (this.f8990H0 == EnumC2879b.Loading || ((this.f8987G && this.f9015d0 && m8685v(this.f8977B)) || (this.f8995K && !this.f9015d0 && m8685v(this.f8977B) && this.f8990H0 != EnumC2879b.Refreshing)))) {
                this.f9007R0 = new RunnableC2862k(f2, -this.f9045s0);
            } else if (this.f9010b == 0 && this.f8991I) {
                this.f9007R0 = new RunnableC2862k(f2, 0);
            }
        }
    }

    /* renamed from: k */
    protected void m8671k() {
        EnumC2879b enumC2879b = this.f8990H0;
        EnumC2879b enumC2879b2 = EnumC2879b.None;
        if (enumC2879b != enumC2879b2 && this.f9010b == 0) {
            m8631a(enumC2879b2);
        }
        if (this.f9010b != 0) {
            this.f8986F0.mo8687a(0);
        }
    }

    /* renamed from: l */
    protected void m8674l() {
        C2853b c2853b = new C2853b();
        m8631a(EnumC2879b.LoadReleased);
        ValueAnimator mo8687a = this.f8986F0.mo8687a(-this.f9045s0);
        if (mo8687a != null) {
            mo8687a.addListener(c2853b);
        }
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if (interfaceC2874h != null) {
            int i2 = this.f9045s0;
            interfaceC2874h.mo8719b(this, i2, (int) (this.f9055x0 * i2));
        }
        InterfaceC2883c interfaceC2883c = this.f9027j0;
        if (interfaceC2883c != null) {
            InterfaceC2874h interfaceC2874h2 = this.f8978B0;
            if (interfaceC2874h2 instanceof InterfaceC2872f) {
                int i3 = this.f9045s0;
                interfaceC2883c.mo8730b((InterfaceC2872f) interfaceC2874h2, i3, (int) (this.f9055x0 * i3));
            }
        }
        if (mo8687a == null) {
            c2853b.onAnimationEnd(null);
        }
    }

    /* renamed from: m */
    protected void m8676m() {
        C2854c c2854c = new C2854c();
        m8631a(EnumC2879b.RefreshReleased);
        ValueAnimator mo8687a = this.f8986F0.mo8687a(this.f9041q0);
        if (mo8687a != null) {
            mo8687a.addListener(c2854c);
        }
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null) {
            int i2 = this.f9041q0;
            interfaceC2874h.mo8719b(this, i2, (int) (this.f9053w0 * i2));
        }
        InterfaceC2883c interfaceC2883c = this.f9027j0;
        if (interfaceC2883c != null) {
            InterfaceC2874h interfaceC2874h2 = this.f8976A0;
            if (interfaceC2874h2 instanceof InterfaceC2873g) {
                int i3 = this.f9041q0;
                interfaceC2883c.mo8727a((InterfaceC2873g) interfaceC2874h2, i3, (int) (this.f9053w0 * i3));
            }
        }
        if (mo8687a == null) {
            c2854c.onAnimationEnd(null);
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: n */
    public SmartRefreshLayout mo8677n(boolean z) {
        this.f8979C = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: o */
    public SmartRefreshLayout mo8678o(boolean z) {
        this.f8999M = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: p */
    public SmartRefreshLayout mo8679p(boolean z) {
        this.f8981D = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: r */
    public SmartRefreshLayout mo8681r(boolean z) {
        this.f9001N = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: s */
    public SmartRefreshLayout mo8682s(boolean z) {
        this.f9017e0 = true;
        this.f8977B = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    public SmartRefreshLayout setPrimaryColors(@ColorInt int... iArr) {
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null) {
            interfaceC2874h.setPrimaryColors(iArr);
        }
        InterfaceC2874h interfaceC2874h2 = this.f8978B0;
        if (interfaceC2874h2 != null) {
            interfaceC2874h2.setPrimaryColors(iArr);
        }
        this.f9058z = iArr;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Deprecated
    /* renamed from: t */
    public SmartRefreshLayout mo8683t(boolean z) {
        this.f8987G = z;
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9016e = 250;
        this.f9018f = 250;
        this.f9030l = 0.5f;
        this.f9032m = 'n';
        this.f9038p = -1;
        this.f9040q = -1;
        this.f9042r = -1;
        this.f9044s = -1;
        this.f8975A = true;
        this.f8977B = false;
        this.f8979C = true;
        this.f8981D = true;
        this.f8983E = true;
        this.f8985F = true;
        this.f8987G = false;
        this.f8989H = true;
        this.f8991I = true;
        this.f8993J = false;
        this.f8995K = true;
        this.f8997L = false;
        this.f8999M = true;
        this.f9001N = true;
        this.f9003O = true;
        this.f9011b0 = false;
        this.f9013c0 = false;
        this.f9015d0 = false;
        this.f9017e0 = false;
        this.f9019f0 = false;
        this.f9021g0 = false;
        this.f9035n0 = new int[2];
        this.f9037o0 = new NestedScrollingChildHelper(this);
        this.f9039p0 = new NestedScrollingParentHelper(this);
        EnumC2878a enumC2878a = EnumC2878a.DefaultUnNotify;
        this.f9043r0 = enumC2878a;
        this.f9047t0 = enumC2878a;
        this.f9053w0 = 2.5f;
        this.f9055x0 = 2.5f;
        this.f9057y0 = 1.0f;
        this.f9059z0 = 1.0f;
        this.f8986F0 = new C2865n();
        EnumC2879b enumC2879b = EnumC2879b.None;
        this.f8990H0 = enumC2879b;
        this.f8992I0 = enumC2879b;
        this.f8994J0 = 0L;
        this.f8996K0 = 0;
        this.f8998L0 = 0;
        this.f9004O0 = false;
        this.f9005P0 = false;
        this.f9006Q0 = null;
        super.setClipToPadding(false);
        C2889b c2889b = new C2889b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f9052w = new Scroller(context);
        this.f9054x = VelocityTracker.obtain();
        this.f9020g = context.getResources().getDisplayMetrics().heightPixels;
        this.f9056y = new InterpolatorC2893f();
        this.f9009a = viewConfiguration.getScaledTouchSlop();
        this.f9046t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9048u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f9045s0 = c2889b.m8737a(60.0f);
        this.f9041q0 = c2889b.m8737a(100.0f);
        this.f9037o0.setNestedScrollingEnabled(true);
        InterfaceC2869c interfaceC2869c = f8974V0;
        if (interfaceC2869c != null) {
            interfaceC2869c.m8701a(context, this);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.SmartRefreshLayout);
        NestedScrollingChildHelper nestedScrollingChildHelper = this.f9037o0;
        nestedScrollingChildHelper.setNestedScrollingEnabled(obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, nestedScrollingChildHelper.isNestedScrollingEnabled()));
        this.f9030l = obtainStyledAttributes.getFloat(C2851R.styleable.SmartRefreshLayout_srlDragRate, this.f9030l);
        this.f9053w0 = obtainStyledAttributes.getFloat(C2851R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f9053w0);
        this.f9055x0 = obtainStyledAttributes.getFloat(C2851R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f9055x0);
        this.f9057y0 = obtainStyledAttributes.getFloat(C2851R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f9057y0);
        this.f9059z0 = obtainStyledAttributes.getFloat(C2851R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f9059z0);
        this.f8975A = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableRefresh, this.f8975A);
        this.f9018f = obtainStyledAttributes.getInt(C2851R.styleable.SmartRefreshLayout_srlReboundDuration, this.f9018f);
        this.f8977B = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.f8977B);
        this.f9041q0 = obtainStyledAttributes.getDimensionPixelOffset(C2851R.styleable.SmartRefreshLayout_srlHeaderHeight, this.f9041q0);
        this.f9045s0 = obtainStyledAttributes.getDimensionPixelOffset(C2851R.styleable.SmartRefreshLayout_srlFooterHeight, this.f9045s0);
        this.f9049u0 = obtainStyledAttributes.getDimensionPixelOffset(C2851R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f9049u0);
        this.f9051v0 = obtainStyledAttributes.getDimensionPixelOffset(C2851R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.f9051v0);
        this.f9011b0 = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.f9011b0);
        this.f9013c0 = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.f9013c0);
        this.f8983E = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.f8983E);
        this.f8985F = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.f8985F);
        this.f8989H = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.f8989H);
        this.f8995K = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.f8995K);
        this.f8991I = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.f8991I);
        this.f8997L = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.f8997L);
        this.f8999M = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.f8999M);
        this.f9001N = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.f9001N);
        this.f9003O = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.f9003O);
        this.f8987G = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.f8987G);
        this.f8987G = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.f8987G);
        this.f8979C = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.f8979C);
        this.f8981D = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.f8981D);
        this.f8993J = obtainStyledAttributes.getBoolean(C2851R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.f8993J);
        this.f9038p = obtainStyledAttributes.getResourceId(C2851R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f9038p);
        this.f9040q = obtainStyledAttributes.getResourceId(C2851R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f9040q);
        this.f9042r = obtainStyledAttributes.getResourceId(C2851R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f9042r);
        this.f9044s = obtainStyledAttributes.getResourceId(C2851R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f9044s);
        if (this.f8997L && !obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag)) {
            this.f8993J = true;
        }
        this.f9017e0 = this.f9017e0 || obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.f9019f0 = this.f9019f0 || obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.f9021g0 = this.f9021g0 || obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.f9043r0 = obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlHeaderHeight) ? EnumC2878a.XmlLayoutUnNotify : this.f9043r0;
        this.f9047t0 = obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_srlFooterHeight) ? EnumC2878a.XmlLayoutUnNotify : this.f9047t0;
        int color = obtainStyledAttributes.getColor(C2851R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(C2851R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f9058z = new int[]{color2, color};
            } else {
                this.f9058z = new int[]{color2};
            }
        } else if (color != 0) {
            this.f9058z = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: f */
    protected boolean m8657f(int i2) {
        if (i2 == 0) {
            if (this.f9008S0 != null) {
                EnumC2879b enumC2879b = this.f8990H0;
                if (enumC2879b.isFinishing || enumC2879b == EnumC2879b.TwoLevelReleased) {
                    return true;
                }
                if (enumC2879b == EnumC2879b.PullDownCanceled) {
                    this.f8986F0.mo8693a(EnumC2879b.PullDownToRefresh);
                } else if (enumC2879b == EnumC2879b.PullUpCanceled) {
                    this.f8986F0.mo8693a(EnumC2879b.PullUpToLoad);
                }
                this.f9008S0.cancel();
                this.f9008S0 = null;
            }
            this.f9007R0 = null;
        }
        return this.f9008S0 != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C2864m generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C2864m(layoutParams);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: h */
    public SmartRefreshLayout mo8661h(float f2) {
        this.f9030l = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: i */
    public SmartRefreshLayout mo8664i(float f2) {
        if (this.f9043r0.canReplaceWith(EnumC2878a.CodeExact)) {
            this.f9041q0 = C2889b.m8735b(f2);
            this.f9043r0 = EnumC2878a.CodeExactUnNotify;
            InterfaceC2874h interfaceC2874h = this.f8976A0;
            if (interfaceC2874h != null) {
                interfaceC2874h.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: c */
    public SmartRefreshLayout mo8642c(float f2) {
        if (this.f9047t0.canReplaceWith(EnumC2878a.CodeExact)) {
            this.f9045s0 = C2889b.m8735b(f2);
            this.f9047t0 = EnumC2878a.CodeExactUnNotify;
            InterfaceC2874h interfaceC2874h = this.f8978B0;
            if (interfaceC2874h != null) {
                interfaceC2874h.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: e */
    public SmartRefreshLayout mo8650e(float f2) {
        this.f9051v0 = C2889b.m8735b(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: g */
    public SmartRefreshLayout mo8659g(float f2) {
        this.f9057y0 = f2;
        return this;
    }

    @Override // android.view.ViewGroup
    public C2864m generateLayoutParams(AttributeSet attributeSet) {
        return new C2864m(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: h */
    public SmartRefreshLayout mo8662h(boolean z) {
        this.f8975A = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: e */
    public SmartRefreshLayout mo8652e(boolean z) {
        return mo8615a(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8994J0))), 300) : 0, z);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: g */
    public SmartRefreshLayout mo8660g(boolean z) {
        this.f8993J = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: h */
    public boolean mo8663h() {
        int i2 = this.f8984E0 == null ? 400 : 0;
        int i3 = this.f9018f;
        float f2 = (this.f9053w0 / 2.0f) + 0.5f;
        int i4 = this.f9041q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return mo8641b(i2, i3, f3 / i4, true);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: b */
    public SmartRefreshLayout mo8638b(float f2) {
        this.f9059z0 = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: d */
    public SmartRefreshLayout mo8647d(float f2) {
        this.f9053w0 = f2;
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null && this.f8984E0 != null) {
            InterfaceC2875i interfaceC2875i = this.f8986F0;
            int i2 = this.f9041q0;
            interfaceC2874h.mo8715a(interfaceC2875i, i2, (int) (this.f9053w0 * i2));
        } else {
            this.f9043r0 = this.f9043r0.unNotify();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: g */
    public SmartRefreshLayout mo8658g() {
        return mo8648d(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8994J0))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: b */
    public SmartRefreshLayout mo8639b(int i2) {
        this.f9018f = i2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: e */
    public SmartRefreshLayout mo8651e(int i2) {
        return mo8616a(i2, true, false);
    }

    /* renamed from: k */
    protected void m8672k(float f2) {
        EnumC2879b enumC2879b;
        if (this.f8990H0 == EnumC2879b.TwoLevel && f2 > 0.0f) {
            this.f8986F0.mo8689a(Math.min((int) f2, getMeasuredHeight()), true);
        } else if (this.f8990H0 == EnumC2879b.Refreshing && f2 >= 0.0f) {
            int i2 = this.f9041q0;
            if (f2 < i2) {
                this.f8986F0.mo8689a((int) f2, true);
            } else {
                double d2 = (this.f9053w0 - 1.0f) * i2;
                int max = Math.max((this.f9020g * 4) / 3, getHeight());
                int i3 = this.f9041q0;
                double d3 = max - i3;
                double max2 = Math.max(0.0f, (f2 - i3) * this.f9030l);
                double d4 = -max2;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                this.f8986F0.mo8689a(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), max2)) + this.f9041q0, true);
            }
        } else if (f2 < 0.0f && (this.f8990H0 == EnumC2879b.Loading || ((this.f8987G && this.f9015d0 && m8685v(this.f8977B)) || (this.f8995K && !this.f9015d0 && m8685v(this.f8977B))))) {
            int i4 = this.f9045s0;
            if (f2 > (-i4)) {
                this.f8986F0.mo8689a((int) f2, true);
            } else {
                double d5 = (this.f9055x0 - 1.0f) * i4;
                int max3 = Math.max((this.f9020g * 4) / 3, getHeight());
                int i5 = this.f9045s0;
                double d6 = max3 - i5;
                double d7 = -Math.min(0.0f, (i5 + f2) * this.f9030l);
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                this.f8986F0.mo8689a(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.f9045s0, true);
            }
        } else if (f2 >= 0.0f) {
            double d9 = this.f9053w0 * this.f9041q0;
            double max4 = Math.max(this.f9020g / 2, getHeight());
            double max5 = Math.max(0.0f, this.f9030l * f2);
            double d10 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.f8986F0.mo8689a((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / max4)), max5), true);
        } else {
            double d11 = this.f9055x0 * this.f9045s0;
            double max6 = Math.max(this.f9020g / 2, getHeight());
            double d12 = -Math.min(0.0f, this.f9030l * f2);
            double d13 = -d12;
            if (max6 == 0.0d) {
                max6 = 1.0d;
            }
            this.f8986F0.mo8689a((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / max6)), d12)), true);
        }
        if (!this.f8995K || this.f9015d0 || !m8685v(this.f8977B) || f2 >= 0.0f || (enumC2879b = this.f8990H0) == EnumC2879b.Refreshing || enumC2879b == EnumC2879b.Loading || enumC2879b == EnumC2879b.LoadFinish) {
            return;
        }
        if (this.f9013c0) {
            this.f9007R0 = null;
            this.f8986F0.mo8687a(-this.f9045s0);
        }
        setStateDirectLoading(false);
        postDelayed(new RunnableC2857f(), this.f9018f);
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$m */
    public static class C2864m extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f9101a;

        /* renamed from: b */
        public EnumC2880c f9102b;

        public C2864m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9101a = 0;
            this.f9102b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2851R.styleable.SmartRefreshLayout_Layout);
            this.f9101a = obtainStyledAttributes.getColor(C2851R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f9101a);
            if (obtainStyledAttributes.hasValue(C2851R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f9102b = EnumC2880c.values()[obtainStyledAttributes.getInt(C2851R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, EnumC2880c.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public C2864m(int i2, int i3) {
            super(i2, i3);
            this.f9101a = 0;
            this.f9102b = null;
        }

        public C2864m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9101a = 0;
            this.f9102b = null;
        }

        public C2864m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9101a = 0;
            this.f9102b = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: b */
    public SmartRefreshLayout mo8640b(boolean z) {
        this.f9003O = z;
        InterfaceC2871e interfaceC2871e = this.f8980C0;
        if (interfaceC2871e != null) {
            interfaceC2871e.mo8709b(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: e */
    public boolean mo8653e() {
        int i2 = this.f8984E0 == null ? 400 : 0;
        int i3 = this.f9018f;
        float f2 = (this.f9053w0 / 2.0f) + 0.5f;
        int i4 = this.f9041q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return mo8641b(i2, i3, f3 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: i */
    public SmartRefreshLayout mo8665i(boolean z) {
        return mo8616a(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8994J0))), 300) : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: c */
    public SmartRefreshLayout mo8643c(boolean z) {
        this.f8991I = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: c */
    public InterfaceC2876j mo8644c() {
        EnumC2879b enumC2879b = this.f8990H0;
        if (enumC2879b == EnumC2879b.Refreshing) {
            mo8658g();
        } else if (enumC2879b == EnumC2879b.Loading) {
            mo8637b();
        } else if (this.f9010b != 0) {
            m8613a(0, 0, this.f9056y, this.f9018f);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: d */
    public SmartRefreshLayout mo8649d(boolean z) {
        this.f9011b0 = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: i */
    public boolean mo8666i() {
        int i2 = this.f9018f;
        int i3 = this.f9045s0;
        float f2 = i3 * ((this.f9055x0 / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return mo8634a(0, i2, f2 / i3, false);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: b */
    public SmartRefreshLayout mo8637b() {
        return mo8651e(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8994J0))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: d */
    public SmartRefreshLayout mo8648d(int i2) {
        return mo8615a(i2, true);
    }

    /* renamed from: j */
    protected void m8668j() {
        EnumC2879b enumC2879b = this.f8990H0;
        if (enumC2879b == EnumC2879b.TwoLevel) {
            if (this.f9050v > -1000 && this.f9010b > getMeasuredHeight() / 2) {
                ValueAnimator mo8687a = this.f8986F0.mo8687a(getMeasuredHeight());
                if (mo8687a != null) {
                    mo8687a.setDuration(this.f9016e);
                    return;
                }
                return;
            }
            if (this.f9034n) {
                this.f8986F0.mo8695b();
                return;
            }
            return;
        }
        if (enumC2879b != EnumC2879b.Loading && (!this.f8987G || !this.f9015d0 || this.f9010b >= 0 || !m8685v(this.f8977B))) {
            EnumC2879b enumC2879b2 = this.f8990H0;
            if (enumC2879b2 == EnumC2879b.Refreshing) {
                int i2 = this.f9010b;
                int i3 = this.f9041q0;
                if (i2 > i3) {
                    this.f8986F0.mo8687a(i3);
                    return;
                } else {
                    if (i2 < 0) {
                        this.f8986F0.mo8687a(0);
                        return;
                    }
                    return;
                }
            }
            if (enumC2879b2 == EnumC2879b.PullDownToRefresh) {
                this.f8986F0.mo8693a(EnumC2879b.PullDownCanceled);
                return;
            }
            if (enumC2879b2 == EnumC2879b.PullUpToLoad) {
                this.f8986F0.mo8693a(EnumC2879b.PullUpCanceled);
                return;
            }
            if (enumC2879b2 == EnumC2879b.ReleaseToRefresh) {
                this.f8986F0.mo8693a(EnumC2879b.Refreshing);
                return;
            }
            if (enumC2879b2 == EnumC2879b.ReleaseToLoad) {
                this.f8986F0.mo8693a(EnumC2879b.Loading);
                return;
            }
            if (enumC2879b2 == EnumC2879b.ReleaseToTwoLevel) {
                this.f8986F0.mo8693a(EnumC2879b.TwoLevelReleased);
                return;
            }
            if (enumC2879b2 == EnumC2879b.RefreshReleased) {
                if (this.f9008S0 == null) {
                    this.f8986F0.mo8687a(this.f9041q0);
                    return;
                }
                return;
            } else if (enumC2879b2 == EnumC2879b.LoadReleased) {
                if (this.f9008S0 == null) {
                    this.f8986F0.mo8687a(-this.f9045s0);
                    return;
                }
                return;
            } else {
                if (this.f9010b != 0) {
                    this.f8986F0.mo8687a(0);
                    return;
                }
                return;
            }
        }
        int i4 = this.f9010b;
        int i5 = this.f9045s0;
        if (i4 < (-i5)) {
            this.f8986F0.mo8687a(-i5);
        } else if (i4 > 0) {
            this.f8986F0.mo8687a(0);
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: l */
    public SmartRefreshLayout mo8673l(boolean z) {
        this.f8995K = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: m */
    public SmartRefreshLayout mo8675m(boolean z) {
        this.f9013c0 = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: d */
    public SmartRefreshLayout mo8646d() {
        return mo8616a(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f8994J0))), 300), true, true);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: b */
    public boolean mo8641b(int i2, int i3, float f2, boolean z) {
        if (this.f8990H0 != EnumC2879b.None || !m8685v(this.f8975A)) {
            return false;
        }
        ValueAnimator valueAnimator = this.f9008S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        RunnableC2860i runnableC2860i = new RunnableC2860i(f2, i3, z);
        if (i2 > 0) {
            this.f9008S0 = new ValueAnimator();
            postDelayed(runnableC2860i, i2);
            return true;
        }
        runnableC2860i.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: f */
    public SmartRefreshLayout mo8654f(float f2) {
        this.f9049u0 = C2889b.m8735b(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: f */
    public SmartRefreshLayout mo8655f(boolean z) {
        this.f8985F = z;
        this.f9021g0 = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Deprecated
    /* renamed from: c */
    public boolean mo8645c(int i2) {
        int i3 = this.f9018f;
        int i4 = this.f9045s0;
        float f2 = i4 * ((this.f9055x0 / 2.0f) + 0.5f) * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return mo8634a(i2, i3, f2 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: f */
    public InterfaceC2876j mo8656f() {
        this.f9015d0 = false;
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if ((interfaceC2874h instanceof InterfaceC2872f) && !((InterfaceC2872f) interfaceC2874h).mo8712a(false)) {
            System.out.println("Footer:" + this.f8978B0 + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    /* renamed from: a */
    protected boolean m8635a(Float f2) {
        float floatValue = f2 == null ? this.f9050v : f2.floatValue();
        if (Math.abs(floatValue) > this.f9046t) {
            int i2 = this.f9010b;
            if (i2 * floatValue < 0.0f) {
                EnumC2879b enumC2879b = this.f8990H0;
                if (enumC2879b.isOpening) {
                    if (enumC2879b != EnumC2879b.TwoLevel && enumC2879b != this.f8992I0) {
                        this.f9007R0 = new RunnableC2863l(floatValue).m8686a();
                        return true;
                    }
                } else if (i2 > this.f9041q0 * this.f9057y0 || (-i2) > this.f9045s0 * this.f9059z0) {
                    return true;
                }
            }
            if ((floatValue < 0.0f && ((this.f8991I && (this.f8993J || m8685v(this.f8977B))) || ((this.f8990H0 == EnumC2879b.Loading && this.f9010b >= 0) || (this.f8995K && m8685v(this.f8977B))))) || (floatValue > 0.0f && ((this.f8991I && (this.f8993J || m8685v(this.f8975A))) || (this.f8990H0 == EnumC2879b.Refreshing && this.f9010b <= 0)))) {
                this.f9005P0 = false;
                this.f9052w.fling(0, 0, 0, (int) (-floatValue), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f9052w.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* renamed from: a */
    protected void m8631a(EnumC2879b enumC2879b) {
        EnumC2879b enumC2879b2 = this.f8990H0;
        if (enumC2879b2 != enumC2879b) {
            this.f8990H0 = enumC2879b;
            this.f8992I0 = enumC2879b;
            InterfaceC2874h interfaceC2874h = this.f8976A0;
            InterfaceC2874h interfaceC2874h2 = this.f8978B0;
            InterfaceC2883c interfaceC2883c = this.f9027j0;
            if (interfaceC2874h != null) {
                interfaceC2874h.mo8733a(this, enumC2879b2, enumC2879b);
            }
            if (interfaceC2874h2 != null) {
                interfaceC2874h2.mo8733a(this, enumC2879b2, enumC2879b);
            }
            if (interfaceC2883c != null) {
                interfaceC2883c.mo8733a(this, enumC2879b2, enumC2879b);
            }
        }
    }

    /* renamed from: a */
    protected boolean m8636a(boolean z, InterfaceC2874h interfaceC2874h) {
        return z || this.f8997L || interfaceC2874h == null || interfaceC2874h.getSpinnerStyle() == EnumC2880c.FixedBehind;
    }

    /* renamed from: a */
    protected ValueAnimator m8613a(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.f9010b == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.f9008S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.f9007R0 = null;
        this.f9008S0 = ValueAnimator.ofInt(this.f9010b, i2);
        this.f9008S0.setDuration(i4);
        this.f9008S0.setInterpolator(interpolator);
        this.f9008S0.addListener(new C2855d());
        this.f9008S0.addUpdateListener(new C2856e());
        this.f9008S0.setStartDelay(i3);
        this.f9008S0.start();
        return this.f9008S0;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: k */
    public SmartRefreshLayout mo8670k(boolean z) {
        this.f8983E = z;
        this.f9019f0 = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: j */
    public SmartRefreshLayout mo8667j(boolean z) {
        this.f8997L = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8614a(float f2) {
        this.f9055x0 = f2;
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if (interfaceC2874h != null && this.f8984E0 != null) {
            InterfaceC2875i interfaceC2875i = this.f8986F0;
            int i2 = this.f9045s0;
            interfaceC2874h.mo8715a(interfaceC2875i, i2, (int) (i2 * this.f9055x0));
        } else {
            this.f9047t0 = this.f9047t0.unNotify();
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8619a(@NonNull Interpolator interpolator) {
        this.f9056y = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8622a(@NonNull InterfaceC2873g interfaceC2873g) {
        return mo8623a(interfaceC2873g, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8623a(@NonNull InterfaceC2873g interfaceC2873g, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null) {
            super.removeView(interfaceC2874h.getView());
        }
        this.f8976A0 = interfaceC2873g;
        this.f8996K0 = 0;
        this.f9000M0 = false;
        this.f9043r0 = this.f9043r0.unNotify();
        if (this.f8976A0.getSpinnerStyle() == EnumC2880c.FixedBehind) {
            super.addView(this.f8976A0.getView(), 0, new C2864m(i2, i3));
        } else {
            super.addView(this.f8976A0.getView(), i2, i3);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8620a(@NonNull InterfaceC2872f interfaceC2872f) {
        return mo8621a(interfaceC2872f, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8621a(@NonNull InterfaceC2872f interfaceC2872f, int i2, int i3) {
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if (interfaceC2874h != null) {
            super.removeView(interfaceC2874h.getView());
        }
        this.f8978B0 = interfaceC2872f;
        this.f8998L0 = 0;
        this.f9002N0 = false;
        this.f9047t0 = this.f9047t0.unNotify();
        this.f8977B = !this.f9017e0 || this.f8977B;
        if (this.f8978B0.getSpinnerStyle() == EnumC2880c.FixedBehind) {
            super.addView(this.f8978B0.getView(), 0, new C2864m(i2, i3));
        } else {
            super.addView(this.f8978B0.getView(), i2, i3);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8617a(@NonNull View view) {
        return mo8618a(view, -1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8618a(@NonNull View view, int i2, int i3) {
        InterfaceC2871e interfaceC2871e = this.f8980C0;
        if (interfaceC2871e != null) {
            super.removeView(interfaceC2871e.getView());
        }
        super.addView(view, 0, new C2864m(i2, i3));
        InterfaceC2874h interfaceC2874h = this.f8976A0;
        if (interfaceC2874h != null && interfaceC2874h.getSpinnerStyle() == EnumC2880c.FixedBehind) {
            super.bringChildToFront(view);
            InterfaceC2874h interfaceC2874h2 = this.f8978B0;
            if (interfaceC2874h2 != null && interfaceC2874h2.getSpinnerStyle() != EnumC2880c.FixedBehind) {
                super.bringChildToFront(this.f8978B0.getView());
            }
        } else {
            InterfaceC2874h interfaceC2874h3 = this.f8978B0;
            if (interfaceC2874h3 != null && interfaceC2874h3.getSpinnerStyle() == EnumC2880c.FixedBehind) {
                super.bringChildToFront(view);
                InterfaceC2874h interfaceC2874h4 = this.f8976A0;
                if (interfaceC2874h4 != null && interfaceC2874h4.getSpinnerStyle() == EnumC2880c.FixedBehind) {
                    super.bringChildToFront(this.f8976A0.getView());
                }
            }
        }
        this.f8980C0 = new C2900a(view);
        if (this.f8984E0 != null) {
            int i4 = this.f9038p;
            View findViewById = i4 > 0 ? findViewById(i4) : null;
            int i5 = this.f9040q;
            View findViewById2 = i5 > 0 ? findViewById(i5) : null;
            this.f8980C0.mo8707a(this.f9029k0);
            this.f8980C0.mo8709b(this.f9003O);
            this.f8980C0.mo8706a(this.f8986F0, findViewById, findViewById2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8627a(InterfaceC2884d interfaceC2884d) {
        this.f9023h0 = interfaceC2884d;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8625a(InterfaceC2882b interfaceC2882b) {
        this.f9025i0 = interfaceC2882b;
        this.f8977B = this.f8977B || !(this.f9017e0 || interfaceC2882b == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8628a(InterfaceC2885e interfaceC2885e) {
        this.f9023h0 = interfaceC2885e;
        this.f9025i0 = interfaceC2885e;
        this.f8977B = this.f8977B || !(this.f9017e0 || interfaceC2885e == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8626a(InterfaceC2883c interfaceC2883c) {
        this.f9027j0 = interfaceC2883c;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8630a(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = AbstractC2892e.m8745a(getContext(), iArr[i2]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8624a(InterfaceC2877k interfaceC2877k) {
        this.f9029k0 = interfaceC2877k;
        InterfaceC2871e interfaceC2871e = this.f8980C0;
        if (interfaceC2871e != null) {
            interfaceC2871e.mo8707a(interfaceC2877k);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Deprecated
    /* renamed from: a */
    public SmartRefreshLayout mo8629a(boolean z) {
        if (this.f8990H0 == EnumC2879b.Loading && z) {
            mo8637b();
        }
        this.f9015d0 = z;
        InterfaceC2874h interfaceC2874h = this.f8978B0;
        if ((interfaceC2874h instanceof InterfaceC2872f) && !((InterfaceC2872f) interfaceC2874h).mo8712a(z)) {
            System.out.println("Footer:" + this.f8978B0 + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)");
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8615a(int i2, boolean z) {
        if (this.f8990H0 == EnumC2879b.Refreshing && z) {
            mo8656f();
        }
        postDelayed(new RunnableC2858g(z), i2 <= 0 ? 1L : i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public SmartRefreshLayout mo8616a(int i2, boolean z, boolean z2) {
        postDelayed(new RunnableC2859h(z, z2), i2 <= 0 ? 1L : i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    @Deprecated
    /* renamed from: a */
    public boolean mo8633a(int i2) {
        int i3 = this.f9018f;
        float f2 = (this.f9053w0 / 2.0f) + 0.5f;
        int i4 = this.f9041q0;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return mo8641b(i2, i3, f3 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public boolean mo8632a() {
        int i2 = this.f9018f;
        int i3 = this.f9045s0;
        float f2 = i3 * ((this.f9055x0 / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return mo8634a(0, i2, f2 / i3, true);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2876j
    /* renamed from: a */
    public boolean mo8634a(int i2, int i3, float f2, boolean z) {
        if (this.f8990H0 != EnumC2879b.None || !m8685v(this.f8977B) || this.f9015d0) {
            return false;
        }
        ValueAnimator valueAnimator = this.f9008S0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        RunnableC2861j runnableC2861j = new RunnableC2861j(f2, i3, z);
        if (i2 > 0) {
            this.f9008S0 = new ValueAnimator();
            postDelayed(runnableC2861j, i2);
            return true;
        }
        runnableC2861j.run();
        return true;
    }
}
