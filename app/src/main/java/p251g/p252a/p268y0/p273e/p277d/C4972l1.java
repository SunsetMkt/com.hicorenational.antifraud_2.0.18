package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* renamed from: g.a.y0.e.d.l1 */
/* loaded from: classes2.dex */
public final class C4972l1<T> extends AbstractC4474c implements InterfaceC4605d<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19109a;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* renamed from: g.a.y0.e.d.l1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4491f f19110a;

        /* renamed from: b */
        InterfaceC4552c f19111b;

        a(InterfaceC4491f interfaceC4491f) {
            this.f19110a = interfaceC4491f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19111b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19111b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19110a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19110a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19111b = interfaceC4552c;
            this.f19110a.onSubscribe(this);
        }
    }

    public C4972l1(InterfaceC4504g0<T> interfaceC4504g0) {
        this.f19109a = interfaceC4504g0;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<T> mo18288a() {
        return C4476a.m17119a(new C4967k1(this.f19109a));
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    public void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f19109a.subscribe(new a(interfaceC4491f));
    }
}
