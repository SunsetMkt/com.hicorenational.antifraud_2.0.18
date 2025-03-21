package p031c.p035b.p043c.p070y.p071a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p031c.p035b.p043c.C1107r;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: URIResultParser.java */
/* renamed from: c.b.c.y.a.d0 */
/* loaded from: classes.dex */
public final class C1132d0 extends AbstractC1156u {

    /* renamed from: f */
    private static final Pattern f2299f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g */
    private static final Pattern f2300g = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    /* renamed from: e */
    static boolean m2031e(String str) {
        if (str.contains(AbstractC1191a.f2568g)) {
            return false;
        }
        Matcher matcher = f2299f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f2300g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1156u
    /* renamed from: a */
    public C1130c0 mo2004a(C1107r c1107r) {
        String m2128b = AbstractC1156u.m2128b(c1107r);
        if (m2128b.startsWith("URL:") || m2128b.startsWith("URI:")) {
            return new C1130c0(m2128b.substring(4).trim(), null);
        }
        String trim = m2128b.trim();
        if (m2031e(trim)) {
            return new C1130c0(trim, null);
        }
        return null;
    }
}
