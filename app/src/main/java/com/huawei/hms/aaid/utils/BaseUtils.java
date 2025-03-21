package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC2467e;
import com.huawei.hms.opendevice.AbstractC2472j;
import com.huawei.hms.opendevice.C2471i;
import com.huawei.hms.support.log.HMSLog;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class BaseUtils {
    private BaseUtils() {
    }

    public static void clearSubjectIds(Context context) {
        C2471i.m7469a(context).removeKey("subjectId");
    }

    public static void delLocalToken(Context context, String str) {
        C2471i.m7469a(context).m7475c(str);
    }

    public static void deleteAllTokenCache(Context context) {
        C2471i.m7469a(context).m7471a();
    }

    public static void deleteCacheData(Context context, String str) {
        C2471i.m7469a(context).removeKey(str);
    }

    public static String getCacheData(Context context, String str, boolean z) {
        return z ? C2471i.m7469a(context).m7470a(str) : C2471i.m7469a(context).getString(str);
    }

    public static String getLocalToken(Context context, String str) {
        return C2471i.m7469a(context).m7473b(str);
    }

    public static boolean getProxyInit(Context context) {
        return C2471i.m7469a(context).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context context) {
        String string = C2471i.m7469a(context).getString("subjectId");
        return TextUtils.isEmpty(string) ? new String[0] : string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static void initSecret(Context context) {
        AbstractC2472j.m7476a(context);
    }

    public static boolean isMainProc(Context context) {
        String m7454a = AbstractC2467e.m7454a(context);
        String str = context.getApplicationInfo().processName;
        HMSLog.m7717i("BaseUtils", "main process name: " + str + ", current process name: " + m7454a);
        return str.equals(m7454a);
    }

    public static boolean saveCacheData(Context context, String str, String str2, boolean z) {
        return z ? C2471i.m7469a(context).m7472a(str, str2) : C2471i.m7469a(context).saveString(str, str2);
    }

    public static void saveProxyInit(Context context, boolean z) {
        C2471i.m7469a(context).saveBoolean("_proxy_init", z);
    }

    public static void saveToken(Context context, String str, String str2) {
        C2471i.m7469a(context).m7474b(str, str2);
    }
}
