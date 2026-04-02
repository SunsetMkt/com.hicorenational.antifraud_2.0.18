package anet.channel;

import anet.channel.SessionRequest;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ Session a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SessionRequest.a f1466b;

    i(SessionRequest.a aVar, Session session) {
        this.f1466b = aVar;
        this.a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SessionRequest.this.a(this.f1466b.f1379c, this.a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.a.f1359c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
