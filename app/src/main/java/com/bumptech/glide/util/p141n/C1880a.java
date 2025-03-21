package com.bumptech.glide.util.p141n;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* renamed from: com.bumptech.glide.util.n.a */
/* loaded from: classes.dex */
public final class C1880a {

    /* renamed from: a */
    private static final String f5503a = "FactoryPools";

    /* renamed from: b */
    private static final int f5504b = 20;

    /* renamed from: c */
    private static final g<Object> f5505c = new a();

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$a */
    class a implements g<Object> {
        a() {
        }

        @Override // com.bumptech.glide.util.p141n.C1880a.g
        /* renamed from: a */
        public void mo5021a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$b */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.p141n.C1880a.d
        @NonNull
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$c */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.p141n.C1880a.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo5021a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$d */
    public interface d<T> {
        T create();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$e */
    private static final class e<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final d<T> f5506a;

        /* renamed from: b */
        private final g<T> f5507b;

        /* renamed from: c */
        private final Pools.Pool<T> f5508c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f5508c = pool;
            this.f5506a = dVar;
            this.f5507b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f5508c.acquire();
            if (acquire == null) {
                acquire = this.f5506a.create();
                if (Log.isLoggable(C1880a.f5503a, 2)) {
                    String str = "Created new " + acquire.getClass();
                }
            }
            if (acquire instanceof f) {
                acquire.mo4024c().mo5031a(false);
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).mo4024c().mo5031a(true);
            }
            this.f5507b.mo5021a(t);
            return this.f5508c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$f */
    public interface f {
        @NonNull
        /* renamed from: c */
        AbstractC1882c mo4024c();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.n.a$g */
    public interface g<T> {
        /* renamed from: a */
        void mo5021a(@NonNull T t);
    }

    private C1880a() {
    }

    @NonNull
    /* renamed from: a */
    public static <T extends f> Pools.Pool<T> m5015a(int i2, @NonNull d<T> dVar) {
        return m5016a(new Pools.SimplePool(i2), dVar);
    }

    @NonNull
    /* renamed from: b */
    public static <T extends f> Pools.Pool<T> m5020b(int i2, @NonNull d<T> dVar) {
        return m5016a(new Pools.SynchronizedPool(i2), dVar);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Pools.Pool<List<T>> m5014a(int i2) {
        return m5017a(new Pools.SynchronizedPool(i2), new b(), new c());
    }

    @NonNull
    /* renamed from: b */
    public static <T> Pools.Pool<List<T>> m5019b() {
        return m5014a(20);
    }

    @NonNull
    /* renamed from: a */
    private static <T extends f> Pools.Pool<T> m5016a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return m5017a(pool, dVar, m5018a());
    }

    @NonNull
    /* renamed from: a */
    private static <T> Pools.Pool<T> m5017a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    /* renamed from: a */
    private static <T> g<T> m5018a() {
        return (g<T>) f5505c;
    }
}
