package anet.channel.detect;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.HorseRaceStat;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.i */
/* loaded from: classes.dex */
class C0767i implements RequestCb {

    /* renamed from: a */
    final /* synthetic */ C0766h f802a;

    C0767i(C0766h c0766h) {
        this.f802a = c0766h;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        ALog.m716i("anet.HorseRaceDetector", "LongLinkTask request finish", this.f802a.f798c, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i2), "msg", str);
        if (this.f802a.f796a.reqErrorCode == 0) {
            this.f802a.f796a.reqErrorCode = i2;
        } else {
            HorseRaceStat horseRaceStat = this.f802a.f796a;
            horseRaceStat.reqRet = horseRaceStat.reqErrorCode == 200 ? 1 : 0;
        }
        HorseRaceStat horseRaceStat2 = this.f802a.f796a;
        long currentTimeMillis = System.currentTimeMillis();
        C0766h c0766h = this.f802a;
        horseRaceStat2.reqTime = (currentTimeMillis - c0766h.f797b) + c0766h.f796a.connTime;
        synchronized (this.f802a.f796a) {
            this.f802a.f796a.notify();
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        this.f802a.f796a.reqErrorCode = i2;
    }
}
