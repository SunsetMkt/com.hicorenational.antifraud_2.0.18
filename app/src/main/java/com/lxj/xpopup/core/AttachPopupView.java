package com.lxj.xpopup.core;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2772d;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.p187f.C2819c;
import com.lxj.xpopup.widget.PartShadowContainer;

/* loaded from: classes.dex */
public abstract class AttachPopupView extends BasePopupView {

    /* renamed from: p */
    protected int f8602p;

    /* renamed from: q */
    protected int f8603q;

    /* renamed from: r */
    protected PartShadowContainer f8604r;

    /* renamed from: s */
    public boolean f8605s;

    /* renamed from: t */
    boolean f8606t;

    /* renamed from: u */
    protected int f8607u;

    /* renamed from: v */
    float f8608v;

    /* renamed from: w */
    float f8609w;

    /* renamed from: x */
    float f8610x;

    /* renamed from: y */
    float f8611y;

    /* renamed from: com.lxj.xpopup.core.AttachPopupView$a */
    class RunnableC2776a implements Runnable {
        RunnableC2776a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView.this.mo8365u();
        }
    }

    /* renamed from: com.lxj.xpopup.core.AttachPopupView$b */
    class RunnableC2777b implements Runnable {
        RunnableC2777b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView attachPopupView = AttachPopupView.this;
            float f2 = attachPopupView.f8606t ? attachPopupView.f8617a.f8697j.x : attachPopupView.f8611y;
            AttachPopupView attachPopupView2 = AttachPopupView.this;
            boolean z = attachPopupView2.f8606t;
            int i2 = attachPopupView2.f8603q;
            if (!z) {
                i2 = -i2;
            }
            attachPopupView.f8608v = f2 + i2;
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f8617a.f8709v) {
                if (attachPopupView3.f8606t) {
                    attachPopupView3.f8608v -= attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                } else {
                    attachPopupView3.f8608v += attachPopupView3.getPopupContentView().getMeasuredWidth() / 2.0f;
                }
            }
            if (AttachPopupView.this.m8366v()) {
                AttachPopupView attachPopupView4 = AttachPopupView.this;
                attachPopupView4.f8609w = (attachPopupView4.f8617a.f8697j.y - attachPopupView4.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.f8602p;
            } else {
                AttachPopupView attachPopupView5 = AttachPopupView.this;
                attachPopupView5.f8609w = attachPopupView5.f8617a.f8697j.y + attachPopupView5.f8602p;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.f8608v);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.f8609w);
        }
    }

    /* renamed from: com.lxj.xpopup.core.AttachPopupView$c */
    class RunnableC2778c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Rect f8614a;

        RunnableC2778c(Rect rect) {
            this.f8614a = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            AttachPopupView attachPopupView = AttachPopupView.this;
            float f2 = attachPopupView.f8606t ? this.f8614a.left : attachPopupView.f8611y;
            AttachPopupView attachPopupView2 = AttachPopupView.this;
            boolean z = attachPopupView2.f8606t;
            int i2 = attachPopupView2.f8603q;
            if (!z) {
                i2 = -i2;
            }
            attachPopupView.f8608v = f2 + i2;
            AttachPopupView attachPopupView3 = AttachPopupView.this;
            if (attachPopupView3.f8617a.f8709v) {
                if (attachPopupView3.f8606t) {
                    attachPopupView3.f8608v += (this.f8614a.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                } else {
                    attachPopupView3.f8608v -= (this.f8614a.width() - AttachPopupView.this.getPopupContentView().getMeasuredWidth()) / 2.0f;
                }
            }
            if (AttachPopupView.this.m8366v()) {
                AttachPopupView.this.f8609w = (this.f8614a.top - r0.getPopupContentView().getMeasuredHeight()) - AttachPopupView.this.f8602p;
            } else {
                AttachPopupView.this.f8609w = this.f8614a.bottom + r0.f8602p;
            }
            AttachPopupView.this.getPopupContentView().setTranslationX(AttachPopupView.this.f8608v);
            AttachPopupView.this.getPopupContentView().setTranslationY(AttachPopupView.this.f8609w);
        }
    }

    public AttachPopupView(@NonNull Context context) {
        super(context);
        this.f8602p = 0;
        this.f8603q = 0;
        this.f8607u = 6;
        this.f8608v = 0.0f;
        this.f8609w = 0.0f;
        this.f8610x = C2819c.m8466b(getContext());
        this.f8611y = 0.0f;
        this.f8604r = (PartShadowContainer) findViewById(C2766R.id.attachPopupContainer);
        this.f8604r.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8604r, false));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return m8366v() ? this.f8606t ? new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromLeftBottom) : new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromRightBottom) : this.f8606t ? new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromLeftTop) : new C2772d(getPopupContentView(), EnumC2803c.ScrollAlphaFromRightTop);
    }

    protected Drawable getPopupBackground() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        if (this.f8617a.m8427a() == null && this.f8617a.f8697j == null) {
            throw new IllegalArgumentException("atView() or touchPoint must not be null for AttachPopupView ！");
        }
        int i2 = this.f8617a.f8707t;
        if (i2 == 0) {
            i2 = C2819c.m8449a(getContext(), 4.0f);
        }
        this.f8602p = i2;
        int i3 = this.f8617a.f8706s;
        if (i3 == 0) {
            i3 = C2819c.m8449a(getContext(), 0.0f);
        }
        this.f8603q = i3;
        getPopupImplView().setTranslationX(this.f8617a.f8706s);
        getPopupImplView().setTranslationY(this.f8617a.f8707t);
        if (!this.f8617a.f8692e.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                if (getPopupBackground() == null) {
                    this.f8604r.setBackgroundColor(-1);
                } else {
                    this.f8604r.setBackgroundDrawable(getPopupBackground());
                }
                this.f8604r.setElevation(C2819c.m8449a(getContext(), 10.0f));
            } else if (getPopupImplView().getBackground() == null) {
                int i4 = this.f8603q;
                int i5 = this.f8607u;
                this.f8603q = i4 - i5;
                this.f8602p -= i5;
                this.f8604r.setBackgroundResource(C2766R.drawable._xpopup_shadow);
            } else {
                this.f8604r.setBackgroundDrawable(getPopupBackground());
            }
        }
        C2819c.m8459a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new RunnableC2776a());
    }

    /* renamed from: u */
    protected void mo8365u() {
        C2800a c2800a = this.f8617a;
        PointF pointF = c2800a.f8697j;
        if (pointF != null) {
            this.f8611y = Math.max(pointF.x - getPopupContentView().getMeasuredWidth(), 0.0f);
            if (this.f8617a.f8697j.y + ((float) getPopupContentView().getMeasuredHeight()) > this.f8610x) {
                this.f8605s = this.f8617a.f8697j.y > ((float) (C2819c.m8466b(getContext()) / 2));
            } else {
                this.f8605s = false;
            }
            this.f8606t = this.f8617a.f8697j.x < ((float) (C2819c.m8472c(getContext()) / 2));
            if (m8366v()) {
                if (getPopupContentView().getMeasuredHeight() > this.f8617a.f8697j.y) {
                    ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
                    layoutParams.height = (int) (this.f8617a.f8697j.y - C2819c.m8471c());
                    getPopupContentView().setLayoutParams(layoutParams);
                }
            } else if (getPopupContentView().getMeasuredHeight() + this.f8617a.f8697j.y > C2819c.m8466b(getContext())) {
                ViewGroup.LayoutParams layoutParams2 = getPopupContentView().getLayoutParams();
                layoutParams2.height = (int) (C2819c.m8466b(getContext()) - this.f8617a.f8697j.y);
                getPopupContentView().setLayoutParams(layoutParams2);
            }
            getPopupContentView().post(new RunnableC2777b());
            return;
        }
        int[] iArr = new int[2];
        c2800a.m8427a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f8617a.m8427a().getMeasuredWidth(), iArr[1] + this.f8617a.m8427a().getMeasuredHeight());
        this.f8611y = Math.max(rect.right - getPopupContentView().getMeasuredWidth(), 0);
        int i2 = (rect.left + rect.right) / 2;
        if (((float) (rect.bottom + getPopupContentView().getMeasuredHeight())) > this.f8610x) {
            this.f8605s = (rect.top + rect.bottom) / 2 > C2819c.m8466b(getContext()) / 2;
        } else {
            this.f8605s = false;
        }
        this.f8606t = i2 < C2819c.m8472c(getContext()) / 2;
        if (m8366v()) {
            if (getPopupContentView().getMeasuredHeight() > rect.top) {
                ViewGroup.LayoutParams layoutParams3 = getPopupContentView().getLayoutParams();
                layoutParams3.height = rect.top - C2819c.m8471c();
                getPopupContentView().setLayoutParams(layoutParams3);
            }
        } else if (getPopupContentView().getMeasuredHeight() + rect.bottom > C2819c.m8466b(getContext())) {
            ViewGroup.LayoutParams layoutParams4 = getPopupContentView().getLayoutParams();
            layoutParams4.height = C2819c.m8466b(getContext()) - rect.bottom;
            getPopupContentView().setLayoutParams(layoutParams4);
        }
        getPopupContentView().post(new RunnableC2778c(rect));
    }

    /* renamed from: v */
    protected boolean m8366v() {
        return (this.f8605s || this.f8617a.f8704q == EnumC2804d.Top) && this.f8617a.f8704q != EnumC2804d.Bottom;
    }
}
