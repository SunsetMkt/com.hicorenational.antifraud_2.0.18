package com.lxj.xpopup.c;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: compiled from: ScaleAlphaAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends com.lxj.xpopup.c.b {

    /* JADX INFO: compiled from: ScaleAlphaAnimator.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.e();
        }
    }

    /* JADX INFO: compiled from: ScaleAlphaAnimator.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(View view, com.lxj.xpopup.d.c cVar) {
        super(view, cVar);
    }

    public void e() {
        int i2 = b.a[this.f5401b.ordinal()];
        if (i2 == 1) {
            this.a.setPivotX(r0.getMeasuredWidth() / 2);
            this.a.setPivotY(r0.getMeasuredHeight() / 2);
            return;
        }
        if (i2 == 2) {
            this.a.setPivotX(0.0f);
            this.a.setPivotY(0.0f);
            return;
        }
        if (i2 == 3) {
            this.a.setPivotX(r0.getMeasuredWidth());
            this.a.setPivotY(0.0f);
        } else if (i2 == 4) {
            this.a.setPivotX(0.0f);
            this.a.setPivotY(r0.getMeasuredHeight());
        } else {
            if (i2 != 5) {
                return;
            }
            this.a.setPivotX(r0.getMeasuredWidth());
            this.a.setPivotY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.c.b
    public void b() {
        this.a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(com.lxj.xpopup.b.a()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    @Override // com.lxj.xpopup.c.b
    public void d() {
        this.a.setScaleX(0.0f);
        this.a.setScaleY(0.0f);
        this.a.setAlpha(0.0f);
        this.a.post(new a());
    }

    @Override // com.lxj.xpopup.c.b
    public void a() {
        this.a.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(com.lxj.xpopup.b.a()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }
}
