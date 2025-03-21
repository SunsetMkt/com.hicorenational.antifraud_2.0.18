package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0872h;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.b */
/* loaded from: classes.dex */
public interface InterfaceC0866b extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.b$a */
    public static abstract class a extends Binder implements InterfaceC0866b {

        /* renamed from: a */
        private static final String f1238a = "anetwork.channel.aidl.IRemoteNetworkGetter";

        /* renamed from: b */
        static final int f1239b = 1;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.b$a$a, reason: collision with other inner class name */
        private static class C7350a implements InterfaceC0866b {

            /* renamed from: a */
            private IBinder f1240a;

            C7350a(IBinder iBinder) {
                this.f1240a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1240a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0866b
            public InterfaceC0872h get(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1238a);
                    obtain.writeInt(i2);
                    this.f1240a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return InterfaceC0872h.a.m780a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f1238a);
        }

        /* renamed from: a */
        public static InterfaceC0866b m766a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1238a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0866b)) ? new C7350a(iBinder) : (InterfaceC0866b) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1238a);
                return true;
            }
            parcel.enforceInterface(f1238a);
            InterfaceC0872h interfaceC0872h = get(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(interfaceC0872h != null ? interfaceC0872h.asBinder() : null);
            return true;
        }
    }

    InterfaceC0872h get(int i2) throws RemoteException;
}
