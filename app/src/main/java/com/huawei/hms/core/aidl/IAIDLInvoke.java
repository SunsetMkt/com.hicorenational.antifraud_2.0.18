package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.core.aidl.IAIDLCallback;

/* loaded from: classes.dex */
public interface IAIDLInvoke extends IInterface {
    public static final String DESCRIPTOR = "com.huawei.hms.core.aidl.IAIDLInvoke";

    public static abstract class Stub extends Binder implements IAIDLInvoke {

        /* renamed from: com.huawei.hms.core.aidl.IAIDLInvoke$Stub$a */
        private static class C2342a implements IAIDLInvoke {

            /* renamed from: b */
            public static IAIDLInvoke f7315b;

            /* renamed from: a */
            private IBinder f7316a;

            C2342a(IBinder iBinder) {
                this.f7316a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7316a;
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iAIDLCallback != null ? iAIDLCallback.asBinder() : null);
                    if (this.f7316a.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().asyncCall(dataBuffer, iAIDLCallback);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.core.aidl.IAIDLInvoke
            public void syncCall(DataBuffer dataBuffer) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIDLInvoke.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f7316a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().syncCall(dataBuffer);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAIDLInvoke.DESCRIPTOR);
        }

        public static IAIDLInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIDLInvoke.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLInvoke)) ? new C2342a(iBinder) : (IAIDLInvoke) queryLocalInterface;
        }

        public static IAIDLInvoke getDefaultImpl() {
            return C2342a.f7315b;
        }

        public static boolean setDefaultImpl(IAIDLInvoke iAIDLInvoke) {
            if (C2342a.f7315b != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iAIDLInvoke == null) {
                return false;
            }
            C2342a.f7315b = iAIDLInvoke;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(IAIDLInvoke.DESCRIPTOR);
                return true;
            }
            if (i2 == 1) {
                parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
                syncCall(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i2 != 2) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(IAIDLInvoke.DESCRIPTOR);
            asyncCall(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null, IAIDLCallback.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void asyncCall(DataBuffer dataBuffer, IAIDLCallback iAIDLCallback) throws RemoteException;

    void syncCall(DataBuffer dataBuffer) throws RemoteException;
}
