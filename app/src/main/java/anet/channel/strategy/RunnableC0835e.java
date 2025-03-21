package anet.channel.strategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.e */
/* loaded from: classes.dex */
class RunnableC0835e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1093a;

    /* renamed from: b */
    final /* synthetic */ StrategyInfoHolder f1094b;

    RunnableC0835e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f1094b = strategyInfoHolder;
        this.f1093a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1094b.m645a(this.f1093a, true);
    }
}
