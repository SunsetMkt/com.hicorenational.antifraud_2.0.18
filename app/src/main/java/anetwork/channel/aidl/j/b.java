package anetwork.channel.aidl.j;

import android.os.RemoteException;
import anetwork.channel.aidl.d;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b extends d.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f1729e = "anet.ParcelableBodyHandlerWrapper";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.a.b f1730d;

    public b(b.a.b bVar) {
        this.f1730d = bVar;
    }

    @Override // anetwork.channel.aidl.d
    public boolean g() throws RemoteException {
        b.a.b bVar = this.f1730d;
        if (bVar != null) {
            return bVar.g();
        }
        return true;
    }

    @Override // anetwork.channel.aidl.d
    public int read(byte[] bArr) throws RemoteException {
        b.a.b bVar = this.f1730d;
        if (bVar != null) {
            return bVar.read(bArr);
        }
        return 0;
    }

    public String toString() {
        return super.toString() + " handle:" + this.f1730d;
    }
}
