package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class i implements Runnable {
    final /* synthetic */ AccsDataListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f5927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f5928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f5929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f5930f;

    i(AccsDataListener accsDataListener, String str, boolean z, boolean z2, int i2, String str2) {
        this.a = accsDataListener;
        this.f5926b = str;
        this.f5927c = z;
        this.f5928d = z2;
        this.f5929e = i2;
        this.f5930f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onDisconnected(new TaoBaseService.ConnectInfo(this.f5926b, this.f5927c, this.f5928d, this.f5929e, this.f5930f));
    }
}
