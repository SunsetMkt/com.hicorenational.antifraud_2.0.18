package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.C3438a;

/* renamed from: com.umeng.message.proguard.r */
/* loaded from: classes2.dex */
public class C3598r implements ActionInfo {
    @Override // com.umeng.ccg.ActionInfo
    public String getModule(Context context) {
        return "push";
    }

    @Override // com.umeng.ccg.ActionInfo
    public String[] getSupportAction(Context context) {
        return new String[]{C3438a.f12332e};
    }

    @Override // com.umeng.ccg.ActionInfo
    public boolean getSwitchState(Context context, String str) {
        if (TextUtils.equals(str, C3438a.f12332e)) {
            return C3586f.f13276a;
        }
        return false;
    }

    @Override // com.umeng.ccg.ActionInfo
    public void onCommand(Context context, String str, Object obj) {
    }
}
