package org.android.agoo.xiaomi;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;

/* loaded from: classes2.dex */
public class MiMsgParseImpl implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "xiaomi";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str;
        MiPushMessage miPushMessage;
        try {
            miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushMessageHelper.KEY_MESSAGE);
        } catch (Throwable unused) {
        }
        if (miPushMessage != null) {
            str = miPushMessage.getContent();
            ALog.m9183i(MiPushRegistar.TAG, "parseMsgFromIntent", "msg", str);
            return str;
        }
        str = null;
        ALog.m9183i(MiPushRegistar.TAG, "parseMsgFromIntent", "msg", str);
        return str;
    }

    public String toString() {
        return "INotifyListener: " + getMsgSource();
    }
}
