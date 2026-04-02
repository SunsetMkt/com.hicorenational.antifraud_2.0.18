package h.a.y0.e.f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SingleInternalHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    /* JADX INFO: compiled from: SingleInternalHelper.java */
    enum a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: SingleInternalHelper.java */
    enum b implements h.a.x0.o<h.a.q0, j.d.b> {
        INSTANCE;

        @Override // h.a.x0.o
        public j.d.b apply(h.a.q0 q0Var) {
            return new q0(q0Var);
        }
    }

    /* JADX INFO: compiled from: SingleInternalHelper.java */
    static final class c<T> implements Iterable<h.a.l<T>> {
        private final Iterable<? extends h.a.q0<? extends T>> a;

        c(Iterable<? extends h.a.q0<? extends T>> iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<h.a.l<T>> iterator() {
            return new d(this.a.iterator());
        }
    }

    /* JADX INFO: compiled from: SingleInternalHelper.java */
    static final class d<T> implements Iterator<h.a.l<T>> {
        private final Iterator<? extends h.a.q0<? extends T>> a;

        d(Iterator<? extends h.a.q0<? extends T>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public h.a.l<T> next() {
            return new q0(this.a.next());
        }
    }

    /* JADX INFO: compiled from: SingleInternalHelper.java */
    enum e implements h.a.x0.o<h.a.q0, h.a.b0> {
        INSTANCE;

        @Override // h.a.x0.o
        public h.a.b0 apply(h.a.q0 q0Var) {
            return new r0(q0Var);
        }
    }

    private e0() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> a() {
        return a.INSTANCE;
    }

    public static <T> h.a.x0.o<h.a.q0<? extends T>, j.d.b<? extends T>> b() {
        return b.INSTANCE;
    }

    public static <T> h.a.x0.o<h.a.q0<? extends T>, h.a.b0<? extends T>> c() {
        return e.INSTANCE;
    }

    public static <T> Iterable<? extends h.a.l<T>> a(Iterable<? extends h.a.q0<? extends T>> iterable) {
        return new c(iterable);
    }
}
