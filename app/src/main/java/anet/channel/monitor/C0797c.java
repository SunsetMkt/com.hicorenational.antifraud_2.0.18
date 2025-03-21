package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.c */
/* loaded from: classes.dex */
class C0797c implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a */
    final /* synthetic */ C0796b f896a;

    C0797c(C0796b c0796b) {
        this.f896a = c0796b;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        C0799e c0799e;
        c0799e = this.f896a.f894n;
        c0799e.m537a();
        C0796b.f886f = 0L;
        this.f896a.m534d();
    }
}
