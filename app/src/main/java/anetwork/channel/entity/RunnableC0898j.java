package anetwork.channel.entity;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.detect.C0772n;
import anet.channel.fulltrace.C0785a;
import anet.channel.fulltrace.C0786b;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.InterfaceC0871g;
import anetwork.channel.aidl.p022j.BinderC0877d;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p011r.C0032b;
import p000a.p001a.p011r.InterfaceC0031a;
import p000a.p001a.p014u.C0052a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.j */
/* loaded from: classes.dex */
class RunnableC0898j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DefaultFinishEvent f1356a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC0871g f1357b;

    /* renamed from: c */
    final /* synthetic */ C0895g f1358c;

    RunnableC0898j(C0895g c0895g, DefaultFinishEvent defaultFinishEvent, InterfaceC0871g interfaceC0871g) {
        this.f1358c = c0895g;
        this.f1356a = defaultFinishEvent;
        this.f1357b = interfaceC0871g;
    }

    @Override // java.lang.Runnable
    public void run() {
        BinderC0877d binderC0877d;
        String str;
        C0899k c0899k;
        C0899k c0899k2;
        String str2;
        BinderC0877d binderC0877d2;
        DefaultFinishEvent defaultFinishEvent = this.f1356a;
        String str3 = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.m743a((Object) null);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.f1356a.f1196e;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = currentTimeMillis;
                requestStatistic.lastProcessTime = currentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (currentTimeMillis - requestStatistic.start);
                this.f1356a.mo9e().filledBy(requestStatistic);
            }
            this.f1357b.mo774a(this.f1356a);
            if (requestStatistic != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = currentTimeMillis2;
                requestStatistic.callbackTime = currentTimeMillis2 - currentTimeMillis;
                C0785a.m516a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            binderC0877d = this.f1358c.f1344c;
            if (binderC0877d != null) {
                binderC0877d2 = this.f1358c.f1344c;
                binderC0877d2.m787a();
            }
            if (requestStatistic != null) {
                String str4 = "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString();
                str = this.f1358c.f1343b;
                ALog.m715e("anet.Repeater", str4, str, new Object[0]);
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
                C0786b sceneInfo = C0785a.m516a().getSceneInfo();
                if (sceneInfo != null) {
                    String c0786b = sceneInfo.toString();
                    str2 = this.f1358c.f1343b;
                    ALog.m716i("anet.Repeater", c0786b, str2, new Object[0]);
                    requestStatistic.sinceInitTime = requestStatistic.start - sceneInfo.f854c;
                    requestStatistic.startType = sceneInfo.f852a;
                    if (sceneInfo.f852a != 1) {
                        requestStatistic.sinceLastLaunchTime = sceneInfo.f854c - sceneInfo.f855d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f856e;
                    if (!sceneInfo.f853b) {
                        i2 = 0;
                    }
                    requestStatistic.isFromExternal = i2;
                    requestStatistic.speedBucket = sceneInfo.f857f;
                    requestStatistic.abTestBucket = sceneInfo.f858g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                c0899k = this.f1358c.f1346e;
                requestStatistic.userInfo = c0899k.m825a(C0052a.f157i);
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (C0014b.m70a(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str5 = requestStatistic.f1002ip;
                    if (requestStatistic.extra != null) {
                        str3 = requestStatistic.extra.optString("firstIp");
                    }
                    if (C0848c.m708b(str5) || C0848c.m708b(str3)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                InterfaceC0031a m171a = C0032b.m171a();
                c0899k2 = this.f1358c.f1346e;
                m171a.mo170a(c0899k2.m833g(), this.f1356a.mo9e());
                C0772n.m483a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}
