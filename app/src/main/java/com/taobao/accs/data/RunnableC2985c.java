package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p199ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.c */
/* loaded from: classes2.dex */
class RunnableC2985c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2983a f9466a;

    RunnableC2985c(C2983a c2983a) {
        this.f9466a = c2983a;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        String str;
        Map map;
        String str2;
        int i3;
        synchronized (this.f9466a) {
            i2 = this.f9466a.f9462f;
            if (i2 == 0) {
                str = this.f9466a.f9458b;
                ALog.m9182e("AssembleMessage", "timeout", Constants.KEY_DATA_ID, str);
                this.f9466a.f9462f = 1;
                map = this.f9466a.f9464h;
                map.clear();
                str2 = this.f9466a.f9458b;
                i3 = this.f9466a.f9462f;
                AppMonitor.getInstance().commitStat(new AssembleMonitor(str2, String.valueOf(i3)));
            }
        }
    }
}
