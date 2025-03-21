package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture<>();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(@Nullable V v) {
        return super.set(v);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setFuture(InterfaceFutureC0952a<? extends V> interfaceFutureC0952a) {
        return super.setFuture(interfaceFutureC0952a);
    }
}
