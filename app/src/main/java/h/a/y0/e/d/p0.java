package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableElementAtMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p0<T> extends h.a.s<T> implements h.a.y0.c.d<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11548b;

    /* JADX INFO: compiled from: ObservableElementAtMaybe.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f11551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11552e;

        a(h.a.v<? super T> vVar, long j2) {
            this.a = vVar;
            this.f11549b = j2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11550c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11550c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11552e) {
                return;
            }
            this.f11552e = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11552e) {
                h.a.c1.a.b(th);
            } else {
                this.f11552e = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11552e) {
                return;
            }
            long j2 = this.f11551d;
            if (j2 != this.f11549b) {
                this.f11551d = j2 + 1;
                return;
            }
            this.f11552e = true;
            this.f11550c.dispose();
            this.a.onSuccess(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11550c, cVar)) {
                this.f11550c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public p0(h.a.g0<T> g0Var, long j2) {
        this.a = g0Var;
        this.f11548b = j2;
    }

    @Override // h.a.y0.c.d
    public h.a.b0<T> a() {
        return h.a.c1.a.a(new o0(this.a, this.f11548b, null, false));
    }

    @Override // h.a.s
    public void b(h.a.v<? super T> vVar) {
        this.a.subscribe(new a(vVar, this.f11548b));
    }
}
