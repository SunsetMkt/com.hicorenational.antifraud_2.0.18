package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.AbstractC4458e;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.C4598j;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.C4635q;

/* compiled from: ObservableTimeout.java */
/* renamed from: g.a.y0.e.d.r3 */
/* loaded from: classes2.dex */
public final class C5004r3<T, U, V> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4504g0<U> f19357b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> f19358c;

    /* renamed from: d */
    final InterfaceC4504g0<? extends T> f19359d;

    /* compiled from: ObservableTimeout.java */
    /* renamed from: g.a.y0.e.d.r3$a */
    interface a {
        void innerError(Throwable th);

        void timeout(long j2);
    }

    /* compiled from: ObservableTimeout.java */
    /* renamed from: g.a.y0.e.d.r3$b */
    static final class b<T, U, V> extends AbstractC4458e<Object> {

        /* renamed from: b */
        final a f19360b;

        /* renamed from: c */
        final long f19361c;

        /* renamed from: d */
        boolean f19362d;

        b(a aVar, long j2) {
            this.f19360b = aVar;
            this.f19361c = j2;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.f19362d) {
                return;
            }
            this.f19362d = true;
            this.f19360b.timeout(this.f19361c);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.f19362d) {
                C4476a.m17152b(th);
            } else {
                this.f19362d = true;
                this.f19360b.innerError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
            if (this.f19362d) {
                return;
            }
            this.f19362d = true;
            dispose();
            this.f19360b.timeout(this.f19361c);
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* renamed from: g.a.y0.e.d.r3$c */
    static final class c<T, U, V> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c, a {
        private static final long serialVersionUID = 2672739326310051084L;
        final InterfaceC4514i0<? super T> actual;
        final InterfaceC4504g0<U> firstTimeoutIndicator;
        volatile long index;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> itemTimeoutIndicator;

        /* renamed from: s */
        InterfaceC4552c f19363s;

        c(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o) {
            this.actual = interfaceC4514i0;
            this.firstTimeoutIndicator = interfaceC4504g0;
            this.itemTimeoutIndicator = interfaceC4584o;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (EnumC4592d.dispose(this)) {
                this.f19363s.dispose();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5004r3.a
        public void innerError(Throwable th) {
            this.f19363s.dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19363s.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            EnumC4592d.dispose(this);
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            EnumC4592d.dispose(this);
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            InterfaceC4552c interfaceC4552c = (InterfaceC4552c) get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            try {
                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                b bVar = new b(this, j2);
                if (compareAndSet(interfaceC4552c, bVar)) {
                    interfaceC4504g0.subscribe(bVar);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                dispose();
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19363s, interfaceC4552c)) {
                this.f19363s = interfaceC4552c;
                InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
                InterfaceC4504g0<U> interfaceC4504g0 = this.firstTimeoutIndicator;
                if (interfaceC4504g0 == null) {
                    interfaceC4514i0.onSubscribe(this);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    interfaceC4514i0.onSubscribe(this);
                    interfaceC4504g0.subscribe(bVar);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5004r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.actual.onError(new TimeoutException());
            }
        }
    }

    /* compiled from: ObservableTimeout.java */
    /* renamed from: g.a.y0.e.d.r3$d */
    static final class d<T, U, V> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c, a {
        private static final long serialVersionUID = -1957813281749686898L;
        final InterfaceC4514i0<? super T> actual;
        final C4598j<T> arbiter;
        boolean done;
        final InterfaceC4504g0<U> firstTimeoutIndicator;
        volatile long index;
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> itemTimeoutIndicator;
        final InterfaceC4504g0<? extends T> other;

        /* renamed from: s */
        InterfaceC4552c f19364s;

        d(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4504g0<U> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o, InterfaceC4504g0<? extends T> interfaceC4504g02) {
            this.actual = interfaceC4514i0;
            this.firstTimeoutIndicator = interfaceC4504g0;
            this.itemTimeoutIndicator = interfaceC4584o;
            this.other = interfaceC4504g02;
            this.arbiter = new C4598j<>(interfaceC4514i0, this, 8);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (EnumC4592d.dispose(this)) {
                this.f19364s.dispose();
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5004r3.a
        public void innerError(Throwable th) {
            this.f19364s.dispose();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19364s.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.m18224a(this.f19364s);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            dispose();
            this.arbiter.m18225a(th, this.f19364s);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.m18226a((C4598j<T>) t, this.f19364s)) {
                InterfaceC4552c interfaceC4552c = (InterfaceC4552c) get();
                if (interfaceC4552c != null) {
                    interfaceC4552c.dispose();
                }
                try {
                    InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.itemTimeoutIndicator.apply(t), "The ObservableSource returned is null");
                    b bVar = new b(this, j2);
                    if (compareAndSet(interfaceC4552c, bVar)) {
                        interfaceC4504g0.subscribe(bVar);
                    }
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19364s, interfaceC4552c)) {
                this.f19364s = interfaceC4552c;
                this.arbiter.m18228b(interfaceC4552c);
                InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
                InterfaceC4504g0<U> interfaceC4504g0 = this.firstTimeoutIndicator;
                if (interfaceC4504g0 == null) {
                    interfaceC4514i0.onSubscribe(this.arbiter);
                    return;
                }
                b bVar = new b(this, 0L);
                if (compareAndSet(null, bVar)) {
                    interfaceC4514i0.onSubscribe(this.arbiter);
                    interfaceC4504g0.subscribe(bVar);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C5004r3.a
        public void timeout(long j2) {
            if (j2 == this.index) {
                dispose();
                this.other.subscribe(new C4635q(this.arbiter));
            }
        }
    }

    public C5004r3(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4504g0<U> interfaceC4504g02, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<V>> interfaceC4584o, InterfaceC4504g0<? extends T> interfaceC4504g03) {
        super(interfaceC4504g0);
        this.f19357b = interfaceC4504g02;
        this.f19358c = interfaceC4584o;
        this.f19359d = interfaceC4504g03;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        InterfaceC4504g0<? extends T> interfaceC4504g0 = this.f19359d;
        if (interfaceC4504g0 == null) {
            this.f18742a.subscribe(new c(new C4466m(interfaceC4514i0), this.f19357b, this.f19358c));
        } else {
            this.f18742a.subscribe(new d(interfaceC4514i0, this.f19357b, this.f19358c, interfaceC4504g0));
        }
    }
}
