package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableOnBackpressureBuffer.java */
/* renamed from: g.a.y0.e.b.e2 */
/* loaded from: classes2.dex */
public final class C4713e2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final int f17855c;

    /* renamed from: d */
    final boolean f17856d;

    /* renamed from: e */
    final boolean f17857e;

    /* renamed from: f */
    final InterfaceC4570a f17858f;

    /* compiled from: FlowableOnBackpressureBuffer.java */
    /* renamed from: g.a.y0.e.b.e2$a */
    static final class a<T> extends AbstractC5153c<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final InterfaceC4570a onOverflow;
        boolean outputFused;
        final InterfaceC4615n<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        InterfaceC5823d f17859s;

        a(InterfaceC5822c<? super T> interfaceC5822c, int i2, boolean z, boolean z2, InterfaceC4570a interfaceC4570a) {
            this.actual = interfaceC5822c;
            this.onOverflow = interfaceC4570a;
            this.delayError = z2;
            this.queue = z ? new C5111c<>(i2) : new C5110b<>(i2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f17859s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<? super T> interfaceC5822c) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
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

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                InterfaceC4615n<T> interfaceC4615n = this.queue;
                InterfaceC5822c<? super T> interfaceC5822c = this.actual;
                int i2 = 1;
                while (!checkTerminated(this.done, interfaceC4615n.isEmpty(), interfaceC5822c)) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (j3 != j2) {
                        boolean z = this.done;
                        T poll = interfaceC4615n.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, interfaceC5822c)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        interfaceC5822c.onNext(poll);
                        j3++;
                    }
                    if (j3 == j2 && checkTerminated(this.done, interfaceC4615n.isEmpty(), interfaceC5822c)) {
                        return;
                    }
                    if (j3 != 0 && j2 != C5556m0.f20396b) {
                        this.requested.addAndGet(-j3);
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.actual.onComplete();
            } else {
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.actual.onError(th);
            } else {
                drain();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.actual.onNext(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            this.f17859s.cancel();
            C4562c c4562c = new C4562c("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                C4561b.m18199b(th);
                c4562c.initCause(th);
            }
            onError(c4562c);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17859s, interfaceC5823d)) {
                this.f17859s = interfaceC5823d;
                this.actual.onSubscribe(this);
                interfaceC5823d.request(C5556m0.f20396b);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (this.outputFused || !EnumC5160j.validate(j2)) {
                return;
            }
            C5164d.m18607a(this.requested, j2);
            drain();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public C4713e2(AbstractC4519l<T> abstractC4519l, int i2, boolean z, boolean z2, InterfaceC4570a interfaceC4570a) {
        super(abstractC4519l);
        this.f17855c = i2;
        this.f17856d = z;
        this.f17857e = z2;
        this.f17858f = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, this.f17855c, this.f17856d, this.f17857e, this.f17858f));
    }
}
