package h.a.y0.e.e;

import h.a.x0.r;

/* JADX INFO: compiled from: ParallelFilterTry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends h.a.b1.b<T> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final r<? super T> f11764b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11765c;

    /* JADX INFO: compiled from: ParallelFilterTry.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[h.a.b1.a.values().length];

        static {
            try {
                a[h.a.b1.a.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.b1.a.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.b1.a.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: ParallelFilterTry.java */
    static abstract class b<T> implements h.a.y0.c.a<T>, j.d.d {
        final r<? super T> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11766b;

        /* JADX INFO: renamed from: c */
        j.d.d f11767c;

        /* JADX INFO: renamed from: d */
        boolean f11768d;

        b(r<? super T> rVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
            this.a = rVar;
            this.f11766b = cVar;
        }

        @Override // j.d.d
        public final void cancel() {
            this.f11767c.cancel();
        }

        @Override // j.d.c
        public final void onNext(T t) {
            if (tryOnNext(t) || this.f11768d) {
                return;
            }
            this.f11767c.request(1L);
        }

        @Override // j.d.d
        public final void request(long j2) {
            this.f11767c.request(j2);
        }
    }

    /* JADX INFO: compiled from: ParallelFilterTry.java */
    static final class c<T> extends b<T> {

        /* JADX INFO: renamed from: e */
        final h.a.y0.c.a<? super T> f11769e;

        c(h.a.y0.c.a<? super T> aVar, r<? super T> rVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
            super(rVar, cVar);
            this.f11769e = aVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11768d) {
                return;
            }
            this.f11768d = true;
            this.f11769e.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11768d) {
                h.a.c1.a.b(th);
            } else {
                this.f11768d = true;
                this.f11769e.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11767c, dVar)) {
                this.f11767c = dVar;
                this.f11769e.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f11768d) {
                long j2 = 0;
                do {
                    try {
                        return this.a.test(t) && this.f11769e.tryOnNext(t);
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        try {
                            j2++;
                            i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11766b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            cancel();
                            onError(new h.a.v0.a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: ParallelFilterTry.java */
    static final class d<T> extends b<T> {

        /* JADX INFO: renamed from: e */
        final j.d.c<? super T> f11770e;

        d(j.d.c<? super T> cVar, r<? super T> rVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar2) {
            super(rVar, cVar2);
            this.f11770e = cVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11768d) {
                return;
            }
            this.f11768d = true;
            this.f11770e.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11768d) {
                h.a.c1.a.b(th);
            } else {
                this.f11768d = true;
                this.f11770e.onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11767c, dVar)) {
                this.f11767c = dVar;
                this.f11770e.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (!this.f11768d) {
                long j2 = 0;
                do {
                    try {
                        if (!this.a.test(t)) {
                            return false;
                        }
                        this.f11770e.onNext(t);
                        return true;
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        try {
                            j2++;
                            i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11766b.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            cancel();
                            onError(new h.a.v0.a(th, th2));
                        }
                    }
                } while (i2 == 1);
                if (i2 != 2) {
                    if (i2 != 3) {
                        cancel();
                        onError(th);
                        return false;
                    }
                    cancel();
                    onComplete();
                }
                return false;
            }
            return false;
        }
    }

    public e(h.a.b1.b<T> bVar, r<? super T> rVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
        this.a = bVar;
        this.f11764b = rVar;
        this.f11765c = cVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                j.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i2] = new c((h.a.y0.c.a) cVar, this.f11764b, this.f11765c);
                } else {
                    cVarArr2[i2] = new d(cVar, this.f11764b, this.f11765c);
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
