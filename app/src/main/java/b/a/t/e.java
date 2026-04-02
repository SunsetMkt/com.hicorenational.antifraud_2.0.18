package b.a.t;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements RequestCb {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        if (this.a.f1859c.f1894d.get()) {
            return;
        }
        d.b(this.a);
        if (this.a.f1859c.f1892b != null) {
            this.a.f1859c.f1892b.a(this.a.f1861e, this.a.f1860d, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (this.a.f1859c.f1894d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.DegradeTask", "[onFinish]", this.a.f1859c.f1893c, "code", Integer.valueOf(i2), "msg", str);
        }
        this.a.f1859c.a();
        requestStatistic.isDone.set(true);
        if (this.a.f1859c.f1892b != null) {
            this.a.f1859c.f1892b.a(new DefaultFinishEvent(i2, str, this.a.f1862f));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (this.a.f1859c.f1894d.get()) {
            return;
        }
        this.a.f1859c.a();
        b.a.l.a.a(this.a.f1859c.a.g(), map);
        this.a.f1860d = HttpHelper.parseContentLength(map);
        if (this.a.f1859c.f1892b != null) {
            this.a.f1859c.f1892b.onResponseCode(i2, map);
        }
    }
}
