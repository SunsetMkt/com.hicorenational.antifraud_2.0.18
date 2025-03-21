package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.f */
/* loaded from: classes.dex */
public interface InterfaceC0870f extends IInterface {
    /* renamed from: a */
    int mo771a(byte[] bArr, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    long mo772a(int i2) throws RemoteException;

    int available() throws RemoteException;

    void close() throws RemoteException;

    int length() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;

    int readByte() throws RemoteException;

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.f$a */
    public static abstract class a extends Binder implements InterfaceC0870f {

        /* renamed from: a */
        private static final String f1252a = "anetwork.channel.aidl.ParcelableInputStream";

        /* renamed from: b */
        static final int f1253b = 1;

        /* renamed from: c */
        static final int f1254c = 2;

        /* renamed from: d */
        static final int f1255d = 3;

        /* renamed from: e */
        static final int f1256e = 4;

        /* renamed from: f */
        static final int f1257f = 5;

        /* renamed from: g */
        static final int f1258g = 6;

        /* renamed from: h */
        static final int f1259h = 7;

        public a() {
            attachInterface(this, f1252a);
        }

        /* renamed from: a */
        public static InterfaceC0870f m773a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1252a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0870f)) ? new C7353a(iBinder) : (InterfaceC0870f) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            byte[] bArr;
            if (i2 == 1598968902) {
                parcel2.writeString(f1252a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f1252a);
                    int available = available();
                    parcel2.writeNoException();
                    parcel2.writeInt(available);
                    return true;
                case 2:
                    parcel.enforceInterface(f1252a);
                    close();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(f1252a);
                    int readByte = readByte();
                    parcel2.writeNoException();
                    parcel2.writeInt(readByte);
                    return true;
                case 4:
                    parcel.enforceInterface(f1252a);
                    int readInt = parcel.readInt();
                    bArr = readInt >= 0 ? new byte[readInt] : null;
                    int mo771a = mo771a(bArr, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(mo771a);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 5:
                    parcel.enforceInterface(f1252a);
                    int readInt2 = parcel.readInt();
                    bArr = readInt2 >= 0 ? new byte[readInt2] : null;
                    int read = read(bArr);
                    parcel2.writeNoException();
                    parcel2.writeInt(read);
                    parcel2.writeByteArray(bArr);
                    return true;
                case 6:
                    parcel.enforceInterface(f1252a);
                    long mo772a = mo772a(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(mo772a);
                    return true;
                case 7:
                    parcel.enforceInterface(f1252a);
                    int length = length();
                    parcel2.writeNoException();
                    parcel2.writeInt(length);
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.f$a$a, reason: collision with other inner class name */
        private static class C7353a implements InterfaceC0870f {

            /* renamed from: a */
            private IBinder f1260a;

            C7353a(IBinder iBinder) {
                this.f1260a = iBinder;
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            /* renamed from: a */
            public int mo771a(byte[] bArr, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1260a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1260a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            public int available() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    this.f1260a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            public void close() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    this.f1260a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            public int length() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    this.f1260a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            public int read(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    if (bArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(bArr.length);
                    }
                    this.f1260a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            public int readByte() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    this.f1260a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0870f
            /* renamed from: a */
            public long mo772a(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1252a);
                    obtain.writeInt(i2);
                    this.f1260a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
