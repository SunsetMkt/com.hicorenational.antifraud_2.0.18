package com.taobao.accs.net;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class q implements Runnable {
    final /* synthetic */ k a;

    q(k kVar) {
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.f5804g) {
            try {
                Session session = SessionCenter.getInstance(this.a.f5806i.getAppKey()).get(this.a.b((String) null), ConnType.TypeLevel.SPDY, 0L);
                if (session != null) {
                    ALog.e(this.a.d(), "try session ping", new Object[0]);
                    int pingTimeout = this.a.f5806i.getPingTimeout();
                    if (pingTimeout > 0) {
                        session.ping(true, pingTimeout);
                    } else {
                        session.ping(true);
                    }
                }
            } catch (Exception e2) {
                ALog.e(this.a.d(), "ping error", e2, new Object[0]);
            }
        }
    }
}
