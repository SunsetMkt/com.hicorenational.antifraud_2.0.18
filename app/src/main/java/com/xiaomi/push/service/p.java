package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.s;
import com.xiaomi.push.service.am;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public final int a;

    /* JADX INFO: renamed from: a */
    public final String f1067a;

    /* JADX INFO: renamed from: b */
    public final String f9411b;

    /* JADX INFO: renamed from: c */
    public final String f9412c;

    /* JADX INFO: renamed from: d */
    public final String f9413d;

    /* JADX INFO: renamed from: e */
    public final String f9414e;

    /* JADX INFO: renamed from: f */
    public final String f9415f;

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.f1067a = str;
        this.f9411b = str2;
        this.f9412c = str3;
        this.f9413d = str4;
        this.f9414e = str5;
        this.f9415f = str6;
        this.a = i2;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m663b(), bh.aI);
        return bVar;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        bVar.f998a = context.getPackageName();
        bVar.f1001b = this.f1067a;
        bVar.f9363h = this.f9412c;
        bVar.f9358c = this.f9411b;
        bVar.f9362g = "5";
        bVar.f9359d = "XMPUSH-PASS";
        bVar.f1000a = false;
        s.a aVar = new s.a();
        aVar.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a("country_code", b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m677a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String strA = a(context);
        if (!TextUtils.isEmpty(strA)) {
            aVar.a("latest_country_code", strA);
        }
        String strD = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(strD)) {
            aVar.a("device_ch", strD);
        }
        String strE = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(strE)) {
            aVar.a("device_mfr", strE);
        }
        bVar.f9360e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.f9413d;
        s.a aVar2 = new s.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m738a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f9361f = aVar2.toString();
        bVar.f997a = hVar;
        return bVar;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m738a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.r.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String strM622a = com.xiaomi.push.j.m622a("ro.miui.region");
            return TextUtils.isEmpty(strM622a) ? com.xiaomi.push.j.m622a("ro.product.locale.region") : strM622a;
        }
        return com.xiaomi.push.j.b();
    }
}
