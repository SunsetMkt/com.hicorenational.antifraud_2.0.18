package com.bumptech.glide.r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.r.e;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e, d {
    private final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final e f3452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile d f3453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d f3454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f3455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private e.a f3456f;

    public b(Object obj, @Nullable e eVar) {
        e.a aVar = e.a.CLEARED;
        this.f3455e = aVar;
        this.f3456f = aVar;
        this.a = obj;
        this.f3452b = eVar;
    }

    @GuardedBy("requestLock")
    private boolean e() {
        e eVar = this.f3452b;
        return eVar == null || eVar.f(this);
    }

    @GuardedBy("requestLock")
    private boolean g() {
        e eVar = this.f3452b;
        return eVar == null || eVar.d(this);
    }

    public void a(d dVar, d dVar2) {
        this.f3453c = dVar;
        this.f3454d = dVar2;
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.f3455e == e.a.CLEARED && this.f3456f == e.a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void c() {
        synchronized (this.a) {
            if (this.f3455e != e.a.RUNNING) {
                this.f3455e = e.a.RUNNING;
                this.f3453c.c();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        synchronized (this.a) {
            this.f3455e = e.a.CLEARED;
            this.f3453c.clear();
            if (this.f3456f != e.a.CLEARED) {
                this.f3456f = e.a.CLEARED;
                this.f3454d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean d() {
        boolean z;
        synchronized (this.a) {
            z = this.f3455e == e.a.SUCCESS || this.f3456f == e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(d dVar) {
        boolean z;
        synchronized (this.a) {
            z = e() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public e getRoot() {
        e root;
        synchronized (this.a) {
            root = this.f3452b != null ? this.f3452b.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            z = this.f3455e == e.a.RUNNING || this.f3456f == e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.r.d
    public void pause() {
        synchronized (this.a) {
            if (this.f3455e == e.a.RUNNING) {
                this.f3455e = e.a.PAUSED;
                this.f3453c.pause();
            }
            if (this.f3456f == e.a.RUNNING) {
                this.f3456f = e.a.PAUSED;
                this.f3454d.pause();
            }
        }
    }

    @GuardedBy("requestLock")
    private boolean g(d dVar) {
        return dVar.equals(this.f3453c) || (this.f3455e == e.a.FAILED && dVar.equals(this.f3454d));
    }

    @Override // com.bumptech.glide.r.e
    public void e(d dVar) {
        synchronized (this.a) {
            if (dVar.equals(this.f3453c)) {
                this.f3455e = e.a.SUCCESS;
            } else if (dVar.equals(this.f3454d)) {
                this.f3456f = e.a.SUCCESS;
            }
            if (this.f3452b != null) {
                this.f3452b.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean a(d dVar) {
        if (!(dVar instanceof b)) {
            return false;
        }
        b bVar = (b) dVar;
        return this.f3453c.a(bVar.f3453c) && this.f3454d.a(bVar.f3454d);
    }

    @GuardedBy("requestLock")
    private boolean f() {
        e eVar = this.f3452b;
        return eVar == null || eVar.c(this);
    }

    @Override // com.bumptech.glide.r.e
    public void b(d dVar) {
        synchronized (this.a) {
            if (!dVar.equals(this.f3454d)) {
                this.f3455e = e.a.FAILED;
                if (this.f3456f != e.a.RUNNING) {
                    this.f3456f = e.a.RUNNING;
                    this.f3454d.c();
                }
                return;
            }
            this.f3456f = e.a.FAILED;
            if (this.f3452b != null) {
                this.f3452b.b(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean d(d dVar) {
        boolean z;
        synchronized (this.a) {
            z = g() && g(dVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e, com.bumptech.glide.r.d
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.f3453c.a() || this.f3454d.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.r.e
    public boolean c(d dVar) {
        boolean z;
        synchronized (this.a) {
            z = f() && g(dVar);
        }
        return z;
    }
}
