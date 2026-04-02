package com.lxj.xpopup.c;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: TranslateAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f5420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f5421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5422i;

    /* JADX INFO: compiled from: TranslateAnimator.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.c.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
        this.f5422i = false;
    }

    private void e() {
        int i2 = a.a[this.f5401b.ordinal()];
        if (i2 == 1) {
            this.a.setTranslationX(-r0.getRight());
            return;
        }
        if (i2 == 2) {
            this.a.setTranslationY(-r0.getBottom());
        } else if (i2 == 3) {
            this.a.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.a.getLeft());
        } else {
            if (i2 != 4) {
                return;
            }
            this.a.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.a.getTop());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        int i2 = a.a[this.f5401b.ordinal()];
        if (i2 == 1) {
            this.f5416c -= this.a.getMeasuredWidth() - this.f5418e;
        } else if (i2 == 2) {
            this.f5417d -= this.a.getMeasuredHeight() - this.f5419f;
        } else if (i2 == 3) {
            this.f5416c += this.a.getMeasuredWidth() - this.f5418e;
        } else if (i2 == 4) {
            this.f5417d += this.a.getMeasuredHeight() - this.f5419f;
        }
        this.a.animate().translationX(this.f5416c).translationY(this.f5417d).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.a.animate().translationX(this.f5420g).translationY(this.f5421h).setInterpolator(new FastOutSlowInInterpolator()).setDuration(com.lxj.xpopup.b.a()).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        if (!this.f5422i) {
            this.f5420g = this.a.getTranslationX();
            this.f5421h = this.a.getTranslationY();
            this.f5422i = true;
        }
        e();
        this.f5416c = this.a.getTranslationX();
        this.f5417d = this.a.getTranslationY();
        this.f5418e = this.a.getMeasuredWidth();
        this.f5419f = this.a.getMeasuredHeight();
    }
}
