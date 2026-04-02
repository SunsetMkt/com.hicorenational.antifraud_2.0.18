package i.g2;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: _UCollections.kt */
/* JADX INFO: loaded from: classes2.dex */
class w1 {
    @i.k
    @i.t0(version = "1.3")
    @j.c.a.d
    public static final byte[] a(@j.c.a.d Collection<i.f1> collection) {
        i.q2.t.i0.f(collection, "$this$toUByteArray");
        byte[] bArrA = i.g1.a(collection.size());
        Iterator<i.f1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i.g1.a(bArrA, i2, it.next().a());
            i2++;
        }
        return bArrA;
    }

    @i.k
    @i.t0(version = "1.3")
    @j.c.a.d
    public static final int[] b(@j.c.a.d Collection<i.j1> collection) {
        i.q2.t.i0.f(collection, "$this$toUIntArray");
        int[] iArrC = i.k1.c(collection.size());
        Iterator<i.j1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i.k1.a(iArrC, i2, it.next().a());
            i2++;
        }
        return iArrC;
    }

    @i.k
    @i.t0(version = "1.3")
    @j.c.a.d
    public static final long[] c(@j.c.a.d Collection<i.n1> collection) {
        i.q2.t.i0.f(collection, "$this$toULongArray");
        long[] jArrA = i.o1.a(collection.size());
        Iterator<i.n1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i.o1.a(jArrA, i2, it.next().a());
            i2++;
        }
        return jArrA;
    }

    @i.k
    @i.t0(version = "1.3")
    @j.c.a.d
    public static final short[] d(@j.c.a.d Collection<i.t1> collection) {
        i.q2.t.i0.f(collection, "$this$toUShortArray");
        short[] sArrA = i.u1.a(collection.size());
        Iterator<i.t1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i.u1.a(sArrA, i2, it.next().a());
            i2++;
        }
        return sArrA;
    }

    @i.k
    @i.q2.e(name = "sumOfUByte")
    @i.t0(version = "1.3")
    public static final int a(@j.c.a.d Iterable<i.f1> iterable) {
        i.q2.t.i0.f(iterable, "$this$sum");
        Iterator<i.f1> it = iterable.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = i.j1.c(iC + i.j1.c(it.next().a() & i.f1.f12066c));
        }
        return iC;
    }

    @i.k
    @i.q2.e(name = "sumOfUInt")
    @i.t0(version = "1.3")
    public static final int b(@j.c.a.d Iterable<i.j1> iterable) {
        i.q2.t.i0.f(iterable, "$this$sum");
        Iterator<i.j1> it = iterable.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = i.j1.c(iC + it.next().a());
        }
        return iC;
    }

    @i.k
    @i.q2.e(name = "sumOfULong")
    @i.t0(version = "1.3")
    public static final long c(@j.c.a.d Iterable<i.n1> iterable) {
        i.q2.t.i0.f(iterable, "$this$sum");
        Iterator<i.n1> it = iterable.iterator();
        long jC = 0;
        while (it.hasNext()) {
            jC = i.n1.c(jC + it.next().a());
        }
        return jC;
    }

    @i.k
    @i.q2.e(name = "sumOfUShort")
    @i.t0(version = "1.3")
    public static final int d(@j.c.a.d Iterable<i.t1> iterable) {
        i.q2.t.i0.f(iterable, "$this$sum");
        Iterator<i.t1> it = iterable.iterator();
        int iC = 0;
        while (it.hasNext()) {
            iC = i.j1.c(iC + i.j1.c(it.next().a() & i.t1.f12275c));
        }
        return iC;
    }
}
