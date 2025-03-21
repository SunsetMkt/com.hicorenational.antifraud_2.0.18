package anet.channel.p021e;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.b */
/* loaded from: classes.dex */
final class C0775b implements IStrategyFilter {
    C0775b() {
    }

    @Override // anet.channel.strategy.IStrategyFilter
    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        return ConnType.HTTP3.equals(str) || ConnType.HTTP3_PLAIN.equals(str);
    }
}
