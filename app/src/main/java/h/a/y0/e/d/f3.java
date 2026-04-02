package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11351b;

    /* JADX INFO: compiled from: ObservableSubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 8094547886072529208L;
        final h.a.i0<? super T> actual;
        final AtomicReference<h.a.u0.c> s = new AtomicReference<>();

        a(h.a.i0<? super T> i0Var) {
            this.actual = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this.s);
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.i0
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.s, cVar);
        }

        void setDisposable(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableSubscribeOn.java */
    final class b implements Runnable {
        private final a<T> a;

        b(a<T> aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f3.this.a.subscribe(this.a);
        }
    }

    public f3(h.a.g0<T> g0Var, h.a.j0 j0Var) {
        super(g0Var);
        this.f11351b = j0Var;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        aVar.setDisposable(this.f11351b.a(new b(aVar)));
    }
}
