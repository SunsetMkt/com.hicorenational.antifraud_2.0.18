package p031c.p035b.p043c.p070y.p071a;

import p031c.p035b.p043c.C1107r;

/* compiled from: AddressBookDoCoMoResultParser.java */
/* renamed from: c.b.c.y.a.c */
/* loaded from: classes.dex */
public final class C1129c extends AbstractC1125a {
    /* renamed from: e */
    private static String m2009e(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1131d mo2004a(C1107r c1107r) {
        String[] m2002a;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("MECARD:") || (m2002a = AbstractC1125a.m2002a("N:", m2128b, true)) == null) {
            return null;
        }
        String m2009e = m2009e(m2002a[0]);
        String m2003b = AbstractC1125a.m2003b("SOUND:", m2128b, true);
        String[] m2002a2 = AbstractC1125a.m2002a("TEL:", m2128b, true);
        String[] m2002a3 = AbstractC1125a.m2002a("EMAIL:", m2128b, true);
        String m2003b2 = AbstractC1125a.m2003b("NOTE:", m2128b, false);
        String[] m2002a4 = AbstractC1125a.m2002a("ADR:", m2128b, true);
        String m2003b3 = AbstractC1125a.m2003b("BDAY:", m2128b, true);
        return new C1131d(AbstractC1156u.m2126a(m2009e), null, m2003b, m2002a2, null, m2002a3, null, null, m2003b2, m2002a4, null, AbstractC1125a.m2003b("ORG:", m2128b, true), !AbstractC1156u.m2131b(m2003b3, 8) ? null : m2003b3, null, AbstractC1125a.m2002a("URL:", m2128b, true), null);
    }
}
