package com.vivo.push.sdk;

import com.vivo.push.ab;
import com.vivo.push.m;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: CommandWorker.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements Runnable {
    final /* synthetic */ com.vivo.push.restructure.a.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f8636b;

    b(a aVar, com.vivo.push.restructure.a.a aVar2) {
        this.f8636b = aVar;
        this.a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.a.j())));
        m.a().a(((ab) this.f8636b).a);
        com.vivo.push.restructure.a.a().d().a(this.a);
    }
}
