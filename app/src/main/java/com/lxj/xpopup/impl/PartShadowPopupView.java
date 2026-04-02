package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.c.g;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.d.c;
import com.lxj.xpopup.d.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PartShadowPopupView extends AttachPopupView {

    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (!PartShadowPopupView.this.a.f5442c.booleanValue()) {
                return false;
            }
            PartShadowPopupView.this.b();
            return false;
        }
    }

    class b implements com.lxj.xpopup.e.b {
        b() {
        }

        @Override // com.lxj.xpopup.e.b
        public void a() {
            if (PartShadowPopupView.this.a.f5442c.booleanValue()) {
                PartShadowPopupView.this.b();
            }
        }
    }

    public PartShadowPopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return new g(getPopupImplView(), this.s ? c.TranslateFromBottom : c.TranslateFromTop);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        int iA = this.a.t;
        if (iA == 0) {
            iA = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.p = iA;
        int iA2 = this.a.s;
        if (iA2 == 0) {
            iA2 = com.lxj.xpopup.f.c.a(getContext(), 0.0f);
        }
        this.q = iA2;
        getPopupImplView().setTranslationX(this.a.s);
        getPopupImplView().setTranslationY(this.a.t);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a.f5442c.booleanValue()) {
            b();
        }
        return !this.a.f5442c.booleanValue();
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    protected void u() {
        if (this.a.a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView\uff01");
        }
        this.f5425c.a = getPopupContentView();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        if (rotation == 0) {
            marginLayoutParams.width = getMeasuredWidth();
        } else if (rotation == 1 || rotation == 3) {
            marginLayoutParams.width = getMeasuredWidth() - (com.lxj.xpopup.f.c.d(getContext()) ? com.lxj.xpopup.f.c.b() : 0);
        }
        if (this.a.v && getPopupImplView() != null) {
            getPopupImplView().setTranslationX((com.lxj.xpopup.f.c.c(getContext()) / 2.0f) - (getPopupContentView().getMeasuredWidth() / 2.0f));
        }
        int[] iArr = new int[2];
        this.a.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.a.a().getMeasuredWidth(), iArr[1] + this.a.a().getMeasuredHeight());
        if ((rect.top + (rect.height() / 2) > getMeasuredHeight() / 2 || this.a.q == d.Top) && this.a.q != d.Bottom) {
            marginLayoutParams.height = rect.top;
            this.s = true;
            marginLayoutParams.topMargin = -this.p;
            View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        } else {
            marginLayoutParams.height = getMeasuredHeight() - rect.bottom;
            if (com.lxj.xpopup.f.c.d(getContext())) {
                marginLayoutParams.height -= com.lxj.xpopup.f.c.b();
            }
            this.s = false;
            marginLayoutParams.topMargin = rect.bottom + this.p;
            View childAt2 = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams2.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams2.height = Math.min(childAt2.getMeasuredHeight(), getMaxHeight());
            }
            childAt2.setLayoutParams(layoutParams2);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        this.r.setOnLongClickListener(new a());
        this.r.setOnClickOutsideListener(new b());
    }
}
