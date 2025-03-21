package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C2560b;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.C2566h;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.huawei.secure.android.common.ssl.c */
/* loaded from: classes.dex */
public class C2556c implements X509TrustManager {

    /* renamed from: c */
    private static final String f8206c = "WebViewX509TrustManger";

    /* renamed from: a */
    private X509Certificate f8207a;

    /* renamed from: b */
    private List<X509TrustManager> f8208b = new ArrayList();

    public C2556c(Context context) {
        if (context == null) {
            throw new NullPointerException("WebViewX509TrustManger context is null");
        }
        ContextUtil.setContext(context);
        this.f8207a = new C2566h(context).m8003b();
        if (this.f8207a == null) {
            throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C2563e.m7987c(f8206c, "checkClientTrusted");
        if (this.f8208b.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.f8208b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        C2563e.m7987c(f8206c, "checkServerTrusted");
        boolean z = false;
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            C2563e.m7984a(f8206c, "checkServerTrusted " + i2 + " : " + x509CertificateArr[i2].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i3 = 0; i3 < x509CertificateArr.length; i3++) {
            x509CertificateArr2[i3] = x509CertificateArr[(x509CertificateArr.length - 1) - i3];
        }
        CertificateException e2 = new CertificateException("CBG root CA CertificateException");
        try {
            z = C2560b.m7961a(this.f8207a, x509CertificateArr2);
        } catch (InvalidKeyException e3) {
            C2563e.m7986b(f8206c, "checkServerTrusted InvalidKeyException: " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            C2563e.m7986b(f8206c, "checkServerTrusted NoSuchAlgorithmException: " + e4.getMessage());
        } catch (NoSuchProviderException e5) {
            C2563e.m7986b(f8206c, "checkServerTrusted NoSuchProviderException: " + e5.getMessage());
        } catch (SignatureException e6) {
            C2563e.m7986b(f8206c, "checkServerTrusted SignatureException: " + e6.getMessage());
        } catch (CertificateException e7) {
            e2 = e7;
            C2563e.m7986b(f8206c, "checkServerTrusted CertificateException: " + e2.getMessage());
        }
        if (!z) {
            throw e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f8208b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            C2563e.m7986b(f8206c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }
}
