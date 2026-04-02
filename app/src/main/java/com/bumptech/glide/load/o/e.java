package com.bumptech.glide.load.o;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: DataRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public interface e<T> {

    /* JADX INFO: compiled from: DataRewinder.java */
    public interface a<T> {
        @NonNull
        e<T> a(@NonNull T t);

        @NonNull
        Class<T> a();
    }

    @NonNull
    T a() throws IOException;

    void b();
}
