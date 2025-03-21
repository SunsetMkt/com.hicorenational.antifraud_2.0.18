package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: MaybeTimeoutMaybe.java */
/* renamed from: g.a.y0.e.c.h1 */
/* loaded from: classes2.dex */
public final class C4859h1<T, U> extends AbstractC4836a<T, T> {

    /* renamed from: b */
    final InterfaceC4588y<U> f18621b;

    /* renamed from: c */
    final InterfaceC4588y<? extends T> f18622c;

    /* compiled from: MaybeTimeoutMaybe.java */
    /* renamed from: g.a.y0.e.c.h1$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = 8663801314800248617L;
        final InterfaceC4559v<? super T> actual;

        a(InterfaceC4559v<? super T> interfaceC4559v) {
            this.actual = interfaceC4559v;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* compiled from: MaybeTimeoutMaybe.java */
    /* renamed from: g.a.y0.e.c.h1$b */
    static final class b<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<T>, InterfaceC4552c {
        private static final long serialVersionUID = -5955289211445418871L;
        final InterfaceC4559v<? super T> actual;
        final InterfaceC4588y<? extends T> fallback;
        final c<T, U> other = new c<>(this);
        final a<T> otherObserver;

        b(InterfaceC4559v<? super T> interfaceC4559v, InterfaceC4588y<? extends T> interfaceC4588y) {
            this.actual = interfaceC4559v;
            this.fallback = interfaceC4588y;
            this.otherObserver = interfaceC4588y != null ? new a<>(interfaceC4559v) : null;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            EnumC4592d.dispose(this.other);
            a<T> aVar = this.otherObserver;
            if (aVar != null) {
                EnumC4592d.dispose(aVar);
            }
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

        public void otherComplete() {
            if (EnumC4592d.dispose(this)) {
                InterfaceC4588y<? extends T> interfaceC4588y = this.fallback;
                if (interfaceC4588y == null) {
                    this.actual.onError(new TimeoutException());
                } else {
                    interfaceC4588y.mo18100a(this.otherObserver);
                }
            }
        }

        public void otherError(Throwable th) {
            if (EnumC4592d.dispose(this)) {
                this.actual.onError(th);
            } else {
                C4476a.m17152b(th);
            }
        }
    }

    /* compiled from: MaybeTimeoutMaybe.java */
    /* renamed from: g.a.y0.e.c.h1$c */
    static final class c<T, U> extends AtomicReference<InterfaceC4552c> implements InterfaceC4559v<Object> {
        private static final long serialVersionUID = 8663801314800248617L;
        final b<T, U> parent;

        c(b<T, U> bVar) {
            this.parent = bVar;
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

    public C4859h1(InterfaceC4588y<T> interfaceC4588y, InterfaceC4588y<U> interfaceC4588y2, InterfaceC4588y<? extends T> interfaceC4588y3) {
        super(interfaceC4588y);
        this.f18621b = interfaceC4588y2;
        this.f18622c = interfaceC4588y3;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        b bVar = new b(interfaceC4559v, this.f18622c);
        interfaceC4559v.onSubscribe(bVar);
        this.f18621b.mo18100a(bVar.other);
        this.f18548a.mo18100a(bVar);
    }
}
