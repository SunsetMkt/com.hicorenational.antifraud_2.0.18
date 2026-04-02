package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableDebounce.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b0<T, U> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<U>> f11232b;

    /* JADX INFO: compiled from: ObservableDebounce.java */
    static final class a<T, U> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends h.a.g0<U>> f11233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<h.a.u0.c> f11235d = new AtomicReference<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f11236e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11237f;

        /* JADX INFO: renamed from: h.a.y0.e.d.b0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableDebounce.java */
        static final class C0209a<T, U> extends h.a.a1.e<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<T, U> f11238b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f11239c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final T f11240d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f11241e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final AtomicBoolean f11242f = new AtomicBoolean();

            C0209a(a<T, U> aVar, long j2, T t) {
                this.f11238b = aVar;
                this.f11239c = j2;
                this.f11240d = t;
            }

            void b() {
                if (this.f11242f.compareAndSet(false, true)) {
                    this.f11238b.a(this.f11239c, this.f11240d);
                }
            }

            @Override // h.a.i0
            public void onComplete() {
                if (this.f11241e) {
                    return;
                }
                this.f11241e = true;
                b();
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                if (this.f11241e) {
                    h.a.c1.a.b(th);
                } else {
                    this.f11241e = true;
                    this.f11238b.onError(th);
                }
            }

            @Override // h.a.i0
            public void onNext(U u) {
                if (this.f11241e) {
                    return;
                }
                this.f11241e = true;
                dispose();
                b();
            }
        }

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<U>> oVar) {
            this.a = i0Var;
            this.f11233b = oVar;
        }

        void a(long j2, T t) {
            if (j2 == this.f11236e) {
                this.a.onNext(t);
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11234c.dispose();
            h.a.y0.a.d.dispose(this.f11235d);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11234c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11237f) {
                return;
            }
            this.f11237f = true;
            h.a.u0.c cVar = this.f11235d.get();
            if (cVar != h.a.y0.a.d.DISPOSED) {
                ((C0209a) cVar).b();
                h.a.y0.a.d.dispose(this.f11235d);
                this.a.onComplete();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.f11235d);
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11237f) {
                return;
            }
            long j2 = this.f11236e + 1;
            this.f11236e = j2;
            h.a.u0.c cVar = this.f11235d.get();
            if (cVar != null) {
                cVar.dispose();
            }
            try {
                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.f11233b.apply(t), "The ObservableSource supplied is null");
                C0209a c0209a = new C0209a(this, j2, t);
                if (this.f11235d.compareAndSet(cVar, c0209a)) {
                    g0Var.subscribe(c0209a);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                dispose();
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11234c, cVar)) {
                this.f11234c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public b0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<U>> oVar) {
        super(g0Var);
        this.f11232b = oVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(new h.a.a1.m(i0Var), this.f11232b));
    }
}
