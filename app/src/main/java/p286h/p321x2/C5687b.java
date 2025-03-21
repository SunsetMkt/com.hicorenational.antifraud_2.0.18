package p286h.p321x2;

import java.util.HashSet;
import java.util.Iterator;
import p286h.p289g2.AbstractC5249c;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: Sequences.kt */
/* renamed from: h.x2.b */
/* loaded from: classes2.dex */
final class C5687b<T, K> extends AbstractC5249c<T> {

    /* renamed from: c */
    private final HashSet<K> f20560c;

    /* renamed from: d */
    private final Iterator<T> f20561d;

    /* renamed from: e */
    private final InterfaceC5506l<T, K> f20562e;

    /* JADX WARN: Multi-variable type inference failed */
    public C5687b(@InterfaceC5816d Iterator<? extends T> it, @InterfaceC5816d InterfaceC5506l<? super T, ? extends K> interfaceC5506l) {
        C5544i0.m22546f(it, "source");
        C5544i0.m22546f(interfaceC5506l, "keySelector");
        this.f20561d = it;
        this.f20562e = interfaceC5506l;
        this.f20560c = new HashSet<>();
    }

    @Override // p286h.p289g2.AbstractC5249c
    /* renamed from: b */
    protected void mo19567b() {
        while (this.f20561d.hasNext()) {
            T next = this.f20561d.next();
            if (this.f20560c.add(this.f20562e.invoke(next))) {
                m19568b(next);
                return;
            }
        }
        m19569c();
    }
}
