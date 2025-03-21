package p251g.p252a.p268y0.p273e.p275b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p280f.C5110b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BlockingFlowableIterable.java */
/* renamed from: g.a.y0.e.b.b */
/* loaded from: classes2.dex */
public final class C4692b<T> implements Iterable<T> {

    /* renamed from: a */
    final AbstractC4519l<T> f17774a;

    /* renamed from: b */
    final int f17775b;

    /* compiled from: BlockingFlowableIterable.java */
    /* renamed from: g.a.y0.e.b.b$a */
    static final class a<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, Iterator<T>, Runnable, InterfaceC4552c {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        volatile boolean done;
        Throwable error;
        final long limit;
        long produced;
        final C5110b<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        a(int i2) {
            this.queue = new C5110b<>(i2);
            this.batchSize = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC5160j.cancel(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw C5171k.m18626c(th);
                    }
                    if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                C5165e.m18612a();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e2) {
                            run();
                            throw C5171k.m18626c(e2);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC5160j.isCancelled(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T poll = this.queue.poll();
            long j2 = this.produced + 1;
            if (j2 == this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
            return poll;
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                signalConsumer();
            } else {
                EnumC5160j.cancel(this);
                onError(new C4562c("Queue full?!"));
            }
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
            if (EnumC5160j.setOnce(this, interfaceC5823d)) {
                interfaceC5823d.request(this.batchSize);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            EnumC5160j.cancel(this);
            signalConsumer();
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public C4692b(AbstractC4519l<T> abstractC4519l, int i2) {
        this.f17774a = abstractC4519l;
        this.f17775b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f17775b);
        this.f17774a.m17799a((InterfaceC4529q) aVar);
        return aVar;
    }
}
