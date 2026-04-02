package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f5779b;

    h(Context context, Intent intent) {
        this.a = context;
        this.f5779b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        g.a().b(this.a, this.f5779b);
    }
}
