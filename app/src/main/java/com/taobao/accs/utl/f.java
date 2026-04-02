package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class f implements Runnable {
    final /* synthetic */ NetPerformanceMonitor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f5918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f5919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f5920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f5921f;

    f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, Intent intent) {
        this.a = netPerformanceMonitor;
        this.f5917b = str;
        this.f5918c = str2;
        this.f5919d = accsDataListener;
        this.f5920e = i2;
        this.f5921f = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f5917b)) {
            ALog.e(a.TAG, "onSendData start dataId:" + this.f5918c + " serviceId:" + this.f5917b, new Object[0]);
        }
        this.f5919d.onSendData(this.f5917b, this.f5918c, this.f5920e, a.c(this.f5921f));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f5917b)) {
            ALog.e(a.TAG, "onSendData end dataId:" + this.f5918c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.a);
    }
}
