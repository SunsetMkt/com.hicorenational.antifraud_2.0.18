package p251g.p252a.p268y0.p280f;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;

/* compiled from: MpscLinkedQueue.java */
/* renamed from: g.a.y0.f.a */
/* loaded from: classes2.dex */
public final class C5109a<T> implements InterfaceC4615n<T> {

    /* renamed from: a */
    private final AtomicReference<a<T>> f19826a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<a<T>> f19827b = new AtomicReference<>();

    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: g.a.y0.f.a$a */
    static final class a<E> extends AtomicReference<a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        a() {
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public a<E> lvNext() {
            return get();
        }

        public void soNext(a<E> aVar) {
            lazySet(aVar);
        }

        public void spValue(E e2) {
            this.value = e2;
        }

        a(E e2) {
            spValue(e2);
        }
    }

    public C5109a() {
        a<T> aVar = new a<>();
        m18533a(aVar);
        m18535b(aVar);
    }

    /* renamed from: a */
    a<T> m18532a() {
        return this.f19827b.get();
    }

    /* renamed from: b */
    a<T> m18535b(a<T> aVar) {
        return this.f19826a.getAndSet(aVar);
    }

    /* renamed from: c */
    a<T> m18536c() {
        return this.f19826a.get();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return m18534b() == m18536c();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        a<T> aVar = new a<>(t);
        m18535b(aVar).soNext(aVar);
        return true;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4615n, p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public T poll() {
        a<T> lvNext;
        a<T> m18532a = m18532a();
        a<T> lvNext2 = m18532a.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            m18533a(lvNext2);
            return andNullValue;
        }
        if (m18532a == m18536c()) {
            return null;
        }
        do {
            lvNext = m18532a.lvNext();
        } while (lvNext == null);
        T andNullValue2 = lvNext.getAndNullValue();
        m18533a(lvNext);
        return andNullValue2;
    }

    /* renamed from: a */
    void m18533a(a<T> aVar) {
        this.f19827b.lazySet(aVar);
    }

    /* renamed from: b */
    a<T> m18534b() {
        return this.f19827b.get();
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
