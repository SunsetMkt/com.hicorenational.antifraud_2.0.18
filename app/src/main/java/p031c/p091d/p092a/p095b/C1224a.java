package p031c.p091d.p092a.p095b;

import java.io.File;
import p031c.p091d.p092a.p093a.C1218b;
import p031c.p091d.p092a.p093a.C1220d;
import p031c.p091d.p092a.p093a.C1221e;

/* compiled from: ChannelReader.java */
/* renamed from: c.d.a.b.a */
/* loaded from: classes.dex */
public class C1224a {
    /* renamed from: a */
    public static boolean m2422a(File file, String str) {
        if (str != null) {
            return str.equals(m2425c(file));
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m2424b(File file, String str) {
        if (str != null) {
            return str.equals(m2426d(file));
        }
        return false;
    }

    /* renamed from: c */
    public static String m2425c(File file) {
        try {
            return C1220d.m2379d(file);
        } catch (Exception unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have channel info from Zip Comment");
            return null;
        }
    }

    /* renamed from: d */
    public static String m2426d(File file) {
        System.out.println("try to read channel info from apk : " + file.getAbsolutePath());
        return C1225b.m2430c(file, C1218b.f2669a);
    }

    /* renamed from: a */
    public static boolean m2421a(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return C1220d.m2377b(file);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m2423b(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return C1221e.m2385a(file);
        }
        return false;
    }
}
