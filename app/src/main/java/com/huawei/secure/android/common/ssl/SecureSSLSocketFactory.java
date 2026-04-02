package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5151i = SecureSSLSocketFactory.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f5152j = null;
    private SSLContext a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLSocket f5153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String[] f5155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private X509TrustManager f5156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f5157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f5158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f5159h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = null;
        this.f5153b = null;
        this.a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f5151i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5152j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f5151i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f5151i, "NoSuchAlgorithmException");
        }
        e.a(f5151i, "update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f5152j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f5152j == null) {
                    f5152j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        if (f5152j.f5154c == null && context != null) {
            f5152j.setContext(context);
        }
        e.a(f5151i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f5152j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f5151i, "createSocket: host , port");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5153b = (SSLSocket) socketCreateSocket;
            this.f5155d = (String[]) this.f5153b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f5157f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f5156e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f5154c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f5159h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.f5153b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f5155d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f5158g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f5156e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f5157f = strArr;
    }

    public void setContext(Context context) {
        this.f5154c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f5159h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f5158g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f5156e = x509TrustManager;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f5151i, "ssf update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5152j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f5151i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f5151i, "NoSuchAlgorithmException");
        }
        e.a(f5151i, "update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = null;
        this.f5153b = null;
        this.a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f5151i, "createSocket s host port autoClose");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5153b = (SSLSocket) socketCreateSocket;
            this.f5155d = (String[]) this.f5153b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f5152j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f5152j == null) {
                    f5152j = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        if (f5152j.f5154c == null && context != null) {
            f5152j.setContext(context);
        }
        e.a(f5151i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f5152j;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5159h)) {
            z = false;
        } else {
            e.c(f5151i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f5159h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5158g) && com.huawei.secure.android.common.ssl.util.a.a(this.f5157f)) {
            z2 = false;
        } else {
            e.c(f5151i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f5158g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f5158g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f5157f);
            }
        }
        if (!z) {
            e.c(f5151i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f5151i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.a = null;
        this.f5153b = null;
        if (context == null) {
            e.b(f5151i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f5156e = SecureX509SingleInstance.getInstance(context);
        this.a.init(null, new X509TrustManager[]{this.f5156e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5153b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5153b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
