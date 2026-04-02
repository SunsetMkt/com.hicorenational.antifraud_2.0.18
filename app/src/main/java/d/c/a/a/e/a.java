package d.c.a.a.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;
import com.hihonor.cloudservice.framework.aidl.a;
import com.hihonor.honorid.core.helper.handler.ErrorStatus;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: AuthOperationTask.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends l.a.a.c.a.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bundle f10062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.a.a.d.b f10063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f10064f;

    /* JADX INFO: renamed from: d.c.a.a.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AuthOperationTask.java */
    class BinderC0162a extends a.AbstractBinderC0086a {
        BinderC0162a() {
        }

        @Override // com.hihonor.cloudservice.framework.aidl.a
        public void a(DataBuffer dataBuffer) {
            e.b("AuthOperationTask", "onResult", true);
            if (((l.a.a.c.a.b) a.this).f12705b.get()) {
                e.b("AuthOperationTask", "has cancelled by timeout, return directly", true);
                return;
            }
            a.this.b();
            String str = dataBuffer.f4013b;
            Bundle bundle = dataBuffer.f4015d;
            int i2 = bundle.getInt("retCode");
            e.b("AuthOperationTask", "onResult retCode:" + i2, true);
            if (i2 == 0) {
                if (str.equals("honorid.signout")) {
                    e.b("AuthOperationTask", "opensdk signOut", true);
                    a.this.f10063e.a(bundle);
                    return;
                } else if (str.equals("honorid.revokeaccess")) {
                    a.this.f10063e.a(bundle);
                    return;
                } else if (!str.equals("honorid.getScope")) {
                    a.this.f10063e.a(bundle);
                    return;
                } else {
                    a.this.f10063e.a(((Intent) bundle.getParcelable("data")).getExtras());
                    return;
                }
            }
            if (i2 == 2001) {
                a.this.f10063e.a(new ErrorStatus(31, "Account has not login"));
                return;
            }
            if (i2 == 7) {
                a.this.f10063e.a(new ErrorStatus(42, "userid not system account"));
                return;
            }
            if (i2 == 8) {
                a.this.f10063e.a(new ErrorStatus(44, "packagename was not matched"));
                return;
            }
            if (i2 == 9) {
                a.this.f10063e.a(new ErrorStatus(43, "packagename not in honorid list"));
                return;
            }
            if (i2 == 1) {
                a.this.f10063e.a(new ErrorStatus(29, "Signature invalid"));
            } else if (i2 == 5) {
                a.this.f10063e.a(new ErrorStatus(69, "uid not match"));
            } else {
                a.this.f10063e.a(new ErrorStatus(44, "other error"));
                e.b("AuthOperationTask", "DONT KNOW RET_CODE:", true);
            }
        }
    }

    public a(Context context, Bundle bundle, String str, d.c.a.a.d.b bVar) {
        super(context);
        this.f10062d = bundle;
        this.f10063e = bVar;
        this.f10064f = str;
    }

    @Override // l.a.a.c.a.b
    protected void a() {
        DataBuffer dataBuffer = new DataBuffer(this.f10064f, 1001);
        dataBuffer.f4015d = this.f10062d;
        try {
            l.a.a.c.a.a.a(this.f12706c).a().a(dataBuffer, new BinderC0162a());
        } catch (RemoteException unused) {
            e.a("AuthOperationTask", "authOperation remote exception", true);
        }
    }

    @Override // l.a.a.c.a.b
    public void a(ErrorStatus errorStatus) {
        if (errorStatus == null) {
            errorStatus = new ErrorStatus(39, "authOperation timeout. retry again");
        }
        this.f10063e.a(errorStatus);
    }
}
