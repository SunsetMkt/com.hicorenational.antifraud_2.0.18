package org.android.agoo.honor;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* loaded from: classes2.dex */
public class HonorMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    public static final String TAG = "HonorMsgParseImpl";

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "honor";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            ALog.m9182e(TAG, "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            return intent.getStringExtra("extras");
        } catch (Throwable th) {
            ALog.m9181e(TAG, "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
