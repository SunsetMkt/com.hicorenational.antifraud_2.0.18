package anet.channel.detect;

import anet.channel.Session;
import anet.channel.entity.EventCb;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.HorseRaceStat;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class h implements EventCb {
    final /* synthetic */ HorseRaceStat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f1416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ l.e f1417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f1418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ d f1419f;

    h(d dVar, HorseRaceStat horseRaceStat, long j2, String str, l.e eVar, TnetSpdySession tnetSpdySession) {
        this.f1419f = dVar;
        this.a = horseRaceStat;
        this.f1415b = j2;
        this.f1416c = str;
        this.f1417d = eVar;
        this.f1418e = tnetSpdySession;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (this.a.connTime != 0) {
            return;
        }
        this.a.connTime = System.currentTimeMillis() - this.f1415b;
        if (i2 != 1) {
            HorseRaceStat horseRaceStat = this.a;
            horseRaceStat.connErrorCode = bVar.f1444b;
            synchronized (horseRaceStat) {
                this.a.notify();
            }
            return;
        }
        ALog.i("anet.HorseRaceDetector", "tnetSpdySession connect success", this.f1416c, new Object[0]);
        this.a.connRet = 1;
        HttpUrl httpUrl = HttpUrl.parse(session.getHost() + this.f1417d.f1633c);
        if (httpUrl == null) {
            return;
        }
        this.f1418e.request(new Request.Builder().setUrl(httpUrl).setReadTimeout(this.f1417d.f1632b.f1608d).setRedirectEnable(false).setSeq(this.f1416c).build(), new i(this));
    }
}
