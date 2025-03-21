package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.C1579e;

/* compiled from: FixedPreloadSizeProvider.java */
/* renamed from: com.bumptech.glide.util.e */
/* loaded from: classes.dex */
public class C1871e<T> implements C1579e.b<T> {

    /* renamed from: a */
    private final int[] f5484a;

    public C1871e(int i2, int i3) {
        this.f5484a = new int[]{i2, i3};
    }

    @Override // com.bumptech.glide.C1579e.b
    @Nullable
    /* renamed from: a */
    public int[] mo3704a(@NonNull T t, int i2, int i3) {
        return this.f5484a;
    }
}
