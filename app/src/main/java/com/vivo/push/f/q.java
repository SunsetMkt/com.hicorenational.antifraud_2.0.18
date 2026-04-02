package com.vivo.push.f;

/* JADX INFO: compiled from: OnListTagReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class q implements Runnable {
    final /* synthetic */ com.vivo.push.b.m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f8530b;

    q(p pVar, com.vivo.push.b.m mVar) {
        this.f8530b = pVar;
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.f8530b;
        ((aa) pVar).f8506b.onListTags(((com.vivo.push.s) pVar).a, this.a.i(), this.a.d(), this.a.h());
    }
}
