package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.hihonor.cloudservice.support.account.request.C2131a;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.common.QueuedWork;
import com.umeng.socialize.honor.BuildConfig;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UMAuthUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p031c.p075c.p076a.p077a.C1182a;
import p031c.p075c.p076a.p084c.p085a.C1198a;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.InterfaceC1210g;
import p031c.p075c.p076a.p090d.InterfaceC1211h;

/* loaded from: classes2.dex */
public class UMHonorHandler extends UMSSOHandler {
    private static final String TAG = "UMHonorHandler";
    private PlatformConfig.APPIDPlatform config;
    private UMAuthListener mAuthListener;
    private UMHonorPreferences mSP;
    private SHARE_MEDIA mTarget = SHARE_MEDIA.HONOR;
    private final String SCOPE_NUM = "https://www.hihonor.com/auth/account/mobile.number";
    private final String SCOPE_PROFILE = "profile";

    /* JADX INFO: Access modifiers changed from: private */
    public void getTokenByCode(SignInAccountInfo signInAccountInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "authorization_code");
        hashMap.put("code", signInAccountInfo.m6045b());
        String str = this.config.redirectUrl;
        if (TextUtils.isEmpty(str)) {
            str = "honorid://redirect_url";
        }
        hashMap.put("redirect_uri", str);
        hashMap.put(Constants.PARAM_CLIENT_ID, this.config.getAppid());
        hashMap.put("client_secret", this.config.getAppSecret());
        final Pair<Integer, String> request = request("https://hnoauth-login.cloud.hihonor.com/oauth2/v3/token", hashMap);
        if (((Integer) request.first).intValue() != 200) {
            String str2 = "failed:" + ((String) request.second);
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Exception((String) request.second));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) request.second);
            if (jSONObject.has("access_token")) {
                getUserInfoByToken(jSONObject.getString("access_token"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        }
    }

    private void getUserInfoByToken(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", str);
        hashMap.put("getNickName", "1");
        final Pair<Integer, String> request = request("https://account-drcn.platform.hihonorcloud.com/rest.php?nsp_svc=GOpen.User.getInfo", hashMap);
        if (((Integer) request.first).intValue() != 200) {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Exception((String) request.second));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        try {
            final Map<String, String> jsonToMap = SocializeUtils.jsonToMap(new JSONObject((String) request.second).toString());
            if (this.mSP != null) {
                this.mSP.setAuthed();
            }
            jsonToMap.put("uid", jsonToMap.get("openID"));
            jsonToMap.put(CommonNetImpl.NAME, jsonToMap.get("displayName"));
            jsonToMap.put("iconurl", jsonToMap.get(UserInfo.HEADPICTUREURL));
            String remove = jsonToMap.remove("mobileNumber");
            if (!TextUtils.isEmpty(remove)) {
                jsonToMap.put("mobileNumber", UMAuthUtils.encrypt(remove, this.config.getAppSecret()));
            }
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onComplete(UMHonorHandler.this.mTarget, 0, jsonToMap);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, th);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSignIn(final SignInAccountInfo signInAccountInfo) {
        if (signInAccountInfo == null) {
            SLog.debug("UMHonorHandler logPrintln : signInAccountInfo is null");
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Exception("signInAccountInfo == null"));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        SLog.debug("UMHonorHandler authorizationCode: " + signInAccountInfo.m6045b());
        QueuedWork.runInBack(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMHonorHandler.this.getTokenByCode(signInAccountInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, th);
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }, true);
    }

    public static Pair<Integer, String> request(String str, Map<String, String> map) {
        String message;
        String encodedQuery;
        int i2 = -1;
        try {
            Uri.Builder builder = new Uri.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            encodedQuery = builder.build().getEncodedQuery();
        } catch (Throwable th) {
            SLog.error(th);
            message = th.getMessage();
        }
        if (encodedQuery == null) {
            return Pair.create(-1, "{}");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setReadTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.getOutputStream().write(encodedQuery.getBytes());
        i2 = httpURLConnection.getResponseCode();
        InputStream inputStream = i2 < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        message = sb.toString();
        SLog.m12717I("response:" + message);
        bufferedReader.close();
        inputStream.close();
        return Pair.create(Integer.valueOf(i2), message);
    }

    private void silentSignIn() {
        final String appid = this.config.getAppid();
        final Activity currentActivity = getCurrentActivity();
        if (!TextUtils.isEmpty(appid) && currentActivity != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Scope("profile"));
            arrayList.add(new Scope("https://www.hihonor.com/auth/account/mobile.number"));
            C1198a.m2292b(currentActivity, new C2131a(SignInOptions.f6374q).m5984a(arrayList).m5987b(appid).m5981a()).mo2309a().mo2328a(new InterfaceC1211h<SignInAccountInfo>() { // from class: com.umeng.socialize.handler.UMHonorHandler.4
                @Override // p031c.p075c.p076a.p090d.InterfaceC1211h
                public void onSuccess(SignInAccountInfo signInAccountInfo) {
                    UMHonorHandler.this.onSignIn(signInAccountInfo);
                }
            }).mo2327a(new InterfaceC1210g() { // from class: com.umeng.socialize.handler.UMHonorHandler.3
                @Override // p031c.p075c.p076a.p090d.InterfaceC1210g
                public void onFailure(Exception exc) {
                    C1182a c1182a = (C1182a) exc;
                    try {
                        if (c1182a.getStatusCode() == 55 || c1182a.getStatusCode() == 31) {
                            UMHonorHandler.this.jumpAuthorization(currentActivity, appid);
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    final String message = c1182a.getMessage();
                    SLog.m12716E("UMHonorHandler error: " + message);
                    QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Throwable(message));
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                }
            });
            return;
        }
        SLog.m12716E("UMHonorHandler appId:" + appid + " activity:" + currentActivity);
        QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Throwable(UmengErrorCode.AuthorizeFailed.getMessage()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void authorize(final UMAuthListener uMAuthListener) {
        this.mAuthListener = uMAuthListener;
        if (isInstall()) {
            silentSignIn();
        } else {
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(uMAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void deleteAuth(final UMAuthListener uMAuthListener) {
        Runnable runnable;
        String appid;
        Runnable runnable2;
        try {
            if (this.mSP != null) {
                this.mSP.delete();
            }
            appid = this.config.getAppid();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                runnable = new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.17
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMHonorHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.HONOR, 1, null);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                };
            } catch (Throwable th2) {
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.17
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMHonorHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.HONOR, 1, null);
                        } catch (Throwable th22) {
                            th22.printStackTrace();
                        }
                    }
                });
                throw th2;
            }
        }
        if (TextUtils.isEmpty(appid)) {
            SLog.m12717I("UMHonorHandler appId null");
            runnable2 = new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.HONOR, 1, null);
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                    }
                }
            };
        } else {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Scope("profile"));
                arrayList.add(new Scope("https://www.hihonor.com/auth/account/mobile.number"));
                C1198a.m2292b(currentActivity, new C2131a().m5987b(appid).m5984a(arrayList).m5981a()).mo2312d().mo2328a(new InterfaceC1211h<Void>() { // from class: com.umeng.socialize.handler.UMHonorHandler.16
                    @Override // p031c.p075c.p076a.p090d.InterfaceC1211h
                    public void onSuccess(Void r1) {
                        SLog.m12717I("UMHonorHandler cancelAuthorization Success");
                    }
                }).mo2327a(new InterfaceC1210g() { // from class: com.umeng.socialize.handler.UMHonorHandler.15
                    @Override // p031c.p075c.p076a.p090d.InterfaceC1210g
                    public void onFailure(Exception exc) {
                        SLog.m12716E("UMHonorHandlercancelAuthorization fail: " + exc.toString());
                    }
                });
                runnable = new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.17
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMHonorHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.HONOR, 1, null);
                        } catch (Throwable th22) {
                            th22.printStackTrace();
                        }
                    }
                };
                QueuedWork.runInMain(runnable);
                return;
            }
            SLog.m12717I("UMHonorHandler activity null");
            runnable2 = new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(uMAuthListener).onComplete(SHARE_MEDIA.HONOR, 1, null);
                    } catch (Throwable th22) {
                        th22.printStackTrace();
                    }
                }
            };
        }
        QueuedWork.runInMain(runnable2);
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getGender(Object obj) {
        return "";
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void getPlatformInfo(UMAuthListener uMAuthListener) {
        authorize(uMAuthListener);
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public int getRequestCode() {
        return HandlerRequestCode.HONOR_REQUEST_CODE;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getSDKVersion() {
        return "6.0.3.004";
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public String getVersion() {
        return BuildConfig.UMENG_VERSION;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isAuthorize() {
        UMHonorPreferences uMHonorPreferences = this.mSP;
        return uMHonorPreferences != null && uMHonorPreferences.isAuthed();
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isHasAuthListener() {
        return this.mAuthListener != null;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isInstall() {
        try {
            Context context = ContextUtil.getContext();
            if (C1198a.m2289a()) {
                return !C1198a.m2293b(context);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isSupport() {
        return isInstall();
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean isSupportAuth() {
        return isInstall();
    }

    public void jumpAuthorization(Activity activity, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Scope("profile"));
        arrayList.add(new Scope("https://www.hihonor.com/auth/account/mobile.number"));
        Intent mo2311c = C1198a.m2292b(activity, new C2131a(SignInOptions.f6374q).m5987b(str).m5984a(arrayList).m5981a()).mo2311c();
        if (mo2311c != null) {
            activity.startActivityFromChild(activity, mo2311c, getRequestCode());
        } else {
            SLog.m12716E("UMHonorHandler Honor version too low");
            QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, new Throwable(UmengErrorCode.NotInstall.getMessage()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (getRequestCode() == i2) {
            try {
                AbstractC1213j<SignInAccountInfo> m2285a = C1198a.m2285a(i3, intent);
                if (m2285a.mo2343e()) {
                    onSignIn(m2285a.mo2340b());
                    return;
                }
                final Exception mo2336a = m2285a.mo2336a();
                if (mo2336a instanceof C1182a) {
                    C1182a c1182a = (C1182a) mo2336a;
                    SLog.m12716E("UMHonorHandler errCode : " + c1182a.getStatusCode() + " , errMsg = " + c1182a.getMessage());
                }
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, mo2336a);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } catch (Throwable th) {
                th.printStackTrace();
                QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            UMHonorHandler.this.getAuthListener(UMHonorHandler.this.mAuthListener).onError(UMHonorHandler.this.mTarget, 0, th);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void onCreate(Context context, PlatformConfig.Platform platform) {
        super.onCreate(context, platform);
        this.config = (PlatformConfig.APPIDPlatform) platform;
        this.mSP = new UMHonorPreferences(context);
        PlatformConfig.APPIDPlatform aPPIDPlatform = this.config;
        if (aPPIDPlatform != null) {
            this.mTarget = aPPIDPlatform.getName();
        }
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void release() {
        super.release();
        this.mAuthListener = null;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public void setAuthListener(UMAuthListener uMAuthListener) {
        super.setAuthListener(uMAuthListener);
        this.mAuthListener = uMAuthListener;
    }

    @Override // com.umeng.socialize.handler.UMSSOHandler
    public boolean share(ShareContent shareContent, final UMShareListener uMShareListener) {
        QueuedWork.runInMain(new Runnable() { // from class: com.umeng.socialize.handler.UMHonorHandler.18
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (uMShareListener != null) {
                        uMShareListener.onError(UMHonorHandler.this.mTarget, new Throwable("not supported!"));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        return false;
    }
}
