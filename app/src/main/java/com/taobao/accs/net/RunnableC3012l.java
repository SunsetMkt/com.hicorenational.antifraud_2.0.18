package com.taobao.accs.net;

import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3048p;
import java.util.UUID;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.l */
/* loaded from: classes2.dex */
class RunnableC3012l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3011k f9571a;

    RunnableC3012l(C3011k c3011k) {
        this.f9571a = c3011k;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j2;
        ALog.m9180d(this.f9571a.mo9100d(), "sendAccsHeartbeatMessage", new Object[0]);
        try {
            C3048p.a m9262a = new C3048p.a().m9262a("dataType", "pingreq");
            j2 = this.f9571a.f9560p;
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, m9262a.m9261a("timeInterval", Long.valueOf(j2)).m9263a().toString().getBytes("utf-8"), UUID.randomUUID().toString());
            accsRequest.setTarget("accs-iot");
            accsRequest.setTargetServiceName("sal");
            this.f9571a.mo9085a(Message.buildRequest(this.f9571a.f9524d, this.f9571a.mo9091b((String) null), this.f9571a.mo9100d(), this.f9571a.f9529i.getStoreId(), this.f9571a.f9524d.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
        } catch (Exception e2) {
            ALog.m9181e(this.f9571a.mo9100d(), "send accs heartbeat message", e2, new Object[0]);
        }
    }
}
