package h.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BlockingObservableLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements Iterable<T> {
    final h.a.g0<T> a;

    /* JADX INFO: compiled from: BlockingObservableLatest.java */
    static final class a<T> extends h.a.a1.e<h.a.a0<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        h.a.a0<T> f11255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Semaphore f11256c = new Semaphore(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<h.a.a0<T>> f11257d = new AtomicReference<>();

        a() {
        }

        @Override // h.a.i0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f11257d.getAndSet(a0Var) == null) {
                this.f11256c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            h.a.a0<T> a0Var = this.f11255b;
            if (a0Var != null && a0Var.d()) {
                throw h.a.y0.j.k.c(this.f11255b.a());
            }
            if (this.f11255b == null) {
                try {
                    h.a.y0.j.e.a();
                    this.f11256c.acquire();
                    h.a.a0<T> andSet = this.f11257d.getAndSet(null);
                    this.f11255b = andSet;
                    if (andSet.d()) {
                        throw h.a.y0.j.k.c(andSet.a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f11255b = h.a.a0.a((Throwable) e2);
                    throw h.a.y0.j.k.c(e2);
                }
            }
            return this.f11255b.e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = this.f11255b.b();
            this.f11255b = null;
            return tB;
        }

        @Override // h.a.i0
        public void onComplete() {
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            h.a.c1.a.b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(h.a.g0<T> g0Var) {
        this.a = g0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        h.a.b0.v(this.a).t().subscribe(aVar);
        return aVar;
    }
}
