package p031c.p035b.p043c.p044a0.p047e;

import java.nio.charset.Charset;
import p031c.p035b.p043c.C1071f;
import p286h.C5230f1;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: EncoderContext.java */
/* renamed from: c.b.c.a0.e.h */
/* loaded from: classes.dex */
final class C0969h {

    /* renamed from: a */
    private final String f1684a;

    /* renamed from: b */
    private EnumC0973l f1685b;

    /* renamed from: c */
    private C1071f f1686c;

    /* renamed from: d */
    private C1071f f1687d;

    /* renamed from: e */
    private final StringBuilder f1688e;

    /* renamed from: f */
    int f1689f;

    /* renamed from: g */
    private int f1690g;

    /* renamed from: h */
    private C0972k f1691h;

    /* renamed from: i */
    private int f1692i;

    C0969h(String str) {
        byte[] bytes = str.getBytes(Charset.forName(C5758c.f20750a));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & C5230f1.f20085c);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.f1684a = sb.toString();
        this.f1685b = EnumC0973l.FORCE_NONE;
        this.f1688e = new StringBuilder(str.length());
        this.f1690g = -1;
    }

    /* renamed from: m */
    private int m1267m() {
        return this.f1684a.length() - this.f1692i;
    }

    /* renamed from: a */
    public void m1271a(EnumC0973l enumC0973l) {
        this.f1685b = enumC0973l;
    }

    /* renamed from: b */
    public StringBuilder m1274b() {
        return this.f1688e;
    }

    /* renamed from: c */
    public char m1276c() {
        return this.f1684a.charAt(this.f1689f);
    }

    /* renamed from: d */
    public char m1278d() {
        return this.f1684a.charAt(this.f1689f);
    }

    /* renamed from: e */
    public String m1279e() {
        return this.f1684a;
    }

    /* renamed from: f */
    public int m1280f() {
        return this.f1690g;
    }

    /* renamed from: g */
    public int m1281g() {
        return m1267m() - this.f1689f;
    }

    /* renamed from: h */
    public C0972k m1282h() {
        return this.f1691h;
    }

    /* renamed from: i */
    public boolean m1283i() {
        return this.f1689f < m1267m();
    }

    /* renamed from: j */
    public void m1284j() {
        this.f1690g = -1;
    }

    /* renamed from: k */
    public void m1285k() {
        this.f1691h = null;
    }

    /* renamed from: l */
    public void m1286l() {
        m1277c(m1268a());
    }

    /* renamed from: a */
    public void m1272a(C1071f c1071f, C1071f c1071f2) {
        this.f1686c = c1071f;
        this.f1687d = c1071f2;
    }

    /* renamed from: b */
    public void m1275b(int i2) {
        this.f1690g = i2;
    }

    /* renamed from: c */
    public void m1277c(int i2) {
        C0972k c0972k = this.f1691h;
        if (c0972k == null || i2 > c0972k.m1313b()) {
            this.f1691h = C0972k.m1307a(i2, this.f1685b, this.f1686c, this.f1687d, true);
        }
    }

    /* renamed from: a */
    public void m1270a(int i2) {
        this.f1692i = i2;
    }

    /* renamed from: a */
    public void m1273a(String str) {
        this.f1688e.append(str);
    }

    /* renamed from: a */
    public void m1269a(char c2) {
        this.f1688e.append(c2);
    }

    /* renamed from: a */
    public int m1268a() {
        return this.f1688e.length();
    }
}
