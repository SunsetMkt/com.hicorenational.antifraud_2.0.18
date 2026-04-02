package d.b.c.x.f;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: State.java */
/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final f f9892e = new f(g.f9896b, 0, 0, 0);
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f9893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9895d;

    private f(g gVar, int i2, int i3, int i4) {
        this.f9893b = gVar;
        this.a = i2;
        this.f9894c = i3;
        this.f9895d = i4;
    }

    int a() {
        return this.f9894c;
    }

    int b() {
        return this.f9895d;
    }

    int c() {
        return this.a;
    }

    g d() {
        return this.f9893b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f9881b[this.a], Integer.valueOf(this.f9895d), Integer.valueOf(this.f9894c));
    }

    f a(int i2, int i3) {
        int i4 = this.f9895d;
        g gVarA = this.f9893b;
        int i5 = this.a;
        if (i2 != i5) {
            int i6 = d.f9887h[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVarA = gVarA.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVarA.a(i3, i9), i2, 0, i4 + i9);
    }

    f b(int i2, int i3) {
        g gVar = this.f9893b;
        int i4 = this.a == 2 ? 4 : 5;
        return new f(gVar.a(d.f9889j[this.a][i2], i4).a(i3, 5), this.a, 0, this.f9895d + i4 + 5);
    }

    f b(int i2) {
        int i3 = this.f9894c;
        return i3 == 0 ? this : new f(this.f9893b.b(i2 - i3, i3), this.a, 0, this.f9895d);
    }

    f a(int i2) {
        g gVarA = this.f9893b;
        int i3 = this.a;
        int i4 = this.f9895d;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.f9887h[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVarA = gVarA.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.f9894c;
        f fVar = new f(gVarA, i3, this.f9894c + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.f9894c == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    boolean a(f fVar) {
        int i2;
        int i3 = this.f9895d + (d.f9887h[this.a][fVar.a] >> 16);
        int i4 = fVar.f9894c;
        if (i4 > 0 && ((i2 = this.f9894c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f9895d;
    }

    d.b.c.z.a a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVarA = b(bArr.length).f9893b; gVarA != null; gVarA = gVarA.a()) {
            linkedList.addFirst(gVarA);
        }
        d.b.c.z.a aVar = new d.b.c.z.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(aVar, bArr);
        }
        return aVar;
    }
}
