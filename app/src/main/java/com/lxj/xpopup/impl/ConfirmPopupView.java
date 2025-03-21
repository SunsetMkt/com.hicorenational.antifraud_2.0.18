package com.lxj.xpopup.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.p186e.InterfaceC2807a;
import com.lxj.xpopup.p186e.InterfaceC2809c;

/* loaded from: classes.dex */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {

    /* renamed from: A */
    String f8782A;

    /* renamed from: B */
    String f8783B;

    /* renamed from: C */
    String f8784C;

    /* renamed from: D */
    boolean f8785D;

    /* renamed from: s */
    InterfaceC2807a f8786s;

    /* renamed from: t */
    InterfaceC2809c f8787t;

    /* renamed from: u */
    TextView f8788u;

    /* renamed from: v */
    TextView f8789v;

    /* renamed from: w */
    TextView f8790w;

    /* renamed from: x */
    TextView f8791x;

    /* renamed from: y */
    String f8792y;

    /* renamed from: z */
    String f8793z;

    public ConfirmPopupView(@NonNull Context context) {
        super(context);
        this.f8785D = false;
    }

    /* renamed from: a */
    public ConfirmPopupView mo8493a(int i2) {
        this.f8646q = i2;
        return this;
    }

    /* renamed from: b */
    public ConfirmPopupView m8497b(String str) {
        this.f8784C = str;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.f8646q;
        return i2 != 0 ? i2 : C2766R.layout._xpopup_center_impl_confirm;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8788u = (TextView) findViewById(C2766R.id.tv_title);
        this.f8789v = (TextView) findViewById(C2766R.id.tv_content);
        this.f8790w = (TextView) findViewById(C2766R.id.tv_cancel);
        this.f8791x = (TextView) findViewById(C2766R.id.tv_confirm);
        if (this.f8646q == 0) {
            m8498u();
        }
        this.f8790w.setOnClickListener(this);
        this.f8791x.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f8792y)) {
            this.f8788u.setVisibility(8);
        } else {
            this.f8788u.setText(this.f8792y);
        }
        if (!TextUtils.isEmpty(this.f8793z)) {
            this.f8789v.setText(this.f8793z);
        }
        if (!TextUtils.isEmpty(this.f8783B)) {
            this.f8790w.setText(this.f8783B);
        }
        if (!TextUtils.isEmpty(this.f8784C)) {
            this.f8791x.setText(this.f8784C);
        }
        if (this.f8785D) {
            this.f8790w.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f8790w) {
            InterfaceC2807a interfaceC2807a = this.f8786s;
            if (interfaceC2807a != null) {
                interfaceC2807a.onCancel();
            }
            mo8378b();
            return;
        }
        if (view == this.f8791x) {
            InterfaceC2809c interfaceC2809c = this.f8787t;
            if (interfaceC2809c != null) {
                interfaceC2809c.m8429a();
            }
            if (this.f8617a.f8691d.booleanValue()) {
                mo8378b();
            }
        }
    }

    /* renamed from: u */
    protected void m8498u() {
        this.f8790w.setTextColor(C2768b.m8296b());
        this.f8791x.setTextColor(C2768b.m8296b());
    }

    /* renamed from: v */
    public ConfirmPopupView m8499v() {
        this.f8785D = true;
        return this;
    }

    /* renamed from: a */
    public ConfirmPopupView m8494a(InterfaceC2809c interfaceC2809c, InterfaceC2807a interfaceC2807a) {
        this.f8786s = interfaceC2807a;
        this.f8787t = interfaceC2809c;
        return this;
    }

    /* renamed from: a */
    public ConfirmPopupView m8496a(String str, String str2, String str3) {
        this.f8792y = str;
        this.f8793z = str2;
        this.f8782A = str3;
        return this;
    }

    /* renamed from: a */
    public ConfirmPopupView m8495a(String str) {
        this.f8783B = str;
        return this;
    }
}
