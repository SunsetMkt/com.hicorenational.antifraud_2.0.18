package com.bumptech.glide.util.n;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "FactoryPools";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3575b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g<Object> f3576c = new C0067a();

    /* JADX INFO: renamed from: com.bumptech.glide.util.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    class C0067a implements g<Object> {
        C0067a() {
        }

        @Override // com.bumptech.glide.util.n.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.n.a.d
        @NonNull
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.n.a.g
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d<T> {
        T create();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class e<T> implements Pools.Pool<T> {
        private final d<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g<T> f3577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f3578c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f3578c = pool;
            this.a = dVar;
            this.f3577b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f3578c.acquire();
            if (tAcquire == null) {
                tAcquire = this.a.create();
                if (Log.isLoggable(a.a, 2)) {
                    String str = "Created new " + tAcquire.getClass();
                }
            }
            if (tAcquire instanceof f) {
                ((f) tAcquire).c().a(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).c().a(true);
            }
            this.f3577b.a(t);
            return this.f3578c.release(t);
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface f {
        @NonNull
        com.bumptech.glide.util.n.c c();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface g<T> {
        void a(@NonNull T t);
    }

    private a() {
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i2), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> b(int i2, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i2), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i2) {
        return a(new Pools.SynchronizedPool(i2), new b(), new c());
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> b() {
        return a(20);
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return a(pool, dVar, a());
    }

    @NonNull
    private static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> a() {
        return (g<T>) f3576c;
    }
}
