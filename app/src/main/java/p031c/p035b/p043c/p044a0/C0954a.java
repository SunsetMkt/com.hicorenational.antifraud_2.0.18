package p031c.p035b.p043c.p044a0;

import java.util.List;
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
import p031c.p035b.p043c.p044a0.p045c.C0959d;
import p031c.p035b.p043c.p044a0.p046d.C0961a;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.C1168g;

/* compiled from: DataMatrixReader.java */
/* renamed from: c.b.c.a0.a */
/* loaded from: classes.dex */
public final class C0954a implements InterfaceC1105p {

    /* renamed from: b */
    private static final C1109t[] f1648b = new C1109t[0];

    /* renamed from: a */
    private final C0959d f1649a = new C0959d();

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C0988d, C1097h {
        return mo1186a(c0981c, (Map<EnumC1044e, ?>) null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        C1109t[] m2203b;
        C1166e c1166e;
        if (map == null || !map.containsKey(EnumC1044e.PURE_BARCODE)) {
            C1168g m1236a = new C0961a(c0981c.m1344a()).m1236a();
            C1166e m1214a = this.f1649a.m1214a(m1236a.m2202a());
            m2203b = m1236a.m2203b();
            c1166e = m1214a;
        } else {
            c1166e = this.f1649a.m1214a(m1184a(c0981c.m1344a()));
            m2203b = f1648b;
        }
        C1107r c1107r = new C1107r(c1166e.m2198i(), c1166e.m2195f(), m2203b, EnumC0953a.DATA_MATRIX);
        List<byte[]> m2187a = c1166e.m2187a();
        if (m2187a != null) {
            c1107r.m1911a(EnumC1108s.BYTE_SEGMENTS, m2187a);
        }
        String m2190b = c1166e.m2190b();
        if (m2190b != null) {
            c1107r.m1911a(EnumC1108s.ERROR_CORRECTION_LEVEL, m2190b);
        }
        return c1107r;
    }

    /* renamed from: a */
    private static C1163b m1184a(C1163b c1163b) throws C1102m {
        int[] m2180f = c1163b.m2180f();
        int[] m2174b = c1163b.m2174b();
        if (m2180f != null && m2174b != null) {
            int m1183a = m1183a(m2180f, c1163b);
            int i2 = m2180f[1];
            int i3 = m2174b[1];
            int i4 = m2180f[0];
            int i5 = ((m2174b[0] - i4) + 1) / m1183a;
            int i6 = ((i3 - i2) + 1) / m1183a;
            if (i5 > 0 && i6 > 0) {
                int i7 = m1183a / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                C1163b c1163b2 = new C1163b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * m1183a) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (c1163b.m2173b((i12 * m1183a) + i9, i11)) {
                            c1163b2.m2175c(i12, i10);
                        }
                    }
                }
                return c1163b2;
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1183a(int[] iArr, C1163b c1163b) throws C1102m {
        int m2181g = c1163b.m2181g();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < m2181g && c1163b.m2173b(i2, i3)) {
            i2++;
        }
        if (i2 != m2181g) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }
}
