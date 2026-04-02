package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes.dex */
public class SecureX509SingleInstance {
    private static final String a = "SecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f5169b;

    private SecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f5169b == null) {
            synchronized (SecureX509SingleInstance.class) {
                if (f5169b == null) {
                    InputStream inputStreamOpen = null;
                    try {
                        inputStreamOpen = BksUtil.getFilesBksIS(context);
                    } catch (RuntimeException unused) {
                        e.b(a, "get files bks error");
                    }
                    if (inputStreamOpen == null) {
                        e.c(a, "get assets bks");
                        inputStreamOpen = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.c(a, "get files bks");
                    }
                    f5169b = new SecureX509TrustManager(inputStreamOpen, "");
                }
            }
        }
        e.a(a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f5169b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        e.c(a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f5169b != null) {
            f5169b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f5169b);
            SecureApacheSSLSocketFactory.a(f5169b);
        }
        e.c(a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        e.c(a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f5169b != null) {
            f5169b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.a(f5169b, secureRandom);
            SecureApacheSSLSocketFactory.a(f5169b, secureRandom);
        }
        e.c(a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }
}
