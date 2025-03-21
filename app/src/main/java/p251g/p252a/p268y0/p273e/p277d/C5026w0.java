package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4605d;
import p251g.p252a.p268y0.p284j.C5163c;

/* compiled from: ObservableFlatMapCompletableCompletable.java */
/* renamed from: g.a.y0.e.d.w0 */
/* loaded from: classes2.dex */
public final class C5026w0<T> extends AbstractC4474c implements InterfaceC4605d<T> {

    /* renamed from: a */
    final InterfaceC4504g0<T> f19472a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f19473b;

    /* renamed from: c */
    final boolean f19474c;

    /* compiled from: ObservableFlatMapCompletableCompletable.java */
    /* renamed from: g.a.y0.e.d.w0$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4552c, InterfaceC4514i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final InterfaceC4491f actual;

        /* renamed from: d */
        InterfaceC4552c f19475d;
        final boolean delayErrors;
        volatile boolean disposed;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;
        final C5163c errors = new C5163c();
        final C4551b set = new C4551b();

        /* compiled from: ObservableFlatMapCompletableCompletable.java */
        /* renamed from: g.a.y0.e.d.w0$a$a, reason: collision with other inner class name */
        final class C7419a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
            private static final long serialVersionUID = 8606673141535671828L;

            C7419a() {
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

        a(InterfaceC4491f interfaceC4491f, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z) {
            this.actual = interfaceC4491f;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.disposed = true;
            this.f19475d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C7419a c7419a) {
            this.set.mo18182c(c7419a);
            onComplete();
        }

        void innerError(a<T>.C7419a c7419a, Throwable th) {
            this.set.mo18182c(c7419a);
            onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19475d.isDisposed();
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
                C7419a c7419a = new C7419a();
                if (this.disposed || !this.set.mo18181b(c7419a)) {
                    return;
                }
                interfaceC4513i.mo17074a(c7419a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f19475d.dispose();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19475d, interfaceC4552c)) {
                this.f19475d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C5026w0(InterfaceC4504g0<T> interfaceC4504g0, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z) {
        this.f19472a = interfaceC4504g0;
        this.f19473b = interfaceC4584o;
        this.f19474c = z;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4605d
    /* renamed from: a */
    public AbstractC4469b0<T> mo18288a() {
        return C4476a.m17119a(new C5021v0(this.f19472a, this.f19473b, this.f19474c));
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f19472a.subscribe(new a(interfaceC4491f, this.f19473b, this.f19474c));
    }
}
