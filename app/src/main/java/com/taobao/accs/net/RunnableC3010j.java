package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.j */
/* loaded from: classes2.dex */
class RunnableC3010j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3009i f9558a;

    RunnableC3010j(C3009i c3009i) {
        this.f9558a = c3009i;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
