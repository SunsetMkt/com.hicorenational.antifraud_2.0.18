package com.alibaba.sdk.android.httpdns.d;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.utils.AlicloudTracker;
import com.alibaba.sdk.android.utils.AlicloudTrackerManager;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b */
    private static volatile b f2555b;
    private AlicloudTracker a;

    /* JADX INFO: renamed from: a */
    private AlicloudTrackerManager f15a;
    private boolean q = true;
    private boolean r = false;

    /* JADX INFO: renamed from: b */
    private a f16b = new a();

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_active", null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass10(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_cache", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass11(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_expired_ip", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass12(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_ipv6_enable", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$13 */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass13(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("err_sc", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass14(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("err_srv", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass2(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("err_uncaught_exception", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass3(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("perf_sc", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass4(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("perf_srv", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass5(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("perf_getip", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass6(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("perf_user_getip", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass7(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("perf_ipselection", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass8(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_sniffer", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.d.b$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ Map a;

        AnonymousClass9(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a.sendCustomHit("biz_local_disable", map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private b(Context context) {
        this.a = null;
        this.f15a = null;
        if (context == null || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        this.f15a = AlicloudTrackerManager.getInstance((Application) context.getApplicationContext());
        AlicloudTrackerManager alicloudTrackerManager = this.f15a;
        if (alicloudTrackerManager != null) {
            this.a = alicloudTrackerManager.getTracker("httpdns", "1.3.2.3-no-bssid-ssid");
        }
    }

    public static b a() {
        return f2555b;
    }

    public static b a(Context context) {
        if (f2555b == null) {
            synchronized (b.class) {
                if (f2555b == null) {
                    f2555b = new b(context);
                }
            }
        }
        return f2555b;
    }

    public void a(String str, int i2, int i3, int i4) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    HashMap map = new HashMap();
                    map.put(Constants.KEY_HOST, str);
                    map.put("success", String.valueOf(i2));
                    map.put("ipv6", String.valueOf(i3));
                    map.put("cacheOpen", String.valueOf(i4));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.5
                        final /* synthetic */ Map a;

                        AnonymousClass5(Map map2) {
                            map = map2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.a.sendCustomHit("perf_getip", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    public void a(String str, long j2, int i2) {
        if (this.q && this.a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                HashMap map = new HashMap();
                map.put("scAddr", str);
                map.put("cost", String.valueOf(j2));
                map.put("ipv6", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.3
                    final /* synthetic */ Map a;

                    AnonymousClass3(Map map2) {
                        map = map2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a.sendCustomHit("perf_sc", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("scAddr", str2);
        map.put("srvAddr", str3);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.8
            final /* synthetic */ Map a;

            AnonymousClass8(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a.sendCustomHit("biz_sniffer", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void a(String str, String str2, String str3, int i2) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            HashMap map = new HashMap();
            map.put("scAddr", str);
            map.put("errCode", str2);
            map.put("errMsg", str3);
            map.put("ipv6", String.valueOf(i2));
            this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.13
                final /* synthetic */ Map a;

                AnonymousClass13(Map map2) {
                    map = map2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a.sendCustomHit("err_sc", map);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        try {
            if (!this.q || this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i2 == 0 || i2 == 1) {
                if (i3 == 0 || i3 == 1) {
                    HashMap map = new HashMap();
                    map.put("srvAddr", str);
                    map.put("errCode", str2);
                    map.put("errMsg", str3);
                    map.put("ipv6", String.valueOf(i2));
                    map.put("ipv6_srv", String.valueOf(i3));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.14
                        final /* synthetic */ Map a;

                        AnonymousClass14(Map map2) {
                            map = map2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.a.sendCustomHit("err_srv", map);
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

    public void a(String str, String str2, String str3, long j2, long j3, int i2) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || i2 <= 0) {
            return;
        }
        if (j2 > com.heytap.mcssdk.constant.a.r) {
            j2 = 5000;
        }
        if (j3 > com.heytap.mcssdk.constant.a.r) {
            j3 = 5000;
        }
        HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("defaultIp", str2);
        map.put("selectedIp", str3);
        map.put("defaultIpCost", String.valueOf(j2));
        map.put("selectedIpCost", String.valueOf(j3));
        map.put("ipCount", String.valueOf(i2));
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.7
            final /* synthetic */ Map a;

            AnonymousClass7(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a.sendCustomHit("perf_ipselection", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public boolean a(SDKMessageCallback sDKMessageCallback) {
        try {
            if (this.f15a != null) {
                return this.f15a.registerCrashDefend("httpdns", "1.3.2.3-no-bssid-ssid", 2, 7, sDKMessageCallback);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void b(String str, int i2, int i3, int i4) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 0 || i2 == 1) {
            if (i3 == 0 || i3 == 1) {
                if (i4 == 0 || i4 == 1) {
                    HashMap map = new HashMap();
                    map.put(Constants.KEY_HOST, str);
                    map.put("success", String.valueOf(i2));
                    map.put("ipv6", String.valueOf(i3));
                    map.put("cacheOpen", String.valueOf(i4));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.6
                        final /* synthetic */ Map a;

                        AnonymousClass6(Map map2) {
                            map = map2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.a.sendCustomHit("perf_user_getip", map);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    public void b(String str, long j2, int i2) {
        if (this.q && this.a != null && !TextUtils.isEmpty(str) && j2 > 0) {
            if (i2 == 0 || i2 == 1) {
                if (j2 > 30000) {
                    j2 = 30000;
                }
                HashMap map = new HashMap();
                map.put("srvAddr", str);
                map.put("cost", String.valueOf(j2));
                map.put("ipv6", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.4
                    final /* synthetic */ Map a;

                    AnonymousClass4(Map map2) {
                        map = map2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a.sendCustomHit("perf_srv", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void b(String str, String str2, String str3) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap map = new HashMap();
        map.put(Constants.KEY_HOST, str);
        map.put("scAddr", str2);
        map.put("srvAddr", str3);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.9
            final /* synthetic */ Map a;

            AnonymousClass9(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a.sendCustomHit("biz_local_disable", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void c(int i2) {
        if (this.q && this.a != null) {
            if (i2 == 0 || i2 == 1) {
                HashMap map = new HashMap();
                map.put("enable", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.10
                    final /* synthetic */ Map a;

                    AnonymousClass10(Map map2) {
                        map = map2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a.sendCustomHit("biz_cache", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void d(int i2) {
        if (this.q && this.a != null) {
            if (i2 == 0 || i2 == 1) {
                HashMap map = new HashMap();
                map.put("enable", String.valueOf(i2));
                this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.11
                    final /* synthetic */ Map a;

                    AnonymousClass11(Map map2) {
                        map = map2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.a.sendCustomHit("biz_expired_ip", map);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void e(int i2) {
        try {
            if (this.q && this.a != null) {
                if (i2 == 0 || i2 == 1) {
                    HashMap map = new HashMap();
                    map.put("enable", String.valueOf(i2));
                    this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.12
                        final /* synthetic */ Map a;

                        AnonymousClass12(Map map2) {
                            map = map2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                b.this.a.sendCustomHit("biz_ipv6_enable", map);
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

    public void e(boolean z) {
        synchronized (b.class) {
            if (!this.r) {
                this.q = z;
            }
        }
    }

    public void k() {
        synchronized (b.class) {
            this.r = true;
            this.q = false;
        }
    }

    public void k(String str) {
        if (!this.q || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("exception", str);
        this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.2
            final /* synthetic */ Map a;

            AnonymousClass2(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.a.sendCustomHit("err_uncaught_exception", map);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void l() {
        if (this.q && this.a != null) {
            this.f16b.b().submit(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.d.b.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a.sendCustomHit("biz_active", null);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void setAccountId(String str) {
        AlicloudTracker alicloudTracker = this.a;
        if (alicloudTracker != null) {
            alicloudTracker.setGlobalProperty("accountId", str);
        }
    }
}
