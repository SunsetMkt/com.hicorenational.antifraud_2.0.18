package h.a.y0.e.b;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableDistinct.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0<T, K> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, K> f10731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f10732d;

    /* JADX INFO: compiled from: FlowableDistinct.java */
    static final class a<T, K> extends h.a.y0.h.b<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Collection<? super K> f10733f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x0.o<? super T, K> f10734g;

        a(j.d.c<? super T> cVar, h.a.x0.o<? super T, K> oVar, Collection<? super K> collection) {
            super(cVar);
            this.f10734g = oVar;
            this.f10733f = collection;
        }

        @Override // h.a.y0.h.b, h.a.y0.c.o
        public void clear() {
            this.f10733f.clear();
            super.clear();
        }

        @Override // h.a.y0.h.b, j.d.c
        public void onComplete() {
            if (this.f12011d) {
                return;
            }
            this.f12011d = true;
            this.f10733f.clear();
            this.a.onComplete();
        }

        @Override // h.a.y0.h.b, j.d.c
        public void onError(Throwable th) {
            if (this.f12011d) {
                h.a.c1.a.b(th);
                return;
            }
            this.f12011d = true;
            this.f10733f.clear();
            this.a.onError(th);
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
                if (this.f10733f.add(h.a.y0.b.b.a(this.f10734g.apply(t), "The keySelector returned a null key"))) {
                    this.a.onNext((Object) t);
                } else {
                    this.f12009b.request(1L);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            T tPoll;
            while (true) {
                tPoll = this.f12010c.poll();
                if (tPoll == null || this.f10733f.add((Object) h.a.y0.b.b.a(this.f10734g.apply(tPoll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f12012e == 2) {
                    this.f12009b.request(1L);
                }
            }
            return tPoll;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return a(i2);
        }
    }

    public k0(h.a.l<T> lVar, h.a.x0.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(lVar);
        this.f10731c = oVar;
        this.f10732d = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        try {
            this.f10561b.a((h.a.q) new a(cVar, this.f10731c, (Collection) h.a.y0.b.b.a(this.f10732d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
