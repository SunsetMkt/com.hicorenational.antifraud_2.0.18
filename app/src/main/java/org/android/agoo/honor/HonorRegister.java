package org.android.agoo.honor;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.TimeUnit;
import org.android.agoo.control.NotifManager;

/* loaded from: classes2.dex */
public class HonorRegister {
    public static final String TAG = "HonorRegister";
    public static final String VERSION = "2.1.0";

    public static void getToken(Context context, HonorPushCallback<String> honorPushCallback) {
        try {
            HonorPushClient.getInstance().init(context, false);
            HonorPushClient.getInstance().getPushToken(honorPushCallback);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getToken failed.", th, new Object[0]);
        }
    }

    public static void register(Context context) {
        try {
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.m9183i(TAG, "not in main process, skipped.", new Object[0]);
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            if (Build.VERSION.SDK_INT < 19 || !HonorPushClient.getInstance().checkSupportHonorPush(applicationContext)) {
                ALog.m9183i(TAG, "device check, skipped.", new Object[0]);
                return;
            }
            ALog.m9183i(TAG, "ver:", "2.1.0");
            BaseNotifyClickActivity.addNotifyListener(new HonorMsgParseImpl());
            ThreadPoolExecutorFactory.schedule(new Runnable() { // from class: org.android.agoo.honor.HonorRegister.1
                @Override // java.lang.Runnable
                public void run() {
                    ALog.m9183i(HonorRegister.TAG, "register begin", new Object[0]);
                    HonorRegister.getToken(applicationContext, new HonorPushCallback<String>() { // from class: org.android.agoo.honor.HonorRegister.1.1
                        @Override // com.hihonor.push.sdk.HonorPushCallback
                        public void onFailure(int i2, String str) {
                            ALog.m9182e(HonorRegister.TAG, "onToken failed!", "code", Integer.valueOf(i2), "msg", str);
                        }

                        @Override // com.hihonor.push.sdk.HonorPushCallback
                        public void onSuccess(String str) {
                            ALog.m9183i(HonorRegister.TAG, "onToken", "token", str);
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    return;
                                }
                                NotifManager notifManager = new NotifManager();
                                notifManager.init(applicationContext);
                                notifManager.reportThirdPushToken(str, HonorMsgService.HONOR_TOKEN);
                            } catch (Throwable th) {
                                ALog.m9181e(HonorRegister.TAG, "token report failed!", th, new Object[0]);
                            }
                        }
                    });
                }
            }, 5L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "register failed:", th, new Object[0]);
        }
    }

    public static void unregister(HonorPushCallback<Void> honorPushCallback) {
        try {
            ALog.m9183i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
            HonorPushClient.getInstance().deletePushToken(honorPushCallback);
        } catch (Throwable th) {
            ALog.m9181e(TAG, MiPushClient.COMMAND_UNREGISTER, th, new Object[0]);
        }
    }
}
