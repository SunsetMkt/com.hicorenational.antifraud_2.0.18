package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableTakeLastTimed.java */
/* renamed from: g.a.y0.e.b.x3 */
/* loaded from: classes2.dex */
public final class C4825x3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18508c;

    /* renamed from: d */
    final long f18509d;

    /* renamed from: e */
    final TimeUnit f18510e;

    /* renamed from: f */
    final AbstractC4516j0 f18511f;

    /* renamed from: g */
    final int f18512g;

    /* renamed from: h */
    final boolean f18513h;

    /* compiled from: FlowableTakeLastTimed.java */
    /* renamed from: g.a.y0.e.b.x3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -5677354903406201275L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final C5111c<Object> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        InterfaceC5823d f18514s;
        final AbstractC4516j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
            this.actual = interfaceC5822c;
            this.count = j2;
            this.time = j3;
            this.unit = timeUnit;
            this.scheduler = abstractC4516j0;
            this.queue = new C5111c<>(i2);
            this.delayError = z;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f18514s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, InterfaceC5822c<? super T> interfaceC5822c, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (!z) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    interfaceC5822c.onError(th);
                } else {
                    interfaceC5822c.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                interfaceC5822c.onError(th2);
                return true;
            }
            if (!z) {
                return false;
            }
            interfaceC5822c.onComplete();
            return true;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            C5111c<Object> c5111c = this.queue;
            boolean z = this.delayError;
            int i2 = 1;
            do {
                if (this.done) {
                    if (checkTerminated(c5111c.isEmpty(), interfaceC5822c, z)) {
                        return;
                    }
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        if (checkTerminated(c5111c.m18554a() == null, interfaceC5822c, z)) {
                            return;
                        }
                        if (j2 != j3) {
                            c5111c.poll();
                            interfaceC5822c.onNext(c5111c.poll());
                            j3++;
                        } else if (j3 != 0) {
                            C5164d.m18610c(this.requested, j3);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            trim(this.scheduler.mo17276a(this.unit), this.queue);
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.delayError) {
                trim(this.scheduler.mo17276a(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            C5111c<Object> c5111c = this.queue;
            long mo17276a = this.scheduler.mo17276a(this.unit);
            c5111c.offer(Long.valueOf(mo17276a), t);
            trim(mo17276a, c5111c);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18514s, interfaceC5823d)) {
                this.f18514s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        void trim(long j2, C5111c<Object> c5111c) {
            long j3 = this.time;
            long j4 = this.count;
            boolean z = j4 == C5556m0.f20396b;
            while (!c5111c.isEmpty()) {
                if (((Long) c5111c.m18554a()).longValue() >= j2 - j3 && (z || (c5111c.m18555b() >> 1) <= j4)) {
                    return;
                }
                c5111c.poll();
                c5111c.poll();
            }
        }
    }

    public C4825x3(AbstractC4519l<T> abstractC4519l, long j2, long j3, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
        super(abstractC4519l);
        this.f18508c = j2;
        this.f18509d = j3;
        this.f18510e = timeUnit;
        this.f18511f = abstractC4516j0;
        this.f18512g = i2;
        this.f18513h = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18508c, this.f18509d, this.f18510e, this.f18511f, this.f18512g, this.f18513h));
    }
}
