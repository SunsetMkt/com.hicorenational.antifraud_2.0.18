package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public final class CertificateUtil {

    /* renamed from: a */
    private static final String f8236a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate getHwCbgRootCA(Context context) {
        Throwable th;
        InputStream inputStream;
        KeyStore keyStore;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(C2566h.f8253e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e3) {
                e = e3;
                inputStream = null;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e4) {
                e = e4;
                inputStream = null;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                inputStream = null;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e6) {
                e = e6;
                inputStream = null;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                AbstractC2562d.m7977a((InputStream) context);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(C2566h.f8254f);
                context = inputStream;
            } catch (IOException e7) {
                e = e7;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e8) {
                e = e8;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e9) {
                e = e9;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e10) {
                e = e10;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e11) {
                e = e11;
                C2563e.m7986b(f8236a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                AbstractC2562d.m7977a((InputStream) context);
                return x509Certificate;
            }
            AbstractC2562d.m7977a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th3) {
            th = th3;
            AbstractC2562d.m7977a((InputStream) context);
            throw th;
        }
    }
}
