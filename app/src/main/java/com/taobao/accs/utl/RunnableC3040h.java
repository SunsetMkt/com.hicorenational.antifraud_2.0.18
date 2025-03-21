package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.h */
/* loaded from: classes2.dex */
class RunnableC3040h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccsDataListener f9733a;

    /* renamed from: b */
    final /* synthetic */ String f9734b;

    /* renamed from: c */
    final /* synthetic */ boolean f9735c;

    /* renamed from: d */
    final /* synthetic */ boolean f9736d;

    RunnableC3040h(AccsDataListener accsDataListener, String str, boolean z, boolean z2) {
        this.f9733a = accsDataListener;
        this.f9734b = str;
        this.f9735c = z;
        this.f9736d = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9733a.onConnected(new TaoBaseService.ConnectInfo(this.f9734b, this.f9735c, this.f9736d));
    }
}
