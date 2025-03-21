package org.greenrobot.eventbus;

/* compiled from: PendingPostQueue.java */
/* renamed from: org.greenrobot.eventbus.k */
/* loaded from: classes2.dex */
final class C6057k {

    /* renamed from: a */
    private C6056j f21584a;

    /* renamed from: b */
    private C6056j f21585b;

    C6057k() {
    }

    /* renamed from: a */
    synchronized void m25032a(C6056j c6056j) {
        try {
            if (c6056j == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            if (this.f21585b != null) {
                this.f21585b.f21583c = c6056j;
                this.f21585b = c6056j;
            } else {
                if (this.f21584a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f21585b = c6056j;
                this.f21584a = c6056j;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: a */
    synchronized C6056j m25030a() {
        C6056j c6056j;
        c6056j = this.f21584a;
        if (this.f21584a != null) {
            this.f21584a = this.f21584a.f21583c;
            if (this.f21584a == null) {
                this.f21585b = null;
            }
        }
        return c6056j;
    }

    /* renamed from: a */
    synchronized C6056j m25031a(int i2) throws InterruptedException {
        if (this.f21584a == null) {
            wait(i2);
        }
        return m25030a();
    }
}
