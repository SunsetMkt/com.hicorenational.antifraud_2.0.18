package com.xiaomi.push;

/* renamed from: com.xiaomi.push.x */
/* loaded from: classes2.dex */
public class C4409x {

    /* renamed from: a */
    private static int f16834a;

    /* renamed from: a */
    public static final String f16835a;

    /* renamed from: a */
    public static boolean f16836a;

    static {
        f16835a = C4072aa.f14476a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f16836a = false;
        f16834a = 1;
        if (f16835a.equalsIgnoreCase("SANDBOX")) {
            f16834a = 2;
        } else if (f16835a.equalsIgnoreCase("ONEBOX")) {
            f16834a = 3;
        } else {
            f16834a = 1;
        }
    }

    /* renamed from: a */
    public static boolean m16366a() {
        return f16834a == 2;
    }

    /* renamed from: b */
    public static boolean m16367b() {
        return f16834a == 3;
    }

    /* renamed from: a */
    public static int m16364a() {
        return f16834a;
    }

    /* renamed from: a */
    public static void m16365a(int i2) {
        f16834a = i2;
    }
}
