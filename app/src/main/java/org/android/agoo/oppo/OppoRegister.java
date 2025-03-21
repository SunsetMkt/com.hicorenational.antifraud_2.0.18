package org.android.agoo.oppo;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.android.agoo.control.NotifManager;

/* loaded from: classes2.dex */
public class OppoRegister {
    public static final String OPPO_TOKEN = "OPPO_TOKEN";
    public static final String TAG = "OppoPush";
    public static final String VERSION = "2.1.0";

    public static String getToken(Context context) {
        try {
            return HeytapPushManager.getRegisterID();
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getToken failed:", th, new Object[0]);
            return "";
        }
    }

    public static void register(Context context, String str, String str2) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (!UtilityImpl.isMainProcess(applicationContext)) {
                ALog.m9183i(TAG, "not in main process, skipped.", new Object[0]);
                return;
            }
            boolean isPrintLog = ALog.isPrintLog();
            try {
                C2107g.m5901f(isPrintLog);
            } catch (Throwable unused) {
            }
            if (!HeytapPushManager.isSupportPush(context)) {
                ALog.m9183i(TAG, "device check, skipped.", new Object[0]);
                return;
            }
            ALog.m9183i(TAG, "ver:", "2.1.0");
            HeytapPushManager.init(applicationContext, isPrintLog);
            BaseNotifyClickActivity.addNotifyListener(new OppoMsgParseImpl());
            ALog.m9183i(TAG, "register oppo begin", new Object[0]);
            HeytapPushManager.register(applicationContext, str, str2, new ICallBackResultService() { // from class: org.android.agoo.oppo.OppoRegister.1
                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onError(int i2, String str3, String str4, String str5) {
                    ALog.m9183i(OppoRegister.TAG, "onError", "code", Integer.valueOf(i2), "msg", str3, "pkg", str4, "miniPkg", str5);
                }

                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onGetNotificationStatus(int i2, int i3) {
                    ALog.m9183i(OppoRegister.TAG, "onGetNotificationStatus", "code", Integer.valueOf(i2), NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i3));
                }

                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onGetPushStatus(int i2, int i3) {
                    ALog.m9183i(OppoRegister.TAG, "onGetPushStatus", "code", Integer.valueOf(i2), NotificationCompat.CATEGORY_STATUS, Integer.valueOf(i3));
                }

                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onRegister(int i2, String str3, String str4, String str5) {
                    ALog.m9183i(OppoRegister.TAG, "onRegister", "regid", str3, "code", Integer.valueOf(i2), "pkg", str4, "miniPkg", str5);
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    NotifManager notifManager = new NotifManager();
                    notifManager.init(applicationContext);
                    notifManager.reportThirdPushToken(str3, OppoRegister.OPPO_TOKEN);
                }

                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onSetPushTime(int i2, String str3) {
                    ALog.m9183i(OppoRegister.TAG, "onSetPushTime", "code", Integer.valueOf(i2), "pushTime", str3);
                }

                @Override // com.heytap.msp.push.callback.ICallBackResultService
                public void onUnRegister(int i2, String str3, String str4) {
                    ALog.m9182e(OppoRegister.TAG, "onUnRegister", "code", Integer.valueOf(i2), "pkg", str3, "miniPkg", str4);
                }
            });
        } catch (Throwable th) {
            ALog.m9181e(TAG, "register failed:", th, new Object[0]);
        }
    }

    public static void unregister() {
        try {
            ALog.m9183i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
            HeytapPushManager.unRegister();
        } catch (Throwable th) {
            ALog.m9181e(TAG, "unregister failed:", th, new Object[0]);
        }
    }
}
