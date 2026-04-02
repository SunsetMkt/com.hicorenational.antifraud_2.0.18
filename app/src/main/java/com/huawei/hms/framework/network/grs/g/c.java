package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.d;
import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: l */
    private static final String f4637l = "c";
    private final GrsBaseInfo a;

    /* JADX INFO: renamed from: b */
    private final Context f4638b;

    /* JADX INFO: renamed from: c */
    private final com.huawei.hms.framework.network.grs.e.a f4639c;

    /* JADX INFO: renamed from: d */
    private d f4640d;

    /* JADX INFO: renamed from: i */
    private final com.huawei.hms.framework.network.grs.g.j.c f4645i;

    /* JADX INFO: renamed from: e */
    private final Map<String, Future<d>> f4641e = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: f */
    private final List<d> f4642f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g */
    private final JSONArray f4643g = new JSONArray();

    /* JADX INFO: renamed from: h */
    private final List<String> f4644h = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j */
    private String f4646j = "";

    /* JADX INFO: renamed from: k */
    private long f4647k = 1;

    public c(com.huawei.hms.framework.network.grs.g.j.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.f4645i = cVar;
        this.a = cVar.b();
        this.f4638b = cVar.a();
        this.f4639c = aVar;
        b();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x009c A[LOOP:0: B:50:0x0006->B:83:0x009c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d a(ExecutorService executorService, List<String> list, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        d dVar;
        d dVar2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            String str2 = list.get(i2);
            boolean z = true;
            if (!TextUtils.isEmpty(str2)) {
                Future<d> futureSubmit = executorService.submit(new a(str2, i2, this, this.f4638b, str, this.a, cVar).g());
                this.f4641e.put(str2, futureSubmit);
                try {
                    dVar = futureSubmit.get(this.f4647k, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    e = e2;
                    dVar = dVar2;
                } catch (CancellationException unused) {
                } catch (ExecutionException e3) {
                    e = e3;
                    dVar = dVar2;
                } catch (TimeoutException unused2) {
                }
                if (dVar != null) {
                    try {
                    } catch (InterruptedException e4) {
                        e = e4;
                        Logger.w(f4637l, "the current thread was interrupted while waiting", e);
                    } catch (CancellationException unused3) {
                        dVar2 = dVar;
                        Logger.i(f4637l, "{requestServer} the computation was cancelled");
                        if (!z) {
                        }
                    } catch (ExecutionException e5) {
                        e = e5;
                        Logger.w(f4637l, "the computation threw an ExecutionException", e);
                    } catch (TimeoutException unused4) {
                        dVar2 = dVar;
                        Logger.w(f4637l, "the wait timed out");
                        z = false;
                        if (!z) {
                        }
                    }
                    if (dVar.o() || dVar.m()) {
                        Logger.i(f4637l, "grs request return body is not null and is OK.");
                        dVar2 = dVar;
                        if (!z) {
                            Logger.v(f4637l, "needBreak is true so need break current circulation");
                            break;
                        }
                        i2++;
                    }
                }
                dVar2 = dVar;
            }
            z = false;
            if (!z) {
            }
        }
        return b(dVar2);
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, d(), this.f4638b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f4644h.add(sb.toString());
    }

    private d b(d dVar) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f4641e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str = f4637l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(f4637l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e = e3;
                str = f4637l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(f4637l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void b() {
        com.huawei.hms.framework.network.grs.g.j.d dVarA = com.huawei.hms.framework.network.grs.g.i.a.a(this.f4638b);
        if (dVarA == null) {
            Logger.w(f4637l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(dVarA);
        List<String> listA = dVarA.a();
        if (listA == null || listA.size() <= 0) {
            Logger.v(f4637l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listA.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strB = dVarA.b();
        if (listA.size() > 0) {
            for (String str : listA) {
                if (str.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    a(strB, str);
                } else {
                    Logger.w(f4637l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(f4637l, "request to GRS server url is {%s}", this.f4644h);
    }

    private void c() {
        String grsParasKey = this.a.getGrsParasKey(true, true, this.f4638b);
        this.f4646j = this.f4639c.a().a(grsParasKey + HttpHeaders.ETAG, "");
    }

    private String d() {
        com.huawei.hms.framework.network.grs.f.b bVarA = com.huawei.hms.framework.network.grs.f.b.a(this.f4638b.getPackageName());
        com.huawei.hms.framework.network.grs.local.model.a aVarA = bVarA != null ? bVarA.a() : null;
        if (aVarA == null) {
            return "";
        }
        String strA = aVarA.a();
        Logger.v(f4637l, "get appName from local assets is{%s}", strA);
        return strA;
    }

    public d a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        if (this.f4644h.isEmpty()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d dVarA = a(executorService, this.f4644h, str, cVar);
        Logger.i(f4637l, "use 2.0 interface return http's code is\uff1a{%d}", Integer.valueOf(dVarA == null ? 0 : dVarA.b()));
        e.a(new ArrayList(this.f4642f), SystemClock.elapsedRealtime() - jElapsedRealtime, this.f4643g, this.f4638b);
        this.f4642f.clear();
        return dVarA;
    }

    public String a() {
        return this.f4646j;
    }

    public synchronized void a(d dVar) {
        this.f4642f.add(dVar);
        d dVar2 = this.f4640d;
        if (dVar2 != null && (dVar2.o() || this.f4640d.m())) {
            Logger.v(f4637l, "grsResponseResult is ok");
            return;
        }
        if (dVar.n()) {
            Logger.i(f4637l, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.a.getGrsParasKey(true, true, this.f4638b), new d.a(dVar.k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (dVar.m()) {
            Logger.i(f4637l, "GRS server open 304 Not Modified.");
        }
        if (!dVar.o() && !dVar.m()) {
            Logger.v(f4637l, "grsResponseResult has exception so need return");
            return;
        }
        this.f4640d = dVar;
        this.f4639c.a(this.a, this.f4640d, this.f4638b, this.f4645i);
        for (Map.Entry<String, Future<d>> entry : this.f4641e.entrySet()) {
            if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                Logger.i(f4637l, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d dVar) {
    }
}
