package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.b */
/* loaded from: classes2.dex */
public class C3063b implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "huawei";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            ALog.m9182e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            return intent.getStringExtra("extras");
        } catch (Throwable th) {
            ALog.m9181e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
