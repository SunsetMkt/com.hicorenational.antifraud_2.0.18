package c.b.c.y.a;

/* compiled from: AddressBookDoCoMoResultParser.java */
/* loaded from: classes.dex */
public final class c extends a {
    private static String e(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
    }

    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String[] a2;
        String b2 = u.b(rVar);
        if (!b2.startsWith("MECARD:") || (a2 = a.a("N:", b2, true)) == null) {
            return null;
        }
        String e2 = e(a2[0]);
        String b3 = a.b("SOUND:", b2, true);
        String[] a3 = a.a("TEL:", b2, true);
        String[] a4 = a.a("EMAIL:", b2, true);
        String b4 = a.b("NOTE:", b2, false);
        String[] a5 = a.a("ADR:", b2, true);
        String b5 = a.b("BDAY:", b2, true);
        return new d(u.a(e2), null, b3, a3, null, a4, null, null, b4, a5, null, a.b("ORG:", b2, true), !u.b(b5, 8) ? null : b5, null, a.a("URL:", b2, true), null);
    }
}
