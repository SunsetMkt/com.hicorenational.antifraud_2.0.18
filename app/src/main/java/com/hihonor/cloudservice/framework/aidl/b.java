package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: IServiceInvoke.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {
    void a(DataBuffer dataBuffer, com.hihonor.cloudservice.framework.aidl.a aVar);

    /* JADX INFO: compiled from: IServiceInvoke.java */
    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: com.hihonor.cloudservice.framework.aidl.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IServiceInvoke.java */
        private static class C0087a implements b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static b f4016b;
            private IBinder a;

            C0087a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.hihonor.cloudservice.framework.aidl.b
            public void a(DataBuffer dataBuffer, com.hihonor.cloudservice.framework.aidl.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
                    if (dataBuffer != null) {
                        parcelObtain.writeInt(1);
                        dataBuffer.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.a.transact(1, parcelObtain, parcelObtain2, 0) || a.a() == null) {
                        parcelObtain2.readException();
                    } else {
                        a.a().a(dataBuffer, aVar);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0087a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }

        public static b a() {
            return C0087a.f4016b;
        }
    }
}
