package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AI01decoder.java */
/* renamed from: c.b.c.d0.a0.g.e.h */
/* loaded from: classes.dex */
abstract class AbstractC1007h extends AbstractC1009j {

    /* renamed from: c */
    protected static final int f1847c = 40;

    AbstractC1007h(C1162a c1162a) {
        super(c1162a);
    }

    /* renamed from: b */
    private static void m1430b(StringBuilder sb, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i2) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        sb.append(i5 != 10 ? i5 : 0);
    }

    /* renamed from: a */
    protected final void m1431a(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        m1432a(sb, i2, length);
    }

    /* renamed from: a */
    protected final void m1432a(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int m1477a = m1435a().m1477a((i4 * 10) + i2, 10);
            if (m1477a / 100 == 0) {
                sb.append('0');
            }
            if (m1477a / 10 == 0) {
                sb.append('0');
            }
            sb.append(m1477a);
        }
        m1430b(sb, i3);
    }
}
