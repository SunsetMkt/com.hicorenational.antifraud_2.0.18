package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3353bj;
import com.umeng.analytics.pro.C3355bl;
import com.umeng.analytics.pro.C3408i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.statistics.C3494b;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag = false;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        C3408i m11232a = C3408i.m11232a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C3355bl.f11733e, str2);
        contentValues.put(C3355bl.f11734f, m11232a.m11256c(jSONObject.toString()));
        contentValues.put(C3355bl.f11735g, m11232a.m11256c(jSONObject2.toString()));
        contentValues.put(C3355bl.f11736h, String.valueOf(currentTimeMillis));
        contentValues.put(C3355bl.f11737i, randomUUID.toString());
        contentValues.put(C3355bl.f11738j, str);
        contentValues.put(C3355bl.f11739k, str3);
        C3353bj.m10987a(context).m10993a(C3355bl.f11731c, contentValues);
        if (C3351bh.f11581aF.equalsIgnoreCase(str2)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if (C3351bh.f11580aE.equalsIgnoreCase(str2)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException unused) {
            }
        } else if (!C3351bh.f11576aA.equalsIgnoreCase(str2)) {
            try {
                if ("t".equalsIgnoreCase(str2)) {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(C3494b.m11723a("header"), new JSONObject());
                    jSONObject4.put(C3494b.m11723a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(C3494b.m11723a("header"), new JSONObject());
                jSONObject5.put(C3494b.m11723a("analytics"), jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (JSONException unused2) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? "t" : jSONObject2.has(C3351bh.f11625ax) ? C3351bh.f11581aF : "a", "9.6.4");
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (UMUtils.isMainProgress(context)) {
            return new C3494b().m11731a(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("exception", 120);
                return jSONObject3;
            } catch (JSONException unused) {
                return jSONObject3;
            }
        } catch (JSONException unused2) {
            return null;
        }
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (UMUtils.isMainProgress(context)) {
            return new C3494b().m11733b(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("exception", 120);
                return jSONObject3;
            } catch (JSONException unused) {
                return jSONObject3;
            }
        } catch (JSONException unused2) {
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z;
        synchronized (UMEnvelopeBuild.class) {
            z = transmissionSendFlag;
        }
        return z;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).m11839c().m11842a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        C3469a.m11569a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6, boolean r7) {
        /*
            if (r5 == 0) goto L43
            android.content.Context r0 = r5.getApplicationContext()
            boolean r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            int r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3c
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r7 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r6 != r7) goto L1f
            boolean r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r5 == 0) goto L1d
            goto L2d
        L1d:
            r7 = 1
            goto L3c
        L1f:
            boolean r7 = com.umeng.commonsdk.framework.C3469a.m11572a()
            if (r7 == 0) goto L2f
            int r5 = com.umeng.commonsdk.framework.C3469a.m11573b()
            long r5 = (long) r5
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r5)
        L2d:
            r7 = 0
            goto L3c
        L2f:
            boolean r6 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r6 != 0) goto L2d
            boolean r5 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5)
            if (r5 == 0) goto L1d
            goto L2d
        L3c:
            if (r1 == 0) goto L43
            if (r2 <= 0) goto L43
            com.umeng.commonsdk.framework.C3469a.m11578d()
        L43:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return C3494b.m11721a(context.getApplicationContext());
    }

    public static void registerNetReceiver(Context context) {
        C3469a.m11575b(context);
    }

    public static void sendProcessNextMsgOnce() {
        C3469a.m11578d();
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z;
        }
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        if (TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 121);
                    return jSONObject3;
                } catch (JSONException unused) {
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
                return null;
            }
        }
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 120);
                    return jSONObject4;
                } catch (JSONException unused3) {
                    return jSONObject4;
                }
            } catch (JSONException unused4) {
                return null;
            }
        }
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
        if (C3353bj.m10987a(context).m10998c()) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
            return new C3494b().m11732a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
        JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        if (!UMWorkDispatch.eventHasExist(C3470a.f12606t)) {
            UMWorkDispatch.sendEvent(context, C3470a.f12606t, C3471b.m11589a(context).m11590a(), null);
        }
        return add2CacheTable;
    }
}
