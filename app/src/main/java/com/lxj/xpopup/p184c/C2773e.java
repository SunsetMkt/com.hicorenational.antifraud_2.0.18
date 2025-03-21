package com.lxj.xpopup.p184c;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.C2768b;

/* compiled from: ShadowBgAnimator.java */
/* renamed from: com.lxj.xpopup.c.e */
/* loaded from: classes.dex */
public class C2773e extends AbstractC2770b {

    /* renamed from: c */
    public ArgbEvaluator f8584c;

    /* renamed from: d */
    public int f8585d;

    /* renamed from: e */
    public boolean f8586e;

    /* compiled from: ShadowBgAnimator.java */
    /* renamed from: com.lxj.xpopup.c.e$a */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2773e.this.f8569a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: ShadowBgAnimator.java */
    /* renamed from: com.lxj.xpopup.c.e$b */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2773e.this.f8569a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public C2773e(View view) {
        super(view);
        this.f8584c = new ArgbEvaluator();
        this.f8585d = 0;
        this.f8586e = false;
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: a */
    public void mo8347a() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f8584c, Integer.valueOf(C2768b.m8298c()), Integer.valueOf(this.f8585d));
        ofObject.addUpdateListener(new b());
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.f8586e ? 0L : C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: b */
    public void mo8348b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f8584c, Integer.valueOf(this.f8585d), Integer.valueOf(C2768b.m8298c()));
        ofObject.addUpdateListener(new a());
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.f8586e ? 0L : C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: d */
    public void mo8349d() {
        this.f8569a.setBackgroundColor(this.f8585d);
    }

    public C2773e() {
        this.f8584c = new ArgbEvaluator();
        this.f8585d = 0;
        this.f8586e = false;
    }

    /* renamed from: a */
    public int m8361a(float f2) {
        return ((Integer) this.f8584c.evaluate(f2, Integer.valueOf(this.f8585d), Integer.valueOf(C2768b.m8298c()))).intValue();
    }
}
