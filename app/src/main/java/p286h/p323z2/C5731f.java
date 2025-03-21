package p286h.p323z2;

import java.nio.charset.Charset;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p325a.p326a.p327a.C5758c;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Charsets.kt */
/* renamed from: h.z2.f */
/* loaded from: classes2.dex */
public final class C5731f {

    /* renamed from: a */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20676a;

    /* renamed from: b */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20677b;

    /* renamed from: c */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20678c;

    /* renamed from: d */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20679d;

    /* renamed from: e */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20680e;

    /* renamed from: f */
    @InterfaceC5479c
    @InterfaceC5816d
    public static final Charset f20681f;

    /* renamed from: g */
    private static Charset f20682g;

    /* renamed from: h */
    private static Charset f20683h;

    /* renamed from: i */
    private static Charset f20684i;

    /* renamed from: j */
    public static final C5731f f20685j = new C5731f();

    static {
        Charset forName = Charset.forName("UTF-8");
        C5544i0.m22521a((Object) forName, "Charset.forName(\"UTF-8\")");
        f20676a = forName;
        Charset forName2 = Charset.forName(C5758c.f20752c);
        C5544i0.m22521a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f20677b = forName2;
        Charset forName3 = Charset.forName(C5758c.f20753d);
        C5544i0.m22521a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f20678c = forName3;
        Charset forName4 = Charset.forName(C5758c.f20754e);
        C5544i0.m22521a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f20679d = forName4;
        Charset forName5 = Charset.forName(C5758c.f20751b);
        C5544i0.m22521a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f20680e = forName5;
        Charset forName6 = Charset.forName(C5758c.f20750a);
        C5544i0.m22521a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f20681f = forName6;
    }

    private C5731f() {
    }

    @InterfaceC5481e(name = "UTF32")
    @InterfaceC5816d
    /* renamed from: a */
    public final Charset m23970a() {
        Charset charset = f20682g;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        C5544i0.m22521a((Object) forName, "Charset.forName(\"UTF-32\")");
        f20682g = forName;
        return forName;
    }

    @InterfaceC5481e(name = "UTF32_BE")
    @InterfaceC5816d
    /* renamed from: b */
    public final Charset m23971b() {
        Charset charset = f20684i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        C5544i0.m22521a((Object) forName, "Charset.forName(\"UTF-32BE\")");
        f20684i = forName;
        return forName;
    }

    @InterfaceC5481e(name = "UTF32_LE")
    @InterfaceC5816d
    /* renamed from: c */
    public final Charset m23972c() {
        Charset charset = f20683h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        C5544i0.m22521a((Object) forName, "Charset.forName(\"UTF-32LE\")");
        f20683h = forName;
        return forName;
    }
}
