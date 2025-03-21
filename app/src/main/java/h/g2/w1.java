package h.g2;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: _UCollections.kt */
/* loaded from: classes2.dex */
class w1 {
    @h.t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final byte[] a(@i.c.a.d Collection<h.f1> collection) {
        h.q2.t.i0.f(collection, "$this$toUByteArray");
        byte[] a2 = h.g1.a(collection.size());
        Iterator<h.f1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            h.g1.a(a2, i2, it.next().a());
            i2++;
        }
        return a2;
    }

    @h.t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final int[] b(@i.c.a.d Collection<h.j1> collection) {
        h.q2.t.i0.f(collection, "$this$toUIntArray");
        int[] c2 = h.k1.c(collection.size());
        Iterator<h.j1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            h.k1.a(c2, i2, it.next().a());
            i2++;
        }
        return c2;
    }

    @h.t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final long[] c(@i.c.a.d Collection<h.n1> collection) {
        h.q2.t.i0.f(collection, "$this$toULongArray");
        long[] a2 = h.o1.a(collection.size());
        Iterator<h.n1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            h.o1.a(a2, i2, it.next().a());
            i2++;
        }
        return a2;
    }

    @h.t0(version = "1.3")
    @h.k
    @i.c.a.d
    public static final short[] d(@i.c.a.d Collection<h.t1> collection) {
        h.q2.t.i0.f(collection, "$this$toUShortArray");
        short[] a2 = h.u1.a(collection.size());
        Iterator<h.t1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            h.u1.a(a2, i2, it.next().a());
            i2++;
        }
        return a2;
    }

    @h.q2.e(name = "sumOfUByte")
    @h.t0(version = "1.3")
    @h.k
    public static final int a(@i.c.a.d Iterable<h.f1> iterable) {
        h.q2.t.i0.f(iterable, "$this$sum");
        Iterator<h.f1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = h.j1.c(i2 + h.j1.c(it.next().a() & h.f1.f16099c));
        }
        return i2;
    }

    @h.q2.e(name = "sumOfUInt")
    @h.t0(version = "1.3")
    @h.k
    public static final int b(@i.c.a.d Iterable<h.j1> iterable) {
        h.q2.t.i0.f(iterable, "$this$sum");
        Iterator<h.j1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = h.j1.c(i2 + it.next().a());
        }
        return i2;
    }

    @h.q2.e(name = "sumOfULong")
    @h.t0(version = "1.3")
    @h.k
    public static final long c(@i.c.a.d Iterable<h.n1> iterable) {
        h.q2.t.i0.f(iterable, "$this$sum");
        Iterator<h.n1> it = iterable.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 = h.n1.c(j2 + it.next().a());
        }
        return j2;
    }

    @h.q2.e(name = "sumOfUShort")
    @h.t0(version = "1.3")
    @h.k
    public static final int d(@i.c.a.d Iterable<h.t1> iterable) {
        h.q2.t.i0.f(iterable, "$this$sum");
        Iterator<h.t1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = h.j1.c(i2 + h.j1.c(it.next().a() & h.t1.f16480c));
        }
        return i2;
    }
}
