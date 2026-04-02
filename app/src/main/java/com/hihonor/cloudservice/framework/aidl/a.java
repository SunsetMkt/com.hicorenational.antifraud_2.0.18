package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IServiceCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.hihonor.cloudservice.framework.aidl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IServiceCallback.java */
    public static abstract class AbstractBinderC0086a extends Binder implements a {
        public AbstractBinderC0086a() {
            attachInterface(this, "com.hihonor.cloudservice.framework.aidl.IServiceCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
                a(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
            return true;
        }
    }

    void a(DataBuffer dataBuffer);
}
