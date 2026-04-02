package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ anet.channel.entity.b f1391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Session f1392c;

    b(Session session, int i2, anet.channel.entity.b bVar) {
        this.f1392c = session;
        this.a = i2;
        this.f1391b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f1392c.f1344b != null) {
                for (EventCb eventCb : this.f1392c.f1344b.keySet()) {
                    if (eventCb != null && (this.f1392c.f1344b.get(eventCb).intValue() & this.a) != 0) {
                        try {
                            eventCb.onEvent(this.f1392c, this.a, this.f1391b);
                        } catch (Exception e2) {
                            ALog.e("awcn.Session", e2.toString(), this.f1392c.p, new Object[0]);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            ALog.e("awcn.Session", "handleCallbacks", this.f1392c.p, e3, new Object[0]);
        }
    }
}
