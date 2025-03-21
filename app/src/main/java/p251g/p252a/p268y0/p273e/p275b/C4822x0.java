package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableFlatMapCompletable.java */
/* renamed from: g.a.y0.e.b.x0 */
/* loaded from: classes2.dex */
public final class C4822x0<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC4513i> f18485c;

    /* renamed from: d */
    final int f18486d;

    /* renamed from: e */
    final boolean f18487e;

    /* compiled from: FlowableFlatMapCompletable.java */
    /* renamed from: g.a.y0.e.b.x0$a */
    static final class a<T> extends AbstractC5153c<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final InterfaceC4584o<? super T, ? extends InterfaceC4513i> mapper;
        final int maxConcurrency;

        /* renamed from: s */
        InterfaceC5823d f18488s;
        final C5163c errors = new C5163c();
        final C4551b set = new C4551b();

        /* compiled from: FlowableFlatMapCompletable.java */
        /* renamed from: g.a.y0.e.b.x0$a$a, reason: collision with other inner class name */
        final class C7397a extends AtomicReference<InterfaceC4552c> implements InterfaceC4491f, InterfaceC4552c {
            private static final long serialVersionUID = 8606673141535671828L;

            C7397a() {
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

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z, int i2) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f18488s.cancel();
            this.set.dispose();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
        }

        void innerComplete(a<T>.C7397a c7397a) {
            this.set.mo18182c(c7397a);
            onComplete();
        }

        void innerError(a<T>.C7397a c7397a, Throwable th) {
            this.set.mo18182c(c7397a);
            onError(th);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return true;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.f18488s.request(1L);
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
                cancel();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f18488s.request(1L);
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            try {
                InterfaceC4513i interfaceC4513i = (InterfaceC4513i) C4601b.m18284a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C7397a c7397a = new C7397a();
                if (this.cancelled || !this.set.mo18181b(c7397a)) {
                    return;
                }
                interfaceC4513i.mo17074a(c7397a);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f18488s.cancel();
                onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18488s, interfaceC5823d)) {
                this.f18488s = interfaceC5823d;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    interfaceC5823d.request(C5556m0.f20396b);
                } else {
                    interfaceC5823d.request(i2);
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            return null;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public C4822x0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC4513i> interfaceC4584o, boolean z, int i2) {
        super(abstractC4519l);
        this.f18485c = interfaceC4584o;
        this.f18487e = z;
        this.f18486d = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18485c, this.f18487e, this.f18486d));
    }
}
