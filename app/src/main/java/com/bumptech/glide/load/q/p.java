package com.bumptech.glide.load.q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelLoaderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    private final r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3092b;

    /* JADX INFO: compiled from: ModelLoaderRegistry.java */
    private static class a {
        private final Map<Class<?>, C0057a<?>> a = new HashMap();

        /* JADX INFO: renamed from: com.bumptech.glide.load.q.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelLoaderRegistry.java */
        private static class C0057a<Model> {
            final List<n<Model, ?>> a;

            public C0057a(List<n<Model, ?>> list) {
                this.a = list;
            }
        }

        a() {
        }

        public void a() {
            this.a.clear();
        }

        public <Model> void a(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.a.put(cls, new C0057a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        @Nullable
        public <Model> List<n<Model, ?>> a(Class<Model> cls) {
            C0057a<?> c0057a = this.a.get(cls);
            if (c0057a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0057a.a;
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.a(cls, cls2, oVar);
        this.f3092b.a();
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.a.b(cls, cls2, oVar);
        this.f3092b.a();
    }

    public synchronized <Model, Data> void c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a((List) this.a.c(cls, cls2, oVar));
        this.f3092b.a();
    }

    private p(@NonNull r rVar) {
        this.f3092b = new a();
        this.a = rVar;
    }

    private <Model, Data> void a(@NonNull List<o<? extends Model, ? extends Data>> list) {
        Iterator<o<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        a((List) this.a.b(cls, cls2));
        this.f3092b.a();
    }

    @NonNull
    public <A> List<n<A, ?>> a(@NonNull A a2) {
        List<n<A, ?>> listB = b((Class) b(a2));
        if (!listB.isEmpty()) {
            int size = listB.size();
            List<n<A, ?>> listEmptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                n<A, ?> nVar = listB.get(i2);
                if (nVar.a(a2)) {
                    if (z) {
                        listEmptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    listEmptyList.add(nVar);
                }
            }
            if (listEmptyList.isEmpty()) {
                throw new i.c(a2, listB);
            }
            return listEmptyList;
        }
        throw new i.c(a2);
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> b(@NonNull Class<A> cls) {
        List<n<A, ?>> listA;
        listA = this.f3092b.a(cls);
        if (listA == null) {
            listA = Collections.unmodifiableList(this.a.a(cls));
            this.f3092b.a(cls, listA);
        }
        return listA;
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    public synchronized <Model, Data> n<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.a.a(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.a.b(cls);
    }
}
