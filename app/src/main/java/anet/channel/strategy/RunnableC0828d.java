package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.util.ALog;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.d */
/* loaded from: classes.dex */
class RunnableC0828d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1077a;

    /* renamed from: b */
    final /* synthetic */ StrategyInfoHolder f1078b;

    RunnableC0828d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f1078b = strategyInfoHolder;
        this.f1077a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.m716i("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
            long currentTimeMillis = System.currentTimeMillis();
            if (AwcnConfig.isAsyncLoadStrategyEnable()) {
                ALog.m716i("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                if (!TextUtils.isEmpty(this.f1077a)) {
                    this.f1078b.m645a(this.f1077a, true);
                }
                StrategyConfig strategyConfig = (StrategyConfig) C0843m.m692a("StrategyConfig", null);
                if (strategyConfig != null) {
                    strategyConfig.m638b();
                    strategyConfig.m635a(this.f1078b);
                    synchronized (this.f1078b) {
                        this.f1078b.f1052b = strategyConfig;
                    }
                }
            }
            File[] m697b = C0843m.m697b();
            if (m697b == null) {
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < m697b.length && i2 < 2; i3++) {
                File file = m697b[i3];
                if (!file.isDirectory()) {
                    String name = file.getName();
                    if (!name.equals(this.f1077a) && !name.startsWith("StrategyConfig")) {
                        this.f1078b.m645a(name, false);
                        i2++;
                    }
                }
            }
            ALog.m716i("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception unused) {
        }
    }
}
