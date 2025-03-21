package p031c.p035b.p043c.p044a0.p047e;

/* compiled from: X12Encoder.java */
/* renamed from: c.b.c.a0.e.n */
/* loaded from: classes.dex */
final class C0975n extends C0964c {
    C0975n() {
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c, p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 3;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c, p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public void mo1242a(C0969h c0969h) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0969h.m1283i()) {
                break;
            }
            char m1278d = c0969h.m1278d();
            c0969h.f1689f++;
            mo1247a(m1278d, sb);
            if (sb.length() % 3 == 0) {
                C0964c.m1246b(c0969h, sb);
                int m1292a = C0971j.m1292a(c0969h.m1279e(), c0969h.f1689f, mo1241a());
                if (m1292a != mo1241a()) {
                    c0969h.m1275b(m1292a);
                    break;
                }
            }
        }
        mo1248a(c0969h, sb);
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c
    /* renamed from: a */
    int mo1247a(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
        } else {
            C0971j.m1297a(c2);
        }
        return 1;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c
    /* renamed from: a */
    void mo1248a(C0969h c0969h, StringBuilder sb) {
        c0969h.m1286l();
        int m1313b = c0969h.m1282h().m1313b() - c0969h.m1268a();
        c0969h.f1689f -= sb.length();
        if (c0969h.m1281g() > 1 || m1313b > 1 || c0969h.m1281g() != m1313b) {
            c0969h.m1269a((char) 254);
        }
        if (c0969h.m1280f() < 0) {
            c0969h.m1275b(0);
        }
    }
}
