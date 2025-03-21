package com.taobao.accs.net;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.x */
/* loaded from: classes2.dex */
class RunnableC3024x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3022v f9627a;

    RunnableC3024x(C3022v c3022v) {
        this.f9627a = c3022v;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9627a.m9160o();
        if (this.f9627a.f9601I != null) {
            this.f9627a.f9601I.setCloseReason("shut down");
        }
        synchronized (this.f9627a.f9614u) {
            try {
                this.f9627a.f9614u.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}
