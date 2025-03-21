package p031c.p035b.p043c.p066x.p069f;

import java.util.Iterator;
import java.util.LinkedList;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: State.java */
/* renamed from: c.b.c.x.f.f */
/* loaded from: classes.dex */
final class C1123f {

    /* renamed from: e */
    static final C1123f f2271e = new C1123f(AbstractC1124g.f2276b, 0, 0, 0);

    /* renamed from: a */
    private final int f2272a;

    /* renamed from: b */
    private final AbstractC1124g f2273b;

    /* renamed from: c */
    private final int f2274c;

    /* renamed from: d */
    private final int f2275d;

    private C1123f(AbstractC1124g abstractC1124g, int i2, int i3, int i4) {
        this.f2273b = abstractC1124g;
        this.f2272a = i2;
        this.f2274c = i3;
        this.f2275d = i4;
    }

    /* renamed from: a */
    int m1989a() {
        return this.f2274c;
    }

    /* renamed from: b */
    int m1994b() {
        return this.f2275d;
    }

    /* renamed from: c */
    int m1997c() {
        return this.f2272a;
    }

    /* renamed from: d */
    AbstractC1124g m1998d() {
        return this.f2273b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", C1121d.f2258b[this.f2272a], Integer.valueOf(this.f2275d), Integer.valueOf(this.f2274c));
    }

    /* renamed from: a */
    C1123f m1991a(int i2, int i3) {
        int i4 = this.f2275d;
        AbstractC1124g abstractC1124g = this.f2273b;
        int i5 = this.f2272a;
        if (i2 != i5) {
            int i6 = C1121d.f2264h[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            abstractC1124g = abstractC1124g.m2000a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new C1123f(abstractC1124g.m2000a(i3, i9), i2, 0, i4 + i9);
    }

    /* renamed from: b */
    C1123f m1996b(int i2, int i3) {
        AbstractC1124g abstractC1124g = this.f2273b;
        int i4 = this.f2272a == 2 ? 4 : 5;
        return new C1123f(abstractC1124g.m2000a(C1121d.f2266j[this.f2272a][i2], i4).m2000a(i3, 5), this.f2272a, 0, this.f2275d + i4 + 5);
    }

    /* renamed from: b */
    C1123f m1995b(int i2) {
        int i3 = this.f2274c;
        return i3 == 0 ? this : new C1123f(this.f2273b.m2001b(i2 - i3, i3), this.f2272a, 0, this.f2275d);
    }

    /* renamed from: a */
    C1123f m1990a(int i2) {
        AbstractC1124g abstractC1124g = this.f2273b;
        int i3 = this.f2272a;
        int i4 = this.f2275d;
        if (i3 == 4 || i3 == 2) {
            int i5 = C1121d.f2264h[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            abstractC1124g = abstractC1124g.m2000a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f2274c;
        C1123f c1123f = new C1123f(abstractC1124g, i3, this.f2274c + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return c1123f.f2274c == 2078 ? c1123f.m1995b(i2 + 1) : c1123f;
    }

    /* renamed from: a */
    boolean m1993a(C1123f c1123f) {
        int i2;
        int i3 = this.f2275d + (C1121d.f2264h[this.f2272a][c1123f.f2272a] >> 16);
        int i4 = c1123f.f2274c;
        if (i4 > 0 && ((i2 = this.f2274c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= c1123f.f2275d;
    }

    /* renamed from: a */
    C1162a m1992a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (AbstractC1124g abstractC1124g = m1995b(bArr.length).f2273b; abstractC1124g != null; abstractC1124g = abstractC1124g.m1999a()) {
            linkedList.addFirst(abstractC1124g);
        }
        C1162a c1162a = new C1162a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((AbstractC1124g) it.next()).mo1971a(c1162a, bArr);
        }
        return c1162a;
    }
}
