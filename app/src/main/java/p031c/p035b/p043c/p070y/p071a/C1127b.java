package p031c.p035b.p043c.p070y.p071a;

import java.util.ArrayList;
import p031c.p035b.p043c.C1107r;

/* compiled from: AddressBookAUResultParser.java */
/* renamed from: c.b.c.y.a.b */
/* loaded from: classes.dex */
public final class C1127b extends AbstractC1156u {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1131d mo2004a(C1107r c1107r) {
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.contains("MEMORY") || !m2128b.contains("\r\n")) {
            return null;
        }
        String m2129b = AbstractC1156u.m2129b("NAME1:", m2128b, '\r', true);
        String m2129b2 = AbstractC1156u.m2129b("NAME2:", m2128b, '\r', true);
        String[] m2005a = m2005a("TEL", 3, m2128b, true);
        String[] m2005a2 = m2005a("MAIL", 3, m2128b, true);
        String m2129b3 = AbstractC1156u.m2129b("MEMORY:", m2128b, '\r', false);
        String m2129b4 = AbstractC1156u.m2129b("ADD:", m2128b, '\r', true);
        return new C1131d(AbstractC1156u.m2126a(m2129b), null, m2129b2, m2005a, null, m2005a2, null, null, m2129b3, m2129b4 != null ? new String[]{m2129b4} : null, null, null, null, null, null, null);
    }

    /* renamed from: a */
    private static String[] m2005a(String str, int i2, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i3 = 1; i3 <= i2; i3++) {
            String m2129b = AbstractC1156u.m2129b(str + i3 + ':', str2, '\r', z);
            if (m2129b == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i2);
            }
            arrayList.add(m2129b);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
