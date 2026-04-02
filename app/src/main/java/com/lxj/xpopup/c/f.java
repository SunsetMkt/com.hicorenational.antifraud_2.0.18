package com.lxj.xpopup.c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: TranslateAlphaAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f5414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f5415f;

    /* JADX INFO: compiled from: TranslateAlphaAnimator.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
    }

    private void e() {
        int iC = com.lxj.xpopup.f.c.c(this.a.getContext()) / 2;
        int measuredWidth = this.a.getMeasuredWidth() / 2;
        int iB = com.lxj.xpopup.f.c.b(this.a.getContext()) / 2;
        int measuredHeight = this.a.getMeasuredHeight() / 2;
        int i2 = a.a[this.f5401b.ordinal()];
        if (i2 == 1) {
            this.a.setTranslationX(-r0.getMeasuredWidth());
            return;
        }
        if (i2 == 2) {
            this.a.setTranslationY(-r0.getMeasuredHeight());
        } else if (i2 == 3) {
            this.a.setTranslationX(r0.getMeasuredWidth());
        } else {
            if (i2 != 4) {
                return;
            }
            this.a.setTranslationY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        this.a.animate().translationX(this.f5412c).translationY(this.f5413d).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.a.animate().translationX(this.f5414e).translationY(this.f5415f).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.f5414e = this.a.getTranslationX();
        this.f5415f = this.a.getTranslationY();
        this.a.setAlpha(0.0f);
        e();
        this.f5412c = this.a.getTranslationX();
        this.f5413d = this.a.getTranslationY();
    }
}
