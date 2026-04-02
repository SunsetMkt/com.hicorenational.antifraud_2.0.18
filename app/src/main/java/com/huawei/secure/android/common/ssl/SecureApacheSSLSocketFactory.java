package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
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

/* JADX INFO: loaded from: classes.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: i */
    private static final String f5142i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* JADX INFO: renamed from: j */
    private static volatile SecureApacheSSLSocketFactory f5143j = null;
    private SSLContext a;

    /* JADX INFO: renamed from: b */
    private SSLSocket f5144b;

    /* JADX INFO: renamed from: c */
    private Context f5145c;

    /* JADX INFO: renamed from: d */
    private String[] f5146d;

    /* JADX INFO: renamed from: e */
    private X509TrustManager f5147e;

    /* JADX INFO: renamed from: f */
    private String[] f5148f;

    /* JADX INFO: renamed from: g */
    private String[] f5149g;

    /* JADX INFO: renamed from: h */
    private String[] f5150h;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.f5144b = null;
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f5142i, "sasf update socket factory trust manager");
        try {
            f5143j = new SecureApacheSSLSocketFactory(null, x509TrustManager);
        } catch (IOException unused) {
            e.b(f5142i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f5142i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f5142i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f5142i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f5142i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f5142i, "CertificateException");
        }
    }

    @Deprecated
    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5143j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f5143j == null) {
                    f5143j = new SecureApacheSSLSocketFactory(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f5143j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f5142i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5144b = (SSLSocket) socketCreateSocket;
            this.f5146d = (String[]) this.f5144b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f5148f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f5147e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f5145c;
    }

    public String[] getProtocols() {
        return this.f5150h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.f5144b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f5146d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f5149g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f5147e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f5148f = strArr;
    }

    public void setContext(Context context) {
        this.f5145c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f5150h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f5144b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f5149g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f5147e = x509TrustManager;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5144b = null;
        if (context == null) {
            e.b(f5142i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f5147e = SecureX509SingleInstance.getInstance(context);
        this.a.init(null, new X509TrustManager[]{this.f5147e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f5142i, "createSocket: ");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5144b = (SSLSocket) socketCreateSocket;
            this.f5146d = (String[]) this.f5144b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5143j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f5143j == null) {
                    f5143j = new SecureApacheSSLSocketFactory(keyStore, context, secureRandom);
                }
            }
        }
        return f5143j;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f5142i, "sasf update socket factory trust manager");
        try {
            f5143j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager, secureRandom);
        } catch (IOException unused) {
            e.b(f5142i, "IOException");
        } catch (KeyManagementException unused2) {
            e.b(f5142i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.b(f5142i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.b(f5142i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.b(f5142i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.b(f5142i, "CertificateException");
        }
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5144b = null;
        this.a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5144b = null;
        this.a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5150h)) {
            z = false;
        } else {
            e.c(f5142i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f5150h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5149g) && com.huawei.secure.android.common.ssl.util.a.a(this.f5148f)) {
            z2 = false;
        } else {
            e.c(f5142i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f5149g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f5149g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f5148f);
            }
        }
        if (!z) {
            e.c(f5142i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f5142i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5144b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5144b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
