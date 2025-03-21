package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.j */
/* loaded from: classes2.dex */
public class C4300j {

    /* renamed from: a */
    private static volatile int f16367a = 0;

    /* renamed from: a */
    private static Map<String, EnumC4304n> f16368a = null;

    /* renamed from: b */
    private static int f16369b = -1;

    /* renamed from: a */
    public static boolean m15680a() {
        return m15672a() == 1;
    }

    /* renamed from: b */
    public static boolean m15687b() {
        return m15672a() == 2;
    }

    /* renamed from: c */
    public static boolean m15689c() {
        if (f16369b < 0) {
            f16369b = !m15693e() ? 1 : 0;
        }
        return f16369b > 0;
    }

    /* renamed from: d */
    public static boolean m15691d() {
        return !EnumC4304n.China.name().equalsIgnoreCase(m15674a(m15685b()).name());
    }

    /* renamed from: e */
    public static boolean m15693e() {
        String str = "";
        try {
            str = C4308q.m15713a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m15672a() {
        /*
            int r0 = com.xiaomi.push.C4300j.f16367a
            if (r0 != 0) goto L47
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = m15678a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = m15678a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 2
        L26:
            com.xiaomi.push.C4300j.f16367a = r2     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13349a(r2, r1)
            com.xiaomi.push.C4300j.f16367a = r0
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = com.xiaomi.push.C4300j.f16367a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13356b(r0)
        L47:
            int r0 = com.xiaomi.push.C4300j.f16367a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4300j.m15672a():int");
    }

    /* renamed from: b */
    public static String m15685b() {
        String m15713a = C4308q.m15713a("ro.miui.region", "");
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = m15686b(C4308q.m15713a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(m15713a)) {
            m15713a = C4308q.m15713a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(m15713a)) {
            AbstractC4022b.m13347a("get region from system, region = " + m15713a);
        }
        if (!TextUtils.isEmpty(m15713a)) {
            return m15713a;
        }
        String country = Locale.getDefault().getCountry();
        AbstractC4022b.m13347a("locale.default.country = " + country);
        return country;
    }

    /* renamed from: d */
    public static String m15690d() {
        return m15678a("ro.build.characteristics");
    }

    /* renamed from: e */
    public static String m15692e() {
        return m15678a("ro.product.manufacturer");
    }

    /* renamed from: c */
    public static String m15688c() {
        return m15678a("ro.miui.ui.version.name");
    }

    /* renamed from: a */
    public static String m15675a() {
        int m15714a = C4309r.m15714a();
        return (!m15680a() || m15714a <= 0) ? "" : m15714a < 2 ? "alpha" : m15714a < 3 ? "development" : "stable";
    }

    /* renamed from: a */
    public static String m15678a(String str) {
        try {
            try {
                return (String) C4094aw.m13824a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                AbstractC4022b.m13361d("fail to get property. " + e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m15681a(Context context) {
        return context != null && m15682a(context.getPackageName());
    }

    /* renamed from: a */
    public static boolean m15682a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    /* renamed from: a */
    public static EnumC4304n m15674a(String str) {
        EnumC4304n m15684b = m15684b(str);
        return m15684b == null ? EnumC4304n.Global : m15684b;
    }

    /* renamed from: a */
    private static void m15679a() {
        if (f16368a != null) {
            return;
        }
        f16368a = new HashMap();
        f16368a.put("CN", EnumC4304n.China);
        f16368a.put("FI", EnumC4304n.Europe);
        f16368a.put("SE", EnumC4304n.Europe);
        f16368a.put("NO", EnumC4304n.Europe);
        f16368a.put("FO", EnumC4304n.Europe);
        f16368a.put("EE", EnumC4304n.Europe);
        f16368a.put("LV", EnumC4304n.Europe);
        f16368a.put("LT", EnumC4304n.Europe);
        f16368a.put("BY", EnumC4304n.Europe);
        f16368a.put("MD", EnumC4304n.Europe);
        f16368a.put("UA", EnumC4304n.Europe);
        f16368a.put("PL", EnumC4304n.Europe);
        f16368a.put("CZ", EnumC4304n.Europe);
        f16368a.put("SK", EnumC4304n.Europe);
        f16368a.put("HU", EnumC4304n.Europe);
        f16368a.put("DE", EnumC4304n.Europe);
        f16368a.put("AT", EnumC4304n.Europe);
        f16368a.put("CH", EnumC4304n.Europe);
        f16368a.put("LI", EnumC4304n.Europe);
        f16368a.put("GB", EnumC4304n.Europe);
        f16368a.put("IE", EnumC4304n.Europe);
        f16368a.put("NL", EnumC4304n.Europe);
        f16368a.put("BE", EnumC4304n.Europe);
        f16368a.put("LU", EnumC4304n.Europe);
        f16368a.put("FR", EnumC4304n.Europe);
        f16368a.put("RO", EnumC4304n.Europe);
        f16368a.put("BG", EnumC4304n.Europe);
        f16368a.put("RS", EnumC4304n.Europe);
        f16368a.put("MK", EnumC4304n.Europe);
        f16368a.put("AL", EnumC4304n.Europe);
        f16368a.put("GR", EnumC4304n.Europe);
        f16368a.put("SI", EnumC4304n.Europe);
        f16368a.put("HR", EnumC4304n.Europe);
        f16368a.put("IT", EnumC4304n.Europe);
        f16368a.put("SM", EnumC4304n.Europe);
        f16368a.put("MT", EnumC4304n.Europe);
        f16368a.put("ES", EnumC4304n.Europe);
        f16368a.put("PT", EnumC4304n.Europe);
        f16368a.put("AD", EnumC4304n.Europe);
        f16368a.put("CY", EnumC4304n.Europe);
        f16368a.put("DK", EnumC4304n.Europe);
        f16368a.put("IS", EnumC4304n.Europe);
        f16368a.put("UK", EnumC4304n.Europe);
        f16368a.put("EL", EnumC4304n.Europe);
        f16368a.put("RU", EnumC4304n.Russia);
        f16368a.put("IN", EnumC4304n.India);
    }

    /* renamed from: b */
    private static EnumC4304n m15684b(String str) {
        m15679a();
        return f16368a.get(str.toUpperCase());
    }

    /* renamed from: b */
    public static int m15683b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    private static String m15686b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    /* renamed from: a */
    public static int m15673a(Context context) {
        String m15678a = m15678a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(m15678a) || !TextUtils.isDigitsOnly(m15678a)) {
            return 0;
        }
        return Integer.parseInt(m15678a);
    }

    /* renamed from: a */
    public static String m15676a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + AbstractC1191a.f2568g + m15677a(intent.getExtras());
    }

    /* renamed from: a */
    public static String m15677a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(AbstractC1191a.f2571h);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(m15677a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
