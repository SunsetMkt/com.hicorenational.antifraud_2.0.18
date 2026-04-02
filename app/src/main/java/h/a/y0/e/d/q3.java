package h.a.y0.e.d;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableTimeInterval.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q3<T> extends h.a.y0.e.d.a<T, h.a.e1.c<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f11583c;

    /* JADX INFO: compiled from: ObservableTimeInterval.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super h.a.e1.c<T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeUnit f11584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.j0 f11585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f11586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.u0.c f11587e;

        a(h.a.i0<? super h.a.e1.c<T>> i0Var, TimeUnit timeUnit, h.a.j0 j0Var) {
            this.a = i0Var;
            this.f11585c = j0Var;
            this.f11584b = timeUnit;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11587e.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11587e.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            long jA = this.f11585c.a(this.f11584b);
            long j2 = this.f11586d;
            this.f11586d = jA;
            this.a.onNext(new h.a.e1.c(t, jA - j2, this.f11584b));
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11587e, cVar)) {
                this.f11587e = cVar;
                this.f11586d = this.f11585c.a(this.f11584b);
                this.a.onSubscribe(this);
            }
        }
    }

    public q3(h.a.g0<T> g0Var, TimeUnit timeUnit, h.a.j0 j0Var) {
        super(g0Var);
        this.f11582b = j0Var;
        this.f11583c = timeUnit;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.e1.c<T>> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11583c, this.f11582b));
    }
}
