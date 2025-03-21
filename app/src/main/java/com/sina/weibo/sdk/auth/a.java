package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.bean.HandlerRequestCode;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public WbAuthListener f8358d;

    public final void a(Activity activity) {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            a.C0121a e2 = com.sina.weibo.sdk.b.a.e(activity);
            Intent intent = new Intent();
            if (e2 == null) {
                intent.setClassName(BuildConfig.APPLICATION_ID, "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(e2.packageName, e2.ag);
            }
            AuthInfo a2 = com.sina.weibo.sdk.a.a();
            intent.putExtra("appKey", a2.getAppKey());
            intent.putExtra("redirectUri", a2.getRedirectUrl());
            intent.putExtra(Constants.PARAM_SCOPE, a2.getScope());
            intent.putExtra("packagename", a2.getPackageName());
            intent.putExtra("key_hash", a2.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb.toString());
            if (activity == null) {
                this.f8358d.onError(new UiError(-1, "activity is null", ""));
            } else if (!com.sina.weibo.sdk.b.a.a(activity, intent)) {
                this.f8358d.onError(new UiError(-2, "your app is illegal", ""));
            } else {
                activity.startActivityForResult(intent, HandlerRequestCode.SINA_AUTH_REQUEST_CODE);
                c.a("WBSsoTag", "start SsoActivity ");
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            c.b("WBSsoTag", e3.getMessage());
            this.f8358d.onError(new UiError(-3, "occur exception", e3.getMessage()));
        }
    }

    public final void b(Activity activity) {
        h hVar = new h();
        AuthInfo a2 = com.sina.weibo.sdk.a.a();
        if (a2 == null) {
            return;
        }
        hVar.put(Constants.PARAM_CLIENT_ID, a2.getAppKey());
        hVar.put("redirect_uri", a2.getRedirectUrl());
        hVar.put(Constants.PARAM_SCOPE, a2.getScope());
        hVar.put("packagename", a2.getPackageName());
        hVar.put("key_hash", a2.getHash());
        hVar.put("response_type", "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", "OP_" + a2.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.g();
        if (this.f8358d != null) {
            b b2 = b.b();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            b2.a(sb2, this.f8358d);
            Intent intent = new Intent(activity, (Class<?>) WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(a2, str, sb2);
            Bundle bundle = new Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
