package com.huawei.hms.push.utils.ha;

/* JADX INFO: loaded from: classes.dex */
public class PushAnalyticsCenter {
    private PushBaseAnalytics a;

    private static class a {
        private static PushAnalyticsCenter a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.a = pushBaseAnalytics;
    }
}
