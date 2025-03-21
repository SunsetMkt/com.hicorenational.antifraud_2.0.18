package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.AbstractC2562d;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class SecureX509TrustManager implements X509TrustManager {

    /* renamed from: c */
    private static final String f8176c = "SX509TM";

    /* renamed from: d */
    public static final String f8177d = "hmsrootcas.bks";

    /* renamed from: e */
    private static final String f8178e = "";

    /* renamed from: f */
    private static final String f8179f = "X509";

    /* renamed from: g */
    private static final String f8180g = "bks";

    /* renamed from: h */
    private static final String f8181h = "AndroidCAStore";

    /* renamed from: a */
    protected List<X509TrustManager> f8182a;

    /* renamed from: b */
    private X509Certificate[] f8183b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    /* renamed from: a */
    private void m7919a() {
        C2563e.m7987c(f8176c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f8181h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f8179f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f8182a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            C2563e.m7986b(f8176c, "loadSystemCA: exception : " + e2.getMessage());
        }
        C2563e.m7984a(f8176c, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C2563e.m7987c(f8176c, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f8182a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                C2563e.m7986b(f8176c, "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        C2563e.m7987c(f8176c, "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            C2563e.m7984a(f8176c, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            C2563e.m7984a(f8176c, "IssuerDN :" + x509Certificate.getIssuerDN());
            C2563e.m7984a(f8176c, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f8182a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                C2563e.m7987c(f8176c, "check server i=" + i2);
                X509TrustManager x509TrustManager = this.f8182a.get(i2);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    C2563e.m7987c(f8176c, "client root ca size=" + acceptedIssuers.length);
                    for (X509Certificate x509Certificate2 : acceptedIssuers) {
                        C2563e.m7984a(f8176c, "client root ca getIssuerDN :" + x509Certificate2.getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                C2563e.m7987c(f8176c, "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e2) {
                C2563e.m7986b(f8176c, "checkServerTrusted error :" + e2.getMessage() + " , time : " + i2);
                if (i2 == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        C2563e.m7986b(f8176c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e2;
                }
            }
        }
        C2563e.m7984a(f8176c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f8182a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            C2563e.m7986b(f8176c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.f8183b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.f8182a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.f8183b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.f8182a = list;
    }

    public SecureX509TrustManager(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f8182a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        ContextUtil.setContext(context);
        if (z) {
            m7919a();
        }
        m7920a(context);
        if (this.f8182a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f8182a = new ArrayList();
        m7922a(inputStream, str);
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    /* renamed from: a */
    private void m7920a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z;
        C2563e.m7987c(f8176c, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream filesBksIS = BksUtil.getFilesBksIS(context);
        if (filesBksIS != null) {
            try {
                C2563e.m7987c(f8176c, "get bks not from assets");
                m7921a(filesBksIS);
            } catch (IOException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                C2563e.m7986b(f8176c, "loadBksCA: exception : " + e2.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || filesBksIS == null) {
            C2563e.m7987c(f8176c, " get bks from assets ");
            m7921a(context.getAssets().open("hmsrootcas.bks"));
        }
        C2563e.m7984a(f8176c, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f8182a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            m7922a(fileInputStream, "");
            AbstractC2562d.m7977a((InputStream) fileInputStream);
            if (z) {
                m7919a();
            }
        } catch (Throwable th2) {
            th = th2;
            AbstractC2562d.m7977a((InputStream) fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.f8182a = new ArrayList();
        if (z) {
            m7919a();
        }
        m7922a(inputStream, str);
    }

    /* renamed from: a */
    private void m7921a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f8179f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.f8182a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } finally {
            AbstractC2562d.m7977a(inputStream);
        }
    }

    /* renamed from: a */
    private void m7922a(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f8179f);
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (int i2 = 0; i2 < trustManagers.length; i2++) {
                        if (trustManagers[i2] instanceof X509TrustManager) {
                            this.f8182a.add((X509TrustManager) trustManagers[i2]);
                        }
                    }
                    AbstractC2562d.m7977a(inputStream);
                } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                    C2563e.m7986b(f8176c, "loadInputStream: exception : " + e2.getMessage());
                }
                C2563e.m7984a(f8176c, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            } finally {
                AbstractC2562d.m7977a(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }
}
