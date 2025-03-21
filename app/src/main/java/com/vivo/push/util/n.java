package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    private static Method f12286f;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f12281a = ag.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f12282b = b("rom_1.0");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f12283c = b("rom_2.0");

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f12284d = b("rom_2.5");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f12285e = b("rom_3.0");

    /* renamed from: g, reason: collision with root package name */
    private static String f12287g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f12288h = null;

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
        String b2 = ag.b("ro.vivo.rom", "");
        String b3 = ag.b("ro.vivo.rom.version", "");
        u.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (n.class) {
            if (f12287g == null && f12288h == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f12286f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f12287g = (String) f12286f.invoke(null, "ro.vivo.rom", "@><@");
                    f12288h = (String) f12286f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    u.b("Device", "getRomCode error");
                }
            }
            u.d("Device", "sRomProperty1 : " + f12287g + " ; sRomProperty2 : " + f12288h);
            String a2 = a(f12287g);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(f12288h);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            return a3;
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
