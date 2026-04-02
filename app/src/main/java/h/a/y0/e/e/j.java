package h.a.y0.e.e;

import h.a.q;

/* JADX INFO: compiled from: ParallelMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T, R> extends h.a.b1.b<R> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super T, ? extends R> f11782b;

    /* JADX INFO: compiled from: ParallelMap.java */
    static final class a<T, R> implements h.a.y0.c.a<T>, j.d.d {
        final h.a.y0.c.a<? super R> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.o<? super T, ? extends R> f11783b;

        /* JADX INFO: renamed from: c */
        j.d.d f11784c;

        /* JADX INFO: renamed from: d */
        boolean f11785d;

        a(h.a.y0.c.a<? super R> aVar, h.a.x0.o<? super T, ? extends R> oVar) {
            this.a = aVar;
            this.f11783b = oVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11784c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11785d) {
                return;
            }
            this.f11785d = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11785d) {
                h.a.c1.a.b(th);
            } else {
                this.f11785d = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f11785d) {
                return;
            }
            try {
                this.a.onNext(h.a.y0.b.b.a(this.f11783b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11784c, dVar)) {
                this.f11784c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11784c.request(j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f11785d) {
                return false;
            }
            try {
                return this.a.tryOnNext(h.a.y0.b.b.a(this.f11783b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: ParallelMap.java */
    static final class b<T, R> implements q<T>, j.d.d {
        final j.d.c<? super R> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.o<? super T, ? extends R> f11786b;

        /* JADX INFO: renamed from: c */
        j.d.d f11787c;

        /* JADX INFO: renamed from: d */
        boolean f11788d;

        b(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends R> oVar) {
            this.a = cVar;
            this.f11786b = oVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11787c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11788d) {
                return;
            }
            this.f11788d = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11788d) {
                h.a.c1.a.b(th);
            } else {
                this.f11788d = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f11788d) {
                return;
            }
            try {
                this.a.onNext(h.a.y0.b.b.a(this.f11786b.apply(t), "The mapper returned a null value"));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11787c, dVar)) {
                this.f11787c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11787c.request(j2);
        }
    }

    public j(h.a.b1.b<T> bVar, h.a.x0.o<? super T, ? extends R> oVar) {
        this.a = bVar;
        this.f11782b = oVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                j.d.c<? super R> cVar = cVarArr[i2];
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i2] = new a((h.a.y0.c.a) cVar, this.f11782b);
                } else {
                    cVarArr2[i2] = new b(cVar, this.f11782b);
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
