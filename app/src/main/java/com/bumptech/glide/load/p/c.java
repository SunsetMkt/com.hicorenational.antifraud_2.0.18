package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.o.d;
import com.bumptech.glide.load.p.f;
import com.bumptech.glide.load.q.n;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: DataCacheGenerator.java */
/* JADX INFO: loaded from: classes.dex */
class c implements f, d.a<Object> {
    private final List<com.bumptech.glide.load.g> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<?> f2860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f.a f2861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.g f2863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.q.n<File, ?>> f2864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile n.a<?> f2866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private File f2867i;

    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean b() {
        return this.f2865g < this.f2864f.size();
    }

    @Override // com.bumptech.glide.load.p.f
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f2864f != null && b()) {
                this.f2866h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.q.n<File, ?>> list = this.f2864f;
                    int i2 = this.f2865g;
                    this.f2865g = i2 + 1;
                    this.f2866h = list.get(i2).a(this.f2867i, this.f2860b.n(), this.f2860b.f(), this.f2860b.i());
                    if (this.f2866h != null && this.f2860b.c(this.f2866h.f3091c.a())) {
                        this.f2866h.f3091c.a(this.f2860b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f2862d++;
            if (this.f2862d >= this.a.size()) {
                return false;
            }
            com.bumptech.glide.load.g gVar = this.a.get(this.f2862d);
            this.f2867i = this.f2860b.d().a(new d(gVar, this.f2860b.l()));
            File file = this.f2867i;
            if (file != null) {
                this.f2863e = gVar;
                this.f2864f = this.f2860b.a(file);
                this.f2865g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.p.f
    public void cancel() {
        n.a<?> aVar = this.f2866h;
        if (aVar != null) {
            aVar.f3091c.cancel();
        }
    }

    c(List<com.bumptech.glide.load.g> list, g<?> gVar, f.a aVar) {
        this.f2862d = -1;
        this.a = list;
        this.f2860b = gVar;
        this.f2861c = aVar;
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(Object obj) {
        this.f2861c.a(this.f2863e, obj, this.f2866h.f3091c, com.bumptech.glide.load.a.DATA_DISK_CACHE, this.f2863e);
    }

    @Override // com.bumptech.glide.load.o.d.a
    public void a(@NonNull Exception exc) {
        this.f2861c.a(this.f2863e, exc, this.f2866h.f3091c, com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }
}
