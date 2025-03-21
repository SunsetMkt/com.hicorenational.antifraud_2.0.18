package p031c.p035b.p043c.p070y.p071a;

import java.util.ArrayList;
import p031c.p035b.p043c.C1107r;

/* compiled from: BizcardResultParser.java */
/* renamed from: c.b.c.y.a.e */
/* loaded from: classes.dex */
public final class C1133e extends AbstractC1125a {
    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1131d mo2004a(C1107r c1107r) {
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("BIZCARD:")) {
            return null;
        }
        String m2032a = m2032a(AbstractC1125a.m2003b("N:", m2128b, true), AbstractC1125a.m2003b("X:", m2128b, true));
        String m2003b = AbstractC1125a.m2003b("T:", m2128b, true);
        String m2003b2 = AbstractC1125a.m2003b("C:", m2128b, true);
        return new C1131d(AbstractC1156u.m2126a(m2032a), null, null, m2033a(AbstractC1125a.m2003b("B:", m2128b, true), AbstractC1125a.m2003b("M:", m2128b, true), AbstractC1125a.m2003b("F:", m2128b, true)), null, AbstractC1156u.m2126a(AbstractC1125a.m2003b("E:", m2128b, true)), null, null, null, AbstractC1125a.m2002a("A:", m2128b, true), null, m2003b2, null, m2003b, null, null);
    }

    /* renamed from: a */
    private static String[] m2033a(String str, String str2, String str3) {
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

    /* renamed from: a */
    private static String m2032a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
}
