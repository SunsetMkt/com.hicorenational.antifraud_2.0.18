package p358k.p359a.p360a.p361a.p363j;

import p358k.p359a.p360a.p361a.p363j.p364f.C5864a;

/* compiled from: LogFile.java */
/* renamed from: k.a.a.a.j.c */
/* loaded from: classes2.dex */
public class C5861c {

    /* renamed from: a */
    private static a f21145a;

    /* compiled from: LogFile.java */
    /* renamed from: k.a.a.a.j.c$a */
    public interface a {
        /* renamed from: a */
        void mo24664a(String str);
    }

    /* renamed from: a */
    public static void m24679a(a aVar) {
        f21145a = aVar;
    }

    /* renamed from: a */
    private static boolean m24681a(int i2) {
        return true;
    }

    /* renamed from: b */
    public static void m24682b(String str, String str2) {
        if (m24681a(4)) {
            C5864a.b m24696a = C5864a.m24696a(4, str);
            m24696a.m24709a(str2);
            m24680a(m24696a.m24710a());
        }
    }

    /* renamed from: b */
    private static void m24683b(C5864a c5864a) {
    }

    /* renamed from: a */
    public static void m24678a(String str, String str2) {
        if (m24681a(6)) {
            C5864a.b m24696a = C5864a.m24696a(6, str);
            m24696a.m24709a(str2);
            m24680a(m24696a.m24710a());
        }
    }

    /* renamed from: a */
    private static void m24680a(C5864a c5864a) {
        m24683b(c5864a);
        a aVar = f21145a;
        if (aVar != null) {
            aVar.mo24664a(c5864a.toString());
        }
    }
}
