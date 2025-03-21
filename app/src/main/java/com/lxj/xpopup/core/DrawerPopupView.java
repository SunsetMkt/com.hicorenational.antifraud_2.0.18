package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.p185d.EnumC2804d;
import com.lxj.xpopup.widget.PopupDrawerLayout;

/* loaded from: classes.dex */
public abstract class DrawerPopupView extends BasePopupView {

    /* renamed from: p */
    PopupDrawerLayout f8648p;

    /* renamed from: q */
    protected FrameLayout f8649q;

    /* renamed from: com.lxj.xpopup.core.DrawerPopupView$a */
    class C2790a implements PopupDrawerLayout.InterfaceC2846d {
        C2790a() {
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.InterfaceC2846d
        /* renamed from: a */
        public void mo8400a() {
            DrawerPopupView.super.mo8381e();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.InterfaceC2846d
        public void onClose() {
            DrawerPopupView.super.mo8378b();
        }

        @Override // com.lxj.xpopup.widget.PopupDrawerLayout.InterfaceC2846d
        /* renamed from: a */
        public void mo8401a(float f2) {
            DrawerPopupView drawerPopupView = DrawerPopupView.this;
            drawerPopupView.f8648p.f8934i = drawerPopupView.f8617a.f8705r.booleanValue();
        }
    }

    /* renamed from: com.lxj.xpopup.core.DrawerPopupView$b */
    class ViewOnClickListenerC2791b implements View.OnClickListener {
        ViewOnClickListenerC2791b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DrawerPopupView.this.f8648p.m8599a();
        }
    }

    public DrawerPopupView(@NonNull Context context) {
        super(context);
        this.f8648p = (PopupDrawerLayout) findViewById(C2766R.id.drawerLayout);
        this.f8649q = (FrameLayout) findViewById(C2766R.id.drawerContentContainer);
        this.f8649q.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8649q, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: e */
    public void mo8381e() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: f */
    public void mo8382f() {
        this.f8648p.m8599a();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: g */
    public void mo8383g() {
        this.f8648p.m8600b();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8648p.f8936k = this.f8617a.f8692e.booleanValue();
        this.f8648p.setOnCloseListener(new C2790a());
        getPopupImplView().setTranslationX(this.f8617a.f8706s);
        getPopupImplView().setTranslationY(this.f8617a.f8707t);
        PopupDrawerLayout popupDrawerLayout = this.f8648p;
        EnumC2804d enumC2804d = this.f8617a.f8704q;
        if (enumC2804d == null) {
            enumC2804d = EnumC2804d.Left;
        }
        popupDrawerLayout.setDrawerPosition(enumC2804d);
        this.f8648p.setOnClickListener(new ViewOnClickListenerC2791b());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: b */
    public void mo8378b() {
        this.f8648p.m8599a();
    }
}
