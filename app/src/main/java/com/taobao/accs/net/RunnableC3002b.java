package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.b */
/* loaded from: classes2.dex */
class RunnableC3002b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9539a;

    /* renamed from: b */
    final /* synthetic */ boolean f9540b;

    /* renamed from: c */
    final /* synthetic */ AbstractC3001a f9541c;

    RunnableC3002b(AbstractC3001a abstractC3001a, String str, boolean z) {
        this.f9541c = abstractC3001a;
        this.f9539a = str;
        this.f9540b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message m9022a = this.f9541c.f9525e.m9022a(this.f9539a);
        if (m9022a != null) {
            this.f9541c.f9525e.m9026a(m9022a, -9);
            this.f9541c.mo9087a(this.f9539a, this.f9540b, "receive data time out");
            ALog.m9182e(this.f9541c.mo9100d(), this.f9539a + "-> receive data time out!", new Object[0]);
        }
    }
}
