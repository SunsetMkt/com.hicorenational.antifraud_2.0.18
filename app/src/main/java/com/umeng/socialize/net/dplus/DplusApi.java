package com.umeng.socialize.net.dplus;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.hihonor.honorid.core.data.UserInfo;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMMin;
import com.umeng.socialize.media.UMQQMini;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.media.UMusic;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UMAuthUtils;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p014u.C0052a;

/* loaded from: classes2.dex */
public class DplusApi {
    private static final String FULL = "false";
    private static final String SIMPLE = "true";
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructAuthContent(Map<String, String> map, boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put(CommonNetImpl.f13711AM, share_media.getsharestyle(z));
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put(CommonNetImpl.AID, map.get(CommonNetImpl.AID));
            constructBaseContent.put(CommonNetImpl.f13712AS, map.get(CommonNetImpl.f13712AS));
            if (TextUtils.isEmpty(map.get("access_token"))) {
                constructBaseContent.put("at", map.get("accessToken"));
            } else {
                constructBaseContent.put("at", map.get("access_token"));
            }
        }
        return constructBaseContent;
    }

    private static JSONObject constructBaseContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String share_media2 = share_media.toString();
        jSONObject.put("pf", share_media.getName());
        if ((share_media2.equals(SHARE_MEDIA.QQ.toString()) || share_media2.equals(SHARE_MEDIA.QZONE.toString())) && Config.isUmengQQ.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, "true");
        } else if ((share_media2.equals(SHARE_MEDIA.WEIXIN.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_CIRCLE.toString()) || share_media2.equals(SHARE_MEDIA.WEIXIN_FAVORITE.toString())) && Config.isUmengWx.booleanValue()) {
            jSONObject.put(CommonNetImpl.SDKT, "true");
        } else {
            jSONObject.put(CommonNetImpl.SDKT, "false");
        }
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put("tag", str);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructDauContent() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ts", System.currentTimeMillis());
        jSONObject.put(CommonNetImpl.SHARETYPE, Config.shareType);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructShareContent(ShareContent shareContent, boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        String str2 = shareContent.mText;
        constructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        constructBaseContent.put(CommonNetImpl.f13716SM, share_media.getsharestyle(z));
        if (!TextUtils.isEmpty(str2) && str2.length() > 10240) {
            str2 = str2.substring(0, 10240);
        }
        if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
            UMImage uMImage = (UMImage) shareContent.mMedia;
            if (uMImage != null) {
                if (uMImage.isUrlMedia()) {
                    constructBaseContent.put("picurl", uMImage.asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMImage.toByte())));
                }
            }
            constructBaseContent.put("ct", str2);
        } else if (shareContent.getShareType() == 1) {
            constructBaseContent.put("ct", str2);
        } else if (shareContent.getShareType() == 8) {
            UMVideo uMVideo = (UMVideo) shareContent.mMedia;
            if (uMVideo.getThumbImage() != null) {
                if (uMVideo.getThumbImage().isUrlMedia()) {
                    constructBaseContent.put("picurl", uMVideo.getThumbImage().asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMVideo.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                constructBaseContent.put("ct", str2);
            } else {
                constructBaseContent.put("ct", uMVideo.getDescription());
            }
            constructBaseContent.put("title", uMVideo.getTitle());
            constructBaseContent.put("url", uMVideo.toUrl());
        } else if (shareContent.getShareType() == 4) {
            UMusic uMusic = (UMusic) shareContent.mMedia;
            if (uMusic.getThumbImage() != null) {
                if (uMusic.getThumbImage().isUrlMedia()) {
                    constructBaseContent.put("picurl", uMusic.getThumbImage().asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMusic.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                constructBaseContent.put("ct", str2);
            } else {
                constructBaseContent.put("ct", uMusic.getDescription());
            }
            constructBaseContent.put("title", uMusic.getTitle());
            constructBaseContent.put(CommonNetImpl.DURL, uMusic.toUrl());
            constructBaseContent.put("url", uMusic.getmTargetUrl());
        } else if (shareContent.getShareType() == 32) {
            constructBaseContent.put("ct", str2);
        } else if (shareContent.getShareType() == 64) {
            UMEmoji uMEmoji = (UMEmoji) shareContent.mMedia;
            if (uMEmoji != null) {
                if (uMEmoji.isUrlMedia()) {
                    constructBaseContent.put("picurl", uMEmoji.asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.md5(uMEmoji.toByte()));
                }
            }
            constructBaseContent.put("ct", str2);
        } else if (shareContent.getShareType() == 128) {
            UMMin uMMin = (UMMin) shareContent.mMedia;
            if (uMMin.getThumbImage() != null) {
                if (uMMin.getThumbImage().isUrlMedia()) {
                    constructBaseContent.put("picurl", uMMin.getThumbImage().asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMMin.getThumbImage().toByte())));
                }
            }
            constructBaseContent.put("ct", uMMin.getDescription());
            constructBaseContent.put("title", uMMin.getTitle());
            constructBaseContent.put("url", uMMin.toUrl());
            constructBaseContent.put(CommonNetImpl.M_P, uMMin.getPath());
            constructBaseContent.put(CommonNetImpl.M_U, uMMin.getUserName());
        } else if (shareContent.getShareType() == 256) {
            UMQQMini uMQQMini = (UMQQMini) shareContent.mMedia;
            if (uMQQMini.getThumbImage() != null) {
                if (uMQQMini.getThumbImage().isUrlMedia()) {
                    constructBaseContent.put("picurl", uMQQMini.getThumbImage().asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMQQMini.getThumbImage().toByte())));
                }
            }
            constructBaseContent.put("ct", uMQQMini.getDescription());
            constructBaseContent.put("title", uMQQMini.getTitle());
            constructBaseContent.put("url", uMQQMini.toUrl());
            constructBaseContent.put(CommonNetImpl.M_P, uMQQMini.getPath());
            constructBaseContent.put(CommonNetImpl.M_U, uMQQMini.getMiniAppId());
        } else if (shareContent.getShareType() == 16) {
            UMWeb uMWeb = (UMWeb) shareContent.mMedia;
            if (uMWeb.getThumbImage() != null) {
                if (uMWeb.getThumbImage().isUrlMedia()) {
                    constructBaseContent.put("picurl", uMWeb.getThumbImage().asUrlImage());
                } else {
                    constructBaseContent.put("pic", SocializeUtils.hexdigest(SocializeUtils.md5(uMWeb.getThumbImage().toByte())));
                }
            }
            if (share_media == SHARE_MEDIA.SINA) {
                constructBaseContent.put("ct", str2);
            } else {
                constructBaseContent.put("ct", uMWeb.getDescription());
            }
            constructBaseContent.put("title", uMWeb.getTitle());
            constructBaseContent.put("url", uMWeb.toUrl());
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsAuthStartContent(boolean z, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_A_S);
        constructBaseContent.put(CommonNetImpl.f13711AM, share_media.getsharestyle(z));
        return constructBaseContent;
    }

    private static JSONObject constructStatsDauContent(Map<String, String> map, int i2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommonNetImpl.NAME, CommonNetImpl.S_DAU);
        jSONObject.put(CommonNetImpl.A_B, i2);
        if (map != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(map.get("position")) && !TextUtils.isEmpty(map.get(CommonNetImpl.MENUBG))) {
                jSONObject2.put("position", map.get("position"));
                jSONObject2.put(CommonNetImpl.MENUBG, map.get(CommonNetImpl.MENUBG));
                jSONObject.put(CommonNetImpl.S_I, jSONObject2);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsInfoStartContent(SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_I_S);
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareContent(ShareContent shareContent, boolean z, SHARE_MEDIA share_media, boolean z2, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_S);
        constructBaseContent.put(CommonNetImpl.U_C, z2 + "");
        constructBaseContent.put(CommonNetImpl.f13716SM, share_media.getsharestyle(z));
        constructBaseContent.put(CommonNetImpl.STYPE, shareContent.getShareType());
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructStatsShareEndContent(SHARE_MEDIA share_media, String str, String str2, String str3) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        constructBaseContent.put(CommonNetImpl.NAME, CommonNetImpl.S_S_E);
        constructBaseContent.put("result", str2);
        if (!TextUtils.isEmpty(str3)) {
            constructBaseContent.put(CommonNetImpl.E_M, str3);
        }
        return constructBaseContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject constructUserInfoContent(Map<String, String> map, SHARE_MEDIA share_media, String str) throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(share_media, str);
        if (map != null) {
            constructBaseContent.put(CommonNetImpl.f13718UN, map.get(CommonNetImpl.NAME));
            constructBaseContent.put(CommonNetImpl.f13719UP, map.get("iconurl"));
            constructBaseContent.put(CommonNetImpl.SEX, map.get(UserInfo.GENDER));
            if (TextUtils.isEmpty(map.get("location"))) {
                constructBaseContent.put(CommonNetImpl.REGION, map.get(UserInfo.CITY));
            } else {
                constructBaseContent.put(CommonNetImpl.REGION, map.get("location"));
            }
            if (share_media.toString().equals("WEIXIN")) {
                constructBaseContent.put("uid", map.get("openid"));
            } else {
                constructBaseContent.put("uid", map.get("uid"));
            }
            if (SHARE_MEDIA.BYTEDANCE == share_media) {
                String str2 = map.get("encrypt_mobile");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str2, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.BYTEDANCE)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } else if (SHARE_MEDIA.HONOR == share_media) {
                String str3 = map.get("mobileNumber");
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        constructBaseContent.put("pn", new String(Base64.encode(SocializeUtils.md5(UMAuthUtils.decrypt(str3, ((PlatformConfig.APPIDPlatform) PlatformConfig.configs.get(SHARE_MEDIA.HONOR)).getAppSecret()).replace(new String(Base64.decode("Kzg2", 0)), "").getBytes()).getBytes(), 0)));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            constructBaseContent.put("unionid", map.get("unionid"));
            constructBaseContent.put("ts", System.currentTimeMillis());
        }
        return constructBaseContent;
    }

    public static JSONObject getFakeData() throws JSONException {
        JSONObject constructBaseContent = constructBaseContent(SHARE_MEDIA.SINA, C0052a.f162n);
        constructBaseContent.put(CommonNetImpl.NAME, "testetstttttttttttttttttttttttttttttttt");
        constructBaseContent.put(CommonNetImpl.U_C, true);
        constructBaseContent.put(CommonNetImpl.f13716SM, "sso");
        constructBaseContent.put(CommonNetImpl.STYPE, 0);
        return constructBaseContent;
    }

    public static void uploadAuth(final Context context, final Map<String, String> map, final boolean z, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.AUTH_EVENT, CommonNetImpl.get(context), DplusApi.constructAuthContent(map, z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadAuthStart(final Context context, final boolean z, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsAuthStartContent(z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadAuthend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsAuthEndContent(SHARE_MEDIA.this, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadDAU(final Context context) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.DAU_EVENT, CommonNetImpl.get(context), DplusApi.constructDauContent());
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadInfoStart(final Context context, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsInfoStartContent(SHARE_MEDIA.this, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadInfoend(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsInfoEndContent(SHARE_MEDIA.this, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadShare(final Context context, final ShareContent shareContent, final boolean z, final SHARE_MEDIA share_media, final String str, final boolean z2) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SHARE_EVENT, CommonNetImpl.get(context), DplusApi.constructShareContent(ShareContent.this, z, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsShareContent(ShareContent.this, z, share_media, z2, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadStatsDAU(Context context, Map<String, String> map, int i2) {
    }

    public static void uploadStatsShareEnd(final Context context, final SHARE_MEDIA share_media, final String str, final String str2, final String str3) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.SAVE_STATS_EVENT, CommonNetImpl.get(context), DplusApi.constructStatsShareEndContent(SHARE_MEDIA.this, str, str2, str3));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }

    public static void uploadUserInfo(final Context context, final Map<String, String> map, final SHARE_MEDIA share_media, final String str) {
        mExecutor.execute(new Runnable() { // from class: com.umeng.socialize.net.dplus.DplusApi.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMWorkDispatch.sendEvent(context, SocializeConstants.GET_EVENT, CommonNetImpl.get(context), DplusApi.constructUserInfoContent(map, share_media, str));
                } catch (JSONException e2) {
                    SLog.error(e2);
                }
            }
        });
    }
}
