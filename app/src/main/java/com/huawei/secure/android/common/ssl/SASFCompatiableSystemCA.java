package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
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
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* JADX INFO: renamed from: i */
    private static final String f5116i = SASFCompatiableSystemCA.class.getSimpleName();

    /* JADX INFO: renamed from: j */
    private static volatile SASFCompatiableSystemCA f5117j = null;
    private SSLContext a;

    /* JADX INFO: renamed from: b */
    private SSLSocket f5118b;

    /* JADX INFO: renamed from: c */
    private Context f5119c;

    /* JADX INFO: renamed from: d */
    private String[] f5120d;

    /* JADX INFO: renamed from: e */
    private X509TrustManager f5121e;

    /* JADX INFO: renamed from: f */
    private String[] f5122f;

    /* JADX INFO: renamed from: g */
    private String[] f5123g;

    /* JADX INFO: renamed from: h */
    private String[] f5124h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.f5118b = null;
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f5116i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5117j = new SASFCompatiableSystemCA(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f5116i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f5116i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f5116i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f5116i, "UnrecoverableKeyException");
        }
        e.a(f5116i, "sasf system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5117j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f5117j == null) {
                    f5117j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f5117j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f5116i, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5118b = (SSLSocket) socketCreateSocket;
            this.f5120d = (String[]) this.f5118b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f5122f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f5121e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f5119c;
    }

    public String[] getProtocols() {
        return this.f5124h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.f5118b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f5120d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f5123g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f5121e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f5122f = strArr;
    }

    public void setContext(Context context) {
        this.f5119c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f5124h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f5118b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f5123g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f5121e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.f5118b = null;
        if (context == null) {
            e.b(f5116i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f5121e = SSFSecureX509SingleInstance.getInstance(context);
        this.a.init(null, new X509TrustManager[]{this.f5121e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.c(f5116i, "createSocket: ");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5118b = (SSLSocket) socketCreateSocket;
            this.f5120d = (String[]) this.f5118b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5117j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f5117j == null) {
                    f5117j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                }
            }
        }
        return f5117j;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f5116i, "sasfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5117j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f5116i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.b(f5116i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.b(f5116i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.b(f5116i, "UnrecoverableKeyException");
        }
        e.a(f5116i, "sasf system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, IllegalArgumentException {
        super(keyStore);
        this.f5118b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, IllegalArgumentException {
        super(keyStore);
        this.f5118b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5124h)) {
            z = false;
        } else {
            e.c(f5116i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f5124h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5123g) && com.huawei.secure.android.common.ssl.util.a.a(this.f5122f)) {
            z2 = false;
        } else {
            e.c(f5116i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f5123g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f5123g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f5122f);
            }
        }
        if (!z) {
            e.c(f5116i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f5116i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
