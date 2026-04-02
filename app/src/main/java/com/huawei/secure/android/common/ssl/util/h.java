package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5222b = "X509CertificateUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5223c = "hmsrootcas.bks";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5224d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5225e = "bks";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5226f = "052root";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f5227g = "hmsincas.bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f5228h = "huawei cbg application integration ca";
    private Context a;

    public h(Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public X509Certificate a(String str, String str2) throws Throwable {
        InputStream inputStreamOpen;
        X509Certificate x509Certificate;
        KeyStore keyStore;
        try {
            try {
                keyStore = KeyStore.getInstance(f5225e);
                inputStreamOpen = this.a.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStreamOpen = null;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
                d.a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStreamOpen = null;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
                d.a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStreamOpen = null;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
                d.a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStreamOpen = null;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
                d.a((InputStream) str);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                str = 0;
                d.a((InputStream) str);
                throw th;
            }
            try {
                inputStreamOpen.reset();
                keyStore.load(inputStreamOpen, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStreamOpen;
            } catch (IOException e6) {
                e = e6;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
            } catch (KeyStoreException e7) {
                e = e7;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
            } catch (CertificateException e9) {
                e = e9;
                e.b(f5222b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStreamOpen;
            }
            d.a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a((InputStream) str);
            throw th;
        }
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f5226f);
    }

    public X509Certificate a() {
        return a(f5227g, f5228h);
    }
}
