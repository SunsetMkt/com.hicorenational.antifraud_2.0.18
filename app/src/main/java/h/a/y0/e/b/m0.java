package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDoAfterNext.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class m0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super T> f10785c;

    /* JADX INFO: compiled from: FlowableDoAfterNext.java */
    static final class a<T> extends h.a.y0.h.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.g<? super T> f10786f;

        a(h.a.y0.c.a<? super T> aVar, h.a.x0.g<? super T> gVar) {
            super(aVar);
            this.f10786f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            this.a.onNext((Object) t);
            if (this.f12008e == 0) {
                try {
                    this.f10786f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f12006c.poll();
            if (tPoll != null) {
                this.f10786f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.y0.c.a
        public boolean tryOnNext(T t) {
            boolean zTryOnNext = this.a.tryOnNext((Object) t);
            try {
                this.f10786f.accept(t);
            } catch (Throwable th) {
                a(th);
            }
            return zTryOnNext;
        }
    }

    /* JADX INFO: compiled from: FlowableDoAfterNext.java */
    static final class b<T> extends h.a.y0.h.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.g<? super T> f10787f;

        b(j.d.c<? super T> cVar, h.a.x0.g<? super T> gVar) {
            super(cVar);
            this.f10787f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.f12011d) {
                return;
            }
            this.a.onNext((Object) t);
            if (this.f12012e == 0) {
                try {
                    this.f10787f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll = this.f12010c.poll();
            if (tPoll != null) {
                this.f10787f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public m0(h.a.l<T> lVar, h.a.x0.g<? super T> gVar) {
        super(lVar);
        this.f10785c = gVar;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f10785c));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f10785c));
        }
    }
}
