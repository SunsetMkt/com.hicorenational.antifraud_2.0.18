package p286h.p319v2;

import bean.SurveyH5Bean;
import java.lang.Comparable;
import p286h.p309q2.p311t.C5544i0;
import p286h.p319v2.InterfaceC5638g;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Ranges.kt */
/* renamed from: h.v2.h */
/* loaded from: classes2.dex */
class C5639h<T extends Comparable<? super T>> implements InterfaceC5638g<T> {

    /* renamed from: a */
    @InterfaceC5816d
    private final T f20508a;

    /* renamed from: b */
    @InterfaceC5816d
    private final T f20509b;

    public C5639h(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "start");
        C5544i0.m22546f(t2, "endInclusive");
        this.f20508a = t;
        this.f20509b = t2;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public boolean contains(@InterfaceC5816d T t) {
        C5544i0.m22546f(t, SurveyH5Bean.VALUE);
        return InterfaceC5638g.a.m23020a(this, t);
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5639h) {
            if (!isEmpty() || !((C5639h) obj).isEmpty()) {
                C5639h c5639h = (C5639h) obj;
                if (!C5544i0.m22531a(getStart(), c5639h.getStart()) || !C5544i0.m22531a(getEndInclusive(), c5639h.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public T getEndInclusive() {
        return this.f20509b;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public T getStart() {
        return this.f20508a;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return InterfaceC5638g.a.m23019a(this);
    }

    @InterfaceC5816d
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
