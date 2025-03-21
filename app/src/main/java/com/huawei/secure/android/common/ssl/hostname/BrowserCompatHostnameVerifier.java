package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.AsyncTaskC2561c;
import com.huawei.secure.android.common.ssl.util.C2563e;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class BrowserCompatHostnameVerifier implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            C2563e.m7987c("", "verify: certificate is : " + x509Certificate.getSubjectDN().getName());
            C2558b.m7935a(str, x509Certificate, false);
            AsyncTaskC2561c.m7966a();
            return true;
        } catch (SSLException e2) {
            C2563e.m7986b("", "SSLException : " + e2.getMessage());
            return false;
        }
    }
}
