package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p253a1.C4466m;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;

/* compiled from: ObservableSampleTimed.java */
/* renamed from: g.a.y0.e.d.q2 */
/* loaded from: classes2.dex */
public final class C4998q2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19327b;

    /* renamed from: c */
    final TimeUnit f19328c;

    /* renamed from: d */
    final AbstractC4516j0 f19329d;

    /* renamed from: e */
    final boolean f19330e;

    /* compiled from: ObservableSampleTimed.java */
    /* renamed from: g.a.y0.e.d.q2$a */
    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC4514i0, j2, timeUnit, abstractC4516j0);
            this.wip = new AtomicInteger(1);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4998q2.c
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* renamed from: g.a.y0.e.d.q2$b */
    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            super(interfaceC4514i0, j2, timeUnit, abstractC4516j0);
        }

        @Override // p251g.p252a.p268y0.p273e.p277d.C4998q2.c
        void complete() {
            this.actual.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    /* compiled from: ObservableSampleTimed.java */
    /* renamed from: g.a.y0.e.d.q2$c */
    static abstract class c<T> extends AtomicReference<T> implements InterfaceC4514i0<T>, InterfaceC4552c, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final InterfaceC4514i0<? super T> actual;
        final long period;

        /* renamed from: s */
        InterfaceC4552c f19331s;
        final AbstractC4516j0 scheduler;
        final AtomicReference<InterfaceC4552c> timer = new AtomicReference<>();
        final TimeUnit unit;

        c(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.actual = interfaceC4514i0;
            this.period = j2;
            this.unit = timeUnit;
            this.scheduler = abstractC4516j0;
        }

        void cancelTimer() {
            EnumC4592d.dispose(this.timer);
        }

        abstract void complete();

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            cancelTimer();
            this.f19331s.dispose();
        }

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19331s.isDisposed();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19331s, interfaceC4552c)) {
                this.f19331s = interfaceC4552c;
                this.actual.onSubscribe(this);
                AbstractC4516j0 abstractC4516j0 = this.scheduler;
                long j2 = this.period;
                EnumC4592d.replace(this.timer, abstractC4516j0.mo17408a(this, j2, j2, this.unit));
            }
        }
    }

    public C4998q2(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, boolean z) {
        super(interfaceC4504g0);
        this.f19327b = j2;
        this.f19328c = timeUnit;
        this.f19329d = abstractC4516j0;
        this.f19330e = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4466m c4466m = new C4466m(interfaceC4514i0);
        if (this.f19330e) {
            this.f18742a.subscribe(new a(c4466m, this.f19327b, this.f19328c, this.f19329d));
        } else {
            this.f18742a.subscribe(new b(c4466m, this.f19327b, this.f19328c, this.f19329d));
        }
    }
}
