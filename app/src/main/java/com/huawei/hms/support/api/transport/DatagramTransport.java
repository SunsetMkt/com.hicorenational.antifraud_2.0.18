package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* loaded from: classes.dex */
public interface DatagramTransport {

    /* renamed from: com.huawei.hms.support.api.transport.DatagramTransport$a */
    public interface InterfaceC2523a {
        /* renamed from: a */
        void mo7669a(int i2, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, InterfaceC2523a interfaceC2523a);

    void send(ApiClient apiClient, InterfaceC2523a interfaceC2523a);
}
