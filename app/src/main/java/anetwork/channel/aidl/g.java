package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.f;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface g extends IInterface {
    void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException;

    void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException;

    void a(f fVar) throws RemoteException;

    boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException;

    byte j() throws RemoteException;

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements g {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2134a = "anetwork.channel.aidl.ParcelableNetworkListener";

        /* renamed from: b, reason: collision with root package name */
        static final int f2135b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2136c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2137d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f2138e = 4;

        /* renamed from: f, reason: collision with root package name */
        static final int f2139f = 5;

        public a() {
            attachInterface(this, f2134a);
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f2134a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof g)) ? new C0023a(iBinder) : (g) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2134a);
                a(parcel.readInt() != 0 ? DefaultProgressEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2134a);
                a(parcel.readInt() != 0 ? DefaultFinishEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(f2134a);
                boolean a2 = a(parcel.readInt(), parcel.readInt() != 0 ? ParcelableHeader.f2087c.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface(f2134a);
                a(f.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2134a);
                return true;
            }
            parcel.enforceInterface(f2134a);
            byte j2 = j();
            parcel2.writeNoException();
            parcel2.writeByte(j2);
            return true;
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.g$a$a, reason: collision with other inner class name */
        private static class C0023a implements g {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2140a;

            C0023a(IBinder iBinder) {
                this.f2140a = iBinder;
            }

            @Override // anetwork.channel.aidl.g
            public void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2134a);
                    if (defaultProgressEvent != null) {
                        obtain.writeInt(1);
                        defaultProgressEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2140a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2140a;
            }

            @Override // anetwork.channel.aidl.g
            public byte j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2134a);
                    this.f2140a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2134a);
                    if (defaultFinishEvent != null) {
                        obtain.writeInt(1);
                        defaultFinishEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2140a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public boolean a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2134a);
                    obtain.writeInt(i2);
                    if (parcelableHeader != null) {
                        obtain.writeInt(1);
                        parcelableHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2140a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.g
            public void a(f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2134a);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f2140a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
