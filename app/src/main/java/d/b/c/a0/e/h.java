package d.b.c.a0.e;

import i.f1;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: EncoderContext.java */
/* JADX INFO: loaded from: classes.dex */
final class h {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f9472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.c.f f9473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.c.f f9474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final StringBuilder f9475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f9476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k f9478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9479i;

    h(String str) {
        byte[] bytes = str.getBytes(Charset.forName(j.a.a.a.c.a));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & f1.f12066c);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.a = sb.toString();
        this.f9472b = l.FORCE_NONE;
        this.f9475e = new StringBuilder(str.length());
        this.f9477g = -1;
    }

    private int m() {
        return this.a.length() - this.f9479i;
    }

    public void a(l lVar) {
        this.f9472b = lVar;
    }

    public StringBuilder b() {
        return this.f9475e;
    }

    public char c() {
        return this.a.charAt(this.f9476f);
    }

    public char d() {
        return this.a.charAt(this.f9476f);
    }

    public String e() {
        return this.a;
    }

    public int f() {
        return this.f9477g;
    }

    public int g() {
        return m() - this.f9476f;
    }

    public k h() {
        return this.f9478h;
    }

    public boolean i() {
        return this.f9476f < m();
    }

    public void j() {
        this.f9477g = -1;
    }

    public void k() {
        this.f9478h = null;
    }

    public void l() {
        c(a());
    }

    public void a(d.b.c.f fVar, d.b.c.f fVar2) {
        this.f9473c = fVar;
        this.f9474d = fVar2;
    }

    public void b(int i2) {
        this.f9477g = i2;
    }

    public void c(int i2) {
        k kVar = this.f9478h;
        if (kVar == null || i2 > kVar.b()) {
            this.f9478h = k.a(i2, this.f9472b, this.f9473c, this.f9474d, true);
        }
    }

    public void a(int i2) {
        this.f9479i = i2;
    }

    public void a(String str) {
        this.f9475e.append(str);
    }

    public void a(char c2) {
        this.f9475e.append(c2);
    }

    public int a() {
        return this.f9475e.length();
    }
}
