package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.c */
/* loaded from: classes2.dex */
class RunnableC3003c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AbstractC3001a f9542a;

    RunnableC3003c(AbstractC3001a abstractC3001a) {
        this.f9542a = abstractC3001a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9542a.f9525e.m9035c()) {
            ALog.m9182e(this.f9542a.mo9100d(), "receive ping time out! ", new Object[0]);
            AbstractC3007g.m9112a(this.f9542a.f9524d).m9116c();
            this.f9542a.mo9087a("", false, "receive ping timeout");
            this.f9542a.f9525e.m9024a(-12);
        }
    }
}
