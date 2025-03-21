package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.data.h */
/* loaded from: classes2.dex */
class RunnableC2990h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f9488a;

    /* renamed from: b */
    final /* synthetic */ Intent f9489b;

    RunnableC2990h(Context context, Intent intent) {
        this.f9488a = context;
        this.f9489b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2989g.m9041a().m9052b(this.f9488a, this.f9489b);
    }
}
