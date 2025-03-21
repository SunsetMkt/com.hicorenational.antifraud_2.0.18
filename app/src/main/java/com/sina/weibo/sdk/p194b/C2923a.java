package com.sina.weibo.sdk.p194b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.sina.weibo.sdk.b.a */
/* loaded from: classes.dex */
public final class C2923a {

    /* renamed from: com.sina.weibo.sdk.b.a$a */
    public static class a {

        /* renamed from: ah */
        public int f9302ah;
        public String packageName = BuildConfig.APPLICATION_ID;

        /* renamed from: ag */
        public String f9301ag = "com.sina.weibo.SSOActivity";
    }

    /* renamed from: a */
    public static boolean m8823a(Context context, Intent intent) {
        PackageManager packageManager;
        ResolveInfo resolveActivity;
        if (context == null || (packageManager = context.getPackageManager()) == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature signature : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(C2926d.m8839a(signature.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static a m8824c(Context context) {
        return m8826e(context);
    }

    /* renamed from: d */
    public static boolean m8825d(Context context) {
        a m8826e = m8826e(context);
        return m8826e != null && m8826e.f9302ah >= 10791;
    }

    /* renamed from: e */
    public static a m8826e(Context context) {
        List<ResolveInfo> queryIntentServices;
        a m8822a;
        String[] strArr = {BuildConfig.APPLICATION_ID, "com.sina.weibog3"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    if (serviceInfo != null && serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.packageName)) {
                        String str2 = resolveInfo.serviceInfo.packageName;
                        if (TextUtils.equals(str, str2) && (m8822a = m8822a(context, str2)) != null) {
                            return m8822a;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static a m8822a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream open = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr, 0, 4096);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    a aVar = new a();
                    aVar.f9302ah = jSONObject.optInt("support_api", -1);
                    aVar.f9301ag = jSONObject.optString("authActivityName", null);
                    aVar.packageName = str;
                    return aVar;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
