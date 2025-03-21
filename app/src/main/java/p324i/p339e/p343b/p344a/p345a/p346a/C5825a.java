package p324i.p339e.p343b.p344a.p345a.p346a;

import android.content.Context;
import p324i.p339e.p340a.p341a.p342a.InterfaceC5824a;

/* compiled from: OpenIDSDK.java */
/* renamed from: i.e.b.a.a.a.a */
/* loaded from: classes2.dex */
public class C5825a {
    /* renamed from: a */
    public static void m24445a(Context context) {
        InterfaceC5824a.b.f20951b = InterfaceC5824a.c.b.f20958a.m24443a(context.getApplicationContext());
        InterfaceC5824a.b.f20950a = true;
    }

    /* renamed from: b */
    public static String m24447b(Context context) {
        if (InterfaceC5824a.b.f20950a) {
            return InterfaceC5824a.c.b.f20958a.m24442a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: c */
    public static String m24448c(Context context) {
        if (InterfaceC5824a.b.f20950a) {
            return InterfaceC5824a.c.b.f20958a.m24442a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: d */
    public static String m24449d(Context context) {
        if (InterfaceC5824a.b.f20950a) {
            return InterfaceC5824a.c.b.f20958a.m24442a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: e */
    public static String m24450e(Context context) {
        if (InterfaceC5824a.b.f20950a) {
            return InterfaceC5824a.c.b.f20958a.m24442a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: a */
    public static boolean m24446a() {
        if (InterfaceC5824a.b.f20950a) {
            return InterfaceC5824a.b.f20951b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
