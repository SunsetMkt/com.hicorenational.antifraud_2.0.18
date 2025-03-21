package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.f */
/* loaded from: classes2.dex */
class RunnableC3038f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetPerformanceMonitor f9725a;

    /* renamed from: b */
    final /* synthetic */ String f9726b;

    /* renamed from: c */
    final /* synthetic */ String f9727c;

    /* renamed from: d */
    final /* synthetic */ AccsDataListener f9728d;

    /* renamed from: e */
    final /* synthetic */ int f9729e;

    /* renamed from: f */
    final /* synthetic */ Intent f9730f;

    RunnableC3038f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, Intent intent) {
        this.f9725a = netPerformanceMonitor;
        this.f9726b = str;
        this.f9727c = str2;
        this.f9728d = accsDataListener;
        this.f9729e = i2;
        this.f9730f = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo m9241c;
        NetPerformanceMonitor netPerformanceMonitor = this.f9725a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9726b)) {
            ALog.m9182e(C3033a.TAG, "onSendData start dataId:" + this.f9727c + " serviceId:" + this.f9726b, new Object[0]);
        }
        AccsDataListener accsDataListener = this.f9728d;
        String str = this.f9726b;
        String str2 = this.f9727c;
        int i2 = this.f9729e;
        m9241c = C3033a.m9241c(this.f9730f);
        accsDataListener.onSendData(str, str2, i2, m9241c);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9726b)) {
            ALog.m9182e(C3033a.TAG, "onSendData end dataId:" + this.f9727c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f9725a);
    }
}
