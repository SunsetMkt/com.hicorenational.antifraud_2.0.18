package p251g.p252a.p268y0.p273e.p276c;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
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

/* compiled from: MaybeFlatMapIterableFlowable.java */
/* renamed from: g.a.y0.e.c.b0 */
/* loaded from: classes2.dex */
public final class C4840b0<T, R> extends AbstractC4519l<R> {

    /* renamed from: b */
    final InterfaceC4588y<T> f18557b;

    /* renamed from: c */
    final InterfaceC4584o<? super T, ? extends Iterable<? extends R>> f18558c;

    /* compiled from: MaybeFlatMapIterableFlowable.java */
    /* renamed from: g.a.y0.e.c.b0$a */
    static final class a<T, R> extends AbstractC5153c<R> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final InterfaceC5822c<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d */
        InterfaceC4552c f18559d;

        /* renamed from: it */
        volatile Iterator<? extends R> f18560it;
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
            this.f18559d.dispose();
            this.f18559d = EnumC4592d.DISPOSED;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.f18560it = null;
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super R> interfaceC5822c = this.actual;
            Iterator<? extends R> it = this.f18560it;
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
                        fastPath(interfaceC5822c, it);
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
                    it = this.f18560it;
                }
            }
        }

        void fastPath(InterfaceC5822c<? super R> interfaceC5822c, Iterator<? extends R> it) {
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

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.f18560it == null;
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            this.f18559d = EnumC4592d.DISPOSED;
            this.actual.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            if (EnumC4592d.validate(this.f18559d, interfaceC4552c)) {
                this.f18559d = interfaceC4552c;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.actual.onComplete();
                } else {
                    this.f18560it = it;
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
            Iterator<? extends R> it = this.f18560it;
            if (it == null) {
                return null;
            }
            R r = (R) C4601b.m18284a(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f18560it = null;
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
    }

    public C4840b0(InterfaceC4588y<T> interfaceC4588y, InterfaceC4584o<? super T, ? extends Iterable<? extends R>> interfaceC4584o) {
        this.f18557b = interfaceC4588y;
        this.f18558c = interfaceC4584o;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super R> interfaceC5822c) {
        this.f18557b.mo18100a(new a(interfaceC5822c, this.f18558c));
    }
}
