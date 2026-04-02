package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;

/* JADX INFO: loaded from: classes2.dex */
public class r implements ActionInfo {
    @Override // com.umeng.ccg.ActionInfo
    public String getModule(Context context) {
        return "push";
    }

    @Override // com.umeng.ccg.ActionInfo
    public String[] getSupportAction(Context context) {
        return new String[]{com.umeng.ccg.a.f7441e};
    }

    @Override // com.umeng.ccg.ActionInfo
    public boolean getSwitchState(Context context, String str) {
        if (TextUtils.equals(str, com.umeng.ccg.a.f7441e)) {
            return f.a;
        }
        return false;
    }

    @Override // com.umeng.ccg.ActionInfo
    public void onCommand(Context context, String str, Object obj) {
    }
}
