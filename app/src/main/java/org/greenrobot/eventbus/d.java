package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;

/* JADX INFO: compiled from: EventBusBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ExecutorService f12912n = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f12916e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f12918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f12919h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<Class<?>> f12921j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List<org.greenrobot.eventbus.r.d> f12922k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f12923l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    h f12924m;
    boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f12913b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12914c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12915d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12917f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ExecutorService f12920i = f12912n;

    d() {
    }

    public d a(boolean z) {
        this.f12917f = z;
        return this;
    }

    public d b(boolean z) {
        this.f12918g = z;
        return this;
    }

    public d c(boolean z) {
        this.f12913b = z;
        return this;
    }

    public d d(boolean z) {
        this.a = z;
        return this;
    }

    public d e(boolean z) {
        this.f12915d = z;
        return this;
    }

    public d f(boolean z) {
        this.f12914c = z;
        return this;
    }

    public d g(boolean z) {
        this.f12919h = z;
        return this;
    }

    public d h(boolean z) {
        this.f12916e = z;
        return this;
    }

    public d a(ExecutorService executorService) {
        this.f12920i = executorService;
        return this;
    }

    Object b() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    g c() {
        g gVar = this.f12923l;
        return gVar != null ? gVar : (!g.a.a() || b() == null) ? new g.c() : new g.a("EventBus");
    }

    h d() {
        Object objB;
        h hVar = this.f12924m;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.a() || (objB = b()) == null) {
            return null;
        }
        return new h.a((Looper) objB);
    }

    public c e() {
        c cVar;
        synchronized (c.class) {
            if (c.t != null) {
                throw new e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            c.t = a();
            cVar = c.t;
        }
        return cVar;
    }

    public d a(Class<?> cls) {
        if (this.f12921j == null) {
            this.f12921j = new ArrayList();
        }
        this.f12921j.add(cls);
        return this;
    }

    public d a(org.greenrobot.eventbus.r.d dVar) {
        if (this.f12922k == null) {
            this.f12922k = new ArrayList();
        }
        this.f12922k.add(dVar);
        return this;
    }

    public d a(g gVar) {
        this.f12923l = gVar;
        return this;
    }

    public c a() {
        return new c(this);
    }
}
