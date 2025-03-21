package com.taobao.accs.data;

import com.taobao.accs.p199ut.monitor.TrafficsMonitor;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.e */
/* loaded from: classes2.dex */
class RunnableC2987e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ TrafficsMonitor.C3032a f9483a;

    /* renamed from: b */
    final /* synthetic */ C2986d f9484b;

    RunnableC2987e(C2986d c2986d, TrafficsMonitor.C3032a c3032a) {
        this.f9484b = c2986d;
        this.f9483a = c3032a;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f9484b.f9469c;
        if (trafficsMonitor != null) {
            trafficsMonitor.m9179a(this.f9483a);
        }
    }
}
