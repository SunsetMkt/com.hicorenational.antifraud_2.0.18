package com.bumptech.glide.p137r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.InterfaceC1826e;

/* compiled from: ErrorRequestCoordinator.java */
/* renamed from: com.bumptech.glide.r.b */
/* loaded from: classes.dex */
public final class C1823b implements InterfaceC1826e, InterfaceC1825d {

    /* renamed from: a */
    private final Object f5307a;

    /* renamed from: b */
    @Nullable
    private final InterfaceC1826e f5308b;

    /* renamed from: c */
    private volatile InterfaceC1825d f5309c;

    /* renamed from: d */
    private volatile InterfaceC1825d f5310d;

    /* renamed from: e */
    @GuardedBy("requestLock")
    private InterfaceC1826e.a f5311e;

    /* renamed from: f */
    @GuardedBy("requestLock")
    private InterfaceC1826e.a f5312f;

    public C1823b(Object obj, @Nullable InterfaceC1826e interfaceC1826e) {
        InterfaceC1826e.a aVar = InterfaceC1826e.a.CLEARED;
        this.f5311e = aVar;
        this.f5312f = aVar;
        this.f5307a = obj;
        this.f5308b = interfaceC1826e;
    }

    @GuardedBy("requestLock")
    /* renamed from: e */
    private boolean m4800e() {
        InterfaceC1826e interfaceC1826e = this.f5308b;
        return interfaceC1826e == null || interfaceC1826e.mo4814f(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: g */
    private boolean m4802g() {
        InterfaceC1826e interfaceC1826e = this.f5308b;
        return interfaceC1826e == null || interfaceC1826e.mo4812d(this);
    }

    /* renamed from: a */
    public void m4804a(InterfaceC1825d interfaceC1825d, InterfaceC1825d interfaceC1825d2) {
        this.f5309c = interfaceC1825d;
        this.f5310d = interfaceC1825d2;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: b */
    public boolean mo4808b() {
        boolean z;
        synchronized (this.f5307a) {
            z = this.f5311e == InterfaceC1826e.a.CLEARED && this.f5312f == InterfaceC1826e.a.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: c */
    public void mo4809c() {
        synchronized (this.f5307a) {
            if (this.f5311e != InterfaceC1826e.a.RUNNING) {
                this.f5311e = InterfaceC1826e.a.RUNNING;
                this.f5309c.mo4809c();
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void clear() {
        synchronized (this.f5307a) {
            this.f5311e = InterfaceC1826e.a.CLEARED;
            this.f5309c.clear();
            if (this.f5312f != InterfaceC1826e.a.CLEARED) {
                this.f5312f = InterfaceC1826e.a.CLEARED;
                this.f5310d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: d */
    public boolean mo4811d() {
        boolean z;
        synchronized (this.f5307a) {
            z = this.f5311e == InterfaceC1826e.a.SUCCESS || this.f5312f == InterfaceC1826e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: f */
    public boolean mo4814f(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5307a) {
            z = m4800e() && m4803g(interfaceC1825d);
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    public InterfaceC1826e getRoot() {
        InterfaceC1826e root;
        synchronized (this.f5307a) {
            root = this.f5308b != null ? this.f5308b.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5307a) {
            z = this.f5311e == InterfaceC1826e.a.RUNNING || this.f5312f == InterfaceC1826e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void pause() {
        synchronized (this.f5307a) {
            if (this.f5311e == InterfaceC1826e.a.RUNNING) {
                this.f5311e = InterfaceC1826e.a.PAUSED;
                this.f5309c.pause();
            }
            if (this.f5312f == InterfaceC1826e.a.RUNNING) {
                this.f5312f = InterfaceC1826e.a.PAUSED;
                this.f5310d.pause();
            }
        }
    }

    @GuardedBy("requestLock")
    /* renamed from: g */
    private boolean m4803g(InterfaceC1825d interfaceC1825d) {
        return interfaceC1825d.equals(this.f5309c) || (this.f5311e == InterfaceC1826e.a.FAILED && interfaceC1825d.equals(this.f5310d));
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: e */
    public void mo4813e(InterfaceC1825d interfaceC1825d) {
        synchronized (this.f5307a) {
            if (interfaceC1825d.equals(this.f5309c)) {
                this.f5311e = InterfaceC1826e.a.SUCCESS;
            } else if (interfaceC1825d.equals(this.f5310d)) {
                this.f5312f = InterfaceC1826e.a.SUCCESS;
            }
            if (this.f5308b != null) {
                this.f5308b.mo4813e(this);
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4806a(InterfaceC1825d interfaceC1825d) {
        if (!(interfaceC1825d instanceof C1823b)) {
            return false;
        }
        C1823b c1823b = (C1823b) interfaceC1825d;
        return this.f5309c.mo4806a(c1823b.f5309c) && this.f5310d.mo4806a(c1823b.f5310d);
    }

    @GuardedBy("requestLock")
    /* renamed from: f */
    private boolean m4801f() {
        InterfaceC1826e interfaceC1826e = this.f5308b;
        return interfaceC1826e == null || interfaceC1826e.mo4810c(this);
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: b */
    public void mo4807b(InterfaceC1825d interfaceC1825d) {
        synchronized (this.f5307a) {
            if (!interfaceC1825d.equals(this.f5310d)) {
                this.f5311e = InterfaceC1826e.a.FAILED;
                if (this.f5312f != InterfaceC1826e.a.RUNNING) {
                    this.f5312f = InterfaceC1826e.a.RUNNING;
                    this.f5310d.mo4809c();
                }
                return;
            }
            this.f5312f = InterfaceC1826e.a.FAILED;
            if (this.f5308b != null) {
                this.f5308b.mo4807b(this);
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: d */
    public boolean mo4812d(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5307a) {
            z = m4802g() && m4803g(interfaceC1825d);
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e, com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4805a() {
        boolean z;
        synchronized (this.f5307a) {
            z = this.f5309c.mo4805a() || this.f5310d.mo4805a();
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: c */
    public boolean mo4810c(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5307a) {
            z = m4801f() && m4803g(interfaceC1825d);
        }
        return z;
    }
}
