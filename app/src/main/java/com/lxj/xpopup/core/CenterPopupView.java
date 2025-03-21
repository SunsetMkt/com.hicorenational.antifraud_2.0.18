package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2771c;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class CenterPopupView extends BasePopupView {

    /* renamed from: p */
    protected FrameLayout f8645p;

    /* renamed from: q */
    protected int f8646q;

    /* renamed from: r */
    protected int f8647r;

    public CenterPopupView(@NonNull Context context) {
        super(context);
        this.f8645p = (FrameLayout) findViewById(C2766R.id.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f8617a.f8698k;
        return i2 == 0 ? (int) (C2819c.m8472c(getContext()) * 0.86f) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        return new C2771c(getPopupContentView(), EnumC2803c.ScaleAlphaFromCenter);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_center_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8645p, false);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 17;
        this.f8645p.addView(inflate, layoutParams);
        getPopupContentView().setTranslationX(this.f8617a.f8706s);
        getPopupContentView().setTranslationY(this.f8617a.f8707t);
        C2819c.m8458a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }
}
