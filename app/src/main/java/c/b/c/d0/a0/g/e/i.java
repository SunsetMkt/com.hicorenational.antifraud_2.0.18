package c.b.c.d0.a0.g.e;

/* compiled from: AI01weightDecoder.java */
/* loaded from: classes.dex */
abstract class i extends h {
    i(c.b.c.z.a aVar) {
        super(aVar);
    }

    protected abstract int a(int i2);

    protected abstract void b(StringBuilder sb, int i2);

    protected final void b(StringBuilder sb, int i2, int i3) {
        int a2 = a().a(i2, i3);
        b(sb, a2);
        int a3 = a(a2);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (a3 / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(a3);
    }
}
