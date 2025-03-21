package com.lxj.xpopup.p184c;

import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2803c;

/* compiled from: ScrollScaleAnimator.java */
/* renamed from: com.lxj.xpopup.c.d */
/* loaded from: classes.dex */
public class C2772d extends AbstractC2770b {

    /* renamed from: c */
    private FloatEvaluator f8573c;

    /* renamed from: d */
    private IntEvaluator f8574d;

    /* renamed from: e */
    private int f8575e;

    /* renamed from: f */
    private int f8576f;

    /* renamed from: g */
    private float f8577g;

    /* renamed from: h */
    private float f8578h;

    /* renamed from: i */
    public boolean f8579i;

    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.c.d$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2772d.this.m8358e();
            C2772d c2772d = C2772d.this;
            c2772d.f8569a.scrollTo(c2772d.f8575e, C2772d.this.f8576f);
            if (C2772d.this.f8569a.getBackground() != null) {
                C2772d.this.f8569a.getBackground().setAlpha(0);
            }
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.c.d$b */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            C2772d c2772d = C2772d.this;
            View view = c2772d.f8569a;
            FloatEvaluator floatEvaluator = c2772d.f8573c;
            Float valueOf = Float.valueOf(C2772d.this.f8577g);
            Float valueOf2 = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) valueOf, (Number) valueOf2).floatValue());
            C2772d c2772d2 = C2772d.this;
            c2772d2.f8569a.scrollTo(c2772d2.f8574d.evaluate(animatedFraction, Integer.valueOf(C2772d.this.f8575e), (Integer) 0).intValue(), C2772d.this.f8574d.evaluate(animatedFraction, Integer.valueOf(C2772d.this.f8576f), (Integer) 0).intValue());
            float floatValue = C2772d.this.f8573c.evaluate(animatedFraction, (Number) Float.valueOf(C2772d.this.f8578h), (Number) valueOf2).floatValue();
            C2772d.this.f8569a.setScaleX(floatValue);
            C2772d c2772d3 = C2772d.this;
            if (!c2772d3.f8579i) {
                c2772d3.f8569a.setScaleY(floatValue);
            }
            if (animatedFraction < 0.9f || C2772d.this.f8569a.getBackground() == null) {
                return;
            }
            C2772d.this.f8569a.getBackground().setAlpha((int) (((animatedFraction - 0.9f) / 0.1f) * 255.0f));
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.c.d$c */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            C2772d c2772d = C2772d.this;
            View view = c2772d.f8569a;
            FloatEvaluator floatEvaluator = c2772d.f8573c;
            Float valueOf = Float.valueOf(1.0f);
            view.setAlpha(floatEvaluator.evaluate(animatedFraction, (Number) valueOf, (Number) Float.valueOf(C2772d.this.f8577g)).floatValue());
            C2772d c2772d2 = C2772d.this;
            c2772d2.f8569a.scrollTo(c2772d2.f8574d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(C2772d.this.f8575e)).intValue(), C2772d.this.f8574d.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(C2772d.this.f8576f)).intValue());
            float floatValue = C2772d.this.f8573c.evaluate(animatedFraction, (Number) valueOf, (Number) Float.valueOf(C2772d.this.f8578h)).floatValue();
            C2772d.this.f8569a.setScaleX(floatValue);
            C2772d c2772d3 = C2772d.this;
            if (!c2772d3.f8579i) {
                c2772d3.f8569a.setScaleY(floatValue);
            }
            if (C2772d.this.f8569a.getBackground() != null) {
                C2772d.this.f8569a.getBackground().setAlpha((int) (animatedFraction * 255.0f));
            }
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    /* renamed from: com.lxj.xpopup.c.d$d */
    static /* synthetic */ class d {

        /* renamed from: a */
        static final /* synthetic */ int[] f8583a = new int[EnumC2803c.values().length];

        static {
            try {
                f8583a[EnumC2803c.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8583a[EnumC2803c.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public C2772d(View view, EnumC2803c enumC2803c) {
        super(view, enumC2803c);
        this.f8573c = new FloatEvaluator();
        this.f8574d = new IntEvaluator();
        this.f8577g = 0.2f;
        this.f8578h = 0.0f;
        this.f8579i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8358e() {
        switch (d.f8583a[this.f8570b.ordinal()]) {
            case 1:
                this.f8569a.setPivotX(0.0f);
                this.f8569a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f8575e = this.f8569a.getMeasuredWidth();
                this.f8576f = 0;
                break;
            case 2:
                this.f8569a.setPivotX(0.0f);
                this.f8569a.setPivotY(0.0f);
                this.f8575e = this.f8569a.getMeasuredWidth();
                this.f8576f = this.f8569a.getMeasuredHeight();
                break;
            case 3:
                this.f8569a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f8569a.setPivotY(0.0f);
                this.f8576f = this.f8569a.getMeasuredHeight();
                break;
            case 4:
                this.f8569a.setPivotX(r0.getMeasuredWidth());
                this.f8569a.setPivotY(0.0f);
                this.f8575e = -this.f8569a.getMeasuredWidth();
                this.f8576f = this.f8569a.getMeasuredHeight();
                break;
            case 5:
                this.f8569a.setPivotX(r0.getMeasuredWidth());
                this.f8569a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f8575e = -this.f8569a.getMeasuredWidth();
                break;
            case 6:
                this.f8569a.setPivotX(r0.getMeasuredWidth());
                this.f8569a.setPivotY(r0.getMeasuredHeight());
                this.f8575e = -this.f8569a.getMeasuredWidth();
                this.f8576f = -this.f8569a.getMeasuredHeight();
                break;
            case 7:
                this.f8569a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f8569a.setPivotY(r0.getMeasuredHeight());
                this.f8576f = -this.f8569a.getMeasuredHeight();
                break;
            case 8:
                this.f8569a.setPivotX(0.0f);
                this.f8569a.setPivotY(r0.getMeasuredHeight());
                this.f8575e = this.f8569a.getMeasuredWidth();
                this.f8576f = -this.f8569a.getMeasuredHeight();
                break;
        }
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: a */
    public void mo8347a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new c());
        ofFloat.setDuration(C2768b.m8294a()).setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: b */
    public void mo8348b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.setDuration(C2768b.m8294a()).setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: d */
    public void mo8349d() {
        this.f8569a.setAlpha(this.f8577g);
        this.f8569a.setScaleX(this.f8578h);
        if (!this.f8579i) {
            this.f8569a.setScaleY(this.f8578h);
        }
        this.f8569a.post(new a());
    }
}
