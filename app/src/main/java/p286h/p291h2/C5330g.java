package p286h.p291h2;

import java.util.Comparator;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Comparisons.kt */
/* renamed from: h.h2.g */
/* loaded from: classes2.dex */
final class C5330g<T> implements Comparator<T> {

    /* renamed from: a */
    @InterfaceC5816d
    private final Comparator<T> f20216a;

    public C5330g(@InterfaceC5816d Comparator<T> comparator) {
        C5544i0.m22546f(comparator, "comparator");
        this.f20216a = comparator;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final Comparator<T> m21870a() {
        return this.f20216a;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f20216a.compare(t2, t);
    }

    @Override // java.util.Comparator
    @InterfaceC5816d
    public final Comparator<T> reversed() {
        return this.f20216a;
    }
}
