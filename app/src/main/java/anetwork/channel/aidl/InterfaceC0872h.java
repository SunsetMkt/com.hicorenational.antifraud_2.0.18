package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0865a;
import anetwork.channel.aidl.InterfaceC0869e;
import anetwork.channel.aidl.InterfaceC0871g;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.h */
/* loaded from: classes.dex */
public interface InterfaceC0872h extends IInterface {
    /* renamed from: a */
    NetworkResponse mo175a(ParcelableRequest parcelableRequest) throws RemoteException;

    /* renamed from: a */
    InterfaceC0869e mo176a(ParcelableRequest parcelableRequest, InterfaceC0871g interfaceC0871g) throws RemoteException;

    /* renamed from: b */
    InterfaceC0865a mo177b(ParcelableRequest parcelableRequest) throws RemoteException;

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.h$a */
    public static abstract class a extends Binder implements InterfaceC0872h {

        /* renamed from: a */
        private static final String f1268a = "anetwork.channel.aidl.RemoteNetwork";

        /* renamed from: b */
        static final int f1269b = 1;

        /* renamed from: c */
        static final int f1270c = 2;

        /* renamed from: d */
        static final int f1271d = 3;

        public a() {
            attachInterface(this, f1268a);
        }

        /* renamed from: a */
        public static InterfaceC0872h m780a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1268a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0872h)) ? new C7355a(iBinder) : (InterfaceC0872h) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f1268a);
                NetworkResponse mo175a = mo175a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (mo175a != null) {
                    parcel2.writeInt(1);
                    mo175a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f1268a);
                InterfaceC0869e mo176a = mo176a(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null, InterfaceC0871g.a.m779a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeStrongBinder(mo176a != null ? mo176a.asBinder() : null);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1268a);
                return true;
            }
            parcel.enforceInterface(f1268a);
            InterfaceC0865a mo177b = mo177b(parcel.readInt() != 0 ? ParcelableRequest.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeStrongBinder(mo177b != null ? mo177b.asBinder() : null);
            return true;
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.h$a$a, reason: collision with other inner class name */
        private static class C7355a implements InterfaceC0872h {

            /* renamed from: a */
            private IBinder f1272a;

            C7355a(IBinder iBinder) {
                this.f1272a = iBinder;
            }

            @Override // anetwork.channel.aidl.InterfaceC0872h
            /* renamed from: a */
            public NetworkResponse mo175a(ParcelableRequest parcelableRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1268a);
                    if (parcelableRequest != null) {
                        obtain.writeInt(1);
                        parcelableRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1272a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1272a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0872h
            /* renamed from: b */
            public InterfaceC0865a mo177b(ParcelableRequest parcelableRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1268a);
                    if (parcelableRequest != null) {
                        obtain.writeInt(1);
                        parcelableRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1272a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return InterfaceC0865a.a.m765a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0872h
            /* renamed from: a */
            public InterfaceC0869e mo176a(ParcelableRequest parcelableRequest, InterfaceC0871g interfaceC0871g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1268a);
                    if (parcelableRequest != null) {
                        obtain.writeInt(1);
                        parcelableRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(interfaceC0871g != null ? interfaceC0871g.asBinder() : null);
                    this.f1272a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return InterfaceC0869e.a.m770a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
