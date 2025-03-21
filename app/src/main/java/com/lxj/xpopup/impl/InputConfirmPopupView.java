package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p186e.InterfaceC2807a;
import com.lxj.xpopup.p186e.InterfaceC2811e;
import com.lxj.xpopup.p187f.C2819c;

/* loaded from: classes.dex */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener {

    /* renamed from: E */
    AppCompatEditText f8796E;

    /* renamed from: F */
    public String f8797F;

    /* renamed from: G */
    InterfaceC2807a f8798G;

    /* renamed from: H */
    InterfaceC2811e f8799H;

    /* renamed from: com.lxj.xpopup.impl.InputConfirmPopupView$a */
    class RunnableC2826a implements Runnable {
        RunnableC2826a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InputConfirmPopupView.this.f8796E.setBackgroundDrawable(C2819c.m8453a(C2819c.m8452a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.f8796E.getMeasuredWidth(), Color.parseColor("#888888")), C2819c.m8452a(InputConfirmPopupView.this.getResources(), InputConfirmPopupView.this.f8796E.getMeasuredWidth(), C2768b.m8296b())));
        }
    }

    public InputConfirmPopupView(@NonNull Context context) {
        super(context);
    }

    public AppCompatEditText getEditText() {
        return this.f8796E;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8796E = (AppCompatEditText) findViewById(C2766R.id.et_input);
        this.f8796E.setVisibility(0);
        if (!TextUtils.isEmpty(this.f8782A)) {
            this.f8796E.setHint(this.f8782A);
        }
        if (!TextUtils.isEmpty(this.f8797F)) {
            this.f8796E.setText(this.f8797F);
            this.f8796E.setSelection(this.f8797F.length());
        }
        m8501w();
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f8790w) {
            InterfaceC2807a interfaceC2807a = this.f8798G;
            if (interfaceC2807a != null) {
                interfaceC2807a.onCancel();
            }
            mo8378b();
            return;
        }
        if (view == this.f8791x) {
            InterfaceC2811e interfaceC2811e = this.f8799H;
            if (interfaceC2811e != null) {
                interfaceC2811e.m8430a(this.f8796E.getText().toString().trim());
            }
            if (this.f8617a.f8691d.booleanValue()) {
                mo8378b();
            }
        }
    }

    /* renamed from: w */
    protected void m8501w() {
        super.m8498u();
        C2819c.m8460a(this.f8796E, C2768b.m8296b());
        this.f8796E.post(new RunnableC2826a());
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView
    /* renamed from: a */
    public InputConfirmPopupView mo8493a(int i2) {
        this.f8646q = i2;
        return this;
    }

    /* renamed from: a */
    public void m8500a(InterfaceC2811e interfaceC2811e, InterfaceC2807a interfaceC2807a) {
        this.f8798G = interfaceC2807a;
        this.f8799H = interfaceC2811e;
    }
}
