package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p271c.InterfaceC4602a;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FlowableObserveOn.java */
/* renamed from: g.a.y0.e.b.d2 */
/* loaded from: classes2.dex */
public final class C4707d2<T> extends AbstractC4686a<T, T> {

    /* renamed from: c */
    final AbstractC4516j0 f17827c;

    /* renamed from: d */
    final boolean f17828d;

    /* renamed from: e */
    final int f17829e;

    /* compiled from: FlowableObserveOn.java */
    /* renamed from: g.a.y0.e.b.d2$a */
    static abstract class a<T> extends AbstractC5153c<T> implements InterfaceC4529q<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        InterfaceC4616o<T> queue;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        InterfaceC5823d f17830s;
        int sourceMode;
        final AbstractC4516j0.c worker;

        a(AbstractC4516j0.c cVar, boolean z, int i2) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.f17830s.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        final boolean checkTerminated(boolean z, boolean z2, InterfaceC5822c<?> interfaceC5822c) {
            if (this.cancelled) {
                clear();
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
                this.worker.dispose();
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                clear();
                interfaceC5822c.onError(th2);
                this.worker.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            interfaceC5822c.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final void clear() {
            this.queue.clear();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            trySchedule();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onError(Throwable th) {
            if (this.done) {
                C4476a.m17152b(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                trySchedule();
                return;
            }
            if (!this.queue.offer(t)) {
                this.f17830s.cancel();
                this.error = new C4562c("Queue is full?!");
                this.done = true;
            }
            trySchedule();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public final void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                trySchedule();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.mo17282a(this);
        }
    }

    /* compiled from: FlowableObserveOn.java */
    /* renamed from: g.a.y0.e.b.d2$b */
    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final InterfaceC4602a<? super T> actual;
        long consumed;

        b(InterfaceC4602a<? super T> interfaceC4602a, AbstractC4516j0.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.actual = interfaceC4602a;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17830s, interfaceC5823d)) {
                this.f17830s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = interfaceC4613l;
                        this.actual.onSubscribe(this);
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j2 = this.consumed + 1;
                if (j2 == this.limit) {
                    this.consumed = 0L;
                    this.f17830s.request(j2);
                } else {
                    this.consumed = j2;
                }
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runAsync() {
            InterfaceC4602a<? super T> interfaceC4602a = this.actual;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            long j2 = this.produced;
            long j3 = this.consumed;
            int i2 = 1;
            while (true) {
                long j4 = this.requested.get();
                while (j2 != j4) {
                    boolean z = this.done;
                    try {
                        T poll = interfaceC4616o.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, interfaceC4602a)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (interfaceC4602a.tryOnNext(poll)) {
                            j2++;
                        }
                        j3++;
                        if (j3 == this.limit) {
                            this.f17830s.request(j3);
                            j3 = 0;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f17830s.cancel();
                        interfaceC4616o.clear();
                        interfaceC4602a.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 == j4 && checkTerminated(this.done, interfaceC4616o.isEmpty(), interfaceC4602a)) {
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    this.consumed = j3;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runSync() {
            InterfaceC4602a<? super T> interfaceC4602a = this.actual;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T poll = interfaceC4616o.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            interfaceC4602a.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (interfaceC4602a.tryOnNext(poll)) {
                            j2++;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f17830s.cancel();
                        interfaceC4602a.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (interfaceC4616o.isEmpty()) {
                    interfaceC4602a.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }
    }

    /* compiled from: FlowableObserveOn.java */
    /* renamed from: g.a.y0.e.b.d2$c */
    static final class c<T> extends a<T> implements InterfaceC4529q<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final InterfaceC5822c<? super T> actual;

        c(InterfaceC5822c<? super T> interfaceC5822c, AbstractC4516j0.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.actual = interfaceC5822c;
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.validate(this.f17830s, interfaceC5823d)) {
                this.f17830s = interfaceC5823d;
                if (interfaceC5823d instanceof InterfaceC4613l) {
                    InterfaceC4613l interfaceC4613l = (InterfaceC4613l) interfaceC5823d;
                    int requestFusion = interfaceC4613l.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = interfaceC4613l;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = interfaceC4613l;
                        this.actual.onSubscribe(this);
                        interfaceC5823d.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new C5110b(this.prefetch);
                this.actual.onSubscribe(this);
                interfaceC5823d.request(this.prefetch);
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T poll = this.queue.poll();
            if (poll != null && this.sourceMode != 1) {
                long j2 = this.produced + 1;
                if (j2 == this.limit) {
                    this.produced = 0L;
                    this.f17830s.request(j2);
                } else {
                    this.produced = j2;
                }
            }
            return poll;
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runAsync() {
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    boolean z = this.done;
                    try {
                        T poll = interfaceC4616o.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2, interfaceC5822c)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        interfaceC5822c.onNext(poll);
                        j2++;
                        if (j2 == this.limit) {
                            if (j3 != C5556m0.f20396b) {
                                j3 = this.requested.addAndGet(-j2);
                            }
                            this.f17830s.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f17830s.cancel();
                        interfaceC4616o.clear();
                        interfaceC5822c.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j2 == j3 && checkTerminated(this.done, interfaceC4616o.isEmpty(), interfaceC5822c)) {
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.actual.onNext(null);
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.actual.onError(th);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p275b.C4707d2.a
        void runSync() {
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            InterfaceC4616o<T> interfaceC4616o = this.queue;
            long j2 = this.produced;
            int i2 = 1;
            while (true) {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    try {
                        T poll = interfaceC4616o.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (poll == null) {
                            interfaceC5822c.onComplete();
                            this.worker.dispose();
                            return;
                        } else {
                            interfaceC5822c.onNext(poll);
                            j2++;
                        }
                    } catch (Throwable th) {
                        C4561b.m18199b(th);
                        this.f17830s.cancel();
                        interfaceC5822c.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (interfaceC4616o.isEmpty()) {
                    interfaceC5822c.onComplete();
                    this.worker.dispose();
                    return;
                }
                int i3 = get();
                if (i2 == i3) {
                    this.produced = j2;
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i2 = i3;
                }
            }
        }
    }

    public C4707d2(AbstractC4519l<T> abstractC4519l, AbstractC4516j0 abstractC4516j0, boolean z, int i2) {
        super(abstractC4519l);
        this.f17827c = abstractC4516j0;
        this.f17828d = z;
        this.f17829e = i2;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        AbstractC4516j0.c mo17277a = this.f17827c.mo17277a();
        if (interfaceC5822c instanceof InterfaceC4602a) {
            this.f17759b.m17799a((InterfaceC4529q) new b((InterfaceC4602a) interfaceC5822c, mo17277a, this.f17828d, this.f17829e));
        } else {
            this.f17759b.m17799a((InterfaceC4529q) new c(interfaceC5822c, mo17277a, this.f17828d, this.f17829e));
        }
    }
}
