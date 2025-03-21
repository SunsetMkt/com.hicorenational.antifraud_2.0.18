package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p266w0.AbstractC4567a;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableRefCount.java */
/* renamed from: g.a.y0.e.b.t2 */
/* loaded from: classes2.dex */
public final class C4803t2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final AbstractC4567a<T> f18414c;

    /* renamed from: d */
    volatile C4551b f18415d;

    /* renamed from: e */
    final AtomicInteger f18416e;

    /* renamed from: f */
    final ReentrantLock f18417f;

    /* compiled from: FlowableRefCount.java */
    /* renamed from: g.a.y0.e.b.t2$a */
    final class a extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d {
        private static final long serialVersionUID = 152064694420235350L;
        final C4551b currentBase;
        final AtomicLong requested = new AtomicLong();
        final InterfaceC4552c resource;
        final InterfaceC5822c<? super T> subscriber;

        a(InterfaceC5822c<? super T> interfaceC5822c, C4551b c4551b, InterfaceC4552c interfaceC4552c) {
            this.subscriber = interfaceC5822c;
            this.currentBase = c4551b;
            this.resource = interfaceC4552c;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            EnumC5160j.cancel(this);
            this.resource.dispose();
        }

        void cleanup() {
            C4803t2.this.f18417f.lock();
            try {
                if (C4803t2.this.f18415d == this.currentBase) {
                    if (C4803t2.this.f18414c instanceof InterfaceC4552c) {
                        ((InterfaceC4552c) C4803t2.this.f18414c).dispose();
                    }
                    C4803t2.this.f18415d.dispose();
                    C4803t2.this.f18415d = new C4551b();
                    C4803t2.this.f18416e.set(0);
                }
            } finally {
                C4803t2.this.f18417f.unlock();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            EnumC5160j.deferredSetOnce(this, this.requested, interfaceC5823d);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            EnumC5160j.deferredRequest(this, this.requested, j2);
        }
    }

    /* compiled from: FlowableRefCount.java */
    /* renamed from: g.a.y0.e.b.t2$b */
    final class b implements InterfaceC4576g<InterfaceC4552c> {

        /* renamed from: a */
        private final InterfaceC5822c<? super T> f18418a;

        /* renamed from: b */
        private final AtomicBoolean f18419b;

        b(InterfaceC5822c<? super T> interfaceC5822c, AtomicBoolean atomicBoolean) {
            this.f18418a = interfaceC5822c;
            this.f18419b = atomicBoolean;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(InterfaceC4552c interfaceC4552c) {
            try {
                C4803t2.this.f18415d.mo18181b(interfaceC4552c);
                C4803t2.this.m18394a((InterfaceC5822c) this.f18418a, C4803t2.this.f18415d);
            } finally {
                C4803t2.this.f18417f.unlock();
                this.f18419b.set(false);
            }
        }
    }

    /* compiled from: FlowableRefCount.java */
    /* renamed from: g.a.y0.e.b.t2$c */
    final class c implements Runnable {

        /* renamed from: a */
        private final C4551b f18421a;

        c(C4551b c4551b) {
            this.f18421a = c4551b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4803t2.this.f18417f.lock();
            try {
                if (C4803t2.this.f18415d == this.f18421a && C4803t2.this.f18416e.decrementAndGet() == 0) {
                    if (C4803t2.this.f18414c instanceof InterfaceC4552c) {
                        ((InterfaceC4552c) C4803t2.this.f18414c).dispose();
                    }
                    C4803t2.this.f18415d.dispose();
                    C4803t2.this.f18415d = new C4551b();
                }
            } finally {
                C4803t2.this.f18417f.unlock();
            }
        }
    }

    public C4803t2(AbstractC4567a<T> abstractC4567a) {
        super(abstractC4567a);
        this.f18415d = new C4551b();
        this.f18416e = new AtomicInteger();
        this.f18417f = new ReentrantLock();
        this.f18414c = abstractC4567a;
    }

    /* renamed from: a */
    private InterfaceC4576g<InterfaceC4552c> m18393a(InterfaceC5822c<? super T> interfaceC5822c, AtomicBoolean atomicBoolean) {
        return new b(interfaceC5822c, atomicBoolean);
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f18417f.lock();
        if (this.f18416e.incrementAndGet() != 1) {
            try {
                m18394a((InterfaceC5822c) interfaceC5822c, this.f18415d);
            } finally {
                this.f18417f.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f18414c.mo18205l((InterfaceC4576g<? super InterfaceC4552c>) m18393a((InterfaceC5822c) interfaceC5822c, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    /* renamed from: a */
    void m18394a(InterfaceC5822c<? super T> interfaceC5822c, C4551b c4551b) {
        a aVar = new a(interfaceC5822c, c4551b, m18392a(c4551b));
        interfaceC5822c.onSubscribe(aVar);
        this.f18414c.m17799a((InterfaceC4529q) aVar);
    }

    /* renamed from: a */
    private InterfaceC4552c m18392a(C4551b c4551b) {
        return C4553d.m18186a(new c(c4551b));
    }
}
