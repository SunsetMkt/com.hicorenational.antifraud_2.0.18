package h.a.y0.e.d;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableElementAt.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f11526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11527d;

    /* JADX INFO: compiled from: ObservableElementAt.java */
    static final class a<T> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f11528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final T f11529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f11530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.u0.c f11531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f11532f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f11533g;

        a(h.a.i0<? super T> i0Var, long j2, T t, boolean z) {
            this.a = i0Var;
            this.f11528b = j2;
            this.f11529c = t;
            this.f11530d = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11531e.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11531e.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11533g) {
                return;
            }
            this.f11533g = true;
            T t = this.f11529c;
            if (t == null && this.f11530d) {
                this.a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.a.onNext(t);
            }
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11533g) {
                h.a.c1.a.b(th);
            } else {
                this.f11533g = true;
                this.a.onError(th);
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11533g) {
                return;
            }
            long j2 = this.f11532f;
            if (j2 != this.f11528b) {
                this.f11532f = j2 + 1;
                return;
            }
            this.f11533g = true;
            this.f11531e.dispose();
            this.a.onNext(t);
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11531e, cVar)) {
                this.f11531e = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public o0(h.a.g0<T> g0Var, long j2, T t, boolean z) {
        super(g0Var);
        this.f11525b = j2;
        this.f11526c = t;
        this.f11527d = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11525b, this.f11526c, this.f11527d));
    }
}
