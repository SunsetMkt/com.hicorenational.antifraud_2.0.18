package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f12051a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f12052b;

    g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f12052b = eVar;
        this.f12051a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        e eVar = this.f12052b;
        PushMessageCallback pushMessageCallback = ((aa) eVar).f12034b;
        context = ((com.vivo.push.s) eVar).f12207a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f12051a);
    }
}
