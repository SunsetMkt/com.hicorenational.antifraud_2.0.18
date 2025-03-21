package anet.channel.strategy;

import java.util.Comparator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class k implements Comparator<IPConnStrategy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StrategyList f1988a;

    k(StrategyList strategyList) {
        this.f1988a = strategyList;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        Map map;
        Map map2;
        int i2;
        int i3;
        map = this.f1988a.f1938b;
        ConnHistoryItem connHistoryItem = (ConnHistoryItem) map.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
        map2 = this.f1988a.f1938b;
        ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) map2.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
        int a2 = connHistoryItem.a();
        int a3 = connHistoryItem2.a();
        if (a2 != a3) {
            return a2 - a3;
        }
        if (iPConnStrategy.f1917a != iPConnStrategy2.f1917a) {
            i2 = iPConnStrategy.f1917a;
            i3 = iPConnStrategy2.f1917a;
        } else {
            i2 = iPConnStrategy.protocol.isHttp;
            i3 = iPConnStrategy2.protocol.isHttp;
        }
        return i2 - i3;
    }
}
