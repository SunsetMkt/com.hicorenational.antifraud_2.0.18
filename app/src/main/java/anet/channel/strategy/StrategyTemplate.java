package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class StrategyTemplate {
    Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.strategy.StrategyTemplate$a */
    static class C0824a {

        /* renamed from: a */
        static StrategyTemplate f1068a = new StrategyTemplate();

        C0824a() {
        }
    }

    public static StrategyTemplate getInstance() {
        return C0824a.f1068a;
    }

    public ConnProtocol getConnProtocol(String str) {
        return this.templateMap.get(str);
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
            try {
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                if (strategyCenter instanceof C0837g) {
                    ((C0837g) strategyCenter).f1098b.f1053c.m664a(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
