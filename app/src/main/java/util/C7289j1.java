package util;

import p388ui.Hicore;

/* compiled from: InstallUtil.java */
/* renamed from: util.j1 */
/* loaded from: classes2.dex */
public class C7289j1 {
    /* renamed from: a */
    public static long m26385a() {
        try {
            return Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0).firstInstallTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: b */
    public static long m26386b() {
        try {
            return Hicore.getApp().getPackageManager().getPackageInfo(Hicore.getApp().getPackageName(), 0).lastUpdateTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: c */
    public static long m26387c() {
        try {
            return C7325u1.m26614a(C7325u1.f25694r, 0L);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: d */
    public static boolean m26388d() {
        return m26385a() == m26386b();
    }

    /* renamed from: e */
    public static boolean m26389e() {
        return m26387c() != m26386b();
    }
}
