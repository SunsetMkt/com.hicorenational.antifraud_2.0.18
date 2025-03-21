package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.C0782b;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.f */
/* loaded from: classes.dex */
class C0784f implements EventCb {

    /* renamed from: a */
    final /* synthetic */ SessionRequest.IConnCb f846a;

    /* renamed from: b */
    final /* synthetic */ long f847b;

    /* renamed from: c */
    final /* synthetic */ SessionRequest f848c;

    C0784f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j2) {
        this.f848c = sessionRequest;
        this.f846a = iConnCb;
        this.f847b = j2;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, C0782b c0782b) {
        if (session == null) {
            return;
        }
        int i3 = c0782b == null ? 0 : c0782b.f841b;
        String str = c0782b == null ? "" : c0782b.f842c;
        if (i2 == 2) {
            ALog.m713d("awcn.SessionRequest", null, session != null ? session.f698p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", c0782b);
            this.f848c.m434a(session, i3, str);
            SessionRequest sessionRequest = this.f848c;
            if (sessionRequest.f722b.m489c(sessionRequest, session)) {
                this.f846a.onDisConnect(session, this.f847b, i2);
                return;
            } else {
                this.f846a.onFailed(session, this.f847b, i2, i3);
                return;
            }
        }
        if (i2 == 256) {
            ALog.m713d("awcn.SessionRequest", null, session != null ? session.f698p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", c0782b);
            this.f846a.onFailed(session, this.f847b, i2, i3);
        } else {
            if (i2 != 512) {
                return;
            }
            ALog.m713d("awcn.SessionRequest", null, session != null ? session.f698p : null, "Session", session, "EventType", Integer.valueOf(i2), "Event", c0782b);
            this.f848c.m434a(session, 0, (String) null);
            this.f846a.onSuccess(session, this.f847b);
        }
    }
}
