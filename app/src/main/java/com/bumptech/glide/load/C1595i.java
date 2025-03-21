package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.C1876j;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* renamed from: com.bumptech.glide.load.i */
/* loaded from: classes.dex */
public final class C1595i<T> {

    /* renamed from: e */
    private static final b<Object> f4193e = new a();

    /* renamed from: a */
    private final T f4194a;

    /* renamed from: b */
    private final b<T> f4195b;

    /* renamed from: c */
    private final String f4196c;

    /* renamed from: d */
    private volatile byte[] f4197d;

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.i$a */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.C1595i.b
        /* renamed from: a */
        public void mo3837a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.i$b */
    public interface b<T> {
        /* renamed from: a */
        void mo3837a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private C1595i(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.f4196c = C1876j.m4987a(str);
        this.f4194a = t;
        this.f4195b = (b) C1876j.m4985a(bVar);
    }

    @NonNull
    /* renamed from: a */
    public static <T> C1595i<T> m3829a(@NonNull String str) {
        return new C1595i<>(str, null, m3833b());
    }

    @NonNull
    /* renamed from: b */
    private static <T> b<T> m3833b() {
        return (b<T>) f4193e;
    }

    @NonNull
    /* renamed from: c */
    private byte[] m3834c() {
        if (this.f4197d == null) {
            this.f4197d = this.f4196c.getBytes(InterfaceC1593g.f4191b);
        }
        return this.f4197d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1595i) {
            return this.f4196c.equals(((C1595i) obj).f4196c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4196c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f4196c + "'}";
    }

    @NonNull
    /* renamed from: a */
    public static <T> C1595i<T> m3831a(@NonNull String str, @NonNull T t) {
        return new C1595i<>(str, t, m3833b());
    }

    @NonNull
    /* renamed from: a */
    public static <T> C1595i<T> m3830a(@NonNull String str, @NonNull b<T> bVar) {
        return new C1595i<>(str, null, bVar);
    }

    @NonNull
    /* renamed from: a */
    public static <T> C1595i<T> m3832a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new C1595i<>(str, t, bVar);
    }

    @Nullable
    /* renamed from: a */
    public T m3835a() {
        return this.f4194a;
    }

    /* renamed from: a */
    public void m3836a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f4195b.mo3837a(m3834c(), t, messageDigest);
    }
}
