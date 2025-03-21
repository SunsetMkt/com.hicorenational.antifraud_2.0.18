package com.hihonor.cloudservice.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IServiceInvoke.java */
/* renamed from: com.hihonor.cloudservice.framework.aidl.b */
/* loaded from: classes.dex */
public interface InterfaceC2129b extends IInterface {
    /* renamed from: a */
    void mo5978a(DataBuffer dataBuffer, InterfaceC2128a interfaceC2128a);

    /* compiled from: IServiceInvoke.java */
    /* renamed from: com.hihonor.cloudservice.framework.aidl.b$a */
    public static abstract class a extends Binder implements InterfaceC2129b {

        /* compiled from: IServiceInvoke.java */
        /* renamed from: com.hihonor.cloudservice.framework.aidl.b$a$a, reason: collision with other inner class name */
        private static class C7365a implements InterfaceC2129b {

            /* renamed from: b */
            public static InterfaceC2129b f6372b;

            /* renamed from: a */
            private IBinder f6373a;

            C7365a(IBinder iBinder) {
                this.f6373a = iBinder;
            }

            @Override // com.hihonor.cloudservice.framework.aidl.InterfaceC2129b
            /* renamed from: a */
            public void mo5978a(DataBuffer dataBuffer, InterfaceC2128a interfaceC2128a) {
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
                    obtain.writeStrongBinder(interfaceC2128a != null ? interfaceC2128a.asBinder() : null);
                    if (this.f6373a.transact(1, obtain, obtain2, 0) || a.m5979a() == null) {
                        obtain2.readException();
                    } else {
                        a.m5979a().mo5978a(dataBuffer, interfaceC2128a);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6373a;
            }
        }

        /* renamed from: a */
        public static InterfaceC2129b m5980a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.framework.aidl.IServiceInvoke");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC2129b)) ? new C7365a(iBinder) : (InterfaceC2129b) queryLocalInterface;
        }

        /* renamed from: a */
        public static InterfaceC2129b m5979a() {
            return C7365a.f6372b;
        }
    }
}
