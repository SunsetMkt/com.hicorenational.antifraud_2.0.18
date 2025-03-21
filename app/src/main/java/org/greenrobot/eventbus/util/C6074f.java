package org.greenrobot.eventbus.util;

/* compiled from: ThrowableFailureEvent.java */
/* renamed from: org.greenrobot.eventbus.util.f */
/* loaded from: classes2.dex */
public class C6074f implements InterfaceC6073e {

    /* renamed from: a */
    protected final Throwable f21664a;

    /* renamed from: b */
    protected final boolean f21665b;

    /* renamed from: c */
    private Object f21666c;

    public C6074f(Throwable th) {
        this.f21664a = th;
        this.f21665b = false;
    }

    @Override // org.greenrobot.eventbus.util.InterfaceC6073e
    /* renamed from: a */
    public Object mo25095a() {
        return this.f21666c;
    }

    /* renamed from: b */
    public Throwable m25097b() {
        return this.f21664a;
    }

    /* renamed from: c */
    public boolean m25098c() {
        return this.f21665b;
    }

    @Override // org.greenrobot.eventbus.util.InterfaceC6073e
    /* renamed from: a */
    public void mo25096a(Object obj) {
        this.f21666c = obj;
    }

    public C6074f(Throwable th, boolean z) {
        this.f21664a = th;
        this.f21665b = z;
    }
}
