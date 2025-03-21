package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.p */
/* loaded from: classes2.dex */
class RunnableC3016p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9578a;

    /* renamed from: b */
    final /* synthetic */ boolean f9579b;

    /* renamed from: c */
    final /* synthetic */ C3011k f9580c;

    RunnableC3016p(C3011k c3011k, String str, boolean z) {
        this.f9580c = c3011k;
        this.f9578a = str;
        this.f9579b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message m9022a = this.f9580c.f9525e.m9022a(this.f9578a);
        if (m9022a != null) {
            this.f9580c.f9525e.m9026a(m9022a, -9);
            this.f9580c.mo9087a(this.f9578a, this.f9579b, "receive data time out");
            ALog.m9182e(this.f9580c.mo9100d(), this.f9578a + "-> receive data time out!", new Object[0]);
        }
    }
}
