package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.sina.weibo.sdk.C2906a;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.C2921a;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.p194b.C2923a;
import com.sina.weibo.sdk.p194b.C2925c;
import com.sina.weibo.sdk.share.C2945e;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.web.p196b.C2959d;
import com.xiaomi.mipush.sdk.PushMessageHelper;

/* renamed from: com.sina.weibo.sdk.openapi.a */
/* loaded from: classes.dex */
public final class C2938a implements IWBAPI {
    private Context mContext;

    /* renamed from: r */
    private C2921a f9325r = new C2921a();

    /* renamed from: s */
    private C2945e f9326s = new C2945e();

    public C2938a(Context context) {
        this.mContext = context;
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        C2921a c2921a = this.f9325r;
        C2925c.m8837a("WBSsoTag", "authorize()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        c2921a.f9298d = wbAuthListener;
        if (C2906a.m8803a(activity)) {
            if (C2923a.m8826e(activity) != null) {
                c2921a.m8815a(activity);
                return;
            }
        }
        c2921a.m8816b(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(Activity activity, int i2, int i3, Intent intent) {
        C2921a c2921a = this.f9325r;
        C2925c.m8837a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = c2921a.f9298d;
        if (wbAuthListener != null) {
            if (32973 != i2) {
                wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
                return;
            }
            if (i3 != -1) {
                if (i3 == 0) {
                    wbAuthListener.onCancel();
                    return;
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                    return;
                }
            }
            if (intent != null) {
                String stringExtra = intent.getStringExtra("error");
                String stringExtra2 = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
                String stringExtra3 = intent.getStringExtra("error_description");
                if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(stringExtra2) || !TextUtils.isEmpty(stringExtra3)) {
                    if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        c2921a.f9298d.onCancel();
                        return;
                    } else {
                        c2921a.f9298d.onError(new UiError(-5, stringExtra2, stringExtra3));
                        return;
                    }
                }
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                if (parseAccessToken == null) {
                    c2921a.f9298d.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                } else {
                    AccessTokenHelper.writeAccessToken(activity, parseAccessToken);
                    c2921a.f9298d.onComplete(parseAccessToken);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        C2921a c2921a = this.f9325r;
        C2925c.m8837a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        c2921a.f9298d = wbAuthListener;
        c2921a.m8815a(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        C2921a c2921a = this.f9325r;
        C2925c.m8837a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener == null) {
            throw new RuntimeException("listener can not be null.");
        }
        c2921a.f9298d = wbAuthListener;
        c2921a.m8816b(activity);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i2 = extras.getInt("_weibo_resp_errcode", -1);
            if (i2 == 0) {
                wbShareCallback.onComplete();
            } else if (i2 == 1) {
                wbShareCallback.onCancel();
            } else {
                if (i2 != 2) {
                    return;
                }
                wbShareCallback.onError(new UiError(i2, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e2) {
            wbShareCallback.onError(new UiError(-1, e2.getMessage(), e2.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return C2906a.m8803a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return C2906a.m8804b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, null);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z) {
        C2925c.setLoggerEnable(z);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z) {
        AuthInfo m8801a;
        C2945e c2945e = this.f9326s;
        if (activity != null) {
            if (C2906a.m8803a(activity) || !z) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c2945e.f9338D >= C2084a.f6136r) {
                    c2945e.f9338D = currentTimeMillis;
                    if (z) {
                        C2945e.m8877a(activity, weiboMultiMessage);
                        return;
                    }
                    C2923a.a m8826e = C2923a.m8826e(activity);
                    if (C2906a.m8803a(activity) && m8826e != null) {
                        C2923a.a m8826e2 = C2923a.m8826e(activity);
                        boolean z2 = false;
                        if (m8826e2 != null && m8826e2.f9302ah > 10000) {
                            z2 = true;
                        }
                        if (z2) {
                            C2945e.m8877a(activity, weiboMultiMessage);
                            return;
                        }
                    }
                    if (activity == null || (m8801a = C2906a.m8801a()) == null) {
                        return;
                    }
                    C2959d c2959d = new C2959d(m8801a);
                    c2959d.setContext(activity);
                    c2959d.f9362aE = weiboMultiMessage;
                    c2959d.packageName = activity.getPackageName();
                    Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                    if (readAccessToken != null) {
                        String accessToken = readAccessToken.getAccessToken();
                        if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                            c2959d.f9365ae = accessToken;
                        }
                    }
                    Bundle bundle = new Bundle();
                    c2959d.writeToBundle(bundle);
                    Intent intent = new Intent(activity, (Class<?>) ShareTransActivity.class);
                    intent.putExtra("start_flag", 1001);
                    intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, 10001);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        C2906a.m8802a(authInfo, sdkListener);
    }
}
