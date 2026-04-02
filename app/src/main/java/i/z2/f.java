package i.z2;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: Charsets.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    @i.q2.c
    @j.c.a.d
    public static final Charset a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final Charset f12404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final Charset f12405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final Charset f12406d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final Charset f12407e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i.q2.c
    @j.c.a.d
    public static final Charset f12408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Charset f12409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Charset f12410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Charset f12411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f12412j = new f();

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        i.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-8\")");
        a = charsetForName;
        Charset charsetForName2 = Charset.forName(j.a.a.a.c.f12441c);
        i.q2.t.i0.a((Object) charsetForName2, "Charset.forName(\"UTF-16\")");
        f12404b = charsetForName2;
        Charset charsetForName3 = Charset.forName(j.a.a.a.c.f12442d);
        i.q2.t.i0.a((Object) charsetForName3, "Charset.forName(\"UTF-16BE\")");
        f12405c = charsetForName3;
        Charset charsetForName4 = Charset.forName(j.a.a.a.c.f12443e);
        i.q2.t.i0.a((Object) charsetForName4, "Charset.forName(\"UTF-16LE\")");
        f12406d = charsetForName4;
        Charset charsetForName5 = Charset.forName(j.a.a.a.c.f12440b);
        i.q2.t.i0.a((Object) charsetForName5, "Charset.forName(\"US-ASCII\")");
        f12407e = charsetForName5;
        Charset charsetForName6 = Charset.forName(j.a.a.a.c.a);
        i.q2.t.i0.a((Object) charsetForName6, "Charset.forName(\"ISO-8859-1\")");
        f12408f = charsetForName6;
    }

    private f() {
    }

    @i.q2.e(name = "UTF32")
    @j.c.a.d
    public final Charset a() {
        Charset charset = f12409g;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        i.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32\")");
        f12409g = charsetForName;
        return charsetForName;
    }

    @i.q2.e(name = "UTF32_BE")
    @j.c.a.d
    public final Charset b() {
        Charset charset = f12411i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        i.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32BE\")");
        f12411i = charsetForName;
        return charsetForName;
    }

    @i.q2.e(name = "UTF32_LE")
    @j.c.a.d
    public final Charset c() {
        Charset charset = f12410h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        i.q2.t.i0.a((Object) charsetForName, "Charset.forName(\"UTF-32LE\")");
        f12410h = charsetForName;
        return charsetForName;
    }
}
