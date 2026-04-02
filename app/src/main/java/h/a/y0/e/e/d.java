package h.a.y0.e.e;

import h.a.x0.r;

/* JADX INFO: compiled from: ParallelFilter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> extends h.a.b1.b<T> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final r<? super T> f11759b;

    /* JADX INFO: compiled from: ParallelFilter.java */
    static abstract class a<T> implements h.a.y0.c.a<T>, j.d.d {
        final r<? super T> a;

        /* JADX INFO: renamed from: b */
        j.d.d f11760b;

        /* JADX INFO: renamed from: c */
        boolean f11761c;

        a(r<? super T> rVar) {
            this.a = rVar;
        }

        @Override // j.d.d
        public final void cancel() {
            this.f11760b.cancel();
        }

        @Override // j.d.c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f11761c) {
                return;
            }
            this.f11760b.request(1L);
        }

        @Override // j.d.d
        public final void request(long j2) {
            this.f11760b.request(j2);
        }
    }

    /* JADX INFO: compiled from: ParallelFilter.java */
    static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: d */
        final h.a.y0.c.a<? super T> f11762d;

        b(h.a.y0.c.a<? super T> aVar, r<? super T> rVar) {
            super(rVar);
            this.f11762d = aVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11761c) {
                return;
            }
            this.f11761c = true;
            this.f11762d.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11761c) {
                h.a.c1.a.b(th);
            } else {
                this.f11761c = true;
                this.f11762d.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11760b, dVar)) {
                this.f11760b = dVar;
                this.f11762d.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.f11761c) {
                try {
                    if (this.a.test(t)) {
                        return this.f11762d.tryOnNext(t);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: ParallelFilter.java */
    static final class c<T> extends a<T> {

        /* JADX INFO: renamed from: d */
        final j.d.c<? super T> f11763d;

        c(j.d.c<? super T> cVar, r<? super T> rVar) {
            super(rVar);
            this.f11763d = cVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11761c) {
                return;
            }
            this.f11761c = true;
            this.f11763d.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11761c) {
                h.a.c1.a.b(th);
            } else {
                this.f11761c = true;
                this.f11763d.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11760b, dVar)) {
                this.f11760b = dVar;
                this.f11763d.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (!this.f11761c) {
                try {
                    if (this.a.test(t)) {
                        this.f11763d.onNext(t);
                        return true;
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }
    }

    public d(h.a.b1.b<T> bVar, r<? super T> rVar) {
        this.a = bVar;
        this.f11759b = rVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                j.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i2] = new b((h.a.y0.c.a) cVar, this.f11759b);
                } else {
                    cVarArr2[i2] = new c(cVar, this.f11759b);
                }
            }
            this.a.a(cVarArr2);
        }
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.a();
    }
}
