package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements IAuth.AuthCallback {
    final /* synthetic */ TnetSpdySession a;

    i(TnetSpdySession tnetSpdySession) {
        this.a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i2, String str) {
        this.a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.a.q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i2;
            this.a.q.errorCode = (long) i2;
        }
        this.a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.a.notifyStatus(4, null);
        this.a.z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.a;
        SessionStatistic sessionStatistic = tnetSpdySession2.q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.q.authTime = System.currentTimeMillis() - this.a.A;
        }
    }
}
