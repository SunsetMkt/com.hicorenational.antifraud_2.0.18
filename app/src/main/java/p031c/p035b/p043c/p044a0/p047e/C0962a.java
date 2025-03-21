package p031c.p035b.p043c.p044a0.p047e;

/* compiled from: ASCIIEncoder.java */
/* renamed from: c.b.c.a0.e.a */
/* loaded from: classes.dex */
final class C0962a implements InterfaceC0968g {
    C0962a() {
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 0;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public void mo1242a(C0969h c0969h) {
        if (C0971j.m1291a(c0969h.m1279e(), c0969h.f1689f) >= 2) {
            c0969h.m1269a(m1240a(c0969h.m1279e().charAt(c0969h.f1689f), c0969h.m1279e().charAt(c0969h.f1689f + 1)));
            c0969h.f1689f += 2;
            return;
        }
        char m1278d = c0969h.m1278d();
        int m1292a = C0971j.m1292a(c0969h.m1279e(), c0969h.f1689f, mo1241a());
        if (m1292a == mo1241a()) {
            if (!C0971j.m1299c(m1278d)) {
                c0969h.m1269a((char) (m1278d + 1));
                c0969h.f1689f++;
                return;
            } else {
                c0969h.m1269a((char) 235);
                c0969h.m1269a((char) ((m1278d - 128) + 1));
                c0969h.f1689f++;
                return;
            }
        }
        if (m1292a == 1) {
            c0969h.m1269a((char) 230);
            c0969h.m1275b(1);
            return;
        }
        if (m1292a == 2) {
            c0969h.m1269a((char) 239);
            c0969h.m1275b(2);
            return;
        }
        if (m1292a == 3) {
            c0969h.m1269a((char) 238);
            c0969h.m1275b(3);
            return;
        }
        if (m1292a == 4) {
            c0969h.m1269a((char) 240);
            c0969h.m1275b(4);
        } else if (m1292a == 5) {
            c0969h.m1269a((char) 231);
            c0969h.m1275b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + m1292a);
        }
    }

    /* renamed from: a */
    private static char m1240a(char c2, char c3) {
        if (C0971j.m1298b(c2) && C0971j.m1298b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
