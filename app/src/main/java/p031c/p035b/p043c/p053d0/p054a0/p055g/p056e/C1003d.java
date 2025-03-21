package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AI01393xDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.d */
/* loaded from: classes.dex */
final class C1003d extends AbstractC1007h {

    /* renamed from: d */
    private static final int f1836d = 8;

    /* renamed from: e */
    private static final int f1837e = 2;

    /* renamed from: f */
    private static final int f1838f = 10;

    C1003d(C1162a c1162a) {
        super(c1162a);
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1009j
    /* renamed from: c */
    public String mo1428c() throws C1102m, C1097h {
        if (m1436b().m2157c() < 48) {
            throw C1102m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        m1431a(sb, 8);
        int m1477a = m1435a().m1477a(48, 2);
        sb.append("(393");
        sb.append(m1477a);
        sb.append(')');
        int m1477a2 = m1435a().m1477a(50, 10);
        if (m1477a2 / 100 == 0) {
            sb.append('0');
        }
        if (m1477a2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(m1477a2);
        sb.append(m1435a().m1478a(60, (String) null).m1450b());
        return sb.toString();
    }
}
