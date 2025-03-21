package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.huawei.hms.framework.common.ContainerUtils;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.C3211c;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.p211a.C3255f;
import com.tencent.open.p212b.C3260b;
import com.tencent.open.p214im.C3273IM;
import com.tencent.open.utils.C3288f;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR = false;

    /* renamed from: c */
    private static Tencent f11343c = null;

    /* renamed from: d */
    private static boolean f11344d = false;
    public static boolean disableResetOrientation = false;

    /* renamed from: a */
    private final C3211c f11345a;

    /* renamed from: b */
    private String f11346b;

    private Tencent(String str, Context context) {
        this.f11345a = C3211c.m10234a(str, context);
        C3260b.m10440a().m10450a(str, context);
        C3288f.m10596a().m10597a(context);
    }

    /* renamed from: a */
    private static boolean m10731a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            SLog.m10500e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.Tencent", "checkManifestConfig exception", th);
        }
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.m10500e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
            return false;
        } catch (Throwable th2) {
            SLog.m10501e("openSDK_LOG.Tencent", "checkManifestConfig exception", th2);
            return true;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            createInstance = createInstance(str, context);
            SLog.m10502i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
            m10730a("createInstance_authority", "appid", str, "authorities", str2);
            if (createInstance != null) {
                createInstance.f11346b = str2;
            } else {
                SLog.m10502i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
            }
        }
        return createInstance;
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            m10730a("getAuthorities", "appid", str);
            if (TextUtils.isEmpty(str)) {
                SLog.m10502i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            if (f11343c != null) {
                return str.equals(f11343c.getAppId()) ? f11343c.f11346b : "";
            }
            SLog.m10502i("openSDK_LOG.Tencent", "sInstance == null");
            return null;
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m10502i("openSDK_LOG.Tencent", sb.toString());
        m10730a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isPermissionNotGranted() {
        return !f11344d || TextUtils.isEmpty(C3288f.m10596a().m10599b());
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z = C3293k.m10645c(context, "5.9.5") >= 0;
        SLog.m10502i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        m10729a("isSupportPushToQZone", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.m10502i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (C3295m.m10694c(context) && C3293k.m10634a(context, Constants.PACKAGE_QQ_PAD) != null) {
            m10729a("isSupportShareToQQ", (Object) true);
            return true;
        }
        if (C3293k.m10645c(context, "4.1") < 0 && C3293k.m10634a(context, Constants.PACKAGE_TIM) == null) {
            z = false;
        }
        SLog.m10502i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        m10729a("isSupportShareToQQ", Boolean.valueOf(z));
        return z;
    }

    public static boolean onActivityResultData(int i2, int i3, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i2);
        sb.append(", resultcode = ");
        sb.append(i3);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m10502i("openSDK_LOG.Tencent", sb.toString());
        m10730a("onActivityResultData", "requestCode", Integer.valueOf(i2), AbstractC3059b.JSON_ERRORCODE, Integer.valueOf(i3));
        return UIListenerManager.getInstance().onActivityResult(i2, i3, intent, iUiListener);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        m10730a("parseMiniParameters", new Object[0]);
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.m10500e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e2);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SLog.m10498d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        Uri data = intent.getData();
        if (data == null) {
            SLog.m10498d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        String uri = data.toString();
        if (TextUtils.isEmpty(uri)) {
            SLog.m10498d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(substring)) {
            SLog.m10498d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        SLog.m10498d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (String str : substring.split("&")) {
            String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void resetQQAppInfoCache() {
        C3293k.m10636a("com.tencent.mobileqq");
    }

    public static void resetTargetAppInfoCache() {
        C3293k.m10635a();
    }

    public static void resetTimAppInfoCache() {
        C3293k.m10636a(Constants.PACKAGE_TIM);
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.m10502i("openSDK_LOG.Tencent", "setCustomLogger");
        m10730a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    public static void setIsPermissionGranted(boolean z) {
        String str;
        SLog.m10502i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z);
        if (z) {
            C3288f.m10596a().m10597a(C3289g.m10603a());
            str = C3288f.m10596a().m10599b();
            if (str == null || str.isEmpty()) {
                str = Build.MODEL;
            }
        } else {
            str = "";
        }
        setIsPermissionGranted(z, str);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "bindQQGroup()");
        m10730a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void callCommonChannelApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        C3211c c3211c = this.f11345a;
        SLog.m10502i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(c3211c, c3211c.m10247b()).launchQQ(activity, bundle, iUiListener));
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "checkLogin()");
        m10730a("checkLogin", new Object[0]);
        this.f11345a.m10244a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f11345a.m10247b().getAccessToken();
        SLog.m10502i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        m10730a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f11345a.m10247b().getAppId();
        SLog.m10502i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        m10729a("getAppId", appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f11345a.m10247b().getExpireTimeInSecond();
        SLog.m10502i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        m10729a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f11345a.m10247b().getOpenId();
        SLog.m10502i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        m10730a("getOpenId", new Object[0]);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.m10502i("openSDK_LOG.Tencent", "getQQToken()");
        m10730a("getQQToken", new Object[0]);
        return this.f11345a.m10247b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.m10502i("openSDK_LOG.Tencent", sb.toString());
        m10730a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        m10730a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.m10502i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e2) {
            SLog.m10502i("QQToken", "initSessionCache " + e2.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean m10643b = C3293k.m10643b(context);
        SLog.m10502i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + m10643b);
        m10729a("isQQInstalled", Boolean.valueOf(m10643b));
        return m10643b;
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        SLog.m10502i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        m10729a("isReady", Boolean.valueOf(z));
        return z;
    }

    public boolean isSessionValid() {
        boolean m10249c = this.f11345a.m10249c();
        SLog.m10502i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + m10249c);
        m10729a("isSessionValid", Boolean.valueOf(m10249c));
        return m10249c;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.m10502i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (C3295m.m10694c(activity) && C3293k.m10634a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            m10729a("isSupportSSOLogin", (Object) true);
            return true;
        }
        if (C3293k.m10645c(activity, "4.1") < 0 && C3293k.m10648d(activity, "1.1") < 0) {
            z = false;
        }
        SLog.m10502i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        m10729a("isSupportSSOLogin", Boolean.valueOf(z));
        return z;
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "joinQQGroup()");
        m10730a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f11345a.m10247b().loadSession(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(loadSession != null ? loadSession.length() : 0);
        SLog.m10502i("openSDK_LOG.Tencent", sb.toString());
        m10730a("loadSession", "appid", str);
        return loadSession;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        m10730a("login_scope", Constants.PARAM_SCOPE, str);
        return this.f11345a.m10237a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        m10730a("loginServerSide_activity", Constants.PARAM_SCOPE, str);
        return this.f11345a.m10237a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.m10502i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        m10730a("loginWithOEM", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z), "registerChannel", str2, "installChannel", str3, com.taobao.accs.common.Constants.KEY_BUSINESSID, str4);
        return this.f11345a.m10240a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.m10502i("openSDK_LOG.Tencent", "logout()");
        m10730a("logout", new Object[0]);
        this.f11345a.m10247b().setAccessToken(null, "0");
        this.f11345a.m10247b().setOpenId(null);
        this.f11345a.m10247b().removeSession(this.f11345a.m10247b().getAppId());
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "publishToQzone()");
        m10730a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f11345a.m10247b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        m10730a("reAuth", Constants.PARAM_SCOPE, str);
        return this.f11345a.m10246b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.m10502i("openSDK_LOG.Tencent", "reportDAU() ");
        m10730a("reportDAU", new Object[0]);
        this.f11345a.m10243a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.m10502i("openSDK_LOG.Tencent", "request()");
        m10730a(SocialConstants.TYPE_REQUEST, "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f11345a.m10247b(), C3289g.m10603a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "requestAsync()");
        m10730a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f11345a.m10247b(), C3289g.m10603a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.m10502i("openSDK_LOG.Tencent", sb.toString());
        m10730a("saveSession", new Object[0]);
        this.f11345a.m10247b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.m10502i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        m10730a("setAccessToken", new Object[0]);
        this.f11345a.m10245a(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "setAvatar()");
        m10730a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f11345a.m10247b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        m10730a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f11345a.m10247b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        m10730a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f11345a.m10247b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "saveQQEmotions()");
        m10730a("setEmotions", new Object[0]);
        new QQEmotion(this.f11345a.m10247b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.m10502i("openSDK_LOG.Tencent", "setOpenId() --start");
        m10730a("setOpenId", new Object[0]);
        this.f11345a.m10248b(C3289g.m10603a(), str);
        SLog.m10502i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "shareToQQ()");
        m10730a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f11346b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f11345a.m10247b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "shareToQzone()");
        m10730a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f11345a.m10247b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.m10502i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f11345a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.m10502i("openSDK_LOG.Tencent", "startIMAio()");
        m10730a("startIMAio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C3273IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.m10502i("openSDK_LOG.Tencent", "startIMAudio()");
        m10730a("startIMAudio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C3273IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        m10730a("startIMConversation", "chatType", str, "uin", str2, Constants.PARAM_PKG_NAME, str3);
        return new C3273IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.m10502i("openSDK_LOG.Tencent", "startIMVideo()");
        m10730a("startIMVideo", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, C3273IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.m10502i("openSDK_LOG.Tencent", "startMiniApp()");
        m10730a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "unBindQQGroup()");
        m10730a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }

    public boolean isQQInstalled(Context context, String str) {
        boolean z = C3293k.m10645c(context, str) >= 0;
        SLog.m10502i("openSDK_LOG.Tencent", "isQQInstalled version[" + str + "] = " + z);
        return z;
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.m10502i("openSDK_LOG.Tencent", "login activity with params");
        m10730a("login_param", new Object[0]);
        return this.f11345a.m10236a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        m10730a("loginServerSide_fragment", Constants.PARAM_SCOPE, str);
        return this.f11345a.m10241a(fragment, str + ",server_side", iUiListener, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            C3289g.m10605a(context.getApplicationContext());
            SLog.m10502i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.m10500e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            if (f11343c == null) {
                f11343c = new Tencent(str, context);
            } else if (!str.equals(f11343c.getAppId())) {
                f11343c.logout(context);
                f11343c = new Tencent(str, context);
            }
            if (!m10731a(context, str)) {
                return null;
            }
            m10730a("createInstance", "appid", str);
            C3255f.m10416a().m10423a(C3291i.m10615a(context, str));
            SLog.m10502i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return f11343c;
        }
    }

    public static void setIsPermissionGranted(boolean z, String str) {
        SLog.m10502i("openSDK_LOG.Tencent", "setIsPermissionGranted, isPermissionGranted: " + z + ", model = " + str);
        String str2 = null;
        if (z) {
            if (str == null || str.trim().isEmpty()) {
                SLog.m10500e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + str + "]");
                z = false;
            } else {
                str2 = str;
            }
        }
        f11344d = z;
        C3288f.m10596a().m10598a(C3289g.m10603a(), str2);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.m10502i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        m10730a("login_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f11345a.m10239a(activity, str, iUiListener, z);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i2, int i3) {
        SLog.m10502i("openSDK_LOG.Tencent", "setAvatar()");
        m10730a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i3);
        activity.overridePendingTransition(i2, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.m10502i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        m10730a("login_fragment_scope", Constants.PARAM_SCOPE, str);
        return this.f11345a.m10241a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z) {
        SLog.m10502i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        m10730a("login_fragment_scope_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z));
        return this.f11345a.m10242a(fragment, str, iUiListener, "", z);
    }

    /* renamed from: a */
    private static void m10730a(String str, Object... objArr) {
        C3260b.m10440a().m10452a(str, m10728a(objArr));
    }

    /* renamed from: a */
    private static String m10728a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2 += 2) {
            if (i2 > 0) {
                sb.append('|');
            }
            sb.append(objArr[i2]);
            sb.append(':');
            sb.append(objArr[i2 + 1]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m10729a(String str, Object obj) {
        C3260b.m10440a().m10451a(str, obj);
    }
}
