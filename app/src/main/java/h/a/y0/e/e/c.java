package h.a.y0.e.e;

/* JADX INFO: compiled from: ParallelDoOnNextTry.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> extends h.a.b1.b<T> {
    final h.a.b1.b<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.x0.g<? super T> f11749b;

    /* JADX INFO: renamed from: c */
    final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11750c;

    /* JADX INFO: compiled from: ParallelDoOnNextTry.java */
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

    /* JADX INFO: compiled from: ParallelDoOnNextTry.java */
    static final class b<T> implements h.a.y0.c.a<T>, j.d.d {
        final h.a.y0.c.a<? super T> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.g<? super T> f11751b;

        /* JADX INFO: renamed from: c */
        final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11752c;

        /* JADX INFO: renamed from: d */
        j.d.d f11753d;

        /* JADX INFO: renamed from: e */
        boolean f11754e;

        b(h.a.y0.c.a<? super T> aVar, h.a.x0.g<? super T> gVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
            this.a = aVar;
            this.f11751b = gVar;
            this.f11752c = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11753d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11754e) {
                return;
            }
            this.f11754e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11754e) {
                h.a.c1.a.b(th);
            } else {
                this.f11754e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t) || this.f11754e) {
                return;
            }
            this.f11753d.request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11753d, dVar)) {
                this.f11753d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11753d.request(j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f11754e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f11751b.accept(t);
                    return this.a.tryOnNext(t);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11752c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    /* JADX INFO: renamed from: h.a.y0.e.e.c$c */
    /* JADX INFO: compiled from: ParallelDoOnNextTry.java */
    static final class C0224c<T> implements h.a.y0.c.a<T>, j.d.d {
        final j.d.c<? super T> a;

        /* JADX INFO: renamed from: b */
        final h.a.x0.g<? super T> f11755b;

        /* JADX INFO: renamed from: c */
        final h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> f11756c;

        /* JADX INFO: renamed from: d */
        j.d.d f11757d;

        /* JADX INFO: renamed from: e */
        boolean f11758e;

        C0224c(j.d.c<? super T> cVar, h.a.x0.g<? super T> gVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar2) {
            this.a = cVar;
            this.f11755b = gVar;
            this.f11756c = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            this.f11757d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11758e) {
                return;
            }
            this.f11758e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11758e) {
                h.a.c1.a.b(th);
            } else {
                this.f11758e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f11757d.request(1L);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11757d, dVar)) {
                this.f11757d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11757d.request(j2);
        }

        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            int i2;
            if (this.f11758e) {
                return false;
            }
            long j2 = 0;
            do {
                try {
                    this.f11755b.accept(t);
                    this.a.onNext(t);
                    return true;
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    try {
                        j2++;
                        i2 = a.a[((h.a.b1.a) h.a.y0.b.b.a(this.f11756c.apply(Long.valueOf(j2), th), "The errorHandler returned a null item")).ordinal()];
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

    public c(h.a.b1.b<T> bVar, h.a.x0.g<? super T> gVar, h.a.x0.c<? super Long, ? super Throwable, h.a.b1.a> cVar) {
        this.a = bVar;
        this.f11749b = gVar;
        this.f11750c = cVar;
    }

    @Override // h.a.b1.b
    public void a(j.d.c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            j.d.c<? super T>[] cVarArr2 = new j.d.c[length];
            for (int i2 = 0; i2 < length; i2++) {
                j.d.c<? super T> cVar = cVarArr[i2];
                if (cVar instanceof h.a.y0.c.a) {
                    cVarArr2[i2] = new b((h.a.y0.c.a) cVar, this.f11749b, this.f11750c);
                } else {
                    cVarArr2[i2] = new C0224c(cVar, this.f11749b, this.f11750c);
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
