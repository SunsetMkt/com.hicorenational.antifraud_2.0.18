package com.lxj.xpopup.p184c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2803c;

/* compiled from: TranslateAnimator.java */
/* renamed from: com.lxj.xpopup.c.g */
/* loaded from: classes.dex */
public class C2775g extends AbstractC2770b {

    /* renamed from: c */
    private float f8594c;

    /* renamed from: d */
    private float f8595d;

    /* renamed from: e */
    private int f8596e;

    /* renamed from: f */
    private int f8597f;

    /* renamed from: g */
    private float f8598g;

    /* renamed from: h */
    private float f8599h;

    /* renamed from: i */
    private boolean f8600i;

    /* compiled from: TranslateAnimator.java */
    /* renamed from: com.lxj.xpopup.c.g$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8601a = new int[EnumC2803c.values().length];

        static {
            try {
                f8601a[EnumC2803c.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8601a[EnumC2803c.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8601a[EnumC2803c.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8601a[EnumC2803c.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C2775g(View view, EnumC2803c enumC2803c) {
        super(view, enumC2803c);
        this.f8600i = false;
    }

    /* renamed from: e */
    private void m8363e() {
        int i2 = a.f8601a[this.f8570b.ordinal()];
        if (i2 == 1) {
            this.f8569a.setTranslationX(-r0.getRight());
            return;
        }
        if (i2 == 2) {
            this.f8569a.setTranslationY(-r0.getBottom());
        } else if (i2 == 3) {
            this.f8569a.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.f8569a.getLeft());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f8569a.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.f8569a.getTop());
        }
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: a */
    public void mo8347a() {
        int i2 = a.f8601a[this.f8570b.ordinal()];
        if (i2 == 1) {
            this.f8594c -= this.f8569a.getMeasuredWidth() - this.f8596e;
        } else if (i2 == 2) {
            this.f8595d -= this.f8569a.getMeasuredHeight() - this.f8597f;
        } else if (i2 == 3) {
            this.f8594c += this.f8569a.getMeasuredWidth() - this.f8596e;
        } else if (i2 == 4) {
            this.f8595d += this.f8569a.getMeasuredHeight() - this.f8597f;
        }
        this.f8569a.animate().translationX(this.f8594c).translationY(this.f8595d).setInterpolator(new FastOutSlowInInterpolator()).setDuration(C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: b */
    public void mo8348b() {
        this.f8569a.animate().translationX(this.f8598g).translationY(this.f8599h).setInterpolator(new FastOutSlowInInterpolator()).setDuration(C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: d */
    public void mo8349d() {
        if (!this.f8600i) {
            this.f8598g = this.f8569a.getTranslationX();
            this.f8599h = this.f8569a.getTranslationY();
            this.f8600i = true;
        }
        m8363e();
        this.f8594c = this.f8569a.getTranslationX();
        this.f8595d = this.f8569a.getTranslationY();
        this.f8596e = this.f8569a.getMeasuredWidth();
        this.f8597f = this.f8569a.getMeasuredHeight();
    }
}
