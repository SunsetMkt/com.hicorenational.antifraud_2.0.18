package com.taobao.accs.data;

import com.taobao.accs.p199ut.monitor.TrafficsMonitor;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.f */
/* loaded from: classes2.dex */
class RunnableC2988f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2986d f9485a;

    RunnableC2988f(C2986d c2986d) {
        this.f9485a = c2986d;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f9485a.f9469c;
        if (trafficsMonitor != null) {
            trafficsMonitor.m9178a();
        }
    }
}
