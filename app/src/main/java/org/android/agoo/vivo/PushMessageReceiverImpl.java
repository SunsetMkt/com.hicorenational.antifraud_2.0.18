package org.android.agoo.vivo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.vivo.push.sdk.BasePushMessageReceiver;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.android.agoo.control.NotifManager;

/* loaded from: classes2.dex */
public class PushMessageReceiverImpl extends OpenClientPushMessageReceiver {
    public static final String VIVO_TOKEN = "VIVO_TOKEN";

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        try {
            ALog.m9180d(BasePushMessageReceiver.TAG, "onReceiveRegId", "token", str);
            NotifManager notifManager = new NotifManager();
            notifManager.init(context.getApplicationContext());
            notifManager.reportThirdPushToken(str, VIVO_TOKEN, "2.0.0", true);
        } catch (Throwable th) {
            ALog.m9181e(BasePushMessageReceiver.TAG, "report token failed:", th, new Object[0]);
        }
    }
}
