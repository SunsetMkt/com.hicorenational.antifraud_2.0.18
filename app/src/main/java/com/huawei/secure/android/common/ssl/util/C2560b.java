package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.huawei.secure.android.common.ssl.util.b */
/* loaded from: classes.dex */
public class C2560b {

    /* renamed from: a */
    private static final String f8238a = "b";

    /* renamed from: b */
    private static final int f8239b = 5;

    /* renamed from: a */
    public static X509Certificate m7957a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e2) {
            C2563e.m7986b(f8238a, "generateX509FromStr: CertificateException" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m7965b(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e2) {
                e = e2;
                C2563e.m7986b(f8238a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e3) {
                e = e3;
                C2563e.m7986b(f8238a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e4) {
                C2563e.m7986b(f8238a, "verifyCertificateDate : exception : " + e4.getMessage());
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m7962a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return !m7961a(x509Certificate, x509CertificateArr) && !m7964a(x509CertificateArr, x509crl) && m7959a(x509CertificateArr[x509CertificateArr.length - 1], str) && m7965b(x509CertificateArr);
    }

    /* renamed from: a */
    public static boolean m7964a(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next().getSerialNumber())) {
                    C2563e.m7986b(f8238a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            C2563e.m7986b(f8238a, "verify: revoked verify exception : " + e2.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m7959a(X509Certificate x509Certificate, String str) {
        if (str.equals(x509Certificate.getSubjectDN().getName())) {
            return true;
        }
        C2563e.m7986b(f8238a, "verify: subject name is error");
        return false;
    }

    /* renamed from: a */
    public static boolean m7960a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (m7965b(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            C2563e.m7986b(f8238a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e2) {
            C2563e.m7986b(f8238a, "verify: publickey InvalidKeyException " + e2.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e3) {
            C2563e.m7986b(f8238a, "verify: publickey NoSuchAlgorithmException " + e3.getMessage());
            return false;
        } catch (NoSuchProviderException e4) {
            C2563e.m7986b(f8238a, "verify: publickey NoSuchProviderException " + e4.getMessage());
            return false;
        } catch (SignatureException e5) {
            C2563e.m7986b(f8238a, "verify: publickey SignatureException " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            C2563e.m7986b(f8238a, "verify: publickey CertificateException " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            C2563e.m7986b(f8238a, "verify: Exception " + e7.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m7961a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i2 = 0;
        while (i2 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i2];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (issuerDN.equals(principal)) {
                    x509CertificateArr[i2].verify(x509CertificateArr[i2 - 1].getPublicKey());
                } else {
                    C2563e.m7986b(f8238a, "verify: principalIssuer not match");
                    return false;
                }
            }
            i2++;
            principal = subjectDN;
        }
        return m7960a(x509Certificate, x509CertificateArr[0]) && m7965b(x509CertificateArr) && m7958a(x509Certificate) && m7963a(x509CertificateArr);
    }

    /* renamed from: a */
    public static X509Certificate m7956a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e2) {
                C2563e.m7985a(f8238a, "exception", e2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m7963a(X509Certificate[] x509CertificateArr) {
        for (int i2 = 0; i2 < x509CertificateArr.length - 1; i2++) {
            if (!m7958a(x509CertificateArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m7958a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }
}
