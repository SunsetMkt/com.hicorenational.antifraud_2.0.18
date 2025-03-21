package org.android.agoo.xiaomi;

import android.content.Context;
import android.os.Build;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: classes2.dex */
public class MiPushRegistar {
    public static final String BLACKSHARK = "blackshark";
    public static final String REDMI = "Redmi";
    public static final String TAG = "MiPushRegistar";
    public static final String VERSION = "2.1.0";
    public static final String XIAOMI = "Xiaomi";

    public static boolean checkDevice() {
        String str = Build.BRAND;
        return XIAOMI.equalsIgnoreCase(str) || REDMI.equalsIgnoreCase(str) || BLACKSHARK.equalsIgnoreCase(str);
    }

    public static String getToken(Context context) {
        try {
            return MiPushClient.getRegId(context);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getToken failed:", th, new Object[0]);
            return null;
        }
    }

    public static void register(Context context, String str, String str2) {
        register(context, str, str2, false);
    }

    public static void register(Context context, String str, String str2, boolean z) {
        try {
            if (!UtilityImpl.isMainProcess(context)) {
                ALog.m9183i(TAG, "not in main process, skipped.", new Object[0]);
                return;
            }
            if (!z && !checkDevice()) {
                ALog.m9183i(TAG, "device check, skipped.", new Object[0]);
                return;
            }
            ALog.m9183i(TAG, "ver:", "2.1.0");
            ALog.m9183i(TAG, "register begin", new Object[0]);
            BaseNotifyClickActivity.addNotifyListener(new MiMsgParseImpl());
            MiPushClient.registerPush(context, str, str2);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "register failed:", th, new Object[0]);
        }
    }

    public static void unregister(Context context) {
        try {
            ALog.m9183i(TAG, MiPushClient.COMMAND_UNREGISTER, new Object[0]);
            MiPushClient.unregisterPush(context);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "unregister failed:", th, new Object[0]);
        }
    }
}
