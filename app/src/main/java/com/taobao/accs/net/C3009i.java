package com.taobao.accs.net;

import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.i */
/* loaded from: classes2.dex */
class C3009i implements HttpDispatcher.IDispatchEventListener {

    /* renamed from: a */
    final /* synthetic */ C3008h f9557a;

    C3009i(C3008h c3008h) {
        this.f9557a = c3008h;
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        ThreadPoolExecutorFactory.schedule(new RunnableC3010j(this), 2000L, TimeUnit.MILLISECONDS);
    }
}
