package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class g implements RequestCb {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        this.a.f1540b.onDataReceive(byteArray, z);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 <= 0 && i2 != -204) {
            this.a.f1542d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.a.f1540b.onFinish(i2, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.a.a.getSeq(), "httpStatusCode", Integer.valueOf(i2));
        ALog.i("awcn.HttpSession", "", this.a.a.getSeq(), "response headers", map);
        this.a.f1540b.onResponseCode(i2, map);
        this.a.f1541c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.a;
        fVar.f1542d.handleResponseCode(fVar.a, i2);
        f fVar2 = this.a;
        fVar2.f1542d.handleResponseHeaders(fVar2.a, map);
    }
}
