package com.alibaba.sdk.android.httpdns;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static volatile t a;

    /* JADX INFO: renamed from: h */
    private long f2611h = 0;

    /* JADX INFO: renamed from: k */
    private boolean f2612k = true;
    private String hostName = null;

    private t() {
    }

    public static t a() {
        if (a == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new t();
                }
            }
        }
        return a;
    }

    private void a(String str, String str2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, u.a(s.SNIFF_HOST), str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f2611h;
        if (j2 != 0 && jCurrentTimeMillis - j2 < 30000) {
            return false;
        }
        this.f2611h = jCurrentTimeMillis;
        return true;
    }

    public synchronized void c(boolean z) {
        this.f2612k = z;
    }

    public synchronized void g() {
        this.f2611h = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0011 A[Catch: all -> 0x0061, Exception -> 0x0063, TryCatch #1 {Exception -> 0x0063, blocks: (B:34:0x0003, B:35:0x0005, B:47:0x0028, B:48:0x004c, B:39:0x0011, B:42:0x001a), top: B:59:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0028 A[Catch: all -> 0x0061, Exception -> 0x0063, TryCatch #1 {Exception -> 0x0063, blocks: (B:34:0x0003, B:35:0x0005, B:47:0x0028, B:48:0x004c, B:39:0x0011, B:42:0x001a), top: B:59:0x0003, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004c A[Catch: all -> 0x0061, Exception -> 0x0063, TRY_LEAVE, TryCatch #1 {Exception -> 0x0063, blocks: (B:34:0x0003, B:35:0x0005, B:47:0x0028, B:48:0x004c, B:39:0x0011, B:42:0x001a), top: B:59:0x0003, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(String str) {
        boolean z;
        String str2;
        String str3;
        if (str != null) {
            try {
                this.hostName = str;
                z = true;
                if (this.f2612k) {
                    str3 = "sniffer is turned off";
                } else if (!d()) {
                    str3 = "sniff too often";
                } else if (TextUtils.isEmpty(this.hostName)) {
                    str3 = "hostname is null";
                } else {
                    str2 = null;
                    if (z) {
                        i.d("launch a sniff task");
                        q qVar = new q(this.hostName, s.SNIFF_HOST);
                        qVar.a(0);
                        c.a().submit(qVar);
                        a(str, u.a(s.SNIFF_HOST));
                        this.hostName = null;
                    } else {
                        i.d("launch sniffer failed due to " + str2);
                    }
                }
                str2 = str3;
                z = false;
                if (z) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            z = true;
            if (this.f2612k) {
            }
            str2 = str3;
            z = false;
            if (z) {
            }
        }
    }
}
