package anet.channel.session;

import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyInstance;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.h */
/* loaded from: classes.dex */
class RunnableC0817h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TnetSpdySession f995a;

    RunnableC0817h(TnetSpdySession tnetSpdySession) {
        this.f995a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        IConnStrategy iConnStrategy;
        if (this.f995a.f974y) {
            TnetSpdySession tnetSpdySession = this.f995a;
            ALog.m715e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.f698p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.f974y));
            try {
                this.f995a.handleCallbacks(2048, null);
                if (this.f995a.f699q != null) {
                    this.f995a.f699q.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f995a.f971I;
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                str = this.f995a.f686d;
                iConnStrategy = this.f995a.f693k;
                strategyCenter.notifyConnEvent(str, iConnStrategy, connEvent);
                this.f995a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
