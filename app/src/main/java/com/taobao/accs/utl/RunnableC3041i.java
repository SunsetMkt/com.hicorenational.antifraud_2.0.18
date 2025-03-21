package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.i */
/* loaded from: classes2.dex */
class RunnableC3041i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccsDataListener f9737a;

    /* renamed from: b */
    final /* synthetic */ String f9738b;

    /* renamed from: c */
    final /* synthetic */ boolean f9739c;

    /* renamed from: d */
    final /* synthetic */ boolean f9740d;

    /* renamed from: e */
    final /* synthetic */ int f9741e;

    /* renamed from: f */
    final /* synthetic */ String f9742f;

    RunnableC3041i(AccsDataListener accsDataListener, String str, boolean z, boolean z2, int i2, String str2) {
        this.f9737a = accsDataListener;
        this.f9738b = str;
        this.f9739c = z;
        this.f9740d = z2;
        this.f9741e = i2;
        this.f9742f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9737a.onDisconnected(new TaoBaseService.ConnectInfo(this.f9738b, this.f9739c, this.f9740d, this.f9741e, this.f9742f));
    }
}
