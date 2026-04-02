package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class w implements f, d.a<Object> {
    private final f.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f3028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3030d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f3031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.q.n<File, ?>> f3032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f3034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f3035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private x f3036j;

    w(g<?> gVar, f.a aVar) {
        this.f3028b = gVar;
        this.a = aVar;
    }

    private boolean b() {
        return this.f3033g < this.f3032f.size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        List<com.bumptech.glide.load.g> listC = this.f3028b.c();
        boolean z = false;
        if (listC.isEmpty()) {
            return false;
        }
        List<Class<?>> listK = this.f3028b.k();
        if (listK.isEmpty()) {
            if (File.class.equals(this.f3028b.m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f3028b.h() + " to " + this.f3028b.m());
        }
        while (true) {
            if (this.f3032f != null && b()) {
                this.f3034h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.q.n<File, ?>> list = this.f3032f;
                    int i2 = this.f3033g;
                    this.f3033g = i2 + 1;
                    this.f3034h = list.get(i2).a(this.f3035i, this.f3028b.n(), this.f3028b.f(), this.f3028b.i());
                    if (this.f3034h != null && this.f3028b.c(this.f3034h.f3091c.a())) {
                        this.f3034h.f3091c.a(this.f3028b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f3030d++;
            if (this.f3030d >= listK.size()) {
                this.f3029c++;
                if (this.f3029c >= listC.size()) {
                    return false;
                }
                this.f3030d = 0;
            }
            com.bumptech.glide.load.g gVar = listC.get(this.f3029c);
            Class<?> cls = listK.get(this.f3030d);
            this.f3036j = new x(this.f3028b.b(), gVar, this.f3028b.l(), this.f3028b.n(), this.f3028b.f(), this.f3028b.b(cls), cls, this.f3028b.i());
            this.f3035i = this.f3028b.d().a(this.f3036j);
            File file = this.f3035i;
            if (file != null) {
                this.f3031e = gVar;
                this.f3032f = this.f3028b.a(file);
                this.f3033g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f3034h;
        if (aVar != null) {
            aVar.f3091c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(Object obj) {
        this.a.a(this.f3031e, obj, this.f3034h.f3091c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.f3036j);
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(@NonNull Exception exc) {
        this.a.a(this.f3036j, exc, this.f3034h.f3091c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }
}
