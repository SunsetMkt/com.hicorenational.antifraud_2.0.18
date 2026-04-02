package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {
    final /* synthetic */ AccsDataListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f5901d;

    b(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.a = accsDataListener;
        this.f5899b = str;
        this.f5900c = i2;
        this.f5901d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onBind(this.f5899b, this.f5900c, a.c(this.f5901d));
    }
}
