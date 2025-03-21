package anet.channel.strategy;

import java.util.Comparator;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.o */
/* loaded from: classes.dex */
final class C0845o implements Comparator<StrategyCollection> {
    C0845o() {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        return strategyCollection.f1041b != strategyCollection2.f1041b ? (int) (strategyCollection.f1041b - strategyCollection2.f1041b) : strategyCollection.f1040a.compareTo(strategyCollection2.f1040a);
    }
}
