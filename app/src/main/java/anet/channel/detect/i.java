package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class i implements RequestCb {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        ALog.i("anet.HorseRaceDetector", "LongLinkTask request finish", this.a.f1416c, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2), "msg", str);
        if (this.a.a.reqErrorCode == 0) {
            this.a.a.reqErrorCode = i2;
        } else {
            HorseRaceStat horseRaceStat = this.a.a;
            horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
        }
        HorseRaceStat horseRaceStat2 = this.a.a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        h hVar = this.a;
        horseRaceStat2.reqTime = (jCurrentTimeMillis - hVar.f1415b) + hVar.a.connTime;
        synchronized (this.a.a) {
            this.a.a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        this.a.a.reqErrorCode = i2;
    }
}
