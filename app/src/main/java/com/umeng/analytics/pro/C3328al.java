package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.ccg.C3438a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ModelHelper.java */
/* renamed from: com.umeng.analytics.pro.al */
/* loaded from: classes2.dex */
public class C3328al {
    /* renamed from: a */
    public static JSONObject m10848a(Context context, String str) {
        JSONObject jSONObject = null;
        try {
            C3327ak c3327ak = new C3327ak();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            c3327ak.m10823a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            c3327ak.m10826b(appkey);
            c3327ak.m10828c(UMUtils.getAppVersionName(context));
            c3327ak.m10830d("9.6.4");
            c3327ak.m10832e(UMUtils.getChannel(context));
            c3327ak.m10834f(Build.VERSION.SDK_INT + "");
            c3327ak.m10836g(Build.BRAND);
            c3327ak.m10838h(Build.MODEL);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            c3327ak.m10840i(localeInfo[1]);
            c3327ak.m10842j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            c3327ak.m10825b(Integer.valueOf(resolutionArray[1]));
            c3327ak.m10822a(Integer.valueOf(resolutionArray[0]));
            c3327ak.m10844k(C3332ap.m10854a(context, "install_datetime", ""));
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(C3327ak.f11436a, c3327ak.m10821a());
                    jSONObject2.put(C3327ak.f11438c, c3327ak.m10827c());
                    jSONObject2.put(C3327ak.f11437b, c3327ak.m10824b());
                    jSONObject2.put(C3327ak.f11439d, c3327ak.m10829d());
                    jSONObject2.put(C3327ak.f11440e, c3327ak.m10831e());
                    jSONObject2.put(C3327ak.f11441f, c3327ak.m10833f());
                    jSONObject2.put(C3327ak.f11442g, c3327ak.m10835g());
                    jSONObject2.put(C3327ak.f11443h, c3327ak.m10837h());
                    jSONObject2.put(C3327ak.f11446k, c3327ak.m10843k());
                    jSONObject2.put(C3327ak.f11445j, c3327ak.m10841j());
                    jSONObject2.put(C3327ak.f11447l, c3327ak.m10845l());
                    jSONObject2.put(C3327ak.f11444i, c3327ak.m10839i());
                    jSONObject2.put(C3327ak.f11448m, c3327ak.m10846m());
                    jSONObject2.put(C3351bh.f11613al, UMUtils.getZid(context));
                    jSONObject2.put("platform", DispatchConstants.ANDROID);
                    jSONObject2.put("optional", new JSONObject(C3332ap.m10855a()));
                    String[] split = str.split("@");
                    if (split.length == 4) {
                        try {
                            long parseLong = Long.parseLong(split[0]);
                            String str2 = split[1];
                            jSONObject2.put("s1", parseLong);
                            jSONObject2.put("s2", str2);
                        } catch (Throwable unused) {
                        }
                    }
                    return jSONObject2;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = jSONObject2;
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                    return jSONObject;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static JSONObject m10847a(Context context, int i2, JSONArray jSONArray, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                String zid = UMUtils.getZid(context);
                if (TextUtils.isEmpty(zid)) {
                    return jSONObject;
                }
                jSONObject.put("atoken", zid);
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, deviceToken);
                }
                jSONObject.put(Constants.KEY_MODEL, Build.MODEL);
                jSONObject.put("os", DispatchConstants.ANDROID);
                jSONObject.put("os_version", Build.VERSION.RELEASE);
                jSONObject.put(C3438a.f12342o, str);
                jSONObject.put(C3438a.f12345r, jSONArray);
                jSONObject.put("e", i2);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
