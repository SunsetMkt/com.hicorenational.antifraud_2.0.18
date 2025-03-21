package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: ObservableSkipLastTimed.java */
/* renamed from: g.a.y0.e.d.c3 */
/* loaded from: classes2.dex */
public final class C4923c3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f18835b;

    /* renamed from: c */
    final TimeUnit f18836c;

    /* renamed from: d */
    final AbstractC4516j0 f18837d;

    /* renamed from: e */
    final int f18838e;

    /* renamed from: f */
    final boolean f18839f;

    /* compiled from: ObservableSkipLastTimed.java */
    /* renamed from: g.a.y0.e.d.c3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -5677354903406201275L;
        final InterfaceC4514i0<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final C5111c<Object> queue;

        /* renamed from: s */
        InterfaceC4552c f18840s;
        final AbstractC4516j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = abstractC4516j0;
            this.queue = new C5111c<>(i2);
            this.delayError = z;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f18840s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
            C5111c<Object> c5111c = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            AbstractC4516j0 abstractC4516j0 = this.scheduler;
            long j2 = this.time;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l2 = (Long) c5111c.m18554a();
                boolean z3 = l2 == null;
                long mo17276a = abstractC4516j0.mo17276a(timeUnit);
                if (!z3 && l2.longValue() > mo17276a - j2) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            interfaceC4514i0.onError(th);
                            return;
                        } else if (z3) {
                            interfaceC4514i0.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            interfaceC4514i0.onError(th2);
                            return;
                        } else {
                            interfaceC4514i0.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    c5111c.poll();
                    interfaceC4514i0.onNext(c5111c.poll());
                }
            }
            this.queue.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.mo17276a(this.unit)), t);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18840s, interfaceC4552c)) {
                this.f18840s = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4923c3(InterfaceC4504g0<T> interfaceC4504g0, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f18835b = j2;
        this.f18836c = timeUnit;
        this.f18837d = abstractC4516j0;
        this.f18838e = i2;
        this.f18839f = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f18835b, this.f18836c, this.f18837d, this.f18838e, this.f18839f));
    }
}
