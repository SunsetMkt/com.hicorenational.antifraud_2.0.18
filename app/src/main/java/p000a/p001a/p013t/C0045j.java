package p000a.p001a.p013t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* renamed from: a.a.t.j */
/* loaded from: classes.dex */
class C0045j implements SessionGetCallback {

    /* renamed from: a */
    final /* synthetic */ RequestStatistic f125a;

    /* renamed from: b */
    final /* synthetic */ long f126b;

    /* renamed from: c */
    final /* synthetic */ Request f127c;

    /* renamed from: d */
    final /* synthetic */ SessionCenter f128d;

    /* renamed from: e */
    final /* synthetic */ HttpUrl f129e;

    /* renamed from: f */
    final /* synthetic */ boolean f130f;

    /* renamed from: g */
    final /* synthetic */ C0042g f131g;

    C0045j(C0042g c0042g, RequestStatistic requestStatistic, long j2, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        this.f131g = c0042g;
        this.f125a = requestStatistic;
        this.f126b = j2;
        this.f127c = request;
        this.f128d = sessionCenter;
        this.f129e = httpUrl;
        this.f130f = z;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        Session m187a;
        ALog.m715e(C0042g.f100n, "onSessionGetFail", this.f131g.f102a.f137c, "url", this.f125a.url);
        this.f125a.connWaitTime = System.currentTimeMillis() - this.f126b;
        C0042g c0042g = this.f131g;
        m187a = c0042g.m187a(null, this.f128d, this.f129e, this.f130f);
        c0042g.m192a(m187a, this.f127c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.m716i(C0042g.f100n, "onSessionGetSuccess", this.f131g.f102a.f137c, "Session", session);
        this.f125a.connWaitTime = System.currentTimeMillis() - this.f126b;
        this.f125a.spdyRequestSend = true;
        this.f131g.m192a(session, this.f127c);
    }
}
