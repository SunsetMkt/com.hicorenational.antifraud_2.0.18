package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import anetwork.channel.aidl.InterfaceC0870f;
import java.util.Map;
import p000a.p001a.p012s.C0035a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.aidl.a */
/* loaded from: classes.dex */
public interface InterfaceC0865a extends IInterface {

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.aidl.a$a */
    public static abstract class a extends Binder implements InterfaceC0865a {

        /* renamed from: a */
        private static final String f1230a = "anetwork.channel.aidl.Connection";

        /* renamed from: b */
        static final int f1231b = 1;

        /* renamed from: c */
        static final int f1232c = 2;

        /* renamed from: d */
        static final int f1233d = 3;

        /* renamed from: e */
        static final int f1234e = 4;

        /* renamed from: f */
        static final int f1235f = 5;

        /* renamed from: g */
        static final int f1236g = 6;

        /* compiled from: Taobao */
        /* renamed from: anetwork.channel.aidl.a$a$a, reason: collision with other inner class name */
        private static class C7349a implements InterfaceC0865a {

            /* renamed from: a */
            private IBinder f1237a;

            C7349a(IBinder iBinder) {
                this.f1237a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1237a;
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            /* renamed from: d */
            public String mo761d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            /* renamed from: e */
            public C0035a mo762e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() == 1 ? (C0035a) obtain2.readSerializable() : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            /* renamed from: f */
            public Map mo763f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            public int getStatusCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.InterfaceC0865a
            /* renamed from: k */
            public InterfaceC0870f mo764k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f1230a);
                    this.f1237a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return InterfaceC0870f.a.m773a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f1230a);
        }

        /* renamed from: a */
        public static InterfaceC0865a m765a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f1230a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC0865a)) ? new C7349a(iBinder) : (InterfaceC0865a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(f1230a);
                return true;
            }
            switch (i2) {
                case 1:
                    parcel.enforceInterface(f1230a);
                    InterfaceC0870f mo764k = mo764k();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(mo764k != null ? mo764k.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(f1230a);
                    int statusCode = getStatusCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(statusCode);
                    return true;
                case 3:
                    parcel.enforceInterface(f1230a);
                    String mo761d = mo761d();
                    parcel2.writeNoException();
                    parcel2.writeString(mo761d);
                    return true;
                case 4:
                    parcel.enforceInterface(f1230a);
                    Map mo763f = mo763f();
                    parcel2.writeNoException();
                    parcel2.writeMap(mo763f);
                    return true;
                case 5:
                    parcel.enforceInterface(f1230a);
                    C0035a mo762e = mo762e();
                    parcel2.writeNoException();
                    if (mo762e != null) {
                        parcel2.writeInt(1);
                        parcel2.writeSerializable(mo762e);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface(f1230a);
                    cancel();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i2, parcel, parcel2, i3);
            }
        }
    }

    void cancel() throws RemoteException;

    /* renamed from: d */
    String mo761d() throws RemoteException;

    /* renamed from: e */
    C0035a mo762e() throws RemoteException;

    /* renamed from: f */
    Map mo763f() throws RemoteException;

    int getStatusCode() throws RemoteException;

    /* renamed from: k */
    InterfaceC0870f mo764k() throws RemoteException;
}
