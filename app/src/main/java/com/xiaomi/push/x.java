package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1108a;

    static {
        f1107a = aa.a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1108a = false;
        a = 1;
        if (f1107a.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (f1107a.equalsIgnoreCase("ONEBOX")) {
            a = 3;
        } else {
            a = 1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m764a() {
        return a == 2;
    }

    public static boolean b() {
        return a == 3;
    }

    public static int a() {
        return a;
    }

    public static void a(int i2) {
        a = i2;
    }
}
