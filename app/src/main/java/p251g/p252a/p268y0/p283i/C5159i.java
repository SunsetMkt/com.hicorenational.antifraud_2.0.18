package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SubscriptionArbiter.java */
/* renamed from: g.a.y0.i.i */
/* loaded from: classes2.dex */
public class C5159i extends AtomicInteger implements InterfaceC5823d {
    private static final long serialVersionUID = -2189523197179400958L;
    InterfaceC5823d actual;
    volatile boolean cancelled;
    long requested;
    protected boolean unbounded;
    final AtomicReference<InterfaceC5823d> missedSubscription = new AtomicReference<>();
    final AtomicLong missedRequested = new AtomicLong();
    final AtomicLong missedProduced = new AtomicLong();

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        drain();
    }

    final void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    final void drainLoop() {
        InterfaceC5823d interfaceC5823d = null;
        long j2 = 0;
        int i2 = 1;
        do {
            InterfaceC5823d interfaceC5823d2 = this.missedSubscription.get();
            if (interfaceC5823d2 != null) {
                interfaceC5823d2 = this.missedSubscription.getAndSet(null);
            }
            long j3 = this.missedRequested.get();
            if (j3 != 0) {
                j3 = this.missedRequested.getAndSet(0L);
            }
            long j4 = this.missedProduced.get();
            if (j4 != 0) {
                j4 = this.missedProduced.getAndSet(0L);
            }
            InterfaceC5823d interfaceC5823d3 = this.actual;
            if (this.cancelled) {
                if (interfaceC5823d3 != null) {
                    interfaceC5823d3.cancel();
                    this.actual = null;
                }
                if (interfaceC5823d2 != null) {
                    interfaceC5823d2.cancel();
                }
            } else {
                long j5 = this.requested;
                if (j5 != C5556m0.f20396b) {
                    j5 = C5164d.m18606a(j5, j3);
                    if (j5 != C5556m0.f20396b) {
                        long j6 = j5 - j4;
                        if (j6 < 0) {
                            EnumC5160j.reportMoreProduced(j6);
                            j6 = 0;
                        }
                        j5 = j6;
                    }
                    this.requested = j5;
                }
                if (interfaceC5823d2 != null) {
                    if (interfaceC5823d3 != null) {
                        interfaceC5823d3.cancel();
                    }
                    this.actual = interfaceC5823d2;
                    if (j5 != 0) {
                        j2 = C5164d.m18606a(j2, j5);
                        interfaceC5823d = interfaceC5823d2;
                    }
                } else if (interfaceC5823d3 != null && j3 != 0) {
                    j2 = C5164d.m18606a(j2, j3);
                    interfaceC5823d = interfaceC5823d3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j2 != 0) {
            interfaceC5823d.request(j2);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long j2) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            C5164d.m18607a(this.missedProduced, j2);
            drain();
            return;
        }
        long j3 = this.requested;
        if (j3 != C5556m0.f20396b) {
            long j4 = j3 - j2;
            long j5 = 0;
            if (j4 < 0) {
                EnumC5160j.reportMoreProduced(j4);
            } else {
                j5 = j4;
            }
            this.requested = j5;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        drainLoop();
    }

    @Override // p324i.p338d.InterfaceC5823d
    public final void request(long j2) {
        if (!EnumC5160j.validate(j2) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            C5164d.m18607a(this.missedRequested, j2);
            drain();
            return;
        }
        long j3 = this.requested;
        if (j3 != C5556m0.f20396b) {
            long m18606a = C5164d.m18606a(j3, j2);
            this.requested = m18606a;
            if (m18606a == C5556m0.f20396b) {
                this.unbounded = true;
            }
        }
        InterfaceC5823d interfaceC5823d = this.actual;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (interfaceC5823d != null) {
            interfaceC5823d.request(j2);
        }
    }

    public final void setSubscription(InterfaceC5823d interfaceC5823d) {
        if (this.cancelled) {
            interfaceC5823d.cancel();
            return;
        }
        C4601b.m18284a(interfaceC5823d, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            InterfaceC5823d andSet = this.missedSubscription.getAndSet(interfaceC5823d);
            if (andSet != null) {
                andSet.cancel();
            }
            drain();
            return;
        }
        InterfaceC5823d interfaceC5823d2 = this.actual;
        if (interfaceC5823d2 != null) {
            interfaceC5823d2.cancel();
        }
        this.actual = interfaceC5823d;
        long j2 = this.requested;
        if (decrementAndGet() != 0) {
            drainLoop();
        }
        if (j2 != 0) {
            interfaceC5823d.request(j2);
        }
    }
}
