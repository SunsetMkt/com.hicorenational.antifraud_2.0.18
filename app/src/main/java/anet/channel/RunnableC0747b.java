package anet.channel;

import anet.channel.entity.C0782b;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.b */
/* loaded from: classes.dex */
class RunnableC0747b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f754a;

    /* renamed from: b */
    final /* synthetic */ C0782b f755b;

    /* renamed from: c */
    final /* synthetic */ Session f756c;

    RunnableC0747b(Session session, int i2, C0782b c0782b) {
        this.f756c = session;
        this.f754a = i2;
        this.f755b = c0782b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f756c.f684b != null) {
                for (EventCb eventCb : this.f756c.f684b.keySet()) {
                    if (eventCb != null && (this.f756c.f684b.get(eventCb).intValue() & this.f754a) != 0) {
                        try {
                            eventCb.onEvent(this.f756c, this.f754a, this.f755b);
                        } catch (Exception e2) {
                            ALog.m715e("awcn.Session", e2.toString(), this.f756c.f698p, new Object[0]);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            ALog.m714e("awcn.Session", "handleCallbacks", this.f756c.f698p, e3, new Object[0]);
        }
    }
}
