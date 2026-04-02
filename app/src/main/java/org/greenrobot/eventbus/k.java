package org.greenrobot.eventbus;

/* JADX INFO: compiled from: PendingPostQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class k {
    private j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f12933b;

    k() {
    }

    synchronized void a(j jVar) {
        try {
            if (jVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f12933b != null) {
                this.f12933b.f12932c = jVar;
                this.f12933b = jVar;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f12933b = jVar;
                this.a = jVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized j a() {
        j jVar;
        jVar = this.a;
        if (this.a != null) {
            this.a = this.a.f12932c;
            if (this.a == null) {
                this.f12933b = null;
            }
        }
        return jVar;
    }

    synchronized j a(int i2) throws InterruptedException {
        if (this.a == null) {
            wait(i2);
        }
        return a();
    }
}
