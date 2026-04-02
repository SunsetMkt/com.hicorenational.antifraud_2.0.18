package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableFromPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e1<T> extends h.a.b0<T> {
    final j.d.b<? extends T> a;

    /* JADX INFO: compiled from: ObservableFromPublisher.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.d.d f11328b;

        a(h.a.i0<? super T> i0Var) {
            this.a = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11328b.cancel();
            this.f11328b = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11328b == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11328b, dVar)) {
                this.f11328b = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public e1(j.d.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var));
    }
}
