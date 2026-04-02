package com.lxj.xpopup.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.R;
import com.lxj.xpopup.d.e;
import com.lxj.xpopup.f.c;
import com.lxj.xpopup.widget.SmartDragLayout;

/* JADX INFO: loaded from: classes2.dex */
public class BottomPopupView extends BasePopupView {
    protected SmartDragLayout p;

    class a implements SmartDragLayout.d {
        a() {
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.d
        public void a() {
            BottomPopupView.super.e();
        }

        @Override // com.lxj.xpopup.widget.SmartDragLayout.d
        public void onClose() {
            BottomPopupView.this.d();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BottomPopupView.this.b();
        }
    }

    public BottomPopupView(@NonNull Context context) {
        super(context);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void b() {
        if (!this.a.u.booleanValue()) {
            super.b();
            return;
        }
        e eVar = this.f5427e;
        e eVar2 = e.Dismissing;
        if (eVar == eVar2) {
            return;
        }
        this.f5427e = eVar2;
        if (this.a.f5452m.booleanValue()) {
            com.lxj.xpopup.f.b.a(this);
        }
        q();
        clearFocus();
        this.p.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    public void e() {
        if (this.a.u.booleanValue()) {
            return;
        }
        super.e();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void f() {
        if (this.a.u.booleanValue()) {
            this.p.a();
        } else {
            super.f();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void g() {
        if (this.a.u.booleanValue()) {
            this.p.b();
        } else {
            super.g();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        if (this.a.u.booleanValue()) {
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
        int i2 = this.a.f5450k;
        return i2 == 0 ? c.c(getContext()) : i2;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        if (this.a.u.booleanValue()) {
            return null;
        }
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_bottom_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.p = (SmartDragLayout) findViewById(R.id.bottomPopupContainer);
        this.p.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.p, false));
        this.p.b(this.a.u.booleanValue());
        this.p.a(this.a.f5442c.booleanValue());
        this.p.c(this.a.f5444e.booleanValue());
        getPopupImplView().setTranslationX(this.a.s);
        getPopupImplView().setTranslationY(this.a.t);
        c.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
        this.p.setOnCloseListener(new a());
        this.p.setOnClickListener(new b());
    }
}
