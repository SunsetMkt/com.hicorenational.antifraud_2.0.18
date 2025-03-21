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

/* compiled from: Taobao */
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DefaultFinishEvent f2218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ anetwork.channel.aidl.g f2219b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f2220c;

    j(g gVar, DefaultFinishEvent defaultFinishEvent, anetwork.channel.aidl.g gVar2) {
        this.f2220c = gVar;
        this.f2218a = defaultFinishEvent;
        this.f2219b = gVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        anetwork.channel.aidl.j.d dVar;
        String str;
        k kVar;
        k kVar2;
        String str2;
        anetwork.channel.aidl.j.d dVar2;
        DefaultFinishEvent defaultFinishEvent = this.f2218a;
        String str3 = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.a((Object) null);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.f2218a.f2070e;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = currentTimeMillis;
                requestStatistic.lastProcessTime = currentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (currentTimeMillis - requestStatistic.start);
                this.f2218a.e().filledBy(requestStatistic);
            }
            this.f2219b.a(this.f2218a);
            if (requestStatistic != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = currentTimeMillis2;
                requestStatistic.callbackTime = currentTimeMillis2 - currentTimeMillis;
                anet.channel.fulltrace.a.a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            dVar = this.f2220c.f2206c;
            if (dVar != null) {
                dVar2 = this.f2220c.f2206c;
                dVar2.a();
            }
            if (requestStatistic != null) {
                String str4 = "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString();
                str = this.f2220c.f2205b;
                ALog.e("anet.Repeater", str4, str, new Object[0]);
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
                    String bVar = sceneInfo.toString();
                    str2 = this.f2220c.f2205b;
                    ALog.i("anet.Repeater", bVar, str2, new Object[0]);
                    requestStatistic.sinceInitTime = requestStatistic.start - sceneInfo.f1780c;
                    requestStatistic.startType = sceneInfo.f1778a;
                    if (sceneInfo.f1778a != 1) {
                        requestStatistic.sinceLastLaunchTime = sceneInfo.f1780c - sceneInfo.f1781d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f1782e;
                    if (!sceneInfo.f1779b) {
                        i2 = 0;
                    }
                    requestStatistic.isFromExternal = i2;
                    requestStatistic.speedBucket = sceneInfo.f1783f;
                    requestStatistic.abTestBucket = sceneInfo.f1784g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                kVar = this.f2220c.f2208e;
                requestStatistic.userInfo = kVar.a(a.a.u.a.f1252i);
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (a.a.k.b.a(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str5 = requestStatistic.ip;
                    if (requestStatistic.extra != null) {
                        str3 = requestStatistic.extra.optString("firstIp");
                    }
                    if (anet.channel.strategy.utils.c.b(str5) || anet.channel.strategy.utils.c.b(str3)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                a.a.r.a a2 = a.a.r.b.a();
                kVar2 = this.f2220c.f2208e;
                a2.a(kVar2.g(), this.f2218a.e());
                n.a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}
