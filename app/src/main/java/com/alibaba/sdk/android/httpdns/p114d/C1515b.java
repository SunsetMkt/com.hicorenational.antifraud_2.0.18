package com.alibaba.sdk.android.httpdns.p114d;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.AlicloudTracker;
import com.alibaba.sdk.android.utils.AlicloudTrackerManager;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.common.Constants;
import java.util.HashMap;

/* renamed from: com.alibaba.sdk.android.httpdns.d.b */
/* loaded from: classes.dex */
public class C1515b {

    /* renamed from: b */
    private static volatile C1515b f3881b;

    /* renamed from: a */
    private AlicloudTracker f3882a;

    /* renamed from: a */
    private AlicloudTrackerManager f3883a;

    /* renamed from: q */
    private boolean f3885q = true;

    /* renamed from: r */
    private boolean f3886r = false;

    /* renamed from: b */
    private C1514a f3884b = new C1514a();

    private C1515b(Context context) {
        this.f3882a = null;
        this.f3883a = null;
        if (context == null || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        this.f3883a = AlicloudTrackerManager.getInstance((Application) context.getApplicationContext());
        AlicloudTrackerManager alicloudTrackerManager = this.f3883a;
        if (alicloudTrackerManager != null) {
            this.f3882a = alicloudTrackerManager.getTracker("httpdns", "1.3.2.3-no-bssid-ssid");
        }
    }

    /* renamed from: a */
    public static C1515b m3486a() {
        return f3881b;
    }

    /* renamed from: a */
    public static C1515b m3487a(Context context) {
        if (f3881b == null) {
            synchronized (C1515b.class) {
                if (f3881b == null) {
                    f3881b = new C1515b(context);
                }
            }
        }
        return f3881b;
    }

    /* renamed from: a */
    public void m3489a(String str, int i2, int i3, int i4) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put(Constants.KEY_HOST, str);
                    hashMap.put("success", String.valueOf(i2));
                    hashMap.put("ipv6", String.valueOf(i3));
                    hashMap.put("cacheOpen", String.valueOf(i4));
                    this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C1515b.this.f3882a.sendCustomHit("perf_getip", hashMap);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public void m3490a(String str, long j2, int i2) {
        if (this.f3885q && this.f3882a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                final HashMap hashMap = new HashMap();
                hashMap.put("scAddr", str);
                hashMap.put("cost", String.valueOf(j2));
                hashMap.put("ipv6", String.valueOf(i2));
                this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1515b.this.f3882a.sendCustomHit("perf_sc", hashMap);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void m3491a(String str, String str2, String str3) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_HOST, str);
        hashMap.put("scAddr", str2);
        hashMap.put("srvAddr", str3);
        this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1515b.this.f3882a.sendCustomHit("biz_sniffer", hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* renamed from: a */
    public void m3492a(String str, String str2, String str3, int i2) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            final HashMap hashMap = new HashMap();
            hashMap.put("scAddr", str);
            hashMap.put("errCode", str2);
            hashMap.put("errMsg", str3);
            hashMap.put("ipv6", String.valueOf(i2));
            this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1515b.this.f3882a.sendCustomHit("err_sc", hashMap);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m3493a(String str, String str2, String str3, int i2, int i3) {
        try {
            if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i2 == 0 || i2 == 1) {
                if (i3 == 0 || i3 == 1) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put("srvAddr", str);
                    hashMap.put("errCode", str2);
                    hashMap.put("errMsg", str3);
                    hashMap.put("ipv6", String.valueOf(i2));
                    hashMap.put("ipv6_srv", String.valueOf(i3));
                    this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.14
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C1515b.this.f3882a.sendCustomHit("err_srv", hashMap);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3494a(String str, String str2, String str3, long j2, long j3, int i2) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i2 <= 0) {
            return;
        }
        if (j2 > C2084a.f6136r) {
            j2 = 5000;
        }
        if (j3 > C2084a.f6136r) {
            j3 = 5000;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_HOST, str);
        hashMap.put("defaultIp", str2);
        hashMap.put("selectedIp", str3);
        hashMap.put("defaultIpCost", String.valueOf(j2));
        hashMap.put("selectedIpCost", String.valueOf(j3));
        hashMap.put("ipCount", String.valueOf(i2));
        this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1515b.this.f3882a.sendCustomHit("perf_ipselection", hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* renamed from: a */
    public boolean m3495a(SDKMessageCallback sDKMessageCallback) {
        try {
            if (this.f3883a != null) {
                return this.f3883a.registerCrashDefend("httpdns", "1.3.2.3-no-bssid-ssid", 2, 7, sDKMessageCallback);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public void m3496b(String str, int i2, int i3, int i4) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put(Constants.KEY_HOST, str);
                    hashMap.put("success", String.valueOf(i2));
                    hashMap.put("ipv6", String.valueOf(i3));
                    hashMap.put("cacheOpen", String.valueOf(i4));
                    this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.6
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C1515b.this.f3882a.sendCustomHit("perf_user_getip", hashMap);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: b */
    public void m3497b(String str, long j2, int i2) {
        if (this.f3885q && this.f3882a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                final HashMap hashMap = new HashMap();
                hashMap.put("srvAddr", str);
                hashMap.put("cost", String.valueOf(j2));
                hashMap.put("ipv6", String.valueOf(i2));
                this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1515b.this.f3882a.sendCustomHit("perf_srv", hashMap);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    public void m3498b(String str, String str2, String str3) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(Constants.KEY_HOST, str);
        hashMap.put("scAddr", str2);
        hashMap.put("srvAddr", str3);
        this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1515b.this.f3882a.sendCustomHit("biz_local_disable", hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* renamed from: c */
    public void m3499c(int i2) {
        if (this.f3885q && this.f3882a != null) {
            if (i2 == 0 || i2 == 1) {
                final HashMap hashMap = new HashMap();
                hashMap.put("enable", String.valueOf(i2));
                this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1515b.this.f3882a.sendCustomHit("biz_cache", hashMap);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: d */
    public void m3500d(int i2) {
        if (this.f3885q && this.f3882a != null) {
            if (i2 == 0 || i2 == 1) {
                final HashMap hashMap = new HashMap();
                hashMap.put("enable", String.valueOf(i2));
                this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1515b.this.f3882a.sendCustomHit("biz_expired_ip", hashMap);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: e */
    public void m3501e(int i2) {
        try {
            if (this.f3885q && this.f3882a != null) {
                if (i2 == 0 || i2 == 1) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put("enable", String.valueOf(i2));
                    this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.12
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                C1515b.this.f3882a.sendCustomHit("biz_ipv6_enable", hashMap);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: e */
    public void m3502e(boolean z) {
        synchronized (C1515b.class) {
            if (!this.f3886r) {
                this.f3885q = z;
            }
        }
    }

    /* renamed from: k */
    public void m3503k() {
        synchronized (C1515b.class) {
            this.f3886r = true;
            this.f3885q = false;
        }
    }

    /* renamed from: k */
    public void m3504k(String str) {
        if (!this.f3885q || this.f3882a == null || TextUtils.isEmpty(str)) {
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("exception", str);
        this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1515b.this.f3882a.sendCustomHit("err_uncaught_exception", hashMap);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* renamed from: l */
    public void m3505l() {
        if (this.f3885q && this.f3882a != null) {
            this.f3884b.m3485b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1515b.this.f3882a.sendCustomHit("biz_active", null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void setAccountId(String str) {
        AlicloudTracker alicloudTracker = this.f3882a;
        if (alicloudTracker != null) {
            alicloudTracker.setGlobalProperty("accountId", str);
        }
    }
}
