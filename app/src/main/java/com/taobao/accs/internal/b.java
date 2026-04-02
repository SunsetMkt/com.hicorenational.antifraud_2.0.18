package com.taobao.accs.internal;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {
    final /* synthetic */ com.taobao.accs.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ACCSManagerImpl f5795b;

    b(ACCSManagerImpl aCCSManagerImpl, com.taobao.accs.c cVar) {
        this.f5795b = aCCSManagerImpl;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.accs.c cVar = this.a;
        if (cVar != null) {
            cVar.a(true, false);
        }
    }
}
