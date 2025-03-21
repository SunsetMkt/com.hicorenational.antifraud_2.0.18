package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.p114d.C1515b;

/* renamed from: com.alibaba.sdk.android.httpdns.t */
/* loaded from: classes.dex */
public class C1542t {

    /* renamed from: a */
    private static volatile C1542t f4003a;

    /* renamed from: h */
    private long f4004h = 0;

    /* renamed from: k */
    private boolean f4005k = true;
    private String hostName = null;

    private C1542t() {
    }

    /* renamed from: a */
    public static C1542t m3580a() {
        if (f4003a == null) {
            synchronized (C1542t.class) {
                if (f4003a == null) {
                    f4003a = new C1542t();
                }
            }
        }
        return f4003a;
    }

    /* renamed from: a */
    private void m3581a(String str, String str2) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3491a(str, C1543u.m3586a(EnumC1541s.SNIFF_HOST), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    private boolean m3582d() {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f4004h;
        if (j2 != 0 && currentTimeMillis - j2 < 30000) {
            return false;
        }
        this.f4004h = currentTimeMillis;
        return true;
    }

    /* renamed from: c */
    public synchronized void m3583c(boolean z) {
        this.f4005k = z;
    }

    /* renamed from: g */
    public synchronized void m3584g() {
        this.f4004h = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c A[Catch: all -> 0x0061, Exception -> 0x0063, TRY_LEAVE, TryCatch #1 {Exception -> 0x0063, blocks: (B:22:0x0003, B:4:0x0005, B:9:0x0028, B:13:0x004c, B:14:0x0011, B:17:0x001a), top: B:21:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028 A[Catch: all -> 0x0061, Exception -> 0x0063, TryCatch #1 {Exception -> 0x0063, blocks: (B:22:0x0003, B:4:0x0005, B:9:0x0028, B:13:0x004c, B:14:0x0011, B:17:0x001a), top: B:21:0x0003, outer: #0 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m3585g(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L5
            r5.hostName = r6     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
        L5:
            r0 = 1
            boolean r1 = r5.f4005k     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L11
            java.lang.String r0 = "sniffer is turned off"
        Le:
            r1 = r0
            r0 = 0
            goto L26
        L11:
            boolean r1 = r5.m3582d()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r1 != 0) goto L1a
            java.lang.String r0 = "sniff too often"
            goto Le
        L1a:
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            if (r1 == 0) goto L25
            java.lang.String r0 = "hostname is null"
            goto Le
        L25:
            r1 = r2
        L26:
            if (r0 == 0) goto L4c
            java.lang.String r0 = "launch a sniff task"
            com.alibaba.sdk.android.httpdns.C1522i.m3525d(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.q r0 = new com.alibaba.sdk.android.httpdns.q     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r1 = r5.hostName     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.EnumC1541s.SNIFF_HOST     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r0.<init>(r1, r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r0.m3578a(r3)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.util.concurrent.ExecutorService r1 = com.alibaba.sdk.android.httpdns.C1511c.m3462a()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r1.submit(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.s r0 = com.alibaba.sdk.android.httpdns.EnumC1541s.SNIFF_HOST     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.C1543u.m3586a(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r5.m3581a(r6, r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r5.hostName = r2     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L67
        L4c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r6.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r0 = "launch sniffer failed due to "
            r6.append(r0)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            r6.append(r1)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            com.alibaba.sdk.android.httpdns.C1522i.m3525d(r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63
            goto L67
        L61:
            r6 = move-exception
            goto L69
        L63:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L61
        L67:
            monitor-exit(r5)
            return
        L69:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.C1542t.m3585g(java.lang.String):void");
    }
}
