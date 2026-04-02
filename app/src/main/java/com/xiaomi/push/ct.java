package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ct {
    private static cl a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cm f285a;

    public static void a(Context context, fa faVar) {
        if (m251b(context)) {
            if (a == null) {
                a = new cl(context);
            }
            if (f285a == null) {
                f285a = new cm(context);
            }
            cl clVar = a;
            faVar.a(clVar, clVar);
            cm cmVar = f285a;
            faVar.b(cmVar, cmVar);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cl clVar = a;
        if (clVar != null) {
            faVar.a(clVar);
            a = null;
        }
        cm cmVar = f285a;
        if (cmVar != null) {
            faVar.b(cmVar);
            f285a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (m251b(context)) {
            cw.c(context, System.currentTimeMillis(), m250a(context));
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (m251b(context)) {
            cw.d(context, System.currentTimeMillis(), m250a(context));
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m251b(Context context) {
        return ck.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (m251b(context)) {
            cw.a(context, System.currentTimeMillis(), m250a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (m251b(context)) {
            cw.b(context, System.currentTimeMillis(), m250a(context));
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m250a(Context context) {
        return i.m618b(context);
    }

    static void a(String str) {
        ck.a("Push-PowerStats", str);
    }
}
