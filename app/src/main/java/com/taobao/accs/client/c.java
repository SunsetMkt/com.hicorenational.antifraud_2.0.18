package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class c implements Runnable {
    final /* synthetic */ GlobalClientInfo a;

    c(GlobalClientInfo globalClientInfo) {
        this.a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.f5717c = UtilityImpl.m(GlobalClientInfo.a);
    }
}
