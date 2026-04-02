package com.bumptech.glide.r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.e;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements e, d {

    @Nullable
    private final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f3481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f3482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f3483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f3484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f3485g;

    public k(Object obj, @Nullable e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f3483e = aVar;
        this.f3484f = aVar;
        this.f3480b = obj;
        this.a = eVar;
    }

    @GuardedBy("requestLock")
    private boolean e() {
        e eVar = this.a;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.a;
        return eVar == null || eVar.d(this);
    }

    public void a(d dVar, d dVar2) {
        this.f3481c = dVar;
        this.f3482d = dVar2;
    }

    @Override // com.bumptech.glide.r.e
    public void b(d dVar) {
        synchronized (this.f3480b) {
            if (!dVar.equals(this.f3481c)) {
                this.f3484f = e.a.FAILED;
                return;
            }
            this.f3483e = e.a.FAILED;
            if (this.a != null) {
                this.a.b(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.f3480b) {
            z = f() && dVar.equals(this.f3481c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        synchronized (this.f3480b) {
            this.f3485g = false;
            this.f3483e = e.a.CLEARED;
            this.f3484f = e.a.CLEARED;
            this.f3482d.clear();
            this.f3481c.clear();
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean d(d dVar) {
        boolean z;
        synchronized (this.f3480b) {
            z = g() && (dVar.equals(this.f3481c) || this.f3483e != e.a.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.f3480b) {
            z = e() && dVar.equals(this.f3481c) && this.f3483e != e.a.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public e getRoot() {
        e root;
        synchronized (this.f3480b) {
            root = this.a != null ? this.a.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f3480b) {
            z = this.f3483e == e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.f3480b) {
            if (!this.f3484f.isComplete()) {
                this.f3484f = e.a.PAUSED;
                this.f3482d.pause();
            }
            if (!this.f3483e.isComplete()) {
                this.f3483e = e.a.PAUSED;
                this.f3481c.pause();
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void e(d dVar) {
        synchronized (this.f3480b) {
            if (dVar.equals(this.f3482d)) {
                this.f3484f = e.a.SUCCESS;
                return;
            }
            this.f3483e = e.a.SUCCESS;
            if (this.a != null) {
                this.a.e(this);
            }
            if (!this.f3484f.isComplete()) {
                this.f3482d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.e, com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.f3480b) {
            z = this.f3482d.a() || this.f3481c.a();
        }
        return z;
    }

    @GuardedBy("requestLock")
    private boolean f() {
        e eVar = this.a;
        return eVar == null || eVar.c(this);
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.f3480b) {
            this.f3485g = true;
            try {
                if (this.f3483e != e.a.SUCCESS && this.f3484f != e.a.RUNNING) {
                    this.f3484f = e.a.RUNNING;
                    this.f3482d.c();
                }
                if (this.f3485g && this.f3483e != e.a.RUNNING) {
                    this.f3483e = e.a.RUNNING;
                    this.f3481c.c();
                }
            } finally {
                this.f3485g = false;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.f3480b) {
            z = this.f3483e == e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        if (!(dVar instanceof k)) {
            return false;
        }
        k kVar = (k) dVar;
        if (this.f3481c == null) {
            if (kVar.f3481c != null) {
                return false;
            }
        } else if (!this.f3481c.a(kVar.f3481c)) {
            return false;
        }
        if (this.f3482d == null) {
            if (kVar.f3482d != null) {
                return false;
            }
        } else if (!this.f3482d.a(kVar.f3482d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.f3480b) {
            z = this.f3483e == e.a.CLEARED;
        }
        return z;
    }
}
