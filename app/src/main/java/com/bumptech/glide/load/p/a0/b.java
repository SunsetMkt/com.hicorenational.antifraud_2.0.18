package com.bumptech.glide.load.p.a0;

/* JADX INFO: compiled from: ArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    public static final int a = 65536;

    <T> T a(int i2, Class<T> cls);

    void a();

    void a(int i2);

    @Deprecated
    <T> void a(T t, Class<T> cls);

    <T> T b(int i2, Class<T> cls);

    <T> void put(T t);
}
