package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.C0782b;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.C0842l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.h */
/* loaded from: classes.dex */
class C0766h implements EventCb {

    /* renamed from: a */
    final /* synthetic */ HorseRaceStat f796a;

    /* renamed from: b */
    final /* synthetic */ long f797b;

    /* renamed from: c */
    final /* synthetic */ String f798c;

    /* renamed from: d */
    final /* synthetic */ C0842l.e f799d;

    /* renamed from: e */
    final /* synthetic */ TnetSpdySession f800e;

    /* renamed from: f */
    final /* synthetic */ C0762d f801f;

    C0766h(C0762d c0762d, HorseRaceStat horseRaceStat, long j2, String str, C0842l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f801f = c0762d;
        this.f796a = horseRaceStat;
        this.f797b = j2;
        this.f798c = str;
        this.f799d = eVar;
        this.f800e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, C0782b c0782b) {
        if (this.f796a.connTime != 0) {
            return;
        }
        this.f796a.connTime = System.currentTimeMillis() - this.f797b;
        if (i2 != 1) {
            HorseRaceStat horseRaceStat = this.f796a;
            horseRaceStat.connErrorCode = c0782b.f841b;
            synchronized (horseRaceStat) {
                this.f796a.notify();
            }
            return;
        }
        ALog.m716i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f798c, new Object[0]);
        this.f796a.connRet = 1;
        HttpUrl parse = HttpUrl.parse(session.getHost() + this.f799d.f1141c);
        if (parse == null) {
            return;
        }
        this.f800e.request(new Request.Builder().setUrl(parse).setReadTimeout(this.f799d.f1140b.f1112d).setRedirectEnable(false).setSeq(this.f798c).build(), new C0767i(this));
    }
}
