package com.taobao.accs.utl;

import android.content.Intent;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.b */
/* loaded from: classes2.dex */
class RunnableC3034b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AccsDataListener f9703a;

    /* renamed from: b */
    final /* synthetic */ String f9704b;

    /* renamed from: c */
    final /* synthetic */ int f9705c;

    /* renamed from: d */
    final /* synthetic */ Intent f9706d;

    RunnableC3034b(AccsDataListener accsDataListener, String str, int i2, Intent intent) {
        this.f9703a = accsDataListener;
        this.f9704b = str;
        this.f9705c = i2;
        this.f9706d = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        TaoBaseService.ExtraInfo m9241c;
        AccsDataListener accsDataListener = this.f9703a;
        String str = this.f9704b;
        int i2 = this.f9705c;
        m9241c = C3033a.m9241c(this.f9706d);
        accsDataListener.onBind(str, i2, m9241c);
    }
}
