package com.alibaba.sdk.android.httpdns.probe;

/* loaded from: classes.dex */
public interface IPProbeService {

    /* renamed from: com.alibaba.sdk.android.httpdns.probe.IPProbeService$a */
    public enum EnumC1532a {
        NO_PROBING,
        PROBING
    }

    EnumC1532a getProbeStatus(String str);

    void launchIPProbeTask(String str, int i2, String[] strArr);

    void setIPListUpdateCallback(InterfaceC1534b interfaceC1534b);

    boolean stopIPProbeTask(String str);
}
