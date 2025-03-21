package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p280f.C5111c;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ObservableTakeLastTimed.java */
/* renamed from: g.a.y0.e.d.l3 */
/* loaded from: classes2.dex */
public final class C4974l3<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final long f19114b;

    /* renamed from: c */
    final long f19115c;

    /* renamed from: d */
    final TimeUnit f19116d;

    /* renamed from: e */
    final AbstractC4516j0 f19117e;

    /* renamed from: f */
    final int f19118f;

    /* renamed from: g */
    final boolean f19119g;

    /* compiled from: ObservableTakeLastTimed.java */
    /* renamed from: g.a.y0.e.d.l3$a */
    static final class a<T> extends AtomicBoolean implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = -5677354903406201275L;
        final InterfaceC4514i0<? super T> actual;
        volatile boolean cancelled;
        final long count;

        /* renamed from: d */
        InterfaceC4552c f19120d;
        final boolean delayError;
        Throwable error;
        final C5111c<Object> queue;
        final AbstractC4516j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
            this.actual = interfaceC4514i0;
            this.count = j2;
            this.time = j3;
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
            this.f19120d.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
                C5111c<Object> c5111c = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        c5111c.clear();
                        interfaceC4514i0.onError(th);
                        return;
                    }
                    Object poll = c5111c.poll();
                    if (poll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            interfaceC4514i0.onError(th2);
                            return;
                        } else {
                            interfaceC4514i0.onComplete();
                            return;
                        }
                    }
                    Object poll2 = c5111c.poll();
                    if (((Long) poll).longValue() >= this.scheduler.mo17276a(this.unit) - this.time) {
                        interfaceC4514i0.onNext(poll2);
                    }
                }
                c5111c.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            C5111c<Object> c5111c = this.queue;
            long mo17276a = this.scheduler.mo17276a(this.unit);
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == C5556m0.f20396b;
            c5111c.offer(Long.valueOf(mo17276a), t);
            while (!c5111c.isEmpty()) {
                if (((Long) c5111c.m18554a()).longValue() > mo17276a - j2 && (z || (c5111c.m18555b() >> 1) <= j3)) {
                    return;
                }
                c5111c.poll();
                c5111c.poll();
            }
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19120d, interfaceC4552c)) {
                this.f19120d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }
    }

    public C4974l3(InterfaceC4504g0<T> interfaceC4504g0, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
        super(interfaceC4504g0);
        this.f19114b = j2;
        this.f19115c = j3;
        this.f19116d = timeUnit;
        this.f19117e = abstractC4516j0;
        this.f19118f = i2;
        this.f19119g = z;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f18742a.subscribe(new a(interfaceC4514i0, this.f19114b, this.f19115c, this.f19116d, this.f19117e, this.f19118f, this.f19119g));
    }
}
