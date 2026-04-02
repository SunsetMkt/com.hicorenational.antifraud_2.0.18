package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.e;

/* JADX INFO: compiled from: FixedPreloadSizeProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class e<T> implements e.b<T> {
    private final int[] a;

    public e(int i2, int i3) {
        this.a = new int[]{i2, i3};
    }

    @Override // com.bumptech.glide.e.b
    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        return this.a;
    }
}
