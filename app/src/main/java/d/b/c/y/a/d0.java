package d.b.c.y.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: URIResultParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9915f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f9916g = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean e(String str) {
        if (str.contains(d.c.a.b.a.a.f10074g)) {
            return false;
        }
        Matcher matcher = f9915f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f9916g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // d.b.c.y.a.u
    public c0 a(d.b.c.r rVar) {
        String strB = u.b(rVar);
        if (strB.startsWith("URL:") || strB.startsWith("URI:")) {
            return new c0(strB.substring(4).trim(), null);
        }
        String strTrim = strB.trim();
        if (e(strTrim)) {
            return new c0(strTrim, null);
        }
        return null;
    }
}
