package h.a.y0.e.d;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BlockingObservableMostRecent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements Iterable<T> {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f11288b;

    /* JADX INFO: compiled from: BlockingObservableMostRecent.java */
    static final class a<T> extends h.a.a1.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Object f11289b;

        /* JADX INFO: renamed from: h.a.y0.e.d.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BlockingObservableMostRecent.java */
        final class C0211a implements Iterator<T> {
            private Object a;

            C0211a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.a = a.this.f11289b;
                return !h.a.y0.j.q.isComplete(this.a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.a == null) {
                        this.a = a.this.f11289b;
                    }
                    if (h.a.y0.j.q.isComplete(this.a)) {
                        throw new NoSuchElementException();
                    }
                    if (h.a.y0.j.q.isError(this.a)) {
                        throw h.a.y0.j.k.c(h.a.y0.j.q.getError(this.a));
                    }
                    return (T) h.a.y0.j.q.getValue(this.a);
                } finally {
                    this.a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f11289b = h.a.y0.j.q.next(t);
        }

        public a<T>.C0211a c() {
            return new C0211a();
        }

        @Override // h.a.i0
        public void onComplete() {
            this.f11289b = h.a.y0.j.q.complete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11289b = h.a.y0.j.q.error(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.f11289b = h.a.y0.j.q.next(t);
        }
    }

    public d(h.a.g0<T> g0Var, T t) {
        this.a = g0Var;
        this.f11288b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f11288b);
        this.a.subscribe(aVar);
        return aVar.c();
    }
}
