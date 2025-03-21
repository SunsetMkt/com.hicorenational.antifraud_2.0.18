package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import p031c.p035b.p040b.p041a.p042a.InterfaceFutureC0952a;

/* loaded from: classes.dex */
public interface Observable<T> {

    public interface Observer<T> {
        void onError(@NonNull Throwable th);

        void onNewData(@Nullable T t);
    }

    void addObserver(@NonNull Executor executor, @NonNull Observer<T> observer);

    @NonNull
    InterfaceFutureC0952a<T> fetchData();

    void removeObserver(@NonNull Observer<T> observer);
}
