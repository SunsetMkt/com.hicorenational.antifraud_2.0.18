package com.taobao.accs.net;

import com.taobao.accs.ACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.p;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f8537a;

    l(k kVar) {
        this.f8537a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j2;
        ALog.d(this.f8537a.d(), "sendAccsHeartbeatMessage", new Object[0]);
        try {
            p.a a2 = new p.a().a("dataType", "pingreq");
            j2 = this.f8537a.p;
            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(null, null, a2.a("timeInterval", Long.valueOf(j2)).a().toString().getBytes("utf-8"), UUID.randomUUID().toString());
            accsRequest.setTarget("accs-iot");
            accsRequest.setTargetServiceName("sal");
            this.f8537a.a(Message.buildRequest(this.f8537a.f8503d, this.f8537a.b((String) null), this.f8537a.d(), this.f8537a.f8508i.getStoreId(), this.f8537a.f8503d.getPackageName(), Constants.TARGET_SERVICE, accsRequest, true), true);
        } catch (Exception e2) {
            ALog.e(this.f8537a.d(), "send accs heartbeat message", e2, new Object[0]);
        }
    }
}
