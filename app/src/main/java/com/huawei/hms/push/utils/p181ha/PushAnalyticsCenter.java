package com.huawei.hms.push.utils.p181ha;

/* loaded from: classes.dex */
public class PushAnalyticsCenter {

    /* renamed from: a */
    private PushBaseAnalytics f7811a;

    /* renamed from: com.huawei.hms.push.utils.ha.PushAnalyticsCenter$a */
    private static class C2504a {

        /* renamed from: a */
        private static PushAnalyticsCenter f7812a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return C2504a.f7812a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f7811a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f7811a = pushBaseAnalytics;
    }
}
