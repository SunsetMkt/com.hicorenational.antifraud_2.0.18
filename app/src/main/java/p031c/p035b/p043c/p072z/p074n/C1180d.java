package p031c.p035b.p043c.p072z.p074n;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder.java */
/* renamed from: c.b.c.z.n.d */
/* loaded from: classes.dex */
public final class C1180d {

    /* renamed from: a */
    private final C1177a f2467a;

    /* renamed from: b */
    private final List<C1178b> f2468b = new ArrayList();

    public C1180d(C1177a c1177a) {
        this.f2467a = c1177a;
        this.f2468b.add(new C1178b(c1177a, new int[]{1}));
    }

    /* renamed from: a */
    private C1178b m2255a(int i2) {
        if (i2 >= this.f2468b.size()) {
            List<C1178b> list = this.f2468b;
            C1178b c1178b = list.get(list.size() - 1);
            for (int size = this.f2468b.size(); size <= i2; size++) {
                C1177a c1177a = this.f2467a;
                c1178b = c1178b.m2249c(new C1178b(c1177a, new int[]{1, c1177a.m2233a((size - 1) + c1177a.m2232a())}));
                this.f2468b.add(c1178b);
            }
        }
        return this.f2468b.get(i2);
    }

    /* renamed from: a */
    public void m2256a(int[] iArr, int i2) {
        if (i2 != 0) {
            int length = iArr.length - i2;
            if (length > 0) {
                C1178b m2255a = m2255a(i2);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] m2244a = new C1178b(this.f2467a, iArr2).m2242a(i2, 1).m2247b(m2255a)[1].m2244a();
                int length2 = i2 - m2244a.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    iArr[length + i3] = 0;
                }
                System.arraycopy(m2244a, 0, iArr, length + length2, m2244a.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
