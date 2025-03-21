package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import com.huawei.hms.framework.network.grs.p174f.C2365b;
import com.huawei.hms.framework.network.grs.p175g.C2375g;
import com.huawei.hms.framework.network.grs.p175g.C2376h;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import com.huawei.hms.framework.network.grs.p178h.C2382a;
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
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.huawei.hms.framework.network.grs.c */
/* loaded from: classes.dex */
public class C2359c {

    /* renamed from: i */
    private static final String f7336i = "c";

    /* renamed from: j */
    private static final ExecutorService f7337j = ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");

    /* renamed from: k */
    private static long f7338k = 0;

    /* renamed from: a */
    private GrsBaseInfo f7339a;

    /* renamed from: b */
    private Context f7340b;

    /* renamed from: c */
    private C2375g f7341c;

    /* renamed from: d */
    private C2361a f7342d;

    /* renamed from: e */
    private C2363c f7343e;

    /* renamed from: f */
    private C2363c f7344f;

    /* renamed from: g */
    private C2357a f7345g;

    /* renamed from: h */
    private FutureTask<Boolean> f7346h;

    /* renamed from: com.huawei.hms.framework.network.grs.c$a */
    class a implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Context f7347a;

        /* renamed from: b */
        final /* synthetic */ GrsBaseInfo f7348b;

