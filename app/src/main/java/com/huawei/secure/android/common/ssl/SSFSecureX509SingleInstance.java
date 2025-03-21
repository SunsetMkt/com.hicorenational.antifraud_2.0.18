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
public class SSFSecureX509SingleInstance {

    /* renamed from: a */
    private static final String f8134a = "SSFSecureX509SingleInstance";

    /* renamed from: b */
    private static volatile SecureX509TrustManager f8135b;

    private SSFSecureX509SingleInstance() {
    }

    @SuppressLint({"NewApi"})
    public static SecureX509TrustManager getInstance(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        ContextUtil.setContext(context);
        if (f8135b == null) {
            synchronized (SSFSecureX509SingleInstance.class) {
                if (f8135b == null) {
                    InputStream filesBksIS = BksUtil.getFilesBksIS(context);
                    if (filesBksIS == null) {
                        C2563e.m7987c(f8134a, "get assets bks");
                        filesBksIS = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        C2563e.m7987c(f8134a, "get files bks");
                    }
                    f8135b = new SecureX509TrustManager(filesBksIS, "", true);
                }
            }
        }
        return f8135b;
    }

    @Deprecated
    public static void updateBks(InputStream inputStream) {
        C2563e.m7987c(f8134a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f8135b != null) {
            f8135b = new SecureX509TrustManager(inputStream, "", true);
            C2563e.m7984a(f8134a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.m7910a(f8135b);
            SASFCompatiableSystemCA.m7907a(f8135b);
        }
        C2563e.m7984a(f8134a, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static void updateBks(InputStream inputStream, SecureRandom secureRandom) {
        C2563e.m7987c(f8134a, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && f8135b != null) {
            f8135b = new SecureX509TrustManager(inputStream, "", true);
            C2563e.m7984a(f8134a, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            SSFCompatiableSystemCA.m7911a(f8135b, secureRandom);
            SASFCompatiableSystemCA.m7908a(f8135b, secureRandom);
        }
        C2563e.m7984a(f8134a, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
