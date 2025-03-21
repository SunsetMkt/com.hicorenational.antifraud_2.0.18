package p031c.p096e.p097a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: c.e.a.a */
/* loaded from: classes.dex */
public interface InterfaceC1226a extends IInterface {

    /* renamed from: c.e.a.a$a */
    public static class a implements InterfaceC1226a {
        @Override // p031c.p096e.p097a.InterfaceC1226a
        /* renamed from: a */
        public void mo2431a(Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* renamed from: c.e.a.a$b */
    public static abstract class b extends Binder implements InterfaceC1226a {

        /* renamed from: a */
        private static final String f2704a = "com.mcs.aidl.IMcsSdkService";

        /* renamed from: b */
        static final int f2705b = 1;

        /* renamed from: c.e.a.a$b$a */
        private static class a implements InterfaceC1226a {

            /* renamed from: b */
            public static InterfaceC1226a f2706b;

            /* renamed from: a */
            private IBinder f2707a;

            a(IBinder iBinder) {
                this.f2707a = iBinder;
            }

            /* renamed from: a */
            public String m2435a() {
                return b.f2704a;
            }

            @Override // p031c.p096e.p097a.InterfaceC1226a
            /* renamed from: a */
            public void mo2431a(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f2704a);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f2707a.transact(1, obtain, obtain2, 0) || b.m2432a() == null) {
                        obtain2.readException();
                    } else {
                        b.m2432a().mo2431a(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2707a;
            }
        }

        public b() {
            attachInterface(this, f2704a);
        }

        /* renamed from: a */
        public static InterfaceC1226a m2432a() {
            return a.f2706b;
        }

        /* renamed from: a */
        public static InterfaceC1226a m2433a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f2704a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1226a)) ? new a(iBinder) : (InterfaceC1226a) queryLocalInterface;
        }

        /* renamed from: a */
        public static boolean m2434a(InterfaceC1226a interfaceC1226a) {
            if (a.f2706b != null || interfaceC1226a == null) {
                return false;
            }
            a.f2706b = interfaceC1226a;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(f2704a);
                return true;
            }
            parcel.enforceInterface(f2704a);
            mo2431a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: a */
    void mo2431a(Bundle bundle);
}
