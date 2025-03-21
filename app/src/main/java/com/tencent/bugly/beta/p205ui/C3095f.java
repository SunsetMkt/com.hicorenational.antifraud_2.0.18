package com.tencent.bugly.beta.p205ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.ViewOnClickListenerC3079b;
import com.tencent.bugly.proguard.C3151an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.f */
/* loaded from: classes2.dex */
public class C3095f extends AbstractC3090a {

    /* renamed from: n */
    public DownloadTask f9966n;

    /* renamed from: o */
    protected TextView f9967o;

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3091b
    /* renamed from: a */
    public boolean mo9353a(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3090a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9940l = C3082e.f9867G.f9910l;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f9940l == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.f9967o = new TextView(this.f9929a);
            this.f9967o.setLayoutParams(layoutParams);
            TextView textView = this.f9967o;
            this.f9938j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.f9967o.setTextSize(16.0f);
            this.f9967o.setTag(Beta.TAG_TIP_MESSAGE);
            this.f9937i.addView(this.f9967o);
        } else if (onCreateView != null) {
            this.f9967o = (TextView) onCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.f9967o.setText(Beta.strNetworkTipsMessage);
            this.f9934f.setText(Beta.strNetworkTipsTitle);
            m9352a(Beta.strNetworkTipsCancelBtn, new ViewOnClickListenerC3079b(2, this), Beta.strNetworkTipsConfirmBtn, new ViewOnClickListenerC3079b(3, this, this.f9966n));
        } catch (Exception e2) {
            if (this.f9940l != 0) {
                C3151an.m9923e("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
        }
        return onCreateView;
    }

    @Override // com.tencent.bugly.beta.p205ui.AbstractC3090a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9967o = null;
    }
}
