package d.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: ITelephony.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: d.a.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ITelephony.java */
    public static abstract class AbstractBinderC0154a extends Binder implements a {
        private static final String a = "com.android.internal.telephony.ITelephony";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f9446b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f9447c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final int f9448d = 3;

        /* JADX INFO: renamed from: d.a.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ITelephony.java */
        private static class C0155a implements a {
            private IBinder a;

            C0155a(IBinder iBinder) {
                this.a = iBinder;
            }

            public String a() {
                return AbstractBinderC0154a.a;
            }

            @Override // d.a.a.a.a
            public void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0154a.a);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeFloat(f2);
                    parcelObtain.writeDouble(d2);
                    parcelObtain.writeString(str);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // d.a.a.a.a
            public boolean h() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0154a.a);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // d.a.a.a.a
            public void i() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0154a.a);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0154a() {
            attachInterface(this, a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0155a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(a);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(a);
                boolean zH = h();
                parcel2.writeNoException();
                parcel2.writeInt(zH ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            i();
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException;

    boolean h() throws RemoteException;

    void i() throws RemoteException;
}