        a(Context context, GrsBaseInfo grsBaseInfo) {
            this.f7347a = context;
            this.f7348b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            C2359c.this.f7341c = new C2375g();
            C2359c.this.f7343e = new C2363c(this.f7347a, GrsApp.getInstance().getBrand(AbstractC1191a.f2606s1) + "share_pre_grs_conf_");
            C2359c.this.f7344f = new C2363c(this.f7347a, GrsApp.getInstance().getBrand(AbstractC1191a.f2606s1) + "share_pre_grs_services_");
            C2359c c2359c = C2359c.this;
            c2359c.f7342d = new C2361a(c2359c.f7343e, C2359c.this.f7344f, C2359c.this.f7341c);
            C2359c c2359c2 = C2359c.this;
            c2359c2.f7345g = new C2357a(c2359c2.f7339a, C2359c.this.f7342d, C2359c.this.f7341c, C2359c.this.f7344f);
            if (C2365b.m6881a(this.f7347a.getPackageName()) == null) {
                new C2365b(this.f7347a, true);
            }
            String m6964c = new C2380c(this.f7348b, this.f7347a).m6964c();
            Logger.m6801v(C2359c.f7336i, "scan serviceSet is: " + m6964c);
            String m6857a = C2359c.this.f7344f.m6857a("services", "");
            String m6954a = C2376h.m6954a(m6857a, m6964c);
            if (!TextUtils.isEmpty(m6954a)) {
                C2359c.this.f7344f.m6861b("services", m6954a);
                Logger.m6799i(C2359c.f7336i, "postList is:" + StringUtils.anonymizeMessage(m6954a));
                Logger.m6799i(C2359c.f7336i, "currentServices:" + StringUtils.anonymizeMessage(m6857a));
                if (!m6954a.equals(m6857a)) {
                    C2359c.this.f7341c.m6953a(C2359c.this.f7339a.getGrsParasKey(true, true, this.f7347a));
                    C2359c.this.f7341c.m6952a(new C2380c(this.f7348b, this.f7347a), null, null, C2359c.this.f7344f, C2359c.this.f7339a.getQueryTimeout());
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - C2359c.f7338k;
            if (C2359c.f7338k == 0 || TimeUnit.MILLISECONDS.toHours(elapsedRealtime) > 24) {
                Logger.m6799i(C2359c.f7336i, "Try to clear unUsed sp data.");
                long unused = C2359c.f7338k = SystemClock.elapsedRealtime();
                C2359c c2359c3 = C2359c.this;
                c2359c3.m6827a(c2359c3.f7343e.m6858a());
            }
            C2359c.this.f7342d.m6852b(this.f7348b, this.f7347a);
            return true;
        }
    }

    C2359c(Context context, GrsBaseInfo grsBaseInfo) {
        this.f7346h = null;
        this.f7340b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        m6825a(grsBaseInfo);
        GrsBaseInfo grsBaseInfo2 = this.f7339a;
        this.f7346h = new FutureTask<>(new a(this.f7340b, grsBaseInfo2));
        f7337j.execute(this.f7346h);
        Logger.m6800i(f7336i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s ,queryTimeout=%d", C2382a.m6972a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry(), Integer.valueOf(grsBaseInfo.getQueryTimeout()));
    }

    C2359c(GrsBaseInfo grsBaseInfo) {
        this.f7346h = null;
        m6825a(grsBaseInfo);
    }

    /* renamed from: a */
    private void m6825a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f7339a = grsBaseInfo.m26853clone();
        } catch (CloneNotSupportedException e2) {
            Logger.m6804w(f7336i, "GrsClient catch CloneNotSupportedException", e2);
            this.f7339a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6827a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.m6801v(f7336i, "sp's content is empty.");
            return;
        }
        Set<String> keySet = map.keySet();
        for (String str : keySet) {
            if (str.endsWith(this.f7340b.getPackageName() + "time")) {
                String m6857a = this.f7343e.m6857a(str, "");
                long j2 = 0;
                if (!TextUtils.isEmpty(m6857a) && m6857a.matches("\\d+")) {
                    try {
                        j2 = Long.parseLong(m6857a);
                    } catch (NumberFormatException e2) {
                        Logger.m6804w(f7336i, "convert expire time from String to Long catch NumberFormatException.", e2);
                    }
                }
                String substring = str.substring(0, str.length() - 4);
                String str2 = substring + HttpHeaders.ETAG;
                if (!m6830b(j2) || !keySet.contains(substring) || !keySet.contains(str2)) {
                    Logger.m6799i(f7336i, "init interface auto clear some invalid sp's data: " + str);
                    this.f7343e.m6859a(substring);
                    this.f7343e.m6859a(str);
                    this.f7343e.m6859a(str2);
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m6830b(long j2) {
        return System.currentTimeMillis() - j2 <= 604800000;
    }

    /* renamed from: e */
    private boolean m6836e() {
        String str;
        String str2;
        FutureTask<Boolean> futureTask = this.f7346h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, TimeUnit.SECONDS).booleanValue();
        } catch (InterruptedException e2) {
            e = e2;
            str = f7336i;
            str2 = "init compute task interrupted.";
            Logger.m6804w(str, str2, e);
            return false;
        } catch (CancellationException unused) {
            Logger.m6799i(f7336i, "init compute task canceled.");
            return false;
        } catch (ExecutionException e3) {
            e = e3;
            str = f7336i;
            str2 = "init compute task failed.";
            Logger.m6804w(str, str2, e);
            return false;
        } catch (TimeoutException unused2) {
            Logger.m6803w(f7336i, "init compute task timed out");
            return false;
        } catch (Exception e4) {
            e = e4;
            str = f7336i;
            str2 = "init compute task occur unknown Exception";
            Logger.m6804w(str, str2, e);
            return false;
        }
    }

    /* renamed from: a */
    String m6837a(String str, String str2, int i2) {
        if (this.f7339a == null || str == null || str2 == null) {
            Logger.m6803w(f7336i, "invalid para!");
            return null;
        }
        if (m6836e()) {
            return this.f7345g.m6813a(str, str2, this.f7340b, i2);
        }
        return null;
    }

    /* renamed from: a */
    Map<String, String> m6838a(String str, int i2) {
        if (this.f7339a != null && str != null) {
            return m6836e() ? this.f7345g.m6814a(str, this.f7340b, i2) : new HashMap();
        }
        Logger.m6803w(f7336i, "invalid para!");
        return new HashMap();
    }

    /* renamed from: a */
    void m6839a() {
        if (m6836e()) {
            String grsParasKey = this.f7339a.getGrsParasKey(true, true, this.f7340b);
            this.f7343e.m6859a(grsParasKey);
            this.f7343e.m6859a(grsParasKey + "time");
            this.f7343e.m6859a(grsParasKey + HttpHeaders.ETAG);
            this.f7341c.m6953a(grsParasKey);
        }
    }

    /* renamed from: a */
    void m6840a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, int i2) {
        if (iQueryUrlsCallBack == null) {
            Logger.m6803w(f7336i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.f7339a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (m6836e()) {
            this.f7345g.m6815a(str, iQueryUrlsCallBack, this.f7340b, i2);
        } else {
            Logger.m6799i(f7336i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    /* renamed from: a */
    void m6841a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, int i2) {
        if (iQueryUrlCallBack == null) {
            Logger.m6803w(f7336i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.f7339a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (m6836e()) {
            this.f7345g.m6816a(str, str2, iQueryUrlCallBack, this.f7340b, i2);
        } else {
            Logger.m6799i(f7336i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    /* renamed from: a */
    boolean m6842a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C2359c.class == obj.getClass() && (obj instanceof C2359c)) {
            return this.f7339a.compare(((C2359c) obj).f7339a);
        }
        return false;
    }

    /* renamed from: b */
    boolean m6843b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!m6836e() || (grsBaseInfo = this.f7339a) == null || (context = this.f7340b) == null) {
            return false;
        }
        this.f7342d.m6849a(grsBaseInfo, context);
        return true;
    }
}
