package p286h.p289g2;

import java.util.List;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.C5642k;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ReversedViews.kt */
/* renamed from: h.g2.e0 */
/* loaded from: classes2.dex */
class C5256e0 extends C5253d0 {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static final int m19728c(@InterfaceC5816d List<?> list, int i2) {
        int m21757a = C5315y.m21757a((List) list);
        if (i2 >= 0 && m21757a >= i2) {
            return C5315y.m21757a((List) list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new C5642k(0, C5315y.m21757a((List) list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static final int m19729d(@InterfaceC5816d List<?> list, int i2) {
        int size = list.size();
        if (i2 >= 0 && size >= i2) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new C5642k(0, list.size()) + "].");
    }

    @InterfaceC5816d
    /* renamed from: h */
    public static final <T> List<T> m19730h(@InterfaceC5816d List<? extends T> list) {
        C5544i0.m22546f(list, "$this$asReversed");
        return new C5269i1(list);
    }

    @InterfaceC5481e(name = "asReversedMutable")
    @InterfaceC5816d
    /* renamed from: i */
    public static final <T> List<T> m19731i(@InterfaceC5816d List<T> list) {
        C5544i0.m22546f(list, "$this$asReversed");
        return new C5266h1(list);
    }
}
