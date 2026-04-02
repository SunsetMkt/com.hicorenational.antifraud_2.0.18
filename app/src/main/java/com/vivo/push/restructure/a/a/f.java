package com.vivo.push.restructure.a.a;

import com.vivo.push.PushClient;

/* JADX INFO: compiled from: DispatchNode.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ String f8592b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ e f8593c;

    f(e eVar, int i2, String str) {
        this.f8593c = eVar;
        this.a = i2;
        this.f8592b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.a;
        if (i2 == 3) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).unBindAlias(this.f8592b, null);
        } else if (i2 == 4) {
            PushClient.getInstance(com.vivo.push.restructure.a.a().b()).delTopic(this.f8592b, null);
        }
    }
}
