package p031c.p075c.p076a.p077a.p080e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.cloudservice.framework.aidl.InterfaceC2128a;
import com.hihonor.cloudservice.framework.aidl.InterfaceC2129b;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.hihonor.honorid.p166g.AbstractC2174a;
import com.hihonor.honorid.p168h.C2178a;
import com.taobao.accs.common.Constants;
import p031c.p075c.p076a.p077a.p079d.InterfaceC1187a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p358k.p359a.p360a.p361a.C5854h;
import p358k.p359a.p360a.p361a.p363j.C5863e;
import p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b;
import p358k.p359a.p360a.p367c.p368a.ServiceConnectionC5866a;
import p358k.p359a.p369b.p370a.p371a.p372a.C5869a;
import p358k.p359a.p369b.p373b.p374a.C5871b;

/* compiled from: SilentLoginTask.java */
/* renamed from: c.c.a.a.e.b */
/* loaded from: classes.dex */
public class C1190b extends AbstractRunnableC5867b {

    /* renamed from: d */
    private String f2477d;

    /* renamed from: e */
    private Bundle f2478e;

    /* renamed from: f */
    private InterfaceC1187a f2479f;

    /* renamed from: g */
    private Context f2480g;

    /* compiled from: SilentLoginTask.java */
    /* renamed from: c.c.a.a.e.b$a */
    class a extends InterfaceC2128a.a {
        a() {
        }

        @Override // com.hihonor.cloudservice.framework.aidl.InterfaceC2128a
        /* renamed from: a */
        public void mo2275a(DataBuffer dataBuffer) {
            C5863e.m24692b("LoginTask", "onResult", true);
            if (((AbstractRunnableC5867b) C1190b.this).f21188b.get()) {
                C5863e.m24692b("LoginTask", "has cancelled by timeout, return directly", true);
                return;
            }
            C1190b.this.m24736b();
            Bundle bundle = dataBuffer.f6371d;
            int i2 = bundle.getInt("retCode");
            C5863e.m24692b("LoginTask", "execute : onResult retCode = " + i2, true);
            if (i2 == 0) {
                HonorAccount m6155a = new HonorAccount().m6155a(((Intent) bundle.getParcelable("data")).getExtras());
                C1190b.this.m2278a(m6155a);
                C2178a.m6345a(C1190b.this.f2480g).m6347a(m6155a);
                HonorAccount m6346a = C2178a.m6345a(C1190b.this.f2480g).m6346a();
                if (C1190b.this.f2479f != null) {
                    C1190b.this.f2479f.mo2266a(m6346a);
                }
                AbstractC2174a.m6331a(C1190b.this.f2480g).mo6333a(C1190b.this.f2480g, m6155a);
                return;
            }
            if (i2 == 2002) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(55, "scopes not authorize"));
                return;
            }
            if (i2 == 2001) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(31, "Account hasnot login"));
                return;
            }
            if (i2 == 1) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(29, "Signature invalid"));
                return;
            }
            if (i2 == 2) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(30, "serviceToken invalid"));
                return;
            }
            String str = "";
            if (i2 != 2009) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(i2, ""));
                return;
            }
            Bundle extras = ((Intent) bundle.getParcelable("data")).getExtras();
            int i3 = 56;
            if (extras != null) {
                i3 = extras.getInt("err_code", 56);
                str = extras.getString("server_err_desc", "access server return error");
            }
            C5863e.m24691a("LoginTask", "loginResult : errCode = " + i3 + " errMsg = " + str, true);
            if (1101 == i3) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(67, str));
            } else if (1202 == i3) {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(68, str));
            } else {
                C1190b.this.f2479f.mo2267a(new ErrorStatus(i3, str));
            }
        }
    }

    public C1190b(Context context, String str, Bundle bundle, InterfaceC1187a interfaceC1187a) {
        super(context);
        this.f2480g = context;
        this.f2477d = str;
        this.f2478e = bundle;
        this.f2479f = interfaceC1187a;
        if (bundle != null) {
            bundle.getString("bundle_key_for_transid_getaccounts_by_type", "");
        }
    }

    public String toString() {
        return "SilentLoginTask{mServiceType='" + this.f2477d + "'}";
    }

    @Override // p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b
    /* renamed from: a */
    protected void mo2273a() {
        C5863e.m24692b("LoginTask", "LoginTask execute", true);
        InterfaceC2129b m24732a = ServiceConnectionC5866a.m24716a(this.f2480g).m24732a();
        try {
            DataBuffer dataBuffer = new DataBuffer("honorid.silentsignin", 1001);
            C5871b c5871b = new C5871b();
            dataBuffer.m5977a(this.f2478e);
            C5869a c5869a = new C5869a();
            this.f2478e.getString("clientId");
            this.f2478e.getString(Constants.KEY_PACKAGE_NAME);
            dataBuffer.f6370c = c5869a.m24737a(c5871b);
            m24732a.mo5978a(dataBuffer, new a());
        } catch (RemoteException unused) {
            C5863e.m24692b("LoginTask", "login remote exception", true);
        }
    }

    @Override // p358k.p359a.p360a.p367c.p368a.AbstractRunnableC5867b
    /* renamed from: a */
    public void mo2274a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "login timeout. retry again");
        }
        this.f2479f.mo2267a(errorStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2278a(HonorAccount honorAccount) {
        String m6199u = honorAccount.m6199u();
        if (TextUtils.isEmpty(m6199u) || AbstractC1191a.f2571h.equalsIgnoreCase(m6199u)) {
            String m24649a = C5854h.m24649a(this.f2480g, 0);
            if (m24649a == null) {
                m24649a = "";
            }
            honorAccount.m6202v(m24649a);
        }
    }
}
