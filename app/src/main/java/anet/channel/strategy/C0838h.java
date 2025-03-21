package anet.channel.strategy;

import anet.channel.AwcnConfig;
import anet.channel.entity.ConnType;
import anet.channel.p021e.C0774a;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.h */
/* loaded from: classes.dex */
class C0838h implements IStrategyFilter {

    /* renamed from: a */
    final /* synthetic */ C0837g f1102a;

    C0838h(C0837g c0837g) {
        this.f1102a = c0837g;
    }

    @Override // anet.channel.strategy.IStrategyFilter
    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        if (ConnType.QUIC.equals(str) || ConnType.QUIC_PLAIN.equals(str)) {
            ALog.m716i("awcn.StrategyCenter", "gquic strategy disabled", null, Constants.KEY_STRATEGY, iConnStrategy);
            return false;
        }
        boolean isHttp3Enable = AwcnConfig.isHttp3Enable();
        boolean m497b = C0774a.m497b();
        if ((isHttp3Enable && m497b) || (!ConnType.HTTP3.equals(str) && !ConnType.HTTP3_PLAIN.equals(str))) {
            return true;
        }
        ALog.m716i("awcn.StrategyCenter", "http3 strategy disabled", null, Constants.KEY_STRATEGY, iConnStrategy);
        return false;
    }
}
