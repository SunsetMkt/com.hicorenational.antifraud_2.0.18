package com.huawei.hms.aaid.plugin;

/* JADX INFO: loaded from: classes.dex */
public class ProxyCenter {
    private PushProxy proxy;

    private static class a {
        private static ProxyCenter a = new ProxyCenter();
    }

    private static ProxyCenter getInstance() {
        return a.a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
