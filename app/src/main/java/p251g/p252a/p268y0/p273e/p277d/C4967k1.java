package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: ObservableIgnoreElements.java */
/* renamed from: g.a.y0.e.d.k1 */
/* loaded from: classes2.dex */
public final class C4967k1<T> extends AbstractC4907a<T, T> {

    /* compiled from: ObservableIgnoreElements.java */
    /* renamed from: g.a.y0.e.d.k1$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f19099a;

        /* renamed from: b */
        InterfaceC4552c f19100b;

        a(InterfaceC4514i0<? super T> interfaceC4514i0) {
            this.f19099a = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19100b.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19100b.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f19099a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f19099a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f19100b = interfaceC4552c;
            this.f19099a.onSubscribe(this);
        }
    }

    public C4967k1(InterfaceC4504g0<T> interfaceC4504g0) {
        super(interfaceC4504g0);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0));
    }
}
