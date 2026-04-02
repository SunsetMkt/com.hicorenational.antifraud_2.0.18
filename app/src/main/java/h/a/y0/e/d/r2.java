package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableSampleWithObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<?> f11599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11600c;

    /* JADX INFO: compiled from: ObservableSampleWithObservable.java */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        a(h.a.i0<? super T> i0Var, h.a.g0<?> g0Var) {
            super(i0Var, g0Var);
            this.wip = new AtomicInteger();
        }

        @Override // h.a.y0.e.d.r2.c
        void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // h.a.y0.e.d.r2.c
        void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.actual.onComplete();
            }
        }

        @Override // h.a.y0.e.d.r2.c
        void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.actual.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableSampleWithObservable.java */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        b(h.a.i0<? super T> i0Var, h.a.g0<?> g0Var) {
            super(i0Var, g0Var);
        }

        @Override // h.a.y0.e.d.r2.c
        void completeMain() {
            this.actual.onComplete();
        }

        @Override // h.a.y0.e.d.r2.c
        void completeOther() {
            this.actual.onComplete();
        }

        @Override // h.a.y0.e.d.r2.c
        void run() {
            emit();
        }
    }

    /* JADX INFO: compiled from: ObservableSampleWithObservable.java */
    static abstract class c<T> extends AtomicReference<T> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -3517602651313910099L;
        final h.a.i0<? super T> actual;
        final AtomicReference<h.a.u0.c> other = new AtomicReference<>();
        h.a.u0.c s;
        final h.a.g0<?> sampler;

        c(h.a.i0<? super T> i0Var, h.a.g0<?> g0Var) {
            this.actual = i0Var;
            this.sampler = g0Var;
        }

        public void complete() {
            this.s.dispose();
            completeOther();
        }

        abstract void completeMain();

        abstract void completeOther();

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.other);
            this.s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        public void error(Throwable th) {
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.other.get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // h.a.i0
        public void onComplete() {
            h.a.y0.a.d.dispose(this.other);
            completeMain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.other);
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new d(this));
                }
            }
        }

        abstract void run();

        boolean setOther(h.a.u0.c cVar) {
            return h.a.y0.a.d.setOnce(this.other, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableSampleWithObservable.java */
    static final class d<T> implements h.a.i0<Object> {
        final c<T> a;

        d(c<T> cVar) {
            this.a = cVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.complete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.error(th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            this.a.run();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.setOther(cVar);
        }
    }

    public r2(h.a.g0<T> g0Var, h.a.g0<?> g0Var2, boolean z) {
        super(g0Var);
        this.f11599b = g0Var2;
        this.f11600c = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        if (this.f11600c) {
            this.a.subscribe(new a(mVar, this.f11599b));
        } else {
            this.a.subscribe(new b(mVar, this.f11599b));
        }
    }
}
