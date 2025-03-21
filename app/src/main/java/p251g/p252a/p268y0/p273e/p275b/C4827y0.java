package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4603b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFlatMapCompletableCompletable.java */
/* renamed from: g.a.y0.e.b.y0 */
/* loaded from: classes2.dex */
public final class C4827y0<T> extends AbstractC4474c implements InterfaceC4603b<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f18520a;

    /* renamed from: b */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f18521b;

    /* renamed from: c */
    final int f18522c;

    /* renamed from: d */
    final boolean f18523d;

    /* compiled from: FlowableFlatMapCompletableCompletable.java */
    /* renamed from: g.a.y0.e.b.y0$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC4552c {
        private static final long serialVersionUID = 8443155186132538303L;
        final InterfaceC4491f actual;
        final boolean delayErrors;
        volatile boolean disposed;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;
        final int maxConcurrency;

        /* renamed from: s */
        InterfaceC5823d f18524s;
        final C5163c errors = new C5163c();
        final C4551b set = new C4551b();

        /* compiled from: FlowableFlatMapCompletableCompletable.java */
        /* renamed from: g.a.y0.e.b.y0$a$a, reason: collision with other inner class name */
        final class C7398a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
            private static final long serialVersionUID = 8606673141535671828L;

            C7398a() {
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

        a(InterfaceC4491f interfaceC4491f, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z, int i2) {
            this.actual = interfaceC4491f;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.disposed = true;
            this.f18524s.cancel();
            this.set.dispose();
        }

        void innerComplete(a<T>.C7398a c7398a) {
            this.set.mo18182c(c7398a);
            onComplete();
        }

        void innerError(a<T>.C7398a c7398a, Throwable th) {
            this.set.mo18182c(c7398a);
            onError(th);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.f18524s.request(1L);
                }
            } else {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f18524s.request(1L);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C7398a c7398a = new C7398a();
                if (this.disposed || !this.set.mo18181b(c7398a)) {
                    return;
                }
                interfaceC4513i.mo17074a(c7398a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18524s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18524s, interfaceC5823d)) {
                this.f18524s = interfaceC5823d;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    interfaceC5823d.request(C5556m0.f20396b);
                } else {
                    interfaceC5823d.request(i2);
                }
            }
        }
    }

    public C4827y0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z, int i2) {
        this.f18520a = abstractC4519l;
        this.f18521b = interfaceC4584o;
        this.f18523d = z;
        this.f18522c = i2;
    }

    @Override // p251g.p252a.AbstractC4474c
    /* renamed from: b */
    protected void mo17086b(InterfaceC4491f interfaceC4491f) {
        this.f18520a.m17799a((InterfaceC4529q) new a(interfaceC4491f, this.f18521b, this.f18523d, this.f18522c));
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4603b
    /* renamed from: b */
    public AbstractC4519l<T> mo18286b() {
        return C4476a.m17129a(new C4822x0(this.f18520a, this.f18521b, this.f18523d, this.f18522c));
    }
}
