package a.a.t;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class e implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f1194a;

    e(d dVar) {
        this.f1194a = dVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        l lVar;
        l lVar2;
        l lVar3;
        int i2;
        int i3;
        lVar = this.f1194a.f1190c;
        if (lVar.f1233d.get()) {
            return;
        }
        d.b(this.f1194a);
        lVar2 = this.f1194a.f1190c;
        if (lVar2.f1231b != null) {
            lVar3 = this.f1194a.f1190c;
            a.a.p.a aVar = lVar3.f1231b;
            i2 = this.f1194a.f1192e;
            i3 = this.f1194a.f1191d;
            aVar.a(i2, i3, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        Request request;
        l lVar5;
        lVar = this.f1194a.f1190c;
        if (lVar.f1233d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            lVar5 = this.f1194a.f1190c;
            ALog.i("anet.DegradeTask", "[onFinish]", lVar5.f1232c, "code", Integer.valueOf(i2), "msg", str);
        }
        lVar2 = this.f1194a.f1190c;
        lVar2.a();
        requestStatistic.isDone.set(true);
        lVar3 = this.f1194a.f1190c;
        if (lVar3.f1231b != null) {
            lVar4 = this.f1194a.f1190c;
            a.a.p.a aVar = lVar4.f1231b;
            request = this.f1194a.f1193f;
            aVar.a(new DefaultFinishEvent(i2, str, request));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        lVar = this.f1194a.f1190c;
        if (lVar.f1233d.get()) {
            return;
        }
        lVar2 = this.f1194a.f1190c;
        lVar2.a();
        lVar3 = this.f1194a.f1190c;
        a.a.l.a.a(lVar3.f1230a.g(), map);
        this.f1194a.f1191d = HttpHelper.parseContentLength(map);
        lVar4 = this.f1194a.f1190c;
        if (lVar4.f1231b != null) {
            lVar5 = this.f1194a.f1190c;
            lVar5.f1231b.onResponseCode(i2, map);
        }
    }
}
