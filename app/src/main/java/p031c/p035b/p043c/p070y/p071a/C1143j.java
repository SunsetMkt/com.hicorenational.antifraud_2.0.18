package p031c.p035b.p043c.p070y.p071a;

import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;

/* compiled from: EmailDoCoMoResultParser.java */
/* renamed from: c.b.c.y.a.j */
/* loaded from: classes.dex */
public final class C1143j extends AbstractC1125a {

    /* renamed from: f */
    private static final Pattern f2342f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    /* renamed from: e */
    static boolean m2085e(String str) {
        return str != null && f2342f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1139h mo2004a(C1107r c1107r) {
        String[] m2002a;
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (!m2128b.startsWith("MATMSG:") || (m2002a = AbstractC1125a.m2002a("TO:", m2128b, true)) == null) {
            return null;
        }
        for (String str : m2002a) {
            if (!m2085e(str)) {
                return null;
            }
        }
        return new C1139h(m2002a, null, null, AbstractC1125a.m2003b("SUB:", m2128b, false), AbstractC1125a.m2003b("BODY:", m2128b, false));
    }
}
