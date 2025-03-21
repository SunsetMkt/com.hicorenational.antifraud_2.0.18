package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {

    @Nullable
    private AsyncFunction<? super I, ? extends O> mFunction;

    @Nullable
    private InterfaceFutureC0952a<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
    private final CountDownLatch mOutputCreated = new CountDownLatch(1);

    @Nullable
    volatile InterfaceFutureC0952a<? extends O> mOutputFuture;

    ChainingListenableFuture(@NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull InterfaceFutureC0952a<? extends I> interfaceFutureC0952a) {
        this.mFunction = (AsyncFunction) Preconditions.checkNotNull(asyncFunction);
        this.mInputFuture = (InterfaceFutureC0952a) Preconditions.checkNotNull(interfaceFutureC0952a);
    }

    private <E> void putUninterruptibly(@NonNull BlockingQueue<E> blockingQueue, @NonNull E e2) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(e2);
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private <E> E takeUninterruptibly(@NonNull BlockingQueue<E> blockingQueue) {
        E take;
        boolean z = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!super.cancel(z)) {
            return false;
        }
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(z));
        cancel(this.mInputFuture, z);
        cancel(this.mOutputFuture, z);
        return true;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    @Nullable
    public O get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            InterfaceFutureC0952a<? extends I> interfaceFutureC0952a = this.mInputFuture;
            if (interfaceFutureC0952a != null) {
                interfaceFutureC0952a.get();
            }
            this.mOutputCreated.await();
            InterfaceFutureC0952a<? extends O> interfaceFutureC0952a2 = this.mOutputFuture;
            if (interfaceFutureC0952a2 != null) {
                interfaceFutureC0952a2.get();
            }
        }
        return (O) super.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        final InterfaceFutureC0952a<? extends O> apply;
        try {
        } catch (Exception e2) {
            setException(e2);
        }
        try {
            try {
                try {
                    apply = this.mFunction.apply(Futures.getUninterruptibly(this.mInputFuture));
                    this.mOutputFuture = apply;
                } catch (Error e3) {
                    setException(e3);
                } catch (UndeclaredThrowableException e4) {
                    setException(e4.getCause());
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e5) {
                setException(e5.getCause());
            }
            if (!isCancelled()) {
                apply.addListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.ChainingListenableFuture.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                ChainingListenableFuture.this.set(Futures.getUninterruptibly(apply));
                            } catch (CancellationException unused2) {
                                ChainingListenableFuture.this.cancel(false);
                                ChainingListenableFuture.this.mOutputFuture = null;
                                return;
                            } catch (ExecutionException e6) {
                                ChainingListenableFuture.this.setException(e6.getCause());
                            }
                            ChainingListenableFuture.this.mOutputFuture = null;
                        } catch (Throwable th) {
                            ChainingListenableFuture.this.mOutputFuture = null;
                            throw th;
                        }
                    }
                }, CameraXExecutors.directExecutor());
                this.mFunction = null;
                this.mInputFuture = null;
                this.mOutputCreated.countDown();
                return;
            }
            apply.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());
            this.mOutputFuture = null;
            this.mFunction = null;
            this.mInputFuture = null;
            this.mOutputCreated.countDown();
        } catch (Throwable th) {
            this.mFunction = null;
            this.mInputFuture = null;
            this.mOutputCreated.countDown();
            throw th;
        }
    }

    private void cancel(@Nullable Future<?> future, boolean z) {
        if (future != null) {
            future.cancel(z);
        }
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    @Nullable
    public O get(long j2, @NonNull TimeUnit timeUnit) throws TimeoutException, ExecutionException, InterruptedException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j2 = timeUnit2.convert(j2, timeUnit);
                timeUnit = TimeUnit.NANOSECONDS;
            }
            InterfaceFutureC0952a<? extends I> interfaceFutureC0952a = this.mInputFuture;
            if (interfaceFutureC0952a != null) {
                long nanoTime = System.nanoTime();
                interfaceFutureC0952a.get(j2, timeUnit);
                j2 -= Math.max(0L, System.nanoTime() - nanoTime);
            }
            long nanoTime2 = System.nanoTime();
            if (this.mOutputCreated.await(j2, timeUnit)) {
                j2 -= Math.max(0L, System.nanoTime() - nanoTime2);
                InterfaceFutureC0952a<? extends O> interfaceFutureC0952a2 = this.mOutputFuture;
                if (interfaceFutureC0952a2 != null) {
                    interfaceFutureC0952a2.get(j2, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return (O) super.get(j2, timeUnit);
    }
}
