package p031c.p075c.p076a.p084c.p085a.p086b;

import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.honorid.core.data.HonorAccount;
import com.tencent.connect.common.Constants;
import p358k.p359a.p360a.p361a.C5850d;

/* compiled from: AccountAuthParamUtil.java */
/* renamed from: c.c.a.c.a.b.a */
/* loaded from: classes.dex */
public class C1199a {
    /* renamed from: a */
    public static Bundle m2294a(SignInOptions signInOptions) {
        String m6026b = signInOptions.m6026b();
        String m24636a = C5850d.m24636a(signInOptions.m6030f());
        Bundle bundle = new Bundle();
        bundle.putString("app_id", m6026b);
        String m6027c = signInOptions.m6027c();
        if (!TextUtils.isEmpty(m6027c)) {
            bundle.putInt("login_channel", Integer.parseInt(m6027c));
        }
        bundle.putString(Constants.PARAM_SCOPE, m24636a);
        bundle.putBoolean("requireAccessToken", signInOptions.m6037m());
        bundle.putBoolean("reqiureAuthCode", signInOptions.m6036l());
        bundle.putInt("reqClientType", 7);
        return bundle;
    }

    /* renamed from: a */
    public static SignInAccountInfo m2295a(HonorAccount honorAccount) {
        return SignInAccountInfo.m5998a(honorAccount.m6183m(), "", null, honorAccount.m6185n(), honorAccount.m6201v(), honorAccount.m6175i());
    }
}
