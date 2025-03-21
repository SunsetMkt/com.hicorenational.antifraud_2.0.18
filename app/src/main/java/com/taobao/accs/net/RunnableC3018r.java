package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.taobao.accs.p199ut.p200a.C3029d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.r */
/* loaded from: classes2.dex */
class RunnableC3018r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f9582a;

    /* renamed from: b */
    final /* synthetic */ byte[] f9583b;

    /* renamed from: c */
    final /* synthetic */ TnetSpdySession f9584c;

    /* renamed from: d */
    final /* synthetic */ C3011k f9585d;

    RunnableC3018r(C3011k c3011k, int i2, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f9585d = c3011k;
        this.f9582a = i2;
        this.f9583b = bArr;
        this.f9584c = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9582a != 200) {
            ALog.m9182e(this.f9585d.mo9100d(), "drop frame len:" + this.f9583b.length + " frameType" + this.f9582a, new Object[0]);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f9585d.f9525e.m9031a(this.f9583b, this.f9584c.getHost());
            C3029d m9039g = this.f9585d.f9525e.m9039g();
            if (m9039g != null) {
                m9039g.f9656c = String.valueOf(currentTimeMillis);
                m9039g.f9660g = this.f9585d.f9523c == 0 ? "service" : "inapp";
                m9039g.m9173a();
            }
        } catch (Throwable th) {
            ALog.m9181e(this.f9585d.mo9100d(), "onDataReceive ", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.m9198a(th));
        }
    }
}
