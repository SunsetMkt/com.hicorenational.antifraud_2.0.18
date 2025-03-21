package com.airbnb.lottie.p100b0;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.C1374e;
import com.airbnb.lottie.C1376g;

/* compiled from: LottieValueAnimator.java */
/* renamed from: com.airbnb.lottie.b0.e */
/* loaded from: classes.dex */
public class ChoreographerFrameCallbackC1355e extends AbstractC1351a implements Choreographer.FrameCallback {

    /* renamed from: j */
    @Nullable
    private C1376g f3141j;

    /* renamed from: c */
    private float f3134c = 1.0f;

    /* renamed from: d */
    private boolean f3135d = false;

    /* renamed from: e */
    private long f3136e = 0;

    /* renamed from: f */
    private float f3137f = 0.0f;

    /* renamed from: g */
    private int f3138g = 0;

    /* renamed from: h */
    private float f3139h = -2.1474836E9f;

    /* renamed from: i */
    private float f3140i = 2.1474836E9f;

    /* renamed from: k */
    @VisibleForTesting
    protected boolean f3142k = false;

    /* renamed from: q */
    private float m2794q() {
        C1376g c1376g = this.f3141j;
        if (c1376g == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c1376g.m2903g()) / Math.abs(this.f3134c);
    }

    /* renamed from: r */
    private boolean m2795r() {
        return m2810j() < 0.0f;
    }

