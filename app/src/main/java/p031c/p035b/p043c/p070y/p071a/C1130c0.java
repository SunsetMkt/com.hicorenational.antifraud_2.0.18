package p031c.p035b.p043c.p070y.p071a;

import com.just.agentweb.DefaultWebClient;
import java.util.regex.Pattern;

/* compiled from: URIParsedResult.java */
/* renamed from: c.b.c.y.a.c0 */
/* loaded from: classes.dex */
public final class C1130c0 extends AbstractC1152q {

    /* renamed from: d */
    private static final Pattern f2280d = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b */
    private final String f2281b;

    /* renamed from: c */
    private final String f2282c;

    public C1130c0(String str, String str2) {
        super(EnumC1153r.URI);
        this.f2281b = m2010a(str);
        this.f2282c = str2;
    }

    @Override // p031c.p035b.p043c.p070y.p071a.AbstractC1152q
    /* renamed from: a */
    public String mo2006a() {
        StringBuilder sb = new StringBuilder(30);
        AbstractC1152q.m2115a(this.f2282c, sb);
        AbstractC1152q.m2115a(this.f2281b, sb);
        return sb.toString();
    }

    /* renamed from: c */
    public String m2012c() {
        return this.f2282c;
    }

    /* renamed from: d */
    public String m2013d() {
        return this.f2281b;
    }

    /* renamed from: e */
    public boolean m2014e() {
        return f2280d.matcher(this.f2281b).find();
    }

    /* renamed from: a */
    private static String m2010a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf >= 0 && !m2011a(trim, indexOf)) {
            return trim;
        }
        return DefaultWebClient.HTTP_SCHEME + trim;
    }

    /* renamed from: a */
    private static boolean m2011a(String str, int i2) {
        int i3 = i2 + 1;
        int indexOf = str.indexOf(47, i3);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return AbstractC1156u.m2125a(str, i3, indexOf - i3);
    }
}
