package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C2559a;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
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

/* loaded from: classes.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f8114i = SASFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j */
    private static volatile SASFCompatiableSystemCA f8115j = null;

    /* renamed from: a */
    private SSLContext f8116a;

    /* renamed from: b */
    private SSLSocket f8117b;

    /* renamed from: c */
    private Context f8118c;

    /* renamed from: d */
    private String[] f8119d;

    /* renamed from: e */
    private X509TrustManager f8120e;

    /* renamed from: f */
    private String[] f8121f;

    /* renamed from: g */
    private String[] f8122g;

    /* renamed from: h */
    private String[] f8123h;

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f8117b = null;
    }

    @Deprecated
    /* renamed from: a */
    static void m7907a(X509TrustManager x509TrustManager) {
        C2563e.m7987c(f8114i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8115j = new SASFCompatiableSystemCA(null, x509TrustManager);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8114i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            C2563e.m7986b(f8114i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            C2563e.m7986b(f8114i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            C2563e.m7986b(f8114i, "UnrecoverableKeyException");
        }
        C2563e.m7984a(f8114i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8115j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f8115j == null) {
                    f8115j = new SASFCompatiableSystemCA(keyStore, context, (SecureRandom) null);
                }
            }
        }
        return f8115j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        C2563e.m7987c(f8114i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f8116a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            m7906a(createSocket);
            this.f8117b = (SSLSocket) createSocket;
            this.f8119d = (String[]) this.f8117b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f8121f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f8120e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f8118c;
    }

    public String[] getProtocols() {
        return this.f8123h;
    }

    public SSLContext getSslContext() {
        return this.f8116a;
    }

    public SSLSocket getSslSocket() {
        return this.f8117b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f8119d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f8122g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f8120e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f8121f = strArr;
    }

    public void setContext(Context context) {
        this.f8118c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f8123h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f8116a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f8117b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f8122g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f8120e = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f8117b = null;
        if (context == null) {
            C2563e.m7986b(f8114i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f8120e = SSFSecureX509SingleInstance.getInstance(context);
        this.f8116a.init(null, new X509TrustManager[]{this.f8120e}, secureRandom);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        C2563e.m7987c(f8114i, "createSocket: ");
        Socket createSocket = this.f8116a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            m7906a(createSocket);
            this.f8117b = (SSLSocket) createSocket;
            this.f8119d = (String[]) this.f8117b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8115j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f8115j == null) {
                    f8115j = new SASFCompatiableSystemCA(keyStore, context, secureRandom);
                }
            }
        }
        return f8115j;
    }

    /* renamed from: a */
    static void m7908a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C2563e.m7987c(f8114i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8115j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8114i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            C2563e.m7986b(f8114i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            C2563e.m7986b(f8114i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            C2563e.m7986b(f8114i, "UnrecoverableKeyException");
        }
        C2563e.m7984a(f8114i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f8117b = null;
        this.f8116a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8116a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f8117b = null;
        this.f8116a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8116a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }

    /* renamed from: a */
    private void m7906a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (C2559a.m7955a(this.f8123h)) {
            z = false;
        } else {
            C2563e.m7987c(f8114i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f8123h);
            z = true;
        }
        if (C2559a.m7955a(this.f8122g) && C2559a.m7955a(this.f8121f)) {
            z2 = false;
        } else {
            C2563e.m7987c(f8114i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C2559a.m7955a(this.f8122g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f8122g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f8121f);
            }
        }
        if (!z) {
            C2563e.m7987c(f8114i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C2563e.m7987c(f8114i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
