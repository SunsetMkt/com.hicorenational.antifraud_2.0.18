package p286h.p291h2;

import java.util.Comparator;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: _Comparisons.kt */
/* renamed from: h.h2.d */
/* loaded from: classes2.dex */
class C5327d extends C5326c {
    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static final <T> T m21864a(T t, T t2, T t3, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return (T) m21865a(t, m21865a(t2, t3, comparator), comparator);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    public static final <T> T m21866b(T t, T t2, T t3, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return (T) m21867b(t, m21867b(t2, t3, comparator), comparator);
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: a */
    public static final <T> T m21865a(T t, T t2, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    @InterfaceC5610t0(version = "1.1")
    /* renamed from: b */
    public static final <T> T m21867b(T t, T t2, @InterfaceC5816d Comparator<? super T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }
}
