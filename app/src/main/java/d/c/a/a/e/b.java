package d.c.a.a.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.cloudservice.framework.aidl.a;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import com.taobao.accs.common.Constants;
import l.a.a.a.h;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: SilentLoginTask.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends l.a.a.c.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bundle f10066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.a.a.d.a f10067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f10068g;

    /* JADX INFO: compiled from: SilentLoginTask.java */
    class a extends a.AbstractBinderC0086a {
        a() {
        }

        @Override // com.hihonor.cloudservice.framework.aidl.a
        public void a(DataBuffer dataBuffer) {
            e.b("LoginTask", "onResult", true);
            if (((l.a.a.c.a.b) b.this).f12705b.get()) {
                e.b("LoginTask", "has cancelled by timeout, return directly", true);
                return;
            }
            b.this.b();
            Bundle bundle = dataBuffer.f4015d;
            int i2 = bundle.getInt("retCode");
            e.b("LoginTask", "execute : onResult retCode = " + i2, true);
            if (i2 == 0) {
                HonorAccount honorAccountA = new HonorAccount().a(((Intent) bundle.getParcelable("data")).getExtras());
                b.this.a(honorAccountA);
                com.hihonor.honorid.h.a.a(b.this.f10068g).a(honorAccountA);
                HonorAccount honorAccountA2 = com.hihonor.honorid.h.a.a(b.this.f10068g).a();
                if (b.this.f10067f != null) {
                    b.this.f10067f.a(honorAccountA2);
                }
                com.hihonor.honorid.g.a.a(b.this.f10068g).a(b.this.f10068g, honorAccountA);
                return;
            }
            if (i2 == 2002) {
                b.this.f10067f.a(new ErrorStatus(55, "scopes not authorize"));
                return;
            }
            if (i2 == 2001) {
                b.this.f10067f.a(new ErrorStatus(31, "Account hasnot login"));
                return;
            }
            if (i2 == 1) {
                b.this.f10067f.a(new ErrorStatus(29, "Signature invalid"));
                return;
            }
            if (i2 == 2) {
                b.this.f10067f.a(new ErrorStatus(30, "serviceToken invalid"));
                return;
            }
            String string = "";
            if (i2 != 2009) {
                b.this.f10067f.a(new ErrorStatus(i2, ""));
                return;
            }
            Bundle extras = ((Intent) bundle.getParcelable("data")).getExtras();
            int i3 = 56;
            if (extras != null) {
                i3 = extras.getInt("err_code", 56);
                string = extras.getString("server_err_desc", "access server return error");
            }
            e.a("LoginTask", "loginResult : errCode = " + i3 + " errMsg = " + string, true);
            if (1101 == i3) {
                b.this.f10067f.a(new ErrorStatus(67, string));
            } else if (1202 == i3) {
                b.this.f10067f.a(new ErrorStatus(68, string));
            } else {
                b.this.f10067f.a(new ErrorStatus(i3, string));
            }
        }
    }

    public b(Context context, String str, Bundle bundle, d.c.a.a.d.a aVar) {
        super(context);
        this.f10068g = context;
        this.f10065d = str;
        this.f10066e = bundle;
        this.f10067f = aVar;
        if (bundle != null) {
            bundle.getString("bundle_key_for_transid_getaccounts_by_type", "");
        }
    }

    public String toString() {
        return "SilentLoginTask{mServiceType='" + this.f10065d + "'}";
    }

    @Override // l.a.a.c.a.b
    protected void a() {
        e.b("LoginTask", "LoginTask execute", true);
        com.hihonor.cloudservice.framework.aidl.b bVarA = l.a.a.c.a.a.a(this.f10068g).a();
        try {
            DataBuffer dataBuffer = new DataBuffer("honorid.silentsignin", 1001);
            l.a.b.b.a.b bVar = new l.a.b.b.a.b();
            dataBuffer.a(this.f10066e);
            l.a.b.a.a.a.a aVar = new l.a.b.a.a.a.a();
            this.f10066e.getString("clientId");
            this.f10066e.getString(Constants.KEY_PACKAGE_NAME);
            dataBuffer.f4014c = aVar.a(bVar);
            bVarA.a(dataBuffer, new a());
        } catch (RemoteException unused) {
            e.b("LoginTask", "login remote exception", true);
        }
    }

    @Override // l.a.a.c.a.b
    public void a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "login timeout. retry again");
        }
        this.f10067f.a(errorStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HonorAccount honorAccount) {
        String strU = honorAccount.u();
        if (TextUtils.isEmpty(strU) || d.c.a.b.a.a.f10075h.equalsIgnoreCase(strU)) {
            String strA = h.a(this.f10068g, 0);
            if (strA == null) {
                strA = "";
            }
            honorAccount.v(strA);
        }
    }
}
