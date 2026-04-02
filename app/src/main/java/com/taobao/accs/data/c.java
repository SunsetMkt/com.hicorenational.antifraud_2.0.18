package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a) {
            if (this.a.f5761f == 0) {
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, this.a.f5757b);
                this.a.f5761f = 1;
                this.a.f5763h.clear();
                AppMonitor.getInstance().commitStat(new AssembleMonitor(this.a.f5757b, String.valueOf(this.a.f5761f)));
            }
        }
    }
}
