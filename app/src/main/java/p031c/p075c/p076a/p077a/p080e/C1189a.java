package p031c.p075c.p076a.p077a.p080e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.cloudservice.framework.aidl.InterfaceC2128a;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import p031c.p075c.p076a.p077a.p079d.InterfaceC1188b;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b;
import p358k.p359a.p360a.p367c.p368a.ServiceConnectionC5866a;

/* compiled from: AuthOperationTask.java */
/* renamed from: c.c.a.a.e.a */
/* loaded from: classes.dex */
public class C1189a extends AbstractRunnableC5867b {

    /* renamed from: d */
    private final Bundle f2473d;

    /* renamed from: e */
    private final InterfaceC1188b f2474e;

    /* renamed from: f */
    private final String f2475f;

    /* compiled from: AuthOperationTask.java */
    /* renamed from: c.c.a.a.e.a$a */
    class a extends InterfaceC2128a.a {
        a() {
        }

        @Override // com.hihonor.cloudservice.framework.aidl.InterfaceC2128a
        /* renamed from: a */
        public void mo2275a(DataBuffer dataBuffer) {
            C5863e.m24692b("AuthOperationTask", "onResult", true);
            if (((AbstractRunnableC5867b) C1189a.this).f21188b.get()) {
                C5863e.m24692b("AuthOperationTask", "has cancelled by timeout, return directly", true);
                return;
            }
            C1189a.this.m24736b();
            String str = dataBuffer.f6369b;
            Bundle bundle = dataBuffer.f6371d;
            int i2 = bundle.getInt("retCode");
            C5863e.m24692b("AuthOperationTask", "onResult retCode:" + i2, true);
            if (i2 == 0) {
                if (str.equals("honorid.signout")) {
                    C5863e.m24692b("AuthOperationTask", "opensdk signOut", true);
                    C1189a.this.f2474e.mo2268a(bundle);
                    return;
                } else if (str.equals("honorid.revokeaccess")) {
                    C1189a.this.f2474e.mo2268a(bundle);
                    return;
                } else if (!str.equals("honorid.getScope")) {
                    C1189a.this.f2474e.mo2268a(bundle);
                    return;
                } else {
                    C1189a.this.f2474e.mo2268a(((Intent) bundle.getParcelable("data")).getExtras());
                    return;
                }
            }
            if (i2 == 2001) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(31, "Account has not login"));
                return;
            }
            if (i2 == 7) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(42, "userid not system account"));
                return;
            }
            if (i2 == 8) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(44, "packagename was not matched"));
                return;
            }
            if (i2 == 9) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(43, "packagename not in honorid list"));
                return;
            }
            if (i2 == 1) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(29, "Signature invalid"));
            } else if (i2 == 5) {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(69, "uid not match"));
            } else {
                C1189a.this.f2474e.mo2269a(new ErrorStatus(44, "other error"));
                C5863e.m24692b("AuthOperationTask", "DONT KNOW RET_CODE:", true);
            }
        }
    }

    public C1189a(Context context, Bundle bundle, String str, InterfaceC1188b interfaceC1188b) {
        super(context);
        this.f2473d = bundle;
        this.f2474e = interfaceC1188b;
        this.f2475f = str;
    }

    @Override // p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b
    /* renamed from: a */
    protected void mo2273a() {
        DataBuffer dataBuffer = new DataBuffer(this.f2475f, 1001);
        dataBuffer.f6371d = this.f2473d;
        try {
            ServiceConnectionC5866a.m24716a(this.f21189c).m24732a().mo5978a(dataBuffer, new a());
        } catch (RemoteException unused) {
            C5863e.m24691a("AuthOperationTask", "authOperation remote exception", true);
        }
    }

    @Override // p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b
    /* renamed from: a */
    public void mo2274a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "authOperation timeout. retry again");
        }
        this.f2474e.mo2269a(errorStatus);
    }
}
