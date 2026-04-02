package b.a.t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ SessionCenter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f1882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ g f1883f;

    i(g gVar, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z) {
        this.f1883f = gVar;
        this.a = sessionCenter;
        this.f1879b = httpUrl;
        this.f1880c = requestStatistic;
        this.f1881d = httpUrl2;
        this.f1882e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Session session = this.a.get(this.f1879b, anet.channel.entity.c.a, 3000L);
        this.f1880c.connWaitTime = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f1880c.spdyRequestSend = session != null;
        Session sessionA = this.f1883f.a(session, this.a, this.f1881d, this.f1882e);
        g gVar = this.f1883f;
        gVar.a(sessionA, gVar.a.a.a());
    }
}
