package p251g.p252a.p268y0.p273e.p279f;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4530q0;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: SingleFlatMapIterableFlowable.java */
/* renamed from: g.a.y0.e.f.x */
/* loaded from: classes2.dex */
public final class C5106x<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    final InterfaceC4530q0<T> f19814b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f19815c;

    /* compiled from: SingleFlatMapIterableFlowable.java */
    /* renamed from: g.a.y0.e.f.x$a */
    static final class a<T, R> extends AbstractC5153c<R> implements InterfaceC4524n0<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d */
        InterfaceC4552c f19816d;

        /* renamed from: it */
        volatile Iterator<? extends R> f19817it;
        final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();

        a(InterfaceC5822c<? super R> interfaceC5822c, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
            this.actual = interfaceC5822c;
            this.mapper = interfaceC4584o;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            this.f19816d.dispose();
            this.f19816d = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f19817it = null;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            Iterator<? extends R> it = this.f19817it;
            if (this.outputFused && it != null) {
                interfaceC5822c.onNext(null);
                interfaceC5822c.onComplete();
                return;
            }
            int i2 = 1;
            while (true) {
                if (it != null) {
                    long j2 = this.requested.get();
                    if (j2 == C5556m0.f20396b) {
                        slowPath(interfaceC5822c, it);
                        return;
                    }
                    long j3 = 0;
                    while (j3 != j2) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            interfaceC5822c.onNext((Object) C4601b.m18284a(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j3++;
                            try {
                                if (!it.hasNext()) {
                                    interfaceC5822c.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                C4561b.m18199b(th);
                                interfaceC5822c.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            C4561b.m18199b(th2);
                            interfaceC5822c.onError(th2);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        C5164d.m18610c(this.requested, j3);
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f19817it;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f19817it == null;
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onError(Throwable th) {
            this.f19816d = EnumC4592d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f19816d, interfaceC4552c)) {
                this.f19816d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.actual.onComplete();
                } else {
                    this.f19817it = it;
                    drain();
                }
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.actual.onError(th);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.f19817it;
            if (it == null) {
                return null;
            }
            R r = (R) C4601b.m18284a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f19817it = null;
            }
            return r;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                drain();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        void slowPath(InterfaceC5822c<? super R> interfaceC5822c, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    interfaceC5822c.onNext(it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        interfaceC5822c.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    interfaceC5822c.onError(th2);
                    return;
                }
            }
        }
    }

    public C5106x(InterfaceC4530q0<T> interfaceC4530q0, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
        this.f19814b = interfaceC4530q0;
        this.f19815c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f19814b.mo17490a(new a(interfaceC5822c, this.f19815c));
    }
}
