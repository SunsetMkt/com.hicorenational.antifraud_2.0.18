package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.i;
import com.bumptech.glide.load.q.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f3100e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f3101f = new a();
    private final List<b<?, ?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f3102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f3103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f3104d;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.q.n
        @Nullable
        public n.a<Object> a(@NonNull Object obj, int i2, int i3, @NonNull com.bumptech.glide.load.j jVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.q.n
        public boolean a(@NonNull Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {
        private final Class<Model> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<Data> f3105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f3106c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.a = cls;
            this.f3105b = cls2;
            this.f3106c = oVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f3105b.isAssignableFrom(cls2);
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f3100e);
    }

    synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> listB;
        listB = b(cls, cls2);
        a(cls, cls2, oVar);
        return listB;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.a = new ArrayList();
        this.f3103c = new HashSet();
        this.f3104d = pool;
        this.f3102b = cVar;
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    synchronized <Model, Data> List<o<? extends Model, ? extends Data>> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.a(cls, cls2)) {
                it.remove();
                arrayList.add(b(next));
            }
        }
        return arrayList;
    }

    @NonNull
    synchronized <Model> List<n<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.f3103c.contains(bVar) && bVar.a(cls)) {
                    this.f3103c.add(bVar);
                    arrayList.add(a(bVar));
                    this.f3103c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f3103c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.f3105b) && bVar.a(cls)) {
                arrayList.add(bVar.f3105b);
            }
        }
        return arrayList;
    }

    @NonNull
    private <Model, Data> o<Model, Data> b(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f3106c;
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.f3103c.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f3103c.add(bVar);
                    arrayList.add(a(bVar));
                    this.f3103c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f3102b.a(arrayList, this.f3104d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z) {
                return a();
            }
            throw new i.c((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f3103c.clear();
            throw th;
        }
    }

    @NonNull
    private <Model, Data> n<Model, Data> a(@NonNull b<?, ?> bVar) {
        return (n) com.bumptech.glide.util.j.a(bVar.f3106c.a(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> a() {
        return (n<Model, Data>) f3101f;
    }
}
