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
import com.tencent.bugly.proguard.an;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: n */
    protected TextView f6064n;

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
            this.f6064n = new TextView(this.a);
            this.f6064n.setLayoutParams(layoutParams);
            TextView textView = this.f6064n;
            this.f6042j.getClass();
            textView.setTextColor(Color.parseColor("#757575"));
            this.f6064n.setTextSize(16.0f);
            this.f6064n.setTag(Beta.TAG_TIP_MESSAGE);
            this.f6041i.addView(this.f6064n);
        } else if (viewOnCreateView != null) {
            this.f6064n = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.f6064n.setText("\u68c0\u6d4b\u5230\u5f53\u524d\u7248\u672c\u9700\u8981\u91cd\u542f\uff0c\u662f\u5426\u91cd\u542f\u5e94\u7528\uff1f");
            this.f6038f.setText("\u66f4\u65b0\u63d0\u793a");
            a("\u53d6\u6d88", new com.tencent.bugly.beta.global.b(8, this), "\u91cd\u542f\u5e94\u7528", new com.tencent.bugly.beta.global.b(7, this));
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
}
