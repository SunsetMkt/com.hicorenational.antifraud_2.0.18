package c.b.c.y.a;

import java.util.ArrayList;

/* compiled from: AddressBookAUResultParser.java */
/* loaded from: classes.dex */
public final class b extends u {
    @Override // c.b.c.y.a.u
    public d a(c.b.c.r rVar) {
        String b2 = u.b(rVar);
        if (!b2.contains("MEMORY") || !b2.contains("\r\n")) {
            return null;
        }
        String b3 = u.b("NAME1:", b2, '\r', true);
        String b4 = u.b("NAME2:", b2, '\r', true);
        String[] a2 = a("TEL", 3, b2, true);
        String[] a3 = a("MAIL", 3, b2, true);
        String b5 = u.b("MEMORY:", b2, '\r', false);
        String b6 = u.b("ADD:", b2, '\r', true);
        return new d(u.a(b3), null, b4, a2, null, a3, null, null, b5, b6 != null ? new String[]{b6} : null, null, null, null, null, null, null);
    }

    private static String[] a(String str, int i2, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i3 = 1; i3 <= i2; i3++) {
            String b2 = u.b(str + i3 + ':', str2, '\r', z);
            if (b2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i2);
            }
            arrayList.add(b2);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
