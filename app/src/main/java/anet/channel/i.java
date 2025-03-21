package anet.channel;

import android.content.Context;
import anet.channel.SessionRequest;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Session f1799a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest.a f1800b;

    i(SessionRequest.a aVar, Session session) {
        this.f1800b = aVar;
        this.f1799a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        try {
            SessionRequest sessionRequest = SessionRequest.this;
            context = this.f1800b.f1661c;
            sessionRequest.a(context, this.f1799a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.f1647a.f1638c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
