package anetwork.channel.aidl;

import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0866b;
import anetwork.channel.aidl.InterfaceC0872h;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.c */
/* loaded from: classes.dex */
class BinderC0867c extends InterfaceC0866b.a {

    /* renamed from: c */
    final /* synthetic */ NetworkService f1241c;

    BinderC0867c(NetworkService networkService) {
        this.f1241c = networkService;
    }

    @Override // anetwork.channel.aidl.InterfaceC0866b
    public InterfaceC0872h get(int i2) throws RemoteException {
        InterfaceC0872h.a aVar;
        InterfaceC0872h.a aVar2;
        if (i2 == 1) {
            aVar2 = this.f1241c.f1210b;
            return aVar2;
        }
        aVar = this.f1241c.f1211c;
        return aVar;
    }
}
