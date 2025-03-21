package p031c.p035b.p043c.p044a0.p047e;

/* compiled from: TextEncoder.java */
/* renamed from: c.b.c.a0.e.m */
/* loaded from: classes.dex */
final class C0974m extends C0964c {
    C0974m() {
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c, p031c.p035b.p043c.p044a0.p047e.InterfaceC0968g
    /* renamed from: a */
    public int mo1241a() {
        return 2;
    }

    @Override // p031c.p035b.p043c.p044a0.p047e.C0964c
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
        if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) ((c2 - 'a') + 14));
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
        if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c2 - 'A') + 1));
            return 2;
        }
        if (c2 >= '{' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) ((c2 - '{') + 27));
            return 2;
        }
        if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return mo1247a((char) (c2 - 128), sb) + 2;
        }
        C0971j.m1297a(c2);
        return -1;
    }
}
