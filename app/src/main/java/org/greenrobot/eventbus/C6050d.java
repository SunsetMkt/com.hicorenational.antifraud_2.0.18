package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.InterfaceC6053g;
import org.greenrobot.eventbus.InterfaceC6054h;
import org.greenrobot.eventbus.p387r.InterfaceC6067d;

/* compiled from: EventBusBuilder.java */
/* renamed from: org.greenrobot.eventbus.d */
/* loaded from: classes2.dex */
public class C6050d {

    /* renamed from: n */
    private static final ExecutorService f21556n = Executors.newCachedThreadPool();

    /* renamed from: e */
    boolean f21561e;

    /* renamed from: g */
    boolean f21563g;

    /* renamed from: h */
    boolean f21564h;

    /* renamed from: j */
    List<Class<?>> f21566j;

    /* renamed from: k */
    List<InterfaceC6067d> f21567k;

    /* renamed from: l */
    InterfaceC6053g f21568l;

    /* renamed from: m */
    InterfaceC6054h f21569m;

    /* renamed from: a */
    boolean f21557a = true;

    /* renamed from: b */
    boolean f21558b = true;

    /* renamed from: c */
    boolean f21559c = true;

    /* renamed from: d */
    boolean f21560d = true;

    /* renamed from: f */
    boolean f21562f = true;

    /* renamed from: i */
    ExecutorService f21565i = f21556n;

    C6050d() {
    }

    /* renamed from: a */
    public C6050d m25010a(boolean z) {
        this.f21562f = z;
        return this;
    }

    /* renamed from: b */
    public C6050d m25012b(boolean z) {
        this.f21563g = z;
        return this;
    }

    /* renamed from: c */
    public C6050d m25013c(boolean z) {
        this.f21558b = z;
        return this;
    }

    /* renamed from: d */
    public C6050d m25015d(boolean z) {
        this.f21557a = z;
        return this;
    }

    /* renamed from: e */
    public C6050d m25018e(boolean z) {
        this.f21560d = z;
        return this;
    }

    /* renamed from: f */
    public C6050d m25019f(boolean z) {
        this.f21559c = z;
        return this;
    }

    /* renamed from: g */
    public C6050d m25020g(boolean z) {
        this.f21564h = z;
        return this;
    }

    /* renamed from: h */
    public C6050d m25021h(boolean z) {
        this.f21561e = z;
        return this;
    }

    /* renamed from: a */
    public C6050d m25007a(ExecutorService executorService) {
        this.f21565i = executorService;
        return this;
    }

    /* renamed from: b */
    Object m25011b() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    /* renamed from: c */
    InterfaceC6053g m25014c() {
        InterfaceC6053g interfaceC6053g = this.f21568l;
        return interfaceC6053g != null ? interfaceC6053g : (!InterfaceC6053g.a.m25024a() || m25011b() == null) ? new InterfaceC6053g.c() : new InterfaceC6053g.a("EventBus");
    }

    /* renamed from: d */
    InterfaceC6054h m25016d() {
        Object m25011b;
        InterfaceC6054h interfaceC6054h = this.f21569m;
        if (interfaceC6054h != null) {
            return interfaceC6054h;
        }
        if (!InterfaceC6053g.a.m25024a() || (m25011b = m25011b()) == null) {
            return null;
        }
        return new InterfaceC6054h.a((Looper) m25011b);
    }

    /* renamed from: e */
    public C6049c m25017e() {
        C6049c c6049c;
        synchronized (C6049c.class) {
            if (C6049c.f21527t != null) {
                throw new C6051e("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            C6049c.f21527t = m25005a();
            c6049c = C6049c.f21527t;
        }
        return c6049c;
    }

    /* renamed from: a */
    public C6050d m25006a(Class<?> cls) {
        if (this.f21566j == null) {
            this.f21566j = new ArrayList();
        }
        this.f21566j.add(cls);
        return this;
    }

    /* renamed from: a */
    public C6050d m25009a(InterfaceC6067d interfaceC6067d) {
        if (this.f21567k == null) {
            this.f21567k = new ArrayList();
        }
        this.f21567k.add(interfaceC6067d);
        return this;
    }

    /* renamed from: a */
    public C6050d m25008a(InterfaceC6053g interfaceC6053g) {
        this.f21568l = interfaceC6053g;
        return this;
    }

    /* renamed from: a */
    public C6049c m25005a() {
        return new C6049c(this);
    }
}
