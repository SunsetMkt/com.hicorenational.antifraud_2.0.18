package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f8548a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte[] f8549b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f8550c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f8551d;

    r(k kVar, int i2, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f8551d = kVar;
        this.f8548a = i2;
        this.f8549b = bArr;
        this.f8550c = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f8548a != 200) {
            ALog.e(this.f8551d.d(), "drop frame len:" + this.f8549b.length + " frameType" + this.f8548a, new Object[0]);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f8551d.f8504e.a(this.f8549b, this.f8550c.getHost());
            com.taobao.accs.ut.a.d g2 = this.f8551d.f8504e.g();
            if (g2 != null) {
                g2.f8595c = String.valueOf(currentTimeMillis);
                g2.f8599g = this.f8551d.f8502c == 0 ? "service" : "inapp";
                g2.a();
            }
        } catch (Throwable th) {
            ALog.e(this.f8551d.d(), "onDataReceive ", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
