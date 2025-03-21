package anet.channel.strategy;

import java.util.Comparator;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.k */
/* loaded from: classes.dex */
class C0841k implements Comparator<IPConnStrategy> {

    /* renamed from: a */
    final /* synthetic */ StrategyList f1108a;

    C0841k(StrategyList strategyList) {
        this.f1108a = strategyList;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        Map map;
        Map map2;
        int i2;
        int i3;
        map = this.f1108a.f1058b;
        ConnHistoryItem connHistoryItem = (ConnHistoryItem) map.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
        map2 = this.f1108a.f1058b;
        ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) map2.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
        int m626a = connHistoryItem.m626a();
        int m626a2 = connHistoryItem2.m626a();
        if (m626a != m626a2) {
            return m626a - m626a2;
        }
        if (iPConnStrategy.f1036a != iPConnStrategy2.f1036a) {
            i2 = iPConnStrategy.f1036a;
            i3 = iPConnStrategy2.f1036a;
        } else {
            i2 = iPConnStrategy.protocol.isHttp;
            i3 = iPConnStrategy2.protocol.isHttp;
        }
        return i2 - i3;
    }
}
