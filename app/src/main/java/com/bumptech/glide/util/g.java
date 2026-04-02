package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T, Y> {
    private final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f3565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3566d;

    public g(long j2) {
        this.f3564b = j2;
        this.f3565c = j2;
    }

    public synchronized void a(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f3565c = Math.round(this.f3564b * f2);
        d();
    }

    protected void a(@NonNull T t, @Nullable Y y) {
    }

    public synchronized long b() {
        return this.f3565c;
    }

    protected synchronized int c() {
        return this.a.size();
    }

    protected int c(@Nullable Y y) {
        return 1;
    }

    @Nullable
    public synchronized Y d(@NonNull T t) {
        Y yRemove;
        yRemove = this.a.remove(t);
        if (yRemove != null) {
            this.f3566d -= (long) c(yRemove);
        }
        return yRemove;
    }

    public synchronized long getCurrentSize() {
        return this.f3566d;
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        return this.a.get(t);
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        long jC = c(y);
        if (jC >= this.f3565c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f3566d += jC;
        }
        Y yPut = this.a.put(t, y);
        if (yPut != null) {
            this.f3566d -= (long) c(yPut);
            if (!yPut.equals(y)) {
                a(t, yPut);
            }
        }
        d();
        return yPut;
    }

    private void d() {
        a(this.f3565c);
    }

    public synchronized boolean a(@NonNull T t) {
        return this.a.containsKey(t);
    }

    public void a() {
        a(0L);
    }

    protected synchronized void a(long j2) {
        while (this.f3566d > j2) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f3566d -= (long) c(value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }
}
