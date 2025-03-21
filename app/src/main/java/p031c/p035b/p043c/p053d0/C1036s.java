package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: UPCAReader.java */
/* renamed from: c.b.c.d0.s */
/* loaded from: classes.dex */
public final class C1036s extends AbstractC1041x {

    /* renamed from: j */
    private final AbstractC1041x f1940j = new C1025h();

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    public C1107r mo1516a(int i2, C1162a c1162a, int[] iArr, Map<EnumC1044e, ?> map) throws C1102m, C1097h, C0988d {
        return m1515a(this.f1940j.mo1516a(i2, c1162a, iArr, map));
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x, p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C1097h, C0988d {
        return m1515a(this.f1940j.mo1365a(i2, c1162a, map));
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C1097h {
        return m1515a(this.f1940j.mo1185a(c0981c));
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C1097h {
        return m1515a(this.f1940j.mo1186a(c0981c, map));
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    EnumC0953a mo1497a() {
        return EnumC0953a.UPC_A;
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected int mo1496a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        return this.f1940j.mo1496a(c1162a, iArr, sb);
    }

    /* renamed from: a */
    private static C1107r m1515a(C1107r c1107r) throws C1097h {
        String m1917e = c1107r.m1917e();
        if (m1917e.charAt(0) == '0') {
            return new C1107r(m1917e.substring(1), null, c1107r.m1916d(), EnumC0953a.UPC_A);
        }
        throw C1097h.getFormatInstance();
    }
}
