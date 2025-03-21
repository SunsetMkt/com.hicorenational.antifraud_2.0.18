package p031c.p035b.p043c.p062f0;

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
import p031c.p035b.p043c.p062f0.p063c.C1078e;
import p031c.p035b.p043c.p062f0.p063c.C1082i;
import p031c.p035b.p043c.p062f0.p064d.C1086c;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.C1168g;

/* compiled from: QRCodeReader.java */
/* renamed from: c.b.c.f0.a */
/* loaded from: classes.dex */
public class C1072a implements InterfaceC1105p {

    /* renamed from: b */
    private static final C1109t[] f2110b = new C1109t[0];

    /* renamed from: a */
    private final C1078e f2111a = new C1078e();

    /* renamed from: a */
    protected final C1078e m1732a() {
        return this.f2111a;
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C0988d, C1097h {
        return mo1186a(c0981c, (Map<EnumC1044e, ?>) null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public final C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h {
        C1109t[] m2203b;
        C1166e c1166e;
        if (map != null && map.containsKey(EnumC1044e.PURE_BARCODE)) {
            c1166e = this.f2111a.m1758a(m1731a(c0981c.m1344a()), map);
            m2203b = f2110b;
        } else {
            C1168g m1801a = new C1086c(c0981c.m1344a()).m1801a(map);
            C1166e m1758a = this.f2111a.m1758a(m1801a.m2202a(), map);
            m2203b = m1801a.m2203b();
            c1166e = m1758a;
        }
        if (c1166e.m2194e() instanceof C1082i) {
            ((C1082i) c1166e.m2194e()).m1766a(m2203b);
        }
        C1107r c1107r = new C1107r(c1166e.m2198i(), c1166e.m2195f(), m2203b, EnumC0953a.QR_CODE);
        List<byte[]> m2187a = c1166e.m2187a();
        if (m2187a != null) {
            c1107r.m1911a(EnumC1108s.BYTE_SEGMENTS, m2187a);
        }
        String m2190b = c1166e.m2190b();
        if (m2190b != null) {
            c1107r.m1911a(EnumC1108s.ERROR_CORRECTION_LEVEL, m2190b);
        }
        if (c1166e.m2199j()) {
            c1107r.m1911a(EnumC1108s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c1166e.m2197h()));
            c1107r.m1911a(EnumC1108s.STRUCTURED_APPEND_PARITY, Integer.valueOf(c1166e.m2196g()));
        }
        return c1107r;
    }

    /* renamed from: a */
    private static C1163b m1731a(C1163b c1163b) throws C1102m {
        int[] m2180f = c1163b.m2180f();
        int[] m2174b = c1163b.m2174b();
        if (m2180f != null && m2174b != null) {
            float m1730a = m1730a(m2180f, c1163b);
            int i2 = m2180f[1];
            int i3 = m2174b[1];
            int i4 = m2180f[0];
            int i5 = m2174b[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4) {
                    i5 = i4 + i6;
                }
                int round = Math.round(((i5 - i4) + 1) / m1730a);
                int round2 = Math.round((i6 + 1) / m1730a);
                if (round <= 0 || round2 <= 0) {
                    throw C1102m.getNotFoundInstance();
                }
                if (round2 == round) {
                    int i7 = (int) (m1730a / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((round - 1) * m1730a)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw C1102m.getNotFoundInstance();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((round2 - 1) * m1730a)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw C1102m.getNotFoundInstance();
                        }
                        i8 -= i11;
                    }
                    C1163b c1163b2 = new C1163b(round, round2);
                    for (int i12 = 0; i12 < round2; i12++) {
                        int i13 = ((int) (i12 * m1730a)) + i8;
                        for (int i14 = 0; i14 < round; i14++) {
                            if (c1163b.m2173b(((int) (i14 * m1730a)) + i9, i13)) {
                                c1163b2.m2175c(i14, i12);
                            }
                        }
                    }
                    return c1163b2;
                }
                throw C1102m.getNotFoundInstance();
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static float m1730a(int[] iArr, C1163b c1163b) throws C1102m {
        int m2177d = c1163b.m2177d();
        int m2181g = c1163b.m2181g();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < m2181g && i3 < m2177d) {
            if (z != c1163b.m2173b(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 != m2181g && i3 != m2177d) {
            return (i2 - iArr[0]) / 7.0f;
        }
        throw C1102m.getNotFoundInstance();
    }
}
