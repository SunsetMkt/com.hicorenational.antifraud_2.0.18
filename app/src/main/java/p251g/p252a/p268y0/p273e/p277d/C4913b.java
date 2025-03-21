package p251g.p252a.p268y0.p273e.p277d;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p251g.p252a.InterfaceC4504g0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: BlockingObservableIterable.java */
/* renamed from: g.a.y0.e.d.b */
/* loaded from: classes2.dex */
public final class C4913b<T> implements Iterable<T> {

    /* renamed from: a */
    final InterfaceC4504g0<? extends T> f18775a;

    /* renamed from: b */
    final int f18776b;

    /* compiled from: BlockingObservableIterable.java */
    /* renamed from: g.a.y0.e.d.b$a */
    static final class a<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, Iterator<T>, InterfaceC4552c {
        private static final long serialVersionUID = 6695226475494099826L;
        volatile boolean done;
        Throwable error;
        final C5111c<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        a(int i2) {
            this.queue = new C5111c<>(i2);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            EnumC4592d.dispose(this);
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
                try {
                    C5165e.m18612a();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (InterruptedException e2) {
                    EnumC4592d.dispose(this);
                    signalConsumer();
                    throw C5171k.m18626c(e2);
                }
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return EnumC4592d.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            EnumC4592d.setOnce(this, interfaceC4552c);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
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

    public C4913b(InterfaceC4504g0<? extends T> interfaceC4504g0, int i2) {
        this.f18775a = interfaceC4504g0;
        this.f18776b = i2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f18776b);
        this.f18775a.subscribe(aVar);
        return aVar;
    }
}
