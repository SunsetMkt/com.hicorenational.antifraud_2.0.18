package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.m */
/* loaded from: classes.dex */
class RunnableC0771m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f807a;

    /* renamed from: b */
    final /* synthetic */ C0770l f808b;

    RunnableC0771m(C0770l c0770l, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f808b = c0770l;
        this.f807a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f807a != NetworkStatusHelper.NetworkStatus.NO && this.f807a != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f808b.f806a.m480a(NetworkStatusHelper.getUniqueId(this.f807a));
            }
        } catch (Throwable th) {
            ALog.m714e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
