package com.bumptech.glide.p136q;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.p118p.C1664i;
import com.bumptech.glide.load.p118p.C1675t;
import com.bumptech.glide.load.p125r.p130h.C1768g;
import com.bumptech.glide.util.C1875i;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* renamed from: com.bumptech.glide.q.c */
/* loaded from: classes.dex */
public class C1818c {

    /* renamed from: c */
    private static final C1675t<?, ?, ?> f5247c = new C1675t<>(Object.class, Object.class, Object.class, Collections.singletonList(new C1664i(Object.class, Object.class, Object.class, Collections.emptyList(), new C1768g(), null)), null);

    /* renamed from: a */
    private final ArrayMap<C1875i, C1675t<?, ?, ?>> f5248a = new ArrayMap<>();

    /* renamed from: b */
    private final AtomicReference<C1875i> f5249b = new AtomicReference<>();

    /* renamed from: b */
    private C1875i m4697b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        C1875i andSet = this.f5249b.getAndSet(null);
        if (andSet == null) {
            andSet = new C1875i();
        }
        andSet.m4984a(cls, cls2, cls3);
        return andSet;
    }

    /* renamed from: a */
    public boolean m4700a(@Nullable C1675t<?, ?, ?> c1675t) {
        return f5247c.equals(c1675t);
    }

    @Nullable
    /* renamed from: a */
    public <Data, TResource, Transcode> C1675t<Data, TResource, Transcode> m4698a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        C1675t<Data, TResource, Transcode> c1675t;
        C1875i m4697b = m4697b(cls, cls2, cls3);
        synchronized (this.f5248a) {
            c1675t = (C1675t) this.f5248a.get(m4697b);
        }
        this.f5249b.set(m4697b);
        return c1675t;
    }

    /* renamed from: a */
    public void m4699a(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable C1675t<?, ?, ?> c1675t) {
        synchronized (this.f5248a) {
            ArrayMap<C1875i, C1675t<?, ?, ?>> arrayMap = this.f5248a;
            C1875i c1875i = new C1875i(cls, cls2, cls3);
            if (c1675t == null) {
                c1675t = f5247c;
            }
            arrayMap.put(c1875i, c1675t);
        }
    }
}
