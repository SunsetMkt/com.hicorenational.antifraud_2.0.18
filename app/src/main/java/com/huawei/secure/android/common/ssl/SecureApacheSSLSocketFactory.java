package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C2559a;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f8144i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* renamed from: j */
    private static volatile SecureApacheSSLSocketFactory f8145j = null;

    /* renamed from: a */
    private SSLContext f8146a;

    /* renamed from: b */
    private SSLSocket f8147b;

    /* renamed from: c */
    private Context f8148c;

    /* renamed from: d */
    private String[] f8149d;

    /* renamed from: e */
    private X509TrustManager f8150e;

    /* renamed from: f */
    private String[] f8151f;

    /* renamed from: g */
    private String[] f8152g;

    /* renamed from: h */
    private String[] f8153h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f8147b = null;
    }

    @Deprecated
    /* renamed from: a */
    static void m7913a(X509TrustManager x509TrustManager) {
        C2563e.m7987c(f8144i, "sasf update socket factory trust manager");
        try {
            f8145j = new SecureApacheSSLSocketFactory(null, x509TrustManager);
        } catch (IOException unused) {
            C2563e.m7986b(f8144i, "IOException");
        } catch (KeyManagementException unused2) {
            C2563e.m7986b(f8144i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            C2563e.m7986b(f8144i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            C2563e.m7986b(f8144i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            C2563e.m7986b(f8144i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            C2563e.m7986b(f8144i, "CertificateException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8145j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f8145j == null) {
                    f8145j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f8145j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        C2563e.m7987c(f8144i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f8146a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            m7912a(createSocket);
            this.f8147b = (SSLSocket) createSocket;
            this.f8149d = (String[]) this.f8147b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f8151f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f8150e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f8148c;
    }

    public String[] getProtocols() {
        return this.f8153h;
    }

    public SSLContext getSslContext() {
        return this.f8146a;
    }

    public SSLSocket getSslSocket() {
        return this.f8147b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f8149d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f8152g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f8150e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f8151f = strArr;
    }

    public void setContext(Context context) {
        this.f8148c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f8153h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f8146a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f8147b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f8152g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f8150e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8147b = null;
        if (context == null) {
            C2563e.m7986b(f8144i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f8150e = SecureX509SingleInstance.getInstance(context);
        this.f8146a.init(null, new X509TrustManager[]{this.f8150e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        C2563e.m7987c(f8144i, "createSocket: ");
        Socket createSocket = this.f8146a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m7912a(createSocket);
            this.f8147b = (SSLSocket) createSocket;
            this.f8149d = (String[]) this.f8147b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8145j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f8145j == null) {
                    f8145j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f8145j;
    }

    /* renamed from: a */
    static void m7914a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C2563e.m7987c(f8144i, "sasf update socket factory trust manager");
        try {
            f8145j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            C2563e.m7986b(f8144i, "IOException");
        } catch (KeyManagementException unused2) {
            C2563e.m7986b(f8144i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            C2563e.m7986b(f8144i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            C2563e.m7986b(f8144i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            C2563e.m7986b(f8144i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            C2563e.m7986b(f8144i, "CertificateException");
        }
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8147b = null;
        this.f8146a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8146a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8147b = null;
        this.f8146a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8146a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    /* renamed from: a */
    private void m7912a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (C2559a.m7955a(this.f8153h)) {
            z = false;
        } else {
            C2563e.m7987c(f8144i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f8153h);
            z = true;
        }
        if (C2559a.m7955a(this.f8152g) && C2559a.m7955a(this.f8151f)) {
            z2 = false;
        } else {
            C2563e.m7987c(f8144i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C2559a.m7955a(this.f8152g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f8152g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f8151f);
            }
        }
        if (!z) {
            C2563e.m7987c(f8144i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C2563e.m7987c(f8144i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8147b = null;
        this.f8146a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8146a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8147b = null;
        this.f8146a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8146a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
