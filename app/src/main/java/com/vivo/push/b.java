package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: compiled from: BasePushClient.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements Runnable {
    final /* synthetic */ IPushQueryActionListener a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ a f8440b;

    b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.f8440b = aVar;
        this.a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(strB);
        }
    }
}
