package l.a.a.a.j;

import android.content.Context;

/* JADX INFO: compiled from: LogX.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static b a;

    public static synchronized void a(Context context) {
        a = d.b(context);
    }

    public static void b(String str, String str2, boolean z) {
        b bVar = a;
        if (bVar == null || !z) {
            return;
        }
        bVar.c(str, str2);
    }

    public static void c(String str, String str2, boolean z) {
        b bVar = a;
        if (bVar == null || !z) {
            return;
        }
        bVar.a(str, str2);
    }

    public static void d(String str, String str2, boolean z) {
        b bVar = a;
        if (bVar == null || !z) {
            return;
        }
        bVar.c(str, str2);
    }

    public static void a(String str, String str2, boolean z) {
        b bVar = a;
        if (bVar == null || !z) {
            return;
        }
        bVar.b(str, str2);
    }
}
