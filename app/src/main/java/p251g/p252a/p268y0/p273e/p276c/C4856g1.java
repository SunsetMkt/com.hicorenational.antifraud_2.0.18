package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: MaybeTakeUntilPublisher.java */
/* renamed from: g.a.y0.e.c.g1 */
/* loaded from: classes2.dex */
public final class C4856g1<T, U> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC5821b<U> f18614b;

    /* compiled from: MaybeTakeUntilPublisher.java */
    /* renamed from: g.a.y0.e.c.g1$a */
    static final class a<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -2187421758664251153L;
        final InterfaceC4559v<? super T> actual;
        final C7406a<U> other = new C7406a<>(this);

        /* compiled from: MaybeTakeUntilPublisher.java */
        /* renamed from: g.a.y0.e.c.g1$a$a, reason: collision with other inner class name */
        static final class C7406a<U> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final a<?, U> parent;

            C7406a(a<?, U> aVar) {
                this.parent = aVar;
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onNext(Object obj) {
                this.parent.otherComplete();
            }

            @Override // p251g.p252a.InterfaceC4529q
            public void onSubscribe(InterfaceC5823d interfaceC5823d) {
                if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                    interfaceC5823d.request(C5556m0.f20396b);
                }
            }
        }

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            EnumC5160j.cancel(this.other);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            EnumC5160j.cancel(this.other);
            if (getAndSet(EnumC4592d.DISPOSED) != EnumC4592d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            EnumC5160j.cancel(this.other);
            if (getAndSet(EnumC4592d.DISPOSED) != EnumC4592d.DISPOSED) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            EnumC5160j.cancel(this.other);
            if (getAndSet(EnumC4592d.DISPOSED) != EnumC4592d.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        void otherComplete() {
            if (EnumC4592d.dispose(this)) {
                this.actual.onComplete();
            }
        }

        void otherError(Throwable th) {
            if (EnumC4592d.dispose(this)) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }
    }

    public C4856g1(InterfaceC4588y<T> interfaceC4588y, InterfaceC5821b<U> interfaceC5821b) {
        super(interfaceC4588y);
        this.f18614b = interfaceC5821b;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a aVar = new a(interfaceC4559v);
        interfaceC4559v.onSubscribe(aVar);
        this.f18614b.subscribe(aVar.other);
        this.f18548a.mo18100a(aVar);
    }
}
