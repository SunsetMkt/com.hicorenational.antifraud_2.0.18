package anet.channel.session;

import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ TnetSpdySession a;

    h(TnetSpdySession tnetSpdySession) {
        this.a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.y) {
            TnetSpdySession tnetSpdySession = this.a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.y));
            try {
                this.a.handleCallbacks(2048, null);
                if (this.a.q != null) {
                    this.a.q.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.a.I;
                StrategyCenter.getInstance().notifyConnEvent(this.a.f1346d, this.a.f1353k, connEvent);
                this.a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
