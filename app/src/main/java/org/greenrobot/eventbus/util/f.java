package org.greenrobot.eventbus.util;

/* JADX INFO: compiled from: ThrowableFailureEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements e {
    protected final Throwable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f12995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f12996c;

    public f(Throwable th) {
        this.a = th;
        this.f12995b = false;
    }

    @Override // org.greenrobot.eventbus.util.e
    public Object a() {
        return this.f12996c;
    }

    public Throwable b() {
        return this.a;
    }

    public boolean c() {
        return this.f12995b;
    }

    @Override // org.greenrobot.eventbus.util.e
    public void a(Object obj) {
        this.f12996c = obj;
    }

    public f(Throwable th, boolean z) {
        this.a = th;
        this.f12995b = z;
    }
}
