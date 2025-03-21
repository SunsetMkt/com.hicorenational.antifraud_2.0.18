package com.bumptech.glide.load.p118p;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.C1876j;
import com.bumptech.glide.util.p141n.AbstractC1882c;
import com.bumptech.glide.util.p141n.C1880a;

/* compiled from: LockedResource.java */
/* renamed from: com.bumptech.glide.load.p.u */
/* loaded from: classes.dex */
final class C1676u<Z> implements InterfaceC1677v<Z>, C1880a.f {

    /* renamed from: e */
    private static final Pools.Pool<C1676u<?>> f4629e = C1880a.m5020b(20, new a());

    /* renamed from: a */
    private final AbstractC1882c f4630a = AbstractC1882c.m5029b();

    /* renamed from: b */
    private InterfaceC1677v<Z> f4631b;

    /* renamed from: c */
    private boolean f4632c;

    /* renamed from: d */
    private boolean f4633d;

    /* compiled from: LockedResource.java */
    /* renamed from: com.bumptech.glide.load.p.u$a */
    class a implements C1880a.d<C1676u<?>> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.p141n.C1880a.d
        public C1676u<?> create() {
            return new C1676u<>();
        }
    }

    C1676u() {
    }

    /* renamed from: a */
    private void m4204a(InterfaceC1677v<Z> interfaceC1677v) {
        this.f4633d = false;
        this.f4632c = true;
        this.f4631b = interfaceC1677v;
    }

    @NonNull
    /* renamed from: b */
    static <Z> C1676u<Z> m4205b(InterfaceC1677v<Z> interfaceC1677v) {
        C1676u<Z> c1676u = (C1676u) C1876j.m4985a(f4629e.acquire());
        c1676u.m4204a(interfaceC1677v);
        return c1676u;
    }

    /* renamed from: e */
    private void m4206e() {
        this.f4631b = null;
        f4629e.release(this);
    }

    @Override // com.bumptech.glide.util.p141n.C1880a.f
    @NonNull
    /* renamed from: c */
    public AbstractC1882c mo4024c() {
        return this.f4630a;
    }

    /* renamed from: d */
    synchronized void m4207d() {
        this.f4630a.mo5030a();
        if (!this.f4632c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f4632c = false;
        if (this.f4633d) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    public Z get() {
        return this.f4631b.get();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    public synchronized void recycle() {
        this.f4630a.mo5030a();
        this.f4633d = true;
        if (!this.f4632c) {
            this.f4631b.recycle();
            m4206e();
        }
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    @NonNull
    /* renamed from: b */
    public Class<Z> mo4184b() {
        return this.f4631b.mo4184b();
    }

    @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
    /* renamed from: a */
    public int mo4183a() {
        return this.f4631b.mo4183a();
    }
}
