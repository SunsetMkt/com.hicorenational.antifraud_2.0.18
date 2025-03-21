package anetwork.channel.aidl.p022j;

import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0868d;
import p000a.p001a.InterfaceC0001b;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.j.b */
/* loaded from: classes.dex */
public class BinderC0875b extends InterfaceC0868d.a {

    /* renamed from: e */
    private static final String f1282e = "anet.ParcelableBodyHandlerWrapper";

    /* renamed from: d */
    private InterfaceC0001b f1283d;

    public BinderC0875b(InterfaceC0001b interfaceC0001b) {
        this.f1283d = interfaceC0001b;
    }

    @Override // anetwork.channel.aidl.InterfaceC0868d
    /* renamed from: g */
    public boolean mo767g() throws RemoteException {
        InterfaceC0001b interfaceC0001b = this.f1283d;
        if (interfaceC0001b != null) {
            return interfaceC0001b.m0g();
        }
        return true;
    }

    @Override // anetwork.channel.aidl.InterfaceC0868d
    public int read(byte[] bArr) throws RemoteException {
        InterfaceC0001b interfaceC0001b = this.f1283d;
        if (interfaceC0001b != null) {
            return interfaceC0001b.read(bArr);
        }
        return 0;
    }

    public String toString() {
        return super.toString() + " handle:" + this.f1283d;
    }
}
