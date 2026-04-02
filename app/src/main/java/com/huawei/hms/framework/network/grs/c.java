package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.g.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4601i = "c";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ExecutorService f4602j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f4603k = 0;
    private GrsBaseInfo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f4605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.a f4606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f4607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.e.c f4608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a f4609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FutureTask<Boolean> f4610h;

    class a implements Callable<Boolean> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GrsBaseInfo f4611b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.f4611b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c.this.f4605c = new g();
            c.this.f4607e = new com.huawei.hms.framework.network.grs.e.c(this.a, GrsApp.getInstance().getBrand(d.c.a.b.a.a.s1) + "share_pre_grs_conf_");
            c.this.f4608f = new com.huawei.hms.framework.network.grs.e.c(this.a, GrsApp.getInstance().getBrand(d.c.a.b.a.a.s1) + "share_pre_grs_services_");
            c cVar = c.this;
            cVar.f4606d = new com.huawei.hms.framework.network.grs.e.a(cVar.f4607e, c.this.f4608f, c.this.f4605c);
            c cVar2 = c.this;
            cVar2.f4609g = new com.huawei.hms.framework.network.grs.a(cVar2.a, c.this.f4606d, c.this.f4605c, c.this.f4608f);
            if (com.huawei.hms.framework.network.grs.f.b.a(this.a.getPackageName()) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.a, true);
            }
            String strC = new com.huawei.hms.framework.network.grs.g.j.c(this.f4611b, this.a).c();
            Logger.v(c.f4601i, "scan serviceSet is: " + strC);
            String strA = c.this.f4608f.a("services", "");
            String strA2 = h.a(strA, strC);
            if (!TextUtils.isEmpty(strA2)) {
                c.this.f4608f.b("services", strA2);
                Logger.i(c.f4601i, "postList is:" + StringUtils.anonymizeMessage(strA2));
                Logger.i(c.f4601i, "currentServices:" + StringUtils.anonymizeMessage(strA));
                if (!strA2.equals(strA)) {
                    c.this.f4605c.a(c.this.a.getGrsParasKey(true, true, this.a));
                    c.this.f4605c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.f4611b, this.a), null, null, c.this.f4608f, c.this.a.getQueryTimeout());
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - c.f4603k;
            if (c.f4603k == 0 || TimeUnit.MILLISECONDS.toHours(jElapsedRealtime) > 24) {
                Logger.i(c.f4601i, "Try to clear unUsed sp data.");
                long unused = c.f4603k = SystemClock.elapsedRealtime();
                c cVar3 = c.this;
                cVar3.a(cVar3.f4607e.a());
            }
            c.this.f4606d.b(this.f4611b, this.a);
            return true;
        }
    }

    c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f4610h = null;
        this.f4604b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.a;
        this.f4610h = new FutureTask<>(new a(this.f4604b, grsBaseInfo2));
        f4602j.execute(this.f4610h);
        Logger.i(f4601i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    c(GrsBaseInfo grsBaseInfo) {
        this.f4610h = null;
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.a = grsBaseInfo.m37clone();
        } catch (CloneNotSupportedException e2) {
            Logger.w(f4601i, "GrsClient catch CloneNotSupportedException", e2);
            this.a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f4601i, "sp's content is empty.");
            return;
        }
        Set<String> setKeySet = map.keySet();
        for (String str : setKeySet) {
            if (str.endsWith(this.f4604b.getPackageName() + "time")) {
                String strA = this.f4607e.a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(strA) && strA.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(strA);
                    } catch (NumberFormatException e2) {
                        Logger.w(f4601i, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                String strSubstring = str.substring(0, str.length() - 4);
                String str2 = strSubstring + HttpHeaders.ETAG;
                if (!b(j2) || !setKeySet.contains(strSubstring) || !setKeySet.contains(str2)) {
                    Logger.i(f4601i, "init interface auto clear some invalid sp's data: " + str);
                    this.f4607e.a(strSubstring);
                    this.f4607e.a(str);
                    this.f4607e.a(str2);
                }
            }
        }
    }

    private boolean b(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f4610h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e2) {
            e = e2;
            str = f4601i;
            str2 = "init compute task interrupted.";
            Logger.w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f4601i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e3) {
            e = e3;
            str = f4601i;
            str2 = "init compute task failed.";
            Logger.w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f4601i, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            e = e4;
            str = f4601i;
            str2 = "init compute task occur unknown Exception";
            Logger.w(str, str2, e);
            return false;
        }
    }

    String a(String str, String str2, int i2) {
        if (this.a == null || str == null || str2 == null) {
            Logger.w(f4601i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.f4609g.a(str, str2, this.f4604b, i2);
        }
        return null;
    }

    Map<String, String> a(String str, int i2) {
        if (this.a != null && str != null) {
            return e() ? this.f4609g.a(str, this.f4604b, i2) : new HashMap();
        }
        Logger.w(f4601i, "invalid para!");
        return new HashMap();
    }

    void a() {
        if (e()) {
            String grsParasKey = this.a.getGrsParasKey(true, true, this.f4604b);
            this.f4607e.a(grsParasKey);
            this.f4607e.a(grsParasKey + "time");
            this.f4607e.a(grsParasKey + HttpHeaders.ETAG);
            this.f4605c.a(grsParasKey);
        }
    }

    void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i2) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f4601i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f4609g.a(str, iQueryUrlsCallBack, this.f4604b, i2);
        } else {
            Logger.i(f4601i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i2) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f4601i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.f4609g.a(str, str2, iQueryUrlCallBack, this.f4604b, i2);
        } else {
            Logger.i(f4601i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass() && (obj instanceof c)) {
            return this.a.compare(((c) obj).a);
        }
        return false;
    }

    boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!e() || (grsBaseInfo = this.a) == null || (context = this.f4604b) == null) {
            return false;
        }
        this.f4606d.a(grsBaseInfo, context);
        return true;
    }
}
