package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = new Function<Object, Object>() { // from class: androidx.camera.core.impl.utils.futures.Futures.2
        @Override // androidx.arch.core.util.Function
        public Object apply(Object obj) {
            return obj;
        }
    };

    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> mCallback;
        final Future<V> mFuture;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.mFuture = future;
            this.mCallback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mCallback.onSuccess(Futures.getDone(this.mFuture));
            } catch (Error e2) {
                e = e2;
                this.mCallback.onFailure(e);
            } catch (RuntimeException e3) {
                e = e3;
                this.mCallback.onFailure(e);
            } catch (ExecutionException e4) {
                this.mCallback.onFailure(e4.getCause());
            }
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + Constants.ACCEPT_TIME_SEPARATOR_SP + this.mCallback;
        }
    }

    private Futures() {
    }

    /* renamed from: a */
    static /* synthetic */ Object m375a(InterfaceFutureC0952a interfaceFutureC0952a, CallbackToFutureAdapter.Completer completer) throws Exception {
        propagateTransform(false, interfaceFutureC0952a, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
        return "nonCancellationPropagating[" + interfaceFutureC0952a + "]";
    }

    public static <V> void addCallback(@NonNull InterfaceFutureC0952a<V> interfaceFutureC0952a, @NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        interfaceFutureC0952a.addListener(new CallbackListener(interfaceFutureC0952a, futureCallback), executor);
    }

    @NonNull
    public static <V> InterfaceFutureC0952a<List<V>> allAsList(@NonNull Collection<? extends InterfaceFutureC0952a<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), true, CameraXExecutors.directExecutor());
    }

    @Nullable
    public static <V> V getDone(@NonNull Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done, " + future);
        return (V) getUninterruptibly(future);
    }

    @Nullable
    public static <V> V getUninterruptibly(@NonNull Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
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
        return v;
    }

    @NonNull
    public static <V> InterfaceFutureC0952a<V> immediateFailedFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    @NonNull
    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(@NonNull Throwable th) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(th);
    }

    @NonNull
    public static <V> InterfaceFutureC0952a<V> immediateFuture(@Nullable V v) {
        return v == null ? ImmediateFuture.nullFuture() : new ImmediateFuture.ImmediateSuccessfulFuture(v);
    }

    @NonNull
    public static <V> InterfaceFutureC0952a<V> nonCancellationPropagating(@NonNull final InterfaceFutureC0952a<V> interfaceFutureC0952a) {
        Preconditions.checkNotNull(interfaceFutureC0952a);
        return interfaceFutureC0952a.isDone() ? interfaceFutureC0952a : CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.impl.utils.futures.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Futures.m375a(InterfaceFutureC0952a.this, completer);
            }
        });
    }

    public static <V> void propagate(@NonNull InterfaceFutureC0952a<V> interfaceFutureC0952a, @NonNull CallbackToFutureAdapter.Completer<V> completer) {
        propagateTransform(interfaceFutureC0952a, IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }

    public static <I, O> void propagateTransform(@NonNull InterfaceFutureC0952a<I> interfaceFutureC0952a, @NonNull Function<? super I, ? extends O> function, @NonNull CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        propagateTransform(true, interfaceFutureC0952a, function, completer, executor);
    }

    @NonNull
    public static <V> InterfaceFutureC0952a<List<V>> successfulAsList(@NonNull Collection<? extends InterfaceFutureC0952a<? extends V>> collection) {
        return new ListFuture(new ArrayList(collection), false, CameraXExecutors.directExecutor());
    }

    @NonNull
    public static <I, O> InterfaceFutureC0952a<O> transform(@NonNull InterfaceFutureC0952a<I> interfaceFutureC0952a, @NonNull final Function<? super I, ? extends O> function, @NonNull Executor executor) {
        Preconditions.checkNotNull(function);
        return transformAsync(interfaceFutureC0952a, new AsyncFunction<I, O>() { // from class: androidx.camera.core.impl.utils.futures.Futures.1
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public InterfaceFutureC0952a<O> apply(I i2) {
                return Futures.immediateFuture(Function.this.apply(i2));
            }
        }, executor);
    }

    @NonNull
    public static <I, O> InterfaceFutureC0952a<O> transformAsync(@NonNull InterfaceFutureC0952a<I> interfaceFutureC0952a, @NonNull AsyncFunction<? super I, ? extends O> asyncFunction, @NonNull Executor executor) {
        ChainingListenableFuture chainingListenableFuture = new ChainingListenableFuture(asyncFunction, interfaceFutureC0952a);
        interfaceFutureC0952a.addListener(chainingListenableFuture, executor);
        return chainingListenableFuture;
    }

    private static <I, O> void propagateTransform(boolean z, @NonNull final InterfaceFutureC0952a<I> interfaceFutureC0952a, @NonNull final Function<? super I, ? extends O> function, @NonNull final CallbackToFutureAdapter.Completer<O> completer, @NonNull Executor executor) {
        Preconditions.checkNotNull(interfaceFutureC0952a);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(completer);
        Preconditions.checkNotNull(executor);
        addCallback(interfaceFutureC0952a, new FutureCallback<I>() { // from class: androidx.camera.core.impl.utils.futures.Futures.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                CallbackToFutureAdapter.Completer.this.setException(th);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable I i2) {
                try {
                    CallbackToFutureAdapter.Completer.this.set(function.apply(i2));
                } catch (Throwable th) {
                    CallbackToFutureAdapter.Completer.this.setException(th);
                }
            }
        }, executor);
        if (z) {
            completer.addCancellationListener(new Runnable() { // from class: androidx.camera.core.impl.utils.futures.Futures.4
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceFutureC0952a.this.cancel(true);
                }
            }, CameraXExecutors.directExecutor());
        }
    }
}
