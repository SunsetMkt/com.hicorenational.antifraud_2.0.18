package com.bumptech.glide.load.p123q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.C1583i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import com.bumptech.glide.util.C1876j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* renamed from: com.bumptech.glide.load.q.r */
/* loaded from: classes.dex */
public class C1699r {

    /* renamed from: e */
    private static final c f4742e = new c();

    /* renamed from: f */
    private static final InterfaceC1695n<Object, Object> f4743f = new a();

    /* renamed from: a */
    private final List<b<?, ?>> f4744a;

    /* renamed from: b */
    private final c f4745b;

    /* renamed from: c */
    private final Set<b<?, ?>> f4746c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f4747d;

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.q.r$a */
    private static class a implements InterfaceC1695n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
        @Nullable
        /* renamed from: a */
        public InterfaceC1695n.a<Object> mo4217a(@NonNull Object obj, int i2, int i3, @NonNull C1596j c1596j) {
            return null;
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
        /* renamed from: a */
        public boolean mo4218a(@NonNull Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.q.r$b */
    private static class b<Model, Data> {

        /* renamed from: a */
        private final Class<Model> f4748a;

        /* renamed from: b */
        final Class<Data> f4749b;

        /* renamed from: c */
        final InterfaceC1696o<? extends Model, ? extends Data> f4750c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
            this.f4748a = cls;
            this.f4749b = cls2;
            this.f4750c = interfaceC1696o;
        }

        /* renamed from: a */
        public boolean m4284a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return m4283a(cls) && this.f4749b.isAssignableFrom(cls2);
        }

        /* renamed from: a */
        public boolean m4283a(@NonNull Class<?> cls) {
            return this.f4748a.isAssignableFrom(cls);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.q.r$c */
    static class c {
        c() {
        }

        @NonNull
        /* renamed from: a */
        public <Model, Data> C1698q<Model, Data> m4285a(@NonNull List<InterfaceC1695n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new C1698q<>(list, pool);
        }
    }

    public C1699r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f4742e);
    }

    /* renamed from: a */
    synchronized <Model, Data> void m4278a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        m4274a(cls, cls2, interfaceC1696o, true);
    }

    /* renamed from: b */
    synchronized <Model, Data> void m4281b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        m4274a(cls, cls2, interfaceC1696o, false);
    }

    @NonNull
    /* renamed from: c */
    synchronized <Model, Data> List<InterfaceC1696o<? extends Model, ? extends Data>> m4282c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o) {
        List<InterfaceC1696o<? extends Model, ? extends Data>> m4280b;
        m4280b = m4280b(cls, cls2);
        m4278a(cls, cls2, interfaceC1696o);
        return m4280b;
    }

    @VisibleForTesting
    C1699r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f4744a = new ArrayList();
        this.f4746c = new HashSet();
        this.f4747d = pool;
        this.f4745b = cVar;
    }

    /* renamed from: a */
    private <Model, Data> void m4274a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC1696o<? extends Model, ? extends Data> interfaceC1696o, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, interfaceC1696o);
        List<b<?, ?>> list = this.f4744a;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    /* renamed from: b */
    synchronized <Model, Data> List<InterfaceC1696o<? extends Model, ? extends Data>> m4280b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f4744a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.m4284a(cls, cls2)) {
                it.remove();
                arrayList.add(m4275b(next));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: a */
    synchronized <Model> List<InterfaceC1695n<Model, ?>> m4277a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f4744a) {
                if (!this.f4746c.contains(bVar) && bVar.m4283a(cls)) {
                    this.f4746c.add(bVar);
                    arrayList.add(m4273a(bVar));
                    this.f4746c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f4746c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: b */
    synchronized List<Class<?>> m4279b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f4744a) {
            if (!arrayList.contains(bVar.f4749b) && bVar.m4283a(cls)) {
                arrayList.add(bVar.f4749b);
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: b */
    private <Model, Data> InterfaceC1696o<Model, Data> m4275b(@NonNull b<?, ?> bVar) {
        return (InterfaceC1696o<Model, Data>) bVar.f4750c;
    }

    @NonNull
    /* renamed from: a */
    public synchronized <Model, Data> InterfaceC1695n<Model, Data> m4276a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f4744a) {
                if (this.f4746c.contains(bVar)) {
                    z = true;
                } else if (bVar.m4284a(cls, cls2)) {
                    this.f4746c.add(bVar);
                    arrayList.add(m4273a(bVar));
                    this.f4746c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4745b.m4285a(arrayList, this.f4747d);
            }
            if (arrayList.size() == 1) {
                return (InterfaceC1695n) arrayList.get(0);
            }
            if (z) {
                return m4272a();
            }
            throw new C1583i.c((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f4746c.clear();
            throw th;
        }
    }

    @NonNull
    /* renamed from: a */
    private <Model, Data> InterfaceC1695n<Model, Data> m4273a(@NonNull b<?, ?> bVar) {
        return (InterfaceC1695n) C1876j.m4985a(bVar.f4750c.mo4220a(this));
    }

    @NonNull
    /* renamed from: a */
    private static <Model, Data> InterfaceC1695n<Model, Data> m4272a() {
        return (InterfaceC1695n<Model, Data>) f4743f;
    }
}
