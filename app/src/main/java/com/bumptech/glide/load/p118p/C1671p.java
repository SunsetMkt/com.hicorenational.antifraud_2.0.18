package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.util.C1876j;

/* compiled from: EngineResource.java */
/* renamed from: com.bumptech.glide.load.p.p */
/* loaded from: classes.dex */
class C1671p<Z> implements InterfaceC1677v<Z> {

    /* renamed from: a */
    private final boolean f4611a;

    /* renamed from: b */
    private final boolean f4612b;

    /* renamed from: c */
    private final InterfaceC1677v<Z> f4613c;

    /* renamed from: d */
    private final a f4614d;

    /* renamed from: e */
    private final InterfaceC1593g f4615e;

    /* renamed from: f */
    private int f4616f;

    /* renamed from: g */
    private boolean f4617g;

    /* compiled from: EngineResource.java */
    /* renamed from: com.bumptech.glide.load.p.p$a */
    interface a {
        /* renamed from: a */
        void mo4150a(InterfaceC1593g interfaceC1593g, C1671p<?> c1671p);
    }

    C1671p(InterfaceC1677v<Z> interfaceC1677v, boolean z, boolean z2, InterfaceC1593g interfaceC1593g, a aVar) {
        this.f4613c = (InterfaceC1677v) C1876j.m4985a(interfaceC1677v);
        this.f4611a = z;
        this.f4612b = z2;
        this.f4615e = interfaceC1593g;
        this.f4614d = (a) C1876j.m4985a(aVar);
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return this.f4613c.mo4183a();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<Z> mo4184b() {
        return this.f4613c.mo4184b();
    }

    /* renamed from: c */
    synchronized void m4185c() {
        if (this.f4617g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f4616f++;
    }

    /* renamed from: d */
    InterfaceC1677v<Z> m4186d() {
        return this.f4613c;
    }

    /* renamed from: e */
    boolean m4187e() {
        return this.f4611a;
    }

    /* renamed from: f */
    void m4188f() {
        boolean z;
        synchronized (this) {
            if (this.f4616f <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = this.f4616f - 1;
            this.f4616f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f4614d.mo4150a(this.f4615e, this);
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public Z get() {
        return this.f4613c.get();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public synchronized void recycle() {
        if (this.f4616f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f4617g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f4617g = true;
        if (this.f4612b) {
            this.f4613c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f4611a + ", listener=" + this.f4614d + ", key=" + this.f4615e + ", acquired=" + this.f4616f + ", isRecycled=" + this.f4617g + ", resource=" + this.f4613c + '}';
    }
}
