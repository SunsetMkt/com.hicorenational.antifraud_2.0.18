package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
final class HandlerScheduledExecutorService extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal<ScheduledExecutorService> sThreadLocalInstance = new ThreadLocal<ScheduledExecutorService>() { // from class: androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService.1
        @Override // java.lang.ThreadLocal
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return CameraXExecutors.mainThreadExecutor();
            }
            if (Looper.myLooper() != null) {
                return new HandlerScheduledExecutorService(new Handler(Looper.myLooper()));
            }
            return null;
        }
    };
    private final Handler mHandler;

    private static class HandlerScheduledFuture<V> implements RunnableScheduledFuture<V> {
        final AtomicReference<CallbackToFutureAdapter.Completer<V>> mCompleter = new AtomicReference<>(null);
        private final InterfaceFutureC0952a<V> mDelegate;
        private final long mRunAtMillis;
        private final Callable<V> mTask;

        HandlerScheduledFuture(final Handler handler, long j2, final Callable<V> callable) {
            this.mRunAtMillis = j2;
            this.mTask = callable;
            this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() { // from class: androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService.HandlerScheduledFuture.1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<V> completer) throws RejectedExecutionException {
                    completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService.HandlerScheduledFuture.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (HandlerScheduledFuture.this.mCompleter.getAndSet(null) != null) {
                                C03731 c03731 = C03731.this;
                                handler.removeCallbacks(HandlerScheduledFuture.this);
                            }
                        }
                    }, CameraXExecutors.directExecutor());
                    HandlerScheduledFuture.this.mCompleter.set(completer);
                    return "HandlerScheduledFuture-" + callable.toString();
                }
            });
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.mDelegate.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public V get() throws ExecutionException, InterruptedException {
            return this.mDelegate.get();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.mRunAtMillis - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.mDelegate.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.mDelegate.isDone();
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            CallbackToFutureAdapter.Completer andSet = this.mCompleter.getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.set(this.mTask.call());
                } catch (Exception e2) {
                    andSet.setException(e2);
                }
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return Long.compare(getDelay(TimeUnit.MILLISECONDS), delayed.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override // java.util.concurrent.Future
        public V get(long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.mDelegate.get(j2, timeUnit);
        }
    }

    HandlerScheduledExecutorService(@NonNull Handler handler) {
        this.mHandler = handler;
    }

    private RejectedExecutionException createPostFailedException() {
        return new RejectedExecutionException(this.mHandler + " is shutting down");
    }

    static ScheduledExecutorService currentThreadExecutor() {
        ScheduledExecutorService scheduledExecutorService = sThreadLocalInstance.get();
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException("Current thread has no looper!");
        }
        HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(new Handler(myLooper));
        sThreadLocalInstance.set(handlerScheduledExecutorService);
        return handlerScheduledExecutorService;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        if (!this.mHandler.post(runnable)) {
            throw createPostFailedException();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(@NonNull final Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
        return schedule(new Callable<Void>() { // from class: androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                runnable.run();
                return null;
            }
        }, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    @NonNull
    public ScheduledFuture<?> scheduleAtFixedRate(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    @NonNull
    public ScheduledFuture<?> scheduleWithFixedDelay(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException(HandlerScheduledExecutorService.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    @NonNull
    public <V> ScheduledFuture<V> schedule(@NonNull Callable<V> callable, long j2, @NonNull TimeUnit timeUnit) {
        long uptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j2, timeUnit);
        HandlerScheduledFuture handlerScheduledFuture = new HandlerScheduledFuture(this.mHandler, uptimeMillis, callable);
        return this.mHandler.postAtTime(handlerScheduledFuture, uptimeMillis) ? handlerScheduledFuture : Futures.immediateFailedScheduledFuture(createPostFailedException());
    }
}
