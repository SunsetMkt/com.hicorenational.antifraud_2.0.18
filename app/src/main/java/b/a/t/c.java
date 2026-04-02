package b.a.t;

import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import b.a.j.a;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {
    private l a;

    /* JADX INFO: renamed from: b */
    private b.a.j.a f1856b;

    /* JADX INFO: renamed from: c */
    private volatile boolean f1857c = false;

    public c(l lVar, b.a.j.a aVar) {
        this.a = null;
        this.f1856b = null;
        this.a = lVar;
        this.f1856b = aVar;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f1857c = true;
        this.a.a.f1791f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zEquals;
        a.C0022a c0022a;
        if (this.f1857c) {
            return;
        }
        anetwork.channel.entity.k kVar = this.a.a;
        RequestStatistic requestStatistic = kVar.f1791f;
        if (this.f1856b != null) {
            String strG = kVar.g();
            Request requestA = this.a.a.a();
            String str = requestA.getHeaders().get("Cache-Control");
            boolean zEquals2 = "no-store".equals(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (zEquals2) {
                this.f1856b.remove(strG);
                zEquals = false;
                c0022a = null;
            } else {
                zEquals = "no-cache".equals(str);
                a.C0022a c0022a2 = this.f1856b.get(strG);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.a.f1893c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(c0022a2 != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(c0022a2 != null ? c0022a2.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = strG;
                    ALog.i("anet.CacheTask", "read cache", str2, objArr);
                }
                c0022a = c0022a2;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = jCurrentTimeMillis2 - jCurrentTimeMillis;
            if (c0022a == null || zEquals || !c0022a.isFresh()) {
                if (this.f1857c) {
                    return;
                }
                g gVar = new g(this.a, zEquals2 ? null : this.f1856b, c0022a);
                this.a.f1895e = gVar;
                gVar.run();
                return;
            }
            if (this.a.f1894d.compareAndSet(false, true)) {
                this.a.a();
                requestStatistic.ret = 1;
                requestStatistic.statusCode = 200;
                requestStatistic.msg = HttpConstant.SUCCESS;
                requestStatistic.protocolType = "cache";
                requestStatistic.rspEnd = jCurrentTimeMillis2;
                requestStatistic.processTime = jCurrentTimeMillis2 - requestStatistic.start;
                if (ALog.isPrintLog(2)) {
                    l lVar = this.a;
                    ALog.i("anet.CacheTask", "hit fresh cache", lVar.f1893c, "URL", lVar.a.f().urlString());
                }
                this.a.f1892b.onResponseCode(200, c0022a.responseHeaders);
                b.a.p.a aVar = this.a.f1892b;
                byte[] bArr = c0022a.data;
                aVar.a(1, bArr.length, ByteArray.wrap(bArr));
                this.a.f1892b.a(new DefaultFinishEvent(200, HttpConstant.SUCCESS, requestA));
            }
        }
    }
}
