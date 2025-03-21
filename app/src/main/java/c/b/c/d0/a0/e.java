package c.b.c.d0.a0;

import c.b.c.d0.q;
import c.b.c.m;
import c.b.c.r;
import c.b.c.t;
import c.b.c.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader.java */
/* loaded from: classes.dex */
public final class e extends a {

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f2474m = {1, 10, 34, 70, 126};
    private static final int[] n = {4, 20, 48, 81};
    private static final int[] o = {0, 161, 961, 2015, 2715};
    private static final int[] p = {0, 336, 1036, 1516};
    private static final int[] q = {8, 6, 4, 3, 1};
    private static final int[] r = {2, 4, 6, 8};
    private static final int[][] s = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: k, reason: collision with root package name */
    private final List<d> f2475k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private final List<d> f2476l = new ArrayList();

    private static r b(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        t[] a2 = dVar.d().a();
        t[] a3 = dVar2.d().a();
        return new r(String.valueOf(sb.toString()), null, new t[]{a2[0], a2[1], a3[0], a3[1]}, c.b.c.a.RSS_14);
    }

    @Override // c.b.c.d0.q
    public r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws m {
        a(this.f2475k, a(aVar, false, i2, map));
        aVar.e();
        a(this.f2476l, a(aVar, true, i2, map));
        aVar.e();
        int size = this.f2475k.size();
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = this.f2475k.get(i3);
            if (dVar.c() > 1) {
                int size2 = this.f2476l.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d dVar2 = this.f2476l.get(i4);
                    if (dVar2.c() > 1 && a(dVar, dVar2)) {
                        return b(dVar, dVar2);
                    }
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public void reset() {
        this.f2475k.clear();
        this.f2476l.clear();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        boolean z = false;
        Iterator<d> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d next = it.next();
            if (next.b() == dVar.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(dVar);
    }

    private static boolean a(d dVar, d dVar2) {
        int a2 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c2 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c2 > 72) {
            c2--;
        }
        if (c2 > 8) {
            c2--;
        }
        return a2 == c2;
    }

    private d a(c.b.c.z.a aVar, boolean z, int i2, Map<c.b.c.e, ?> map) {
        try {
            c a2 = a(aVar, i2, z, a(aVar, 0, z));
            u uVar = map == null ? null : (u) map.get(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
            if (uVar != null) {
                float f2 = (r2[0] + r2[1]) / 2.0f;
                if (z) {
                    f2 = (aVar.c() - 1) - f2;
                }
                uVar.a(new t(f2, i2));
            }
            b a3 = a(aVar, a2, true);
            b a4 = a(aVar, a2, false);
            return new d((a3.b() * 1597) + a4.b(), a3.a() + (a4.a() * 4), a2);
        } catch (m unused) {
            return null;
        }
    }

    private b a(c.b.c.z.a aVar, c cVar, boolean z) throws m {
        int[] a2 = a();
        a2[0] = 0;
        a2[1] = 0;
        a2[2] = 0;
        a2[3] = 0;
        a2[4] = 0;
        a2[5] = 0;
        a2[6] = 0;
        a2[7] = 0;
        if (z) {
            q.b(aVar, cVar.b()[0], a2);
        } else {
            q.a(aVar, cVar.b()[1] + 1, a2);
            int i2 = 0;
            for (int length = a2.length - 1; i2 < length; length--) {
                int i3 = a2[i2];
                a2[i2] = a2[length];
                a2[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float a3 = a.a(a2) / i4;
        int[] e2 = e();
        int[] c2 = c();
        float[] f2 = f();
        float[] d2 = d();
        for (int i5 = 0; i5 < a2.length; i5++) {
            float f3 = a2[i5] / a3;
            int i6 = (int) (0.5f + f3);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                e2[i7] = i6;
                f2[i7] = f3 - i6;
            } else {
                c2[i7] = i6;
                d2[i7] = f3 - i6;
            }
        }
        a(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = e2.length - 1; length2 >= 0; length2--) {
            i8 = (i8 * 9) + e2[length2];
            i9 += e2[length2];
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = c2.length - 1; length3 >= 0; length3--) {
            i10 = (i10 * 9) + c2[length3];
            i11 += c2[length3];
        }
        int i12 = i8 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) == 0 && i11 <= 10 && i11 >= 4) {
                int i13 = (10 - i11) / 2;
                int i14 = r[i13];
                return new b((f.a(c2, 9 - i14, false) * n[i13]) + f.a(e2, i14, true) + p[i13], i12);
            }
            throw m.getNotFoundInstance();
        }
        if ((i9 & 1) == 0 && i9 <= 12 && i9 >= 4) {
            int i15 = (12 - i9) / 2;
            int i16 = q[i15];
            return new b((f.a(e2, i16, false) * f2474m[i15]) + f.a(c2, 9 - i16, true) + o[i15], i12);
        }
        throw m.getNotFoundInstance();
    }

    private int[] a(c.b.c.z.a aVar, int i2, boolean z) throws m {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int c2 = aVar.c();
        boolean z2 = false;
        while (i2 < c2) {
            z2 = !aVar.b(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < c2) {
            if (aVar.b(i2) ^ z2) {
                b2[i4] = b2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.b(b2)) {
                        return new int[]{i3, i2};
                    }
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                }
                b2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    private c a(c.b.c.z.a aVar, int i2, boolean z, int[] iArr) throws m {
        int i3;
        int i4;
        boolean b2 = aVar.b(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && (aVar.b(i5) ^ b2)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] b3 = b();
        System.arraycopy(b3, 0, b3, 1, b3.length - 1);
        b3[0] = i7;
        int a2 = a.a(b3, s);
        int i8 = iArr[1];
        if (z) {
            int c2 = (aVar.c() - 1) - i6;
            i3 = (aVar.c() - 1) - i8;
            i4 = c2;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new c(a2, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x003a, code lost:
    
        if (r1 < 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0054, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0053, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0051, code lost:
    
        if (r1 < 4) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r10, int r11) throws c.b.c.m {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.a0.e.a(boolean, int):void");
    }
}
