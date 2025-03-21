package c.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITelephony.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ITelephony.java */
    /* renamed from: c.a.a.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0031a extends Binder implements a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2328a = "com.android.internal.telephony.ITelephony";

        /* renamed from: b, reason: collision with root package name */
        static final int f2329b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2330c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2331d = 3;

        /* compiled from: ITelephony.java */
        /* renamed from: c.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C0032a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2332a;

            C0032a(IBinder iBinder) {
                this.f2332a = iBinder;
            }

            public String a() {
                return AbstractBinderC0031a.f2328a;
            }

            @Override // c.a.a.a.a
            public void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f2);
                    obtain.writeDouble(d2);
                    obtain.writeString(str);
                    this.f2332a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2332a;
            }

            @Override // c.a.a.a.a
            public boolean h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    this.f2332a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // c.a.a.a.a
            public void i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0031a.f2328a);
                    this.f2332a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0031a() {
            attachInterface(this, f2328a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f2328a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0032a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2328a);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2328a);
                boolean h2 = h();
                parcel2.writeNoException();
                parcel2.writeInt(h2 ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2328a);
                return true;
            }
            parcel.enforceInterface(f2328a);
            i();
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException;

    boolean h() throws RemoteException;

    void i() throws RemoteException;
}
