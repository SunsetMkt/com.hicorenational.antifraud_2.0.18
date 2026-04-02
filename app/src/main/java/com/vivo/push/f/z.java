package com.vivo.push.f;

/* JADX INFO: compiled from: OnPublishReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class z implements Runnable {
    final /* synthetic */ com.vivo.push.b.r a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f8534b;

    z(y yVar, com.vivo.push.b.r rVar) {
        this.f8534b = yVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.f8534b;
        ((aa) yVar).f8506b.onPublish(((com.vivo.push.s) yVar).a, this.a.i(), this.a.h());
    }
}
