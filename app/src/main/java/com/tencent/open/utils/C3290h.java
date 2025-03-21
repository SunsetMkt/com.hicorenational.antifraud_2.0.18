package com.tencent.open.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.vivo.push.PushClientConstants;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.h */
/* loaded from: classes2.dex */
public class C3290h {

    /* renamed from: a */
    private static boolean f11305a = false;

    /* renamed from: a */
    public static String m10610a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return m10612b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return m10612b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static String m10612b(Context context, String str, String str2) {
        if (!f11305a) {
            return null;
        }
        try {
            Cursor m10613c = m10613c(context, str, str2);
            if (m10613c == null) {
                SLog.m10500e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                return null;
            }
            if (m10613c.getCount() <= 0) {
                SLog.m10500e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                return null;
            }
            m10613c.moveToFirst();
            String string = m10613c.getString(0);
            m10613c.close();
            SLog.m10502i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
            return m10611a(string) ? string : "UNKNOWN";
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e2);
            return null;
        }
    }

    /* renamed from: c */
    private static Cursor m10613c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            return context.getContentResolver().query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid" + ContainerUtils.KEY_VALUE_DELIMITER + str + "&" + PushClientConstants.TAG_PKG_NAME + ContainerUtils.KEY_VALUE_DELIMITER + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e2);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m10611a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return false;
        }
        for (String str2 : split) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
