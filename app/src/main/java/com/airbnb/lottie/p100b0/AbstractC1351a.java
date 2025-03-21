package com.airbnb.lottie.p100b0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BaseLottieAnimator.java */
/* renamed from: com.airbnb.lottie.b0.a */
/* loaded from: classes.dex */
public abstract class AbstractC1351a extends ValueAnimator {

    /* renamed from: a */
    private final Set<ValueAnimator.AnimatorUpdateListener> f3130a = new CopyOnWriteArraySet();

    /* renamed from: b */
    private final Set<Animator.AnimatorListener> f3131b = new CopyOnWriteArraySet();

    /* renamed from: a */
    void m2776a(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f3131b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f3131b.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3130a.add(animatorUpdateListener);
    }

    /* renamed from: b */
    void m2778b(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.f3131b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* renamed from: c */
    void m2779c() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f3130a.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f3131b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f3130a.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f3131b.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3130a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    /* renamed from: a */
    void m2775a() {
        Iterator<Animator.AnimatorListener> it = this.f3131b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    /* renamed from: b */
    void m2777b() {
        Iterator<Animator.AnimatorListener> it = this.f3131b.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }
}
