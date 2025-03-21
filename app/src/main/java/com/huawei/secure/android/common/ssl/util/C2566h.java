package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* renamed from: com.huawei.secure.android.common.ssl.util.h */
/* loaded from: classes.dex */
public class C2566h {

    /* renamed from: b */
    private static final String f8250b = "X509CertificateUtil";

    /* renamed from: c */
    public static final String f8251c = "hmsrootcas.bks";

    /* renamed from: d */
    public static final String f8252d = "";

    /* renamed from: e */
    public static final String f8253e = "bks";

    /* renamed from: f */
    public static final String f8254f = "052root";

    /* renamed from: g */
    private static final String f8255g = "hmsincas.bks";

    /* renamed from: h */
    private static final String f8256h = "huawei cbg application integration ca";

    /* renamed from: a */
    private Context f8257a;

    public C2566h(Context context) {
        this.f8257a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: a */
    public X509Certificate m8002a(String str, String str2) {
        InputStream inputStream;
        X509Certificate x509Certificate;
        KeyStore keyStore;
        try {
            try {
                keyStore = KeyStore.getInstance(f8253e);
                inputStream = this.f8257a.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStream = null;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStream = null;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStream = null;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                str = 0;
                AbstractC2562d.m7977a((InputStream) str);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStream;
            } catch (IOException e6) {
                e = e6;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                e = e7;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            } catch (CertificateException e9) {
                e = e9;
                C2563e.m7986b(f8250b, "loadBksCA: exception : " + e.getMessage());
                x509Certificate = null;
                str = inputStream;
                AbstractC2562d.m7977a((InputStream) str);
                return x509Certificate;
            }
            AbstractC2562d.m7977a((InputStream) str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            AbstractC2562d.m7977a((InputStream) str);
            throw th;
        }
    }

    /* renamed from: b */
    public X509Certificate m8003b() {
        return m8002a("hmsrootcas.bks", f8254f);
    }

    /* renamed from: a */
    public X509Certificate m8001a() {
        return m8002a(f8255g, f8256h);
    }
}
