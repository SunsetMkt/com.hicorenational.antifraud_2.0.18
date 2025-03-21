package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sina.weibo.sdk.net.InterfaceC2932c;
import com.sina.weibo.sdk.p193a.C2908b;
import com.sina.weibo.sdk.p193a.C2911e;

/* loaded from: classes.dex */
public class AccessTokenHelper {
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    public static void clearAccessToken(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        edit.clear();
        edit.apply();
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
        oauth2AccessToken.setScreenName(sharedPreferences.getString("userName", ""));
        oauth2AccessToken.setAccessToken(sharedPreferences.getString("access_token", ""));
        oauth2AccessToken.setRefreshToken(sharedPreferences.getString("refresh_token", ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong("expires_in", 0L));
        return oauth2AccessToken;
    }

    public static void refreshAccessToken(final Context context, String str) {
        C2908b c2908b;
        Oauth2AccessToken readAccessToken = readAccessToken(context);
        if (readAccessToken != null) {
            C2911e c2911e = new C2911e(str, readAccessToken, new InterfaceC2932c<String>() { // from class: com.sina.weibo.sdk.auth.AccessTokenHelper.1
                @Override // com.sina.weibo.sdk.net.InterfaceC2932c
                /* renamed from: a */
                public final /* synthetic */ void mo8814a(String str2) {
                    AccessTokenHelper.writeAccessToken(context, Oauth2AccessToken.parseAccessToken(str2));
                }

                @Override // com.sina.weibo.sdk.net.InterfaceC2932c
                public final void onError(Throwable th) {
                }
            });
            c2908b = C2908b.a.f9268K;
            c2908b.m8806a(c2911e);
        }
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context == null || oauth2AccessToken == null || TextUtils.isEmpty(oauth2AccessToken.getAccessToken())) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        edit.putString("uid", oauth2AccessToken.getUid());
        edit.putString("userName", oauth2AccessToken.getScreenName());
        edit.putString("access_token", oauth2AccessToken.getAccessToken());
        edit.putString("refresh_token", oauth2AccessToken.getRefreshToken());
        edit.putLong("expires_in", oauth2AccessToken.getExpiresTime());
        edit.apply();
    }
}
