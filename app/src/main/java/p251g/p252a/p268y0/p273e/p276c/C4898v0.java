package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.InterfaceC4588y;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.C4551b;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5822c;

/* compiled from: MaybeMergeArray.java */
/* renamed from: g.a.y0.e.c.v0 */
/* loaded from: classes2.dex */
public final class C4898v0<T> extends AbstractC4519l<T> {

    /* renamed from: b */
    final InterfaceC4588y<? extends T>[] f18717b;

    /* compiled from: MaybeMergeArray.java */
    /* renamed from: g.a.y0.e.c.v0$a */
    static final class a<T> extends ConcurrentLinkedQueue<T> implements d<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        a() {
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public void drop() {
            poll();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, p251g.p252a.p268y0.p273e.p276c.C4898v0.d, p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            T t = (T) super.poll();
            if (t != null) {
                this.consumerIndex++;
            }
            return t;
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }
    }

    /* compiled from: MaybeMergeArray.java */
    /* renamed from: g.a.y0.e.c.v0$b */
    static final class b<T> extends AbstractC5153c<T> implements InterfaceC4559v<T> {
        private static final long serialVersionUID = -660395290758764731L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        long consumed;
        boolean outputFused;
        final d<Object> queue;
        final int sourceCount;
        final C4551b set = new C4551b();
        final AtomicLong requested = new AtomicLong();
        final C5163c error = new C5163c();

        b(InterfaceC5822c<? super T> interfaceC5822c, int i2, d<Object> dVar) {
            this.actual = interfaceC5822c;
            this.sourceCount = i2;
            this.queue = dVar;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        void drainFused() {
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            d<Object> dVar = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    dVar.clear();
                    interfaceC5822c.onError(th);
                    return;
                }
                boolean z = dVar.producerIndex() == this.sourceCount;
                if (!dVar.isEmpty()) {
                    interfaceC5822c.onNext(null);
                }
                if (z) {
                    interfaceC5822c.onComplete();
                    return;
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            dVar.clear();
        }

        void drainNormal() {
            InterfaceC5822c<? super T> interfaceC5822c = this.actual;
            d<Object> dVar = this.queue;
            long j2 = this.consumed;
            int i2 = 1;
            do {
                long j3 = this.requested.get();
                while (j2 != j3) {
                    if (this.cancelled) {
                        dVar.clear();
                        return;
                    }
                    if (this.error.get() != null) {
                        dVar.clear();
                        interfaceC5822c.onError(this.error.terminate());
                        return;
                    } else {
                        if (dVar.consumerIndex() == this.sourceCount) {
                            interfaceC5822c.onComplete();
                            return;
                        }
                        Object poll = dVar.poll();
                        if (poll == null) {
                            break;
                        } else if (poll != EnumC5177q.COMPLETE) {
                            interfaceC5822c.onNext(poll);
                            j2++;
                        }
                    }
                }
                if (j2 == j3) {
                    if (this.error.get() != null) {
                        dVar.clear();
                        interfaceC5822c.onError(this.error.terminate());
                        return;
                    } else {
                        while (dVar.peek() == EnumC5177q.COMPLETE) {
                            dVar.drop();
                        }
                        if (dVar.consumerIndex() == this.sourceCount) {
                            interfaceC5822c.onComplete();
                            return;
                        }
                    }
                }
                this.consumed = j2;
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }

        boolean isCancelled() {
            return this.cancelled;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onComplete() {
            this.queue.offer(EnumC5177q.COMPLETE);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                C4476a.m17152b(th);
                return;
            }
            this.set.dispose();
            this.queue.offer(EnumC5177q.COMPLETE);
            drain();
        }

        @Override // p251g.p252a.InterfaceC4559v
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.set.mo18181b(interfaceC4552c);
        }

        @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
        public void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            T t;
            do {
                t = (T) this.queue.poll();
            } while (t == EnumC5177q.COMPLETE);
            return t;
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

    /* compiled from: MaybeMergeArray.java */
    /* renamed from: g.a.y0.e.c.v0$d */
    interface d<T> extends InterfaceC4616o<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Override // java.util.Queue, p251g.p252a.p268y0.p273e.p276c.C4898v0.d, p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        T poll();

        int producerIndex();
    }

    public C4898v0(InterfaceC4588y<? extends T>[] interfaceC4588yArr) {
        this.f18717b = interfaceC4588yArr;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        InterfaceC4588y[] interfaceC4588yArr = this.f18717b;
        int length = interfaceC4588yArr.length;
        b bVar = new b(interfaceC5822c, length, length <= AbstractC4519l.m17539Q() ? new c(length) : new a());
        interfaceC5822c.onSubscribe(bVar);
        C5163c c5163c = bVar.error;
        for (InterfaceC4588y interfaceC4588y : interfaceC4588yArr) {
            if (bVar.isCancelled() || c5163c.get() != null) {
                return;
            }
            interfaceC4588y.mo18100a(bVar);
        }
    }

    /* compiled from: MaybeMergeArray.java */
    /* renamed from: g.a.y0.e.c.v0$c */
    static final class c<T> extends AtomicReferenceArray<T> implements d<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex;

        c(int i2) {
            super(i2);
            this.producerIndex = new AtomicInteger();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public int consumerIndex() {
            return this.consumerIndex;
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public void drop() {
            int i2 = this.consumerIndex;
            lazySet(i2, null);
            this.consumerIndex = i2 + 1;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t) {
            C4601b.m18284a((Object) t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t);
            return true;
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public T peek() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            return get(i2);
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d, java.util.Queue, p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            int i2 = this.consumerIndex;
            if (i2 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i2);
                if (t != null) {
                    this.consumerIndex = i2 + 1;
                    lazySet(i2, null);
                    return t;
                }
            } while (atomicInteger.get() != i2);
            return null;
        }

        @Override // p251g.p252a.p268y0.p273e.p276c.C4898v0.d
        public int producerIndex() {
            return this.producerIndex.get();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }
    }
}
