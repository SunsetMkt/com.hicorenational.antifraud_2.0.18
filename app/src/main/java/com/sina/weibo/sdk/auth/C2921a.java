package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.C2906a;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.C2937h;
import com.sina.weibo.sdk.p194b.C2923a;
import com.sina.weibo.sdk.p194b.C2925c;
import com.sina.weibo.sdk.web.WebActivity;
import com.sina.weibo.sdk.web.p196b.C2956a;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.bean.HandlerRequestCode;

/* renamed from: com.sina.weibo.sdk.auth.a */
/* loaded from: classes.dex */
public final class C2921a {

    /* renamed from: d */
    public WbAuthListener f9298d;

    /* renamed from: a */
    public final void m8815a(Activity activity) {
        C2925c.m8837a("WBSsoTag", "startClientAuth()");
        try {
            C2923a.a m8826e = C2923a.m8826e(activity);
            Intent intent = new Intent();
            if (m8826e == null) {
                intent.setClassName(BuildConfig.APPLICATION_ID, "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(m8826e.packageName, m8826e.f9301ag);
            }
            AuthInfo m8801a = C2906a.m8801a();
            intent.putExtra("appKey", m8801a.getAppKey());
            intent.putExtra("redirectUri", m8801a.getRedirectUrl());
            intent.putExtra(Constants.PARAM_SCOPE, m8801a.getScope());
            intent.putExtra("packagename", m8801a.getPackageName());
            intent.putExtra("key_hash", m8801a.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb.toString());
            if (activity == null) {
                this.f9298d.onError(new UiError(-1, "activity is null", ""));
            } else if (!C2923a.m8823a(activity, intent)) {
                this.f9298d.onError(new UiError(-2, "your app is illegal", ""));
            } else {
                activity.startActivityForResult(intent, HandlerRequestCode.SINA_AUTH_REQUEST_CODE);
                C2925c.m8837a("WBSsoTag", "start SsoActivity ");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C2925c.m8838b("WBSsoTag", e2.getMessage());
            this.f9298d.onError(new UiError(-3, "occur exception", e2.getMessage()));
        }
    }

    /* renamed from: b */
    public final void m8816b(Activity activity) {
        C2937h c2937h = new C2937h();
        AuthInfo m8801a = C2906a.m8801a();
        if (m8801a == null) {
            return;
        }
        c2937h.put(Constants.PARAM_CLIENT_ID, m8801a.getAppKey());
        c2937h.put("redirect_uri", m8801a.getRedirectUrl());
        c2937h.put(Constants.PARAM_SCOPE, m8801a.getScope());
        c2937h.put("packagename", m8801a.getPackageName());
        c2937h.put("key_hash", m8801a.getHash());
        c2937h.put("response_type", "code");
        c2937h.put("version", "0041005000");
        c2937h.put("luicode", "10000360");
        c2937h.put("lfid", "OP_" + m8801a.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                c2937h.put("trans_token", accessToken);
                c2937h.put("trans_access_token", accessToken);
            }
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + c2937h.m8860g();
        if (this.f9298d != null) {
            C2922b m8817b = C2922b.m8817b();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            m8817b.m8819a(sb2, this.f9298d);
            Intent intent = new Intent(activity, (Class<?>) WebActivity.class);
            C2956a c2956a = new C2956a(m8801a, str, sb2);
            Bundle bundle = new Bundle();
            c2956a.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
