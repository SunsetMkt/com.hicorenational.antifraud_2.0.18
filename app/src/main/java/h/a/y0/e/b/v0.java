package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableFilter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.r<? super T> f11015c;

    /* JADX INFO: compiled from: FlowableFilter.java */
    static final class a<T> extends h.a.y0.h.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.r<? super T> f11016f;

        a(h.a.y0.c.a<? super T> aVar, h.a.x0.r<? super T> rVar) {
            super(aVar);
            this.f11016f = rVar;
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
            h.a.y0.c.l<T> lVar = this.f12006c;
            h.a.x0.r<? super T> rVar = this.f11016f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f12008e == 2) {
                    lVar.request(1L);
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
                return this.a.tryOnNext(null);
            }
            try {
                return this.f11016f.test(t) && this.a.tryOnNext((Object) t);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableFilter.java */
    static final class b<T> extends h.a.y0.h.b<T, T> implements h.a.y0.c.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.r<? super T> f11017f;

        b(j.d.c<? super T> cVar, h.a.x0.r<? super T> rVar) {
            super(cVar);
            this.f11017f = rVar;
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
            h.a.y0.c.l<T> lVar = this.f12010c;
            h.a.x0.r<? super T> rVar = this.f11017f;
            while (true) {
                T tPoll = lVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (rVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.f12012e == 2) {
                    lVar.request(1L);
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
                this.a.onNext(null);
                return true;
            }
            try {
                boolean zTest = this.f11017f.test(t);
                if (zTest) {
                    this.a.onNext((Object) t);
                }
                return zTest;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    public v0(h.a.l<T> lVar, h.a.x0.r<? super T> rVar) {
        super(lVar);
        this.f11015c = rVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f11015c));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f11015c));
        }
    }
}
