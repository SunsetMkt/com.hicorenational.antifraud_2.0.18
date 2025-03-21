package com.bumptech.glide.p136q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.C1875i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache.java */
/* renamed from: com.bumptech.glide.q.d */
/* loaded from: classes.dex */
public class C1819d {

    /* renamed from: a */
    private final AtomicReference<C1875i> f5250a = new AtomicReference<>();

    /* renamed from: b */
    private final ArrayMap<C1875i, List<Class<?>>> f5251b = new ArrayMap<>();

    @Nullable
    /* renamed from: a */
    public List<Class<?>> m4701a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        C1875i andSet = this.f5250a.getAndSet(null);
        if (andSet == null) {
            andSet = new C1875i(cls, cls2, cls3);
        } else {
            andSet.m4984a(cls, cls2, cls3);
        }
        synchronized (this.f5251b) {
            list = this.f5251b.get(andSet);
        }
        this.f5250a.set(andSet);
        return list;
    }

    /* renamed from: a */
    public void m4703a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f5251b) {
            this.f5251b.put(new C1875i(cls, cls2, cls3), list);
        }
    }

    /* renamed from: a */
    public void m4702a() {
        synchronized (this.f5251b) {
            this.f5251b.clear();
        }
    }
}
