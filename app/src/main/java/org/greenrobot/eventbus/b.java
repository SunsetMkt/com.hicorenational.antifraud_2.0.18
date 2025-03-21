package org.greenrobot.eventbus;

import java.util.logging.Level;

/* compiled from: BackgroundPoster.java */
/* loaded from: classes2.dex */
final class b implements Runnable, l {

    /* renamed from: a, reason: collision with root package name */
    private final k f17365a = new k();

    /* renamed from: b, reason: collision with root package name */
    private final c f17366b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f17367c;

    b(c cVar) {
        this.f17366b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f17365a.a(a2);
            if (!this.f17367c) {
                this.f17367c = true;
                this.f17366b.a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                j a2 = this.f17365a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f17365a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.f17366b.a(a2);
            } catch (InterruptedException e2) {
                this.f17366b.b().a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f17367c = false;
            }
        }
    }
}
