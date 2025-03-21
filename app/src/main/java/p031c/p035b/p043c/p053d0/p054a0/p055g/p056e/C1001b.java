package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: AI01320xDecoder.java */
/* renamed from: c.b.c.d0.a0.g.e.b */
/* loaded from: classes.dex */
final class C1001b extends AbstractC1005f {
    C1001b(C1162a c1162a) {
        super(c1162a);
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1008i
    /* renamed from: a */
    protected int mo1426a(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }

    @Override // p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1008i
    /* renamed from: b */
    protected void mo1427b(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
