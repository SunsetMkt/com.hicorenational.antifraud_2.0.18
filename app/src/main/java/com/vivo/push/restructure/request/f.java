package com.vivo.push.restructure.request;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ e f8628b;

    f(e eVar, b bVar) {
        this.f8628b = eVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.a;
        if (bVar == null || bVar.b() == null) {
            return;
        }
        this.a.b().a(1003);
    }
}
