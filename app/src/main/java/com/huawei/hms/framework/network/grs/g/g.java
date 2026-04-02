package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.h.d;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b */
    private static final ExecutorService f4664b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* JADX INFO: renamed from: c */
    private static final Map<String, com.huawei.hms.framework.network.grs.g.j.b> f4665c = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: d */
    private static final Object f4666d = new Object();
    private com.huawei.hms.framework.network.grs.e.a a;

    class a implements Callable<d> {
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f4667b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f4668c;

        a(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.a = cVar;
            this.f4667b = str;
            this.f4668c = cVar2;
        }

        @Override // java.util.concurrent.Callable
        public d call() {
            return new c(this.a, g.this.a).a(g.f4664b, this.f4667b, this.f4668c);
        }
    }

    class b implements Runnable {
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.j.c a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f4670b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c f4671c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ int f4672d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ com.huawei.hms.framework.network.grs.b f4673e;

        b(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2, com.huawei.hms.framework.network.grs.b bVar) {
            this.a = cVar;
            this.f4670b = str;
            this.f4671c = cVar2;
            this.f4672d = i2;
            this.f4673e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.a(gVar.a(this.a, this.f4670b, this.f4671c, this.f4672d), this.f4673e);
        }
    }

    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(dVar);
            }
        }
    }

    public d a(com.huawei.hms.framework.network.grs.g.j.c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2) {
        Future<d> futureSubmit;
        String str2;
        String str3;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (f4666d) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a aVarA = com.huawei.hms.framework.network.grs.h.d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.j.b bVar = f4665c.get(grsParasKey);
            if (bVar == null || !bVar.b()) {
                if (aVarA != null && aVarA.a()) {
                    return null;
                }
                Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
                futureSubmit = f4664b.submit(new a(cVar, str, cVar2));
                f4665c.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.j.b(futureSubmit));
            } else {
                futureSubmit = bVar.a();
            }
            if (i2 == -1) {
                com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(cVar.a());
                i2 = dVarA != null ? dVarA.c() : 10;
            }
            Logger.i("RequestController", "use grsQueryTimeout %d", Integer.valueOf(i2));
            try {
                return futureSubmit.get(i2, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (CancellationException e3) {
                e = e3;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (ExecutionException e4) {
                e = e4;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (TimeoutException e5) {
                e = e5;
                str2 = "RequestController";
                str3 = "when check result, find TimeoutException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (Exception e6) {
                e = e6;
                str2 = "RequestController";
                str3 = "when check result, find Other Exception, check others";
                Logger.w(str2, str3, e);
                return null;
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.a = aVar;
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, int i2) {
        f4664b.execute(new b(cVar, str, cVar2, i2, bVar));
    }

    public void a(String str) {
        synchronized (f4666d) {
            f4665c.remove(str);
        }
    }
}
