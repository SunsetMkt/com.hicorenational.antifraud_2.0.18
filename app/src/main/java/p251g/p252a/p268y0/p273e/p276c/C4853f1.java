package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeTakeUntilMaybe.java */
/* renamed from: g.a.y0.e.c.f1 */
/* loaded from: classes2.dex */
public final class C4853f1<T, U> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4588y<U> f18609b;

    /* compiled from: MaybeTakeUntilMaybe.java */
    /* renamed from: g.a.y0.e.c.f1$a */
    static final class a<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -2187421758664251153L;
        final InterfaceC4559v<? super T> actual;
        final C7404a<U> other = new C7404a<>(this);

        /* compiled from: MaybeTakeUntilMaybe.java */
        /* renamed from: g.a.y0.e.c.f1$a$a, reason: collision with other inner class name */
        static final class C7404a<U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final a<?, U> parent;

            C7404a(a<?, U> aVar) {
                this.parent = aVar;
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // p251g.p252a.InterfaceC4559v
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }

            @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
            public void onSuccess(Object obj) {
                this.parent.otherComplete();
            }
        }

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            EnumC4592d.dispose(this.other);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            EnumC4592d.dispose(this.other);
            if (getAndSet(EnumC4592d.DISPOSED) != EnumC4592d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.other);
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
            EnumC4592d.dispose(this.other);
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

    public C4853f1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4588y<U> interfaceC4588y2) {
        super(interfaceC4588y);
        this.f18609b = interfaceC4588y2;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        a aVar = new a(interfaceC4559v);
        interfaceC4559v.onSubscribe(aVar);
        this.f18609b.mo18100a(aVar.other);
        this.f18548a.mo18100a(aVar);
    }
}
