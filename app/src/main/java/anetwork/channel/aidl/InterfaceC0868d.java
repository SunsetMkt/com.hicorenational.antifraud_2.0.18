package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.d */
/* loaded from: classes.dex */
public interface InterfaceC0868d extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.d$a */
    public static abstract class a extends Binder implements InterfaceC0868d {

        /* renamed from: a */
        private static final String f1242a = "anetwork.channel.aidl.ParcelableBodyHandler";

        /* renamed from: b */
        static final int f1243b = 1;

        /* renamed from: c */
        static final int f1244c = 2;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.d$a$a, reason: collision with other inner class name */
        private static class C7351a implements InterfaceC0868d {

            /* renamed from: a */
            private IBinder f1245a;

            C7351a(IBinder iBinder) {
                this.f1245a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1245a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0868d
            /* renamed from: g */
            public boolean mo767g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1242a);
                    this.f1245a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0868d
            public int read(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1242a);
                    obtain.writeByteArray(bArr);
                    this.f1245a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f1242a);
        }

        /* renamed from: a */
        public static InterfaceC0868d m768a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1242a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0868d)) ? new C7351a(iBinder) : (InterfaceC0868d) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f1242a);
                byte[] createByteArray = parcel.createByteArray();
                int read = read(createByteArray);
                parcel2.writeNoException();
                parcel2.writeInt(read);
                parcel2.writeByteArray(createByteArray);
                return true;
            }
            if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1242a);
                return true;
            }
            parcel.enforceInterface(f1242a);
            boolean mo767g = mo767g();
            parcel2.writeNoException();
            parcel2.writeInt(mo767g ? 1 : 0);
            return true;
        }
    }

    /* renamed from: g */
    boolean mo767g() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;
}
