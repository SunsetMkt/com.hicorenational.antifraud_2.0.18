package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f8636a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8637b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f8638c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f8639d;

    b(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.f8636a = accsDataListener;
        this.f8637b = str;
        this.f8638c = i2;
        this.f8639d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo c2;
        AccsDataListener accsDataListener = this.f8636a;
        String str = this.f8637b;
        int i2 = this.f8638c;
        c2 = a.c(this.f8639d);
        accsDataListener.onBind(str, i2, c2);
    }
}
