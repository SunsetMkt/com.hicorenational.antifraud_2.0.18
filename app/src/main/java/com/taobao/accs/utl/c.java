package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8640a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8641b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f8642c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f8643d;

    c(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.f8640a = accsDataListener;
        this.f8641b = str;
        this.f8642c = i2;
        this.f8643d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c2;
        AccsDataListener accsDataListener = this.f8640a;
        String str = this.f8641b;
        int i2 = this.f8642c;
        c2 = a.c(this.f8643d);
        accsDataListener.onUnbind(str, i2, c2);
    }
}
