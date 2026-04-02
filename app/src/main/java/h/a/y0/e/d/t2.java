package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableScan.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.c<T, T, T> f11634b;

    /* JADX INFO: compiled from: ObservableScan.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.x0.c<T, T, T> f11635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        h.a.u0.c f11636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f11637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11638e;

        a(h.a.i0<? super T> i0Var, h.a.x0.c<T, T, T> cVar) {
            this.a = i0Var;
            this.f11635b = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11636c.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11636c.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11638e) {
                return;
            }
            this.f11638e = true;
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11638e) {
                h.a.c1.a.b(th);
            } else {
                this.f11638e = true;
                this.a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11638e) {
                return;
            }
            h.a.i0<? super T> i0Var = this.a;
            T t2 = this.f11637d;
            if (t2 == null) {
                this.f11637d = t;
                i0Var.onNext(t);
                return;
            }
            try {
                ?? r4 = (T) h.a.y0.b.b.a((Object) this.f11635b.apply(t2, t), "The value returned by the accumulator is null");
                this.f11637d = r4;
                i0Var.onNext(r4);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11636c.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11636c, cVar)) {
                this.f11636c = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public t2(h.a.g0<T> g0Var, h.a.x0.c<T, T, T> cVar) {
        super(g0Var);
        this.f11634b = cVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11634b));
    }
}
