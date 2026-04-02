package h.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BlockingFlowableMostRecent.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements Iterable<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f10602b;

    /* JADX INFO: compiled from: BlockingFlowableMostRecent.java */
    static final class a<T> extends h.a.g1.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Object f10603b;

        /* JADX INFO: renamed from: h.a.y0.e.b.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BlockingFlowableMostRecent.java */
        final class C0189a implements Iterator<T> {
            private Object a;

            C0189a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.a = a.this.f10603b;
                return !h.a.y0.j.q.isComplete(this.a);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.a == null) {
                        this.a = a.this.f10603b;
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
            this.f10603b = h.a.y0.j.q.next(t);
        }

        public a<T>.C0189a c() {
            return new C0189a();
        }

        @Override // j.d.c
        public void onComplete() {
            this.f10603b = h.a.y0.j.q.complete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.f10603b = h.a.y0.j.q.error(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.f10603b = h.a.y0.j.q.next(t);
        }
    }

    public d(h.a.l<T> lVar, T t) {
        this.a = lVar;
        this.f10602b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f10602b);
        this.a.a((h.a.q) aVar);
        return aVar.c();
    }
}
