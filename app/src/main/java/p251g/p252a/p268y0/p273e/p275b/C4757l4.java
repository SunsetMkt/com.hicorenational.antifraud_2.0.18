package p251g.p252a.p268y0.p273e.p275b;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableWindow.java */
/* renamed from: g.a.y0.e.b.l4 */
/* loaded from: classes2.dex */
public final class C4757l4<T> extends AbstractC4686a<T, AbstractC4519l<T>> {

    /* renamed from: c */
    final long f18041c;

    /* renamed from: d */
    final long f18042d;

    /* renamed from: e */
    final int f18043e;

    /* compiled from: FlowableWindow.java */
    /* renamed from: g.a.y0.e.b.l4$a */
    static final class a<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final InterfaceC5822c<? super AbstractC4519l<T>> actual;
        final int bufferSize;
        long index;
        final AtomicBoolean once;

        /* renamed from: s */
        InterfaceC5823d f18044s;
        final long size;
        C4485g<T> window;

        a(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, int i2) {
            super(1);
            this.actual = interfaceC5822c;
            this.size = j2;
            this.once = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            C4485g<T> c4485g = this.window;
            if (c4485g != null) {
                this.window = null;
                c4485g.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            C4485g<T> c4485g = this.window;
            if (c4485g != null) {
                this.window = null;
                c4485g.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = this.index;
            C4485g<T> c4485g = this.window;
            if (j2 == 0) {
                getAndIncrement();
                c4485g = C4485g.m17256a(this.bufferSize, (Runnable) this);
                this.window = c4485g;
                this.actual.onNext(c4485g);
            }
            long j3 = j2 + 1;
            c4485g.onNext(t);
            if (j3 != this.size) {
                this.index = j3;
                return;
            }
            this.index = 0L;
            this.window = null;
            c4485g.onComplete();
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18044s, interfaceC5823d)) {
                this.f18044s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                this.f18044s.request(C5164d.m18608b(this.size, j2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f18044s.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    /* renamed from: g.a.y0.e.b.l4$b */
    static final class b<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final InterfaceC5822c<? super AbstractC4519l<T>> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final C5111c<C4485g<T>> queue;
        final AtomicLong requested;

        /* renamed from: s */
        InterfaceC5823d f18045s;
        final long size;
        final long skip;
        final ArrayDeque<C4485g<T>> windows;
        final AtomicInteger wip;

        b(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, long j3, int i2) {
            super(1);
            this.actual = interfaceC5822c;
            this.size = j2;
            this.skip = j3;
            this.queue = new C5111c<>(i2);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c, C5111c<?> c5111c) {
            if (this.cancelled) {
                c5111c.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                c5111c.clear();
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
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c = this.actual;
            C5111c<C4485g<T>> c5111c = this.queue;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z = this.done;
                    C4485g<T> poll = c5111c.poll();
                    boolean z2 = poll == null;
                    if (checkTerminated(z, z2, interfaceC5822c, c5111c)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(poll);
                    j3++;
                }
                if (j3 == j2 && checkTerminated(this.done, c5111c.isEmpty(), interfaceC5822c, c5111c)) {
                    return;
                }
                if (j3 != 0 && j2 != C5556m0.f20396b) {
                    this.requested.addAndGet(-j3);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            if (this.done) {
                return;
            }
            Iterator<C4485g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            Iterator<C4485g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.windows.clear();
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j2 = this.index;
            if (j2 == 0 && !this.cancelled) {
                getAndIncrement();
                C4485g<T> m17256a = C4485g.m17256a(this.bufferSize, (Runnable) this);
                this.windows.offer(m17256a);
                this.queue.offer(m17256a);
                drain();
            }
            long j3 = j2 + 1;
            Iterator<C4485g<T>> it = this.windows.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j4 = this.produced + 1;
            if (j4 == this.size) {
                this.produced = j4 - this.skip;
                C4485g<T> poll = this.windows.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.produced = j4;
            }
            if (j3 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j3;
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18045s, interfaceC5823d)) {
                this.f18045s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.f18045s.request(C5164d.m18608b(this.skip, j2));
                } else {
                    this.f18045s.request(C5164d.m18606a(this.size, C5164d.m18608b(this.skip, j2 - 1)));
                }
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f18045s.cancel();
            }
        }
    }

    /* compiled from: FlowableWindow.java */
    /* renamed from: g.a.y0.e.b.l4$c */
    static final class c<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final InterfaceC5822c<? super AbstractC4519l<T>> actual;
        final int bufferSize;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;

        /* renamed from: s */
        InterfaceC5823d f18046s;
        final long size;
        final long skip;
        C4485g<T> window;

        c(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c, long j2, long j3, int i2) {
            super(1);
            this.actual = interfaceC5822c;
            this.size = j2;
            this.skip = j3;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i2;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            C4485g<T> c4485g = this.window;
            if (c4485g != null) {
                this.window = null;
                c4485g.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            C4485g<T> c4485g = this.window;
            if (c4485g != null) {
                this.window = null;
                c4485g.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            long j2 = this.index;
            C4485g<T> c4485g = this.window;
            if (j2 == 0) {
                getAndIncrement();
                c4485g = C4485g.m17256a(this.bufferSize, (Runnable) this);
                this.window = c4485g;
                this.actual.onNext(c4485g);
            }
            long j3 = j2 + 1;
            if (c4485g != null) {
                c4485g.onNext(t);
            }
            if (j3 == this.size) {
                this.window = null;
                c4485g.onComplete();
            }
            if (j3 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j3;
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f18046s, interfaceC5823d)) {
                this.f18046s = interfaceC5823d;
                this.actual.onSubscribe(this);
            }
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                if (this.firstRequest.get() || !this.firstRequest.compareAndSet(false, true)) {
                    this.f18046s.request(C5164d.m18608b(this.skip, j2));
                } else {
                    this.f18046s.request(C5164d.m18606a(C5164d.m18608b(this.size, j2), C5164d.m18608b(this.skip - this.size, j2 - 1)));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f18046s.cancel();
            }
        }
    }

    public C4757l4(AbstractC4519l<T> abstractC4519l, long j2, long j3, int i2) {
        super(abstractC4519l);
        this.f18041c = j2;
        this.f18042d = j3;
        this.f18043e = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super AbstractC4519l<T>> interfaceC5822c) {
        long j2 = this.f18042d;
        long j3 = this.f18041c;
        if (j2 == j3) {
            this.f17759b.m17799a((InterfaceC4529q) new a(interfaceC5822c, j3, this.f18043e));
        } else if (j2 > j3) {
            this.f17759b.m17799a((InterfaceC4529q) new c(interfaceC5822c, j3, j2, this.f18043e));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new b(interfaceC5822c, j3, j2, this.f18043e));
        }
    }
}
