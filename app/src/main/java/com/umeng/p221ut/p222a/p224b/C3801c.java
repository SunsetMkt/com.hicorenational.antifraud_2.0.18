package com.umeng.p221ut.p222a.p224b;

import android.annotation.TargetApi;
import com.umeng.p221ut.p222a.p225c.C3810e;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

@TargetApi(24)
/* renamed from: com.umeng.ut.a.b.c */
/* loaded from: classes2.dex */
class C3801c extends X509ExtendedTrustManager {

    /* renamed from: a */
    private static TrustManager[] f13862a;

    C3801c() {
    }

    static synchronized TrustManager[] getTrustManagers() {
        TrustManager[] trustManagerArr;
        synchronized (C3801c.class) {
            if (f13862a == null) {
                f13862a = new TrustManager[]{new C3801c()};
            }
            trustManagerArr = f13862a;
        }
        return trustManagerArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkClientTrusted1");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkServerTrusted1");
        if (x509CertificateArr == null || x509CertificateArr.length <= 0) {
            throw new IllegalArgumentException("checkServerTrusted: X509Certificate array is null");
        }
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init((KeyStore) null);
            if (trustManagerFactory == null || trustManagerFactory.getTrustManagers() == null) {
                return;
            }
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                try {
                    ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
                } catch (CertificateException e2) {
                    for (Throwable th = e2; th != null; th = th.getCause()) {
                        if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                            return;
                        }
                    }
                    throw e2;
                }
            }
        } catch (KeyStoreException e3) {
            throw new CertificateException(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new CertificateException(e4);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkClientTrusted2");
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("parameter is not used");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("parameter is not used");
        }
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
            throw new CertificateException("Certificate not valid or trusted.");
        }
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkClientTrusted3");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkServerTrusted2");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        C3810e.m12784a("UtExtendTrustManager", "checkServerTrusted3");
    }
}
