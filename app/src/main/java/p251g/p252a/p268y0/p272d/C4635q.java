package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4598j;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: FullArbiterObserver.java */
/* renamed from: g.a.y0.d.q */
/* loaded from: classes2.dex */
public final class C4635q<T> implements InterfaceC4514i0<T> {

    /* renamed from: a */
    final C4598j<T> f17583a;

    /* renamed from: b */
    InterfaceC4552c f17584b;

    public C4635q(C4598j<T> c4598j) {
        this.f17583a = c4598j;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        this.f17583a.m18224a(this.f17584b);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        this.f17583a.m18225a(th, this.f17584b);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        this.f17583a.m18226a((C4598j<T>) t, this.f17584b);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17584b, interfaceC4552c)) {
            this.f17584b = interfaceC4552c;
            this.f17583a.m18228b(interfaceC4552c);
        }
    }
}
