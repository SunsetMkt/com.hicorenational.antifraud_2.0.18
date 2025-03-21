package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.c */
/* loaded from: classes2.dex */
public class C3064c implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "meizu";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str = null;
        if (intent == null) {
            ALog.m9182e("DefaultMeizuMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            str = intent.getStringExtra(AgooConstants.MESSAGE_MEIZU_PAYLOAD);
            ALog.m9183i("DefaultMeizuMsgParseImpl", "parseMsgFromIntent", "msg", str);
            return str;
        } catch (Throwable th) {
            ALog.m9181e("DefaultMeizuMsgParseImpl", "parseMsgFromIntent", th, new Object[0]);
            return str;
        }
    }
}
