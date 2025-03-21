package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IServiceInvoke.java */
/* loaded from: classes.dex */
public interface b extends IInterface {
    void a(DataBuffer dataBuffer, com.hihonor.cloudservice.framework.aidl.a aVar);

    /* compiled from: IServiceInvoke.java */
    public static abstract class a extends Binder implements b {

        /* compiled from: IServiceInvoke.java */
        /* renamed from: com.hihonor.cloudservice.framework.aidl.b$a$a, reason: collision with other inner class name */
        private static class C0099a implements b {

            /* renamed from: b, reason: collision with root package name */
            public static b f5987b;

            /* renamed from: a, reason: collision with root package name */
            private IBinder f5988a;

            C0099a(IBinder iBinder) {
                this.f5988a = iBinder;
            }

            @Override // com.hihonor.cloudservice.framework.aidl.b
            public void a(DataBuffer dataBuffer, com.hihonor.cloudservice.framework.aidl.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.f5988a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                    } else {
                        a.a().a(dataBuffer, aVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5988a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0099a(iBinder) : (b) queryLocalInterface;
        }

        public static b a() {
            return C0099a.f5987b;
        }
    }
}
