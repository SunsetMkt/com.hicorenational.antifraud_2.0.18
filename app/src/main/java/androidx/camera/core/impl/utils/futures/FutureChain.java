package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public class FutureChain<V> implements InterfaceFutureC0952a<V> {

    @Nullable
    CallbackToFutureAdapter.Completer<V> mCompleter;

    @NonNull
    private final InterfaceFutureC0952a<V> mDelegate;

    FutureChain(@NonNull InterfaceFutureC0952a<V> interfaceFutureC0952a) {
        this.mDelegate = (InterfaceFutureC0952a) Preconditions.checkNotNull(interfaceFutureC0952a);
    }

    @NonNull
    public static <V> FutureChain<V> from(@NonNull InterfaceFutureC0952a<V> interfaceFutureC0952a) {
        return interfaceFutureC0952a instanceof FutureChain ? (FutureChain) interfaceFutureC0952a : new FutureChain<>(interfaceFutureC0952a);
    }

    public final void addCallback(@NonNull FutureCallback<? super V> futureCallback, @NonNull Executor executor) {
        Futures.addCallback(this, futureCallback, executor);
    }

    @Override // p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mDelegate.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.mDelegate.cancel(z);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    boolean set(@Nullable V v) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.set(v);
        }
        return false;
    }

    boolean setException(@NonNull Throwable th) {
        CallbackToFutureAdapter.Completer<V> completer = this.mCompleter;
        if (completer != null) {
            return completer.setException(th);
        }
        return false;
    }

    @NonNull
    public final <T> FutureChain<T> transform(@NonNull Function<? super V, T> function, @NonNull Executor executor) {
        return (FutureChain) Futures.transform(this, function, executor);
    }

    @NonNull
    public final <T> FutureChain<T> transformAsync(@NonNull AsyncFunction<? super V, T> asyncFunction, @NonNull Executor executor) {
        return (FutureChain) Futures.transformAsync(this, asyncFunction, executor);
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public V get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(j2, timeUnit);
    }

    FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<V>() { // from class: androidx.camera.core.impl.utils.futures.FutureChain.1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<V> completer) {
                Preconditions.checkState(FutureChain.this.mCompleter == null, "The result can only set once!");
                FutureChain.this.mCompleter = completer;
                return "FutureChain[" + FutureChain.this + "]";
            }
        });
    }
}
