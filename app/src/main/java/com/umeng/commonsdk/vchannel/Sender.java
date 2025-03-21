package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(Context context, C3533b c3533b) {
        if (context == null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(C3351bh.f11594aS, "1.0.0");
                if (customHeader != null && customHeader.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", c3533b.m12111d());
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, C3532a.f13027c, "v", "1.0.0");
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
            return;
        }
        if (map == null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
            return;
        }
        if (!UMFrUtils.isOnline(context)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
            return;
        }
        if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
            return;
        }
        C3533b c3533b = new C3533b(context);
        c3533b.m12107a(str);
        c3533b.m12106a(System.currentTimeMillis());
        c3533b.m12108a(map);
        try {
            UMWorkDispatch.sendEvent(context, C3470a.f12601o, C3471b.m11589a(context).m11590a(), c3533b);
        } catch (Throwable unused) {
        }
        lastTriggerTime = System.currentTimeMillis();
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
