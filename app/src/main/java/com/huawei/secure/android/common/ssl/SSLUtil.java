package com.huawei.secure.android.common.ssl;

import android.os.Build;
import com.huawei.secure.android.common.ssl.util.C2563e;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public abstract class SSLUtil {

    /* renamed from: a */
    private static final String f8136a = "SSLUtil";

    /* renamed from: b */
    private static final String f8137b = "TLSv1.3";

    /* renamed from: c */
    private static final String f8138c = "TLSv1.2";

    /* renamed from: d */
    private static final String f8139d = "TLS";

    /* renamed from: e */
    private static final String f8140e = "TLSv1";

    /* renamed from: f */
    private static final String[] f8141f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g */
    private static final String[] f8142g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h */
    private static final String[] f8143h = {"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] getEnabledCipherSuites(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] getEnabledProtocols(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void printTLSAndCipher(SSLSocket sSLSocket) {
        for (String str : sSLSocket.getEnabledProtocols()) {
            C2563e.m7987c(f8136a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            C2563e.m7987c(f8136a, "new cipher suites is : " + str2);
        }
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return setBlackListCipherSuites(sSLSocket, f8143h);
    }

    public static void setEnableSafeCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null || setWhiteListCipherSuites(sSLSocket)) {
            return;
        }
        setBlackListCipherSuites(sSLSocket);
    }

    public static void setEnabledProtocols(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{f8137b, f8138c});
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && i2 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f8138c});
        } else if (Build.VERSION.SDK_INT < 16) {
            sSLSocket.setEnabledProtocols(new String[]{f8140e});
        }
    }

    public static SSLContext setSSLContext() throws NoSuchAlgorithmException {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 29 ? SSLContext.getInstance(f8137b) : i2 >= 16 ? SSLContext.getInstance(f8138c) : SSLContext.getInstance(f8139d);
    }

    public static void setSSLSocketOptions(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        setEnabledProtocols(sSLSocket);
        setEnableSafeCipherSuites(sSLSocket);
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return Build.VERSION.SDK_INT > 19 ? setWhiteListCipherSuites(sSLSocket, f8142g) : setWhiteListCipherSuites(sSLSocket, f8141f);
    }

    public static boolean setBlackListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            String str = enabledCipherSuites[i2];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z = false;
                    break;
                }
                if (upperCase.contains(strArr[i3].toUpperCase(Locale.ENGLISH))) {
                    break;
                }
                i3++;
            }
            if (!z) {
                arrayList.add(str);
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setWhiteListCipherSuites(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static boolean setEnabledProtocols(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e2) {
                C2563e.m7986b(f8136a, "setEnabledProtocols: exception : " + e2.getMessage());
            }
        }
        return false;
    }
}
