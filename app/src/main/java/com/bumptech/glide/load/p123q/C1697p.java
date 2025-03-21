package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.C1583i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* renamed from: com.bumptech.glide.load.q.p */
/* loaded from: classes.dex */
public class C1697p {

    /* renamed from: a */
    private final C1699r f4729a;

    /* renamed from: b */
    private final a f4730b;

    /* compiled from: ModelLoaderRegistry.java */
    /* renamed from: com.bumptech.glide.load.q.p$a */
    private static class a {

        /* renamed from: a */
        private final Map<Class<?>, C7362a<?>> f4731a = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.q.p$a$a, reason: collision with other inner class name */
        private static class C7362a<Model> {

            /* renamed from: a */
            final List<InterfaceC1695n<Model, ?>> f4732a;

            public C7362a(List<InterfaceC1695n<Model, ?>> list) {
                this.f4732a = list;
            }
        }

        a() {
        }

        /* renamed from: a */
        public void m4269a() {
            this.f4731a.clear();
        }

        /* renamed from: a */
        public <Model> void m4270a(Class<Model> cls, List<InterfaceC1695n<Model, ?>> list) {
            if (this.f4731a.put(cls, new C7362a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        @Nullable
        /* renamed from: a */
        public <Model> List<InterfaceC1695n<Model, ?>> m4268a(Class<Model> cls) {
            C7362a<?> c7362a = this.f4731a.get(cls);
            if (c7362a == null) {
                return null;
            }
            return (List<InterfaceC1695n<Model, ?>>) c7362a.f4732a;
        }
    }

    public C1697p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new C1699r(pool));
    }

    /* renamed from: a */
    public synchronized <Model, Data> void m4264a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        this.f4729a.m4278a(cls, cls2, interfaceC1696o);
        this.f4730b.m4269a();
    }

    /* renamed from: b */
    public synchronized <Model, Data> void m4266b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        this.f4729a.m4281b(cls, cls2, interfaceC1696o);
        this.f4730b.m4269a();
    }

    /* renamed from: c */
    public synchronized <Model, Data> void m4267c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        m4258a((List) this.f4729a.m4282c(cls, cls2, interfaceC1696o));
        this.f4730b.m4269a();
    }

    private C1697p(@NonNull C1699r c1699r) {
        this.f4730b = new a();
        this.f4729a = c1699r;
    }

    /* renamed from: a */
    private <Model, Data> void m4258a(@NonNull List<InterfaceC1696o<? extends Model, ? extends Data>> list) {
        Iterator<InterfaceC1696o<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo4221a();
        }
    }

    /* renamed from: b */
    public synchronized <Model, Data> void m4265b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        m4258a((List) this.f4729a.m4280b(cls, cls2));
        this.f4730b.m4269a();
    }

    @NonNull
    /* renamed from: a */
    public <A> List<InterfaceC1695n<A, ?>> m4263a(@NonNull A a2) {
        List<InterfaceC1695n<A, ?>> m4260b = m4260b((Class) m4259b(a2));
        if (!m4260b.isEmpty()) {
            int size = m4260b.size();
            List<InterfaceC1695n<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC1695n<A, ?> interfaceC1695n = m4260b.get(i2);
                if (interfaceC1695n.mo4218a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(interfaceC1695n);
                }
            }
            if (emptyList.isEmpty()) {
                throw new C1583i.c(a2, m4260b);
            }
            return emptyList;
        }
        throw new C1583i.c(a2);
    }

    @NonNull
    /* renamed from: b */
    private synchronized <A> List<InterfaceC1695n<A, ?>> m4260b(@NonNull Class<A> cls) {
        List<InterfaceC1695n<A, ?>> m4268a;
        m4268a = this.f4730b.m4268a(cls);
        if (m4268a == null) {
            m4268a = Collections.unmodifiableList(this.f4729a.m4277a(cls));
            this.f4730b.m4270a(cls, m4268a);
        }
        return m4268a;
    }

    @NonNull
    /* renamed from: b */
    private static <A> Class<A> m4259b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    /* renamed from: a */
    public synchronized <Model, Data> InterfaceC1695n<Model, Data> m4261a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f4729a.m4276a(cls, cls2);
    }

    @NonNull
    /* renamed from: a */
    public synchronized List<Class<?>> m4262a(@NonNull Class<?> cls) {
        return this.f4729a.m4279b(cls);
    }
}
