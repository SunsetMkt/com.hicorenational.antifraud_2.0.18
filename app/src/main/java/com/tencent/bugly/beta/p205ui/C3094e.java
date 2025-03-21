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
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.ViewOnClickListenerC3079b;
import com.tencent.bugly.proguard.C3151an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.ui.e */
/* loaded from: classes2.dex */
public class C3094e extends AbstractC3090a {

    /* renamed from: n */
    protected TextView f9965n;

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
            this.f9965n = new TextView(this.f9929a);
            this.f9965n.setLayoutParams(layoutParams);
            TextView textView = this.f9965n;
            this.f9938j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.f9965n.setTextSize(16.0f);
            this.f9965n.setTag(Beta.TAG_TIP_MESSAGE);
            this.f9937i.addView(this.f9965n);
        } else if (onCreateView != null) {
            this.f9965n = (TextView) onCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.f9965n.setText("检测到当前版本需要重启，是否重启应用？");
            this.f9934f.setText("更新提示");
            m9352a("取消", new ViewOnClickListenerC3079b(8, this), "重启应用", new ViewOnClickListenerC3079b(7, this));
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
}
