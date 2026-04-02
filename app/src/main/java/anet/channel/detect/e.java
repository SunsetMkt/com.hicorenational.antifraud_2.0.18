package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements IStrategyListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable() || (cVarArr = dVar.f1626c) == null || cVarArr.length == 0) {
            return;
        }
        synchronized (this.a.a) {
            for (int i2 = 0; i2 < dVar.f1626c.length; i2++) {
                l.c cVar = dVar.f1626c[i2];
                this.a.a.put(cVar.a, cVar);
            }
        }
    }
}
