package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AI01weightDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.i */
/* loaded from: classes.dex */
abstract class AbstractC1008i extends AbstractC1007h {
    AbstractC1008i(C1162a c1162a) {
        super(c1162a);
    }

    /* renamed from: a */
    protected abstract int mo1426a(int i2);

    /* renamed from: b */
    protected abstract void mo1427b(StringBuilder sb, int i2);

    /* renamed from: b */
    protected final void m1433b(StringBuilder sb, int i2, int i3) {
        int m1477a = m1435a().m1477a(i2, i3);
        mo1427b(sb, m1477a);
        int mo1426a = mo1426a(m1477a);
        int i4 = 100000;
        for (int i5 = 0; i5 < 5; i5++) {
            if (mo1426a / i4 == 0) {
                sb.append('0');
            }
            i4 /= 10;
        }
        sb.append(mo1426a);
    }
}
