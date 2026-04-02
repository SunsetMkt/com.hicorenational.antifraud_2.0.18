package d.b.c.y.a;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: EmailDoCoMoResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9956f = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    static boolean e(String str) {
        return str != null && f9956f.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // d.b.c.y.a.u
    public h a(d.b.c.r rVar) {
        String[] strArrA;
        String strB = u.b(rVar);
        if (!strB.startsWith("MATMSG:") || (strArrA = a.a("TO:", strB, true)) == null) {
            return null;
        }
        for (String str : strArrA) {
            if (!e(str)) {
                return null;
            }
        }
        return new h(strArrA, null, null, a.b("SUB:", strB, false), a.b("BODY:", strB, false));
    }
}
