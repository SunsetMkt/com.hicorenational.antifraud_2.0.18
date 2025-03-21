package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f8449a;

    c(a aVar) {
        this.f8449a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        String str;
        Map map;
        String str2;
        int i3;
        synchronized (this.f8449a) {
            i2 = this.f8449a.f8445f;
            if (i2 == 0) {
                str = this.f8449a.f8441b;
                ALog.e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, str);
                this.f8449a.f8445f = 1;
                map = this.f8449a.f8447h;
                map.clear();
                str2 = this.f8449a.f8441b;
                i3 = this.f8449a.f8445f;
                AppMonitor.getInstance().commitStat(new AssembleMonitor(str2, String.valueOf(i3)));
            }
        }
    }
}
