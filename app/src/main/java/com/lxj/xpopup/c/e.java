package com.lxj.xpopup.c;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: ShadowBgAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends com.lxj.xpopup.c.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArgbEvaluator f5409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5411e;

    /* JADX INFO: compiled from: ShadowBgAnimator.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: compiled from: ShadowBgAnimator.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public e(View view) {
        super(view);
        this.f5409c = new ArgbEvaluator();
        this.f5410d = 0;
        this.f5411e = false;
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f5409c, Integer.valueOf(com.lxj.xpopup.b.c()), Integer.valueOf(this.f5410d));
        valueAnimatorOfObject.addUpdateListener(new b());
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f5411e ? 0L : com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.f5409c, Integer.valueOf(this.f5410d), Integer.valueOf(com.lxj.xpopup.b.c()));
        valueAnimatorOfObject.addUpdateListener(new a());
        valueAnimatorOfObject.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfObject.setDuration(this.f5411e ? 0L : com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.a.setBackgroundColor(this.f5410d);
    }

    public e() {
        this.f5409c = new ArgbEvaluator();
        this.f5410d = 0;
        this.f5411e = false;
    }

    public int a(float f2) {
        return ((Integer) this.f5409c.evaluate(f2, Integer.valueOf(this.f5410d), Integer.valueOf(com.lxj.xpopup.b.c()))).intValue();
    }
}
