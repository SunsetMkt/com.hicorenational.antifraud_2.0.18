package com.umeng.socialize.net.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.p208mm.opensdk.constants.ConstantsAPI;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.base.SocializeClient;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.DplusApi;
import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.net.verify.VerifyReqeust;
import com.umeng.socialize.net.verify.VerifyResponse;
import com.umeng.socialize.uploadlog.UMLog;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeSpUtils;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class SocialAnalytics {

    /* renamed from: a */
    private static SocializeClient f13704a = new SocializeClient();

    /* renamed from: b */
    private static ExecutorService f13705b = Executors.newCachedThreadPool();

    public static void authendt(Context context, SHARE_MEDIA share_media, String str, boolean z, String str2, String str3, Map<String, String> map) {
        DplusApi.uploadAuthend(context, share_media, str3, str, str2);
        if (map != null) {
            DplusApi.uploadAuth(context, map, z, share_media, str3);
        }
        if (map != null) {
            m12668a(context, share_media.toString().toLowerCase(), map);
        }
        verifyStats(context);
    }

    public static void authstart(Context context, SHARE_MEDIA share_media, String str, boolean z, String str2) {
        DplusApi.uploadAuthStart(context, z, share_media, str2);
    }

    public static void dauStats(Context context, boolean z) {
        Bundle shareAndAuth = UMLog.getShareAndAuth();
        int i2 = (shareAndAuth.getBoolean("isjump") ? CommonNetImpl.FLAG_SHARE_JUMP : 0) | (shareAndAuth.getBoolean("share") ? CommonNetImpl.FLAG_SHARE : 0) | (shareAndAuth.getBoolean("auth") ? CommonNetImpl.FLAG_AUTH : 0) | (UMLog.isOpenShareEdit() ? 16777216 : 0);
        String shareBoardConfig = SocializeSpUtils.getShareBoardConfig(context);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(shareBoardConfig)) {
            DplusApi.uploadStatsDAU(context, null, i2);
            return;
        }
        String[] split = shareBoardConfig.split(";");
        if (split.length == 2) {
            String str = split[0];
            String str2 = split[1];
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            hashMap.put("position", split[1]);
            hashMap.put(CommonNetImpl.MENUBG, split[0]);
            DplusApi.uploadStatsDAU(context, hashMap, i2);
        }
    }

    public static void getInfoendt(Context context, SHARE_MEDIA share_media, String str, String str2, String str3, Map<String, String> map) {
        DplusApi.uploadInfoend(context, share_media, str3, str, str2);
        if (map != null) {
            DplusApi.uploadUserInfo(context, map, share_media, str3);
        }
        if (map != null) {
            m12668a(context, share_media.toString().toLowerCase(), map);
        }
        verifyStats(context);
    }

    public static void getInfostart(Context context, SHARE_MEDIA share_media, String str) {
        DplusApi.uploadInfoStart(context, share_media, str);
    }

    public static void log(final Context context, final String str, final String str2, final UMediaObject uMediaObject) {
        m12669a(new Runnable() { // from class: com.umeng.socialize.net.analytics.SocialAnalytics.1
            @Override // java.lang.Runnable
            public void run() {
                AnalyticsReqeust analyticsReqeust = new AnalyticsReqeust(context, str, str2);
                analyticsReqeust.setMedia(uMediaObject);
                analyticsReqeust.setReqType(1);
                AnalyticsResponse analyticsResponse = (AnalyticsResponse) SocialAnalytics.f13704a.execute(analyticsReqeust);
                if (analyticsResponse == null || !analyticsResponse.isOk()) {
                    SLog.debug(UmengText.NET.SHARESELFFAIL);
                } else {
                    SLog.debug(UmengText.NET.SHARESELFOK);
                }
            }
        });
    }

    public static void shareend(Context context, SHARE_MEDIA share_media, String str, String str2, String str3) {
        DplusApi.uploadStatsShareEnd(context, share_media, str3, str, str2);
    }

    public static void verifyStats(final Context context) {
        Set<String> stringSet = context.getSharedPreferences("umeng_verify", 0).getStringSet("verify_log", null);
        if (stringSet == null || stringSet.isEmpty()) {
            return;
        }
        m12669a(new Runnable() { // from class: com.umeng.socialize.net.analytics.SocialAnalytics.2
            @Override // java.lang.Runnable
            public void run() {
                VerifyResponse verifyResponse = (VerifyResponse) SocialAnalytics.f13704a.execute(new VerifyReqeust(context, "https://ai.login.umeng.com/api/umed/event", VerifyResponse.class, URequest.RequestMethod.POST));
                if (verifyResponse == null || !verifyResponse.isOk()) {
                    SLog.debug("VerifyReqeust Fail");
                    return;
                }
                SLog.debug("VerifyReqeust Success");
                SharedPreferences.Editor edit = context.getSharedPreferences("umeng_verify", 0).edit();
                edit.remove("verify_log");
                edit.commit();
            }
        });
    }

    /* renamed from: a */
    private static void m12668a(Context context, String str, Map<String, String> map) {
        if ("weixin".equals(str) || "sina".equals(str) || "qq".equals(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                String appkey = SocializeUtils.getAppkey(context);
                if (!TextUtils.isEmpty(appkey)) {
                    jSONObject.put("appkey", appkey);
                }
                String upperCase = Build.MODEL.replaceAll("\\s", Constants.ACCEPT_TIME_SEPARATOR_SERVER).toUpperCase();
                if (!TextUtils.isEmpty(upperCase)) {
                    jSONObject.put("device_model", upperCase);
                }
                jSONObject.put("os", DispatchConstants.ANDROID);
                String osVersion = DeviceConfig.getOsVersion();
                if (!TextUtils.isEmpty(osVersion)) {
                    jSONObject.put("os_version", osVersion);
                }
                jSONObject.put("sdk_version", "7.3.2");
                String uMId = UMUtils.getUMId(context);
                if (!TextUtils.isEmpty(uMId)) {
                    jSONObject.put("umid", uMId);
                }
                String str2 = DeviceConfig.getNetworkAccessMode(context)[0];
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(C3351bh.f11565Q, str2);
                }
                String str3 = DeviceConfig.getNetworkAccessMode(context)[1];
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(C3351bh.f11566R, str3);
                }
                jSONObject.put("carrier", "");
                String deviceId = DeviceConfig.getDeviceId(context);
                if (!TextUtils.isEmpty(deviceId)) {
                    jSONObject.put("device_id_type", "0");
                    jSONObject.put("device_id", deviceId);
                } else if (TextUtils.isEmpty("")) {
                    String androidID = DeviceConfig.getAndroidID(context);
                    if (!TextUtils.isEmpty(androidID)) {
                        jSONObject.put("device_id_type", "2");
                        jSONObject.put("device_id", androidID);
                    }
                } else {
                    jSONObject.put("device_id_type", "1");
                    jSONObject.put("device_id", "");
                }
                if ("weixin".equals(str)) {
                    jSONObject.put("source", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
                } else if ("sina".equals(str)) {
                    jSONObject.put("source", "weibo");
                } else {
                    jSONObject.put("source", str);
                }
                HashMap hashMap = new HashMap();
                String str4 = map.get(CommonNetImpl.AID);
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("appId", str4);
                }
                String str5 = map.get("openid");
                if (TextUtils.isEmpty(str5)) {
                    str5 = map.get("uid");
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put("openId", str5);
                }
                String str6 = map.get("unionid");
                if (!TextUtils.isEmpty(str6)) {
                    str5 = str6;
                }
                if (!TextUtils.isEmpty(str5)) {
                    hashMap.put("unionId", str5);
                }
                String str7 = map.get(CommonNetImpl.NAME);
                if (!TextUtils.isEmpty(str7)) {
                    hashMap.put("nickName", str7);
                }
                String str8 = map.get(UserInfo.GENDER);
                if (!TextUtils.isEmpty(str8)) {
                    if ("男".equals(str8)) {
                        hashMap.put(CommonNetImpl.SEX, "0");
                    } else if ("女".equals(str8)) {
                        hashMap.put(CommonNetImpl.SEX, "1");
                    } else {
                        hashMap.put(CommonNetImpl.SEX, str8);
                    }
                }
                jSONObject.put("info", new JSONObject(hashMap.toString()));
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                Set<String> stringSet = context.getSharedPreferences("umeng_verify", 0).getStringSet("verify_log", null);
                HashSet hashSet = new HashSet();
                if (stringSet != null && !stringSet.isEmpty()) {
                    Iterator<String> it = stringSet.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next());
                    }
                }
                hashSet.add(jSONObject.toString());
                SharedPreferences.Editor edit = context.getSharedPreferences("umeng_verify", 0).edit();
                edit.putStringSet("verify_log", hashSet);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m12669a(Runnable runnable) {
        ExecutorService executorService = f13705b;
        if (executorService == null || runnable == null) {
            return;
        }
        executorService.execute(runnable);
    }
}
