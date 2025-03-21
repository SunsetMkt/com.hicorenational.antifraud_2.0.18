package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.e */
/* loaded from: classes2.dex */
public class C3066e implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "vivo";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str = null;
        if (intent == null) {
            ALog.m9182e("DefaultVivoMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            str = intent.getStringExtra(AgooConstants.MESSAGE_VIVO_PAYLOAD);
            ALog.m9183i("DefaultVivoMsgParseImpl", "parseMsgFromIntent", "msg", str);
            return str;
        } catch (Throwable th) {
            ALog.m9181e("DefaultVivoMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return str;
        }
    }
}
