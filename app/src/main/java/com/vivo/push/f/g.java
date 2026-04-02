package com.vivo.push.f;

import com.vivo.push.model.UPSNotificationMessage;

/* JADX INFO: compiled from: NotifyOpenClientClickTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ e f8519b;

    g(e eVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f8519b = eVar;
        this.a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = this.f8519b;
        ((aa) eVar).f8506b.onNotificationMessageClicked(((com.vivo.push.s) eVar).a, this.a);
    }
}
