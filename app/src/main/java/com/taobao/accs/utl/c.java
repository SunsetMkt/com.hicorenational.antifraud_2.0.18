package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ AccsDataListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f5902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f5903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f5904d;

    c(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.a = accsDataListener;
        this.f5902b = str;
        this.f5903c = i2;
        this.f5904d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onUnbind(this.f5902b, this.f5903c, a.c(this.f5904d));
    }
}
