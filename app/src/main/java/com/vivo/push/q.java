package com.vivo.push;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class q implements Runnable {
    final /* synthetic */ com.vivo.push.b.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f8576c;

    q(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f8576c = mVar;
        this.a = bVar;
        this.f8575b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8576c.a(this.a);
        this.f8576c.c(this.f8575b);
    }
}
