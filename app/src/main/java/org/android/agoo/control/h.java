package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ g f12882b;

    h(g gVar, Intent intent) {
        this.f12882b = gVar;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12882b.a.onHandleIntent(this.a);
    }
}
