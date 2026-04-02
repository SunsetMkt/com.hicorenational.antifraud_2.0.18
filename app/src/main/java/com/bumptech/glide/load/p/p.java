package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes.dex */
class p<Z> implements v<Z> {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v<Z> f3012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f3013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.g f3014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f3015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3016g;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void a(com.bumptech.glide.load.g gVar, p<?> pVar);
    }

    p(v<Z> vVar, boolean z, boolean z2, com.bumptech.glide.load.g gVar, a aVar) {
        this.f3012c = (v) com.bumptech.glide.util.j.a(vVar);
        this.a = z;
        this.f3011b = z2;
        this.f3014e = gVar;
        this.f3013d = (a) com.bumptech.glide.util.j.a(aVar);
    }

    @Override // com.bumptech.glide.load.p.v
    public int a() {
        return this.f3012c.a();
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Class<Z> b() {
        return this.f3012c.b();
    }

    synchronized void c() {
        if (this.f3016g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f3015f++;
    }

    v<Z> d() {
        return this.f3012c;
    }

    boolean e() {
        return this.a;
    }

    void f() {
        boolean z;
        synchronized (this) {
            if (this.f3015f <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = this.f3015f - 1;
            this.f3015f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f3013d.a(this.f3014e, this);
        }
    }

    @Override // com.bumptech.glide.load.p.v
    @NonNull
    public Z get() {
        return this.f3012c.get();
    }

    @Override // com.bumptech.glide.load.p.v
    public synchronized void recycle() {
        if (this.f3015f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f3016g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f3016g = true;
        if (this.f3011b) {
            this.f3012c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.f3013d + ", key=" + this.f3014e + ", acquired=" + this.f3015f + ", isRecycled=" + this.f3016g + ", resource=" + this.f3012c + '}';
    }
}
