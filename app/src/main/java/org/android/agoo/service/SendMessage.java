package org.android.agoo.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SendMessage extends IInterface {

    /* compiled from: Taobao */
    public static abstract class Stub extends Binder implements SendMessage {
        private static final String DESCRIPTOR = "org.android.agoo.service.SendMessage";
        static final int TRANSACTION_doSend = 1;

        /* compiled from: Taobao */
        /* renamed from: org.android.agoo.service.SendMessage$Stub$a */
        private static class C6036a implements SendMessage {

            /* renamed from: a */
            private IBinder f21514a;

            C6036a(IBinder iBinder) {
                this.f21514a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21514a;
            }

            @Override // org.android.agoo.service.SendMessage
            public int doSend(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21514a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SendMessage asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return queryLocalInterface instanceof SendMessage ? (SendMessage) queryLocalInterface : new C6036a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int doSend = doSend(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            parcel2.writeInt(doSend);
            return true;
        }
    }

    int doSend(Intent intent) throws RemoteException;
}
