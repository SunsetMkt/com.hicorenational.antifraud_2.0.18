package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableTakeUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m3<T, U> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<? extends U> f11500b;

    /* JADX INFO: compiled from: ObservableTakeUntil.java */
    final class a implements h.a.i0<U> {
        private final h.a.y0.a.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.a1.m<T> f11501b;

        a(h.a.y0.a.a aVar, h.a.a1.m<T> mVar) {
            this.a = aVar;
            this.f11501b = mVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.dispose();
            this.f11501b.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.dispose();
            this.f11501b.onError(th);
        }

        @Override // h.a.i0
        public void onNext(U u) {
            this.a.dispose();
            this.f11501b.onComplete();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.a.setResource(1, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableTakeUntil.java */
    static final class b<T> extends AtomicBoolean implements h.a.i0<T> {
        private static final long serialVersionUID = 3451719290311127173L;
        final h.a.i0<? super T> actual;
        final h.a.y0.a.a frc;
        h.a.u0.c s;

        b(h.a.i0<? super T> i0Var, h.a.y0.a.a aVar) {
            this.actual = i0Var;
            this.frc = aVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.frc.dispose();
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.frc.dispose();
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.frc.setResource(0, cVar);
            }
        }
    }

    public m3(h.a.g0<T> g0Var, h.a.g0<? extends U> g0Var2) {
        super(g0Var);
        this.f11500b = g0Var2;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        h.a.y0.a.a aVar = new h.a.y0.a.a(2);
        b bVar = new b(mVar, aVar);
        i0Var.onSubscribe(aVar);
        this.f11500b.subscribe(new a(aVar, mVar));
        this.a.subscribe(bVar);
    }
}
