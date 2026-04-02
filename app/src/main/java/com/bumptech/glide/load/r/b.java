package com.bumptech.glide.load.r;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.p.v;
import com.bumptech.glide.util.j;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> implements v<T> {
    protected final T a;

    public b(@NonNull T t) {
        this.a = (T) j.a(t);
    }

    @Override // com.bumptech.glide.load.p.v
    public final int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<T> b() {
        return (Class<T>) this.a.getClass();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public final T get() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.p.v
    public void recycle() {
    }
}
