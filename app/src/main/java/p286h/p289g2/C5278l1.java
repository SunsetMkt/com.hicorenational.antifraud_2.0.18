package p286h.p289g2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SetsJVM.kt */
/* renamed from: h.g2.l1 */
/* loaded from: classes2.dex */
class C5278l1 {
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> Set<T> m20010a(T t) {
        Set<T> singleton = Collections.singleton(t);
        C5544i0.m22521a((Object) singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> TreeSet<T> m20012a(@InterfaceC5816d T... tArr) {
        C5544i0.m22546f(tArr, "elements");
        return (TreeSet) C5294r.m21231e((Object[]) tArr, new TreeSet());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> TreeSet<T> m20011a(@InterfaceC5816d Comparator<? super T> comparator, @InterfaceC5816d T... tArr) {
        C5544i0.m22546f(comparator, "comparator");
        C5544i0.m22546f(tArr, "elements");
        return (TreeSet) C5294r.m21231e((Object[]) tArr, new TreeSet(comparator));
    }
}
