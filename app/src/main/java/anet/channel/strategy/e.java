package anet.channel.strategy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ StrategyInfoHolder f1597b;

    e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f1597b = strategyInfoHolder;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1597b.a(this.a, true);
    }
}
