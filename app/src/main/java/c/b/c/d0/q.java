package c.b.c.d0;

import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: OneDReader.java */
/* loaded from: classes.dex */
public abstract class q implements c.b.c.p {
    private c.b.c.r b(c.b.c.c cVar, Map<c.b.c.e, ?> map) throws c.b.c.m {
        int i2;
        int i3;
        int c2 = cVar.c();
        int b2 = cVar.b();
        c.b.c.z.a aVar = new c.b.c.z.a(c2);
        int i4 = b2 >> 1;
        char c3 = 0;
        int i5 = 1;
        boolean z = map != null && map.containsKey(c.b.c.e.TRY_HARDER);
        int max = Math.max(1, b2 >> (z ? 8 : 5));
        int i6 = z ? b2 : 15;
        Map<c.b.c.e, ?> map2 = map;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * max) + i4;
            if (i10 < 0 || i10 >= b2) {
                break;
            }
            try {
                aVar = cVar.a(i10, aVar);
                Map<c.b.c.e, ?> map3 = map2;
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i5) {
                        aVar.e();
                        if (map3 != null && map3.containsKey(c.b.c.e.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(c.b.c.e.class);
                            enumMap.putAll(map3);
                            enumMap.remove(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        c.b.c.r a2 = a(i10, aVar, map3);
                        if (i11 == i5) {
                            a2.a(c.b.c.s.ORIENTATION, 180);
                            c.b.c.t[] d2 = a2.d();
                            if (d2 != null) {
                                float f2 = c2;
                                i3 = c2;
                                try {
                                    d2[0] = new c.b.c.t((f2 - d2[c3].a()) - 1.0f, d2[c3].b());
                                } catch (c.b.c.q unused) {
                                    i11++;
                                    c2 = i3;
                                    c3 = 0;
                                    i5 = 1;
                                }
                                try {
                                    d2[1] = new c.b.c.t((f2 - d2[1].a()) - 1.0f, d2[1].b());
                                } catch (c.b.c.q unused2) {
                                    continue;
                                    i11++;
                                    c2 = i3;
                                    c3 = 0;
                                    i5 = 1;
                                }
                            }
                        }
                        return a2;
                    } catch (c.b.c.q unused3) {
                        i3 = c2;
                    }
                }
                i2 = c2;
                map2 = map3;
            } catch (c.b.c.m unused4) {
                i2 = c2;
            }
            i7 = i8;
            c2 = i2;
            c3 = 0;
            i5 = 1;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    public abstract c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m, c.b.c.d, c.b.c.h;

    @Override // c.b.c.p
    public c.b.c.r a(c.b.c.c cVar) throws c.b.c.m, c.b.c.h {
        return a(cVar, null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public c.b.c.r a(c.b.c.c cVar, Map<c.b.c.e, ?> map) throws c.b.c.m, c.b.c.h {
        try {
            return b(cVar, map);
        } catch (c.b.c.m e2) {
            if (!(map != null && map.containsKey(c.b.c.e.TRY_HARDER)) || !cVar.e()) {
                throw e2;
            }
            c.b.c.c f2 = cVar.f();
            c.b.c.r b2 = b(f2, map);
            Map<c.b.c.s, Object> c2 = b2.c();
            int i2 = SubsamplingScaleImageView.ORIENTATION_270;
            if (c2 != null && c2.containsKey(c.b.c.s.ORIENTATION)) {
                i2 = (((Integer) c2.get(c.b.c.s.ORIENTATION)).intValue() + SubsamplingScaleImageView.ORIENTATION_270) % 360;
            }
            b2.a(c.b.c.s.ORIENTATION, Integer.valueOf(i2));
            c.b.c.t[] d2 = b2.d();
            if (d2 != null) {
                int b3 = f2.b();
                for (int i3 = 0; i3 < d2.length; i3++) {
                    d2[i3] = new c.b.c.t((b3 - d2[i3].b()) - 1.0f, d2[i3].a());
                }
            }
            return b2;
        }
    }

    protected static void a(c.b.c.z.a aVar, int i2, int[] iArr) throws c.b.c.m {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int c2 = aVar.c();
        if (i2 < c2) {
            boolean z = !aVar.b(i2);
            while (i2 < c2) {
                if (aVar.b(i2) ^ z) {
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
                if (i3 != length - 1 || i2 != c2) {
                    throw c.b.c.m.getNotFoundInstance();
                }
                return;
            }
            return;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    protected static void b(c.b.c.z.a aVar, int i2, int[] iArr) throws c.b.c.m {
        int length = iArr.length;
        boolean b2 = aVar.b(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.b(i2) != b2) {
                length--;
                b2 = !b2;
            }
        }
        if (length < 0) {
            a(aVar, i2 + 1, iArr);
            return;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    protected static float a(int[] iArr, int[] iArr2, float f2) {
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
