package h.a.y0.e.c;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeConcatIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends h.a.y<? extends T>> f11134b;

    /* JADX INFO: compiled from: MaybeConcatIterable.java */
    static final class a<T> extends AtomicInteger implements h.a.v<T>, j.d.d {
        private static final long serialVersionUID = 3520831347801429610L;
        final j.d.c<? super T> actual;
        long produced;
        final Iterator<? extends h.a.y<? extends T>> sources;
        final AtomicLong requested = new AtomicLong();
        final h.a.y0.a.k disposables = new h.a.y0.a.k();
        final AtomicReference<Object> current = new AtomicReference<>(h.a.y0.j.q.COMPLETE);

        a(j.d.c<? super T> cVar, Iterator<? extends h.a.y<? extends T>> it) {
            this.actual = cVar;
            this.sources = it;
        }

        @Override // j.d.d
        public void cancel() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            j.d.c<? super T> cVar = this.actual;
            h.a.y0.a.k kVar = this.disposables;
            while (!kVar.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != h.a.y0.j.q.COMPLETE) {
                        long j2 = this.produced;
                        if (j2 != this.requested.get()) {
                            this.produced = j2 + 1;
                            atomicReference.lazySet(null);
                            cVar.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !kVar.isDisposed()) {
                        try {
                            if (this.sources.hasNext()) {
                                try {
                                    ((h.a.y) h.a.y0.b.b.a(this.sources.next(), "The source Iterator returned a null MaybeSource")).a(this);
                                } catch (Throwable th) {
                                    h.a.v0.b.b(th);
                                    cVar.onError(th);
                                    return;
                                }
                            } else {
                                cVar.onComplete();
                            }
                        } catch (Throwable th2) {
                            h.a.v0.b.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // h.a.v
        public void onComplete() {
            this.current.lazySet(h.a.y0.j.q.COMPLETE);
            drain();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            this.disposables.replace(cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public g(Iterable<? extends h.a.y<? extends T>> iterable) {
        this.f11134b = iterable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        try {
            a aVar = new a(cVar, (Iterator) h.a.y0.b.b.a(this.f11134b.iterator(), "The sources Iterable returned a null Iterator"));
            cVar.onSubscribe(aVar);
            aVar.drain();
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
