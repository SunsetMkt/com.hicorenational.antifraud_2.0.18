package com.taobao.accs.client;

import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.client.c */
/* loaded from: classes.dex */
class RunnableC2980c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ GlobalClientInfo f9415a;

    RunnableC2980c(GlobalClientInfo globalClientInfo) {
        this.f9415a = globalClientInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlobalClientInfo.f9388c = UtilityImpl.m9231m(GlobalClientInfo.f9386a);
    }
}
