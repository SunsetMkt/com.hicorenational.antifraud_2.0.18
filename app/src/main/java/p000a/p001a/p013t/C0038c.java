package p000a.p001a.p013t;

import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.entity.C0899k;
import p000a.p001a.p002j.InterfaceC0009a;
import p000a.p001a.p008p.InterfaceC0026a;

/* compiled from: Taobao */
/* renamed from: a.a.t.c */
/* loaded from: classes.dex */
public class C0038c implements InterfaceRunnableC0036a {

    /* renamed from: a */
    private C0047l f88a;

    /* renamed from: b */
    private InterfaceC0009a f89b;

    /* renamed from: c */
    private volatile boolean f90c = false;

    public C0038c(C0047l c0047l, InterfaceC0009a interfaceC0009a) {
        this.f88a = null;
        this.f89b = null;
        this.f88a = c0047l;
        this.f89b = interfaceC0009a;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f90c = true;
        this.f88a.f135a.f1364f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean equals;
        InterfaceC0009a.a aVar;
        if (this.f90c) {
            return;
        }
        C0899k c0899k = this.f88a.f135a;
        RequestStatistic requestStatistic = c0899k.f1364f;
        if (this.f89b != null) {
            String m833g = c0899k.m833g();
            Request m824a = this.f88a.f135a.m824a();
            String str = m824a.getHeaders().get("Cache-Control");
            boolean equals2 = "no-store".equals(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (equals2) {
                this.f89b.remove(m833g);
                equals = false;
                aVar = null;
            } else {
                equals = "no-cache".equals(str);
                InterfaceC0009a.a aVar2 = this.f89b.get(m833g);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.f88a.f137c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(aVar2 != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(aVar2 != null ? aVar2.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = m833g;
                    ALog.m716i("anet.CacheTask", "read cache", str2, objArr);
                }
                aVar = aVar2;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = currentTimeMillis2 - currentTimeMillis;
            if (aVar == null || equals || !aVar.isFresh()) {
                if (this.f90c) {
                    return;
                }
                C0042g c0042g = new C0042g(this.f88a, equals2 ? null : this.f89b, aVar);
                this.f88a.f139e = c0042g;
                c0042g.run();
                return;
            }
            if (this.f88a.f138d.compareAndSet(false, true)) {
                this.f88a.m197a();
                requestStatistic.ret = 1;
                requestStatistic.statusCode = 200;
                requestStatistic.msg = HttpConstant.SUCCESS;
                requestStatistic.protocolType = "cache";
                requestStatistic.rspEnd = currentTimeMillis2;
                requestStatistic.processTime = currentTimeMillis2 - requestStatistic.start;
                if (ALog.isPrintLog(2)) {
                    C0047l c0047l = this.f88a;
                    ALog.m716i("anet.CacheTask", "hit fresh cache", c0047l.f137c, "URL", c0047l.f135a.m832f().urlString());
                }
                this.f88a.f136b.onResponseCode(200, aVar.responseHeaders);
                InterfaceC0026a interfaceC0026a = this.f88a.f136b;
                byte[] bArr = aVar.data;
                interfaceC0026a.mo150a(1, bArr.length, ByteArray.wrap(bArr));
                this.f88a.f136b.mo151a(new DefaultFinishEvent(200, HttpConstant.SUCCESS, m824a));
            }
        }
    }
}
