package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4589a;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSkipUntil.java */
/* renamed from: g.a.y0.e.d.d3 */
/* loaded from: classes2.dex */
public final class C4929d3<T, U> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4504g0<U> f18899b;

    /* compiled from: ObservableSkipUntil.java */
    /* renamed from: g.a.y0.e.d.d3$a */
    final class a implements InterfaceC4514i0<U> {

        /* renamed from: a */
        private final C4589a f18900a;

        /* renamed from: b */
        private final b<T> f18901b;

        /* renamed from: c */
        private final C4466m<T> f18902c;

        /* renamed from: d */
        InterfaceC4552c f18903d;

        a(C4589a c4589a, b<T> bVar, C4466m<T> c4466m) {
            this.f18900a = c4589a;
            this.f18901b = bVar;
            this.f18902c = c4466m;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18901b.f18908d = true;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18900a.dispose();
            this.f18902c.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(U u) {
            this.f18903d.dispose();
            this.f18901b.f18908d = true;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18903d, interfaceC4552c)) {
                this.f18903d = interfaceC4552c;
                this.f18900a.setResource(1, interfaceC4552c);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    /* renamed from: g.a.y0.e.d.d3$b */
    static final class b<T> implements InterfaceC4514i0<T> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f18905a;

        /* renamed from: b */
        final C4589a f18906b;

        /* renamed from: c */
        InterfaceC4552c f18907c;

        /* renamed from: d */
        volatile boolean f18908d;

        /* renamed from: e */
        boolean f18909e;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, C4589a c4589a) {
            this.f18905a = interfaceC4514i0;
            this.f18906b = c4589a;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.f18906b.dispose();
            this.f18905a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.f18906b.dispose();
            this.f18905a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f18909e) {
                this.f18905a.onNext(t);
            } else if (this.f18908d) {
                this.f18909e = true;
                this.f18905a.onNext(t);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18907c, interfaceC4552c)) {
                this.f18907c = interfaceC4552c;
                this.f18906b.setResource(0, interfaceC4552c);
            }
        }
    }

    public C4929d3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<U> interfaceC4504g02) {
        super(interfaceC4504g0);
        this.f18899b = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        C4589a c4589a = new C4589a(2);
        c4466m.onSubscribe(c4589a);
        b bVar = new b(c4466m, c4589a);
        this.f18899b.subscribe(new a(c4589a, bVar, c4466m));
        this.f18742a.subscribe(bVar);
    }
}
