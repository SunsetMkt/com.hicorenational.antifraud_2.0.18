package d.b.c.a0.e;

/* JADX INFO: compiled from: ASCIIEncoder.java */
/* JADX INFO: loaded from: classes.dex */
final class a implements g {
    a() {
    }

    @Override // d.b.c.a0.e.g
    public int a() {
        return 0;
    }

    @Override // d.b.c.a0.e.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f9476f) >= 2) {
            hVar.a(a(hVar.e().charAt(hVar.f9476f), hVar.e().charAt(hVar.f9476f + 1)));
            hVar.f9476f += 2;
            return;
        }
        char cD = hVar.d();
        int iA = j.a(hVar.e(), hVar.f9476f, a());
        if (iA == a()) {
            if (!j.c(cD)) {
                hVar.a((char) (cD + 1));
                hVar.f9476f++;
                return;
            } else {
                hVar.a('\u00eb');
                hVar.a((char) ((cD - '\u0080') + 1));
                hVar.f9476f++;
                return;
            }
        }
        if (iA == 1) {
            hVar.a('\u00e6');
            hVar.b(1);
            return;
        }
        if (iA == 2) {
            hVar.a('\u00ef');
            hVar.b(2);
            return;
        }
        if (iA == 3) {
            hVar.a('\u00ee');
            hVar.b(3);
            return;
        }
        if (iA == 4) {
            hVar.a('\u00f0');
            hVar.b(4);
        } else if (iA == 5) {
            hVar.a('\u00e7');
            hVar.b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iA);
        }
    }

    private static char a(char c2, char c3) {
        if (j.b(c2) && j.b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
