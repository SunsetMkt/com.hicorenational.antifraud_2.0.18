package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.q */
/* loaded from: classes2.dex */
class RunnableC3017q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3011k f9581a;

    RunnableC3017q(C3011k c3011k) {
        this.f9581a = c3011k;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9581a.f9527g) {
            try {
                Session session = SessionCenter.getInstance(this.f9581a.f9529i.getAppKey()).get(this.f9581a.mo9091b((String) null), ConnType.TypeLevel.SPDY, 0L);
                if (session != null) {
                    ALog.m9182e(this.f9581a.mo9100d(), "try session ping", new Object[0]);
                    int pingTimeout = this.f9581a.f9529i.getPingTimeout();
                    if (pingTimeout > 0) {
                        session.ping(true, pingTimeout);
                    } else {
                        session.ping(true);
                    }
                }
            } catch (Exception e2) {
                ALog.m9181e(this.f9581a.mo9100d(), "ping error", e2, new Object[0]);
            }
        }
    }
}
