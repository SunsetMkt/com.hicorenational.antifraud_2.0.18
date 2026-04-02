package com.vivo.push;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class o implements Runnable {
    final /* synthetic */ com.vivo.push.b.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f8574c;

    o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.f8574c = mVar;
        this.a = bVar;
        this.f8573b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8574c.a(this.a);
        this.f8574c.c(this.f8573b);
    }
}
