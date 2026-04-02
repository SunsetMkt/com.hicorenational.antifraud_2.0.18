package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {
    final /* synthetic */ NetPerformanceMonitor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f5912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f5913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f5914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f5915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Intent f5916g;

    e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, byte[] bArr, Intent intent) {
        this.a = netPerformanceMonitor;
        this.f5911b = str;
        this.f5912c = str2;
        this.f5913d = accsDataListener;
        this.f5914e = i2;
        this.f5915f = bArr;
        this.f5916g = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f5911b)) {
            ALog.e(a.TAG, "onResponse start dataId:" + this.f5912c + " serviceId:" + this.f5911b, new Object[0]);
        }
        this.f5913d.onResponse(this.f5911b, this.f5912c, this.f5914e, this.f5915f, a.c(this.f5916g));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f5911b)) {
            ALog.e(a.TAG, "onResponse end dataId:" + this.f5912c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.a);
    }
}
