package androidx.camera.core.impl.utils.futures;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
public interface AsyncFunction<I, O> {
    d.b.b.a.a.a<O> apply(@Nullable I i2) throws Exception;
}
