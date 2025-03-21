package p031c.p035b.p043c.p044a0.p047e;

/* compiled from: EdifactEncoder.java */
/* renamed from: c.b.c.a0.e.f */
/* loaded from: classes.dex */
final class C0967f implements InterfaceC0968g {
    C0967f() {
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 4;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public void mo1242a(C0969h c0969h) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0969h.m1283i()) {
                break;
            }
            m1265a(c0969h.m1278d(), sb);
            c0969h.f1689f++;
            if (sb.length() >= 4) {
                c0969h.m1273a(m1264a(sb, 0));
                sb.delete(0, 4);
                if (C0971j.m1292a(c0969h.m1279e(), c0969h.f1689f, mo1241a()) != mo1241a()) {
                    c0969h.m1275b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        m1266a(c0969h, sb);
    }

    /* renamed from: a */
    private static void m1266a(C0969h c0969h, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                c0969h.m1286l();
                int m1313b = c0969h.m1282h().m1313b() - c0969h.m1268a();
                if (c0969h.m1281g() == 0 && m1313b <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i2 = length - 1;
                String m1264a = m1264a(charSequence, 0);
                if (!(!c0969h.m1283i()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    c0969h.m1277c(c0969h.m1268a() + i2);
                    if (c0969h.m1282h().m1313b() - c0969h.m1268a() >= 3) {
                        c0969h.m1277c(c0969h.m1268a() + m1264a.length());
                        z = false;
                    }
                }
                if (z) {
                    c0969h.m1285k();
                    c0969h.f1689f -= i2;
                } else {
                    c0969h.m1273a(m1264a);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            c0969h.m1275b(0);
        }
    }

    /* renamed from: a */
    private static void m1265a(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            C0971j.m1297a(c2);
        }
    }

    /* renamed from: a */
    private static String m1264a(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            int charAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
            char c2 = (char) ((charAt >> 16) & 255);
            char c3 = (char) ((charAt >> 8) & 255);
            char c4 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c2);
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
