package h.a.y0.e.b;

/* JADX INFO: compiled from: FlowableDoOnEach.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super T> f10840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.g<? super Throwable> f10841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.a f10842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x0.a f10843f;

    /* JADX INFO: compiled from: FlowableDoOnEach.java */
    static final class a<T> extends h.a.y0.h.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.g<? super T> f10844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.g<? super Throwable> f10845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.x0.a f10846h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final h.a.x0.a f10847i;

        a(h.a.y0.c.a<? super T> aVar, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar2, h.a.x0.a aVar3) {
            super(aVar);
            this.f10844f = gVar;
            this.f10845g = gVar2;
            this.f10846h = aVar2;
            this.f10847i = aVar3;
        }

        @Override // h.a.y0.h.a, j.d.c
        public void onComplete() {
            if (this.f12007d) {
                return;
            }
            try {
                this.f10846h.run();
                this.f12007d = true;
                this.a.onComplete();
                try {
                    this.f10847i.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // h.a.y0.h.a, j.d.c
        public void onError(Throwable th) {
            if (this.f12007d) {
                h.a.c1.a.b(th);
                return;
            }
            boolean z = true;
            this.f12007d = true;
            try {
                this.f10845g.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.f10847i.run();
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.c1.a.b(th3);
            }
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
                this.f10844f.accept(t);
                this.a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            try {
                T tPoll = this.f12006c.poll();
                if (tPoll != null) {
                    try {
                        this.f10844f.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            h.a.v0.b.b(th);
                            try {
                                this.f10845g.accept(th);
                                throw h.a.y0.j.k.b(th);
                            } catch (Throwable th2) {
                                throw new h.a.v0.a(th, th2);
                            }
                        } finally {
                            this.f10847i.run();
                        }
                    }
                } else if (this.f12008e == 1) {
                    this.f10846h.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                try {
                    this.f10845g.accept(th3);
                    throw h.a.y0.j.k.b(th3);
                } catch (Throwable th4) {
                    throw new h.a.v0.a(th3, th4);
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
            try {
                this.f10844f.accept(t);
                return this.a.tryOnNext((Object) t);
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableDoOnEach.java */
    static final class b<T> extends h.a.y0.h.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.x0.g<? super T> f10848f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.g<? super Throwable> f10849g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.x0.a f10850h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final h.a.x0.a f10851i;

        b(j.d.c<? super T> cVar, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
            super(cVar);
            this.f10848f = gVar;
            this.f10849g = gVar2;
            this.f10850h = aVar;
            this.f10851i = aVar2;
        }

        @Override // h.a.y0.h.b, j.d.c
        public void onComplete() {
            if (this.f12011d) {
                return;
            }
            try {
                this.f10850h.run();
                this.f12011d = true;
                this.a.onComplete();
                try {
                    this.f10851i.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }

        @Override // h.a.y0.h.b, j.d.c
        public void onError(Throwable th) {
            if (this.f12011d) {
                h.a.c1.a.b(th);
                return;
            }
            boolean z = true;
            this.f12011d = true;
            try {
                this.f10849g.accept(th);
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.a.onError(new h.a.v0.a(th, th2));
                z = false;
            }
            if (z) {
                this.a.onError(th);
            }
            try {
                this.f10851i.run();
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                h.a.c1.a.b(th3);
            }
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
                this.f10848f.accept(t);
                this.a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            try {
                T tPoll = this.f12010c.poll();
                if (tPoll != null) {
                    try {
                        this.f10848f.accept(tPoll);
                    } catch (Throwable th) {
                        try {
                            h.a.v0.b.b(th);
                            try {
                                this.f10849g.accept(th);
                                throw h.a.y0.j.k.b(th);
                            } catch (Throwable th2) {
                                throw new h.a.v0.a(th, th2);
                            }
                        } finally {
                            this.f10851i.run();
                        }
                    }
                } else if (this.f12012e == 1) {
                    this.f10850h.run();
                }
                return tPoll;
            } catch (Throwable th3) {
                h.a.v0.b.b(th3);
                try {
                    this.f10849g.accept(th3);
                    throw h.a.y0.j.k.b(th3);
                } catch (Throwable th4) {
                    throw new h.a.v0.a(th3, th4);
                }
            }
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public o0(h.a.l<T> lVar, h.a.x0.g<? super T> gVar, h.a.x0.g<? super Throwable> gVar2, h.a.x0.a aVar, h.a.x0.a aVar2) {
        super(lVar);
        this.f10840c = gVar;
        this.f10841d = gVar2;
        this.f10842e = aVar;
        this.f10843f = aVar2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        if (cVar instanceof h.a.y0.c.a) {
            this.f10561b.a((h.a.q) new a((h.a.y0.c.a) cVar, this.f10840c, this.f10841d, this.f10842e, this.f10843f));
        } else {
            this.f10561b.a((h.a.q) new b(cVar, this.f10840c, this.f10841d, this.f10842e, this.f10843f));
        }
    }
}
