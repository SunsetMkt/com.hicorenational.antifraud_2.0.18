package p251g.p252a.p268y0.p273e.p279f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p267x0.InterfaceC4584o;
import p324i.p338d.InterfaceC5821b;

/* compiled from: SingleInternalHelper.java */
/* renamed from: g.a.y0.e.f.e0 */
/* loaded from: classes2.dex */
public final class C5070e0 {

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: g.a.y0.e.f.e0$a */
    enum a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: g.a.y0.e.f.e0$b */
    enum b implements InterfaceC4584o<InterfaceC4530q0, InterfaceC5821b> {
        INSTANCE;

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public InterfaceC5821b apply(InterfaceC4530q0 interfaceC4530q0) {
            return new C5094q0(interfaceC4530q0);
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: g.a.y0.e.f.e0$c */
    static final class c<T> implements Iterable<AbstractC4519l<T>> {

        /* renamed from: a */
        private final Iterable<? extends InterfaceC4530q0<? extends T>> f19692a;

        c(Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
            this.f19692a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<AbstractC4519l<T>> iterator() {
            return new d(this.f19692a.iterator());
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: g.a.y0.e.f.e0$d */
    static final class d<T> implements Iterator<AbstractC4519l<T>> {

        /* renamed from: a */
        private final Iterator<? extends InterfaceC4530q0<? extends T>> f19693a;

        d(Iterator<? extends InterfaceC4530q0<? extends T>> it) {
            this.f19693a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19693a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public AbstractC4519l<T> next() {
            return new C5094q0(this.f19693a.next());
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* renamed from: g.a.y0.e.f.e0$e */
    enum e implements InterfaceC4584o<InterfaceC4530q0, AbstractC4469b0> {
        INSTANCE;

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        public AbstractC4469b0 apply(InterfaceC4530q0 interfaceC4530q0) {
            return new C5096r0(interfaceC4530q0);
        }
    }

    private C5070e0() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Callable<NoSuchElementException> m18528a() {
        return a.INSTANCE;
    }

    /* renamed from: b */
    public static <T> InterfaceC4584o<InterfaceC4530q0<? extends T>, InterfaceC5821b<? extends T>> m18529b() {
        return b.INSTANCE;
    }

    /* renamed from: c */
    public static <T> InterfaceC4584o<InterfaceC4530q0<? extends T>, AbstractC4469b0<? extends T>> m18530c() {
        return e.INSTANCE;
    }

    /* renamed from: a */
    public static <T> Iterable<? extends AbstractC4519l<T>> m18527a(Iterable<? extends InterfaceC4530q0<? extends T>> iterable) {
        return new c(iterable);
    }
}
