package com.vivo.push.f;

/* JADX INFO: compiled from: OnUnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class af implements Runnable {
    final /* synthetic */ com.vivo.push.b.i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f8516b;

    af(ae aeVar, com.vivo.push.b.i iVar) {
        this.f8516b = aeVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ae aeVar = this.f8516b;
        ((aa) aeVar).f8506b.onUnBind(((com.vivo.push.s) aeVar).a, this.a.i(), this.a.d());
    }
}
