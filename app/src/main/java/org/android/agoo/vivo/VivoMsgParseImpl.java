package org.android.agoo.vivo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

/* loaded from: classes2.dex */
public class VivoMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    public static final String TAG = "VivoMsgParseImpl";

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "vivo";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str = null;
        if (intent == null) {
            ALog.m9182e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            str = intent.getStringExtra(AgooConstants.MESSAGE_VIVO_PAYLOAD);
            ALog.m9183i(TAG, "parseMsgFromIntent", "msg", str);
            return str;
        } catch (Throwable th) {
            ALog.m9181e(TAG, "parseMsgFromIntent", th, new Object[0]);
            return str;
        }
    }
}
