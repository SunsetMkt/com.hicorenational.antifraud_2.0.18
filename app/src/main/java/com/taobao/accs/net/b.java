package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f5812c;

    b(a aVar, String str, boolean z) {
        this.f5812c = aVar;
        this.a = str;
        this.f5811b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f5812c.f5802e.a(this.a);
        if (messageA != null) {
            this.f5812c.f5802e.a(messageA, -9);
            this.f5812c.a(this.a, this.f5811b, "receive data time out");
            ALog.e(this.f5812c.d(), this.a + "-> receive data time out!", new Object[0]);
        }
    }
}
