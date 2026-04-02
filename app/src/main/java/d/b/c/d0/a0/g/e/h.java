package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: AI01decoder.java */
/* JADX INFO: loaded from: classes.dex */
abstract class h extends j {

    /* JADX INFO: renamed from: c */
    protected static final int f9586c = 40;

    h(d.b.c.z.a aVar) {
        super(aVar);
    }

    private static void b(StringBuilder sb, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int iCharAt = sb.charAt(i4 + i2) - '0';
            if ((i4 & 1) == 0) {
                iCharAt *= 3;
            }
            i3 += iCharAt;
        }
        int i5 = 10 - (i3 % 10);
        sb.append(i5 != 10 ? i5 : 0);
    }

    protected final void a(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        a(sb, i2, length);
    }

    protected final void a(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int iA = a().a((i4 * 10) + i2, 10);
            if (iA / 100 == 0) {
                sb.append('0');
            }
            if (iA / 10 == 0) {
                sb.append('0');
            }
            sb.append(iA);
        }
        b(sb, i3);
    }
}
