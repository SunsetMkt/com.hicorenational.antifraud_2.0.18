package com.alibaba.sdk.android.httpdns.probe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.alibaba.sdk.android.httpdns.probe.g */
/* loaded from: classes.dex */
class RunnableC1539g implements Runnable {

    /* renamed from: a */
    private CountDownLatch f3985a;

    /* renamed from: b */
    private ConcurrentHashMap<String, Long> f3986b;

    /* renamed from: o */
    private String f3987o;
    private int port;

    public RunnableC1539g(String str, int i2, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.f3985a = null;
        this.f3987o = str;
        this.port = i2;
        this.f3985a = countDownLatch;
        this.f3986b = concurrentHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long m3574a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "socket close failed:"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r5 = 0
            java.net.Socket r6 = new java.net.Socket     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r6.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r5.<init>(r8, r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r8 = 5000(0x1388, float:7.006E-42)
            r6.connect(r5, r8)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r6.close()     // Catch: java.io.IOException -> L21
            goto L78
        L21:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r5.toString()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.alibaba.sdk.android.httpdns.C1522i.m3527f(r0)
            goto L78
        L39:
            r8 = move-exception
            r5 = r6
            goto L7f
        L3c:
            r8 = move-exception
            r5 = r6
            goto L42
        L3f:
            r8 = move-exception
            goto L7f
        L41:
            r8 = move-exception
        L42:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r9.<init>()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "connect failed:"
            r9.append(r6)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L3f
            r9.append(r8)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L3f
            com.alibaba.sdk.android.httpdns.C1522i.m3527f(r8)     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L77
            r5.close()     // Catch: java.io.IOException -> L60
            goto L77
        L60:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.alibaba.sdk.android.httpdns.C1522i.m3527f(r8)
        L77:
            r8 = r3
        L78:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 != 0) goto L7d
            return r3
        L7d:
            long r8 = r8 - r1
            return r8
        L7f:
            if (r5 == 0) goto L9c
            r5.close()     // Catch: java.io.IOException -> L85
            goto L9c
        L85:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.alibaba.sdk.android.httpdns.C1522i.m3527f(r9)
        L9c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.RunnableC1539g.m3574a(java.lang.String, int):long");
    }

    /* renamed from: a */
    private boolean m3575a(int i2) {
        return i2 >= 1 && i2 <= 65535;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: Exception -> 0x0052, TRY_LEAVE, TryCatch #0 {Exception -> 0x0052, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000d, B:9:0x0037, B:10:0x0048, B:12:0x004c, B:17:0x0043), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f3987o     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L43
            int r0 = r4.port     // Catch: java.lang.Exception -> L52
            boolean r0 = r4.m3575a(r0)     // Catch: java.lang.Exception -> L52
            if (r0 != 0) goto Ld
            goto L43
        Ld:
            java.lang.String r0 = r4.f3987o     // Catch: java.lang.Exception -> L52
            int r1 = r4.port     // Catch: java.lang.Exception -> L52
            long r0 = r4.m3574a(r0, r1)     // Catch: java.lang.Exception -> L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52
            r2.<init>()     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = "connect cost for ip:"
            r2.append(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = r4.f3987o     // Catch: java.lang.Exception -> L52
            r2.append(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = " is "
            r2.append(r3)     // Catch: java.lang.Exception -> L52
            r2.append(r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L52
            com.alibaba.sdk.android.httpdns.C1522i.m3525d(r2)     // Catch: java.lang.Exception -> L52
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r2 = r4.f3986b     // Catch: java.lang.Exception -> L52
            if (r2 == 0) goto L48
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r2 = r4.f3986b     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = r4.f3987o     // Catch: java.lang.Exception -> L52
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Exception -> L52
            r2.put(r3, r0)     // Catch: java.lang.Exception -> L52
            goto L48
        L43:
            java.lang.String r0 = "invalid params, give up"
            com.alibaba.sdk.android.httpdns.C1522i.m3527f(r0)     // Catch: java.lang.Exception -> L52
        L48:
            java.util.concurrent.CountDownLatch r0 = r4.f3985a     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L56
            java.util.concurrent.CountDownLatch r0 = r4.f3985a     // Catch: java.lang.Exception -> L52
            r0.countDown()     // Catch: java.lang.Exception -> L52
            goto L56
        L52:
            r0 = move-exception
            r0.printStackTrace()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.RunnableC1539g.run():void");
    }
}
