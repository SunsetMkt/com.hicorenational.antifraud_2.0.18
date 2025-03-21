package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdManager.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    public static class C0134a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String e(String str) throws RemoteException {
            return null;
        }
    }

    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    /* compiled from: IDeviceIdManager.java */
    public static abstract class b extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        static final int f10009a = 1;

        /* renamed from: b, reason: collision with root package name */
        static final int f10010b = 2;

        /* renamed from: c, reason: collision with root package name */
        static final int f10011c = 3;

        /* renamed from: d, reason: collision with root package name */
        static final int f10012d = 4;

        /* renamed from: e, reason: collision with root package name */
        static final int f10013e = 5;

        /* renamed from: f, reason: collision with root package name */
        static final int f10014f = 6;

        /* renamed from: g, reason: collision with root package name */
        static final int f10015g = 7;

        /* renamed from: h, reason: collision with root package name */
        private static final String f10016h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public b() {
            attachInterface(this, f10016h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f10016h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0135a(iBinder) : (a) queryLocalInterface;
        }

        public static a c() {
            return C0135a.f10017a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f10016h);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f10016h);
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(f10016h);
                    String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(f10016h);
                    String c2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c2);
                    return true;
                case 4:
                    parcel.enforceInterface(f10016h);
                    String d2 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(d2);
                    return true;
                case 5:
                    parcel.enforceInterface(f10016h);
                    String e2 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e2);
                    return true;
                case 6:
                    parcel.enforceInterface(f10016h);
                    boolean a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f10016h);
                    String b3 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        public static boolean a(a aVar) {
            if (C0135a.f10017a != null || aVar == null) {
                return false;
            }
            C0135a.f10017a = aVar;
            return true;
        }

        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.umeng.analytics.pro.a$b$a, reason: collision with other inner class name */
        private static class C0135a implements a {

            /* renamed from: a, reason: collision with root package name */
            public static a f10017a;

            /* renamed from: b, reason: collision with root package name */
            private IBinder f10018b;

            C0135a(IBinder iBinder) {
                this.f10018b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    obtain.writeString(str);
                    if (!this.f10018b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a(str);
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
                return this.f10018b;
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    obtain.writeString(str);
                    if (!this.f10018b.transact(2, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.f10016h;
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    obtain.writeString(str);
                    if (!this.f10018b.transact(3, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    obtain.writeString(str);
                    if (!this.f10018b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    obtain.writeString(str);
                    if (!this.f10018b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    if (!this.f10018b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f10016h);
                    if (!this.f10018b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b();
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
