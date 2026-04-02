package h.a.y0.e.b;

import java.util.Iterator;

/* JADX INFO: compiled from: FlowableZipIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t4<T, U, V> extends h.a.y0.e.b.a<T, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable<U> f10997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.c<? super T, ? super U, ? extends V> f10998d;

    /* JADX INFO: compiled from: FlowableZipIterable.java */
    static final class a<T, U, V> implements h.a.q<T>, j.d.d {
        final j.d.c<? super V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<U> f10999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final h.a.x0.c<? super T, ? super U, ? extends V> f11000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j.d.d f11001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11002e;

        a(j.d.c<? super V> cVar, Iterator<U> it, h.a.x0.c<? super T, ? super U, ? extends V> cVar2) {
            this.a = cVar;
            this.f10999b = it;
            this.f11000c = cVar2;
        }

        void a(Throwable th) {
            h.a.v0.b.b(th);
            this.f11002e = true;
            this.f11001d.cancel();
            this.a.onError(th);
        }

        @Override // j.d.d
        public void cancel() {
            this.f11001d.cancel();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f11002e) {
                return;
            }
            this.f11002e = true;
            this.a.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f11002e) {
                h.a.c1.a.b(th);
            } else {
                this.f11002e = true;
                this.a.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f11002e) {
                return;
            }
            try {
                try {
                    this.a.onNext(h.a.y0.b.b.a(this.f11000c.apply(t, h.a.y0.b.b.a(this.f10999b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f10999b.hasNext()) {
                            return;
                        }
                        this.f11002e = true;
                        this.f11001d.cancel();
                        this.a.onComplete();
                    } catch (Throwable th) {
                        a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f11001d, dVar)) {
                this.f11001d = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f11001d.request(j2);
        }
    }

    public t4(h.a.l<T> lVar, Iterable<U> iterable, h.a.x0.c<? super T, ? super U, ? extends V> cVar) {
        super(lVar);
        this.f10997c = iterable;
        this.f10998d = cVar;
    }

    @Override // h.a.l
    public void d(j.d.c<? super V> cVar) {
        try {
            Iterator it = (Iterator) h.a.y0.b.b.a(this.f10997c.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f10561b.a((h.a.q) new a(cVar, it, this.f10998d));
                } else {
                    h.a.y0.i.g.complete(cVar);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.i.g.error(th, cVar);
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.y0.i.g.error(th2, cVar);
        }
    }
}
