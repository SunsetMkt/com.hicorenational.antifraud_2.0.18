package com.vivo.push.util;

import java.util.List;

/* JADX INFO: compiled from: ImageDownTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class q implements Runnable {
    final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f8692b;

    q(p pVar, List list) {
        this.f8692b = pVar;
        this.a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f8692b.f8686b != null) {
            ad.b().a("com.vivo.push.notify_key", this.f8692b.f8687c);
            NotifyAdapterUtil.pushNotification(this.f8692b.a, this.a, this.f8692b.f8686b, this.f8692b.f8687c, this.f8692b.f8689e, this.f8692b.f8690f, this.f8692b.f8691g);
        }
    }
}
