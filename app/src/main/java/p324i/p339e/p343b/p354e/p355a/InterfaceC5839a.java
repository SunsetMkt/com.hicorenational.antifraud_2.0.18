package p324i.p339e.p343b.p354e.p355a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceidInterface.java */
/* renamed from: i.e.b.e.a.a */
/* loaded from: classes2.dex */
public interface InterfaceC5839a extends IInterface {
    /* renamed from: a */
    String mo24563a() throws RemoteException;

    /* renamed from: a */
    String mo24564a(String str) throws RemoteException;

    /* renamed from: b */
    String mo24565b() throws RemoteException;

    /* renamed from: b */
    String mo24566b(String str) throws RemoteException;

    /* renamed from: c */
    boolean mo24567c() throws RemoteException;

    /* renamed from: c */
    boolean mo24568c(String str) throws RemoteException;

    /* compiled from: IDeviceidInterface.java */
    /* renamed from: i.e.b.e.a.a$a */
    public static abstract class a extends Binder implements InterfaceC5839a {

        /* renamed from: a */
        private static final String f21077a = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b */
        static final int f21078b = 1;

        /* renamed from: c */
        static final int f21079c = 2;

        /* renamed from: d */
        static final int f21080d = 3;

        /* renamed from: e */
        static final int f21081e = 4;

        /* renamed from: f */
        static final int f21082f = 5;

        /* renamed from: g */
        static final int f21083g = 6;

        public a() {
            attachInterface(this, f21077a);
        }

        /* renamed from: a */
        public static InterfaceC5839a m24569a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f21077a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC5839a)) ? new C7433a(iBinder) : (InterfaceC5839a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f21077a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f21077a);
                    String mo24563a = mo24563a();
                    parcel2.writeNoException();
                    parcel2.writeString(mo24563a);
                    return true;
                case 2:
                    parcel.enforceInterface(f21077a);
                    String mo24565b = mo24565b();
                    parcel2.writeNoException();
                    parcel2.writeString(mo24565b);
                    return true;
                case 3:
                    parcel.enforceInterface(f21077a);
                    boolean mo24567c = mo24567c();
                    parcel2.writeNoException();
                    parcel2.writeInt(mo24567c ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f21077a);
                    String mo24564a = mo24564a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo24564a);
                    return true;
                case 5:
                    parcel.enforceInterface(f21077a);
                    String mo24566b = mo24566b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mo24566b);
                    return true;
                case 6:
                    parcel.enforceInterface(f21077a);
                    boolean mo24568c = mo24568c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(mo24568c ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: IDeviceidInterface.java */
        /* renamed from: i.e.b.e.a.a$a$a, reason: collision with other inner class name */
        private static class C7433a implements InterfaceC5839a {

            /* renamed from: a */
            private IBinder f21084a;

            C7433a(IBinder iBinder) {
                this.f21084a = iBinder;
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: a */
            public String mo24563a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    this.f21084a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21084a;
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: b */
            public String mo24565b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    this.f21084a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: c */
            public boolean mo24567c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    this.f21084a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public String m24570d() {
                return a.f21077a;
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: a */
            public String mo24564a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    obtain.writeString(str);
                    this.f21084a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: b */
            public String mo24566b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    obtain.writeString(str);
                    this.f21084a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p324i.p339e.p343b.p354e.p355a.InterfaceC5839a
            /* renamed from: c */
            public boolean mo24568c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f21077a);
                    obtain.writeString(str);
                    this.f21084a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
