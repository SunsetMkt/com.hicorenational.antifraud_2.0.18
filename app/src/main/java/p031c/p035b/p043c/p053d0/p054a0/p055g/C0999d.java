package p031c.p035b.p043c.p053d0.p054a0.p055g;

import com.hicorenational.antifraud.C2114a;
import com.luck.picture.lib.config.PictureConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.socialize.bean.HandlerRequestCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p053d0.AbstractC1034q;
import p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a;
import p031c.p035b.p043c.p053d0.p054a0.C0991b;
import p031c.p035b.p043c.p053d0.p054a0.C0992c;
import p031c.p035b.p043c.p053d0.p054a0.C0995f;
import p031c.p035b.p043c.p053d0.p054a0.p055g.p056e.AbstractC1009j;
import p031c.p035b.p043c.p072z.C1162a;
import util.p395c2.C7265a;

/* compiled from: RSSExpandedReader.java */
/* renamed from: c.b.c.d0.a0.g.d */
/* loaded from: classes.dex */
public final class C0999d extends AbstractC0990a {

    /* renamed from: A */
    private static final int f1817A = 11;

    /* renamed from: t */
    private static final int f1823t = 0;

    /* renamed from: u */
    private static final int f1824u = 1;

    /* renamed from: v */
    private static final int f1825v = 2;

    /* renamed from: w */
    private static final int f1826w = 3;

    /* renamed from: x */
    private static final int f1827x = 4;

    /* renamed from: y */
    private static final int f1828y = 5;

    /* renamed from: k */
    private final List<C0997b> f1830k = new ArrayList(11);

    /* renamed from: l */
    private final List<C0998c> f1831l = new ArrayList();

    /* renamed from: m */
    private final int[] f1832m = new int[2];

    /* renamed from: n */
    private boolean f1833n;

    /* renamed from: o */
    private static final int[] f1818o = {7, 5, 4, 3, 1};

    /* renamed from: p */
    private static final int[] f1819p = {4, 20, 52, 104, 204};

    /* renamed from: q */
    private static final int[] f1820q = {0, 348, 1388, 2948, 3988};

