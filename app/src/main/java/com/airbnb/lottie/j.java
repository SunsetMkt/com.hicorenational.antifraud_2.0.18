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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LottieDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends Drawable implements Drawable.Callback, Animatable {
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = -1;

    /* JADX INFO: renamed from: b */
    private com.airbnb.lottie.g f2182b;

    /* JADX INFO: renamed from: j */
    @Nullable
    private com.airbnb.lottie.x.b f2190j;

    /* JADX INFO: renamed from: k */
    @Nullable
    private String f2191k;

    /* JADX INFO: renamed from: l */
    @Nullable
    private com.airbnb.lottie.d f2192l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private com.airbnb.lottie.x.a f2193m;

    /* JADX INFO: renamed from: n */
    @Nullable
    com.airbnb.lottie.c f2194n;

    @Nullable
    v o;
    private boolean p;

    @Nullable
    private com.airbnb.lottie.y.l.b q;
    private boolean s;
    private boolean t;
    private boolean u;
    private final Matrix a = new Matrix();

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.b0.e f2183c = new com.airbnb.lottie.b0.e();

    /* JADX INFO: renamed from: d */
    private float f2184d = 1.0f;

    /* JADX INFO: renamed from: e */
    private boolean f2185e = true;

    /* JADX INFO: renamed from: f */
    private boolean f2186f = false;

    /* JADX INFO: renamed from: g */
    private boolean f2187g = false;

    /* JADX INFO: renamed from: h */
    private final ArrayList<r> f2188h = new ArrayList<>();

    /* JADX INFO: renamed from: i */
    private final ValueAnimator.AnimatorUpdateListener f2189i = new i();
    private int r = 255;
    private boolean v = true;
    private boolean w = false;

    /* JADX INFO: compiled from: LottieDrawable.java */
    class a implements r {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.d(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class b implements r {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f2196b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f2197c;

        b(String str, String str2, boolean z) {
            this.a = str;
            this.f2196b = str2;
            this.f2197c = z;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a, this.f2196b, this.f2197c);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class c implements r {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f2199b;

        c(int i2, int i3) {
            this.a = i2;
            this.f2199b = i3;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a, this.f2199b);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class d implements r {
        final /* synthetic */ float a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ float f2201b;

        d(float f2, float f3) {
            this.a = f2;
            this.f2201b = f3;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a, this.f2201b);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class e implements r {
        final /* synthetic */ int a;

        e(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class f implements r {
        final /* synthetic */ float a;

        f(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class g implements r {
        final /* synthetic */ com.airbnb.lottie.y.e a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Object f2205b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ com.airbnb.lottie.c0.j f2206c;

        g(com.airbnb.lottie.y.e eVar, Object obj, com.airbnb.lottie.c0.j jVar) {
            this.a = eVar;
            this.f2205b = obj;
            this.f2206c = jVar;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a, this.f2205b, (com.airbnb.lottie.c0.j<Object>) this.f2206c);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class h<T> extends com.airbnb.lottie.c0.j<T> {

        /* JADX INFO: renamed from: d */
        final /* synthetic */ com.airbnb.lottie.c0.l f2208d;

        h(com.airbnb.lottie.c0.l lVar) {
            this.f2208d = lVar;
        }

        @Override // com.airbnb.lottie.c0.j
        public T a(com.airbnb.lottie.c0.b<T> bVar) {
            return (T) this.f2208d.a(bVar);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (j.this.q != null) {
                j.this.q.a(j.this.f2183c.f());
            }
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.j$j */
    /* JADX INFO: compiled from: LottieDrawable.java */
    class C0036j implements r {
        C0036j() {
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.y();
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class k implements r {
        k() {
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.B();
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class l implements r {
        final /* synthetic */ int a;

        l(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class m implements r {
        final /* synthetic */ float a;

        m(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.b(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class n implements r {
        final /* synthetic */ int a;

        n(int i2) {
            this.a = i2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.b(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class o implements r {
        final /* synthetic */ float a;

        o(float f2) {
            this.a = f2;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.a(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class p implements r {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.e(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    class q implements r {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.j.r
        public void a(com.airbnb.lottie.g gVar) {
            j.this.c(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    private interface r {
        void a(com.airbnb.lottie.g gVar);
    }

    /* JADX INFO: compiled from: LottieDrawable.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface s {
    }

    public j() {
        this.f2183c.addUpdateListener(this.f2189i);
    }

    private boolean E() {
        return this.f2185e || this.f2186f;
    }

    private boolean F() {
        com.airbnb.lottie.g gVar = this.f2182b;
        return gVar == null || getBounds().isEmpty() || a(getBounds()) == a(gVar.a());
    }

    private void G() {
        this.q = new com.airbnb.lottie.y.l.b(this, com.airbnb.lottie.a0.s.a(this.f2182b), this.f2182b.i(), this.f2182b);
        if (this.t) {
            this.q.a(true);
        }
    }

    @Nullable
    private Context H() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.x.a I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f2193m == null) {
            this.f2193m = new com.airbnb.lottie.x.a(getCallback(), this.f2194n);
        }
        return this.f2193m;
    }

    private com.airbnb.lottie.x.b J() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.x.b bVar = this.f2190j;
        if (bVar != null && !bVar.a(H())) {
            this.f2190j = null;
        }
        if (this.f2190j == null) {
            this.f2190j = new com.airbnb.lottie.x.b(getCallback(), this.f2191k, this.f2192l, this.f2182b.h());
        }
        return this.f2190j;
    }

    public void A() {
        this.f2183c.removeAllUpdateListeners();
        this.f2183c.addUpdateListener(this.f2189i);
    }

    @MainThread
    public void B() {
        if (this.q == null) {
            this.f2188h.add(new k());
            return;
        }
        if (E() || m() == 0) {
            this.f2183c.o();
        }
        if (E()) {
            return;
        }
        a((int) (p() < 0.0f ? j() : i()));
        this.f2183c.e();
    }

    public void C() {
        this.f2183c.p();
    }

    public boolean D() {
        return this.o == null && this.f2182b.b().size() > 0;
    }

    public void c(boolean z2) {
        this.u = z2;
    }

    public boolean d() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.w = false;
        com.airbnb.lottie.e.a("Drawable#draw");
        if (this.f2187g) {
            try {
                a(canvas);
            } catch (Throwable th) {
                com.airbnb.lottie.b0.d.b("Lottie crashed in draw!", th);
            }
        } else {
            a(canvas);
        }
        com.airbnb.lottie.e.b("Drawable#draw");
    }

    public void e(boolean z2) {
        if (this.t == z2) {
            return;
        }
        this.t = z2;
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar != null) {
            bVar.a(z2);
        }
    }

    public void f(boolean z2) {
        this.s = z2;
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar != null) {
            gVar.b(z2);
        }
    }

    public void g(boolean z2) {
        this.f2187g = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2182b == null) {
            return -1;
        }
        return (int) (r0.a().height() * o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2182b == null) {
            return -1;
        }
        return (int) (r0.a().width() * o());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Nullable
    public String h() {
        return this.f2191k;
    }

    public float i() {
        return this.f2183c.h();
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
        if (this.w) {
            return;
        }
        this.w = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return t();
    }

    public float j() {
        return this.f2183c.i();
    }

    @Nullable
    public com.airbnb.lottie.s k() {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar != null) {
            return gVar.l();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float l() {
        return this.f2183c.f();
    }

    public int m() {
        return this.f2183c.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    public int n() {
        return this.f2183c.getRepeatMode();
    }

    public float o() {
        return this.f2184d;
    }

    public float p() {
        return this.f2183c.j();
    }

    @Nullable
    public v q() {
        return this.o;
    }

    public boolean r() {
        com.airbnb.lottie.y.l.b bVar = this.q;
        return bVar != null && bVar.e();
    }

    public boolean s() {
        com.airbnb.lottie.y.l.b bVar = this.q;
        return bVar != null && bVar.f();
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
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.r = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        com.airbnb.lottie.b0.d.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        y();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        e();
    }

    public boolean t() {
        com.airbnb.lottie.b0.e eVar = this.f2183c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean u() {
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean v() {
        return this.f2183c.getRepeatCount() == -1;
    }

    public boolean w() {
        return this.p;
    }

    public void x() {
        this.f2188h.clear();
        this.f2183c.k();
    }

    @MainThread
    public void y() {
        if (this.q == null) {
            this.f2188h.add(new C0036j());
            return;
        }
        if (E() || m() == 0) {
            this.f2183c.l();
        }
        if (E()) {
            return;
        }
        a((int) (p() < 0.0f ? j() : i()));
        this.f2183c.e();
    }

    public void z() {
        this.f2183c.removeAllListeners();
    }

    public void a(boolean z2) {
        if (this.p == z2) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.airbnb.lottie.b0.d.b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.p = z2;
        if (this.f2182b != null) {
            G();
        }
    }

    public void b(@Nullable String str) {
        this.f2191k = str;
    }

    public void c() {
        this.v = false;
    }

    public void d(String str) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new a(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            int i2 = (int) hVarB.f2424b;
            a(i2, ((int) hVarB.f2425c) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public int g() {
        return (int) this.f2183c.g();
    }

    public void b() {
        if (this.f2183c.isRunning()) {
            this.f2183c.cancel();
        }
        this.f2182b = null;
        this.q = null;
        this.f2190j = null;
        this.f2183c.d();
        invalidateSelf();
    }

    public void c(int i2) {
        if (this.f2182b == null) {
            this.f2188h.add(new l(i2));
        } else {
            this.f2183c.a(i2);
        }
    }

    public com.airbnb.lottie.g f() {
        return this.f2182b;
    }

    @MainThread
    public void e() {
        this.f2188h.clear();
        this.f2183c.e();
    }

    public void c(String str) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new q(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            b((int) (hVarB.f2424b + hVarB.f2425c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void e(String str) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new p(str));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            c((int) hVarB.f2424b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public boolean a(com.airbnb.lottie.g gVar) {
        if (this.f2182b == gVar) {
            return false;
        }
        this.w = false;
        b();
        this.f2182b = gVar;
        G();
        this.f2183c.a(gVar);
        c(this.f2183c.getAnimatedFraction());
        d(this.f2184d);
        Iterator it = new ArrayList(this.f2188h).iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.a(gVar);
            }
            it.remove();
        }
        this.f2188h.clear();
        gVar.b(this.s);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void d(int i2) {
        this.f2183c.setRepeatCount(i2);
    }

    public void d(boolean z2) {
        this.f2186f = z2;
    }

    public void b(float f2) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new m(f2));
        } else {
            c((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f2182b.e(), f2));
        }
    }

    public void d(float f2) {
        this.f2184d = f2;
    }

    private float d(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f2182b.a().width(), canvas.getHeight() / this.f2182b.a().height());
    }

    public void c(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f2182b == null) {
            this.f2188h.add(new f(f2));
            return;
        }
        com.airbnb.lottie.e.a("Drawable#setProgress");
        this.f2183c.a(this.f2182b.a(f2));
        com.airbnb.lottie.e.b("Drawable#setProgress");
    }

    public void e(float f2) {
        this.f2183c.c(f2);
    }

    public void b(int i2) {
        if (this.f2182b == null) {
            this.f2188h.add(new n(i2));
        } else {
            this.f2183c.b(i2 + 0.99f);
        }
    }

    public void e(int i2) {
        this.f2183c.setRepeatMode(i2);
    }

    private void c(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        float f3 = this.f2184d;
        float fD = d(canvas);
        if (f3 > fD) {
            f2 = this.f2184d / fD;
        } else {
            fD = f3;
            f2 = 1.0f;
        }
        int iSave = -1;
        if (f2 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f2182b.a().width() / 2.0f;
            float fHeight = this.f2182b.a().height() / 2.0f;
            float f4 = fWidth * fD;
            float f5 = fHeight * fD;
            canvas.translate((o() * fWidth) - f4, (o() * fHeight) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.a.reset();
        this.a.preScale(fD, fD);
        this.q.a(canvas, this.a, this.r);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2183c.removeUpdateListener(animatorUpdateListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f2183c.removeListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2183c.removePauseListener(animatorPauseListener);
    }

    @Deprecated
    public void b(boolean z2) {
        this.f2183c.setRepeatCount(z2 ? -1 : 0);
    }

    private void b(Canvas canvas) {
        float f2;
        if (this.q == null) {
            return;
        }
        int iSave = -1;
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.f2182b.a().width();
        float fHeight = bounds.height() / this.f2182b.a().height();
        if (this.v) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f2 = 1.0f / fMin;
                fWidth /= f2;
                fHeight /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f3 = fWidth2 * fMin;
                float f4 = fMin * fHeight2;
                canvas.translate(fWidth2 - f3, fHeight2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.a.reset();
        this.a.preScale(fWidth, fHeight);
        this.q.a(canvas, this.a, this.r);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void a(@NonNull Canvas canvas) {
        if (!F()) {
            b(canvas);
        } else {
            c(canvas);
        }
    }

    private float a(Rect rect) {
        return rect.width() / rect.height();
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new o(f2));
        } else {
            b((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f2182b.e(), f2));
        }
    }

    public void a(String str, String str2, boolean z2) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new b(str, str2, z2));
            return;
        }
        com.airbnb.lottie.y.h hVarB = gVar.b(str);
        if (hVarB != null) {
            int i2 = (int) hVarB.f2424b;
            com.airbnb.lottie.y.h hVarB2 = this.f2182b.b(str2);
            if (hVarB2 != null) {
                a(i2, (int) (hVarB2.f2424b + (z2 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void a(int i2, int i3) {
        if (this.f2182b == null) {
            this.f2188h.add(new c(i2, i3));
        } else {
            this.f2183c.a(i2, i3 + 0.99f);
        }
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        com.airbnb.lottie.g gVar = this.f2182b;
        if (gVar == null) {
            this.f2188h.add(new d(f2, f3));
        } else {
            a((int) com.airbnb.lottie.b0.g.c(gVar.m(), this.f2182b.e(), f2), (int) com.airbnb.lottie.b0.g.c(this.f2182b.m(), this.f2182b.e(), f3));
        }
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2183c.addUpdateListener(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f2183c.addListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2183c.addPauseListener(animatorPauseListener);
    }

    public void a(int i2) {
        if (this.f2182b == null) {
            this.f2188h.add(new e(i2));
        } else {
            this.f2183c.a(i2);
        }
    }

    void a(Boolean bool) {
        this.f2185e = bool.booleanValue();
    }

    public void a(com.airbnb.lottie.d dVar) {
        this.f2192l = dVar;
        com.airbnb.lottie.x.b bVar = this.f2190j;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void a(com.airbnb.lottie.c cVar) {
        this.f2194n = cVar;
        com.airbnb.lottie.x.a aVar = this.f2193m;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void a(v vVar) {
        this.o = vVar;
    }

    public void a() {
        this.f2188h.clear();
        this.f2183c.cancel();
    }

    public List<com.airbnb.lottie.y.e> a(com.airbnb.lottie.y.e eVar) {
        if (this.q == null) {
            com.airbnb.lottie.b0.d.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.q.a(eVar, 0, arrayList, new com.airbnb.lottie.y.e(new String[0]));
        return arrayList;
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar == null) {
            this.f2188h.add(new g(eVar, t, jVar));
            return;
        }
        boolean zIsEmpty = true;
        if (eVar == com.airbnb.lottie.y.e.f2420c) {
            bVar.a(t, jVar);
        } else if (eVar.a() != null) {
            eVar.a().a(t, jVar);
        } else {
            List<com.airbnb.lottie.y.e> listA = a(eVar);
            for (int i2 = 0; i2 < listA.size(); i2++) {
                listA.get(i2).a().a(t, jVar);
            }
            zIsEmpty = true ^ listA.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == com.airbnb.lottie.o.C) {
                c(l());
            }
        }
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t, com.airbnb.lottie.c0.l<T> lVar) {
        a(eVar, t, new h(lVar));
    }

    @Nullable
    public Bitmap a(String str, @Nullable Bitmap bitmap) {
        com.airbnb.lottie.x.b bVarJ = J();
        if (bVarJ == null) {
            com.airbnb.lottie.b0.d.b("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapA = bVarJ.a(str, bitmap);
        invalidateSelf();
        return bitmapA;
    }

    @Nullable
    public Bitmap a(String str) {
        com.airbnb.lottie.x.b bVarJ = J();
        if (bVarJ != null) {
            return bVarJ.a(str);
        }
        com.airbnb.lottie.g gVar = this.f2182b;
        com.airbnb.lottie.k kVar = gVar == null ? null : gVar.h().get(str);
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    @Nullable
    public Typeface a(String str, String str2) {
        com.airbnb.lottie.x.a aVarI = I();
        if (aVarI != null) {
            return aVarI.a(str, str2);
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.y.l.b bVar = this.q;
        if (bVar == null) {
            return;
        }
        bVar.a(canvas, matrix, this.r);
    }
}
