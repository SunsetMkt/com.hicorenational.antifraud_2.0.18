package org.android.agoo.control;

import android.content.Intent;

/* compiled from: Taobao */
/* renamed from: org.android.agoo.control.h */
/* loaded from: classes2.dex */
class RunnableC6021h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f21496a;

    /* renamed from: b */
    final /* synthetic */ HandlerC6020g f21497b;

    RunnableC6021h(HandlerC6020g handlerC6020g, Intent intent) {
        this.f21497b = handlerC6020g;
        this.f21496a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21497b.f21495a.onHandleIntent(this.f21496a);
    }
}
