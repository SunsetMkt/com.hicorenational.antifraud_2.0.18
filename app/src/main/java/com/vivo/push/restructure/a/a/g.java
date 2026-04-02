package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: IPCNode.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends a<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8594b;

    public g(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("IPCNode", aVar, iVar);
        this.f8594b = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jD = aVar.d();
        if (jD <= 0 || jElapsedRealtime <= jD) {
            return;
        }
        this.f8594b = jElapsedRealtime - jD;
    }

    @Override // com.vivo.push.restructure.a.a.a
    protected final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.f8594b);
        return super.b();
    }
}
