package com.taobao.accs.data;

import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class i implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Intent f5781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f5782d;

    i(g gVar, String str, String str2, Intent intent) {
        this.f5782d = gVar;
        this.a = str;
        this.f5780b = str2;
        this.f5781c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (g.a == null || !g.a.contains(this.a)) {
            return;
        }
        ALog.e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.a, Constants.KEY_SERVICE_ID, this.f5780b);
        g.a.remove(this.a);
        com.taobao.accs.utl.k.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "timeout", "pkg:" + this.f5781c.getPackage());
    }
}
