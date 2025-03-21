package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.e */
/* loaded from: classes.dex */
public interface InterfaceC0869e extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.e$a */
    public static abstract class a extends Binder implements InterfaceC0869e {

        /* renamed from: a */
        private static final String f1246a = "anetwork.channel.aidl.ParcelableFuture";

        /* renamed from: b */
        static final int f1247b = 1;

        /* renamed from: c */
        static final int f1248c = 2;

        /* renamed from: d */
        static final int f1249d = 3;

        /* renamed from: e */
        static final int f1250e = 4;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.e$a$a, reason: collision with other inner class name */
        private static class C7352a implements InterfaceC0869e {

            /* renamed from: a */
            private IBinder f1251a;

            C7352a(IBinder iBinder) {
                this.f1251a = iBinder;
            }

            @Override // anetwork.channel.aidl.InterfaceC0869e
            /* renamed from: a */
            public NetworkResponse mo769a(long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1246a);
                    obtain.writeLong(j2);
                    this.f1251a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? NetworkResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1251a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0869e
            public boolean cancel(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1246a);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1251a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0869e
            public boolean isCancelled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1246a);
                    this.f1251a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0869e
            public boolean isDone() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1246a);
                    this.f1251a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f1246a);
        }

        /* renamed from: a */
        public static InterfaceC0869e m770a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1246a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0869e)) ? new C7352a(iBinder) : (InterfaceC0869e) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f1246a);
                boolean cancel = cancel(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(cancel ? 1 : 0);
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f1246a);
                boolean isCancelled = isCancelled();
                parcel2.writeNoException();
                parcel2.writeInt(isCancelled ? 1 : 0);
                return true;
            }
            if (i2 == 3) {
                parcel.enforceInterface(f1246a);
                boolean isDone = isDone();
                parcel2.writeNoException();
                parcel2.writeInt(isDone ? 1 : 0);
                return true;
            }
            if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1246a);
                return true;
            }
            parcel.enforceInterface(f1246a);
            NetworkResponse mo769a = mo769a(parcel.readLong());
            parcel2.writeNoException();
            if (mo769a != null) {
                parcel2.writeInt(1);
                mo769a.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    /* renamed from: a */
    NetworkResponse mo769a(long j2) throws RemoteException;

    boolean cancel(boolean z) throws RemoteException;

    boolean isCancelled() throws RemoteException;

    boolean isDone() throws RemoteException;
}
