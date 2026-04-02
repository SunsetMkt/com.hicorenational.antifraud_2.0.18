package h.a.y0.e.e;

import h.a.x0.q;

/* JADX INFO: compiled from: ParallelPeek.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l<T> extends h.a.b1.b<T> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.g<? super T> f11799b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.g<? super T> f11800c;

    /* JADX INFO: renamed from: d */
    final h.a.x0.g<? super Throwable> f11801d;

    /* JADX INFO: renamed from: e */
    final h.a.x0.a f11802e;

    /* JADX INFO: renamed from: f */
    final h.a.x0.a f11803f;

    /* JADX INFO: renamed from: g */
    final h.a.x0.g<? super j.d.d> f11804g;

    /* JADX INFO: renamed from: h */
    final q f11805h;

    /* JADX INFO: renamed from: i */
    final h.a.x0.a f11806i;

    /* JADX INFO: compiled from: ParallelPeek.java */
    static final class a<T> implements h.a.q<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b */
        final l<T> f11807b;

        /* JADX INFO: renamed from: c */
        j.d.d f11808c;

        /* JADX INFO: renamed from: d */
        boolean f11809d;

        a(j.d.c<? super T> cVar, l<T> lVar) {
            this.a = cVar;
            this.f11807b = lVar;
        }

        @Override // j.d.d
        public void cancel() {
            try {
                this.f11807b.f11806i.run();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f11808c.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11809d) {
                return;
            }
            this.f11809d = true;
            try {
                this.f11807b.f11802e.run();
                this.a.onComplete();
                try {
                    this.f11807b.f11803f.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(th2);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11809d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f11809d = true;
            try {
                this.f11807b.f11801d.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                th = new h.a.v0.a(th, th2);
            }
            this.a.onError(th);
            try {
                this.f11807b.f11803f.run();
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.c1.a.b(th3);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f11809d) {
                return;
            }
            try {
                this.f11807b.f11799b.accept(t);
                this.a.onNext(t);
                try {
                    this.f11807b.f11800c.accept(t);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                onError(th2);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11808c, dVar)) {
                this.f11808c = dVar;
                try {
                    this.f11807b.f11804g.accept(dVar);
                    this.a.onSubscribe(this);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    dVar.cancel();
                    this.a.onSubscribe(h.a.y0.i.g.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            try {
                this.f11807b.f11805h.a(j2);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.c1.a.b(th);
            }
            this.f11808c.request(j2);
        }
    }

    public l(h.a.b1.b<T> bVar, h.a.x0.g<? super T> gVar, h.a.x0.g<? super T> gVar2, h.a.x0.g<? super Throwable> gVar3, h.a.x0.a aVar, h.a.x0.a aVar2, h.a.x0.g<? super j.d.d> gVar4, q qVar, h.a.x0.a aVar3) {
        this.a = bVar;
        this.f11799b = (h.a.x0.g) h.a.y0.b.b.a(gVar, "onNext is null");
        this.f11800c = (h.a.x0.g) h.a.y0.b.b.a(gVar2, "onAfterNext is null");
        this.f11801d = (h.a.x0.g) h.a.y0.b.b.a(gVar3, "onError is null");
        this.f11802e = (h.a.x0.a) h.a.y0.b.b.a(aVar, "onComplete is null");
        this.f11803f = (h.a.x0.a) h.a.y0.b.b.a(aVar2, "onAfterTerminated is null");
        this.f11804g = (h.a.x0.g) h.a.y0.b.b.a(gVar4, "onSubscribe is null");
        this.f11805h = (q) h.a.y0.b.b.a(qVar, "onRequest is null");
        this.f11806i = (h.a.x0.a) h.a.y0.b.b.a(aVar3, "onCancel is null");
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                cVarArr2[i2] = new a(cVarArr[i2], this);
            }
            this.a.a(cVarArr2);
        }
    }

    @Override // h.a.b1.b
    public int a() {
        return this.a.a();
    }
}
