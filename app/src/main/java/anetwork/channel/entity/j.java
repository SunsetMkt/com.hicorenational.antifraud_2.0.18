package anetwork.channel.entity;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.detect.n;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ DefaultFinishEvent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f1785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f1786c;

    j(g gVar, DefaultFinishEvent defaultFinishEvent, anetwork.channel.aidl.g gVar2) {
        this.f1786c = gVar;
        this.a = defaultFinishEvent;
        this.f1785b = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultFinishEvent defaultFinishEvent = this.a;
        String strOptString = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.a((Object) null);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.a.f1664e;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = jCurrentTimeMillis;
                requestStatistic.lastProcessTime = jCurrentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (jCurrentTimeMillis - requestStatistic.start);
                this.a.e().filledBy(requestStatistic);
            }
            this.f1785b.a(this.a);
            if (requestStatistic != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = jCurrentTimeMillis2;
                requestStatistic.callbackTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
                anet.channel.fulltrace.a.a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            if (this.f1786c.f1775c != null) {
                this.f1786c.f1775c.a();
            }
            if (requestStatistic != null) {
                ALog.e("anet.Repeater", "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString(), this.f1786c.f1774b, new Object[0]);
                CopyOnWriteArrayList<String> bucketInfo = GlobalAppRuntimeInfo.getBucketInfo();
                int i2 = 1;
                if (bucketInfo != null) {
                    int size = bucketInfo.size();
                    for (int i3 = 0; i3 < size - 1; i3 += 2) {
                        requestStatistic.putExtra(bucketInfo.get(i3), bucketInfo.get(i3 + 1));
                    }
                }
                if (GlobalAppRuntimeInfo.isAppBackground()) {
                    requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.getRestrictBackgroundStatus()));
                }
                anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
                if (sceneInfo != null) {
                    ALog.i("anet.Repeater", sceneInfo.toString(), this.f1786c.f1774b, new Object[0]);
                    requestStatistic.sinceInitTime = requestStatistic.start - sceneInfo.f1452c;
                    requestStatistic.startType = sceneInfo.a;
                    if (sceneInfo.a != 1) {
                        requestStatistic.sinceLastLaunchTime = sceneInfo.f1452c - sceneInfo.f1453d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f1454e;
                    if (!sceneInfo.f1451b) {
                        i2 = 0;
                    }
                    requestStatistic.isFromExternal = i2;
                    requestStatistic.speedBucket = sceneInfo.f1455f;
                    requestStatistic.abTestBucket = sceneInfo.f1456g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                requestStatistic.userInfo = this.f1786c.f1777e.a(b.a.u.a.f1907i);
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (b.a.k.b.a(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str = requestStatistic.ip;
                    if (requestStatistic.extra != null) {
                        strOptString = requestStatistic.extra.optString("firstIp");
                    }
                    if (anet.channel.strategy.utils.c.b(str) || anet.channel.strategy.utils.c.b(strOptString)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                b.a.r.b.a().a(this.f1786c.f1777e.g(), this.a.e());
                n.a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}
