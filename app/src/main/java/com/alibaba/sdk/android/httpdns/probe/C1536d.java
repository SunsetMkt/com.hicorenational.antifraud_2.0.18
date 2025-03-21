package com.alibaba.sdk.android.httpdns.probe;

/* renamed from: com.alibaba.sdk.android.httpdns.probe.d */
/* loaded from: classes.dex */
public final class C1536d {

    /* renamed from: a */
    private static IPProbeService f3979a;

    /* renamed from: a */
    public static synchronized IPProbeService m3568a(InterfaceC1534b interfaceC1534b) {
        IPProbeService iPProbeService;
        synchronized (C1536d.class) {
            if (f3979a == null) {
                f3979a = new C1537e();
                f3979a.setIPListUpdateCallback(interfaceC1534b);
            }
            iPProbeService = f3979a;
        }
        return iPProbeService;
    }
}
