package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AI013x0x1xDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.e */
/* loaded from: classes.dex */
final class C1004e extends AbstractC1008i {

    /* renamed from: f */
    private static final int f1839f = 8;

    /* renamed from: g */
    private static final int f1840g = 20;

    /* renamed from: h */
    private static final int f1841h = 16;

    /* renamed from: d */
    private final String f1842d;

    /* renamed from: e */
    private final String f1843e;

    C1004e(C1162a c1162a, String str, String str2) {
        super(c1162a);
        this.f1842d = str2;
        this.f1843e = str;
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1008i
    /* renamed from: a */
    protected int mo1426a(int i2) {
        return i2 % 100000;
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1008i
    /* renamed from: b */
    protected void mo1427b(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f1843e);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1009j
    /* renamed from: c */
    public String mo1428c() throws C1102m {
        if (m1436b().m2157c() != 84) {
            throw C1102m.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        m1431a(sb, 8);
        m1433b(sb, 48, 20);
        m1429c(sb, 68);
        return sb.toString();
    }

    /* renamed from: c */
    private void m1429c(StringBuilder sb, int i2) {
        int m1477a = m1435a().m1477a(i2, 16);
        if (m1477a == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f1842d);
        sb.append(')');
        int i3 = m1477a % 32;
        int i4 = m1477a / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }
}
