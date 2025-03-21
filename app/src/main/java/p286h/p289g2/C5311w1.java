package p286h.p289g2;

import java.util.Collection;
import java.util.Iterator;
import p286h.C5230f1;
import p286h.C5239g1;
import p286h.C5341j1;
import p286h.C5354k1;
import p286h.C5441n1;
import p286h.C5468o1;
import p286h.C5611t1;
import p286h.C5619u1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _UCollections.kt */
/* renamed from: h.g2.w1 */
/* loaded from: classes2.dex */
class C5311w1 {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: a */
    public static final byte[] m21742a(@InterfaceC5816d Collection<C5230f1> collection) {
        C5544i0.m22546f(collection, "$this$toUByteArray");
        byte[] m18980a = C5239g1.m18980a(collection.size());
        Iterator<C5230f1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C5239g1.m18975a(m18980a, i2, it.next().m18966a());
            i2++;
        }
        return m18980a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: b */
    public static final int[] m21744b(@InterfaceC5816d Collection<C5341j1> collection) {
        C5544i0.m22546f(collection, "$this$toUIntArray");
        int[] m21985c = C5354k1.m21985c(collection.size());
        Iterator<C5341j1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C5354k1.m21977a(m21985c, i2, it.next().m21968a());
            i2++;
        }
        return m21985c;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: c */
    public static final long[] m21746c(@InterfaceC5816d Collection<C5441n1> collection) {
        C5544i0.m22546f(collection, "$this$toULongArray");
        long[] m22421a = C5468o1.m22421a(collection.size());
        Iterator<C5441n1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C5468o1.m22416a(m22421a, i2, it.next().m22244a());
            i2++;
        }
        return m22421a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    @InterfaceC5816d
    /* renamed from: d */
    public static final short[] m21748d(@InterfaceC5816d Collection<C5611t1> collection) {
        C5544i0.m22546f(collection, "$this$toUShortArray");
        short[] m22931a = C5619u1.m22931a(collection.size());
        Iterator<C5611t1> it = collection.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C5619u1.m22926a(m22931a, i2, it.next().m22913a());
            i2++;
        }
        return m22931a;
    }

    @InterfaceC5481e(name = "sumOfUByte")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m21741a(@InterfaceC5816d Iterable<C5230f1> iterable) {
        C5544i0.m22546f(iterable, "$this$sum");
        Iterator<C5230f1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = C5341j1.m21929c(i2 + C5341j1.m21929c(it.next().m18966a() & C5230f1.f20085c));
        }
        return i2;
    }

    @InterfaceC5481e(name = "sumOfUInt")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: b */
    public static final int m21743b(@InterfaceC5816d Iterable<C5341j1> iterable) {
        C5544i0.m22546f(iterable, "$this$sum");
        Iterator<C5341j1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = C5341j1.m21929c(i2 + it.next().m21968a());
        }
        return i2;
    }

    @InterfaceC5481e(name = "sumOfULong")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: c */
    public static final long m21745c(@InterfaceC5816d Iterable<C5441n1> iterable) {
        C5544i0.m22546f(iterable, "$this$sum");
        Iterator<C5441n1> it = iterable.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 = C5441n1.m22205c(j2 + it.next().m22244a());
        }
        return j2;
    }

    @InterfaceC5481e(name = "sumOfUShort")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: d */
    public static final int m21747d(@InterfaceC5816d Iterable<C5611t1> iterable) {
        C5544i0.m22546f(iterable, "$this$sum");
        Iterator<C5611t1> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = C5341j1.m21929c(i2 + C5341j1.m21929c(it.next().m22913a() & C5611t1.f20467c));
        }
        return i2;
    }
}
