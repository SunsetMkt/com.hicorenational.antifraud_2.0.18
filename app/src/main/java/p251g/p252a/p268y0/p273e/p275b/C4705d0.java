package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p259g1.AbstractC4506b;
import p251g.p252a.p259g1.C4509e;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5821b;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableDebounce.java */
/* renamed from: g.a.y0.e.b.d0 */
/* loaded from: classes2.dex */
public final class C4705d0<T, U> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> f17819c;

    /* compiled from: FlowableDebounce.java */
    /* renamed from: g.a.y0.e.b.d0$a */
    static final class a<T, U> extends AtomicLong implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 6725975399620862591L;
        final InterfaceC5822c<? super T> actual;
        final InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> debounceSelector;
        final AtomicReference<InterfaceC4552c> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;

        /* renamed from: s */
        InterfaceC5823d f17820s;

        /* compiled from: FlowableDebounce.java */
        /* renamed from: g.a.y0.e.b.d0$a$a, reason: collision with other inner class name */
        static final class C7390a<T, U> extends AbstractC4506b<U> {

            /* renamed from: b */
            final a<T, U> f17821b;

            /* renamed from: c */
            final long f17822c;

            /* renamed from: d */
            final T f17823d;

            /* renamed from: e */
            boolean f17824e;

            /* renamed from: f */
            final AtomicBoolean f17825f = new AtomicBoolean();

            C7390a(a<T, U> aVar, long j2, T t) {
                this.f17821b = aVar;
                this.f17822c = j2;
                this.f17823d = t;
            }

            /* renamed from: c */
            void m18315c() {
                if (this.f17825f.compareAndSet(false, true)) {
                    this.f17821b.emit(this.f17822c, this.f17823d);
                }
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onComplete() {
                if (this.f17824e) {
                    return;
                }
                this.f17824e = true;
                m18315c();
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onError(Throwable th) {
                if (this.f17824e) {
                    C4476a.m17152b(th);
                } else {
                    this.f17824e = true;
                    this.f17821b.onError(th);
                }
            }

            @Override // p324i.p338d.InterfaceC5822c
            public void onNext(U u) {
                if (this.f17824e) {
                    return;
                }
                this.f17824e = true;
                m17380a();
                m18315c();
            }
        }

        a(InterfaceC5822c<? super T> interfaceC5822c, InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> interfaceC4584o) {
            this.actual = interfaceC5822c;
            this.debounceSelector = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.f17820s.cancel();
            EnumC4592d.dispose(this.debouncer);
        }

        void emit(long j2, T t) {
            if (j2 == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    C5164d.m18610c(this, 1L);
                } else {
                    cancel();
                    this.actual.onError(new C4562c("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            InterfaceC4552c interfaceC4552c = this.debouncer.get();
            if (EnumC4592d.isDisposed(interfaceC4552c)) {
                return;
            }
            ((C7390a) interfaceC4552c).m18315c();
            EnumC4592d.dispose(this.debouncer);
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            EnumC4592d.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            InterfaceC4552c interfaceC4552c = this.debouncer.get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            try {
                InterfaceC5821b interfaceC5821b = (InterfaceC5821b) C4601b.m18284a(this.debounceSelector.apply(t), "The publisher supplied is null");
                C7390a c7390a = new C7390a(this, j2, t);
                if (this.debouncer.compareAndSet(interfaceC4552c, c7390a)) {
                    interfaceC5821b.subscribe(c7390a);
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                cancel();
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17820s, interfaceC5823d)) {
                this.f17820s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
            }
        }
    }

    public C4705d0(AbstractC4519l<T> abstractC4519l, InterfaceC4584o<? super T, ? extends InterfaceC5821b<U>> interfaceC4584o) {
        super(abstractC4519l);
        this.f17819c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(new C4509e(interfaceC5822c), this.f17819c));
    }
}
