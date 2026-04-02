package h.a.y0.f;

import h.a.t0.g;
import h.a.y0.c.n;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MpscLinkedQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements n<T> {
    private final AtomicReference<C0230a<T>> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0230a<T>> f11906b = new AtomicReference<>();

    /* JADX INFO: renamed from: h.a.y0.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MpscLinkedQueue.java */
    static final class C0230a<E> extends AtomicReference<C0230a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        C0230a() {
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public C0230a<E> lvNext() {
            return get();
        }

        public void soNext(C0230a<E> c0230a) {
            lazySet(c0230a);
        }

        public void spValue(E e2) {
            this.value = e2;
        }

        C0230a(E e2) {
            spValue(e2);
        }
    }

    public a() {
        C0230a<T> c0230a = new C0230a<>();
        a(c0230a);
        b(c0230a);
    }

    C0230a<T> a() {
        return this.f11906b.get();
    }

    C0230a<T> b(C0230a<T> c0230a) {
        return this.a.getAndSet(c0230a);
    }

    C0230a<T> c() {
        return this.a.get();
    }

    @Override // h.a.y0.c.o
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // h.a.y0.c.o
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // h.a.y0.c.o
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0230a<T> c0230a = new C0230a<>(t);
        b(c0230a).soNext(c0230a);
        return true;
    }

    @Override // h.a.y0.c.n, h.a.y0.c.o
    @g
    public T poll() {
        C0230a<T> c0230aLvNext;
        C0230a<T> c0230aA = a();
        C0230a<T> c0230aLvNext2 = c0230aA.lvNext();
        if (c0230aLvNext2 != null) {
            T andNullValue = c0230aLvNext2.getAndNullValue();
            a(c0230aLvNext2);
            return andNullValue;
        }
        if (c0230aA == c()) {
            return null;
        }
        do {
            c0230aLvNext = c0230aA.lvNext();
        } while (c0230aLvNext == null);
        T andNullValue2 = c0230aLvNext.getAndNullValue();
        a(c0230aLvNext);
        return andNullValue2;
    }

    void a(C0230a<T> c0230a) {
        this.f11906b.lazySet(c0230a);
    }

    C0230a<T> b() {
        return this.f11906b.get();
    }

    @Override // h.a.y0.c.o
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
