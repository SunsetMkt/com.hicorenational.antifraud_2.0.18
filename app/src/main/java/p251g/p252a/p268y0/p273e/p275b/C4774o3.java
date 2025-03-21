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

/* compiled from: FlowableSkipLastTimed.java */
/* renamed from: g.a.y0.e.b.o3 */
/* loaded from: classes2.dex */
public final class C4774o3<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final long f18168c;

    /* renamed from: d */
    final TimeUnit f18169d;

    /* renamed from: e */
    final AbstractC4516j0 f18170e;

    /* renamed from: f */
    final int f18171f;

    /* renamed from: g */
    final boolean f18172g;

    /* compiled from: FlowableSkipLastTimed.java */
    /* renamed from: g.a.y0.e.b.o3$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = -5677354903406201275L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final C5111c<Object> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        InterfaceC5823d f18173s;
        final AbstractC4516j0 scheduler;
        final long time;
        final TimeUnit unit;

        a(InterfaceC5822c<? super T> interfaceC5822c, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
            this.actual = interfaceC5822c;
            this.time = j2;
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
            this.f18173s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<? super T> interfaceC5822c, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
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
            if (!z2) {
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
            TimeUnit timeUnit = this.unit;
            AbstractC4516j0 abstractC4516j0 = this.scheduler;
            long j2 = this.time;
            int i2 = 1;
            do {
                long j3 = this.requested.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.done;
                    Long l2 = (Long) c5111c.m18554a();
                    boolean z3 = l2 == null;
                    boolean z4 = (z3 || l2.longValue() <= abstractC4516j0.mo17276a(timeUnit) - j2) ? z3 : true;
                    if (checkTerminated(z2, z4, interfaceC5822c, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    c5111c.poll();
                    interfaceC5822c.onNext(c5111c.poll());
                    j4++;
                }
                if (j4 != 0) {
                    C5164d.m18610c(this.requested, j4);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.queue.offer(Long.valueOf(this.scheduler.mo17276a(this.unit)), t);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18173s, interfaceC5823d)) {
                this.f18173s = interfaceC5823d;
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
    }

    public C4774o3(AbstractC4519l<T> abstractC4519l, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2, boolean z) {
        super(abstractC4519l);
        this.f18168c = j2;
        this.f18169d = timeUnit;
        this.f18170e = abstractC4516j0;
        this.f18171f = i2;
        this.f18172g = z;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f18168c, this.f18169d, this.f18170e, this.f18171f, this.f18172g));
    }
}
