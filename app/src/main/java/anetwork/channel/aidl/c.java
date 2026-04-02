package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.b;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class c extends b.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NetworkService f1700c;

    c(NetworkService networkService) {
        this.f1700c = networkService;
    }

    @Override // anetwork.channel.aidl.b
    public h get(int i2) throws RemoteException {
        return i2 == 1 ? this.f1700c.f1675b : this.f1700c.f1676c;
    }
}
