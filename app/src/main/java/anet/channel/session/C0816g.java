package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.C0782b;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.g */
/* loaded from: classes.dex */
class C0816g implements RequestCb {

    /* renamed from: a */
    final /* synthetic */ RunnableC0815f f994a;

    C0816g(RunnableC0815f runnableC0815f) {
        this.f994a = runnableC0815f;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z) {
        this.f994a.f991b.onDataReceive(byteArray, z);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i2, String str, RequestStatistic requestStatistic) {
        if (i2 <= 0 && i2 != -204) {
            this.f994a.f993d.handleCallbacks(2, new C0782b(2, 0, "Http connect fail"));
        }
        this.f994a.f991b.onFinish(i2, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        ALog.m716i("awcn.HttpSession", "", this.f994a.f990a.getSeq(), "httpStatusCode", Integer.valueOf(i2));
        ALog.m716i("awcn.HttpSession", "", this.f994a.f990a.getSeq(), "response headers", map);
        this.f994a.f991b.onResponseCode(i2, map);
        this.f994a.f992c.serverRT = HttpHelper.parseServerRT(map);
        RunnableC0815f runnableC0815f = this.f994a;
        runnableC0815f.f993d.handleResponseCode(runnableC0815f.f990a, i2);
        RunnableC0815f runnableC0815f2 = this.f994a;
        runnableC0815f2.f993d.handleResponseHeaders(runnableC0815f2.f990a, map);
    }
}
