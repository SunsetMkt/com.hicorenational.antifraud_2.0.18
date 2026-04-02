package l.a.a.a.j;

import l.a.a.a.j.f.a;

/* JADX INFO: compiled from: LogFile.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static a a;

    /* JADX INFO: compiled from: LogFile.java */
    public interface a {
        void a(String str);
    }

    public static void a(a aVar) {
        a = aVar;
    }

    private static boolean a(int i2) {
        return true;
    }

    public static void b(String str, String str2) {
        if (a(4)) {
            a.b bVarA = l.a.a.a.j.f.a.a(4, str);
            bVarA.a(str2);
            a(bVarA.a());
        }
    }

    private static void b(l.a.a.a.j.f.a aVar) {
    }

    public static void a(String str, String str2) {
        if (a(6)) {
            a.b bVarA = l.a.a.a.j.f.a.a(6, str);
            bVarA.a(str2);
            a(bVarA.a());
        }
    }

    private static void a(l.a.a.a.j.f.a aVar) {
        b(aVar);
        a aVar2 = a;
        if (aVar2 != null) {
            aVar2.a(aVar.toString());
        }
    }
}
