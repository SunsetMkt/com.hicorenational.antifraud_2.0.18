package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnBackpressureLatest.java */
/* renamed from: g.a.y0.e.b.i2 */
/* loaded from: classes2.dex */
public final class C4737i2<T> extends AbstractC4686a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* renamed from: g.a.y0.e.b.i2$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 163080509307634843L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;

        /* renamed from: s */
        InterfaceC5823d f17957s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        a(InterfaceC5822c<? super T> interfaceC5822c) {
            this.actual = interfaceC5822c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f17957s.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                atomicReference.lazySet(null);
                interfaceC5822c.onError(th);
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
            AtomicLong atomicLong = this.requested;
            AtomicReference<T> atomicReference = this.current;
            int i2 = 1;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.done;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (checkTerminated(z, z2, interfaceC5822c, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(andSet);
                    j2++;
                }
                if (j2 == atomicLong.get()) {
                    if (checkTerminated(this.done, atomicReference.get() == null, interfaceC5822c, atomicReference)) {
                        return;
                    }
                }
                if (j2 != 0) {
                    C5164d.m18610c(atomicLong, j2);
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
            this.current.lazySet(t);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17957s, interfaceC5823d)) {
                this.f17957s = interfaceC5823d;
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

    public C4737i2(AbstractC4519l<T> abstractC4519l) {
        super(abstractC4519l);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c));
    }
}
