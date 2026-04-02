package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.EventCb;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements EventCb {
    final /* synthetic */ IConnStrategy a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ e f1439b;

    f(e eVar, IConnStrategy iConnStrategy) {
        this.f1439b = eVar;
        this.a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ?? r5 = i2 != 1 ? 0 : 1;
        a.a.a(NetworkStatusHelper.getUniqueId(this.f1439b.f1438b), r5);
        session.close(false);
        Http3DetectStat http3DetectStat = new Http3DetectStat(a.f1428b, this.a);
        http3DetectStat.ret = r5;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
