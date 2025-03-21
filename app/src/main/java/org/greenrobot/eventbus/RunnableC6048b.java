package org.greenrobot.eventbus;

import java.util.logging.Level;

/* compiled from: BackgroundPoster.java */
/* renamed from: org.greenrobot.eventbus.b */
/* loaded from: classes2.dex */
final class RunnableC6048b implements Runnable, InterfaceC6058l {

    /* renamed from: a */
    private final C6057k f21523a = new C6057k();

    /* renamed from: b */
    private final C6049c f21524b;

    /* renamed from: c */
    private volatile boolean f21525c;

    RunnableC6048b(C6049c c6049c) {
        this.f21524b = c6049c;
    }

    @Override // org.greenrobot.eventbus.InterfaceC6058l
    /* renamed from: a */
    public void mo24975a(C6063q c6063q, Object obj) {
        C6056j m25028a = C6056j.m25028a(c6063q, obj);
        synchronized (this) {
            this.f21523a.m25032a(m25028a);
            if (!this.f21525c) {
                this.f21525c = true;
                this.f21524b.m24990a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                C6056j m25031a = this.f21523a.m25031a(1000);
                if (m25031a == null) {
                    synchronized (this) {
                        m25031a = this.f21523a.m25030a();
                        if (m25031a == null) {
                            return;
                        }
                    }
                }
                this.f21524b.m24992a(m25031a);
            } catch (InterruptedException e2) {
                this.f21524b.m24994b().mo25023a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f21525c = false;
            }
        }
    }
}
