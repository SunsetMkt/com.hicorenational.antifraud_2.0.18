package com.alibaba.sdk.android.httpdns.probe;

import com.alibaba.sdk.android.httpdns.C1511c;
import com.heytap.mcssdk.constant.C2084a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.alibaba.sdk.android.httpdns.probe.a */
/* loaded from: classes.dex */
class RunnableC1533a implements Runnable {

    /* renamed from: a */
    private InterfaceC1538f f3972a;

    /* renamed from: b */
    private ConcurrentHashMap<String, Long> f3973b = new ConcurrentHashMap<>();
    private String host;
    private String[] ips;

    /* renamed from: j */
    private long f3974j;
    private int port;

    public RunnableC1533a(long j2, String str, String[] strArr, int i2, InterfaceC1538f interfaceC1538f) {
        this.f3972a = null;
        this.f3974j = j2;
        this.host = str;
        this.ips = strArr;
        this.port = i2;
        this.f3972a = interfaceC1538f;
    }

    /* renamed from: a */
    private C1535c m3562a(String[] strArr) {
        String[] strArr2 = this.ips;
        if (strArr2 == null || strArr2.length == 0 || strArr == null || strArr.length == 0) {
            return null;
        }
        String str = strArr2[0];
        String str2 = strArr[0];
        return new C1535c(this.host, strArr, str, str2, this.f3973b.containsKey(str) ? this.f3973b.get(str).longValue() : 2147483647L, this.f3973b.containsKey(str2) ? this.f3973b.get(str2).longValue() : 2147483647L);
    }

    /* renamed from: a */
    private String[] m3563a(ConcurrentHashMap<String, Long> concurrentHashMap) {
        if (concurrentHashMap == null) {
            return null;
        }
        String[] strArr = new String[concurrentHashMap.size()];
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = new String(it.next());
            i2++;
        }
        for (int i3 = 0; i3 < strArr.length - 1; i3++) {
            int i4 = 0;
            while (i4 < (strArr.length - i3) - 1) {
                int i5 = i4 + 1;
                if (concurrentHashMap.get(strArr[i4]).longValue() > concurrentHashMap.get(strArr[i5]).longValue()) {
                    String str = strArr[i4];
                    strArr[i4] = strArr[i5];
                    strArr[i5] = str;
                }
                i4 = i5;
            }
        }
        return strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] m3563a;
        String[] strArr = this.ips;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(strArr.length);
        for (int i2 = 0; i2 < this.ips.length; i2++) {
            C1511c.m3462a().execute(new RunnableC1539g(this.ips[i2], this.port, countDownLatch, this.f3973b));
        }
        try {
            countDownLatch.await(C2084a.f6135q, TimeUnit.MILLISECONDS);
            if (this.f3972a == null || (m3563a = m3563a(this.f3973b)) == null || m3563a.length == 0) {
                return;
            }
            this.f3972a.mo3573a(this.f3974j, m3562a(m3563a));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
