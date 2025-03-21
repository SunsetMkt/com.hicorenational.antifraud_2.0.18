package p031c.p035b.p043c.p053d0;

import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.EnumC1108s;
import p031c.p035b.p043c.InterfaceC1105p;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: OneDReader.java */
/* renamed from: c.b.c.d0.q */
/* loaded from: classes.dex */
public abstract class AbstractC1034q implements InterfaceC1105p {
    /* renamed from: b */
    private C1107r m1510b(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m {
        int i2;
        int i3;
        int m1346c = c0981c.m1346c();
        int m1345b = c0981c.m1345b();
        C1162a c1162a = new C1162a(m1346c);
        int i4 = m1345b >> 1;
        char c2 = 0;
        int i5 = 1;
        boolean z = map != null && map.containsKey(EnumC1044e.TRY_HARDER);
        int max = Math.max(1, m1345b >> (z ? 8 : 5));
        int i6 = z ? m1345b : 15;
        Map<EnumC1044e, ?> map2 = map;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * max) + i4;
            if (i10 < 0 || i10 >= m1345b) {
                break;
            }
            try {
                c1162a = c0981c.m1343a(i10, c1162a);
                Map<EnumC1044e, ?> map3 = map2;
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i5) {
                        c1162a.m2162e();
                        if (map3 != null && map3.containsKey(EnumC1044e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(EnumC1044e.class);
                            enumMap.putAll(map3);
                            enumMap.remove(EnumC1044e.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        C1107r mo1365a = mo1365a(i10, c1162a, map3);
                        if (i11 == i5) {
                            mo1365a.m1911a(EnumC1108s.ORIENTATION, 180);
                            C1109t[] m1916d = mo1365a.m1916d();
                            if (m1916d != null) {
                                float f2 = m1346c;
                                i3 = m1346c;
                                try {
                                    m1916d[0] = new C1109t((f2 - m1916d[c2].m1922a()) - 1.0f, m1916d[c2].m1923b());
                                } catch (AbstractC1106q unused) {
                                    i11++;
                                    m1346c = i3;
                                    c2 = 0;
                                    i5 = 1;
                                }
                                try {
                                    m1916d[1] = new C1109t((f2 - m1916d[1].m1922a()) - 1.0f, m1916d[1].m1923b());
                                } catch (AbstractC1106q unused2) {
                                    continue;
                                    i11++;
                                    m1346c = i3;
                                    c2 = 0;
                                    i5 = 1;
                                }
                            }
                        }
                        return mo1365a;
                    } catch (AbstractC1106q unused3) {
                        i3 = m1346c;
                    }
                }
                i2 = m1346c;
                map2 = map3;
            } catch (C1102m unused4) {
                i2 = m1346c;
            }
            i7 = i8;
            m1346c = i2;
            c2 = 0;
            i5 = 1;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    public abstract C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C0988d, C1097h;

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1185a(C0981c c0981c) throws C1102m, C1097h {
        return mo1186a(c0981c, null);
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
    }

    @Override // p031c.p035b.p043c.InterfaceC1105p
    /* renamed from: a */
    public C1107r mo1186a(C0981c c0981c, Map<EnumC1044e, ?> map) throws C1102m, C1097h {
        try {
            return m1510b(c0981c, map);
        } catch (C1102m e2) {
            if (!(map != null && map.containsKey(EnumC1044e.TRY_HARDER)) || !c0981c.m1348e()) {
                throw e2;
            }
            C0981c m1349f = c0981c.m1349f();
            C1107r m1510b = m1510b(m1349f, map);
            Map<EnumC1108s, Object> m1915c = m1510b.m1915c();
            int i2 = SubsamplingScaleImageView.ORIENTATION_270;
            if (m1915c != null && m1915c.containsKey(EnumC1108s.ORIENTATION)) {
                i2 = (((Integer) m1915c.get(EnumC1108s.ORIENTATION)).intValue() + SubsamplingScaleImageView.ORIENTATION_270) % 360;
            }
            m1510b.m1911a(EnumC1108s.ORIENTATION, Integer.valueOf(i2));
            C1109t[] m1916d = m1510b.m1916d();
            if (m1916d != null) {
                int m1345b = m1349f.m1345b();
                for (int i3 = 0; i3 < m1916d.length; i3++) {
                    m1916d[i3] = new C1109t((m1345b - m1916d[i3].m1923b()) - 1.0f, m1916d[i3].m1922a());
                }
            }
            return m1510b;
        }
    }

    /* renamed from: a */
    protected static void m1509a(C1162a c1162a, int i2, int[] iArr) throws C1102m {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int m2157c = c1162a.m2157c();
        if (i2 < m2157c) {
            boolean z = !c1162a.m2155b(i2);
            while (i2 < m2157c) {
                if (c1162a.m2155b(i2) ^ z) {
                    iArr[i3] = iArr[i3] + 1;
                } else {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z = !z;
                }
                i2++;
            }
            if (i3 != length) {
                if (i3 != length - 1 || i2 != m2157c) {
                    throw C1102m.getNotFoundInstance();
                }
                return;
            }
            return;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: b */
    protected static void m1511b(C1162a c1162a, int i2, int[] iArr) throws C1102m {
        int length = iArr.length;
        boolean m2155b = c1162a.m2155b(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (c1162a.m2155b(i2) != m2155b) {
                length--;
                m2155b = !m2155b;
            }
        }
        if (length < 0) {
            m1509a(c1162a, i2 + 1, iArr);
            return;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    protected static float m1508a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
