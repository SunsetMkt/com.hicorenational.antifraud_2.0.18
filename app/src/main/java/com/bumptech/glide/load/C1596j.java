package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* renamed from: com.bumptech.glide.load.j */
/* loaded from: classes.dex */
public final class C1596j implements InterfaceC1593g {

    /* renamed from: c */
    private final ArrayMap<C1595i<?>, Object> f4198c = new CachedHashCodeArrayMap();

    /* renamed from: a */
    public void m3841a(@NonNull C1596j c1596j) {
        this.f4198c.putAll((SimpleArrayMap<? extends C1595i<?>, ? extends Object>) c1596j.f4198c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (obj instanceof C1596j) {
            return this.f4198c.equals(((C1596j) obj).f4198c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        return this.f4198c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f4198c + '}';
    }

    @NonNull
    /* renamed from: a */
    public <T> C1596j m3839a(@NonNull C1595i<T> c1595i, @NonNull T t) {
        this.f4198c.put(c1595i, t);
        return this;
    }

    @Nullable
    /* renamed from: a */
    public <T> T m3840a(@NonNull C1595i<T> c1595i) {
        return this.f4198c.containsKey(c1595i) ? (T) this.f4198c.get(c1595i) : c1595i.m3835a();
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f4198c.size(); i2++) {
            m3838a(this.f4198c.keyAt(i2), this.f4198c.valueAt(i2), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static <T> void m3838a(@NonNull C1595i<T> c1595i, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        c1595i.m3836a((C1595i<T>) obj, messageDigest);
    }
}
