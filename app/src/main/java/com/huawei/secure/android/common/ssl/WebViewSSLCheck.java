package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.WebViewSSLCheckThread;
import com.huawei.secure.android.common.ssl.util.C2560b;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.C2566h;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public class WebViewSSLCheck {

    /* renamed from: a */
    private static final String f8184a = "WebViewSSLCheck";

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        checkServerCertificateNew(sslErrorHandler, sslError, null, context, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, WebViewSSLCheckThread.Callback callback) {
        C2563e.m7987c(f8184a, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate m7956a = C2560b.m7956a(sslError.getCertificate());
        X509Certificate m8001a = new C2566h(context).m8001a();
        C2563e.m7984a(f8184a, "checkServerCertificateNew: error certificate is : " + m7956a);
        if (C2560b.m7960a(m8001a, m7956a)) {
            C2563e.m7987c(f8184a, "checkServerCertificateNew: proceed");
            if (callback != null) {
                callback.onProceed(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        C2563e.m7986b(f8184a, "checkServerCertificateNew: cancel");
        if (callback != null) {
            callback.onCancel(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean checkServerCertificateNew(X509Certificate x509Certificate, SslError sslError) {
        return C2560b.m7960a(x509Certificate, C2560b.m7956a(sslError.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String str, SslError sslError) {
        return checkServerCertificateNew(C2560b.m7957a(str), sslError);
    }
}
