package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableTake.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i3<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11423b;

    /* JADX INFO: compiled from: ObservableTake.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f11424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f11426d;

        a(h.a.i0<? super T> i0Var, long j2) {
            this.a = i0Var;
            this.f11426d = j2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11425c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11425c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11424b) {
                return;
            }
            this.f11424b = true;
            this.f11425c.dispose();
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11424b) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11424b = true;
            this.f11425c.dispose();
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11424b) {
                return;
            }
            long j2 = this.f11426d;
            this.f11426d = j2 - 1;
            if (j2 > 0) {
                boolean z = this.f11426d == 0;
                this.a.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11425c, cVar)) {
                this.f11425c = cVar;
                if (this.f11426d != 0) {
                    this.a.onSubscribe(this);
                    return;
                }
                this.f11424b = true;
                cVar.dispose();
                h.a.y0.a.e.complete(this.a);
            }
        }
    }

    public i3(h.a.g0<T> g0Var, long j2) {
        super(g0Var);
        this.f11423b = j2;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11423b));
    }
}
