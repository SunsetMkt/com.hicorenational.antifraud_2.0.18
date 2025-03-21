package c.b.c.y.a;

import java.util.regex.Pattern;

/* compiled from: EmailDoCoMoResultParser.java */
/* loaded from: classes.dex */
public final class j extends a {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2961f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean e(String str) {
        return str != null && f2961f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // c.b.c.y.a.u
    public h a(c.b.c.r rVar) {
        String[] a2;
        String b2 = u.b(rVar);
        if (!b2.startsWith("MATMSG:") || (a2 = a.a("TO:", b2, true)) == null) {
            return null;
        }
        for (String str : a2) {
            if (!e(str)) {
                return null;
            }
        }
        return new h(a2, null, null, a.b("SUB:", b2, false), a.b("BODY:", b2, false));
    }
}
