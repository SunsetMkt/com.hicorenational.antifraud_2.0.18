package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.g */
/* loaded from: classes2.dex */
class RunnableC3039g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccsDataListener f9731a;

    /* renamed from: b */
    final /* synthetic */ boolean f9732b;

    RunnableC3039g(AccsDataListener accsDataListener, boolean z) {
        this.f9731a = accsDataListener;
        this.f9732b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9731a.onAntiBrush(this.f9732b, null);
    }
}
