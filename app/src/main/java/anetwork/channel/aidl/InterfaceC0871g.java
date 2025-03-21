package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0870f;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.g */
/* loaded from: classes.dex */
public interface InterfaceC0871g extends IInterface {
    /* renamed from: a */
    void mo774a(DefaultFinishEvent defaultFinishEvent) throws RemoteException;

    /* renamed from: a */
    void mo775a(DefaultProgressEvent defaultProgressEvent) throws RemoteException;

    /* renamed from: a */
    void mo776a(InterfaceC0870f interfaceC0870f) throws RemoteException;

    /* renamed from: a */
    boolean mo777a(int i2, ParcelableHeader parcelableHeader) throws RemoteException;

    /* renamed from: j */
    byte mo778j() throws RemoteException;

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.g$a */
    public static abstract class a extends Binder implements InterfaceC0871g {

        /* renamed from: a */
        private static final String f1261a = "anetwork.channel.aidl.ParcelableNetworkListener";

        /* renamed from: b */
        static final int f1262b = 1;

        /* renamed from: c */
        static final int f1263c = 2;

        /* renamed from: d */
        static final int f1264d = 3;

        /* renamed from: e */
        static final int f1265e = 4;

        /* renamed from: f */
        static final int f1266f = 5;

        public a() {
            attachInterface(this, f1261a);
        }

        /* renamed from: a */
        public static InterfaceC0871g m779a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1261a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0871g)) ? new C7354a(iBinder) : (InterfaceC0871g) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f1261a);
                mo775a(parcel.readInt() != 0 ? DefaultProgressEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f1261a);
                mo774a(parcel.readInt() != 0 ? DefaultFinishEvent.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(f1261a);
                boolean mo777a = mo777a(parcel.readInt(), parcel.readInt() != 0 ? ParcelableHeader.f1213c.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(mo777a ? 1 : 0);
                return true;
            }
            if (i2 == 4) {
                parcel.enforceInterface(f1261a);
                mo776a(InterfaceC0870f.a.m773a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1261a);
                return true;
            }
            parcel.enforceInterface(f1261a);
            byte mo778j = mo778j();
            parcel2.writeNoException();
            parcel2.writeByte(mo778j);
            return true;
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.g$a$a, reason: collision with other inner class name */
        private static class C7354a implements InterfaceC0871g {

            /* renamed from: a */
            private IBinder f1267a;

            C7354a(IBinder iBinder) {
                this.f1267a = iBinder;
            }

            @Override // anetwork.channel.aidl.InterfaceC0871g
            /* renamed from: a */
            public void mo775a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1261a);
                    if (defaultProgressEvent != null) {
                        obtain.writeInt(1);
                        defaultProgressEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1267a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0871g
            /* renamed from: j */
            public byte mo778j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1261a);
                    this.f1267a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0871g
            /* renamed from: a */
            public void mo774a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1261a);
                    if (defaultFinishEvent != null) {
                        obtain.writeInt(1);
                        defaultFinishEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0871g
            /* renamed from: a */
            public boolean mo777a(int i2, ParcelableHeader parcelableHeader) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1261a);
                    obtain.writeInt(i2);
                    if (parcelableHeader != null) {
                        obtain.writeInt(1);
                        parcelableHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0871g
            /* renamed from: a */
            public void mo776a(InterfaceC0870f interfaceC0870f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1261a);
                    obtain.writeStrongBinder(interfaceC0870f != null ? interfaceC0870f.asBinder() : null);
                    this.f1267a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
