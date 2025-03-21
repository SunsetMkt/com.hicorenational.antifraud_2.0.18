package com.huawei.secure.android.common.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public class SecureX509SingleInstance {

    /* renamed from: a */
    private static final String f8174a = "SecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f8175b;

    private SecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f8175b == null) {
            synchronized (SecureX509SingleInstance.class) {
                if (f8175b == null) {
                    InputStream inputStream = null;
                    try {
                        inputStream = BksUtil.getFilesBksIS(context);
                    } catch (RuntimeException unused) {
                        C2563e.m7986b(f8174a, "get files bks error");
                    }
                    if (inputStream == null) {
                        C2563e.m7987c(f8174a, "get assets bks");
                        inputStream = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        C2563e.m7987c(f8174a, "get files bks");
                    }
                    f8175b = new SecureX509TrustManager(inputStream, "");
                }
            }
        }
        C2563e.m7984a(f8174a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f8175b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        C2563e.m7987c(f8174a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f8175b != null) {
            f8175b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.m7916a(f8175b);
            SecureApacheSSLSocketFactory.m7913a(f8175b);
        }
        C2563e.m7987c(f8174a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        C2563e.m7987c(f8174a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f8175b != null) {
            f8175b = new SecureX509TrustManager(inputStream, "");
            SecureSSLSocketFactory.m7917a(f8175b, secureRandom);
            SecureApacheSSLSocketFactory.m7914a(f8175b, secureRandom);
        }
        C2563e.m7987c(f8174a, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
