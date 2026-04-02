package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static volatile int a = 0;

    /* JADX INFO: renamed from: a */
    private static Map<String, n> f908a = null;

    /* JADX INFO: renamed from: b */
    private static int f9328b = -1;

    /* JADX INFO: renamed from: a */
    public static boolean m624a() {
        return a() == 1;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m628b() {
        return a() == 2;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m629c() {
        if (f9328b < 0) {
            f9328b = !m631e() ? 1 : 0;
        }
        return f9328b > 0;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m630d() {
        return !n.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* JADX INFO: renamed from: e */
    public static boolean m631e() {
        String strA = "";
        try {
            strA = q.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(strA);
    }

    public static int a() {
        if (a == 0) {
            try {
                int i2 = 1;
                if (!((TextUtils.isEmpty(m622a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m622a("ro.miui.ui.version.name"))) ? false : true)) {
                    i2 = 2;
                }
                a = i2;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                a = 0;
            }
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    public static String b() {
        String strA = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m627b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m48a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m622a("ro.build.characteristics");
    }

    public static String e() {
        return m622a("ro.product.manufacturer");
    }

    public static String c() {
        return m622a("ro.miui.ui.version.name");
    }

    /* JADX INFO: renamed from: a */
    public static String m621a() {
        int iA = r.a();
        return (!m624a() || iA <= 0) ? "" : iA < 2 ? "alpha" : iA < 3 ? "development" : "stable";
    }

    /* JADX INFO: renamed from: a */
    public static String m622a(String str) {
        try {
            try {
                return (String) aw.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m625a(Context context) {
        return context != null && m626a(context.getPackageName());
    }

    /* JADX INFO: renamed from: a */
    public static boolean m626a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static n a(String str) {
        n nVarB = b(str);
        return nVarB == null ? n.Global : nVarB;
    }

    /* JADX INFO: renamed from: a */
    private static void m623a() {
        if (f908a != null) {
            return;
        }
        f908a = new HashMap();
        f908a.put("CN", n.China);
        f908a.put("FI", n.Europe);
        f908a.put("SE", n.Europe);
        f908a.put("NO", n.Europe);
        f908a.put("FO", n.Europe);
        f908a.put("EE", n.Europe);
        f908a.put("LV", n.Europe);
        f908a.put("LT", n.Europe);
        f908a.put("BY", n.Europe);
        f908a.put("MD", n.Europe);
        f908a.put("UA", n.Europe);
        f908a.put("PL", n.Europe);
        f908a.put("CZ", n.Europe);
        f908a.put("SK", n.Europe);
        f908a.put("HU", n.Europe);
        f908a.put("DE", n.Europe);
        f908a.put("AT", n.Europe);
        f908a.put("CH", n.Europe);
        f908a.put("LI", n.Europe);
        f908a.put("GB", n.Europe);
        f908a.put("IE", n.Europe);
        f908a.put("NL", n.Europe);
        f908a.put("BE", n.Europe);
        f908a.put("LU", n.Europe);
        f908a.put("FR", n.Europe);
        f908a.put("RO", n.Europe);
        f908a.put("BG", n.Europe);
        f908a.put("RS", n.Europe);
        f908a.put("MK", n.Europe);
        f908a.put("AL", n.Europe);
        f908a.put("GR", n.Europe);
        f908a.put("SI", n.Europe);
        f908a.put("HR", n.Europe);
        f908a.put("IT", n.Europe);
        f908a.put("SM", n.Europe);
        f908a.put("MT", n.Europe);
        f908a.put("ES", n.Europe);
        f908a.put("PT", n.Europe);
        f908a.put("AD", n.Europe);
        f908a.put("CY", n.Europe);
        f908a.put("DK", n.Europe);
        f908a.put("IS", n.Europe);
        f908a.put("UK", n.Europe);
        f908a.put("EL", n.Europe);
        f908a.put("RU", n.Russia);
        f908a.put("IN", n.India);
    }

    private static n b(String str) {
        m623a();
        return f908a.get(str.toUpperCase());
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m627b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM622a = m622a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(strM622a) || !TextUtils.isDigitsOnly(strM622a)) {
            return 0;
        }
        return Integer.parseInt(strM622a);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + d.c.a.b.a.a.f10074g + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(d.c.a.b.a.a.f10075h);
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
                    sb.append(a((Bundle) obj));
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
