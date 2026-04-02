package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Options.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements g {

    /* JADX INFO: renamed from: c */
    private final ArrayMap<i<?>, Object> f2721c = new CachedHashCodeArrayMap();

    public void a(@NonNull j jVar) {
        this.f2721c.putAll((SimpleArrayMap<? extends i<?>, ? extends Object>) jVar.f2721c);
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f2721c.equals(((j) obj).f2721c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        return this.f2721c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f2721c + '}';
    }

    @NonNull
    public <T> j a(@NonNull i<T> iVar, @NonNull T t) {
        this.f2721c.put(iVar, t);
        return this;
    }

    @Nullable
    public <T> T a(@NonNull i<T> iVar) {
        return this.f2721c.containsKey(iVar) ? (T) this.f2721c.get(iVar) : iVar.a();
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f2721c.size(); i2++) {
            a(this.f2721c.keyAt(i2), this.f2721c.valueAt(i2), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(@NonNull i<T> iVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        iVar.a(obj, messageDigest);
    }
}
