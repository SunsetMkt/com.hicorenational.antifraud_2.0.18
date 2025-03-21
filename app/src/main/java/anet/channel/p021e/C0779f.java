package anet.channel.p021e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0782b;
import anet.channel.entity.EventCb;
import anet.channel.p021e.C0774a;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.f */
/* loaded from: classes.dex */
class C0779f implements EventCb {

    /* renamed from: a */
    final /* synthetic */ IConnStrategy f832a;

    /* renamed from: b */
    final /* synthetic */ RunnableC0778e f833b;

    C0779f(RunnableC0778e runnableC0778e, IConnStrategy iConnStrategy) {
        this.f833b = runnableC0778e;
        this.f832a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, C0782b c0782b) {
        C0774a.b bVar;
        String str;
        ?? r5 = i2 != 1 ? 0 : 1;
        bVar = C0774a.f817a;
        bVar.m505a(NetworkStatusHelper.getUniqueId(this.f833b.f831b), r5);
        session.close(false);
        str = C0774a.f818b;
        Http3DetectStat http3DetectStat = new Http3DetectStat(str, this.f832a);
        http3DetectStat.ret = r5;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
