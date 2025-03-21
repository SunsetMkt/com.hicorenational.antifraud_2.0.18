package com.bumptech.glide.p137r;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.p137r.InterfaceC1826e;

/* compiled from: ThumbnailRequestCoordinator.java */
/* renamed from: com.bumptech.glide.r.k */
/* loaded from: classes.dex */
public class C1832k implements InterfaceC1826e, InterfaceC1825d {

    /* renamed from: a */
    @Nullable
    private final InterfaceC1826e f5366a;

    /* renamed from: b */
    private final Object f5367b;

    /* renamed from: c */
    private volatile InterfaceC1825d f5368c;

    /* renamed from: d */
    private volatile InterfaceC1825d f5369d;

    /* renamed from: e */
    @GuardedBy("requestLock")
    private InterfaceC1826e.a f5370e;

    /* renamed from: f */
    @GuardedBy("requestLock")
    private InterfaceC1826e.a f5371f;

    /* renamed from: g */
    @GuardedBy("requestLock")
    private boolean f5372g;

    public C1832k(Object obj, @Nullable InterfaceC1826e interfaceC1826e) {
        InterfaceC1826e.a aVar = InterfaceC1826e.a.CLEARED;
        this.f5370e = aVar;
        this.f5371f = aVar;
        this.f5367b = obj;
        this.f5366a = interfaceC1826e;
    }

    @GuardedBy("requestLock")
    /* renamed from: e */
    private boolean m4868e() {
        InterfaceC1826e interfaceC1826e = this.f5366a;
        return interfaceC1826e == null || interfaceC1826e.mo4814f(this);
    }

    @GuardedBy("requestLock")
    /* renamed from: g */
    private boolean m4870g() {
        InterfaceC1826e interfaceC1826e = this.f5366a;
        return interfaceC1826e == null || interfaceC1826e.mo4812d(this);
    }

    /* renamed from: a */
    public void m4871a(InterfaceC1825d interfaceC1825d, InterfaceC1825d interfaceC1825d2) {
        this.f5368c = interfaceC1825d;
        this.f5369d = interfaceC1825d2;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: b */
    public void mo4807b(InterfaceC1825d interfaceC1825d) {
        synchronized (this.f5367b) {
            if (!interfaceC1825d.equals(this.f5368c)) {
                this.f5371f = InterfaceC1826e.a.FAILED;
                return;
            }
            this.f5370e = InterfaceC1826e.a.FAILED;
            if (this.f5366a != null) {
                this.f5366a.mo4807b(this);
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: c */
    public boolean mo4810c(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5367b) {
            z = m4869f() && interfaceC1825d.equals(this.f5368c) && !mo4805a();
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void clear() {
        synchronized (this.f5367b) {
            this.f5372g = false;
            this.f5370e = InterfaceC1826e.a.CLEARED;
            this.f5371f = InterfaceC1826e.a.CLEARED;
            this.f5369d.clear();
            this.f5368c.clear();
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: d */
    public boolean mo4812d(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5367b) {
            z = m4870g() && (interfaceC1825d.equals(this.f5368c) || this.f5370e != InterfaceC1826e.a.SUCCESS);
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: f */
    public boolean mo4814f(InterfaceC1825d interfaceC1825d) {
        boolean z;
        synchronized (this.f5367b) {
            z = m4868e() && interfaceC1825d.equals(this.f5368c) && this.f5370e != InterfaceC1826e.a.PAUSED;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    public InterfaceC1826e getRoot() {
        InterfaceC1826e root;
        synchronized (this.f5367b) {
            root = this.f5366a != null ? this.f5366a.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public boolean isRunning() {
        boolean z;
        synchronized (this.f5367b) {
            z = this.f5370e == InterfaceC1826e.a.RUNNING;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    public void pause() {
        synchronized (this.f5367b) {
            if (!this.f5371f.isComplete()) {
                this.f5371f = InterfaceC1826e.a.PAUSED;
                this.f5369d.pause();
            }
            if (!this.f5370e.isComplete()) {
                this.f5370e = InterfaceC1826e.a.PAUSED;
                this.f5368c.pause();
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e
    /* renamed from: e */
    public void mo4813e(InterfaceC1825d interfaceC1825d) {
        synchronized (this.f5367b) {
            if (interfaceC1825d.equals(this.f5369d)) {
                this.f5371f = InterfaceC1826e.a.SUCCESS;
                return;
            }
            this.f5370e = InterfaceC1826e.a.SUCCESS;
            if (this.f5366a != null) {
                this.f5366a.mo4813e(this);
            }
            if (!this.f5371f.isComplete()) {
                this.f5369d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1826e, com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4805a() {
        boolean z;
        synchronized (this.f5367b) {
            z = this.f5369d.mo4805a() || this.f5368c.mo4805a();
        }
        return z;
    }

    @GuardedBy("requestLock")
    /* renamed from: f */
    private boolean m4869f() {
        InterfaceC1826e interfaceC1826e = this.f5366a;
        return interfaceC1826e == null || interfaceC1826e.mo4810c(this);
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: c */
    public void mo4809c() {
        synchronized (this.f5367b) {
            this.f5372g = true;
            try {
                if (this.f5370e != InterfaceC1826e.a.SUCCESS && this.f5371f != InterfaceC1826e.a.RUNNING) {
                    this.f5371f = InterfaceC1826e.a.RUNNING;
                    this.f5369d.mo4809c();
                }
                if (this.f5372g && this.f5370e != InterfaceC1826e.a.RUNNING) {
                    this.f5370e = InterfaceC1826e.a.RUNNING;
                    this.f5368c.mo4809c();
                }
            } finally {
                this.f5372g = false;
            }
        }
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: d */
    public boolean mo4811d() {
        boolean z;
        synchronized (this.f5367b) {
            z = this.f5370e == InterfaceC1826e.a.SUCCESS;
        }
        return z;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: a */
    public boolean mo4806a(InterfaceC1825d interfaceC1825d) {
        if (!(interfaceC1825d instanceof C1832k)) {
            return false;
        }
        C1832k c1832k = (C1832k) interfaceC1825d;
        if (this.f5368c == null) {
            if (c1832k.f5368c != null) {
                return false;
            }
        } else if (!this.f5368c.mo4806a(c1832k.f5368c)) {
            return false;
        }
        if (this.f5369d == null) {
            if (c1832k.f5369d != null) {
                return false;
            }
        } else if (!this.f5369d.mo4806a(c1832k.f5369d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.p137r.InterfaceC1825d
    /* renamed from: b */
    public boolean mo4808b() {
        boolean z;
        synchronized (this.f5367b) {
            z = this.f5370e == InterfaceC1826e.a.CLEARED;
        }
        return z;
    }
}
