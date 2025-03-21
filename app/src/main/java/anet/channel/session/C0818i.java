package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.i */
/* loaded from: classes.dex */
class C0818i implements IAuth.AuthCallback {

    /* renamed from: a */
    final /* synthetic */ TnetSpdySession f996a;

    C0818i(TnetSpdySession tnetSpdySession) {
        this.f996a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i2, String str) {
        this.f996a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.f996a.f699q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i2;
            this.f996a.f699q.errorCode = (long) i2;
        }
        this.f996a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.f996a.notifyStatus(4, null);
        this.f996a.f975z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f996a;
        IHeartbeat iHeartbeat = tnetSpdySession.f966D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f996a;
        SessionStatistic sessionStatistic = tnetSpdySession2.f699q;
        sessionStatistic.ret = 1;
        ALog.m713d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.f698p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f996a;
        if (tnetSpdySession3.f963A > 0) {
            tnetSpdySession3.f699q.authTime = System.currentTimeMillis() - this.f996a.f963A;
        }
    }
}
