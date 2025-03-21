package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.e.a;
import anet.channel.entity.EventCb;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class f implements EventCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IConnStrategy f1758a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f1759b;

    f(e eVar, IConnStrategy iConnStrategy) {
        this.f1759b = eVar;
        this.f1758a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        a.b bVar2;
        String str;
        ?? r5 = i2 != 1 ? 0 : 1;
        bVar2 = a.f1743a;
        bVar2.a(NetworkStatusHelper.getUniqueId(this.f1759b.f1757b), r5);
        session.close(false);
        str = a.f1744b;
        Http3DetectStat http3DetectStat = new Http3DetectStat(str, this.f1758a);
        http3DetectStat.ret = r5;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
