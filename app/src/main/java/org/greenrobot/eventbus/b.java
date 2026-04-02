package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: compiled from: BackgroundPoster.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements Runnable, l {
    private final k a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f12892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12893c;

    b(c cVar) {
        this.f12892b = cVar;
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.a.a(jVarA);
            if (!this.f12893c) {
                this.f12893c = true;
                this.f12892b.a().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVarA;
        while (true) {
            try {
                jVarA = this.a.a(1000);
            } catch (InterruptedException e2) {
                this.f12892b.b().a(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.f12893c = false;
            }
            if (jVarA == null) {
                synchronized (this) {
                    jVarA = this.a.a();
                    if (jVarA == null) {
                        return;
                    }
                    this.f12893c = false;
                }
            }
            this.f12892b.a(jVarA);
        }
    }
}
