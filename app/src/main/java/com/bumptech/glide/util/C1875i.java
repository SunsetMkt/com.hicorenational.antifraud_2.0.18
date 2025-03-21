package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: MultiClassKey.java */
/* renamed from: com.bumptech.glide.util.i */
/* loaded from: classes.dex */
public class C1875i {

    /* renamed from: a */
    private Class<?> f5493a;

    /* renamed from: b */
    private Class<?> f5494b;

    /* renamed from: c */
    private Class<?> f5495c;

    public C1875i() {
    }

    /* renamed from: a */
    public void m4983a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m4984a(cls, cls2, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1875i.class != obj.getClass()) {
            return false;
        }
        C1875i c1875i = (C1875i) obj;
        return this.f5493a.equals(c1875i.f5493a) && this.f5494b.equals(c1875i.f5494b) && C1878l.m5009b(this.f5495c, c1875i.f5495c);
    }

    public int hashCode() {
        int hashCode = ((this.f5493a.hashCode() * 31) + this.f5494b.hashCode()) * 31;
        Class<?> cls = this.f5495c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f5493a + ", second=" + this.f5494b + '}';
    }

    public C1875i(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        m4983a(cls, cls2);
    }

    /* renamed from: a */
    public void m4984a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f5493a = cls;
        this.f5494b = cls2;
        this.f5495c = cls3;
    }

    public C1875i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        m4984a(cls, cls2, cls3);
    }
}
