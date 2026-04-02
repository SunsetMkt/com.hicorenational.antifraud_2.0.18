package com.bumptech.glide.load.p;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.b0.a;
import com.bumptech.glide.load.p.b0.j;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.p.p;
import com.bumptech.glide.util.n.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Engine.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements m, j.a, p.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f2966j = 150;
    private final s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f2968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.b0.j f2969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f2970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f2971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f2972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f2973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a f2974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2965i = "Engine";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f2967k = Log.isLoggable(f2965i, 2);

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class a {
        final h.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Pools.Pool<h<?>> f2975b = com.bumptech.glide.util.n.a.b(150, new C0053a());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2976c;

        /* JADX INFO: renamed from: com.bumptech.glide.load.p.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Engine.java */
        class C0053a implements a.d<h<?>> {
            C0053a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.n.a.d
            public h<?> create() {
                a aVar = a.this;
                return new h<>(aVar.a, aVar.f2975b);
            }
        }

        a(h.e eVar) {
            this.a = eVar;
        }

        <R> h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.j jVar2, h.b<R> bVar) {
            h hVar2 = (h) com.bumptech.glide.util.j.a(this.f2975b.acquire());
            int i4 = this.f2976c;
            this.f2976c = i4 + 1;
            return hVar2.a(dVar, obj, nVar, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, z3, jVar2, bVar, i4);
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    private static class c implements h.e {
        private final a.InterfaceC0046a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.p.b0.a f2983b;

        c(a.InterfaceC0046a interfaceC0046a) {
            this.a = interfaceC0046a;
        }

        @Override // com.bumptech.glide.load.p.h.e
        public com.bumptech.glide.load.p.b0.a a() {
            if (this.f2983b == null) {
                synchronized (this) {
                    if (this.f2983b == null) {
                        this.f2983b = this.a.build();
                    }
                    if (this.f2983b == null) {
                        this.f2983b = new com.bumptech.glide.load.p.b0.b();
                    }
                }
            }
            return this.f2983b;
        }

        @VisibleForTesting
        synchronized void b() {
            if (this.f2983b == null) {
                return;
            }
            this.f2983b.clear();
        }
    }

    /* JADX INFO: compiled from: Engine.java */
    public class d {
        private final l<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.r.i f2984b;

        d(com.bumptech.glide.r.i iVar, l<?> lVar) {
            this.f2984b = iVar;
            this.a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.a.c(this.f2984b);
            }
        }
    }

    public k(com.bumptech.glide.load.p.b0.j jVar, a.InterfaceC0046a interfaceC0046a, com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, boolean z) {
        this(jVar, interfaceC0046a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    @Nullable
    private p<?> b(com.bumptech.glide.load.g gVar) {
        p<?> pVarB = this.f2974h.b(gVar);
        if (pVarB != null) {
            pVarB.c();
        }
        return pVarB;
    }

    private p<?> c(com.bumptech.glide.load.g gVar) {
        p<?> pVarA = a(gVar);
        if (pVarA != null) {
            pVarA.c();
            this.f2974h.a(gVar, pVarA);
        }
        return pVarA;
    }

    public <R> d a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, com.bumptech.glide.load.j jVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.i iVar, Executor executor) {
        long jA = f2967k ? com.bumptech.glide.util.f.a() : 0L;
        n nVarA = this.f2968b.a(obj, gVar, i2, i3, map, cls, cls2, jVar2);
        synchronized (this) {
            p<?> pVarA = a(nVarA, z3, jA);
            if (pVarA == null) {
                return a(dVar, obj, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, jVar2, z3, z4, z5, z6, iVar, executor, nVarA, jA);
            }
            iVar.a(pVarA, com.bumptech.glide.load.a.MEMORY_CACHE);
            return null;
        }
    }

    @VisibleForTesting
    k(com.bumptech.glide.load.p.b0.j jVar, a.InterfaceC0046a interfaceC0046a, com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, s sVar, o oVar, com.bumptech.glide.load.p.a aVar5, b bVar, a aVar6, y yVar, boolean z) {
        this.f2969c = jVar;
        this.f2972f = new c(interfaceC0046a);
        com.bumptech.glide.load.p.a aVar7 = aVar5 == null ? new com.bumptech.glide.load.p.a(z) : aVar5;
        this.f2974h = aVar7;
        aVar7.a(this);
        this.f2968b = oVar == null ? new o() : oVar;
        this.a = sVar == null ? new s() : sVar;
        this.f2970d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.f2973g = aVar6 == null ? new a(this.f2972f) : aVar6;
        this.f2971e = yVar == null ? new y() : yVar;
        jVar.a(this);
    }

    public void b(v<?> vVar) {
        if (vVar instanceof p) {
            ((p) vVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    /* JADX INFO: compiled from: Engine.java */
    @VisibleForTesting
    static class b {
        final com.bumptech.glide.load.p.c0.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f2977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f2978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.bumptech.glide.load.p.c0.a f2979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final m f2980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final p.a f2981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Pools.Pool<l<?>> f2982g = com.bumptech.glide.util.n.a.b(150, new a());

        /* JADX INFO: compiled from: Engine.java */
        class a implements a.d<l<?>> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.n.a.d
            public l<?> create() {
                b bVar = b.this;
                return new l<>(bVar.a, bVar.f2977b, bVar.f2978c, bVar.f2979d, bVar.f2980e, bVar.f2981f, bVar.f2982g);
            }
        }

        b(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5) {
            this.a = aVar;
            this.f2977b = aVar2;
            this.f2978c = aVar3;
            this.f2979d = aVar4;
            this.f2980e = mVar;
            this.f2981f = aVar5;
        }

        @VisibleForTesting
        void a() {
            com.bumptech.glide.util.d.a(this.a);
            com.bumptech.glide.util.d.a(this.f2977b);
            com.bumptech.glide.util.d.a(this.f2978c);
            com.bumptech.glide.util.d.a(this.f2979d);
        }

        <R> l<R> a(com.bumptech.glide.load.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((l) com.bumptech.glide.util.j.a(this.f2982g.acquire())).a(gVar, z, z2, z3, z4);
        }
    }

    @VisibleForTesting
    public void b() {
        this.f2970d.a();
        this.f2972f.b();
        this.f2974h.b();
    }

    private <R> d a(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, com.bumptech.glide.load.n<?>> map, boolean z, boolean z2, com.bumptech.glide.load.j jVar2, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.r.i iVar, Executor executor, n nVar, long j2) {
        l<?> lVarA = this.a.a(nVar, z6);
        if (lVarA != null) {
            lVarA.a(iVar, executor);
            if (f2967k) {
                a("Added to existing load", j2, nVar);
            }
            return new d(iVar, lVarA);
        }
        l<R> lVarA2 = this.f2970d.a(nVar, z3, z4, z5, z6);
        h<R> hVarA = this.f2973g.a(dVar, obj, nVar, gVar, i2, i3, cls, cls2, hVar, jVar, map, z, z2, z6, jVar2, lVarA2);
        this.a.a((com.bumptech.glide.load.g) nVar, (l<?>) lVarA2);
        lVarA2.a(iVar, executor);
        lVarA2.b(hVarA);
        if (f2967k) {
            a("Started new load", j2, nVar);
        }
        return new d(iVar, lVarA2);
    }

    @Nullable
    private p<?> a(n nVar, boolean z, long j2) {
        if (!z) {
            return null;
        }
        p<?> pVarB = b(nVar);
        if (pVarB != null) {
            if (f2967k) {
                a("Loaded resource from active resources", j2, nVar);
            }
            return pVarB;
        }
        p<?> pVarC = c(nVar);
        if (pVarC == null) {
            return null;
        }
        if (f2967k) {
            a("Loaded resource from cache", j2, nVar);
        }
        return pVarC;
    }

    private static void a(String str, long j2, com.bumptech.glide.load.g gVar) {
        String str2 = str + " in " + com.bumptech.glide.util.f.a(j2) + "ms, key: " + gVar;
    }

    private p<?> a(com.bumptech.glide.load.g gVar) {
        v<?> vVarA = this.f2969c.a(gVar);
        if (vVarA == null) {
            return null;
        }
        if (vVarA instanceof p) {
            return (p) vVarA;
        }
        return new p<>(vVarA, true, true, gVar, this);
    }

    @Override // com.bumptech.glide.load.p.m
    public synchronized void a(l<?> lVar, com.bumptech.glide.load.g gVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.e()) {
                this.f2974h.a(gVar, pVar);
            }
            this.a.b(gVar, lVar);
        } else {
            this.a.b(gVar, lVar);
        }
    }

    @Override // com.bumptech.glide.load.p.m
    public synchronized void a(l<?> lVar, com.bumptech.glide.load.g gVar) {
        this.a.b(gVar, lVar);
    }

    @Override // com.bumptech.glide.load.p.b0.j.a
    public void a(@NonNull v<?> vVar) {
        this.f2971e.a(vVar, true);
    }

    @Override // com.bumptech.glide.load.p.p.a
    public void a(com.bumptech.glide.load.g gVar, p<?> pVar) {
        this.f2974h.a(gVar);
        if (pVar.e()) {
            this.f2969c.a(gVar, pVar);
        } else {
            this.f2971e.a(pVar, false);
        }
    }

    public void a() {
        this.f2972f.a().clear();
    }
}
