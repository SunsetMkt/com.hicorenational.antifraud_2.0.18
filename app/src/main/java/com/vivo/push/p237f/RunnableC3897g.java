package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.f.g */
/* loaded from: classes2.dex */
final class RunnableC3897g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UPSNotificationMessage f14026a;

    /* renamed from: b */
    final /* synthetic */ C3895e f14027b;

    RunnableC3897g(C3895e c3895e, UPSNotificationMessage uPSNotificationMessage) {
        this.f14027b = c3895e;
        this.f14026a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3895e c3895e = this.f14027b;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3895e).f14009b;
        context = ((AbstractRunnableC3971s) c3895e).f14186a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f14026a);
    }
}
