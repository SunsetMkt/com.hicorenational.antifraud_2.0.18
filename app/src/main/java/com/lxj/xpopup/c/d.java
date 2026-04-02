package com.lxj.xpopup.c;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: ScrollScaleAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends com.lxj.xpopup.c.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FloatEvaluator f5402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IntEvaluator f5403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f5406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f5407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5408i;

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.e();
            d dVar = d.this;
            dVar.a.scrollTo(dVar.f5404e, d.this.f5405f);
            if (d.this.a.getBackground() != null) {
                d.this.a.getBackground().setAlpha(0);
            }
        }
    }

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = d.this;
            View view = dVar.a;
            FloatEvaluator floatEvaluator = dVar.f5402c;
            Float fValueOf = Float.valueOf(d.this.f5406g);
            Float fValueOf2 = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) fValueOf, (Number) fValueOf2).floatValue());
            d dVar2 = d.this;
            dVar2.a.scrollTo(dVar2.f5403d.evaluate(animatedFraction, Integer.valueOf(d.this.f5404e), (Integer) 0).intValue(), d.this.f5403d.evaluate(animatedFraction, Integer.valueOf(d.this.f5405f), (Integer) 0).intValue());
            float fFloatValue = d.this.f5402c.evaluate(animatedFraction, (Number) Float.valueOf(d.this.f5407h), (Number) fValueOf2).floatValue();
            d.this.a.setScaleX(fFloatValue);
            d dVar3 = d.this;
            if (!dVar3.f5408i) {
                dVar3.a.setScaleY(fFloatValue);
            }
            if (animatedFraction < 0.9f || d.this.a.getBackground() == null) {
                return;
            }
            d.this.a.getBackground().setAlpha((int) (((animatedFraction - 0.9f) / 0.1f) * 255.0f));
        }
    }

    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            d dVar = d.this;
            View view = dVar.a;
            FloatEvaluator floatEvaluator = dVar.f5402c;
            Float fValueOf = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) fValueOf, (Number) Float.valueOf(d.this.f5406g)).floatValue());
            d dVar2 = d.this;
            dVar2.a.scrollTo(dVar2.f5403d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.f5404e)).intValue(), d.this.f5403d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(d.this.f5405f)).intValue());
            float fFloatValue = d.this.f5402c.evaluate(animatedFraction, (Number) fValueOf, (Number) Float.valueOf(d.this.f5407h)).floatValue();
            d.this.a.setScaleX(fFloatValue);
            d dVar3 = d.this;
            if (!dVar3.f5408i) {
                dVar3.a.setScaleY(fFloatValue);
            }
            if (d.this.a.getBackground() != null) {
                d.this.a.getBackground().setAlpha((int) (animatedFraction * 255.0f));
            }
        }
    }

    /* JADX INFO: renamed from: com.lxj.xpopup.c.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScrollScaleAnimator.java */
    static /* synthetic */ class C0101d {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public d(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
        this.f5402c = new FloatEvaluator();
        this.f5403d = new IntEvaluator();
        this.f5406g = 0.2f;
        this.f5407h = 0.0f;
        this.f5408i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        switch (C0101d.a[this.f5401b.ordinal()]) {
            case 1:
                this.a.setPivotX(0.0f);
                this.a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f5404e = this.a.getMeasuredWidth();
                this.f5405f = 0;
                break;
            case 2:
                this.a.setPivotX(0.0f);
                this.a.setPivotY(0.0f);
                this.f5404e = this.a.getMeasuredWidth();
                this.f5405f = this.a.getMeasuredHeight();
                break;
            case 3:
                this.a.setPivotX(r0.getMeasuredWidth() / 2);
                this.a.setPivotY(0.0f);
                this.f5405f = this.a.getMeasuredHeight();
                break;
            case 4:
                this.a.setPivotX(r0.getMeasuredWidth());
                this.a.setPivotY(0.0f);
                this.f5404e = -this.a.getMeasuredWidth();
                this.f5405f = this.a.getMeasuredHeight();
                break;
            case 5:
                this.a.setPivotX(r0.getMeasuredWidth());
                this.a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f5404e = -this.a.getMeasuredWidth();
                break;
            case 6:
                this.a.setPivotX(r0.getMeasuredWidth());
                this.a.setPivotY(r0.getMeasuredHeight());
                this.f5404e = -this.a.getMeasuredWidth();
                this.f5405f = -this.a.getMeasuredHeight();
                break;
            case 7:
                this.a.setPivotX(r0.getMeasuredWidth() / 2);
                this.a.setPivotY(r0.getMeasuredHeight());
                this.f5405f = -this.a.getMeasuredHeight();
                break;
            case 8:
                this.a.setPivotX(0.0f);
                this.a.setPivotY(r0.getMeasuredHeight());
                this.f5404e = this.a.getMeasuredWidth();
                this.f5405f = -this.a.getMeasuredHeight();
                break;
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new c());
        valueAnimatorOfFloat.setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b());
        valueAnimatorOfFloat.setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator());
        valueAnimatorOfFloat.start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.a.setAlpha(this.f5406g);
        this.a.setScaleX(this.f5407h);
        if (!this.f5408i) {
            this.a.setScaleY(this.f5407h);
        }
        this.a.post(new a());
    }
}
