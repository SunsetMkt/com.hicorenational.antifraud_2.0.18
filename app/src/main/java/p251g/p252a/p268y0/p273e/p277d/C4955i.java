package p251g.p252a.p268y0.p273e.p277d;

import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4587r;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableAny.java */
/* renamed from: g.a.y0.e.d.i */
/* loaded from: classes2.dex */
public final class C4955i<T> extends AbstractC4907a<T, Boolean> {

    /* renamed from: b */
    final InterfaceC4587r<? super T> f19048b;

    /* compiled from: ObservableAny.java */
    /* renamed from: g.a.y0.e.d.i$a */
    static final class a<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

        /* renamed from: a */
        final InterfaceC4514i0<? super Boolean> f19049a;

        /* renamed from: b */
        final InterfaceC4587r<? super T> f19050b;

        /* renamed from: c */
        InterfaceC4552c f19051c;

        /* renamed from: d */
        boolean f19052d;

        a(InterfaceC4514i0<? super Boolean> interfaceC4514i0, InterfaceC4587r<? super T> interfaceC4587r) {
            this.f19049a = interfaceC4514i0;
            this.f19050b = interfaceC4587r;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19051c.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19051c.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19052d) {
                return;
            }
            this.f19052d = true;
            this.f19049a.onNext(false);
            this.f19049a.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19052d) {
                C4476a.m17152b(th);
            } else {
                this.f19052d = true;
                this.f19049a.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.f19052d) {
                return;
            }
            try {
                if (this.f19050b.test(t)) {
                    this.f19052d = true;
                    this.f19051c.dispose();
                    this.f19049a.onNext(true);
                    this.f19049a.onComplete();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19051c.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19051c, interfaceC4552c)) {
                this.f19051c = interfaceC4552c;
                this.f19049a.onSubscribe(this);
            }
        }
    }

    public C4955i(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4587r<? super T> interfaceC4587r) {
        super(interfaceC4504g0);
        this.f19048b = interfaceC4587r;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super Boolean> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19048b));
    }
}
