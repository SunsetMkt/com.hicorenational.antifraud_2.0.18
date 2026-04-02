package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableDebounceTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11260d;

    /* JADX INFO: compiled from: ObservableDebounceTimed.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements Runnable, h.a.u0.c {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableDebounceTimed.java */
    static final class b<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f11262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final j0.c f11263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.u0.c f11264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11265f = new AtomicReference<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile long f11266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f11267h;

        b(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar) {
            this.a = i0Var;
            this.f11261b = j2;
            this.f11262c = timeUnit;
            this.f11263d = cVar;
        }

        void a(long j2, T t, a<T> aVar) {
            if (j2 == this.f11266g) {
                this.a.onNext(t);
                aVar.dispose();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11264e.dispose();
            this.f11263d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11263d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11267h) {
                return;
            }
            this.f11267h = true;
            h.a.u0.c cVar = this.f11265f.get();
            if (cVar != h.a.y0.a.d.DISPOSED) {
                a aVar = (a) cVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.a.onComplete();
                this.f11263d.dispose();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11267h) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11267h = true;
            this.a.onError(th);
            this.f11263d.dispose();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11267h) {
                return;
            }
            long j2 = this.f11266g + 1;
            this.f11266g = j2;
            h.a.u0.c cVar = this.f11265f.get();
            if (cVar != null) {
                cVar.dispose();
            }
            a aVar = new a(t, j2, this);
            if (this.f11265f.compareAndSet(cVar, aVar)) {
                aVar.setResource(this.f11263d.a(aVar, this.f11261b, this.f11262c));
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11264e, cVar)) {
                this.f11264e = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public c0(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(g0Var);
        this.f11258b = j2;
        this.f11259c = timeUnit;
        this.f11260d = j0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11258b, this.f11259c, this.f11260d.a()));
    }
}
