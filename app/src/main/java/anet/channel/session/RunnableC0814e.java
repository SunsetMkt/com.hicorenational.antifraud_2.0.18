package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.entity.C0782b;
import anet.channel.request.Request;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.e */
/* loaded from: classes.dex */
class RunnableC0814e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Request f988a;

    /* renamed from: b */
    final /* synthetic */ C0813d f989b;

    RunnableC0814e(C0813d c0813d, Request request) {
        this.f989b = c0813d;
        this.f988a = request;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = C0811b.m602a(this.f988a, (RequestCb) null).f981a;
        if (i2 > 0) {
            this.f989b.notifyStatus(4, new C0782b(1));
        } else {
            this.f989b.handleCallbacks(256, new C0782b(256, i2, "Http connect fail"));
        }
    }
}
