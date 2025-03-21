package c.b.c.a0.e;

/* compiled from: ASCIIEncoder.java */
/* loaded from: classes.dex */
final class a implements g {
    a() {
    }

    @Override // c.b.c.a0.e.g
    public int a() {
        return 0;
    }

    @Override // c.b.c.a0.e.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f2375f) >= 2) {
            hVar.a(a(hVar.e().charAt(hVar.f2375f), hVar.e().charAt(hVar.f2375f + 1)));
            hVar.f2375f += 2;
            return;
        }
        char d2 = hVar.d();
        int a2 = j.a(hVar.e(), hVar.f2375f, a());
        if (a2 == a()) {
            if (!j.c(d2)) {
                hVar.a((char) (d2 + 1));
                hVar.f2375f++;
                return;
            } else {
                hVar.a((char) 235);
                hVar.a((char) ((d2 - 128) + 1));
                hVar.f2375f++;
                return;
            }
        }
        if (a2 == 1) {
            hVar.a((char) 230);
            hVar.b(1);
            return;
        }
        if (a2 == 2) {
            hVar.a((char) 239);
            hVar.b(2);
            return;
        }
        if (a2 == 3) {
            hVar.a((char) 238);
            hVar.b(3);
            return;
        }
        if (a2 == 4) {
            hVar.a((char) 240);
            hVar.b(4);
        } else if (a2 == 5) {
            hVar.a((char) 231);
            hVar.b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + a2);
        }
    }

    private static char a(char c2, char c3) {
        if (j.b(c2) && j.b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
