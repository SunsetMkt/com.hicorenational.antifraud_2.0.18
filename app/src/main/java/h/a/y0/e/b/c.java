package h.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BlockingFlowableLatest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T> implements Iterable<T> {
    final j.d.b<? extends T> a;

    /* JADX INFO: compiled from: BlockingFlowableLatest.java */
    static final class a<T> extends h.a.g1.b<h.a.a0<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Semaphore f10587b = new Semaphore(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference<h.a.a0<T>> f10588c = new AtomicReference<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.a0<T> f10589d;

        a() {
        }

        @Override // j.d.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(h.a.a0<T> a0Var) {
            if (this.f10588c.getAndSet(a0Var) == null) {
                this.f10587b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            h.a.a0<T> a0Var = this.f10589d;
            if (a0Var != null && a0Var.d()) {
                throw h.a.y0.j.k.c(this.f10589d.a());
            }
            h.a.a0<T> a0Var2 = this.f10589d;
            if ((a0Var2 == null || a0Var2.e()) && this.f10589d == null) {
                try {
                    h.a.y0.j.e.a();
                    this.f10587b.acquire();
                    h.a.a0<T> andSet = this.f10588c.getAndSet(null);
                    this.f10589d = andSet;
                    if (andSet.d()) {
                        throw h.a.y0.j.k.c(andSet.a());
                    }
                } catch (InterruptedException e2) {
                    dispose();
                    this.f10589d = h.a.a0.a((Throwable) e2);
                    throw h.a.y0.j.k.c(e2);
                }
            }
            return this.f10589d.e();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f10589d.e()) {
                throw new NoSuchElementException();
            }
            T tB = this.f10589d.b();
            this.f10589d = null;
            return tB;
        }

        @Override // j.d.c
        public void onComplete() {
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.c1.a.b(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(j.d.b<? extends T> bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        h.a.l.q(this.a).t().a((h.a.q<? super h.a.a0<T>>) aVar);
        return aVar;
    }
}
