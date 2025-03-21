package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IServiceCallback.java */
/* renamed from: com.hihonor.cloudservice.framework.aidl.a */
/* loaded from: classes.dex */
public interface InterfaceC2128a extends IInterface {

    /* compiled from: IServiceCallback.java */
    /* renamed from: com.hihonor.cloudservice.framework.aidl.a$a */
    public static abstract class a extends Binder implements InterfaceC2128a {
        public a() {
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
                mo2275a(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel2.writeString("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
            return true;
        }
    }

    /* renamed from: a */
    void mo2275a(DataBuffer dataBuffer);
}
