package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.f */
/* loaded from: classes.dex */
class RunnableC0815f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Request f990a;

    /* renamed from: b */
    final /* synthetic */ RequestCb f991b;

    /* renamed from: c */
    final /* synthetic */ RequestStatistic f992c;

    /* renamed from: d */
    final /* synthetic */ C0813d f993d;

    RunnableC0815f(C0813d c0813d, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f993d = c0813d;
        this.f990a = request;
        this.f991b = requestCb;
        this.f992c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f990a.f916a.sendBeforeTime = System.currentTimeMillis() - this.f990a.f916a.reqStart;
        C0811b.m602a(this.f990a, new C0816g(this));
    }
}
