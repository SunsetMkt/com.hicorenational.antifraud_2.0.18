package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdService.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: IDeviceIdService.java */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0136b extends Binder implements b {

        /* renamed from: a, reason: collision with root package name */
        static final int f10104a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f10105b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f10106c = 3;

        /* renamed from: d, reason: collision with root package name */
        private static final String f10107d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC0136b() {
            attachInterface(this, f10107d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f10107d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static b b() {
            return a.f10108a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f10107d);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f10107d);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f10107d);
                return true;
            }
            parcel.enforceInterface(f10107d);
            String b2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }

        public static boolean a(b bVar) {
            if (a.f10108a != null || bVar == null) {
                return false;
            }
            a.f10108a = bVar;
            return true;
        }

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        private static class a implements b {

            /* renamed from: a, reason: collision with root package name */
            public static b f10108a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10109b;

            a(IBinder iBinder) {
                this.f10109b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    if (!this.f10109b.transact(1, obtain, obtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f10109b;
            }

            public String b() {
                return AbstractBinderC0136b.f10107d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    obtain.writeString(str);
                    if (!this.f10109b.transact(3, obtain, obtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0136b.f10107d);
                    obtain.writeString(str);
                    if (!this.f10109b.transact(2, obtain, obtain2, 0) && AbstractBinderC0136b.b() != null) {
                        return AbstractBinderC0136b.b().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
