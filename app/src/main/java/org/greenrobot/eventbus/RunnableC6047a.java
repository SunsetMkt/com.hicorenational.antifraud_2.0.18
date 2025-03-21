package org.greenrobot.eventbus;

/* compiled from: AsyncPoster.java */
/* renamed from: org.greenrobot.eventbus.a */
/* loaded from: classes2.dex */
class RunnableC6047a implements Runnable, InterfaceC6058l {

    /* renamed from: a */
    private final C6057k f21521a = new C6057k();

    /* renamed from: b */
    private final C6049c f21522b;

    RunnableC6047a(C6049c c6049c) {
        this.f21522b = c6049c;
    }

    @Override // org.greenrobot.eventbus.InterfaceC6058l
    /* renamed from: a */
    public void mo24975a(C6063q c6063q, Object obj) {
        this.f21521a.m25032a(C6056j.m25028a(c6063q, obj));
        this.f21522b.m24990a().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        C6056j m25030a = this.f21521a.m25030a();
        if (m25030a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f21522b.m24992a(m25030a);
    }
}
