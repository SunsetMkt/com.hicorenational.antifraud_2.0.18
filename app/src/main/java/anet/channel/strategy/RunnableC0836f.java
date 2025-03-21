package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.f */
/* loaded from: classes.dex */
class RunnableC0836f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f1095a;

    /* renamed from: b */
    final /* synthetic */ StrategyInfoHolder.LruStrategyMap f1096b;

    RunnableC0836f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.f1096b = lruStrategyMap;
        this.f1095a = entry;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.f1095a.getValue();
        if (strategyTable.f1065d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.f1062a;
            C0843m.m695a((Serializable) this.f1095a.getValue(), strategyTable.f1062a, strategyStatObject);
            strategyTable.f1065d = false;
        }
    }
}
