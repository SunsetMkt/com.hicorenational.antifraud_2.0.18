package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p.v;
import java.io.IOException;

/* JADX INFO: compiled from: ResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public interface l<T, Z> {
    @Nullable
    v<Z> a(@NonNull T t, int i2, int i3, @NonNull j jVar) throws IOException;

    boolean a(@NonNull T t, @NonNull j jVar) throws IOException;
}
