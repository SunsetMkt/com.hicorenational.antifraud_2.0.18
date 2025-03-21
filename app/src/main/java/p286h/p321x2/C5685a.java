package p286h.p321x2;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SequencesJVM.kt */
/* renamed from: h.x2.a */
/* loaded from: classes2.dex */
public final class C5685a<T> implements InterfaceC5699m<T> {

    /* renamed from: a */
    private final AtomicReference<InterfaceC5699m<T>> f20559a;

    public C5685a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "sequence");
        this.f20559a = new AtomicReference<>(interfaceC5699m);
    }

    @Override // p286h.p321x2.InterfaceC5699m
    @InterfaceC5816d
    public Iterator<T> iterator() {
        InterfaceC5699m<T> andSet = this.f20559a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
