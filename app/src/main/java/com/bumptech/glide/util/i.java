package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MultiClassKey.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    private Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f3569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f3570c;

    public i() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.a.equals(iVar.a) && this.f3569b.equals(iVar.f3569b) && l.b(this.f3570c, iVar.f3570c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.f3569b.hashCode()) * 31;
        Class<?> cls = this.f3570c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.f3569b + '}';
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.a = cls;
        this.f3569b = cls2;
        this.f3570c = cls3;
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
