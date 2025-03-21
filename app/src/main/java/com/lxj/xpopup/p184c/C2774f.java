package com.lxj.xpopup.p184c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p187f.C2819c;

/* compiled from: TranslateAlphaAnimator.java */
/* renamed from: com.lxj.xpopup.c.f */
/* loaded from: classes.dex */
public class C2774f extends AbstractC2770b {

    /* renamed from: c */
    private float f8589c;

    /* renamed from: d */
    private float f8590d;

    /* renamed from: e */
    private float f8591e;

    /* renamed from: f */
    private float f8592f;

    /* compiled from: TranslateAlphaAnimator.java */
    /* renamed from: com.lxj.xpopup.c.f$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8593a = new int[EnumC2803c.values().length];

        static {
            try {
                f8593a[EnumC2803c.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8593a[EnumC2803c.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8593a[EnumC2803c.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8593a[EnumC2803c.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C2774f(View view, EnumC2803c enumC2803c) {
        super(view, enumC2803c);
    }

    /* renamed from: e */
    private void m8362e() {
        int m8472c = C2819c.m8472c(this.f8569a.getContext()) / 2;
        int measuredWidth = this.f8569a.getMeasuredWidth() / 2;
        int m8466b = C2819c.m8466b(this.f8569a.getContext()) / 2;
        int measuredHeight = this.f8569a.getMeasuredHeight() / 2;
        int i2 = a.f8593a[this.f8570b.ordinal()];
        if (i2 == 1) {
            this.f8569a.setTranslationX(-r0.getMeasuredWidth());
            return;
        }
        if (i2 == 2) {
            this.f8569a.setTranslationY(-r0.getMeasuredHeight());
        } else if (i2 == 3) {
            this.f8569a.setTranslationX(r0.getMeasuredWidth());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f8569a.setTranslationY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: a */
    public void mo8347a() {
        this.f8569a.animate().translationX(this.f8589c).translationY(this.f8590d).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: b */
    public void mo8348b() {
        this.f8569a.animate().translationX(this.f8591e).translationY(this.f8592f).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(C2768b.m8294a()).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: d */
    public void mo8349d() {
        this.f8591e = this.f8569a.getTranslationX();
        this.f8592f = this.f8569a.getTranslationY();
        this.f8569a.setAlpha(0.0f);
        m8362e();
        this.f8589c = this.f8569a.getTranslationX();
        this.f8590d = this.f8569a.getTranslationY();
    }
}
