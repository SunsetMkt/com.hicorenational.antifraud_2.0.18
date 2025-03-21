package i.e.b.e.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IDeviceidInterface.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    boolean c() throws RemoteException;

    boolean c(String str) throws RemoteException;

    /* compiled from: IDeviceidInterface.java */
    /* renamed from: i.e.b.e.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0260a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f16969a = "org.repackage.com.zui.deviceidservice.IDeviceidInterface";

        /* renamed from: b, reason: collision with root package name */
        static final int f16970b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f16971c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f16972d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f16973e = 4;

        /* renamed from: f, reason: collision with root package name */
        static final int f16974f = 5;

        /* renamed from: g, reason: collision with root package name */
        static final int f16975g = 6;

        public AbstractBinderC0260a() {
            attachInterface(this, f16969a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f16969a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0261a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f16969a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f16969a);
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(f16969a);
                    String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(f16969a);
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(f16969a);
                    String a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 5:
                    parcel.enforceInterface(f16969a);
                    String b3 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                case 6:
                    parcel.enforceInterface(f16969a);
                    boolean c3 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c3 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: IDeviceidInterface.java */
        /* renamed from: i.e.b.e.a.a$a$a, reason: collision with other inner class name */
        private static class C0261a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f16976a;

            C0261a(IBinder iBinder) {
                this.f16976a = iBinder;
            }

            @Override // i.e.b.e.a.a
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f16976a;
            }

            @Override // i.e.b.e.a.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    this.f16976a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String d() {
                return AbstractBinderC0260a.f16969a;
            }

            @Override // i.e.b.e.a.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    obtain.writeString(str);
                    this.f16976a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    obtain.writeString(str);
                    this.f16976a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // i.e.b.e.a.a
            public boolean c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0260a.f16969a);
                    obtain.writeString(str);
                    this.f16976a.transact(6, obtain, obtain2, 0);
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
