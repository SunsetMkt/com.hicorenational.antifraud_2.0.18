package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.AbstractC4619b;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableFlatMapCompletable.java */
/* renamed from: g.a.y0.e.d.v0 */
/* loaded from: classes2.dex */
public final class C5021v0<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f19441b;

    /* renamed from: c */
    final boolean f19442c;

    /* compiled from: ObservableFlatMapCompletable.java */
    /* renamed from: g.a.y0.e.d.v0$a */
    static final class a<T> extends AbstractC4619b<T> implements InterfaceC4514i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final InterfaceC4514i0<? super T> actual;

        /* renamed from: d */
        InterfaceC4552c f19443d;
        final boolean delayErrors;
        volatile boolean disposed;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;
        final C5163c errors = new C5163c();
        final C4551b set = new C4551b();

        /* compiled from: ObservableFlatMapCompletable.java */
        /* renamed from: g.a.y0.e.d.v0$a$a, reason: collision with other inner class name */
        final class C7417a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
            private static final long serialVersionUID = 8606673141535671828L;

            C7417a() {
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public void dispose() {
                EnumC4592d.dispose(this);
            }

            @Override // p251g.p252a.p264u0.InterfaceC4552c
            public boolean isDisposed() {
                return EnumC4592d.isDisposed(get());
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // p251g.p252a.InterfaceC4491f
            public void onSubscribe(InterfaceC4552c interfaceC4552c) {
                EnumC4592d.setOnce(this, interfaceC4552c);
            }
        }

        a(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z) {
            this.actual = interfaceC4514i0;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.disposed = true;
            this.f19443d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C7417a c7417a) {
            this.set.mo18182c(c7417a);
            onComplete();
        }

        void innerError(a<T>.C7417a c7417a, Throwable th) {
            this.set.mo18182c(c7417a);
            onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19443d.isDisposed();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return true;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            try {
                InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C7417a c7417a = new C7417a();
                if (this.disposed || !this.set.mo18181b(c7417a)) {
                    return;
                }
                interfaceC4513i.mo17074a(c7417a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19443d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19443d, interfaceC4552c)) {
                this.f19443d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            return null;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public C5021v0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z) {
        super(interfaceC4504g0);
        this.f19441b = interfaceC4584o;
        this.f19442c = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19441b, this.f19442c));
    }
}
