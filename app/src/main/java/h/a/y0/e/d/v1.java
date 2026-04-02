package h.a.y0.e.d;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableMapNotification.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v1<T, R> extends h.a.y0.e.d.a<T, h.a.g0<? extends R>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> f11667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends R>> f11668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<? extends h.a.g0<? extends R>> f11669d;

    /* JADX INFO: compiled from: ObservableMapNotification.java */
    static final class a<T, R> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super h.a.g0<? extends R>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> f11670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends R>> f11671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Callable<? extends h.a.g0<? extends R>> f11672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.u0.c f11673e;

        a(h.a.i0<? super h.a.g0<? extends R>> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends R>> oVar2, Callable<? extends h.a.g0<? extends R>> callable) {
            this.a = i0Var;
            this.f11670b = oVar;
            this.f11671c = oVar2;
            this.f11672d = callable;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11673e.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11673e.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            try {
                this.a.onNext((h.a.g0) h.a.y0.b.b.a(this.f11672d.call(), "The onComplete ObservableSource returned is null"));
                this.a.onComplete();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            try {
                this.a.onNext((h.a.g0) h.a.y0.b.b.a(this.f11671c.apply(th), "The onError ObservableSource returned is null"));
                this.a.onComplete();
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            try {
                this.a.onNext((h.a.g0) h.a.y0.b.b.a(this.f11670b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11673e, cVar)) {
                this.f11673e = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public v1(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, h.a.x0.o<? super Throwable, ? extends h.a.g0<? extends R>> oVar2, Callable<? extends h.a.g0<? extends R>> callable) {
        super(g0Var);
        this.f11667b = oVar;
        this.f11668c = oVar2;
        this.f11669d = callable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.g0<? extends R>> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11667b, this.f11668c, this.f11669d));
    }
}
