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

    /* renamed from: a, reason: collision with root package name */
    private static final String f7654a = "CertificateUtil";

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
                keyStore = KeyStore.getInstance(h.f7671e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e3) {
                e = e3;
                inputStream = null;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e4) {
                e = e4;
                inputStream = null;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                inputStream = null;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e6) {
                e = e6;
                inputStream = null;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                d.a((InputStream) context);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(h.f7672f);
                context = inputStream;
            } catch (IOException e7) {
                e = e7;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (RuntimeException e8) {
                e = e8;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (KeyStoreException e9) {
                e = e9;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e10) {
                e = e10;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            } catch (CertificateException e11) {
                e = e11;
                e.b(f7654a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                d.a((InputStream) context);
                return x509Certificate;
            }
            d.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th3) {
            th = th3;
            d.a((InputStream) context);
            throw th;
        }
    }
}
