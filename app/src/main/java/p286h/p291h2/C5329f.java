package p286h.p291h2;

import java.util.Comparator;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Comparisons.kt */
/* renamed from: h.h2.f */
/* loaded from: classes2.dex */
final class C5329f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a */
    public static final C5329f f20215a = new C5329f();

    private C5329f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@InterfaceC5816d Comparable<Object> comparable, @InterfaceC5816d Comparable<Object> comparable2) {
        C5544i0.m22546f(comparable, "a");
        C5544i0.m22546f(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    @InterfaceC5816d
    public final Comparator<Comparable<? super Object>> reversed() {
        return C5328e.f20214a;
    }
}
