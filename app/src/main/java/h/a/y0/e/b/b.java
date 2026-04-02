package h.a.y0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: BlockingFlowableIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements Iterable<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f10574b;

    /* JADX INFO: compiled from: BlockingFlowableIterable.java */
    static final class a<T> extends AtomicReference<j.d.d> implements h.a.q<T>, Iterator<T>, Runnable, h.a.u0.c {
        private static final long serialVersionUID = 6695226475494099826L;
        final long batchSize;
        volatile boolean done;
        Throwable error;
        final long limit;
        long produced;
        final h.a.y0.f.b<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        a(int i2) {
            this.queue = new h.a.y0.f.b<>(i2);
            this.batchSize = i2;
            this.limit = i2 - (i2 >> 2);
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw h.a.y0.j.k.c(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                h.a.y0.j.e.a();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e2) {
                            run();
                            throw h.a.y0.j.k.c(e2);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tPoll = this.queue.poll();
            long j2 = this.produced + 1;
            if (j2 == this.limit) {
                this.produced = 0L;
                get().request(j2);
            } else {
                this.produced = j2;
            }
            return tPoll;
        }

        @Override // j.d.c
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                signalConsumer();
            } else {
                h.a.y0.i.j.cancel(this);
                onError(new h.a.v0.c("Queue full?!"));
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(this.batchSize);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.y0.i.j.cancel(this);
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

    public b(h.a.l<T> lVar, int i2) {
        this.a = lVar;
        this.f10574b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f10574b);
        this.a.a((h.a.q) aVar);
        return aVar;
    }
}
