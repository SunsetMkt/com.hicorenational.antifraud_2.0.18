package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p185d.EnumC2805e;
import com.lxj.xpopup.p187f.C2818b;
import com.lxj.xpopup.p187f.C2819c;
import com.lxj.xpopup.widget.SmartDragLayout;

/* loaded from: classes.dex */
public class BottomPopupView extends BasePopupView {

    /* renamed from: p */
    protected SmartDragLayout f8642p;

    /* renamed from: com.lxj.xpopup.core.BottomPopupView$a */
    class C2788a implements SmartDragLayout.InterfaceC2850d {
        C2788a() {
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.InterfaceC2850d
        /* renamed from: a */
        public void mo8397a() {
            BottomPopupView.super.mo8381e();
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.InterfaceC2850d
        public void onClose() {
            BottomPopupView.this.m8380d();
        }
    }

    /* renamed from: com.lxj.xpopup.core.BottomPopupView$b */
    class ViewOnClickListenerC2789b implements View.OnClickListener {
        ViewOnClickListenerC2789b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomPopupView.this.mo8378b();
        }
    }

    public BottomPopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: b */
    public void mo8378b() {
        if (!this.f8617a.f8708u.booleanValue()) {
            super.mo8378b();
            return;
        }
        EnumC2805e enumC2805e = this.f8621e;
        EnumC2805e enumC2805e2 = EnumC2805e.Dismissing;
        if (enumC2805e == enumC2805e2) {
            return;
        }
        this.f8621e = enumC2805e2;
        if (this.f8617a.f8700m.booleanValue()) {
            C2818b.m8443a(this);
        }
        m8392q();
        clearFocus();
        this.f8642p.m8603a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: e */
    public void mo8381e() {
        if (this.f8617a.f8708u.booleanValue()) {
            return;
        }
        super.mo8381e();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: f */
    public void mo8382f() {
        if (this.f8617a.f8708u.booleanValue()) {
            this.f8642p.m8603a();
        } else {
            super.mo8382f();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: g */
    public void mo8383g() {
        if (this.f8617a.f8708u.booleanValue()) {
            this.f8642p.m8606b();
        } else {
            super.mo8383g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        if (this.f8617a.f8708u.booleanValue()) {
            return 0;
        }
        return super.getAnimationDuration();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f8617a.f8698k;
        return i2 == 0 ? C2819c.m8472c(getContext()) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected AbstractC2770b getPopupAnimator() {
        if (this.f8617a.f8708u.booleanValue()) {
            return null;
        }
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_bottom_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8642p = (SmartDragLayout) findViewById(C2766R.id.bottomPopupContainer);
        this.f8642p.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8642p, false));
        this.f8642p.m8607b(this.f8617a.f8708u.booleanValue());
        this.f8642p.m8605a(this.f8617a.f8690c.booleanValue());
        this.f8642p.m8608c(this.f8617a.f8692e.booleanValue());
        getPopupImplView().setTranslationX(this.f8617a.f8706s);
        getPopupImplView().setTranslationY(this.f8617a.f8707t);
        C2819c.m8458a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
        this.f8642p.setOnCloseListener(new C2788a());
        this.f8642p.setOnClickListener(new ViewOnClickListenerC2789b());
    }
}
