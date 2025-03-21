package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4309r;
import com.xiaomi.push.C4310s;
import com.xiaomi.push.service.C4361am;
import java.util.Locale;

/* renamed from: com.xiaomi.push.service.p */
/* loaded from: classes2.dex */
public class C4393p {

    /* renamed from: a */
    public final int f16753a;

    /* renamed from: a */
    public final String f16754a;

    /* renamed from: b */
    public final String f16755b;

    /* renamed from: c */
    public final String f16756c;

    /* renamed from: d */
    public final String f16757d;

    /* renamed from: e */
    public final String f16758e;

    /* renamed from: f */
    public final String f16759f;

    public C4393p(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.f16754a = str;
        this.f16755b = str2;
        this.f16756c = str3;
        this.f16757d = str4;
        this.f16758e = str5;
        this.f16759f = str6;
        this.f16753a = i2;
    }

    /* renamed from: b */
    private static boolean m16200b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    public C4361am.b m16201a(XMPushService xMPushService) {
        C4361am.b bVar = new C4361am.b(xMPushService);
        m16202a(bVar, xMPushService, xMPushService.m15808b(), C3351bh.f11584aI);
        return bVar;
    }

    /* renamed from: a */
    public C4361am.b m16202a(C4361am.b bVar, Context context, C4385h c4385h, String str) {
        bVar.f16553a = context.getPackageName();
        bVar.f16557b = this.f16754a;
        bVar.f16564h = this.f16756c;
        bVar.f16559c = this.f16755b;
        bVar.f16563g = "5";
        bVar.f16560d = "XMPUSH-PASS";
        bVar.f16555a = false;
        C4310s.a aVar = new C4310s.a();
        aVar.m15730a("sdk_ver", 48).m15730a("cpvn", BuildConfig.VERSION_NAME).m15730a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).m15730a("country_code", C4375b.m16045a(context).m16050b()).m15730a("region", C4375b.m16045a(context).m16048a()).m15730a("miui_vn", C4300j.m15688c()).m15730a("miui_vc", Integer.valueOf(C4300j.m15673a(context))).m15730a("xmsf_vc", Integer.valueOf(C4233g.m14925a(context, "com.xiaomi.xmsf"))).m15730a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).m15730a("n_belong_to_app", Boolean.valueOf(C4354af.m15882a(context))).m15730a("systemui_vc", Integer.valueOf(C4233g.m14924a(context)));
        String m16197a = m16197a(context);
        if (!TextUtils.isEmpty(m16197a)) {
            aVar.m15730a("latest_country_code", m16197a);
        }
        String m15690d = C4300j.m15690d();
        if (!TextUtils.isEmpty(m15690d)) {
            aVar.m15730a("device_ch", m15690d);
        }
        String m15692e = C4300j.m15692e();
        if (!TextUtils.isEmpty(m15692e)) {
            aVar.m15730a("device_mfr", m15692e);
        }
        bVar.f16561e = aVar.toString();
        String str2 = m16200b(context) ? "1000271" : this.f16757d;
        C4310s.a aVar2 = new C4310s.a();
        aVar2.m15730a("appid", str2).m15730a("locale", Locale.getDefault().toString()).m15730a("sync", 1);
        if (m16199a(context)) {
            aVar2.m15730a("ab", str);
        }
        bVar.f16562f = aVar2.toString();
        bVar.f16552a = c4385h;
        return bVar;
    }

    /* renamed from: a */
    public static boolean m16199a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && m16198a();
    }

    /* renamed from: a */
    public static boolean m16198a() {
        try {
            return C4309r.m15716a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static String m16197a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String m15678a = C4300j.m15678a("ro.miui.region");
            return TextUtils.isEmpty(m15678a) ? C4300j.m15678a("ro.product.locale.region") : m15678a;
        }
        return C4300j.m15685b();
    }
}
