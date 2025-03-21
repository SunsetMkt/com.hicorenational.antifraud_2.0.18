package com.vivo.push.restructure.request;

/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.f */
/* loaded from: classes2.dex */
final class RunnableC3970f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3966b f14184a;

    /* renamed from: b */
    final /* synthetic */ HandlerC3969e f14185b;

    RunnableC3970f(HandlerC3969e handlerC3969e, C3966b c3966b) {
        this.f14185b = handlerC3969e;
        this.f14184a = c3966b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3966b c3966b = this.f14184a;
        if (c3966b == null || c3966b.m13152b() == null) {
            return;
        }
        this.f14184a.m13152b().mo12938a(1003);
    }
}
