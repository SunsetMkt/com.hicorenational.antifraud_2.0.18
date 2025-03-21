package p031c.p035b.p043c.p044a0.p047e;

/* compiled from: C40Encoder.java */
/* renamed from: c.b.c.a0.e.c */
/* loaded from: classes.dex */
class C0964c implements InterfaceC0968g {
    C0964c() {
    }

    /* renamed from: b */
    static void m1246b(C0969h c0969h, StringBuilder sb) {
        c0969h.m1273a(m1245a(sb, 0));
        sb.delete(0, 3);
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 1;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public void mo1242a(C0969h c0969h) {
        int m1292a;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0969h.m1283i()) {
                break;
            }
            char m1278d = c0969h.m1278d();
            c0969h.f1689f++;
            int mo1247a = mo1247a(m1278d, sb);
            int m1268a = c0969h.m1268a() + ((sb.length() / 3) * 2);
            c0969h.m1277c(m1268a);
            int m1313b = c0969h.m1282h().m1313b() - m1268a;
            if (!c0969h.m1283i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (m1313b < 2 || m1313b > 2)) {
                    mo1247a = m1244a(c0969h, sb, sb2, mo1247a);
                }
                while (sb.length() % 3 == 1 && ((mo1247a <= 3 && m1313b != 1) || mo1247a > 3)) {
                    mo1247a = m1244a(c0969h, sb, sb2, mo1247a);
                }
            } else if (sb.length() % 3 == 0 && (m1292a = C0971j.m1292a(c0969h.m1279e(), c0969h.f1689f, mo1241a())) != mo1241a()) {
                c0969h.m1275b(m1292a);
                break;
            }
        }
        mo1248a(c0969h, sb);
    }

    /* renamed from: a */
    private int m1244a(C0969h c0969h, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        c0969h.f1689f--;
        int mo1247a = mo1247a(c0969h.m1278d(), sb2);
        c0969h.m1285k();
        return mo1247a;
    }

    /* renamed from: a */
    void mo1248a(C0969h c0969h, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int m1268a = c0969h.m1268a() + length;
        c0969h.m1277c(m1268a);
        int m1313b = c0969h.m1282h().m1313b() - m1268a;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                m1246b(c0969h, sb);
            }
            if (c0969h.m1283i()) {
                c0969h.m1269a((char) 254);
            }
        } else if (m1313b == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                m1246b(c0969h, sb);
            }
            if (c0969h.m1283i()) {
                c0969h.m1269a((char) 254);
            }
            c0969h.f1689f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                m1246b(c0969h, sb);
            }
            if (m1313b > 0 || c0969h.m1283i()) {
                c0969h.m1269a((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        c0969h.m1275b(0);
    }

    /* renamed from: a */
    int mo1247a(char c2, StringBuilder sb) {
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
            return mo1247a((char) (c2 - 128), sb) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c2);
    }

    /* renamed from: a */
    private static String m1245a(CharSequence charSequence, int i2) {
        int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
