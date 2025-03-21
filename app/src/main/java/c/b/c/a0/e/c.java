package c.b.c.a0.e;

/* compiled from: C40Encoder.java */
/* loaded from: classes.dex */
class c implements g {
    c() {
    }

    static void b(h hVar, StringBuilder sb) {
        hVar.a(a(sb, 0));
        sb.delete(0, 3);
    }

    @Override // c.b.c.a0.e.g
    public int a() {
        return 1;
    }

    @Override // c.b.c.a0.e.g
    public void a(h hVar) {
        int a2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.i()) {
                break;
            }
            char d2 = hVar.d();
            hVar.f2375f++;
            int a3 = a(d2, sb);
            int a4 = hVar.a() + ((sb.length() / 3) * 2);
            hVar.c(a4);
            int b2 = hVar.h().b() - a4;
            if (!hVar.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (b2 < 2 || b2 > 2)) {
                    a3 = a(hVar, sb, sb2, a3);
                }
                while (sb.length() % 3 == 1 && ((a3 <= 3 && b2 != 1) || a3 > 3)) {
                    a3 = a(hVar, sb, sb2, a3);
                }
            } else if (sb.length() % 3 == 0 && (a2 = j.a(hVar.e(), hVar.f2375f, a())) != a()) {
                hVar.b(a2);
                break;
            }
        }
        a(hVar, sb);
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f2375f--;
        int a2 = a(hVar.d(), sb2);
        hVar.k();
        return a2;
    }

    void a(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int a2 = hVar.a() + length;
        hVar.c(a2);
        int b2 = hVar.h().b() - a2;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (hVar.i()) {
                hVar.a((char) 254);
            }
        } else if (b2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (hVar.i()) {
                hVar.a((char) 254);
            }
            hVar.f2375f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(hVar, sb);
            }
            if (b2 > 0 || hVar.i()) {
                hVar.a((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.b(0);
    }

    int a(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        }
        if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return a((char) (c2 - 128), sb) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c2);
    }

    private static String a(CharSequence charSequence, int i2) {
        int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
