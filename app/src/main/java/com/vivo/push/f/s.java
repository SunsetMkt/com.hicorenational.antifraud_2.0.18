package com.vivo.push.f;

/* JADX INFO: compiled from: OnLogReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class s implements Runnable {
    final /* synthetic */ com.vivo.push.b.n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f8531b;

    s(r rVar, com.vivo.push.b.n nVar) {
        this.f8531b = rVar;
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.f8531b;
        ((aa) rVar).f8506b.onLog(((com.vivo.push.s) rVar).a, this.a.d(), this.a.e(), this.a.f());
    }
}
