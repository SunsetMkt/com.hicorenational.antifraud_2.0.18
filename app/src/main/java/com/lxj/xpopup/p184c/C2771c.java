package com.lxj.xpopup.p184c;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2803c;

/* compiled from: ScaleAlphaAnimator.java */
/* renamed from: com.lxj.xpopup.c.c */
/* loaded from: classes.dex */
public class C2771c extends AbstractC2770b {

    /* compiled from: ScaleAlphaAnimator.java */
    /* renamed from: com.lxj.xpopup.c.c$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2771c.this.m8352e();
        }
    }

    /* compiled from: ScaleAlphaAnimator.java */
    /* renamed from: com.lxj.xpopup.c.c$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f8572a = new int[EnumC2803c.values().length];

        static {
            try {
                f8572a[EnumC2803c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8572a[EnumC2803c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8572a[EnumC2803c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8572a[EnumC2803c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8572a[EnumC2803c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C2771c(View view, EnumC2803c enumC2803c) {
        super(view, enumC2803c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8352e() {
        int i2 = b.f8572a[this.f8570b.ordinal()];
        if (i2 == 1) {
            this.f8569a.setPivotX(r0.getMeasuredWidth() / 2);
            this.f8569a.setPivotY(r0.getMeasuredHeight() / 2);
            return;
        }
        if (i2 == 2) {
            this.f8569a.setPivotX(0.0f);
            this.f8569a.setPivotY(0.0f);
            return;
        }
        if (i2 == 3) {
            this.f8569a.setPivotX(r0.getMeasuredWidth());
            this.f8569a.setPivotY(0.0f);
        } else if (i2 == 4) {
            this.f8569a.setPivotX(0.0f);
            this.f8569a.setPivotY(r0.getMeasuredHeight());
        } else {
            if (i2 != 5) {
                return;
            }
            this.f8569a.setPivotX(r0.getMeasuredWidth());
            this.f8569a.setPivotY(r0.getMeasuredHeight());
        }
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: b */
    public void mo8348b() {
        this.f8569a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(C2768b.m8294a()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: d */
    public void mo8349d() {
        this.f8569a.setScaleX(0.0f);
        this.f8569a.setScaleY(0.0f);
        this.f8569a.setAlpha(0.0f);
        this.f8569a.post(new a());
    }

    @Override // com.lxj.xpopup.p184c.AbstractC2770b
    /* renamed from: a */
    public void mo8347a() {
        this.f8569a.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(C2768b.m8294a()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }
}
