package anet.channel;

import anet.channel.entity.C0782b;
import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.g */
/* loaded from: classes.dex */
class C0787g implements EventCb {

    /* renamed from: a */
    final /* synthetic */ Session f859a;

    /* renamed from: b */
    final /* synthetic */ SessionRequest f860b;

    C0787g(SessionRequest sessionRequest, Session session) {
        this.f860b = sessionRequest;
        this.f859a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, C0782b c0782b) {
        ALog.m713d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i2));
        ConnEvent connEvent = new ConnEvent();
        if (i2 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f860b.f723c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f859a.getRealHost(), this.f859a.getConnStrategy(), connEvent);
    }
}
