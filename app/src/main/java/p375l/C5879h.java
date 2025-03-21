package p375l;

import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: HttpException.java */
/* renamed from: l.h */
/* loaded from: classes2.dex */
public class C5879h extends RuntimeException {

    /* renamed from: a */
    private final transient C5884m<?> f21211a;
    private final int code;
    private final String message;

    public C5879h(C5884m<?> c5884m) {
        super(m24756a(c5884m));
        this.code = c5884m.m24792b();
        this.message = c5884m.m24796f();
        this.f21211a = c5884m;
    }

    /* renamed from: a */
    private static String m24756a(C5884m<?> c5884m) {
        C5887p.m24845a(c5884m, "response == null");
        return "HTTP " + c5884m.m24792b() + AbstractC1191a.f2568g + c5884m.m24796f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public C5884m<?> response() {
        return this.f21211a;
    }
}
