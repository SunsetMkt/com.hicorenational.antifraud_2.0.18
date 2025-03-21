package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.a */
/* loaded from: classes.dex */
class C0759a implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ExceptionDetector f787a;

    C0759a(ExceptionDetector exceptionDetector) {
        this.f787a = exceptionDetector;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitDetectTask(new RunnableC0760b(this));
    }
}
