package com.heytap.mcssdk.p160k;

/* renamed from: com.heytap.mcssdk.k.d */
/* loaded from: classes.dex */
public class C2104d {

    /* renamed from: a */
    private static final String f6244a = "file";

    /* renamed from: b */
    private static final String f6245b = "ro.crypto.type";

    /* renamed from: a */
    private static String m5868a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m5869a() {
        return f6244a.equals(m5868a(f6245b));
    }
}
