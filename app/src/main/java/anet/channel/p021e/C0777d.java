package anet.channel.p021e;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* renamed from: anet.channel.e.d */
/* loaded from: classes.dex */
final class C0777d implements NetworkStatusHelper.INetworkStatusChangeListener {
    C0777d() {
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        C0774a.m494a(networkStatus);
    }
}
