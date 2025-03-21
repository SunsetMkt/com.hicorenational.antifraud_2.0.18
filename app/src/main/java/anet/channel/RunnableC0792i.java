package anet.channel;

import android.content.Context;
import anet.channel.SessionRequest;
import anet.channel.util.C0863i;

/* compiled from: Taobao */
/* renamed from: anet.channel.i */
/* loaded from: classes.dex */
class RunnableC0792i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Session f873a;

    /* renamed from: b */
    final /* synthetic */ SessionRequest.C0739a f874b;

    RunnableC0792i(SessionRequest.C0739a c0739a, Session session) {
        this.f874b = c0739a;
        this.f873a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        try {
            SessionRequest sessionRequest = SessionRequest.this;
            context = this.f874b.f735c;
            sessionRequest.m431a(context, this.f873a.getConnType().getType(), C0863i.m740a(SessionRequest.this.f721a.f712c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
