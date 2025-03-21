package com.huawei.hms.framework.network.grs.p175g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C2389a;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import com.huawei.hms.framework.network.grs.p174f.C2365b;
import com.huawei.hms.framework.network.grs.p175g.p176i.C2377a;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2381d;
import com.huawei.hms.framework.network.grs.p178h.C2385d;
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

/* renamed from: com.huawei.hms.framework.network.grs.g.c */
/* loaded from: classes.dex */
public class C2371c {

    /* renamed from: l */
    private static final String f7383l = "c";

    /* renamed from: a */
    private final GrsBaseInfo f7384a;

    /* renamed from: b */
    private final Context f7385b;

    /* renamed from: c */
    private final C2361a f7386c;

    /* renamed from: d */
    private C2372d f7387d;

    /* renamed from: i */
    private final C2380c f7392i;

    /* renamed from: e */
    private final Map<String, Future<C2372d>> f7388e = new ConcurrentHashMap(16);

    /* renamed from: f */
    private final List<C2372d> f7389f = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final JSONArray f7390g = new JSONArray();

    /* renamed from: h */
    private final List<String> f7391h = new CopyOnWriteArrayList();

    /* renamed from: j */
    private String f7393j = "";

    /* renamed from: k */
    private long f7394k = 1;

    public C2371c(C2380c c2380c, C2361a c2361a) {
        this.f7392i = c2380c;
        this.f7384a = c2380c.m6963b();
        this.f7385b = c2380c.m6961a();
        this.f7386c = c2361a;
        m6902b();
        m6903c();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0099 A[LOOP:0: B:2:0x0006->B:13:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0091 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.p175g.C2372d m6899a(java.util.concurrent.ExecutorService r17, java.util.List<java.lang.String> r18, java.lang.String r19, com.huawei.hms.framework.network.grs.p173e.C2363c r20) {
        /*
            r16 = this;
            r9 = r16
            r10 = 0
            r0 = 0
            r12 = r0
            r11 = 0
        L6:
            int r0 = r18.size()
            if (r11 >= r0) goto L9d
            r13 = r18
            java.lang.Object r0 = r13.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r14 = 1
            if (r1 != 0) goto L8c
            com.huawei.hms.framework.network.grs.g.a r15 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r5 = r9.f7385b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.f7384a
            r1 = r15
            r2 = r0
            r3 = r11
            r4 = r16
            r6 = r19
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r1 = r15.m6897g()
            r2 = r17
            java.util.concurrent.Future r1 = r2.submit(r1)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r3 = r9.f7388e
            r3.put(r0, r1)
            long r3 = r9.f7394k     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            java.lang.Object r0 = r1.get(r3, r0)     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            r1 = r0
            com.huawei.hms.framework.network.grs.g.d r1 = (com.huawei.hms.framework.network.grs.p175g.C2372d) r1     // Catch: java.util.concurrent.TimeoutException -> L65 java.lang.InterruptedException -> L6d java.util.concurrent.ExecutionException -> L78 java.util.concurrent.CancellationException -> L83
            if (r1 == 0) goto L81
            boolean r0 = r1.m6942o()     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            if (r0 != 0) goto L55
            boolean r0 = r1.m6940m()     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            if (r0 == 0) goto L81
        L55:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.m6799i(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L5d java.lang.InterruptedException -> L5f java.util.concurrent.ExecutionException -> L61 java.util.concurrent.CancellationException -> L63
            goto L76
        L5d:
            r12 = r1
            goto L65
        L5f:
            r0 = move-exception
            goto L6f
        L61:
            r0 = move-exception
            goto L7a
        L63:
            r12 = r1
            goto L83
        L65:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l
            java.lang.String r1 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.m6803w(r0, r1)
            goto L8e
        L6d:
            r0 = move-exception
            r1 = r12
        L6f:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l
            java.lang.String r4 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.m6804w(r3, r4, r0)
        L76:
            r12 = r1
            goto L8f
        L78:
            r0 = move-exception
            r1 = r12
        L7a:
            java.lang.String r3 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l
            java.lang.String r4 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.m6804w(r3, r4, r0)
        L81:
            r12 = r1
            goto L8e
        L83:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l
            java.lang.String r1 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.m6799i(r0, r1)
            goto L8f
        L8c:
            r2 = r17
        L8e:
            r14 = 0
        L8f:
            if (r14 == 0) goto L99
            java.lang.String r0 = com.huawei.hms.framework.network.grs.p175g.C2371c.f7383l
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.m6801v(r0, r1)
            goto L9d
        L99:
            int r11 = r11 + 1
            goto L6
        L9d:
            com.huawei.hms.framework.network.grs.g.d r0 = r9.m6901b(r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p175g.C2371c.m6899a(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    /* renamed from: a */
    private void m6900a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.f7384a.getGrsReqParamJoint(false, false, m6904d(), this.f7385b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f7391h.add(sb.toString());
    }

    /* renamed from: b */
    private C2372d m6901b(C2372d c2372d) {
        String str;
        String str2;
        for (Map.Entry<String, Future<C2372d>> entry : this.f7388e.entrySet()) {
            if (c2372d != null && (c2372d.m6942o() || c2372d.m6940m())) {
                break;
            }
            try {
                c2372d = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                e = e2;
                str = f7383l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.m6804w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.m6799i(f7383l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e3) {
                e = e3;
                str = f7383l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.m6804w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.m6803w(f7383l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return c2372d;
    }

    /* renamed from: b */
    private void m6902b() {
        C2381d m6956a = C2377a.m6956a(this.f7385b);
        if (m6956a == null) {
            Logger.m6803w(f7383l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        m6908a(m6956a);
        List<String> m6966a = m6956a.m6966a();
        if (m6966a == null || m6966a.size() <= 0) {
            Logger.m6801v(f7383l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (m6966a.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String m6970b = m6956a.m6970b();
        if (m6966a.size() > 0) {
            for (String str : m6966a) {
                if (str.startsWith(DefaultWebClient.HTTPS_SCHEME)) {
                    m6900a(m6970b, str);
                } else {
                    Logger.m6803w(f7383l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.m6802v(f7383l, "request to GRS server url is {%s}", this.f7391h);
    }

    /* renamed from: c */
    private void m6903c() {
        String grsParasKey = this.f7384a.getGrsParasKey(true, true, this.f7385b);
        this.f7393j = this.f7386c.m6847a().m6857a(grsParasKey + HttpHeaders.ETAG, "");
    }

    /* renamed from: d */
    private String m6904d() {
        C2365b m6881a = C2365b.m6881a(this.f7385b.getPackageName());
        C2389a m6883a = m6881a != null ? m6881a.m6883a() : null;
        if (m6883a == null) {
            return "";
        }
        String m6991a = m6883a.m6991a();
        Logger.m6802v(f7383l, "get appName from local assets is{%s}", m6991a);
        return m6991a;
    }

    /* renamed from: a */
    public C2372d m6905a(ExecutorService executorService, String str, C2363c c2363c) {
        if (this.f7391h.isEmpty()) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C2372d m6899a = m6899a(executorService, this.f7391h, str, c2363c);
        Logger.m6800i(f7383l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(m6899a == null ? 0 : m6899a.m6927b()));
        C2373e.m6944a(new ArrayList(this.f7389f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f7390g, this.f7385b);
        this.f7389f.clear();
        return m6899a;
    }

    /* renamed from: a */
    public String m6906a() {
        return this.f7393j;
    }

    /* renamed from: a */
    public synchronized void m6907a(C2372d c2372d) {
        this.f7389f.add(c2372d);
        C2372d c2372d2 = this.f7387d;
        if (c2372d2 != null && (c2372d2.m6942o() || this.f7387d.m6940m())) {
            Logger.m6801v(f7383l, "grsResponseResult is ok");
            return;
        }
        if (c2372d.m6941n()) {
            Logger.m6799i(f7383l, "GRS server open 503 limiting strategy.");
            C2385d.m6982a(this.f7384a.getGrsParasKey(true, true, this.f7385b), new C2385d.a(c2372d.m6938k(), SystemClock.elapsedRealtime()));
            return;
        }
        if (c2372d.m6940m()) {
            Logger.m6799i(f7383l, "GRS server open 304 Not Modified.");
        }
        if (!c2372d.m6942o() && !c2372d.m6940m()) {
            Logger.m6801v(f7383l, "grsResponseResult has exception so need return");
            return;
        }
        this.f7387d = c2372d;
        this.f7386c.m6850a(this.f7384a, this.f7387d, this.f7385b, this.f7392i);
        for (Map.Entry<String, Future<C2372d>> entry : this.f7388e.entrySet()) {
            if (!entry.getKey().equals(c2372d.m6939l()) && !entry.getValue().isCancelled()) {
                Logger.m6799i(f7383l, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    /* renamed from: a */
    public void m6908a(C2381d c2381d) {
    }
}
