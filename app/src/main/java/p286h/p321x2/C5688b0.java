package p286h.p321x2;

import java.util.Iterator;
import p286h.C5230f1;
import p286h.C5341j1;
import p286h.C5441n1;
import p286h.C5611t1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _USequences.kt */
/* renamed from: h.x2.b0 */
/* loaded from: classes2.dex */
class C5688b0 {
    @InterfaceC5481e(name = "sumOfUByte")
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5352k
    /* renamed from: a */
    public static final int m23277a(@InterfaceC5816d InterfaceC5699m<C5230f1> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$sum");
        Iterator<C5230f1> it = interfaceC5699m.iterator();
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
    public static final int m23278b(@InterfaceC5816d InterfaceC5699m<C5341j1> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$sum");
        Iterator<C5341j1> it = interfaceC5699m.iterator();
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
    public static final long m23279c(@InterfaceC5816d InterfaceC5699m<C5441n1> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$sum");
        Iterator<C5441n1> it = interfaceC5699m.iterator();
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
    public static final int m23280d(@InterfaceC5816d InterfaceC5699m<C5611t1> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$sum");
        Iterator<C5611t1> it = interfaceC5699m.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 = C5341j1.m21929c(i2 + C5341j1.m21929c(it.next().m22913a() & C5611t1.f20467c));
        }
        return i2;
    }
}
