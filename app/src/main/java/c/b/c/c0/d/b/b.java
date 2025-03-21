package c.b.c.c0.d.b;

import c.b.c.f0.d.d;
import c.b.c.f0.d.e;
import c.b.c.f0.d.f;
import c.b.c.m;
import c.b.c.t;
import c.b.c.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: MultiFinderPatternFinder.java */
/* loaded from: classes.dex */
final class b extends e {

    /* renamed from: i, reason: collision with root package name */
    private static final f[] f2441i = new f[0];

    /* renamed from: j, reason: collision with root package name */
    private static final float f2442j = 180.0f;

    /* renamed from: k, reason: collision with root package name */
    private static final float f2443k = 9.0f;

    /* renamed from: l, reason: collision with root package name */
    private static final float f2444l = 0.05f;

    /* renamed from: m, reason: collision with root package name */
    private static final float f2445m = 0.5f;

    /* compiled from: MultiFinderPatternFinder.java */
    /* renamed from: c.b.c.c0.d.b.b$b, reason: collision with other inner class name */
    private static final class C0035b implements Comparator<d>, Serializable {
        private C0035b() {
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            double d2 = dVar2.d() - dVar.d();
            if (d2 < 0.0d) {
                return -1;
            }
            return d2 > 0.0d ? 1 : 0;
        }
    }

    b(c.b.c.z.b bVar) {
        super(bVar);
    }

    private d[][] c() throws m {
        List<d> b2 = b();
        int size = b2.size();
        int i2 = 3;
        if (size < 3) {
            throw m.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new d[][]{new d[]{b2.get(0), b2.get(1), b2.get(2)}};
        }
        Collections.sort(b2, new C0035b());
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < size - 2) {
            d dVar = b2.get(i3);
            if (dVar != null) {
                int i4 = i3 + 1;
                while (i4 < size - 1) {
                    d dVar2 = b2.get(i4);
                    if (dVar2 != null) {
                        float d2 = (dVar.d() - dVar2.d()) / Math.min(dVar.d(), dVar2.d());
                        float abs = Math.abs(dVar.d() - dVar2.d());
                        float f2 = f2444l;
                        float f3 = f2445m;
                        if (abs > f2445m && d2 >= f2444l) {
                            break;
                        }
                        int i5 = i4 + 1;
                        while (i5 < size) {
                            d dVar3 = b2.get(i5);
                            if (dVar3 != null) {
                                float d3 = (dVar2.d() - dVar3.d()) / Math.min(dVar2.d(), dVar3.d());
                                if (Math.abs(dVar2.d() - dVar3.d()) > f3 && d3 >= f2) {
                                    break;
                                }
                                d[] dVarArr = new d[i2];
                                dVarArr[c2] = dVar;
                                dVarArr[1] = dVar2;
                                dVarArr[2] = dVar3;
                                t.a(dVarArr);
                                f fVar = new f(dVarArr);
                                float a2 = t.a(fVar.b(), fVar.a());
                                float a3 = t.a(fVar.c(), fVar.a());
                                float a4 = t.a(fVar.b(), fVar.c());
                                float d4 = (a2 + a4) / (dVar.d() * 2.0f);
                                if (d4 <= f2442j && d4 >= f2443k && Math.abs((a2 - a4) / Math.min(a2, a4)) < 0.1f) {
                                    float sqrt = (float) Math.sqrt((a2 * a2) + (a4 * a4));
                                    if (Math.abs((a3 - sqrt) / Math.min(a3, sqrt)) < 0.1f) {
                                        arrayList.add(dVarArr);
                                    }
                                }
                            }
                            i5++;
                            i2 = 3;
                            c2 = 0;
                            f2 = f2444l;
                            f3 = f2445m;
                        }
                    }
                    i4++;
                    i2 = 3;
                    c2 = 0;
                }
            }
            i3++;
            i2 = 3;
            c2 = 0;
        }
        if (arrayList.isEmpty()) {
            throw m.getNotFoundInstance();
        }
        return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
    }

    public f[] b(Map<c.b.c.e, ?> map) throws m {
        boolean z = map != null && map.containsKey(c.b.c.e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(c.b.c.e.PURE_BARCODE);
        c.b.c.z.b a2 = a();
        int d2 = a2.d();
        int g2 = a2.g();
        int i2 = (int) ((d2 / 228.0f) * 3.0f);
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        for (int i3 = i2 - 1; i3 < d2; i3 += i2) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < g2; i5++) {
                if (a2.b(i5, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (e.a(iArr) && a(iArr, i3, i5, z2)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i4 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
            }
            if (e.a(iArr)) {
                a(iArr, i3, g2, z2);
            }
        }
        d[][] c2 = c();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : c2) {
            t.a(dVarArr);
            arrayList.add(new f(dVarArr));
        }
        return arrayList.isEmpty() ? f2441i : (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    b(c.b.c.z.b bVar, u uVar) {
        super(bVar, uVar);
    }
}
