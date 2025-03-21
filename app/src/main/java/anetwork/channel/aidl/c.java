package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.b;
import anetwork.channel.aidl.h;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class c extends b.a {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NetworkService f2114c;

    c(NetworkService networkService) {
        this.f2114c = networkService;
    }

    @Override // anetwork.channel.aidl.b
    public h get(int i2) throws RemoteException {
        h.a aVar;
        h.a aVar2;
        if (i2 == 1) {
            aVar2 = this.f2114c.f2084b;
            return aVar2;
        }
        aVar = this.f2114c.f2085c;
        return aVar;
    }
}
