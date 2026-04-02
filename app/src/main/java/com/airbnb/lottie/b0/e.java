package com.airbnb.lottie.b0;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: LottieValueAnimator.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.g f2102j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2095c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2096d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2097e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2098f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2099g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2100h = -2.1474836E9f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2101i = 2.1474836E9f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    protected boolean f2103k = false;

    private float q() {
        com.airbnb.lottie.g gVar = this.f2102j;
        if (gVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / gVar.g()) / Math.abs(this.f2095c);
    }

    private boolean r() {
        return j() < 0.0f;
    }

    private void s() {
        if (this.f2102j == null) {
            return;
        }
        float f2 = this.f2098f;
        if (f2 < this.f2100h || f2 > this.f2101i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f2100h), Float.valueOf(this.f2101i), Float.valueOf(this.f2098f)));
        }
    }

    public void a(com.airbnb.lottie.g gVar) {
        boolean z = this.f2102j == null;
        this.f2102j = gVar;
        if (z) {
            a((int) Math.max(this.f2100h, gVar.m()), (int) Math.min(this.f2101i, gVar.e()));
        } else {
            a((int) gVar.m(), (int) gVar.e());
        }
        float f2 = this.f2098f;
        this.f2098f = 0.0f;
        a((int) f2);
        c();
    }

    public void b(float f2) {
        a(this.f2100h, f2);
    }

    public void c(float f2) {
        this.f2095c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        a();
        n();
    }

    public void d() {
        this.f2102j = null;
        this.f2100h = -2.1474836E9f;
        this.f2101i = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        m();
        if (this.f2102j == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.e.a("LottieValueAnimator#doFrame");
        float fQ = (this.f2097e != 0 ? j2 - r1 : 0L) / q();
        float f2 = this.f2098f;
        if (r()) {
            fQ = -fQ;
        }
        this.f2098f = f2 + fQ;
        boolean z = !g.b(this.f2098f, i(), h());
        this.f2098f = g.a(this.f2098f, i(), h());
        this.f2097e = j2;
        c();
        if (z) {
            if (getRepeatCount() == -1 || this.f2099g < getRepeatCount()) {
                b();
                this.f2099g++;
                if (getRepeatMode() == 2) {
                    this.f2096d = !this.f2096d;
                    p();
                } else {
                    this.f2098f = r() ? h() : i();
                }
                this.f2097e = j2;
            } else {
                this.f2098f = this.f2095c < 0.0f ? i() : h();
                n();
                a(r());
            }
        }
        s();
        com.airbnb.lottie.e.b("LottieValueAnimator#doFrame");
    }

    @MainThread
    public void e() {
        n();
        a(r());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float f() {
        com.airbnb.lottie.g gVar = this.f2102j;
        if (gVar == null) {
            return 0.0f;
        }
        return (this.f2098f - gVar.m()) / (this.f2102j.e() - this.f2102j.m());
    }

    public float g() {
        return this.f2098f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fI;
        float fH;
        float fI2;
        if (this.f2102j == null) {
            return 0.0f;
        }
        if (r()) {
            fI = h() - this.f2098f;
            fH = h();
            fI2 = i();
        } else {
            fI = this.f2098f - i();
            fH = h();
            fI2 = i();
        }
        return fI / (fH - fI2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(f());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.g gVar = this.f2102j;
        if (gVar == null) {
            return 0L;
        }
        return (long) gVar.c();
    }

    public float h() {
        com.airbnb.lottie.g gVar = this.f2102j;
        if (gVar == null) {
            return 0.0f;
        }
        float f2 = this.f2101i;
        return f2 == 2.1474836E9f ? gVar.e() : f2;
    }

    public float i() {
        com.airbnb.lottie.g gVar = this.f2102j;
        if (gVar == null) {
            return 0.0f;
        }
        float f2 = this.f2100h;
        return f2 == -2.1474836E9f ? gVar.m() : f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f2103k;
    }

    public float j() {
        return this.f2095c;
    }

    @MainThread
    public void k() {
        n();
    }

    @MainThread
    public void l() {
        this.f2103k = true;
        b(r());
        a((int) (r() ? h() : i()));
        this.f2097e = 0L;
        this.f2099g = 0;
        m();
    }

    protected void m() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void n() {
        c(true);
    }

    @MainThread
    public void o() {
        this.f2103k = true;
        m();
        this.f2097e = 0L;
        if (r() && g() == i()) {
            this.f2098f = h();
        } else {
            if (r() || g() != h()) {
                return;
            }
            this.f2098f = i();
        }
    }

    public void p() {
        c(-j());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f2096d) {
            return;
        }
        this.f2096d = false;
        p();
    }

    @MainThread
    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f2103k = false;
        }
    }

    public void a(float f2) {
        if (this.f2098f == f2) {
            return;
        }
        this.f2098f = g.a(f2, i(), h());
        this.f2097e = 0L;
        c();
    }

    public void a(int i2) {
        a(i2, (int) this.f2101i);
    }

    public void a(float f2, float f3) {
        if (f2 <= f3) {
            com.airbnb.lottie.g gVar = this.f2102j;
            float fM = gVar == null ? -3.4028235E38f : gVar.m();
            com.airbnb.lottie.g gVar2 = this.f2102j;
            float fE = gVar2 == null ? Float.MAX_VALUE : gVar2.e();
            float fA = g.a(f2, fM, fE);
            float fA2 = g.a(f3, fM, fE);
            if (fA == this.f2100h && fA2 == this.f2101i) {
                return;
            }
            this.f2100h = fA;
            this.f2101i = fA2;
            a((int) g.a(this.f2098f, fA, fA2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
