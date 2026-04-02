package d.b.c.y.a;

import com.just.agentweb.DefaultWebClient;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: URIParsedResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f9899d = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9901c;

    public c0(String str, String str2) {
        super(r.URI);
        this.f9900b = a(str);
        this.f9901c = str2;
    }

    @Override // d.b.c.y.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.a(this.f9901c, sb);
        q.a(this.f9900b, sb);
        return sb.toString();
    }

    public String c() {
        return this.f9901c;
    }

    public String d() {
        return this.f9900b;
    }

    public boolean e() {
        return f9899d.matcher(this.f9900b).find();
    }

    private static String a(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        if (iIndexOf >= 0 && !a(strTrim, iIndexOf)) {
            return strTrim;
        }
        return DefaultWebClient.HTTP_SCHEME + strTrim;
    }

    private static boolean a(String str, int i2) {
        int i3 = i2 + 1;
        int iIndexOf = str.indexOf(47, i3);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return u.a(str, i3, iIndexOf - i3);
    }
}
