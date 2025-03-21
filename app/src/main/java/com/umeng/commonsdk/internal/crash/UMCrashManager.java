package com.umeng.commonsdk.internal.crash;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.stateless.C3489a;
import com.umeng.commonsdk.stateless.C3492d;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMCrashManager {
    private static final String CM_VERSION = "2.0";
    private static boolean isReportCrash = false;
    private static Object mObject = new Object();

    public static void buildEnvelope(Context context, Object obj) {
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> UMCrashManager.buildEnvelope enter.");
        try {
            synchronized (mObject) {
                if (context == null || obj == null) {
                    return;
                }
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = context.getFilesDir() + File.separator + C3489a.f12686f;
                    File file = new File(str2);
                    if (!file.isDirectory()) {
                        file.mkdir();
                    }
                    C3492d.m11703a(context, str2, C3351bh.f11584aI, 10);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(C3351bh.f11593aR, CM_VERSION);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("content", str);
                        jSONObject2.put("ts", System.currentTimeMillis());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(CrashHianalyticsData.EVENT_ID_CRASH, jSONObject2);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, jSONObject3);
                        UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject4, UMServerURL.PATH_INNER_CRASH, C3351bh.f11584aI, CM_VERSION);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void reportCrash(Context context, Throwable th) {
        synchronized (mObject) {
            if (!isReportCrash) {
                isReportCrash = true;
                UMWorkDispatch.sendEvent(context, C3470a.f12607u, C3471b.m11589a(context).m11590a(), C3473a.m11609a(th));
            }
        }
    }
}
