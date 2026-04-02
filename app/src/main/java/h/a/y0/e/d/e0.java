package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableDelay.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.j0 f11319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11320e;

    /* JADX INFO: compiled from: ObservableDelay.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f11322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final j0.c f11323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f11324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        h.a.u0.c f11325f;

        /* JADX INFO: renamed from: h.a.y0.e.d.e0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableDelay.java */
        final class RunnableC0212a implements Runnable {
            RunnableC0212a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onComplete();
                } finally {
                    a.this.f11323d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: ObservableDelay.java */
        final class b implements Runnable {
            private final Throwable a;

            b(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a.onError(this.a);
                } finally {
                    a.this.f11323d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: ObservableDelay.java */
        final class c implements Runnable {
            private final T a;

            c(T t) {
                this.a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.onNext(this.a);
            }
        }

        a(h.a.i0<? super T> i0Var, long j2, TimeUnit timeUnit, j0.c cVar, boolean z) {
            this.a = i0Var;
            this.f11321b = j2;
            this.f11322c = timeUnit;
            this.f11323d = cVar;
            this.f11324e = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11325f.dispose();
            this.f11323d.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11323d.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11323d.a(new RunnableC0212a(), this.f11321b, this.f11322c);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11323d.a(new b(th), this.f11324e ? this.f11321b : 0L, this.f11322c);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11323d.a(new c(t), this.f11321b, this.f11322c);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11325f, cVar)) {
                this.f11325f = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public e0(h.a.g0<T> g0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, boolean z) {
        super(g0Var);
        this.f11317b = j2;
        this.f11318c = timeUnit;
        this.f11319d = j0Var;
        this.f11320e = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(this.f11320e ? i0Var : new h.a.a1.m(i0Var), this.f11317b, this.f11318c, this.f11319d.a(), this.f11320e));
    }
}
