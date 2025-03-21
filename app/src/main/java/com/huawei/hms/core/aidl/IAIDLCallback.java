package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IAIDLCallback extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLCallback";

    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        /* renamed from: com.huawei.hms.core.aidl.IAIDLCallback$Stub$a */
        private static class C2341a implements IAIDLCallback {

            /* renamed from: b */
            public static IAIDLCallback f7313b;

            /* renamed from: a */
            private IBinder f7314a;

            C2341a(IBinder iBinder) {
                this.f7314a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7314a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLCallback
            public void call(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLCallback.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f7314a.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().call(dataBuffer);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLCallback.DESCRIPTOR);
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLCallback)) ? new C2341a(iBinder) : (IAIDLCallback) queryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return C2341a.f7313b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (C2341a.f7313b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAIDLCallback == null) {
                return false;
            }
            C2341a.f7313b = iAIDLCallback;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(IAIDLCallback.DESCRIPTOR);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(IAIDLCallback.DESCRIPTOR);
            call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            return true;
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
