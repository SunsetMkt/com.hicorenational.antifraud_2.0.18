package p286h;

import java.util.List;
import p286h.p289g2.C5315y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Tuples.kt */
@InterfaceC5481e(name = "TuplesKt")
/* renamed from: h.c1 */
/* loaded from: classes2.dex */
public final class C5218c1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static final <A, B> C5334i0<A, B> m18838a(A a2, B b2) {
        return new C5334i0<>(a2, b2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> List<T> m18840a(@InterfaceC5816d C5334i0<? extends T, ? extends T> c5334i0) {
        List<T> m21783c;
        C5544i0.m22546f(c5334i0, "$this$toList");
        m21783c = C5315y.m21783c(c5334i0.getFirst(), c5334i0.getSecond());
        return m21783c;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> List<T> m18839a(@InterfaceC5816d C5214b1<? extends T, ? extends T, ? extends T> c5214b1) {
        List<T> m21783c;
        C5544i0.m22546f(c5214b1, "$this$toList");
        m21783c = C5315y.m21783c(c5214b1.getFirst(), c5214b1.getSecond(), c5214b1.getThird());
        return m21783c;
    }
}
