package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l0<T, K> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, K> f10748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.d<? super K, ? super K> f10749d;

    /* JADX INFO: compiled from: FlowableDistinctUntilChanged.java */
    static final class a<T, K> extends h.a.y0.h.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, K> f10750f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.d<? super K, ? super K> f10751g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        K f10752h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f10753i;

        a(h.a.y0.c.a<? super T> aVar, h.a.x0.o<? super T, K> oVar, h.a.x0.d<? super K, ? super K> dVar) {
            super(aVar);
            this.f10750f = oVar;
            this.f10751g = dVar;
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f12005b.request(1L);
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f12006c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f10750f.apply(tPoll);
                if (!this.f10753i) {
                    this.f10753i = true;
                    this.f10752h = kApply;
                    return tPoll;
                }
                if (!this.f10751g.a(this.f10752h, kApply)) {
                    this.f10752h = kApply;
                    return tPoll;
                }
                this.f10752h = kApply;
                if (this.f12008e != 1) {
                    this.f12005b.request(1L);
                }
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f12007d) {
                return false;
            }
            if (this.f12008e != 0) {
                return this.a.tryOnNext((Object) t);
            }
            try {
                K kApply = this.f10750f.apply(t);
                if (this.f10753i) {
                    boolean zA = this.f10751g.a(this.f10752h, kApply);
                    this.f10752h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f10753i = true;
                    this.f10752h = kApply;
                }
                this.a.onNext((Object) t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableDistinctUntilChanged.java */
    static final class b<T, K> extends h.a.y0.h.b<T, T> implements h.a.y0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, K> f10754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.d<? super K, ? super K> f10755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        K f10756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f10757i;

        b(j.d.c<? super T> cVar, h.a.x0.o<? super T, K> oVar, h.a.x0.d<? super K, ? super K> dVar) {
            super(cVar);
            this.f10754f = oVar;
            this.f10755g = dVar;
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.f12009b.request(1L);
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f12010c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f10754f.apply(tPoll);
                if (!this.f10757i) {
                    this.f10757i = true;
                    this.f10756h = kApply;
                    return tPoll;
                }
                if (!this.f10755g.a(this.f10756h, kApply)) {
                    this.f10756h = kApply;
                    return tPoll;
                }
                this.f10756h = kApply;
                if (this.f12012e != 1) {
                    this.f12009b.request(1L);
                }
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            if (this.f12011d) {
                return false;
            }
            if (this.f12012e != 0) {
                this.a.onNext((Object) t);
                return true;
            }
            try {
                K kApply = this.f10754f.apply(t);
                if (this.f10757i) {
                    boolean zA = this.f10755g.a(this.f10756h, kApply);
                    this.f10756h = kApply;
                    if (zA) {
                        return false;
                    }
                } else {
                    this.f10757i = true;
                    this.f10756h = kApply;
                }
                this.a.onNext((Object) t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    public l0(h.a.l<T> lVar, h.a.x0.o<? super T, K> oVar, h.a.x0.d<? super K, ? super K> dVar) {
        super(lVar);
        this.f10748c = oVar;
        this.f10749d = dVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f10748c, this.f10749d));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f10748c, this.f10749d));
        }
    }
}
