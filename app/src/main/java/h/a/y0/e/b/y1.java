package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y1<T, U> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends U> f11071c;

    /* JADX INFO: compiled from: FlowableMap.java */
    static final class a<T, U> extends h.a.y0.h.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends U> f11072f;

        a(h.a.y0.c.a<? super U> aVar, h.a.x0.o<? super T, ? extends U> oVar) {
            super(aVar);
            this.f11072f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.f12007d) {
                return;
            }
            if (this.f12008e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext((Object) h.a.y0.b.b.a(this.f11072f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f12006c.poll();
            if (tPoll != null) {
                return (U) h.a.y0.b.b.a(this.f11072f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
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
            try {
                return this.a.tryOnNext((Object) h.a.y0.b.b.a(this.f11072f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableMap.java */
    static final class b<T, U> extends h.a.y0.h.b<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.o<? super T, ? extends U> f11073f;

        b(j.d.c<? super U> cVar, h.a.x0.o<? super T, ? extends U> oVar) {
            super(cVar);
            this.f11073f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.f12011d) {
                return;
            }
            if (this.f12012e != 0) {
                this.a.onNext(null);
                return;
            }
            try {
                this.a.onNext((Object) h.a.y0.b.b.a(this.f11073f.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public U poll() throws Exception {
            T tPoll = this.f12010c.poll();
            if (tPoll != null) {
                return (U) h.a.y0.b.b.a(this.f11073f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public y1(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends U> oVar) {
        super(lVar);
        this.f11071c = oVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f11071c));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f11071c));
        }
    }
}
