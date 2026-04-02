package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements EventCb {
    final /* synthetic */ Session a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest f1457b;

    g(SessionRequest sessionRequest, Session session) {
        this.f1457b = sessionRequest;
        this.a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i2));
        ConnEvent connEvent = new ConnEvent();
        if (i2 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f1457b.f1368c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.a.getRealHost(), this.a.getConnStrategy(), connEvent);
    }
}
