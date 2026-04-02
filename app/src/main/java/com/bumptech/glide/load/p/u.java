package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.n.a;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes.dex */
final class u<Z> implements v<Z>, a.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pools.Pool<u<?>> f3024e = com.bumptech.glide.util.n.a.b(20, new a());
    private final com.bumptech.glide.util.n.c a = com.bumptech.glide.util.n.c.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v<Z> f3025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3027d;

    /* JADX INFO: compiled from: LockedResource.java */
    class a implements a.d<u<?>> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.n.a.d
        public u<?> create() {
            return new u<>();
        }
    }

    u() {
    }

    private void a(v<Z> vVar) {
        this.f3027d = false;
        this.f3026c = true;
        this.f3025b = vVar;
    }

    @NonNull
    static <Z> u<Z> b(v<Z> vVar) {
        u<Z> uVar = (u) com.bumptech.glide.util.j.a(f3024e.acquire());
        uVar.a(vVar);
        return uVar;
    }

    private void e() {
        this.f3025b = null;
        f3024e.release(this);
    }

    @Override // com.bumptech.glide.util.n.a.f
    @NonNull
    public com.bumptech.glide.util.n.c c() {
        return this.a;
    }

    synchronized void d() {
        this.a.a();
        if (!this.f3026c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f3026c = false;
        if (this.f3027d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Z get() {
        return this.f3025b.get();
    }

    @Override // com.bumptech.glide.load.p.v
    public synchronized void recycle() {
        this.a.a();
        this.f3027d = true;
        if (!this.f3026c) {
            this.f3025b.recycle();
            e();
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Z> b() {
        return this.f3025b.b();
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f3025b.a();
    }
}
