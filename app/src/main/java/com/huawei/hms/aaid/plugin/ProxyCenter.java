package com.huawei.hms.aaid.plugin;

/* loaded from: classes.dex */
public class ProxyCenter {
    private PushProxy proxy;

    /* renamed from: com.huawei.hms.aaid.plugin.ProxyCenter$a */
    private static class C2282a {

        /* renamed from: a */
        private static ProxyCenter f7012a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return C2282a.f7012a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
