package com.huawei.hms.framework.network.grs.p178h.p180g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew;
import com.huawei.secure.android.common.ssl.SecureX509TrustManager;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.huawei.hms.framework.network.grs.h.g.a */
/* loaded from: classes.dex */
public class C2388a {

    /* renamed from: a */
    private static final HostnameVerifier f7446a = new StrictHostnameVerifier();

    /* renamed from: a */
    public static HostnameVerifier m6988a() {
        return f7446a;
    }

    /* renamed from: a */
    public static SSLSocketFactory m6989a(Context context) {
        try {
            return new SecureSSLSocketFactoryNew(new SecureX509TrustManager(context.getAssets().open(GrsApp.getInstance().getBrand("/") + "grs_sp.bks"), ""));
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}
