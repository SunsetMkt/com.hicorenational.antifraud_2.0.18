package p031c.p032a.p033a.p034a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITelephony.java */
/* renamed from: c.a.a.a.a */
/* loaded from: classes.dex */
public interface InterfaceC0947a extends IInterface {

    /* compiled from: ITelephony.java */
    /* renamed from: c.a.a.a.a$a */
    public static abstract class a extends Binder implements InterfaceC0947a {

        /* renamed from: a */
        private static final String f1642a = "com.android.internal.telephony.ITelephony";

        /* renamed from: b */
        static final int f1643b = 1;

        /* renamed from: c */
        static final int f1644c = 2;

        /* renamed from: d */
        static final int f1645d = 3;

        /* compiled from: ITelephony.java */
        /* renamed from: c.a.a.a.a$a$a, reason: collision with other inner class name */
        private static class C7356a implements InterfaceC0947a {

            /* renamed from: a */
            private IBinder f1646a;

            C7356a(IBinder iBinder) {
                this.f1646a = iBinder;
            }

            /* renamed from: a */
            public String m1182a() {
                return a.f1642a;
            }

            @Override // p031c.p032a.p033a.p034a.InterfaceC0947a
            /* renamed from: a */
            public void mo1178a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1642a);
                    obtain.writeInt(i2);
                    obtain.writeLong(j2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f2);
                    obtain.writeDouble(d2);
                    obtain.writeString(str);
                    this.f1646a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1646a;
            }

            @Override // p031c.p032a.p033a.p034a.InterfaceC0947a
            /* renamed from: h */
            public boolean mo1179h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1642a);
                    this.f1646a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // p031c.p032a.p033a.p034a.InterfaceC0947a
            /* renamed from: i */
            public void mo1180i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1642a);
                    this.f1646a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f1642a);
        }

        /* renamed from: a */
        public static InterfaceC0947a m1181a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1642a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0947a)) ? new C7356a(iBinder) : (InterfaceC0947a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(f1642a);
                mo1178a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i2 == 2) {
                parcel.enforceInterface(f1642a);
                boolean mo1179h = mo1179h();
                parcel2.writeNoException();
                parcel2.writeInt(mo1179h ? 1 : 0);
                return true;
            }
            if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f1642a);
                return true;
            }
            parcel.enforceInterface(f1642a);
            mo1180i();
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo1178a(int i2, long j2, boolean z, float f2, double d2, String str) throws RemoteException;

    /* renamed from: h */
    boolean mo1179h() throws RemoteException;

    /* renamed from: i */
    void mo1180i() throws RemoteException;
}
