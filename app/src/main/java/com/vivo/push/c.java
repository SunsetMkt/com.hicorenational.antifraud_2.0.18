package com.vivo.push;

/* JADX INFO: compiled from: BasePushClient.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements Runnable {
    final /* synthetic */ IPushActionListener a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ a f8474b;

    c(a aVar, IPushActionListener iPushActionListener) {
        this.f8474b = aVar;
        this.a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iA = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(iA);
        }
    }
}
