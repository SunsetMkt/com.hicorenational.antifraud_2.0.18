package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.c */
/* loaded from: classes2.dex */
class RunnableC3035c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccsDataListener f9707a;

    /* renamed from: b */
    final /* synthetic */ String f9708b;

    /* renamed from: c */
    final /* synthetic */ int f9709c;

    /* renamed from: d */
    final /* synthetic */ Intent f9710d;

    RunnableC3035c(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.f9707a = accsDataListener;
        this.f9708b = str;
        this.f9709c = i2;
        this.f9710d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo m9241c;
        AccsDataListener accsDataListener = this.f9707a;
        String str = this.f9708b;
        int i2 = this.f9709c;
        m9241c = C3033a.m9241c(this.f9710d);
        accsDataListener.onUnbind(str, i2, m9241c);
    }
}
