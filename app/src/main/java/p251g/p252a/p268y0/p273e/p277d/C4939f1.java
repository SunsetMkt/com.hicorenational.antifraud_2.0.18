package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;

/* compiled from: ObservableFromUnsafeSource.java */
/* renamed from: g.a.y0.e.d.f1 */
/* loaded from: classes2.dex */
public final class C4939f1<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f18967a;

    public C4939f1(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f18967a = interfaceC4504g0;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18967a.subscribe(interfaceC4514i0);
    }
}
