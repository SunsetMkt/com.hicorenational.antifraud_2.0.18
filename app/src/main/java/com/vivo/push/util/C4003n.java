package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* renamed from: com.vivo.push.util.n */
/* loaded from: classes2.dex */
public final class C4003n {

    /* renamed from: f */
    private static Method f14265f;

    /* renamed from: a */
    public static final boolean f14260a = C3990ag.m13218b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b */
    public static final boolean f14261b = m13269b("rom_1.0");

    /* renamed from: c */
    public static final boolean f14262c = m13269b("rom_2.0");

    /* renamed from: d */
    public static final boolean f14263d = m13269b("rom_2.5");

    /* renamed from: e */
    public static final boolean f14264e = m13269b("rom_3.0");

    /* renamed from: g */
    private static String f14266g = null;

    /* renamed from: h */
    private static String f14267h = null;

    /* renamed from: a */
    public static String m13267a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* renamed from: b */
    private static boolean m13269b(String str) {
        String m13218b = C3990ag.m13218b("ro.vivo.rom", "");
        String m13218b2 = C3990ag.m13218b("ro.vivo.rom.version", "");
        C4010u.m13309d("Device", "ro.vivo.rom = " + m13218b + " ; ro.vivo.rom.version = " + m13218b2);
        if (m13218b == null || !m13218b.contains(str)) {
            return m13218b2 != null && m13218b2.contains(str);
        }
        return true;
    }

    /* renamed from: a */
    public static synchronized String m13265a() {
        synchronized (C4003n.class) {
            if (f14266g == null && f14267h == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f14265f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f14266g = (String) f14265f.invoke(null, "ro.vivo.rom", "@><@");
                    f14267h = (String) f14265f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    C4010u.m13301b("Device", "getRomCode error");
                }
            }
            C4010u.m13309d("Device", "sRomProperty1 : " + f14266g + " ; sRomProperty2 : " + f14267h);
            String m13266a = m13266a(f14266g);
            if (!TextUtils.isEmpty(m13266a)) {
                return m13266a;
            }
            String m13266a2 = m13266a(f14267h);
            if (TextUtils.isEmpty(m13266a2)) {
                return null;
            }
            return m13266a2;
        }
    }

    /* renamed from: b */
    public static boolean m13268b() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            C4010u.m13309d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        C4010u.m13309d("Device", "Build.MANUFACTURER is " + Build.MANUFACTURER);
        return Build.MANUFACTURER.toLowerCase().contains("bbk") || Build.MANUFACTURER.toLowerCase().startsWith("vivo");
    }

    /* renamed from: a */
    private static String m13266a(String str) {
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
