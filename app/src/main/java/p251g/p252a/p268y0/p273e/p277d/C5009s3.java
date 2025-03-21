package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.C4598j;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p272d.C4635q;

/* compiled from: ObservableTimeoutTimed.java */
/* renamed from: g.a.y0.e.d.s3 */
/* loaded from: classes2.dex */
public final class C5009s3<T> extends AbstractC4907a<T, T> {

    /* renamed from: f */
    static final InterfaceC4552c f19381f = new a();

    /* renamed from: b */
    final long f19382b;

    /* renamed from: c */
    final TimeUnit f19383c;

    /* renamed from: d */
    final AbstractC4516j0 f19384d;

    /* renamed from: e */
    final InterfaceC4504g0<? extends T> f19385e;

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.d.s3$a */
    static final class a implements InterfaceC4552c {
        a() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return true;
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.d.s3$b */
    static final class b<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -8387234228317808253L;
        final InterfaceC4514i0<? super T> actual;
        volatile boolean done;
        volatile long index;

        /* renamed from: s */
        InterfaceC4552c f19386s;
        final long timeout;
        final TimeUnit unit;
        final AbstractC4516j0.c worker;

        /* compiled from: ObservableTimeoutTimed.java */
        /* renamed from: g.a.y0.e.d.s3$b$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final long f19387a;

            a(long j2) {
                this.f19387a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19387a == b.this.index) {
                    b bVar = b.this;
                    bVar.done = true;
                    bVar.f19386s.dispose();
                    EnumC4592d.dispose(b.this);
                    b.this.actual.onError(new TimeoutException());
                    b.this.worker.dispose();
                }
            }
        }

        b(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar) {
            this.actual = interfaceC4514i0;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19386s.dispose();
            this.worker.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
            dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
            dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            this.actual.onNext(t);
            scheduleTimeout(j2);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19386s, interfaceC4552c)) {
                this.f19386s = interfaceC4552c;
                this.actual.onSubscribe(this);
                scheduleTimeout(0L);
            }
        }

        void scheduleTimeout(long j2) {
            InterfaceC4552c interfaceC4552c = get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            if (compareAndSet(interfaceC4552c, C5009s3.f19381f)) {
                EnumC4592d.replace(this, this.worker.mo17283a(new a(j2), this.timeout, this.unit));
            }
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* renamed from: g.a.y0.e.d.s3$c */
    static final class c<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -4619702551964128179L;
        final InterfaceC4514i0<? super T> actual;
        final C4598j<T> arbiter;
        volatile boolean done;
        volatile long index;
        final InterfaceC4504g0<? extends T> other;

        /* renamed from: s */
        InterfaceC4552c f19389s;
        final long timeout;
        final TimeUnit unit;
        final AbstractC4516j0.c worker;

        /* compiled from: ObservableTimeoutTimed.java */
        /* renamed from: g.a.y0.e.d.s3$c$a */
        final class a implements Runnable {

            /* renamed from: a */
            private final long f19390a;

            a(long j2) {
                this.f19390a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f19390a == c.this.index) {
                    c cVar = c.this;
                    cVar.done = true;
                    cVar.f19389s.dispose();
                    EnumC4592d.dispose(c.this);
                    c.this.subscribeNext();
                    c.this.worker.dispose();
                }
            }
        }

        c(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0.c cVar, InterfaceC4504g0<? extends T> interfaceC4504g0) {
            this.actual = interfaceC4514i0;
            this.timeout = j2;
            this.unit = timeUnit;
            this.worker = cVar;
            this.other = interfaceC4504g0;
            this.arbiter = new C4598j<>(interfaceC4514i0, this, 8);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f19389s.dispose();
            this.worker.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.arbiter.m18224a(this.f19389s);
            this.worker.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.done = true;
            this.arbiter.m18225a(th, this.f19389s);
            this.worker.dispose();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index + 1;
            this.index = j2;
            if (this.arbiter.m18226a((C4598j<T>) t, this.f19389s)) {
                scheduleTimeout(j2);
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19389s, interfaceC4552c)) {
                this.f19389s = interfaceC4552c;
                if (this.arbiter.m18228b(interfaceC4552c)) {
                    this.actual.onSubscribe(this.arbiter);
                    scheduleTimeout(0L);
                }
            }
        }

        void scheduleTimeout(long j2) {
            InterfaceC4552c interfaceC4552c = get();
            if (interfaceC4552c != null) {
                interfaceC4552c.dispose();
            }
            if (compareAndSet(interfaceC4552c, C5009s3.f19381f)) {
                EnumC4592d.replace(this, this.worker.mo17283a(new a(j2), this.timeout, this.unit));
            }
        }

        void subscribeNext() {
            this.other.subscribe(new C4635q(this.arbiter));
        }
    }

    public C5009s3(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, InterfaceC4504g0<? extends T> interfaceC4504g02) {
        super(interfaceC4504g0);
        this.f19382b = j2;
        this.f19383c = timeUnit;
        this.f19384d = abstractC4516j0;
        this.f19385e = interfaceC4504g02;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        if (this.f19385e == null) {
            this.f18742a.subscribe(new b(new C4466m(interfaceC4514i0), this.f19382b, this.f19383c, this.f19384d.mo17277a()));
        } else {
            this.f18742a.subscribe(new c(interfaceC4514i0, this.f19382b, this.f19383c, this.f19384d.mo17277a(), this.f19385e));
        }
    }
}
