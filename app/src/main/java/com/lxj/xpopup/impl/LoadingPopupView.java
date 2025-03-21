package com.lxj.xpopup.impl;

import android.content.Context;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.core.CenterPopupView;

/* loaded from: classes.dex */
public class LoadingPopupView extends CenterPopupView {

    /* renamed from: s */
    private TextView f8801s;

    /* renamed from: t */
    private String f8802t;

    public LoadingPopupView(@NonNull Context context) {
        super(context);
    }

    /* renamed from: a */
    public LoadingPopupView m8502a(int i2) {
        this.f8646q = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f8646q;
        return i2 != 0 ? i2 : C2766R.layout._xpopup_center_impl_loading;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        TextView textView;
        super.mo8364k();
        this.f8801s = (TextView) findViewById(C2766R.id.tv_title);
        if (this.f8802t == null || (textView = this.f8801s) == null) {
            return;
        }
        textView.setVisibility(0);
        this.f8801s.setText(this.f8802t);
    }

    /* renamed from: a */
    public LoadingPopupView m8503a(String str) {
        this.f8802t = str;
        return this;
    }
}