    /* renamed from: s */
    private void m2796s() {
        if (this.f3141j == null) {
            return;
        }
        float f2 = this.f3137f;
        if (f2 < this.f3139h || f2 > this.f3140i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f3139h), Float.valueOf(this.f3140i), Float.valueOf(this.f3137f)));
        }
    }

    /* renamed from: a */
    public void m2800a(C1376g c1376g) {
        boolean z = this.f3141j == null;
        this.f3141j = c1376g;
        if (z) {
            m2798a((int) Math.max(this.f3139h, c1376g.m2909m()), (int) Math.min(this.f3140i, c1376g.m2901e()));
        } else {
            m2798a((int) c1376g.m2909m(), (int) c1376g.m2901e());
        }
        float f2 = this.f3137f;
        this.f3137f = 0.0f;
        m2797a((int) f2);
        m2779c();
    }

    /* renamed from: b */
    public void m2801b(float f2) {
        m2798a(this.f3139h, f2);
    }

    /* renamed from: c */
    public void m2802c(float f2) {
        this.f3134c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        m2775a();
        m2814n();
    }

    /* renamed from: d */
    public void m2804d() {
        this.f3141j = null;
        this.f3139h = -2.1474836E9f;
        this.f3140i = 2.1474836E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        m2813m();
        if (this.f3141j == null || !isRunning()) {
            return;
        }
        C1374e.m2881a("LottieValueAnimator#doFrame");
        float m2794q = (this.f3136e != 0 ? j2 - r1 : 0L) / m2794q();
        float f2 = this.f3137f;
        if (m2795r()) {
            m2794q = -m2794q;
        }
        this.f3137f = f2 + m2794q;
        boolean z = !C1357g.m2830b(this.f3137f, m2809i(), m2808h());
        this.f3137f = C1357g.m2820a(this.f3137f, m2809i(), m2808h());
        this.f3136e = j2;
        m2779c();
        if (z) {
            if (getRepeatCount() == -1 || this.f3138g < getRepeatCount()) {
                m2777b();
                this.f3138g++;
                if (getRepeatMode() == 2) {
                    this.f3135d = !this.f3135d;
                    m2816p();
                } else {
                    this.f3137f = m2795r() ? m2808h() : m2809i();
                }
                this.f3136e = j2;
            } else {
                this.f3137f = this.f3134c < 0.0f ? m2809i() : m2808h();
                m2814n();
                m2776a(m2795r());
            }
        }
        m2796s();
        C1374e.m2883b("LottieValueAnimator#doFrame");
    }

    @MainThread
    /* renamed from: e */
    public void m2805e() {
        m2814n();
        m2776a(m2795r());
    }

    @FloatRange(from = 0.0d, m293to = 1.0d)
    /* renamed from: f */
    public float m2806f() {
        C1376g c1376g = this.f3141j;
        if (c1376g == null) {
            return 0.0f;
        }
        return (this.f3137f - c1376g.m2909m()) / (this.f3141j.m2901e() - this.f3141j.m2909m());
    }

    /* renamed from: g */
    public float m2807g() {
        return this.f3137f;
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, m293to = 1.0d)
    public float getAnimatedFraction() {
        float m2809i;
        float m2808h;
        float m2809i2;
        if (this.f3141j == null) {
            return 0.0f;
        }
        if (m2795r()) {
            m2809i = m2808h() - this.f3137f;
            m2808h = m2808h();
            m2809i2 = m2809i();
        } else {
            m2809i = this.f3137f - m2809i();
            m2808h = m2808h();
            m2809i2 = m2809i();
        }
        return m2809i / (m2808h - m2809i2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m2806f());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        C1376g c1376g = this.f3141j;
        if (c1376g == null) {
            return 0L;
        }
        return (long) c1376g.m2898c();
    }

    /* renamed from: h */
    public float m2808h() {
        C1376g c1376g = this.f3141j;
        if (c1376g == null) {
            return 0.0f;
        }
        float f2 = this.f3140i;
        return f2 == 2.1474836E9f ? c1376g.m2901e() : f2;
    }

    /* renamed from: i */
    public float m2809i() {
        C1376g c1376g = this.f3141j;
        if (c1376g == null) {
            return 0.0f;
        }
        float f2 = this.f3139h;
        return f2 == -2.1474836E9f ? c1376g.m2909m() : f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f3142k;
    }

    /* renamed from: j */
    public float m2810j() {
        return this.f3134c;
    }

    @MainThread
    /* renamed from: k */
    public void m2811k() {
        m2814n();
    }

    @MainThread
    /* renamed from: l */
    public void m2812l() {
        this.f3142k = true;
        m2778b(m2795r());
        m2797a((int) (m2795r() ? m2808h() : m2809i()));
        this.f3136e = 0L;
        this.f3138g = 0;
        m2813m();
    }

    /* renamed from: m */
    protected void m2813m() {
        if (isRunning()) {
            m2803c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    /* renamed from: n */
    protected void m2814n() {
        m2803c(true);
    }

    @MainThread
    /* renamed from: o */
    public void m2815o() {
        this.f3142k = true;
        m2813m();
        this.f3136e = 0L;
        if (m2795r() && m2807g() == m2809i()) {
            this.f3137f = m2808h();
        } else {
            if (m2795r() || m2807g() != m2808h()) {
                return;
            }
            this.f3137f = m2809i();
        }
    }

    /* renamed from: p */
    public void m2816p() {
        m2802c(-m2810j());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f3135d) {
            return;
        }
        this.f3135d = false;
        m2816p();
    }

    @MainThread
    /* renamed from: c */
    protected void m2803c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f3142k = false;
        }
    }

    /* renamed from: a */
    public void m2797a(float f2) {
        if (this.f3137f == f2) {
            return;
        }
        this.f3137f = C1357g.m2820a(f2, m2809i(), m2808h());
        this.f3136e = 0L;
        m2779c();
    }

    /* renamed from: a */
    public void m2799a(int i2) {
        m2798a(i2, (int) this.f3140i);
    }

    /* renamed from: a */
    public void m2798a(float f2, float f3) {
        if (f2 <= f3) {
            C1376g c1376g = this.f3141j;
            float m2909m = c1376g == null ? -3.4028235E38f : c1376g.m2909m();
            C1376g c1376g2 = this.f3141j;
            float m2901e = c1376g2 == null ? Float.MAX_VALUE : c1376g2.m2901e();
            float m2820a = C1357g.m2820a(f2, m2909m, m2901e);
            float m2820a2 = C1357g.m2820a(f3, m2909m, m2901e);
            if (m2820a == this.f3139h && m2820a2 == this.f3140i) {
                return;
            }
            this.f3139h = m2820a;
            this.f3140i = m2820a2;
            m2797a((int) C1357g.m2820a(this.f3137f, m2820a, m2820a2));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }
}
