package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements EventCb {
    final /* synthetic */ SessionRequest.IConnCb a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionRequest f1449c;

    f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j2) {
        this.f1449c = sessionRequest;
        this.a = iConnCb;
        this.f1448b = j2;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (session == null) {
            return;
        }
        int i3 = bVar == null ? 0 : bVar.f1444b;
        String str = bVar == null ? "" : bVar.f1445c;
        if (i2 == 2) {
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f1449c.a(session, i3, str);
            SessionRequest sessionRequest = this.f1449c;
            if (sessionRequest.f1367b.c(sessionRequest, session)) {
                this.a.onDisConnect(session, this.f1448b, i2);
                return;
            } else {
                this.a.onFailed(session, this.f1448b, i2, i3);
                return;
            }
        }
        if (i2 == 256) {
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.a.onFailed(session, this.f1448b, i2, i3);
        } else {
            if (i2 != 512) {
                return;
            }
            ALog.d("awcn.SessionRequest", null, session != null ? session.p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f1449c.a(session, 0, (String) null);
            this.a.onSuccess(session, this.f1448b);
        }
    }
}
