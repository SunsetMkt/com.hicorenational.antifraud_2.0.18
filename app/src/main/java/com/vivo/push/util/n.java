package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Device.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f8683f;
    public static final boolean a = ag.b("ro.vivo.product.overseas", "no").equals("yes");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f8679b = b("rom_1.0");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f8680c = b("rom_2.0");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8681d = b("rom_2.5");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f8682e = b("rom_3.0");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f8684g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f8685h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String strB = ag.b("ro.vivo.rom", "");
        String strB2 = ag.b("ro.vivo.rom.version", "");
        u.d("Device", "ro.vivo.rom = " + strB + " ; ro.vivo.rom.version = " + strB2);
        if (strB == null || !strB.contains(str)) {
            return strB2 != null && strB2.contains(str);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0085 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087 A[Catch: all -> 0x0097, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x000e, B:11:0x0053, B:12:0x005a, B:16:0x0087), top: B:25:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a() {
        String strA;
        if (f8684g == null && f8685h == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                f8683f = declaredMethod;
                declaredMethod.setAccessible(true);
                f8684g = (String) f8683f.invoke(null, "ro.vivo.rom", "@><@");
                f8685h = (String) f8683f.invoke(null, "ro.vivo.rom.version", "@><@");
            } catch (Exception unused) {
                u.b("Device", "getRomCode error");
            }
            u.d("Device", "sRomProperty1 : " + f8684g + " ; sRomProperty2 : " + f8685h);
            strA = a(f8684g);
            if (TextUtils.isEmpty(strA)) {
            }
        } else {
            u.d("Device", "sRomProperty1 : " + f8684g + " ; sRomProperty2 : " + f8685h);
            strA = a(f8684g);
            if (TextUtils.isEmpty(strA)) {
                return strA;
            }
            String strA2 = a(f8685h);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            return strA2;
        }
    }

    public static boolean b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            u.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        u.d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}
