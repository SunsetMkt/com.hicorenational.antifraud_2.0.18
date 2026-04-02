package h.a.y0.e.e;

/* JADX INFO: compiled from: ParallelMapTry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k<T, R> extends h.a.b1.b<R> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.o<? super T, ? extends R> f11789b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11790c;

    /* JADX INFO: compiled from: ParallelMapTry.java */
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

    /* JADX INFO: compiled from: ParallelMapTry.java */
    static final class b<T, R> implements h.a.y0.c.a<T>, j.d.d {
        final h.a.y0.c.a<? super R> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.o<? super T, ? extends R> f11791b;

        /* JADX INFO: renamed from: c */
        final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11792c;

        /* JADX INFO: renamed from: d */
        j.d.d f11793d;

        /* JADX INFO: renamed from: e */
        boolean f11794e;

        b(h.a.y0.c.a<? super R> aVar, h.a.x0.o<? super T, ? extends R> oVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
            this.a = aVar;
            this.f11791b = oVar;
            this.f11792c = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11793d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11794e) {
                return;
            }
            this.f11794e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11794e) {
                h.a.c1.a.b(th);
            } else {
                this.f11794e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f11794e) {
                return;
            }
            this.f11793d.request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11793d, dVar)) {
                this.f11793d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11793d.request(j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f11794e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    return this.a.tryOnNext(h.a.y0.b.b.a(this.f11791b.apply(t), "The mapper returned a null value"));
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11792c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        cancel();
                        onError(new h.a.v0.a(th, th2));
                        return false;
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
    }

    /* JADX INFO: compiled from: ParallelMapTry.java */
    static final class c<T, R> implements h.a.y0.c.a<T>, j.d.d {
        final j.d.c<? super R> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.o<? super T, ? extends R> f11795b;

        /* JADX INFO: renamed from: c */
        final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11796c;

        /* JADX INFO: renamed from: d */
        j.d.d f11797d;

        /* JADX INFO: renamed from: e */
        boolean f11798e;

        c(j.d.c<? super R> cVar, h.a.x0.o<? super T, ? extends R> oVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar2) {
            this.a = cVar;
            this.f11795b = oVar;
            this.f11796c = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11797d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11798e) {
                return;
            }
            this.f11798e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11798e) {
                h.a.c1.a.b(th);
            } else {
                this.f11798e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f11798e) {
                return;
            }
            this.f11797d.request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11797d, dVar)) {
                this.f11797d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11797d.request(j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f11798e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.a.onNext(h.a.y0.b.b.a(this.f11795b.apply(t), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11796c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        cancel();
                        onError(new h.a.v0.a(th, th2));
                        return false;
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
    }

    public k(h.a.b1.b<T> bVar, h.a.x0.o<? super T, ? extends R> oVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
        this.a = bVar;
        this.f11789b = oVar;
        this.f11790c = cVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super R>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                j.d.c<? super R> cVar = cVarArr[i2];
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i2] = new b((h.a.y0.c.a) cVar, this.f11789b, this.f11790c);
                } else {
                    cVarArr2[i2] = new c(cVar, this.f11789b, this.f11790c);
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
