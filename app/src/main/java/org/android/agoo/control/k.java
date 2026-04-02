package org.android.agoo.control;

import android.content.Intent;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class k implements Runnable {
    final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseIntentService f12883b;

    k(BaseIntentService baseIntentService, Intent intent) {
        this.f12883b = baseIntentService;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12883b.onHandleIntent(this.a);
    }
}
