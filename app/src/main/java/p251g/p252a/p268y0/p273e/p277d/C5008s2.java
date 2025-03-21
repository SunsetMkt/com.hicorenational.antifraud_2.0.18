package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;

/* compiled from: ObservableScalarXMap.java */
/* renamed from: g.a.y0.e.d.s2 */
/* loaded from: classes2.dex */
public final class C5008s2 {

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: g.a.y0.e.d.s2$a */
    public static final class a<T> extends AtomicInteger implements InterfaceC4611j<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final InterfaceC4514i0<? super T> observer;
        final T value;

        public a(InterfaceC4514i0<? super T> interfaceC4514i0, T t) {
            this.observer = interfaceC4514i0;
            this.value = t;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            lazySet(3);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            set(3);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: g.a.y0.e.d.s2$b */
    static final class b<T, R> extends AbstractC4469b0<R> {

        /* renamed from: a */
        final T f19379a;

        /* renamed from: b */
        final InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> f19380b;

        b(T t, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
            this.f19379a = t;
            this.f19380b = interfaceC4584o;
        }

        @Override // p251g.p252a.AbstractC4469b0
        /* renamed from: d */
        public void mo16855d(InterfaceC4514i0<? super R> interfaceC4514i0) {
            try {
                InterfaceC4504g0 interfaceC4504g0 = (InterfaceC4504g0) C4601b.m18284a(this.f19380b.apply(this.f19379a), "The mapper returned a null ObservableSource");
                if (!(interfaceC4504g0 instanceof Callable)) {
                    interfaceC4504g0.subscribe(interfaceC4514i0);
                    return;
                }
                try {
                    Object call = ((Callable) interfaceC4504g0).call();
                    if (call == null) {
                        EnumC4593e.complete(interfaceC4514i0);
                        return;
                    }
                    a aVar = new a(interfaceC4514i0, call);
                    interfaceC4514i0.onSubscribe(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    EnumC4593e.error(th, interfaceC4514i0);
                }
            } catch (Throwable th2) {
                EnumC4593e.error(th2, interfaceC4514i0);
            }
        }
    }

    private C5008s2() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T, R> boolean m18520a(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4514i0<? super R> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends R>> interfaceC4584o) {
        if (!(interfaceC4504g0 instanceof Callable)) {
            return false;
        }
        try {
            InterfaceC0000a interfaceC0000a = (Object) ((Callable) interfaceC4504g0).call();
            if (interfaceC0000a == null) {
                EnumC4593e.complete(interfaceC4514i0);
                return true;
            }
            try {
                InterfaceC4504g0 interfaceC4504g02 = (InterfaceC4504g0) C4601b.m18284a(interfaceC4584o.apply(interfaceC0000a), "The mapper returned a null ObservableSource");
                if (interfaceC4504g02 instanceof Callable) {
                    try {
                        Object call = ((Callable) interfaceC4504g02).call();
                        if (call == null) {
                            EnumC4593e.complete(interfaceC4514i0);
                            return true;
                        }
                        a aVar = new a(interfaceC4514i0, call);
                        interfaceC4514i0.onSubscribe(aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        EnumC4593e.error(th, interfaceC4514i0);
                        return true;
                    }
                } else {
                    interfaceC4504g02.subscribe(interfaceC4514i0);
                }
                return true;
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                EnumC4593e.error(th2, interfaceC4514i0);
                return true;
            }
        } catch (Throwable th3) {
            C4561b.m18199b(th3);
            EnumC4593e.error(th3, interfaceC4514i0);
            return true;
        }
    }

    /* renamed from: a */
    public static <T, U> AbstractC4469b0<U> m18519a(T t, InterfaceC4584o<? super T, ? extends InterfaceC4504g0<? extends U>> interfaceC4584o) {
        return C4476a.m17119a(new b(t, interfaceC4584o));
    }
}
