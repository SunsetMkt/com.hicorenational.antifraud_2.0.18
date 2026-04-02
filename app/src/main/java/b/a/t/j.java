package b.a.t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class j implements SessionGetCallback {
    final /* synthetic */ RequestStatistic a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Request f1885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SessionCenter f1886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ HttpUrl f1887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f1888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ g f1889g;

    j(g gVar, RequestStatistic requestStatistic, long j2, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        this.f1889g = gVar;
        this.a = requestStatistic;
        this.f1884b = j2;
        this.f1885c = request;
        this.f1886d = sessionCenter;
        this.f1887e = httpUrl;
        this.f1888f = z;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        ALog.e(g.f1864n, "onSessionGetFail", this.f1889g.a.f1893c, "url", this.a.url);
        this.a.connWaitTime = System.currentTimeMillis() - this.f1884b;
        g gVar = this.f1889g;
        gVar.a(gVar.a(null, this.f1886d, this.f1887e, this.f1888f), this.f1885c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.i(g.f1864n, "onSessionGetSuccess", this.f1889g.a.f1893c, "Session", session);
        this.a.connWaitTime = System.currentTimeMillis() - this.f1884b;
        this.a.spdyRequestSend = true;
        this.f1889g.a(session, this.f1885c);
    }
}
