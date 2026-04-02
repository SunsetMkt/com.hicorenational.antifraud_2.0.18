package com.bumptech.glide.load.p;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.p.h;
import com.bumptech.glide.load.p.p;
import com.bumptech.glide.util.n.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: EngineJob.java */
/* JADX INFO: loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {
    private static final c y = new c();
    final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.n.c f2986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p.a f2987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<l<?>> f2988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c f2989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f2990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f2991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f2992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f2993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.p.c0.a f2994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f2995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bumptech.glide.load.g f2996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2998n;
    private boolean o;
    private boolean p;
    private v<?> q;
    com.bumptech.glide.load.a r;
    private boolean s;
    q t;
    private boolean u;
    p<?> v;
    private h<R> w;
    private volatile boolean x;

    /* JADX INFO: compiled from: EngineJob.java */
    private class a implements Runnable {
        private final com.bumptech.glide.r.i a;

        a(com.bumptech.glide.r.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.e()) {
                synchronized (l.this) {
                    if (l.this.a.a(this.a)) {
                        l.this.a(this.a);
                    }
                    l.this.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    private class b implements Runnable {
        private final com.bumptech.glide.r.i a;

        b(com.bumptech.glide.r.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.e()) {
                synchronized (l.this) {
                    if (l.this.a.a(this.a)) {
                        l.this.v.c();
                        l.this.b(this.a);
                        l.this.c(this.a);
                    }
                    l.this.b();
                }
            }
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    @VisibleForTesting
    static class c {
        c() {
        }

        public <R> p<R> a(v<R> vVar, boolean z, com.bumptech.glide.load.g gVar, p.a aVar) {
            return new p<>(vVar, z, true, gVar, aVar);
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class d {
        final com.bumptech.glide.r.i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f3001b;

        d(com.bumptech.glide.r.i iVar, Executor executor) {
            this.a = iVar;
            this.f3001b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: EngineJob.java */
    static final class e implements Iterable<d> {
        private final List<d> a;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.r.i iVar) {
            return new d(iVar, com.bumptech.glide.util.d.a());
        }

        void a(com.bumptech.glide.r.i iVar, Executor executor) {
            this.a.add(new d(iVar, executor));
        }

        void b(com.bumptech.glide.r.i iVar) {
            this.a.remove(c(iVar));
        }

        void clear() {
            this.a.clear();
        }

        boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.a.iterator();
        }

        int size() {
            return this.a.size();
        }

        e(List<d> list) {
            this.a = list;
        }

        boolean a(com.bumptech.glide.r.i iVar) {
            return this.a.contains(c(iVar));
        }

        e a() {
            return new e(new ArrayList(this.a));
        }
    }

    l(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, y);
    }

    private com.bumptech.glide.load.p.c0.a h() {
        return this.f2998n ? this.f2993i : this.o ? this.f2994j : this.f2992h;
    }

    private boolean i() {
        return this.u || this.s || this.x;
    }

    private synchronized void j() {
        if (this.f2996l == null) {
            throw new IllegalArgumentException();
        }
        this.a.clear();
        this.f2996l = null;
        this.v = null;
        this.q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.w.a(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.f2988d.release(this);
    }

    @VisibleForTesting
    synchronized l<R> a(com.bumptech.glide.load.g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f2996l = gVar;
        this.f2997m = z;
        this.f2998n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public synchronized void b(h<R> hVar) {
        this.w = hVar;
        (hVar.d() ? this.f2991g : h()).execute(hVar);
    }

    synchronized void c(com.bumptech.glide.r.i iVar) {
        this.f2986b.a();
        this.a.b(iVar);
        if (this.a.isEmpty()) {
            a();
            if ((this.s || this.u) && this.f2995k.get() == 0) {
                j();
            }
        }
    }

    synchronized boolean d() {
        return this.x;
    }

    void e() {
        synchronized (this) {
            this.f2986b.a();
            if (this.x) {
                j();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.u) {
                throw new IllegalStateException("Already failed once");
            }
            this.u = true;
            com.bumptech.glide.load.g gVar = this.f2996l;
            e eVarA = this.a.a();
            a(eVarA.size() + 1);
            this.f2990f.a(this, gVar, null);
            for (d dVar : eVarA) {
                dVar.f3001b.execute(new a(dVar.a));
            }
            b();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void f() {
        synchronized (this) {
            this.f2986b.a();
            if (this.x) {
                this.q.recycle();
                j();
                return;
            }
            if (this.a.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.s) {
                throw new IllegalStateException("Already have resource");
            }
            this.v = this.f2989e.a(this.q, this.f2997m, this.f2996l, this.f2987c);
            this.s = true;
            e eVarA = this.a.a();
            a(eVarA.size() + 1);
            this.f2990f.a(this, this.f2996l, this.v);
            for (d dVar : eVarA) {
                dVar.f3001b.execute(new b(dVar.a));
            }
            b();
        }
    }

    boolean g() {
        return this.p;
    }

    @VisibleForTesting
    l(com.bumptech.glide.load.p.c0.a aVar, com.bumptech.glide.load.p.c0.a aVar2, com.bumptech.glide.load.p.c0.a aVar3, com.bumptech.glide.load.p.c0.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.a = new e();
        this.f2986b = com.bumptech.glide.util.n.c.b();
        this.f2995k = new AtomicInteger();
        this.f2991g = aVar;
        this.f2992h = aVar2;
        this.f2993i = aVar3;
        this.f2994j = aVar4;
        this.f2990f = mVar;
        this.f2987c = aVar5;
        this.f2988d = pool;
        this.f2989e = cVar;
    }

    @GuardedBy("this")
    void b(com.bumptech.glide.r.i iVar) {
        try {
            iVar.a(this.v, this.r);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.p.b(th);
        }
    }

    synchronized void a(com.bumptech.glide.r.i iVar, Executor executor) {
        this.f2986b.a();
        this.a.a(iVar, executor);
        boolean z = true;
        if (this.s) {
            a(1);
            executor.execute(new b(iVar));
        } else if (this.u) {
            a(1);
            executor.execute(new a(iVar));
        } else {
            if (this.x) {
                z = false;
            }
            com.bumptech.glide.util.j.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    void b() {
        p<?> pVar;
        synchronized (this) {
            this.f2986b.a();
            com.bumptech.glide.util.j.a(i(), "Not yet complete!");
            int iDecrementAndGet = this.f2995k.decrementAndGet();
            com.bumptech.glide.util.j.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                pVar = this.v;
                j();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.f();
        }
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.f2986b;
    }

    @GuardedBy("this")
    void a(com.bumptech.glide.r.i iVar) {
        try {
            iVar.a(this.t);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.p.b(th);
        }
    }

    void a() {
        if (i()) {
            return;
        }
        this.x = true;
        this.w.a();
        this.f2990f.a(this, this.f2996l);
    }

    synchronized void a(int i2) {
        com.bumptech.glide.util.j.a(i(), "Not yet complete!");
        if (this.f2995k.getAndAdd(i2) == 0 && this.v != null) {
            this.v.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.p.h.b
    public void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.q = vVar;
            this.r = aVar;
        }
        f();
    }

    @Override // com.bumptech.glide.load.p.h.b
    public void a(q qVar) {
        synchronized (this) {
            this.t = qVar;
        }
        e();
    }

    @Override // com.bumptech.glide.load.p.h.b
    public void a(h<?> hVar) {
        h().execute(hVar);
    }
}
