package anet.channel.strategy;

import anet.channel.strategy.C0842l;
import anet.channel.strategy.StrategyList;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.j */
/* loaded from: classes.dex */
class C0840j implements StrategyList.Predicate<IPConnStrategy> {

    /* renamed from: a */
    final /* synthetic */ C0842l.a f1104a;

    /* renamed from: b */
    final /* synthetic */ String f1105b;

    /* renamed from: c */
    final /* synthetic */ ConnProtocol f1106c;

    /* renamed from: d */
    final /* synthetic */ StrategyList f1107d;

    C0840j(StrategyList strategyList, C0842l.a aVar, String str, ConnProtocol connProtocol) {
        this.f1107d = strategyList;
        this.f1104a = aVar;
        this.f1105b = str;
        this.f1106c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.f1104a.f1109a && iPConnStrategy.getIp().equals(this.f1105b) && iPConnStrategy.protocol.equals(this.f1106c);
    }
}
