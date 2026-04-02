package h.a.y0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: CompletableConcatIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends h.a.c {
    final Iterable<? extends h.a.i> a;

    /* JADX INFO: compiled from: CompletableConcatIterable.java */
    static final class a extends AtomicInteger implements h.a.f {
        private static final long serialVersionUID = -7965400327305809232L;
        final h.a.f actual;
        final h.a.y0.a.k sd = new h.a.y0.a.k();
        final Iterator<? extends h.a.i> sources;

        a(h.a.f fVar, Iterator<? extends h.a.i> it) {
            this.actual = fVar;
            this.sources = it;
        }

        void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                Iterator<? extends h.a.i> it = this.sources;
                while (!this.sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onComplete();
                            return;
                        }
                        try {
                            ((h.a.i) h.a.y0.b.b.a(it.next(), "The CompletableSource returned is null")).a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // h.a.f
        public void onComplete() {
            next();
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            this.sd.replace(cVar);
        }
    }

    public e(Iterable<? extends h.a.i> iterable) {
        this.a = iterable;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        try {
            a aVar = new a(fVar, (Iterator) h.a.y0.b.b.a(this.a.iterator(), "The iterator returned is null"));
            fVar.onSubscribe(aVar.sd);
            aVar.next();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.a.e.error(th, fVar);
        }
    }
}
