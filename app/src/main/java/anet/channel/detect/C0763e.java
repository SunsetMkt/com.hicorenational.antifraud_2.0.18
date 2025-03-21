package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.C0842l;
import anet.channel.strategy.IStrategyListener;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.e */
/* loaded from: classes.dex */
class C0763e implements IStrategyListener {

    /* renamed from: a */
    final /* synthetic */ C0762d f793a;

    C0763e(C0762d c0762d) {
        this.f793a = c0762d;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(C0842l.d dVar) {
        C0842l.c[] cVarArr;
        ALog.m716i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable() || (cVarArr = dVar.f1133c) == null || cVarArr.length == 0) {
            return;
        }
        synchronized (this.f793a.f791a) {
            for (int i2 = 0; i2 < dVar.f1133c.length; i2++) {
                C0842l.c cVar = dVar.f1133c[i2];
                this.f793a.f791a.put(cVar.f1129a, cVar);
            }
        }
    }
}
