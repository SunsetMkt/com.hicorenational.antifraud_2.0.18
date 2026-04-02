package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w0<T> extends h.a.c implements h.a.y0.c.d<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11687c;

    /* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
    static final class a<T> extends AtomicInteger implements h.a.u0.c, h.a.i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final h.a.f actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11688d;
        final boolean delayErrors;
        volatile boolean disposed;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final h.a.u0.b set = new h.a.u0.b();

        /* JADX INFO: renamed from: h.a.y0.e.d.w0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
        final class C0219a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0219a() {
            }

            @Override // h.a.u0.c
            public void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.u0.c
            public boolean isDisposed() {
                return h.a.y0.a.d.isDisposed(get());
            }

            @Override // h.a.f
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }
        }

        a(h.a.f fVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z) {
            this.actual = fVar;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.f11688d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0219a c0219a) {
            this.set.c(c0219a);
            onComplete();
        }

        void innerError(a<T>.C0219a c0219a, Throwable th) {
            this.set.c(c0219a);
            onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11688d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            try {
                h.a.i iVar = (h.a.i) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0219a c0219a = new C0219a();
                if (this.disposed || !this.set.b(c0219a)) {
                    return;
                }
                iVar.a(c0219a);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11688d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11688d, cVar)) {
                this.f11688d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public w0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z) {
        this.a = g0Var;
        this.f11686b = oVar;
        this.f11687c = z;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<T> a() {
        return h.a.c1.a.a(new v0(this.a, this.f11686b, this.f11687c));
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar, this.f11686b, this.f11687c));
    }
}
