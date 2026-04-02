package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DataFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public interface d<T> {

    /* JADX INFO: compiled from: DataFetcher.java */
    public interface a<T> {
        void a(@NonNull Exception exc);

        void a(@Nullable T t);
    }

    @NonNull
    Class<T> a();

    void a(@NonNull com.bumptech.glide.h hVar, @NonNull a<? super T> aVar);

    void b();

    @NonNull
    com.bumptech.glide.load.a c();

    void cancel();
}
