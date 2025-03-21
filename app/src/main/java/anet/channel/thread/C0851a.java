package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: anet.channel.thread.a */
/* loaded from: classes.dex */
class C0851a extends ThreadPoolExecutor {
    public C0851a(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new a(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new a(callable);
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.thread.a$a */
    class a<V> extends FutureTask<V> implements Comparable<a<V>> {

        /* renamed from: b */
        private Object f1162b;

        public a(Callable<V> callable) {
            super(callable);
            this.f1162b = callable;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a<V> aVar) {
            if (this == aVar) {
                return 0;
            }
            if (aVar == null) {
                return -1;
            }
            Object obj = this.f1162b;
            if (obj != null && aVar.f1162b != null && obj.getClass().equals(aVar.f1162b.getClass())) {
                Object obj2 = this.f1162b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(aVar.f1162b);
                }
            }
            return 0;
        }

        public a(Runnable runnable, V v) {
            super(runnable, v);
            this.f1162b = runnable;
        }
    }
}
