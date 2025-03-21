package c.b.c.d0.a0.g;

import c.b.c.d0.a0.f;
import c.b.c.d0.a0.g.e.j;
import c.b.c.d0.q;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.r;
import c.b.c.t;
import com.luck.picture.lib.config.PictureConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.socialize.bean.HandlerRequestCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: RSSExpandedReader.java */
/* loaded from: classes.dex */
public final class d extends c.b.c.d0.a0.a {
    private static final int A = 11;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;

    /* renamed from: k, reason: collision with root package name */
    private final List<b> f2484k = new ArrayList(11);

    /* renamed from: l, reason: collision with root package name */
    private final List<c> f2485l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final int[] f2486m = new int[2];
    private boolean n;
    private static final int[] o = {7, 5, 4, 3, 1};
    private static final int[] p = {4, 20, 52, 104, 204};
    private static final int[] q = {0, 348, 1388, 2948, 3988};
    private static final int[][] r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 205}, new int[]{193, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, PictureConfig.CHOOSE_REQUEST, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, PictureConfig.PREVIEW_VIDEO_CODE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, util.c2.a.u0, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{161, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, com.hicorenational.antifraud.a.f5936e, 100, 89}};
    private static final int[][] z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private static boolean b(List<b> list) {
        boolean z2;
        for (int[] iArr : z) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z2 = true;
                        break;
                    }
                    if (list.get(i2).a().c() != iArr[i2]) {
                        z2 = false;
                        break;
                    }
                    i2++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void c(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private boolean h() {
        b bVar = this.f2484k.get(0);
        c.b.c.d0.a0.b b2 = bVar.b();
        c.b.c.d0.a0.b c2 = bVar.c();
        if (c2 == null) {
            return false;
        }
        int a2 = c2.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f2484k.size(); i3++) {
            b bVar2 = this.f2484k.get(i3);
            a2 += bVar2.b().a();
            i2++;
            c.b.c.d0.a0.b c3 = bVar2.c();
            if (c3 != null) {
                a2 += c3.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * util.c2.a.v0) + (a2 % util.c2.a.v0) == b2.b();
    }

    @Override // c.b.c.d0.q
    public r a(int i2, c.b.c.z.a aVar, Map<e, ?> map) throws m, h {
        this.f2484k.clear();
        this.n = false;
        try {
            return a(a(i2, aVar));
        } catch (m unused) {
            this.f2484k.clear();
            this.n = true;
            return a(a(i2, aVar));
        }
    }

    List<c> g() {
        return this.f2485l;
    }

    @Override // c.b.c.d0.q, c.b.c.p
    public void reset() {
        this.f2484k.clear();
        this.f2485l.clear();
    }

    private void b(c.b.c.z.a aVar, List<b> list, int i2) throws m {
        int[] b2 = b();
        b2[0] = 0;
        b2[1] = 0;
        b2[2] = 0;
        b2[3] = 0;
        int c2 = aVar.c();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).a().b()[1];
        }
        boolean z2 = list.size() % 2 != 0;
        if (this.n) {
            z2 = !z2;
        }
        boolean z3 = false;
        while (i2 < c2) {
            z3 = !aVar.b(i2);
            if (!z3) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < c2) {
            if (aVar.b(i2) ^ z3) {
                b2[i4] = b2[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z2) {
                        c(b2);
                    }
                    if (c.b.c.d0.a0.a.b(b2)) {
                        int[] iArr = this.f2486m;
                        iArr[0] = i3;
                        iArr[1] = i2;
                        return;
                    }
                    if (z2) {
                        c(b2);
                    }
                    i3 += b2[0] + b2[1];
                    b2[0] = b2[2];
                    b2[1] = b2[3];
                    b2[2] = 0;
                    b2[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                b2[i4] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    List<b> a(int i2, c.b.c.z.a aVar) throws m {
        while (true) {
            try {
                this.f2484k.add(a(aVar, this.f2484k, i2));
            } catch (m e2) {
                if (!this.f2484k.isEmpty()) {
                    if (h()) {
                        return this.f2484k;
                    }
                    boolean z2 = !this.f2485l.isEmpty();
                    a(i2, false);
                    if (z2) {
                        List<b> a2 = a(false);
                        if (a2 != null) {
                            return a2;
                        }
                        List<b> a3 = a(true);
                        if (a3 != null) {
                            return a3;
                        }
                    }
                    throw m.getNotFoundInstance();
                }
                throw e2;
            }
        }
    }

    private List<b> a(boolean z2) {
        List<b> list = null;
        if (this.f2485l.size() > 25) {
            this.f2485l.clear();
            return null;
        }
        this.f2484k.clear();
        if (z2) {
            Collections.reverse(this.f2485l);
        }
        try {
            list = a(new ArrayList(), 0);
        } catch (m unused) {
        }
        if (z2) {
            Collections.reverse(this.f2485l);
        }
        return list;
    }

    private List<b> a(List<c> list, int i2) throws m {
        while (i2 < this.f2485l.size()) {
            c cVar = this.f2485l.get(i2);
            this.f2484k.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f2484k.addAll(list.get(i3).a());
            }
            this.f2484k.addAll(cVar.a());
            if (b(this.f2484k)) {
                if (h()) {
                    return this.f2484k;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return a(arrayList, i2 + 1);
                } catch (m unused) {
                    continue;
                }
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    private void a(int i2, boolean z2) {
        boolean z3 = false;
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 >= this.f2485l.size()) {
                break;
            }
            c cVar = this.f2485l.get(i3);
            if (cVar.b() > i2) {
                z3 = cVar.a(this.f2484k);
                break;
            } else {
                z4 = cVar.a(this.f2484k);
                i3++;
            }
        }
        if (z3 || z4 || a((Iterable<b>) this.f2484k, (Iterable<c>) this.f2485l)) {
            return;
        }
        this.f2485l.add(i3, new c(this.f2484k, i2, z2));
        a(this.f2484k, this.f2485l);
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z2;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z2 = false;
                    boolean z3 = true;
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z3 = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                    if (!z3) {
                        break;
                    }
                }
                if (z2) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z2;
        boolean z3;
        Iterator<c> it = iterable2.iterator();
        do {
            z2 = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z3 = true;
                        break;
                    }
                }
                if (!z3) {
                    break;
                }
            }
        } while (!z2);
        return true;
    }

    static r a(List<b> list) throws m, h {
        String c2 = j.a(a.a(list)).c();
        t[] a2 = list.get(0).a().a();
        t[] a3 = list.get(list.size() - 1).a().a();
        return new r(c2, null, new t[]{a2[0], a2[1], a3[0], a3[1]}, c.b.c.a.RSS_EXPANDED);
    }

    private static int a(c.b.c.z.a aVar, int i2) {
        if (aVar.b(i2)) {
            return aVar.c(aVar.d(i2));
        }
        return aVar.d(aVar.c(i2));
    }

    b a(c.b.c.z.a aVar, List<b> list, int i2) throws m {
        c.b.c.d0.a0.c a2;
        c.b.c.d0.a0.b bVar;
        boolean z2 = list.size() % 2 == 0;
        if (this.n) {
            z2 = !z2;
        }
        int i3 = -1;
        boolean z3 = true;
        do {
            b(aVar, list, i3);
            a2 = a(aVar, i2, z2);
            if (a2 == null) {
                i3 = a(aVar, this.f2486m[0]);
            } else {
                z3 = false;
            }
        } while (z3);
        c.b.c.d0.a0.b a3 = a(aVar, a2, z2, true);
        if (!list.isEmpty() && list.get(list.size() - 1).e()) {
            throw m.getNotFoundInstance();
        }
        try {
            bVar = a(aVar, a2, z2, false);
        } catch (m unused) {
            bVar = null;
        }
        return new b(a3, bVar, a2, true);
    }

    private c.b.c.d0.a0.c a(c.b.c.z.a aVar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        if (z2) {
            int i6 = this.f2486m[0] - 1;
            while (i6 >= 0 && !aVar.b(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f2486m;
            int i8 = iArr[0] - i7;
            i4 = iArr[1];
            i5 = i7;
            i3 = i8;
        } else {
            int[] iArr2 = this.f2486m;
            int i9 = iArr2[0];
            int d2 = aVar.d(iArr2[1] + 1);
            i3 = d2 - this.f2486m[1];
            i4 = d2;
            i5 = i9;
        }
        int[] b2 = b();
        System.arraycopy(b2, 0, b2, 1, b2.length - 1);
        b2[0] = i3;
        try {
            return new c.b.c.d0.a0.c(c.b.c.d0.a0.a.a(b2, r), new int[]{i5, i4}, i5, i4, i2);
        } catch (m unused) {
            return null;
        }
    }

    c.b.c.d0.a0.b a(c.b.c.z.a aVar, c.b.c.d0.a0.c cVar, boolean z2, boolean z3) throws m {
        int[] a2 = a();
        a2[0] = 0;
        a2[1] = 0;
        a2[2] = 0;
        a2[3] = 0;
        a2[4] = 0;
        a2[5] = 0;
        a2[6] = 0;
        a2[7] = 0;
        if (z3) {
            q.b(aVar, cVar.b()[0], a2);
        } else {
            q.a(aVar, cVar.b()[1], a2);
            int i2 = 0;
            for (int length = a2.length - 1; i2 < length; length--) {
                int i3 = a2[i2];
                a2[i2] = a2[length];
                a2[length] = i3;
                i2++;
            }
        }
        float a3 = c.b.c.d0.a0.a.a(a2) / 17;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(a3 - f2) / f2 <= 0.3f) {
            int[] e2 = e();
            int[] c2 = c();
            float[] f3 = f();
            float[] d2 = d();
            for (int i4 = 0; i4 < a2.length; i4++) {
                float f4 = (a2[i4] * 1.0f) / a3;
                int i5 = (int) (0.5f + f4);
                if (i5 < 1) {
                    if (f4 < 0.3f) {
                        throw m.getNotFoundInstance();
                    }
                    i5 = 1;
                } else if (i5 > 8) {
                    if (f4 > 8.7f) {
                        throw m.getNotFoundInstance();
                    }
                    i5 = 8;
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    e2[i6] = i5;
                    f3[i6] = f4 - i5;
                } else {
                    c2[i6] = i5;
                    d2[i6] = f4 - i5;
                }
            }
            a(17);
            int c3 = (((cVar.c() * 4) + (z2 ? 0 : 2)) + (!z3 ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = e2.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z2, z3)) {
                    i7 += e2[length2] * s[c3][length2 * 2];
                }
                i8 += e2[length2];
            }
            int i9 = 0;
            for (int length3 = c2.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z2, z3)) {
                    i9 += c2[length3] * s[c3][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) == 0 && i8 <= 13 && i8 >= 4) {
                int i11 = (13 - i8) / 2;
                int i12 = o[i11];
                return new c.b.c.d0.a0.b((f.a(e2, i12, true) * p[i11]) + f.a(c2, 9 - i12, false) + q[i11], i10);
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static boolean a(c.b.c.d0.a0.c cVar, boolean z2, boolean z3) {
        return (cVar.c() == 0 && z2 && z3) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r11) throws c.b.c.m {
        /*
            r10 = this;
            int[] r0 = r10.e()
            int r0 = c.b.c.d0.a0.a.a(r0)
            int[] r1 = r10.c()
            int r1 = c.b.c.d0.a0.a.a(r1)
            int r2 = r0 + r1
            int r2 = r2 - r11
            r11 = r0 & 1
            r3 = 0
            r4 = 1
            if (r11 != r4) goto L1b
            r11 = 1
            goto L1c
        L1b:
            r11 = 0
        L1c:
            r5 = r1 & 1
            if (r5 != 0) goto L22
            r5 = 1
            goto L23
        L22:
            r5 = 0
        L23:
            r6 = 4
            r7 = 13
            if (r0 <= r7) goto L2b
            r8 = 0
            r9 = 1
            goto L31
        L2b:
            if (r0 >= r6) goto L2f
            r8 = 1
            goto L30
        L2f:
            r8 = 0
        L30:
            r9 = 0
        L31:
            if (r1 <= r7) goto L35
            r6 = 1
            goto L39
        L35:
            if (r1 >= r6) goto L38
            r3 = 1
        L38:
            r6 = 0
        L39:
            if (r2 != r4) goto L4f
            if (r11 == 0) goto L46
            if (r5 != 0) goto L41
        L3f:
            r9 = 1
            goto L79
        L41:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L46:
            if (r5 == 0) goto L4a
            r6 = 1
            goto L79
        L4a:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L4f:
            r7 = -1
            if (r2 != r7) goto L66
            if (r11 == 0) goto L5d
            if (r5 != 0) goto L58
        L56:
            r8 = 1
            goto L79
        L58:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L5d:
            if (r5 == 0) goto L61
            r3 = 1
            goto L79
        L61:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L66:
            if (r2 != 0) goto Lc3
            if (r11 == 0) goto L77
            if (r5 == 0) goto L72
            if (r0 >= r1) goto L70
            r6 = 1
            goto L56
        L70:
            r3 = 1
            goto L3f
        L72:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L77:
            if (r5 != 0) goto Lbe
        L79:
            if (r8 == 0) goto L8e
            if (r9 != 0) goto L89
            int[] r11 = r10.e()
            float[] r0 = r10.f()
            c.b.c.d0.a0.a.b(r11, r0)
            goto L8e
        L89:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        L8e:
            if (r9 == 0) goto L9b
            int[] r11 = r10.e()
            float[] r0 = r10.f()
            c.b.c.d0.a0.a.a(r11, r0)
        L9b:
            if (r3 == 0) goto Lb0
            if (r6 != 0) goto Lab
            int[] r11 = r10.c()
            float[] r0 = r10.f()
            c.b.c.d0.a0.a.b(r11, r0)
            goto Lb0
        Lab:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        Lb0:
            if (r6 == 0) goto Lbd
            int[] r11 = r10.c()
            float[] r0 = r10.d()
            c.b.c.d0.a0.a.a(r11, r0)
        Lbd:
            return
        Lbe:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        Lc3:
            c.b.c.m r11 = c.b.c.m.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.a0.g.d.a(int):void");
    }
}
