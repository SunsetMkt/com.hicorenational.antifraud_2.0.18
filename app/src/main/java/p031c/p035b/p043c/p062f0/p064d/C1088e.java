package p031c.p035b.p043c.p062f0.p064d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: FinderPatternFinder.java */
/* renamed from: c.b.c.f0.d.e */
/* loaded from: classes.dex */
public class C1088e {

    /* renamed from: f */
    private static final int f2160f = 2;

    /* renamed from: g */
    protected static final int f2161g = 3;

    /* renamed from: h */
    protected static final int f2162h = 57;

    /* renamed from: a */
    private final C1163b f2163a;

    /* renamed from: b */
    private final List<C1087d> f2164b;

    /* renamed from: c */
    private boolean f2165c;

    /* renamed from: d */
    private final int[] f2166d;

    /* renamed from: e */
    private final InterfaceC1110u f2167e;

    /* compiled from: FinderPatternFinder.java */
    /* renamed from: c.b.c.f0.d.e$b */
    private static final class b implements Comparator<C1087d>, Serializable {
        private final float average;

        private b(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(C1087d c1087d, C1087d c1087d2) {
            if (c1087d2.m1806c() != c1087d.m1806c()) {
                return c1087d2.m1806c() - c1087d.m1806c();
            }
            float abs = Math.abs(c1087d2.m1807d() - this.average);
            float abs2 = Math.abs(c1087d.m1807d() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    /* compiled from: FinderPatternFinder.java */
    /* renamed from: c.b.c.f0.d.e$c */
    private static final class c implements Comparator<C1087d>, Serializable {
        private final float average;

        private c(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(C1087d c1087d, C1087d c1087d2) {
            float abs = Math.abs(c1087d2.m1807d() - this.average);
            float abs2 = Math.abs(c1087d.m1807d() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public C1088e(C1163b c1163b) {
        this(c1163b, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.m2173b(r12, r3) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.m2173b(r12, r11) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.m2173b(r12, r11) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.m2173b(r12, r11) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b9, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
    
        if (m1810a(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
    
        return m1808a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float m1812c(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 199
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p064d.C1088e.m1812c(int, int, int, int):float");
    }

    /* renamed from: d */
    private int[] m1814d() {
        int[] iArr = this.f2166d;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    /* renamed from: e */
    private boolean m1815e() {
        int size = this.f2164b.size();
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        for (C1087d c1087d : this.f2164b) {
            if (c1087d.m1806c() >= 2) {
                i2++;
                f3 += c1087d.m1807d();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / size;
        Iterator<C1087d> it = this.f2164b.iterator();
        while (it.hasNext()) {
            f2 += Math.abs(it.next().m1807d() - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    /* renamed from: f */
    private C1087d[] m1816f() throws C1102m {
        int size = this.f2164b.size();
        if (size < 3) {
            throw C1102m.getNotFoundInstance();
        }
        float f2 = 0.0f;
        if (size > 3) {
            Iterator<C1087d> it = this.f2164b.iterator();
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (it.hasNext()) {
                float m1807d = it.next().m1807d();
                f3 += m1807d;
                f4 += m1807d * m1807d;
            }
            float f5 = f3 / size;
            float sqrt = (float) Math.sqrt((f4 / r0) - (f5 * f5));
            Collections.sort(this.f2164b, new c(f5));
            float max = Math.max(0.2f * f5, sqrt);
            int i2 = 0;
            while (i2 < this.f2164b.size() && this.f2164b.size() > 3) {
                if (Math.abs(this.f2164b.get(i2).m1807d() - f5) > max) {
                    this.f2164b.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.f2164b.size() > 3) {
            Iterator<C1087d> it2 = this.f2164b.iterator();
            while (it2.hasNext()) {
                f2 += it2.next().m1807d();
            }
            Collections.sort(this.f2164b, new b(f2 / this.f2164b.size()));
            List<C1087d> list = this.f2164b;
            list.subList(3, list.size()).clear();
        }
        return new C1087d[]{this.f2164b.get(0), this.f2164b.get(1), this.f2164b.get(2)};
    }

    /* renamed from: a */
    protected final C1163b m1818a() {
        return this.f2163a;
    }

    /* renamed from: b */
    protected final List<C1087d> m1820b() {
        return this.f2164b;
    }

    public C1088e(C1163b c1163b, InterfaceC1110u interfaceC1110u) {
        this.f2163a = c1163b;
        this.f2164b = new ArrayList();
        this.f2166d = new int[5];
        this.f2167e = interfaceC1110u;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.m2173b(r3, r12) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.m2173b(r11, r12) == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.m2173b(r11, r12) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.m2173b(r11, r12) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (m1810a(r2) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c4, code lost:
    
        return m1808a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return Float.NaN;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float m1811b(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p064d.C1088e.m1811b(int, int, int, int):float");
    }

    /* renamed from: a */
    final C1089f m1817a(Map<EnumC1044e, ?> map) throws C1102m {
        boolean z = map != null && map.containsKey(EnumC1044e.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(EnumC1044e.PURE_BARCODE);
        int m2177d = this.f2163a.m2177d();
        int m2181g = this.f2163a.m2181g();
        int i2 = (m2177d * 3) / 228;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        int i4 = i2;
        boolean z3 = false;
        while (i3 < m2177d && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean z4 = z3;
            int i5 = i4;
            int i6 = 0;
            int i7 = 0;
            while (i6 < m2181g) {
                if (this.f2163a.m2173b(i6, i3)) {
                    if ((i7 & 1) == 1) {
                        i7++;
                    }
                    iArr[i7] = iArr[i7] + 1;
                } else if ((i7 & 1) != 0) {
                    iArr[i7] = iArr[i7] + 1;
                } else if (i7 == 4) {
                    if (!m1810a(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (m1819a(iArr, i3, i6, z2)) {
                        if (this.f2165c) {
                            z4 = m1815e();
                        } else {
                            int m1813c = m1813c();
                            if (m1813c > iArr[2]) {
                                i3 += (m1813c - iArr[2]) - 2;
                                i6 = m2181g - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i7 = 0;
                        i5 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i7 = 3;
                } else {
                    i7++;
                    iArr[i7] = iArr[i7] + 1;
                }
                i6++;
            }
            if (m1810a(iArr) && m1819a(iArr, i3, m2181g, z2)) {
                int i8 = iArr[0];
                if (this.f2165c) {
                    i4 = i8;
                    z3 = m1815e();
                    i3 += i4;
                } else {
                    i4 = i8;
                }
            } else {
                i4 = i5;
            }
            z3 = z4;
            i3 += i4;
        }
        C1087d[] m1816f = m1816f();
        C1109t.m1921a(m1816f);
        return new C1089f(m1816f);
    }

    /* renamed from: c */
    private int m1813c() {
        if (this.f2164b.size() <= 1) {
            return 0;
        }
        C1087d c1087d = null;
        for (C1087d c1087d2 : this.f2164b) {
            if (c1087d2.m1806c() >= 2) {
                if (c1087d != null) {
                    this.f2165c = true;
                    return ((int) (Math.abs(c1087d.m1922a() - c1087d2.m1922a()) - Math.abs(c1087d.m1923b() - c1087d2.m1923b()))) / 2;
                }
                c1087d = c1087d2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static float m1808a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* renamed from: a */
    protected static boolean m1810a(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r18 >= r6) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r17 < r6) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r18 < r6) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r16.f2163a.m2173b(r18 - r6, r17 - r6) != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r4[1] > r19) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        r4[1] = r4[1] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r17 < r6) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r18 < r6) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r4[1] <= r19) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r17 < r6) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r18 < r6) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r16.f2163a.m2173b(r18 - r6, r17 - r6) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if (r4[0] > r19) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r4[0] = r4[0] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r4[0] <= r19) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        r6 = r16.f2163a.m2177d();
        r9 = r16.f2163a.m2181g();
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
    
        if (r11 >= r6) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r12 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r12 >= r9) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r16.f2163a.m2173b(r12, r11) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        r4[2] = r4[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        if (r11 >= r6) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
    
        if ((r18 + r10) < r9) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
    
        if (r11 >= r6) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        r13 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a9, code lost:
    
        if (r13 >= r9) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
    
        if (r16.f2163a.m2173b(r13, r11) != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b5, code lost:
    
        if (r4[3] >= r19) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b7, code lost:
    
        r4[3] = r4[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bf, code lost:
    
        if (r11 >= r6) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c3, code lost:
    
        if ((r18 + r10) >= r9) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c7, code lost:
    
        if (r4[3] < r19) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ca, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cd, code lost:
    
        if (r11 >= r6) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        r14 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r14 >= r9) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d9, code lost:
    
        if (r16.f2163a.m2173b(r14, r11) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        if (r4[4] >= r19) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00df, code lost:
    
        r4[4] = r4[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e9, code lost:
    
        if (r4[4] < r19) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00eb, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0102, code lost:
    
        if (java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r20) >= (r20 * 2)) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0108, code lost:
    
        if (m1810a(r4) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return false;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1809a(int r17, int r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p064d.C1088e.m1809a(int, int, int, int):boolean");
    }

    /* renamed from: a */
    protected final boolean m1819a(int[] iArr, int i2, int i3, boolean z) {
        boolean z2 = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int m1808a = (int) m1808a(iArr, i3);
        float m1812c = m1812c(i2, m1808a, iArr[2], i4);
        if (!Float.isNaN(m1812c)) {
            int i5 = (int) m1812c;
            float m1811b = m1811b(m1808a, i5, iArr[2], i4);
            if (!Float.isNaN(m1811b) && (!z || m1809a(i5, (int) m1811b, iArr[2], i4))) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f2164b.size()) {
                        break;
                    }
                    C1087d c1087d = this.f2164b.get(i6);
                    if (c1087d.m1804a(f2, m1812c, m1811b)) {
                        this.f2164b.set(i6, c1087d.m1805b(m1812c, m1811b, f2));
                        z2 = true;
                        break;
                    }
                    i6++;
                }
                if (!z2) {
                    C1087d c1087d2 = new C1087d(m1811b, m1812c, f2);
                    this.f2164b.add(c1087d2);
                    InterfaceC1110u interfaceC1110u = this.f2167e;
                    if (interfaceC1110u != null) {
                        interfaceC1110u.mo1924a(c1087d2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
