package com.tencent.bugly.beta.ui;

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
import com.tencent.bugly.proguard.an;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class f extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DownloadTask f6065n;
    protected TextView o;

    @Override // com.tencent.bugly.beta.ui.b
    public boolean a(int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6044l = com.tencent.bugly.beta.global.e.G.f6028l;
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f6044l == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            this.o = new TextView(this.a);
            this.o.setLayoutParams(layoutParams);
            TextView textView = this.o;
            this.f6042j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.o.setTextSize(16.0f);
            this.o.setTag(Beta.TAG_TIP_MESSAGE);
            this.f6041i.addView(this.o);
        } else if (viewOnCreateView != null) {
            this.o = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.o.setText(Beta.strNetworkTipsMessage);
            this.f6038f.setText(Beta.strNetworkTipsTitle);
            a(Beta.strNetworkTipsCancelBtn, new com.tencent.bugly.beta.global.b(2, this), Beta.strNetworkTipsConfirmBtn, new com.tencent.bugly.beta.global.b(3, this, this.f6065n));
        } catch (Exception e2) {
            if (this.f6044l != 0) {
                an.e("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        return viewOnCreateView;
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.o = null;
    }
}
