package anet.channel.strategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.i */
/* loaded from: classes.dex */
class RunnableC0839i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0837g f1103a;

    RunnableC0839i(C0837g c0837g) {
        this.f1103a = c0837g;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m686a;
        m686a = this.f1103a.m686a();
        if (m686a) {
            return;
        }
        this.f1103a.f1098b.m647c();
    }
}
