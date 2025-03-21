package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: com.bumptech.glide.util.g */
/* loaded from: classes.dex */
public class C1873g<T, Y> {

    /* renamed from: a */
    private final Map<T, Y> f5486a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b */
    private final long f5487b;

    /* renamed from: c */
    private long f5488c;

    /* renamed from: d */
    private long f5489d;

    public C1873g(long j2) {
        this.f5487b = j2;
        this.f5488c = j2;
    }

    /* renamed from: a */
    public synchronized void m4973a(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.f5488c = Math.round(this.f5487b * f2);
        m4971d();
    }

    /* renamed from: a */
    protected void mo3999a(@NonNull T t, @Nullable Y y) {
    }

    /* renamed from: b */
    public synchronized long m4976b() {
        return this.f5488c;
    }

    /* renamed from: c */
    protected synchronized int m4979c() {
        return this.f5486a.size();
    }

    /* renamed from: c */
    protected int mo4001c(@Nullable Y y) {
        return 1;
    }

    @Nullable
    /* renamed from: d */
    public synchronized Y m4980d(@NonNull T t) {
        Y remove;
        remove = this.f5486a.remove(t);
        if (remove != null) {
            this.f5489d -= mo4001c(remove);
        }
        return remove;
    }

    public synchronized long getCurrentSize() {
        return this.f5489d;
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m4977b(@NonNull T t) {
        return this.f5486a.get(t);
    }

    @Nullable
    /* renamed from: b */
    public synchronized Y m4978b(@NonNull T t, @Nullable Y y) {
        long mo4001c = mo4001c(y);
        if (mo4001c >= this.f5488c) {
            mo3999a(t, y);
            return null;
        }
        if (y != null) {
            this.f5489d += mo4001c;
        }
        Y put = this.f5486a.put(t, y);
        if (put != null) {
            this.f5489d -= mo4001c(put);
            if (!put.equals(y)) {
                mo3999a(t, put);
            }
        }
        m4971d();
        return put;
    }

    /* renamed from: d */
    private void m4971d() {
        m4974a(this.f5488c);
    }

    /* renamed from: a */
    public synchronized boolean m4975a(@NonNull T t) {
        return this.f5486a.containsKey(t);
    }

    /* renamed from: a */
    public void m4972a() {
        m4974a(0L);
    }

    /* renamed from: a */
    protected synchronized void m4974a(long j2) {
        while (this.f5489d > j2) {
            Iterator<Map.Entry<T, Y>> it = this.f5486a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f5489d -= mo4001c(value);
            T key = next.getKey();
            it.remove();
            mo3999a(key, value);
        }
    }
}
