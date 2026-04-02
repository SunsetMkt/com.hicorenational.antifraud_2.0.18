package h.a.y0.e.b;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: FlowableElementAtSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> extends h.a.k0<T> implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f10957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f10958c;

    /* JADX INFO: compiled from: FlowableElementAtSingle.java */
    static final class a<T> implements h.a.q<T>, h.a.u0.c {
        final h.a.n0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f10959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final T f10960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f10961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f10962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f10963f;

        a(h.a.n0<? super T> n0Var, long j2, T t) {
            this.a = n0Var;
            this.f10959b = j2;
            this.f10960c = t;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10961d.cancel();
            this.f10961d = h.a.y0.i.j.CANCELLED;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10961d == h.a.y0.i.j.CANCELLED;
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10961d = h.a.y0.i.j.CANCELLED;
            if (this.f10963f) {
                return;
            }
            this.f10963f = true;
            T t = this.f10960c;
            if (t != null) {
                this.a.onSuccess(t);
            } else {
                this.a.onError(new NoSuchElementException());
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10963f) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10963f = true;
            this.f10961d = h.a.y0.i.j.CANCELLED;
            this.a.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10963f) {
                return;
            }
            long j2 = this.f10962e;
            if (j2 != this.f10959b) {
                this.f10962e = j2 + 1;
                return;
            }
            this.f10963f = true;
            this.f10961d.cancel();
            this.f10961d = h.a.y0.i.j.CANCELLED;
            this.a.onSuccess(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10961d, dVar)) {
                this.f10961d = dVar;
                this.a.onSubscribe(this);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public s0(h.a.l<T> lVar, long j2, T t) {
        this.a = lVar;
        this.f10957b = j2;
        this.f10958c = t;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a((h.a.q) new a(n0Var, this.f10957b, this.f10958c));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new q0(this.a, this.f10957b, this.f10958c, true));
    }
}