    /* renamed from: r */
    private static final int[][] f1821r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: s */
    private static final int[][] f1822s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 205}, new int[]{193, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, PictureConfig.CHOOSE_REQUEST, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, PictureConfig.PREVIEW_VIDEO_CODE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, C7265a.f25265u0, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{161, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, C2114a.f6308e, 100, 89}};

    /* renamed from: z */
    private static final int[][] f1829z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: b */
    private static boolean m1419b(List<C0997b> list) {
        boolean z;
        for (int[] iArr : f1829z) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i2).m1399a().m1382c() != iArr[i2]) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private static void m1420c(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    /* renamed from: h */
    private boolean m1421h() {
        C0997b c0997b = this.f1830k.get(0);
        C0991b m1400b = c0997b.m1400b();
        C0991b m1401c = c0997b.m1401c();
        if (m1401c == null) {
            return false;
        }
        int m1378a = m1401c.m1378a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.f1830k.size(); i3++) {
            C0997b c0997b2 = this.f1830k.get(i3);
            m1378a += c0997b2.m1400b().m1378a();
            i2++;
            C0991b m1401c2 = c0997b2.m1401c();
            if (m1401c2 != null) {
                m1378a += m1401c2.m1378a();
                i2++;
            }
        }
        return ((i2 + (-4)) * C7265a.f25267v0) + (m1378a % C7265a.f25267v0) == m1400b.m1379b();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m, C1097h {
        this.f1830k.clear();
        this.f1833n = false;
        try {
            return m1410a(m1424a(i2, c1162a));
        } catch (C1102m unused) {
            this.f1830k.clear();
            this.f1833n = true;
            return m1410a(m1424a(i2, c1162a));
        }
    }

    /* renamed from: g */
    List<C0998c> m1425g() {
        return this.f1831l;
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        this.f1830k.clear();
        this.f1831l.clear();
    }

    /* renamed from: b */
    private void m1418b(C1162a c1162a, List<C0997b> list, int i2) throws C1102m {
        int[] m1373b = m1373b();
        m1373b[0] = 0;
        m1373b[1] = 0;
        m1373b[2] = 0;
        m1373b[3] = 0;
        int m2157c = c1162a.m2157c();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).m1399a().m1381b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.f1833n) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < m2157c) {
            z2 = !c1162a.m2155b(i2);
            if (!z2) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < m2157c) {
            if (c1162a.m2155b(i2) ^ z2) {
                m1373b[i4] = m1373b[i4] + 1;
            } else {
                if (i4 == 3) {
                    if (z) {
                        m1420c(m1373b);
                    }
                    if (AbstractC0990a.m1371b(m1373b)) {
                        int[] iArr = this.f1832m;
                        iArr[0] = i3;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        m1420c(m1373b);
                    }
                    i3 += m1373b[0] + m1373b[1];
                    m1373b[0] = m1373b[2];
                    m1373b[1] = m1373b[3];
                    m1373b[2] = 0;
                    m1373b[3] = 0;
                    i4--;
                } else {
                    i4++;
                }
                m1373b[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    List<C0997b> m1424a(int i2, C1162a c1162a) throws C1102m {
        while (true) {
            try {
                this.f1830k.add(m1423a(c1162a, this.f1830k, i2));
            } catch (C1102m e2) {
                if (!this.f1830k.isEmpty()) {
                    if (m1421h()) {
                        return this.f1830k;
                    }
                    boolean z = !this.f1831l.isEmpty();
                    m1414a(i2, false);
                    if (z) {
                        List<C0997b> m1412a = m1412a(false);
                        if (m1412a != null) {
                            return m1412a;
                        }
                        List<C0997b> m1412a2 = m1412a(true);
                        if (m1412a2 != null) {
                            return m1412a2;
                        }
                    }
                    throw C1102m.getNotFoundInstance();
                }
                throw e2;
            }
        }
    }

    /* renamed from: a */
    private List<C0997b> m1412a(boolean z) {
        List<C0997b> list = null;
        if (this.f1831l.size() > 25) {
            this.f1831l.clear();
            return null;
        }
        this.f1830k.clear();
        if (z) {
            Collections.reverse(this.f1831l);
        }
        try {
            list = m1411a(new ArrayList(), 0);
        } catch (C1102m unused) {
        }
        if (z) {
            Collections.reverse(this.f1831l);
        }
        return list;
    }

    /* renamed from: a */
    private List<C0997b> m1411a(List<C0998c> list, int i2) throws C1102m {
        while (i2 < this.f1831l.size()) {
            C0998c c0998c = this.f1831l.get(i2);
            this.f1830k.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f1830k.addAll(list.get(i3).m1404a());
            }
            this.f1830k.addAll(c0998c.m1404a());
            if (m1419b(this.f1830k)) {
                if (m1421h()) {
                    return this.f1830k;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(c0998c);
                try {
                    return m1411a(arrayList, i2 + 1);
                } catch (C1102m unused) {
                    continue;
                }
            }
            i2++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private void m1414a(int i2, boolean z) {
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= this.f1831l.size()) {
                break;
            }
            C0998c c0998c = this.f1831l.get(i3);
            if (c0998c.m1406b() > i2) {
                z2 = c0998c.m1405a(this.f1830k);
                break;
            } else {
                z3 = c0998c.m1405a(this.f1830k);
                i3++;
            }
        }
        if (z2 || z3 || m1417a((Iterable<C0997b>) this.f1830k, (Iterable<C0998c>) this.f1831l)) {
            return;
        }
        this.f1831l.add(i3, new C0998c(this.f1830k, i2, z));
        m1415a(this.f1830k, this.f1831l);
    }

    /* renamed from: a */
    private static void m1415a(List<C0997b> list, List<C0998c> list2) {
        boolean z;
        Iterator<C0998c> it = list2.iterator();
        while (it.hasNext()) {
            C0998c next = it.next();
            if (next.m1404a().size() != list.size()) {
                Iterator<C0997b> it2 = next.m1404a().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    C0997b next2 = it2.next();
                    Iterator<C0997b> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m1417a(Iterable<C0997b> iterable, Iterable<C0998c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<C0998c> it = iterable2.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            C0998c next = it.next();
            Iterator<C0997b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                C0997b next2 = it2.next();
                Iterator<C0997b> it3 = next.m1404a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    /* renamed from: a */
    static C1107r m1410a(List<C0997b> list) throws C1102m, C1097h {
        String mo1428c = AbstractC1009j.m1434a(C0996a.m1396a(list)).mo1428c();
        C1109t[] m1380a = list.get(0).m1399a().m1380a();
        C1109t[] m1380a2 = list.get(list.size() - 1).m1399a().m1380a();
        return new C1107r(mo1428c, null, new C1109t[]{m1380a[0], m1380a[1], m1380a2[0], m1380a2[1]}, EnumC0953a.RSS_EXPANDED);
    }

    /* renamed from: a */
    private static int m1408a(C1162a c1162a, int i2) {
        if (c1162a.m2155b(i2)) {
            return c1162a.m2158c(c1162a.m2161d(i2));
        }
        return c1162a.m2161d(c1162a.m2158c(i2));
    }

    /* renamed from: a */
    C0997b m1423a(C1162a c1162a, List<C0997b> list, int i2) throws C1102m {
        C0992c m1409a;
        C0991b c0991b;
        boolean z = list.size() % 2 == 0;
        if (this.f1833n) {
            z = !z;
        }
        int i3 = -1;
        boolean z2 = true;
        do {
            m1418b(c1162a, list, i3);
            m1409a = m1409a(c1162a, i2, z);
            if (m1409a == null) {
                i3 = m1408a(c1162a, this.f1832m[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        C0991b m1422a = m1422a(c1162a, m1409a, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).m1403e()) {
            throw C1102m.getNotFoundInstance();
        }
        try {
            c0991b = m1422a(c1162a, m1409a, z, false);
        } catch (C1102m unused) {
            c0991b = null;
        }
        return new C0997b(m1422a, c0991b, m1409a, true);
    }

    /* renamed from: a */
    private C0992c m1409a(C1162a c1162a, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.f1832m[0] - 1;
            while (i6 >= 0 && !c1162a.m2155b(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.f1832m;
            int i8 = iArr[0] - i7;
            i4 = iArr[1];
            i5 = i7;
            i3 = i8;
        } else {
            int[] iArr2 = this.f1832m;
            int i9 = iArr2[0];
            int m2161d = c1162a.m2161d(iArr2[1] + 1);
            i3 = m2161d - this.f1832m[1];
            i4 = m2161d;
            i5 = i9;
        }
        int[] m1373b = m1373b();
        System.arraycopy(m1373b, 0, m1373b, 1, m1373b.length - 1);
        m1373b[0] = i3;
        try {
            return new C0992c(AbstractC0990a.m1368a(m1373b, f1821r), new int[]{i5, i4}, i5, i4, i2);
        } catch (C1102m unused) {
            return null;
        }
    }

    /* renamed from: a */
    C0991b m1422a(C1162a c1162a, C0992c c0992c, boolean z, boolean z2) throws C1102m {
        int[] m1372a = m1372a();
        m1372a[0] = 0;
        m1372a[1] = 0;
        m1372a[2] = 0;
        m1372a[3] = 0;
        m1372a[4] = 0;
        m1372a[5] = 0;
        m1372a[6] = 0;
        m1372a[7] = 0;
        if (z2) {
            AbstractC1034q.m1511b(c1162a, c0992c.m1381b()[0], m1372a);
        } else {
            AbstractC1034q.m1509a(c1162a, c0992c.m1381b()[1], m1372a);
            int i2 = 0;
            for (int length = m1372a.length - 1; i2 < length; length--) {
                int i3 = m1372a[i2];
                m1372a[i2] = m1372a[length];
                m1372a[length] = i3;
                i2++;
            }
        }
        float m1367a = AbstractC0990a.m1367a(m1372a) / 17;
        float f2 = (c0992c.m1381b()[1] - c0992c.m1381b()[0]) / 15.0f;
        if (Math.abs(m1367a - f2) / f2 <= 0.3f) {
            int[] m1376e = m1376e();
            int[] m1374c = m1374c();
            float[] m1377f = m1377f();
            float[] m1375d = m1375d();
            for (int i4 = 0; i4 < m1372a.length; i4++) {
                float f3 = (m1372a[i4] * 1.0f) / m1367a;
                int i5 = (int) (0.5f + f3);
                if (i5 < 1) {
                    if (f3 < 0.3f) {
                        throw C1102m.getNotFoundInstance();
                    }
                    i5 = 1;
                } else if (i5 > 8) {
                    if (f3 > 8.7f) {
                        throw C1102m.getNotFoundInstance();
                    }
                    i5 = 8;
                }
                int i6 = i4 / 2;
                if ((i4 & 1) == 0) {
                    m1376e[i6] = i5;
                    m1377f[i6] = f3 - i5;
                } else {
                    m1374c[i6] = i5;
                    m1375d[i6] = f3 - i5;
                }
            }
            m1413a(17);
            int m1382c = (((c0992c.m1382c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
            int i7 = 0;
            int i8 = 0;
            for (int length2 = m1376e.length - 1; length2 >= 0; length2--) {
                if (m1416a(c0992c, z, z2)) {
                    i7 += m1376e[length2] * f1822s[m1382c][length2 * 2];
                }
                i8 += m1376e[length2];
            }
            int i9 = 0;
            for (int length3 = m1374c.length - 1; length3 >= 0; length3--) {
                if (m1416a(c0992c, z, z2)) {
                    i9 += m1374c[length3] * f1822s[m1382c][(length3 * 2) + 1];
                }
            }
            int i10 = i7 + i9;
            if ((i8 & 1) == 0 && i8 <= 13 && i8 >= 4) {
                int i11 = (13 - i8) / 2;
                int i12 = f1818o[i11];
                return new C0991b((C0995f.m1395a(m1376e, i12, true) * f1819p[i11]) + C0995f.m1395a(m1374c, 9 - i12, false) + f1820q[i11], i10);
            }
            throw C1102m.getNotFoundInstance();
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static boolean m1416a(C0992c c0992c, boolean z, boolean z2) {
        return (c0992c.m1382c() == 0 && z && z2) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1413a(int r11) throws p031c.p035b.p043c.C1102m {
        /*
            r10 = this;
            int[] r0 = r10.m1376e()
            int r0 = p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1367a(r0)
            int[] r1 = r10.m1374c()
            int r1 = p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1367a(r1)
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
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        L46:
            if (r5 == 0) goto L4a
            r6 = 1
            goto L79
        L4a:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
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
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        L5d:
            if (r5 == 0) goto L61
            r3 = 1
            goto L79
        L61:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
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
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        L77:
            if (r5 != 0) goto Lbe
        L79:
            if (r8 == 0) goto L8e
            if (r9 != 0) goto L89
            int[] r11 = r10.m1376e()
            float[] r0 = r10.m1377f()
            p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1370b(r11, r0)
            goto L8e
        L89:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        L8e:
            if (r9 == 0) goto L9b
            int[] r11 = r10.m1376e()
            float[] r0 = r10.m1377f()
            p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1369a(r11, r0)
        L9b:
            if (r3 == 0) goto Lb0
            if (r6 != 0) goto Lab
            int[] r11 = r10.m1374c()
            float[] r0 = r10.m1377f()
            p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1370b(r11, r0)
            goto Lb0
        Lab:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        Lb0:
            if (r6 == 0) goto Lbd
            int[] r11 = r10.m1374c()
            float[] r0 = r10.m1375d()
            p031c.p035b.p043c.p053d0.p054a0.AbstractC0990a.m1369a(r11, r0)
        Lbd:
            return
        Lbe:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        Lc3:
            c.b.c.m r11 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p053d0.p054a0.p055g.C0999d.m1413a(int):void");
    }
}
