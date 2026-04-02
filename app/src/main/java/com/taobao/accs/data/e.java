package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {
    final /* synthetic */ TrafficsMonitor.a a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ d f5777b;

    e(d dVar, TrafficsMonitor.a aVar) {
        this.f5777b = dVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f5777b.f5765c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.a);
        }
    }
}
