package c.b.c.y.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser.java */
/* loaded from: classes.dex */
public final class d0 extends u {

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2922f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f2923g = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    static boolean e(String str) {
        if (str.contains(c.c.a.b.a.a.f3100g)) {
            return false;
        }
        Matcher matcher = f2922f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f2923g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // c.b.c.y.a.u
    public c0 a(c.b.c.r rVar) {
        String b2 = u.b(rVar);
        if (b2.startsWith("URL:") || b2.startsWith("URI:")) {
            return new c0(b2.substring(4).trim(), null);
        }
        String trim = b2.trim();
        if (e(trim)) {
            return new c0(trim, null);
        }
        return null;
    }
}
