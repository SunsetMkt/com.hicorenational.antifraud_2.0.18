package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface e extends IInterface {

    /* compiled from: Taobao */
    public static abstract class a extends Binder implements e {

        /* renamed from: a, reason: collision with root package name */
        private static final String f2119a = "anetwork.channel.aidl.ParcelableFuture";

        /* renamed from: b, reason: collision with root package name */
        static final int f2120b = 1;

        /* renamed from: c, reason: collision with root package name */
        static final int f2121c = 2;

        /* renamed from: d, reason: collision with root package name */
        static final int f2122d = 3;

        /* renamed from: e, reason: collision with root package name */
        static final int f2123e = 4;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.e$a$a, reason: collision with other inner class name */
        private static class C0021a implements e {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f2124a;

            C0021a(IBinder iBinder) {
                this.f2124a = iBinder;
            }

            @Override // anetwork.channel.aidl.e
            public NetworkResponse a(long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2119a);
                    obtain.writeLong(j2);
                    this.f2124a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2124a;
            }

            @Override // anetwork.channel.aidl.e
            public boolean cancel(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2119a);
                    obtain.writeInt(z ? 1 : 0);
                    this.f2124a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.e
            public boolean isCancelled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2119a);
                    this.f2124a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.e
            public boolean isDone() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f2119a);
                    this.f2124a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f2119a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f2119a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0021a(iBinder) : (e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f2119a);
                boolean cancel = cancel(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(cancel ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f2119a);
                boolean isCancelled = isCancelled();
                parcel2.writeNoException();
                parcel2.writeInt(isCancelled ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(f2119a);
                boolean isDone = isDone();
                parcel2.writeNoException();
                parcel2.writeInt(isDone ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2119a);
                return true;
            }
            parcel.enforceInterface(f2119a);
            NetworkResponse a2 = a(parcel.readLong());
            parcel2.writeNoException();
            if (a2 != null) {
                parcel2.writeInt(1);
                a2.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    NetworkResponse a(long j2) throws RemoteException;

    boolean cancel(boolean z) throws RemoteException;

    boolean isCancelled() throws RemoteException;

    boolean isDone() throws RemoteException;
}
