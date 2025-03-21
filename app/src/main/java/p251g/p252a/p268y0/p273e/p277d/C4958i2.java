package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p285z0.AbstractC5187a;

/* compiled from: ObservableRefCount.java */
/* renamed from: g.a.y0.e.d.i2 */
/* loaded from: classes2.dex */
public final class C4958i2<T> extends AbstractC4907a<T, T> {

    /* renamed from: b */
    final AbstractC5187a<? extends T> f19061b;

    /* renamed from: c */
    volatile C4551b f19062c;

    /* renamed from: d */
    final AtomicInteger f19063d;

    /* renamed from: e */
    final ReentrantLock f19064e;

    /* compiled from: ObservableRefCount.java */
    /* renamed from: g.a.y0.e.d.i2$a */
    final class a extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
        private static final long serialVersionUID = 3813126992133394324L;
        final C4551b currentBase;
        final InterfaceC4552c resource;
        final InterfaceC4514i0<? super T> subscriber;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, C4551b c4551b, InterfaceC4552c interfaceC4552c) {
            this.subscriber = interfaceC4514i0;
            this.currentBase = c4551b;
            this.resource = interfaceC4552c;
        }

        void cleanup() {
            C4958i2.this.f19064e.lock();
            try {
                if (C4958i2.this.f19062c == this.currentBase) {
                    if (C4958i2.this.f19061b instanceof InterfaceC4552c) {
                        ((InterfaceC4552c) C4958i2.this.f19061b).dispose();
                    }
                    C4958i2.this.f19062c.dispose();
                    C4958i2.this.f19062c = new C4551b();
                    C4958i2.this.f19063d.set(0);
                }
            } finally {
                C4958i2.this.f19064e.unlock();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
            this.resource.dispose();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            cleanup();
            this.subscriber.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            cleanup();
            this.subscriber.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.subscriber.onNext(t);
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* renamed from: g.a.y0.e.d.i2$b */
    final class b implements InterfaceC4576g<InterfaceC4552c> {

        /* renamed from: a */
        private final InterfaceC4514i0<? super T> f19065a;

        /* renamed from: b */
        private final AtomicBoolean f19066b;

        b(InterfaceC4514i0<? super T> interfaceC4514i0, AtomicBoolean atomicBoolean) {
            this.f19065a = interfaceC4514i0;
            this.f19066b = atomicBoolean;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4576g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(InterfaceC4552c interfaceC4552c) {
            try {
                C4958i2.this.f19062c.mo18181b(interfaceC4552c);
                C4958i2.this.m18454a((InterfaceC4514i0) this.f19065a, C4958i2.this.f19062c);
            } finally {
                C4958i2.this.f19064e.unlock();
                this.f19066b.set(false);
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* renamed from: g.a.y0.e.d.i2$c */
    final class c implements Runnable {

        /* renamed from: a */
        private final C4551b f19068a;

        c(C4551b c4551b) {
            this.f19068a = c4551b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4958i2.this.f19064e.lock();
            try {
                if (C4958i2.this.f19062c == this.f19068a && C4958i2.this.f19063d.decrementAndGet() == 0) {
                    if (C4958i2.this.f19061b instanceof InterfaceC4552c) {
                        ((InterfaceC4552c) C4958i2.this.f19061b).dispose();
                    }
                    C4958i2.this.f19062c.dispose();
                    C4958i2.this.f19062c = new C4551b();
                }
            } finally {
                C4958i2.this.f19064e.unlock();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C4958i2(AbstractC5187a<T> abstractC5187a) {
        super(abstractC5187a);
        this.f19062c = new C4551b();
        this.f19063d = new AtomicInteger();
        this.f19064e = new ReentrantLock();
        this.f19061b = abstractC5187a;
    }

    /* renamed from: a */
    private InterfaceC4576g<InterfaceC4552c> m18453a(InterfaceC4514i0<? super T> interfaceC4514i0, AtomicBoolean atomicBoolean) {
        return new b(interfaceC4514i0, atomicBoolean);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f19064e.lock();
        if (this.f19063d.incrementAndGet() != 1) {
            try {
                m18454a((InterfaceC4514i0) interfaceC4514i0, this.f19062c);
            } finally {
                this.f19064e.unlock();
            }
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f19061b.mo18422k((InterfaceC4576g<? super InterfaceC4552c>) m18453a((InterfaceC4514i0) interfaceC4514i0, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
    }

    /* renamed from: a */
    void m18454a(InterfaceC4514i0<? super T> interfaceC4514i0, C4551b c4551b) {
        a aVar = new a(interfaceC4514i0, c4551b, m18452a(c4551b));
        interfaceC4514i0.onSubscribe(aVar);
        this.f19061b.subscribe(aVar);
    }

    /* renamed from: a */
    private InterfaceC4552c m18452a(C4551b c4551b) {
        return C4553d.m18186a(new c(c4551b));
    }
}
