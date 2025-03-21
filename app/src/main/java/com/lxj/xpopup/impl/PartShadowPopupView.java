package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2775g;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.p186e.InterfaceC2808b;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public abstract class PartShadowPopupView extends AttachPopupView {

    /* renamed from: com.lxj.xpopup.impl.PartShadowPopupView$a */
    class ViewOnLongClickListenerC2827a implements View.OnLongClickListener {
        ViewOnLongClickListenerC2827a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PartShadowPopupView.this.f8617a.f8690c.booleanValue()) {
                return false;
            }
            PartShadowPopupView.this.mo8378b();
            return false;
        }
    }

    /* renamed from: com.lxj.xpopup.impl.PartShadowPopupView$b */
    class C2828b implements InterfaceC2808b {
        C2828b() {
        }

        @Override // com.lxj.xpopup.p186e.InterfaceC2808b
        /* renamed from: a */
        public void mo8428a() {
            if (PartShadowPopupView.this.f8617a.f8690c.booleanValue()) {
                PartShadowPopupView.this.mo8378b();
            }
        }
    }

    public PartShadowPopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return new C2775g(getPopupImplView(), this.f8605s ? EnumC2803c.TranslateFromBottom : EnumC2803c.TranslateFromTop);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        int i2 = this.f8617a.f8707t;
        if (i2 == 0) {
            i2 = C2819c.m8449a(getContext(), 0.0f);
        }
        this.f8602p = i2;
        int i3 = this.f8617a.f8706s;
        if (i3 == 0) {
            i3 = C2819c.m8449a(getContext(), 0.0f);
        }
        this.f8603q = i3;
        getPopupImplView().setTranslationX(this.f8617a.f8706s);
        getPopupImplView().setTranslationY(this.f8617a.f8707t);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8617a.f8690c.booleanValue()) {
            mo8378b();
        }
        return !this.f8617a.f8690c.booleanValue();
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    /* renamed from: u */
    protected void mo8365u() {
        if (this.f8617a.m8427a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
        }
        this.f8619c.f8569a = getPopupContentView();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        if (rotation == 0) {
            marginLayoutParams.width = getMeasuredWidth();
        } else if (rotation == 1 || rotation == 3) {
            marginLayoutParams.width = getMeasuredWidth() - (C2819c.m8474d(getContext()) ? C2819c.m8465b() : 0);
        }
        if (this.f8617a.f8709v && getPopupImplView() != null) {
            getPopupImplView().setTranslationX((C2819c.m8472c(getContext()) / 2.0f) - (getPopupContentView().getMeasuredWidth() / 2.0f));
        }
        int[] iArr = new int[2];
        this.f8617a.m8427a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.f8617a.m8427a().getMeasuredWidth(), iArr[1] + this.f8617a.m8427a().getMeasuredHeight());
        if ((rect.top + (rect.height() / 2) > getMeasuredHeight() / 2 || this.f8617a.f8704q == EnumC2804d.Top) && this.f8617a.f8704q != EnumC2804d.Bottom) {
            marginLayoutParams.height = rect.top;
            this.f8605s = true;
            marginLayoutParams.topMargin = -this.f8602p;
            View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        } else {
            marginLayoutParams.height = getMeasuredHeight() - rect.bottom;
            if (C2819c.m8474d(getContext())) {
                marginLayoutParams.height -= C2819c.m8465b();
            }
            this.f8605s = false;
            marginLayoutParams.topMargin = rect.bottom + this.f8602p;
            View childAt2 = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams2.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams2.height = Math.min(childAt2.getMeasuredHeight(), getMaxHeight());
            }
            childAt2.setLayoutParams(layoutParams2);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        this.f8604r.setOnLongClickListener(new ViewOnLongClickListenerC2827a());
        this.f8604r.setOnClickOutsideListener(new C2828b());
    }
}
