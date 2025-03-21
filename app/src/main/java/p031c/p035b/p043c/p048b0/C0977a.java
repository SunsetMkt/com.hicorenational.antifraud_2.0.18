package p031c.p035b.p043c.p048b0;

import java.util.Map;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.InterfaceC1105p;
import p031c.p035b.p043c.p048b0.p049b.C0980c;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;

/* compiled from: MaxiCodeReader.java */
/* renamed from: c.b.c.b0.a */
/* loaded from: classes.dex */
public final class C0977a implements InterfaceC1105p {

    /* renamed from: b */
    private static final C1109t[] f1730b = new C1109t[0];

    /* renamed from: c */
    private static final int f1731c = 30;

    /* renamed from: d */
    private static final int f1732d = 33;

    /* renamed from: a */
    private final C0980c f1733a = new C0980c();

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C0988d, C1097h {
        return mo1186a(c0981c, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        if (map == null || !map.containsKey(EnumC1044e.PURE_BARCODE)) {
            throw C1102m.getNotFoundInstance();
        }
        C1166e m1341a = this.f1733a.m1341a(m1328a(c0981c.m1344a()), map);
        C1107r c1107r = new C1107r(m1341a.m2198i(), m1341a.m2195f(), f1730b, EnumC0953a.MAXICODE);
        String m2190b = m1341a.m2190b();
        if (m2190b != null) {
            c1107r.m1911a(EnumC1108s.ERROR_CORRECTION_LEVEL, m2190b);
        }
        return c1107r;
    }

    /* renamed from: a */
    private static C1163b m1328a(C1163b c1163b) throws C1102m {
        int[] m2176c = c1163b.m2176c();
        if (m2176c != null) {
            int i2 = m2176c[0];
            int i3 = m2176c[1];
            int i4 = m2176c[2];
            int i5 = m2176c[3];
            C1163b c1163b2 = new C1163b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (c1163b.m2173b(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        c1163b2.m2175c(i8, i6);
                    }
                }
            }
            return c1163b2;
        }
        throw C1102m.getNotFoundInstance();
    }
}
