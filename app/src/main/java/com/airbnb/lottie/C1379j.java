package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.p098a0.C1342s;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p100b0.ChoreographerFrameCallbackC1355e;
import com.airbnb.lottie.p101c0.C1362b;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p101c0.InterfaceC1372l;
import com.airbnb.lottie.p105x.C1432a;
import com.airbnb.lottie.p105x.C1433b;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.C1442h;
import com.airbnb.lottie.p106y.p109l.C1478b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: LottieDrawable.java */
/* renamed from: com.airbnb.lottie.j */
/* loaded from: classes.dex */
public class C1379j extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: x */
    public static final int f3253x = 1;

    /* renamed from: y */
    public static final int f3254y = 2;

    /* renamed from: z */
    public static final int f3255z = -1;

    /* renamed from: b */
    private C1376g f3257b;

    /* renamed from: j */
    @Nullable
    private C1433b f3265j;

    /* renamed from: k */
    @Nullable
    private String f3266k;

    /* renamed from: l */
    @Nullable
    private InterfaceC1373d f3267l;

    /* renamed from: m */
    @Nullable
    private C1432a f3268m;

    /* renamed from: n */
    @Nullable
    C1360c f3269n;

    /* renamed from: o */
    @Nullable
    C1391v f3270o;

    /* renamed from: p */
    private boolean f3271p;

    /* renamed from: q */
    @Nullable
    private C1478b f3272q;

    /* renamed from: s */
    private boolean f3274s;

    /* renamed from: t */
    private boolean f3275t;

    /* renamed from: u */
    private boolean f3276u;

    /* renamed from: a */
    private final Matrix f3256a = new Matrix();

    /* renamed from: c */
    private final ChoreographerFrameCallbackC1355e f3258c = new ChoreographerFrameCallbackC1355e();

    /* renamed from: d */
    private float f3259d = 1.0f;

    /* renamed from: e */
    private boolean f3260e = true;

    /* renamed from: f */
    private boolean f3261f = false;

    /* renamed from: g */
    private boolean f3262g = false;

    /* renamed from: h */
    private final ArrayList<r> f3263h = new ArrayList<>();

    /* renamed from: i */
    private final ValueAnimator.AnimatorUpdateListener f3264i = new i();

    /* renamed from: r */
    private int f3273r = 255;

    /* renamed from: v */
    private boolean f3277v = true;

    /* renamed from: w */
    private boolean f3278w = false;

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$a */
    class a implements r {

        /* renamed from: a */
        final /* synthetic */ String f3279a;

        a(String str) {
            this.f3279a = str;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3019d(this.f3279a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$b */
    class b implements r {

        /* renamed from: a */
        final /* synthetic */ String f3281a;

        /* renamed from: b */
        final /* synthetic */ String f3282b;

        /* renamed from: c */
        final /* synthetic */ boolean f3283c;

        b(String str, String str2, boolean z) {
            this.f3281a = str;
            this.f3282b = str2;
            this.f3283c = z;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3001a(this.f3281a, this.f3282b, this.f3283c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$c */
    class c implements r {

        /* renamed from: a */
        final /* synthetic */ int f3285a;

        /* renamed from: b */
        final /* synthetic */ int f3286b;

        c(int i2, int i3) {
            this.f3285a = i2;
            this.f3286b = i3;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2990a(this.f3285a, this.f3286b);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$d */
    class d implements r {

        /* renamed from: a */
        final /* synthetic */ float f3288a;

        /* renamed from: b */
        final /* synthetic */ float f3289b;

        d(float f2, float f3) {
            this.f3288a = f2;
            this.f3289b = f3;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2988a(this.f3288a, this.f3289b);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$e */
    class e implements r {

        /* renamed from: a */
        final /* synthetic */ int f3291a;

        e(int i2) {
            this.f3291a = i2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2989a(this.f3291a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$f */
    class f implements r {

        /* renamed from: a */
        final /* synthetic */ float f3293a;

        f(float f2) {
            this.f3293a = f2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3013c(this.f3293a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$g */
    class g implements r {

        /* renamed from: a */
        final /* synthetic */ C1439e f3295a;

        /* renamed from: b */
        final /* synthetic */ Object f3296b;

        /* renamed from: c */
        final /* synthetic */ C1370j f3297c;

        g(C1439e c1439e, Object obj, C1370j c1370j) {
            this.f3295a = c1439e;
            this.f3296b = obj;
            this.f3297c = c1370j;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2998a(this.f3295a, (C1439e) this.f3296b, (C1370j<C1439e>) this.f3297c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$h */
    class h<T> extends C1370j<T> {

        /* renamed from: d */
        final /* synthetic */ InterfaceC1372l f3299d;

        h(InterfaceC1372l interfaceC1372l) {
            this.f3299d = interfaceC1372l;
        }

        @Override // com.airbnb.lottie.p101c0.C1370j
        /* renamed from: a */
        public T mo2653a(C1362b<T> c1362b) {
            return (T) this.f3299d.m2876a(c1362b);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$i */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (C1379j.this.f3272q != null) {
                C1379j.this.f3272q.mo3344a(C1379j.this.f3258c.m2806f());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$j */
    class j implements r {
        j() {
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3048y();
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$k */
    class k implements r {
        k() {
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2979B();
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$l */
    class l implements r {

        /* renamed from: a */
        final /* synthetic */ int f3304a;

        l(int i2) {
            this.f3304a = i2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3014c(this.f3304a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$m */
    class m implements r {

        /* renamed from: a */
        final /* synthetic */ float f3306a;

        m(float f2) {
            this.f3306a = f2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3005b(this.f3306a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$n */
    class n implements r {

        /* renamed from: a */
        final /* synthetic */ int f3308a;

        n(int i2) {
            this.f3308a = i2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3006b(this.f3308a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$o */
    class o implements r {

        /* renamed from: a */
        final /* synthetic */ float f3310a;

        o(float f2) {
            this.f3310a = f2;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m2987a(this.f3310a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$p */
    class p implements r {

        /* renamed from: a */
        final /* synthetic */ String f3312a;

        p(String str) {
            this.f3312a = str;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3025e(this.f3312a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$q */
    class q implements r {

        /* renamed from: a */
        final /* synthetic */ String f3314a;

        q(String str) {
            this.f3314a = str;
        }

        @Override // com.airbnb.lottie.C1379j.r
        /* renamed from: a */
        public void mo3050a(C1376g c1376g) {
            C1379j.this.m3015c(this.f3314a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.j$r */
    private interface r {
        /* renamed from: a */
        void mo3050a(C1376g c1376g);
    }

    /* compiled from: LottieDrawable.java */
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.airbnb.lottie.j$s */
    public @interface s {
    }

    public C1379j() {
        this.f3258c.addUpdateListener(this.f3264i);
    }

    /* renamed from: E */
    private boolean m2965E() {
        return this.f3260e || this.f3261f;
    }

    /* renamed from: F */
    private boolean m2966F() {
        C1376g c1376g = this.f3257b;
        return c1376g == null || getBounds().isEmpty() || m2971a(getBounds()) == m2971a(c1376g.m2888a());
    }

    /* renamed from: G */
    private void m2967G() {
        this.f3272q = new C1478b(this, C1342s.m2763a(this.f3257b), this.f3257b.m2905i(), this.f3257b);
        if (this.f3275t) {
            this.f3272q.mo3347a(true);
        }
    }

    @Nullable
    /* renamed from: H */
    private Context m2968H() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    /* renamed from: I */
    private C1432a m2969I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f3268m == null) {
            this.f3268m = new C1432a(getCallback(), this.f3269n);
        }
        return this.f3268m;
    }

    /* renamed from: J */
    private C1433b m2970J() {
        if (getCallback() == null) {
            return null;
        }
        C1433b c1433b = this.f3265j;
        if (c1433b != null && !c1433b.m3184a(m2968H())) {
            this.f3265j = null;
        }
        if (this.f3265j == null) {
            this.f3265j = new C1433b(getCallback(), this.f3266k, this.f3267l, this.f3257b.m2904h());
        }
        return this.f3265j;
    }

    /* renamed from: A */
    public void m2978A() {
        this.f3258c.removeAllUpdateListeners();
        this.f3258c.addUpdateListener(this.f3264i);
    }

    @MainThread
    /* renamed from: B */
    public void m2979B() {
        if (this.f3272q == null) {
            this.f3263h.add(new k());
            return;
        }
        if (m2965E() || m3036m() == 0) {
            this.f3258c.m2815o();
        }
        if (m2965E()) {
            return;
        }
        m2989a((int) (m3039p() < 0.0f ? m3033j() : m3032i()));
        this.f3258c.m2805e();
    }

    /* renamed from: C */
    public void m2980C() {
        this.f3258c.m2816p();
    }

    /* renamed from: D */
    public boolean m2981D() {
        return this.f3270o == null && this.f3257b.m2895b().size() > 0;
    }

    /* renamed from: c */
    public void m3016c(boolean z) {
        this.f3276u = z;
    }

    /* renamed from: d */
    public boolean m3021d() {
        return this.f3271p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f3278w = false;
        C1374e.m2881a("Drawable#draw");
        if (this.f3262g) {
            try {
                m2973a(canvas);
            } catch (Throwable th) {
                C1354d.m2792b("Lottie crashed in draw!", th);
            }
        } else {
            m2973a(canvas);
        }
        C1374e.m2883b("Drawable#draw");
    }

    /* renamed from: e */
    public void m3026e(boolean z) {
        if (this.f3275t == z) {
            return;
        }
        this.f3275t = z;
        C1478b c1478b = this.f3272q;
        if (c1478b != null) {
            c1478b.mo3347a(z);
        }
    }

    /* renamed from: f */
    public void m3028f(boolean z) {
        this.f3274s = z;
        C1376g c1376g = this.f3257b;
        if (c1376g != null) {
            c1376g.m2897b(z);
        }
    }

    /* renamed from: g */
    public void m3030g(boolean z) {
        this.f3262g = z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3273r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f3257b == null) {
            return -1;
        }
        return (int) (r0.m2888a().height() * m3038o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f3257b == null) {
            return -1;
        }
        return (int) (r0.m2888a().width() * m3038o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    /* renamed from: h */
    public String m3031h() {
        return this.f3266k;
    }

    /* renamed from: i */
    public float m3032i() {
        return this.f3258c.m2808h();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f3278w) {
            return;
        }
        this.f3278w = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m3043t();
    }

    /* renamed from: j */
    public float m3033j() {
        return this.f3258c.m2809i();
    }

    @Nullable
    /* renamed from: k */
    public C1388s m3034k() {
        C1376g c1376g = this.f3257b;
        if (c1376g != null) {
            return c1376g.m2908l();
        }
        return null;
    }

    @FloatRange(from = 0.0d, m293to = 1.0d)
    /* renamed from: l */
    public float m3035l() {
        return this.f3258c.m2806f();
    }

    /* renamed from: m */
    public int m3036m() {
        return this.f3258c.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    /* renamed from: n */
    public int m3037n() {
        return this.f3258c.getRepeatMode();
    }

    /* renamed from: o */
    public float m3038o() {
        return this.f3259d;
    }

    /* renamed from: p */
    public float m3039p() {
        return this.f3258c.m2810j();
    }

    @Nullable
    /* renamed from: q */
    public C1391v m3040q() {
        return this.f3270o;
    }

    /* renamed from: r */
    public boolean m3041r() {
        C1478b c1478b = this.f3272q;
        return c1478b != null && c1478b.m3355e();
    }

    /* renamed from: s */
    public boolean m3042s() {
        C1478b c1478b = this.f3272q;
        return c1478b != null && c1478b.m3356f();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m294to = 255) int i2) {
        this.f3273r = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        C1354d.m2791b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        m3048y();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        m3022e();
    }

    /* renamed from: t */
    public boolean m3043t() {
        ChoreographerFrameCallbackC1355e choreographerFrameCallbackC1355e = this.f3258c;
        if (choreographerFrameCallbackC1355e == null) {
            return false;
        }
        return choreographerFrameCallbackC1355e.isRunning();
    }

    /* renamed from: u */
    public boolean m3044u() {
        return this.f3276u;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    /* renamed from: v */
    public boolean m3045v() {
        return this.f3258c.getRepeatCount() == -1;
    }

    /* renamed from: w */
    public boolean m3046w() {
        return this.f3271p;
    }

    /* renamed from: x */
    public void m3047x() {
        this.f3263h.clear();
        this.f3258c.m2811k();
    }

    @MainThread
    /* renamed from: y */
    public void m3048y() {
        if (this.f3272q == null) {
            this.f3263h.add(new j());
            return;
        }
        if (m2965E() || m3036m() == 0) {
            this.f3258c.m2812l();
        }
        if (m2965E()) {
            return;
        }
        m2989a((int) (m3039p() < 0.0f ? m3033j() : m3032i()));
        this.f3258c.m2805e();
    }

    /* renamed from: z */
    public void m3049z() {
        this.f3258c.removeAllListeners();
    }

    /* renamed from: a */
    public void m3002a(boolean z) {
        if (this.f3271p == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            C1354d.m2791b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f3271p = z;
        if (this.f3257b != null) {
            m2967G();
        }
    }

    /* renamed from: b */
    public void m3010b(@Nullable String str) {
        this.f3266k = str;
    }

    /* renamed from: c */
    public void m3012c() {
        this.f3277v = false;
    }

    /* renamed from: d */
    public void m3019d(String str) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new a(str));
            return;
        }
        C1442h m2896b = c1376g.m2896b(str);
        if (m2896b != null) {
            int i2 = (int) m2896b.f3610b;
            m2990a(i2, ((int) m2896b.f3611c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    /* renamed from: g */
    public int m3029g() {
        return (int) this.f3258c.m2807g();
    }

    /* renamed from: b */
    public void m3004b() {
        if (this.f3258c.isRunning()) {
            this.f3258c.cancel();
        }
        this.f3257b = null;
        this.f3272q = null;
        this.f3265j = null;
        this.f3258c.m2804d();
        invalidateSelf();
    }

    /* renamed from: c */
    public void m3014c(int i2) {
        if (this.f3257b == null) {
            this.f3263h.add(new l(i2));
        } else {
            this.f3258c.m2799a(i2);
        }
    }

    /* renamed from: f */
    public C1376g m3027f() {
        return this.f3257b;
    }

    @MainThread
    /* renamed from: e */
    public void m3022e() {
        this.f3263h.clear();
        this.f3258c.m2805e();
    }

    /* renamed from: c */
    public void m3015c(String str) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new q(str));
            return;
        }
        C1442h m2896b = c1376g.m2896b(str);
        if (m2896b != null) {
            m3006b((int) (m2896b.f3610b + m2896b.f3611c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    /* renamed from: e */
    public void m3025e(String str) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new p(str));
            return;
        }
        C1442h m2896b = c1376g.m2896b(str);
        if (m2896b != null) {
            m3014c((int) m2896b.f3610b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    /* renamed from: a */
    public boolean m3003a(C1376g c1376g) {
        if (this.f3257b == c1376g) {
            return false;
        }
        this.f3278w = false;
        m3004b();
        this.f3257b = c1376g;
        m2967G();
        this.f3258c.m2800a(c1376g);
        m3013c(this.f3258c.getAnimatedFraction());
        m3017d(this.f3259d);
        Iterator it = new ArrayList(this.f3263h).iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.mo3050a(c1376g);
            }
            it.remove();
        }
        this.f3263h.clear();
        c1376g.m2897b(this.f3274s);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    /* renamed from: d */
    public void m3018d(int i2) {
        this.f3258c.setRepeatCount(i2);
    }

    /* renamed from: d */
    public void m3020d(boolean z) {
        this.f3261f = z;
    }

    /* renamed from: b */
    public void m3005b(float f2) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new m(f2));
        } else {
            m3014c((int) C1357g.m2831c(c1376g.m2909m(), this.f3257b.m2901e(), f2));
        }
    }

    /* renamed from: d */
    public void m3017d(float f2) {
        this.f3259d = f2;
    }

    /* renamed from: d */
    private float m2977d(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f3257b.m2888a().width(), canvas.getHeight() / this.f3257b.m2888a().height());
    }

    /* renamed from: c */
    public void m3013c(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        if (this.f3257b == null) {
            this.f3263h.add(new f(f2));
            return;
        }
        C1374e.m2881a("Drawable#setProgress");
        this.f3258c.m2797a(this.f3257b.m2887a(f2));
        C1374e.m2883b("Drawable#setProgress");
    }

    /* renamed from: e */
    public void m3023e(float f2) {
        this.f3258c.m2802c(f2);
    }

    /* renamed from: b */
    public void m3006b(int i2) {
        if (this.f3257b == null) {
            this.f3263h.add(new n(i2));
        } else {
            this.f3258c.m2801b(i2 + 0.99f);
        }
    }

    /* renamed from: e */
    public void m3024e(int i2) {
        this.f3258c.setRepeatMode(i2);
    }

    /* renamed from: c */
    private void m2976c(Canvas canvas) {
        float f2;
        if (this.f3272q == null) {
            return;
        }
        float f3 = this.f3259d;
        float m2977d = m2977d(canvas);
        if (f3 > m2977d) {
            f2 = this.f3259d / m2977d;
        } else {
            m2977d = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.f3257b.m2888a().width() / 2.0f;
            float height = this.f3257b.m2888a().height() / 2.0f;
            float f4 = width * m2977d;
            float f5 = height * m2977d;
            canvas.translate((m3038o() * width) - f4, (m3038o() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f3256a.reset();
        this.f3256a.preScale(m2977d, m2977d);
        this.f3272q.mo3094a(canvas, this.f3256a, this.f3273r);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    /* renamed from: b */
    public void m3009b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3258c.removeUpdateListener(animatorUpdateListener);
    }

    /* renamed from: b */
    public void m3007b(Animator.AnimatorListener animatorListener) {
        this.f3258c.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    /* renamed from: b */
    public void m3008b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3258c.removePauseListener(animatorPauseListener);
    }

    @Deprecated
    /* renamed from: b */
    public void m3011b(boolean z) {
        this.f3258c.setRepeatCount(z ? -1 : 0);
    }

    /* renamed from: b */
    private void m2975b(Canvas canvas) {
        float f2;
        if (this.f3272q == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = bounds.width() / this.f3257b.m2888a().width();
        float height = bounds.height() / this.f3257b.m2888a().height();
        if (this.f3277v) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.f3256a.reset();
        this.f3256a.preScale(width, height);
        this.f3272q.mo3094a(canvas, this.f3256a, this.f3273r);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    /* renamed from: a */
    private void m2973a(@NonNull Canvas canvas) {
        if (!m2966F()) {
            m2975b(canvas);
        } else {
            m2976c(canvas);
        }
    }

    /* renamed from: a */
    private float m2971a(Rect rect) {
        return rect.width() / rect.height();
    }

    /* renamed from: a */
    public void m2987a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new o(f2));
        } else {
            m3006b((int) C1357g.m2831c(c1376g.m2909m(), this.f3257b.m2901e(), f2));
        }
    }

    /* renamed from: a */
    public void m3001a(String str, String str2, boolean z) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new b(str, str2, z));
            return;
        }
        C1442h m2896b = c1376g.m2896b(str);
        if (m2896b != null) {
            int i2 = (int) m2896b.f3610b;
            C1442h m2896b2 = this.f3257b.m2896b(str2);
            if (m2896b2 != null) {
                m2990a(i2, (int) (m2896b2.f3610b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    /* renamed from: a */
    public void m2990a(int i2, int i3) {
        if (this.f3257b == null) {
            this.f3263h.add(new c(i2, i3));
        } else {
            this.f3258c.m2798a(i2, i3 + 0.99f);
        }
    }

    /* renamed from: a */
    public void m2988a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2, @FloatRange(from = 0.0d, m293to = 1.0d) float f3) {
        C1376g c1376g = this.f3257b;
        if (c1376g == null) {
            this.f3263h.add(new d(f2, f3));
        } else {
            m2990a((int) C1357g.m2831c(c1376g.m2909m(), this.f3257b.m2901e(), f2), (int) C1357g.m2831c(this.f3257b.m2909m(), this.f3257b.m2901e(), f3));
        }
    }

    /* renamed from: a */
    public void m2993a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3258c.addUpdateListener(animatorUpdateListener);
    }

    /* renamed from: a */
    public void m2991a(Animator.AnimatorListener animatorListener) {
        this.f3258c.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    /* renamed from: a */
    public void m2992a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3258c.addPauseListener(animatorPauseListener);
    }

    /* renamed from: a */
    public void m2989a(int i2) {
        if (this.f3257b == null) {
            this.f3263h.add(new e(i2));
        } else {
            this.f3258c.m2797a(i2);
        }
    }

    /* renamed from: a */
    void m3000a(Boolean bool) {
        this.f3260e = bool.booleanValue();
    }

    /* renamed from: a */
    public void m2996a(InterfaceC1373d interfaceC1373d) {
        this.f3267l = interfaceC1373d;
        C1433b c1433b = this.f3265j;
        if (c1433b != null) {
            c1433b.m3183a(interfaceC1373d);
        }
    }

    /* renamed from: a */
    public void m2995a(C1360c c1360c) {
        this.f3269n = c1360c;
        C1432a c1432a = this.f3268m;
        if (c1432a != null) {
            c1432a.m3178a(c1360c);
        }
    }

    /* renamed from: a */
    public void m2997a(C1391v c1391v) {
        this.f3270o = c1391v;
    }

    /* renamed from: a */
    public void m2986a() {
        this.f3263h.clear();
        this.f3258c.cancel();
    }

    /* renamed from: a */
    public List<C1439e> m2985a(C1439e c1439e) {
        if (this.f3272q == null) {
            C1354d.m2791b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f3272q.mo3096a(c1439e, 0, arrayList, new C1439e(new String[0]));
        return arrayList;
    }

    /* renamed from: a */
    public <T> void m2998a(C1439e c1439e, T t, @Nullable C1370j<T> c1370j) {
        C1478b c1478b = this.f3272q;
        if (c1478b == null) {
            this.f3263h.add(new g(c1439e, t, c1370j));
            return;
        }
        boolean z = true;
        if (c1439e == C1439e.f3603c) {
            c1478b.mo3097a((C1478b) t, (C1370j<C1478b>) c1370j);
        } else if (c1439e.m3206a() != null) {
            c1439e.m3206a().mo3097a(t, c1370j);
        } else {
            List<C1439e> m2985a = m2985a(c1439e);
            for (int i2 = 0; i2 < m2985a.size(); i2++) {
                m2985a.get(i2).m3206a().mo3097a(t, c1370j);
            }
            z = true ^ m2985a.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == InterfaceC1384o.f3324C) {
                m3013c(m3035l());
            }
        }
    }

    /* renamed from: a */
    public <T> void m2999a(C1439e c1439e, T t, InterfaceC1372l<T> interfaceC1372l) {
        m2998a(c1439e, (C1439e) t, (C1370j<C1439e>) new h(interfaceC1372l));
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m2983a(String str, @Nullable Bitmap bitmap) {
        C1433b m2970J = m2970J();
        if (m2970J == null) {
            C1354d.m2791b("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap m3182a = m2970J.m3182a(str, bitmap);
        invalidateSelf();
        return m3182a;
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m2982a(String str) {
        C1433b m2970J = m2970J();
        if (m2970J != null) {
            return m2970J.m3181a(str);
        }
        C1376g c1376g = this.f3257b;
        C1380k c1380k = c1376g == null ? null : c1376g.m2904h().get(str);
        if (c1380k != null) {
            return c1380k.m3051a();
        }
        return null;
    }

    @Nullable
    /* renamed from: a */
    public Typeface m2984a(String str, String str2) {
        C1432a m2969I = m2969I();
        if (m2969I != null) {
            return m2969I.m3177a(str, str2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    public void m2994a(Canvas canvas, Matrix matrix) {
        C1478b c1478b = this.f3272q;
        if (c1478b == null) {
            return;
        }
        c1478b.mo3094a(canvas, matrix, this.f3273r);
    }
}
