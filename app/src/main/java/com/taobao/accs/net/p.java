package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class p implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f5830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ k f5831c;

    p(k kVar, String str, boolean z) {
        this.f5831c = kVar;
        this.a = str;
        this.f5830b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f5831c.f5802e.a(this.a);
        if (messageA != null) {
            this.f5831c.f5802e.a(messageA, -9);
            this.f5831c.a(this.a, this.f5830b, "receive data time out");
            ALog.e(this.f5831c.d(), this.a + "-> receive data time out!", new Object[0]);
        }
    }
}
