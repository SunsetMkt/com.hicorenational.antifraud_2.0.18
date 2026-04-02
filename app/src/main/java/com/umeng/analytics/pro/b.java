package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IDeviceIdService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b extends IInterface {

    /* JADX INFO: compiled from: IDeviceIdService.java */
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

    /* JADX INFO: renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IDeviceIdService.java */
    public static abstract class AbstractBinderC0124b extends Binder implements b {
        static final int a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f7044b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f7045c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f7046d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC0124b() {
            attachInterface(this, f7046d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f7046d);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b b() {
            return a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f7046d);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f7046d);
                String strA2 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f7046d);
                return true;
            }
            parcel.enforceInterface(f7046d);
            String strB = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        public static boolean a(b bVar) {
            if (a.a != null || bVar == null) {
                return false;
            }
            a.a = bVar;
            return true;
        }

        /* JADX INFO: renamed from: com.umeng.analytics.pro.b$b$a */
        /* JADX INFO: compiled from: IDeviceIdService.java */
        private static class a implements b {
            public static b a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private IBinder f7047b;

            a(IBinder iBinder) {
                this.f7047b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0124b.f7046d);
                    if (!this.f7047b.transact(1, parcelObtain, parcelObtain2, 0) && AbstractBinderC0124b.b() != null) {
                        return AbstractBinderC0124b.b().a();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7047b;
            }

            public String b() {
                return AbstractBinderC0124b.f7046d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0124b.f7046d);
                    parcelObtain.writeString(str);
                    if (!this.f7047b.transact(3, parcelObtain, parcelObtain2, 0) && AbstractBinderC0124b.b() != null) {
                        return AbstractBinderC0124b.b().b(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0124b.f7046d);
                    parcelObtain.writeString(str);
                    if (!this.f7047b.transact(2, parcelObtain, parcelObtain2, 0) && AbstractBinderC0124b.b() != null) {
                        return AbstractBinderC0124b.b().a(str);
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
