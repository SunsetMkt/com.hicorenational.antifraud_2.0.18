package org.android.agoo.control;

import android.content.Intent;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.k */
/* loaded from: classes2.dex */
class RunnableC6024k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f21500a;

    /* renamed from: b */
    final /* synthetic */ BaseIntentService f21501b;

    RunnableC6024k(BaseIntentService baseIntentService, Intent intent) {
        this.f21501b = baseIntentService;
        this.f21500a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21501b.onHandleIntent(this.f21500a);
    }
}
