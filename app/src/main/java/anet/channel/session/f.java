package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ Request a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestCb f1540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f1541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f1542d;

    f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f1542d = dVar;
        this.a = request;
        this.f1540b = requestCb;
        this.f1541c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.sendBeforeTime = System.currentTimeMillis() - this.a.a.reqStart;
        b.a(this.a, new g(this));
    }
}
