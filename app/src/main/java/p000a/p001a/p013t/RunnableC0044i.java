package p000a.p001a.p013t;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.C0783c;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* renamed from: a.a.t.i */
/* loaded from: classes.dex */
class RunnableC0044i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SessionCenter f119a;

    /* renamed from: b */
    final /* synthetic */ HttpUrl f120b;

    /* renamed from: c */
    final /* synthetic */ RequestStatistic f121c;

    /* renamed from: d */
    final /* synthetic */ HttpUrl f122d;

    /* renamed from: e */
    final /* synthetic */ boolean f123e;

    /* renamed from: f */
    final /* synthetic */ C0042g f124f;

    RunnableC0044i(C0042g c0042g, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z) {
        this.f124f = c0042g;
        this.f119a = sessionCenter;
        this.f120b = httpUrl;
        this.f121c = requestStatistic;
        this.f122d = httpUrl2;
        this.f123e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Session m187a;
        long currentTimeMillis = System.currentTimeMillis();
        Session session = this.f119a.get(this.f120b, C0783c.f843a, 3000L);
        this.f121c.connWaitTime = System.currentTimeMillis() - currentTimeMillis;
        this.f121c.spdyRequestSend = session != null;
        m187a = this.f124f.m187a(session, this.f119a, this.f122d, this.f123e);
        C0042g c0042g = this.f124f;
        c0042g.m192a(m187a, c0042g.f102a.f135a.m824a());
    }
}
