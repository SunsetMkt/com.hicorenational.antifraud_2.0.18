package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes.dex */
public final class i<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final b<Object> f2717e = new a();
    private final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b<T> f2718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile byte[] f2720d;

    /* JADX INFO: compiled from: Option.java */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.i.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* JADX INFO: compiled from: Option.java */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private i(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        this.f2719c = com.bumptech.glide.util.j.a(str);
        this.a = t;
        this.f2718b = (b) com.bumptech.glide.util.j.a(bVar);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str) {
        return new i<>(str, null, b());
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f2717e;
    }

    @NonNull
    private byte[] c() {
        if (this.f2720d == null) {
            this.f2720d = this.f2719c.getBytes(g.f2715b);
        }
        return this.f2720d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f2719c.equals(((i) obj).f2719c);
        }
        return false;
    }

    public int hashCode() {
        return this.f2719c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f2719c + "'}";
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @NonNull T t) {
        return new i<>(str, t, b());
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @NonNull b<T> bVar) {
        return new i<>(str, null, bVar);
    }

    @NonNull
    public static <T> i<T> a(@NonNull String str, @Nullable T t, @NonNull b<T> bVar) {
        return new i<>(str, t, bVar);
    }

    @Nullable
    public T a() {
        return this.a;
    }

    public void a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f2718b.a(c(), t, messageDigest);
    }
}
