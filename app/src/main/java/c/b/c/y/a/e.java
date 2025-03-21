package c.b.c.y.a;

import java.util.ArrayList;

/* compiled from: BizcardResultParser.java */
/* loaded from: classes.dex */
public final class e extends a {
    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String b2 = u.b(rVar);
        if (!b2.startsWith("BIZCARD:")) {
            return null;
        }
        String a2 = a(a.b("N:", b2, true), a.b("X:", b2, true));
        String b3 = a.b("T:", b2, true);
        String b4 = a.b("C:", b2, true);
        return new d(u.a(a2), null, null, a(a.b("B:", b2, true), a.b("M:", b2, true), a.b("F:", b2, true)), null, u.a(a.b("E:", b2, true)), null, null, null, a.a("A:", b2, true), null, b4, null, b3, null, null);
    }

    private static String[] a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    private static String a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
}
