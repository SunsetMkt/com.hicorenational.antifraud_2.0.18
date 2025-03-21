package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceIdService.java */
/* renamed from: com.umeng.analytics.pro.b */
/* loaded from: classes2.dex */
public interface InterfaceC3343b extends IInterface {

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$a */
    public static class a implements InterfaceC3343b {
        @Override // com.umeng.analytics.pro.InterfaceC3343b
        /* renamed from: a */
        public String mo10889a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3343b
        /* renamed from: a */
        public String mo10890a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.InterfaceC3343b
        /* renamed from: b */
        public String mo10891b(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: a */
    String mo10889a() throws RemoteException;

    /* renamed from: a */
    String mo10890a(String str) throws RemoteException;

    /* renamed from: b */
    String mo10891b(String str) throws RemoteException;

    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$b */
    public static abstract class b extends Binder implements InterfaceC3343b {

        /* renamed from: a */
        static final int f11537a = 1;

        /* renamed from: b */
        static final int f11538b = 2;

        /* renamed from: c */
        static final int f11539c = 3;

        /* renamed from: d */
        private static final String f11540d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public b() {
            attachInterface(this, f11540d);
        }

        /* renamed from: a */
        public static InterfaceC3343b m10892a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f11540d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC3343b)) ? new a(iBinder) : (InterfaceC3343b) queryLocalInterface;
        }

        /* renamed from: b */
        public static InterfaceC3343b m10894b() {
            return a.f11541a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f11540d);
                String mo10889a = mo10889a();
                parcel2.writeNoException();
                parcel2.writeString(mo10889a);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f11540d);
                String mo10890a = mo10890a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(mo10890a);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f11540d);
                return true;
            }
            parcel.enforceInterface(f11540d);
            String mo10891b = mo10891b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(mo10891b);
            return true;
        }

        /* renamed from: a */
        public static boolean m10893a(InterfaceC3343b interfaceC3343b) {
            if (a.f11541a != null || interfaceC3343b == null) {
                return false;
            }
            a.f11541a = interfaceC3343b;
            return true;
        }

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        private static class a implements InterfaceC3343b {

            /* renamed from: a */
            public static InterfaceC3343b f11541a;

            /* renamed from: b */
            private IBinder f11542b;

            a(IBinder iBinder) {
                this.f11542b = iBinder;
            }

            @Override // com.umeng.analytics.pro.InterfaceC3343b
            /* renamed from: a */
            public String mo10889a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11540d);
                    if (!this.f11542b.transact(1, obtain, obtain2, 0) && b.m10894b() != null) {
                        return b.m10894b().mo10889a();
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
                return this.f11542b;
            }

            /* renamed from: b */
            public String m10895b() {
                return b.f11540d;
            }

            @Override // com.umeng.analytics.pro.InterfaceC3343b
            /* renamed from: b */
            public String mo10891b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11540d);
                    obtain.writeString(str);
                    if (!this.f11542b.transact(3, obtain, obtain2, 0) && b.m10894b() != null) {
                        return b.m10894b().mo10891b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.InterfaceC3343b
            /* renamed from: a */
            public String mo10890a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f11540d);
                    obtain.writeString(str);
                    if (!this.f11542b.transact(2, obtain, obtain2, 0) && b.m10894b() != null) {
                        return b.m10894b().mo10890a(str);
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
