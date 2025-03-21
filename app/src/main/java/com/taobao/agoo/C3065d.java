package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.d */
/* loaded from: classes2.dex */
public class C3065d implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "oppo";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str = null;
        if (intent == null) {
            ALog.m9182e("DefaultOppoMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            str = intent.getStringExtra(AgooConstants.MESSAGE_OPPO_PAYLOAD);
            ALog.m9183i("DefaultOppoMsgParseImpl", "parseMsgFromIntent", "msg", str);
            return str;
        } catch (Throwable th) {
            ALog.m9181e("DefaultOppoMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return str;
        }
    }
}
