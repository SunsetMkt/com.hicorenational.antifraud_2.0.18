package com.taobao.accs.net;

import anet.channel.session.TnetSpdySession;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class r implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte[] f5832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TnetSpdySession f5833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f5834d;

    r(k kVar, int i2, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.f5834d = kVar;
        this.a = i2;
        this.f5832b = bArr;
        this.f5833c = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != 200) {
            ALog.e(this.f5834d.d(), "drop frame len:" + this.f5832b.length + " frameType" + this.a, new Object[0]);
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f5834d.f5802e.a(this.f5832b, this.f5833c.getHost());
            com.taobao.accs.ut.a.d dVarG = this.f5834d.f5802e.g();
            if (dVarG != null) {
                dVarG.f5867c = String.valueOf(jCurrentTimeMillis);
                dVarG.f5871g = this.f5834d.f5800c == 0 ? "service" : "inapp";
                dVarG.a();
            }
        } catch (Throwable th) {
            ALog.e(this.f5834d.d(), "onDataReceive ", th, new Object[0]);
            UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.a(th));
        }
    }
}
