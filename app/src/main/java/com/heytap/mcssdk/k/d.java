package com.heytap.mcssdk.k;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "file";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3947b = "ro.crypto.type";

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return a.equals(a(f3947b));
    }
}
