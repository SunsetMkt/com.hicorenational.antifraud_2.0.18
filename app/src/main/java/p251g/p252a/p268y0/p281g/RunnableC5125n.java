package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.InterfaceC4591c;

/* compiled from: ScheduledRunnable.java */
/* renamed from: g.a.y0.g.n */
/* loaded from: classes2.dex */
public final class RunnableC5125n extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, InterfaceC4552c {
    static final int FUTURE_INDEX = 1;
    static final int PARENT_INDEX = 0;
    static final int THREAD_INDEX = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;
    static final Object PARENT_DISPOSED = new Object();
    static final Object SYNC_DISPOSED = new Object();
    static final Object ASYNC_DISPOSED = new Object();
    static final Object DONE = new Object();

    public RunnableC5125n(Runnable runnable, InterfaceC4591c interfaceC4591c) {
        super(3);
        this.actual = runnable;
        lazySet(0, interfaceC4591c);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        Object obj;
        Object obj2;
        while (true) {
            Object obj3 = get(1);
            if (obj3 == DONE || obj3 == SYNC_DISPOSED || obj3 == ASYNC_DISPOSED) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (compareAndSet(1, obj3, z ? ASYNC_DISPOSED : SYNC_DISPOSED)) {
                if (obj3 != null) {
                    ((Future) obj3).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((InterfaceC4591c) obj).mo18182c(this);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == PARENT_DISPOSED || obj == DONE;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != PARENT_DISPOSED) {
                    ((InterfaceC4591c) obj4).mo18182c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != SYNC_DISPOSED) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj5, DONE));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != PARENT_DISPOSED && compareAndSet(0, obj4, DONE) && obj4 != null) {
            ((InterfaceC4591c) obj4).mo18182c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != SYNC_DISPOSED || obj5 == ASYNC_DISPOSED) {
                return;
            }
        } while (!compareAndSet(1, obj5, DONE));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            } else if (obj == ASYNC_DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
