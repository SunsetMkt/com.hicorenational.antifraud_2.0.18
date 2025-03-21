package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.p199ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.e */
/* loaded from: classes2.dex */
class RunnableC3037e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetPerformanceMonitor f9718a;

    /* renamed from: b */
    final /* synthetic */ String f9719b;

    /* renamed from: c */
    final /* synthetic */ String f9720c;

    /* renamed from: d */
    final /* synthetic */ AccsDataListener f9721d;

    /* renamed from: e */
    final /* synthetic */ int f9722e;

    /* renamed from: f */
    final /* synthetic */ byte[] f9723f;

    /* renamed from: g */
    final /* synthetic */ Intent f9724g;

    RunnableC3037e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, byte[] bArr, Intent intent) {
        this.f9718a = netPerformanceMonitor;
        this.f9719b = str;
        this.f9720c = str2;
        this.f9721d = accsDataListener;
        this.f9722e = i2;
        this.f9723f = bArr;
        this.f9724g = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo m9241c;
        NetPerformanceMonitor netPerformanceMonitor = this.f9718a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9719b)) {
            ALog.m9182e(C3033a.TAG, "onResponse start dataId:" + this.f9720c + " serviceId:" + this.f9719b, new Object[0]);
        }
        AccsDataListener accsDataListener = this.f9721d;
        String str = this.f9719b;
        String str2 = this.f9720c;
        int i2 = this.f9722e;
        byte[] bArr = this.f9723f;
        m9241c = C3033a.m9241c(this.f9724g);
        accsDataListener.onResponse(str, str2, i2, bArr, m9241c);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.f9719b)) {
            ALog.m9182e(C3033a.TAG, "onResponse end dataId:" + this.f9720c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.f9718a);
    }
}
