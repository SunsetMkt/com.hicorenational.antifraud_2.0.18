package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableMaterialize.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w1<T> extends h.a.y0.e.d.a<T, h.a.a0<T>> {

    /* JADX INFO: compiled from: ObservableMaterialize.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super h.a.a0<T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.u0.c f11689b;

        a(h.a.i0<? super h.a.a0<T>> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11689b.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11689b.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.a.onNext(h.a.a0.f());
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.a.onNext(h.a.a0.a(th));
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.a.onNext(h.a.a0.a(t));
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11689b, cVar)) {
                this.f11689b = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public w1(h.a.g0<T> g0Var) {
        super(g0Var);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.a0<T>> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
