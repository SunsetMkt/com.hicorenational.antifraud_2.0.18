package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.f5802e.c()) {
            ALog.e(this.a.d(), "receive ping time out! ", new Object[0]);
            g.a(this.a.f5801d).c();
            this.a.a("", false, "receive ping timeout");
            this.a.f5802e.a(-12);
        }
    }
}
