package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class a extends ThreadPoolExecutor {
    public a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0012a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0012a(callable);
    }

    /* JADX INFO: renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    class C0012a<V> extends FutureTask<V> implements Comparable<C0012a<V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f1647b;

        public C0012a(Callable<V> callable) {
            super(callable);
            this.f1647b = callable;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0012a<V> c0012a) {
            if (this == c0012a) {
                return 0;
            }
            if (c0012a == null) {
                return -1;
            }
            Object obj = this.f1647b;
            if (obj != null && c0012a.f1647b != null && obj.getClass().equals(c0012a.f1647b.getClass())) {
                Object obj2 = this.f1647b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(c0012a.f1647b);
                }
            }
            return 0;
        }

        public C0012a(Runnable runnable, V v) {
            super(runnable, v);
            this.f1647b = runnable;
        }
    }
}
