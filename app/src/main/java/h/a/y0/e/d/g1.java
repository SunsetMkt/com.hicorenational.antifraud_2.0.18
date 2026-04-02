package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableGenerate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g1<T, S> extends h.a.b0<T> {
    final Callable<S> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<S, h.a.k<T>, S> f11367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super S> f11368c;

    public g1(Callable<S> callable, h.a.x0.c<S, h.a.k<T>, S> cVar, h.a.x0.g<? super S> gVar) {
        this.a = callable;
        this.f11367b = cVar;
        this.f11368c = gVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        try {
            a aVar = new a(i0Var, this.f11367b, this.f11368c, this.a.call());
            i0Var.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, i0Var);
        }
    }

    /* JADX INFO: compiled from: ObservableGenerate.java */
    static final class a<T, S> implements h.a.k<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<S, ? super h.a.k<T>, S> f11369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.g<? super S> f11370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        S f11371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11373f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f11374g;

        a(h.a.i0<? super T> i0Var, h.a.x0.c<S, ? super h.a.k<T>, S> cVar, h.a.x0.g<? super S> gVar, S s) {
            this.a = i0Var;
            this.f11369b = cVar;
            this.f11370c = gVar;
            this.f11371d = s;
        }

        public void a() {
            S sApply = this.f11371d;
            if (this.f11372e) {
                this.f11371d = null;
                a(sApply);
                return;
            }
            h.a.x0.c<S, ? super h.a.k<T>, S> cVar = this.f11369b;
            while (!this.f11372e) {
                this.f11374g = false;
                try {
                    sApply = cVar.apply(sApply, this);
                    if (this.f11373f) {
                        this.f11372e = true;
                        this.f11371d = null;
                        a(sApply);
                        return;
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.f11371d = null;
                    this.f11372e = true;
                    onError(th);
                    a(sApply);
                    return;
                }
            }
            this.f11371d = null;
            a(sApply);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11372e = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11372e;
        }

        @Override // h.a.k
        public void onComplete() {
            if (this.f11373f) {
                return;
            }
            this.f11373f = true;
            this.a.onComplete();
        }

        @Override // h.a.k
        public void onError(Throwable th) {
            if (this.f11373f) {
                h.a.c1.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f11373f = true;
            this.a.onError(th);
        }

        @Override // h.a.k
        public void onNext(T t) {
            if (this.f11373f) {
                return;
            }
            if (this.f11374g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f11374g = true;
                this.a.onNext(t);
            }
        }

        private void a(S s) {
            try {
                this.f11370c.accept(s);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
        }
    }
}
