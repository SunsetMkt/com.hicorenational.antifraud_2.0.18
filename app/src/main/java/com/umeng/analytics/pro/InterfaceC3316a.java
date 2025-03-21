package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdManager.java */
/* renamed from: com.umeng.analytics.pro.a */
/* loaded from: classes2.dex */
public interface InterfaceC3316a extends IInterface {

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$a */
    public static class a implements InterfaceC3316a {
        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: a */
        public String mo10798a(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: a */
        public boolean mo10799a() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: b */
        public String mo10800b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: b */
        public String mo10801b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: c */
        public String mo10802c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: d */
        public String mo10803d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3316a
        /* renamed from: e */
        public String mo10804e(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: a */
    String mo10798a(String str) throws RemoteException;

    /* renamed from: a */
    boolean mo10799a() throws RemoteException;

    /* renamed from: b */
    String mo10800b() throws RemoteException;

    /* renamed from: b */
    String mo10801b(String str) throws RemoteException;

    /* renamed from: c */
    String mo10802c(String str) throws RemoteException;

    /* renamed from: d */
    String mo10803d(String str) throws RemoteException;

    /* renamed from: e */
    String mo10804e(String str) throws RemoteException;

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$b */
    public static abstract class b extends Binder implements InterfaceC3316a {

        /* renamed from: a */
        static final int f11411a = 1;

        /* renamed from: b */
        static final int f11412b = 2;

        /* renamed from: c */
        static final int f11413c = 3;

        /* renamed from: d */
        static final int f11414d = 4;

        /* renamed from: e */
        static final int f11415e = 5;

        /* renamed from: f */
        static final int f11416f = 6;

        /* renamed from: g */
        static final int f11417g = 7;

        /* renamed from: h */
        private static final String f11418h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public b() {
            attachInterface(this, f11418h);
        }

        /* renamed from: a */
        public static InterfaceC3316a m10805a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f11418h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC3316a)) ? new a(iBinder) : (InterfaceC3316a) queryLocalInterface;
        }

        /* renamed from: c */
        public static InterfaceC3316a m10807c() {
            return a.f11419a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f11418h);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f11418h);
                    String mo10798a = mo10798a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo10798a);
                    return true;
                case 2:
                    parcel.enforceInterface(f11418h);
                    String mo10801b = mo10801b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo10801b);
                    return true;
                case 3:
                    parcel.enforceInterface(f11418h);
                    String mo10802c = mo10802c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo10802c);
                    return true;
                case 4:
                    parcel.enforceInterface(f11418h);
                    String mo10803d = mo10803d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo10803d);
                    return true;
                case 5:
                    parcel.enforceInterface(f11418h);
                    String mo10804e = mo10804e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo10804e);
                    return true;
                case 6:
                    parcel.enforceInterface(f11418h);
                    boolean mo10799a = mo10799a();
                    parcel2.writeNoException();
                    parcel2.writeInt(mo10799a ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(f11418h);
                    String mo10800b = mo10800b();
                    parcel2.writeNoException();
                    parcel2.writeString(mo10800b);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* renamed from: a */
        public static boolean m10806a(InterfaceC3316a interfaceC3316a) {
            if (a.f11419a != null || interfaceC3316a == null) {
                return false;
            }
            a.f11419a = interfaceC3316a;
            return true;
        }

        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.umeng.analytics.pro.a$b$a */
        private static class a implements InterfaceC3316a {

            /* renamed from: a */
            public static InterfaceC3316a f11419a;

            /* renamed from: b */
            private IBinder f11420b;

            a(IBinder iBinder) {
                this.f11420b = iBinder;
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: a */
            public String mo10798a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    obtain.writeString(str);
                    if (!this.f11420b.transact(1, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10798a(str);
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
                return this.f11420b;
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: b */
            public String mo10801b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    obtain.writeString(str);
                    if (!this.f11420b.transact(2, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10801b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public String m10808c() {
                return b.f11418h;
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: c */
            public String mo10802c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    obtain.writeString(str);
                    if (!this.f11420b.transact(3, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10802c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: d */
            public String mo10803d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    obtain.writeString(str);
                    if (!this.f11420b.transact(4, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10803d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: e */
            public String mo10804e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    obtain.writeString(str);
                    if (!this.f11420b.transact(5, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10804e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: a */
            public boolean mo10799a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    if (!this.f11420b.transact(6, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10799a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.InterfaceC3316a
            /* renamed from: b */
            public String mo10800b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11418h);
                    if (!this.f11420b.transact(7, obtain, obtain2, 0) && b.m10807c() != null) {
                        return b.m10807c().mo10800b();
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
