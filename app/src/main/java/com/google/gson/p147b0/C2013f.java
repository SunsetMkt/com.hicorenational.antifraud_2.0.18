package com.google.gson.p147b0;

/* compiled from: JavaVersion.java */
/* renamed from: com.google.gson.b0.f */
/* loaded from: classes.dex */
public final class C2013f {

    /* renamed from: a */
    private static final int f5686a = m5356a();

    private C2013f() {
    }

    /* renamed from: a */
    private static int m5356a() {
        return m5359b(System.getProperty("java.version"));
    }

    /* renamed from: b */
    static int m5359b(String str) {
        int m5360c = m5360c(str);
        if (m5360c == -1) {
            m5360c = m5357a(str);
        }
        if (m5360c == -1) {
            return 6;
        }
        return m5360c;
    }

    /* renamed from: c */
    private static int m5360c(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static int m5357a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static int m5358b() {
        return f5686a;
    }

    /* renamed from: c */
    public static boolean m5361c() {
        return f5686a >= 9;
    }
}
