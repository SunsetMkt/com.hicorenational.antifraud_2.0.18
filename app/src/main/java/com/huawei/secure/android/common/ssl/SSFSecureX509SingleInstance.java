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
public class SSFSecureX509SingleInstance {
    private static final String a = "SSFSecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f5134b;

    private SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f5134b == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                if (f5134b == null) {
                    InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        e.c(a, "get assets bks");
                        filesBksIS = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.c(a, "get files bks");
                    }
                    f5134b = new SecureX509TrustManager(filesBksIS, "", true);
                }
            }
        }
        return f5134b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        e.c(a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f5134b != null) {
            f5134b = new SecureX509TrustManager(inputStream, "", true);
            e.a(a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(f5134b);
            SASFCompatiableSystemCA.a(f5134b);
        }
        e.a(a, "update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        e.c(a, "update bks");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f5134b != null) {
            f5134b = new SecureX509TrustManager(inputStream, "", true);
            e.a(a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            SSFCompatiableSystemCA.a(f5134b, secureRandom);
            SASFCompatiableSystemCA.a(f5134b, secureRandom);
        }
        e.a(a, "update bks cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }
}
