package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.p268y0.p271c.InterfaceC4608g;

/* compiled from: AbstractObservableWithUpstream.java */
/* renamed from: g.a.y0.e.d.a */
/* loaded from: classes2.dex */
abstract class AbstractC4907a<T, U> extends AbstractC4469b0<U> implements InterfaceC4608g<T> {

    /* renamed from: a */
    protected final InterfaceC4504g0<T> f18742a;

    AbstractC4907a(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f18742a = interfaceC4504g0;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4608g
    public final InterfaceC4504g0<T> source() {
        return this.f18742a;
    }
}
