package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C2559a;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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

@Deprecated
/* loaded from: classes.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i */
    private static final String f8154i = SecureSSLSocketFactory.class.getSimpleName();

    /* renamed from: j */
    private static volatile SecureSSLSocketFactory f8155j = null;

    /* renamed from: a */
    private SSLContext f8156a;

    /* renamed from: b */
    private SSLSocket f8157b;

    /* renamed from: c */
    private Context f8158c;

    /* renamed from: d */
    private String[] f8159d;

    /* renamed from: e */
    private X509TrustManager f8160e;

    /* renamed from: f */
    private String[] f8161f;

    /* renamed from: g */
    private String[] f8162g;

    /* renamed from: h */
    private String[] f8163h;

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f8156a = null;
        this.f8157b = null;
        this.f8156a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8156a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    @Deprecated
    /* renamed from: a */
    static void m7916a(X509TrustManager x509TrustManager) {
        C2563e.m7987c(f8154i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8155j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8154i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C2563e.m7986b(f8154i, "NoSuchAlgorithmException");
        }
        C2563e.m7984a(f8154i, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f8155j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f8155j == null) {
                    f8155j = new SecureSSLSocketFactory(context, (SecureRandom) null);
                }
            }
        }
        if (f8155j.f8158c == null && context != null) {
            f8155j.setContext(context);
        }
        C2563e.m7984a(f8154i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f8155j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        C2563e.m7987c(f8154i, "createSocket: host , port");
        Socket createSocket = this.f8156a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            m7915a(createSocket);
            this.f8157b = (SSLSocket) createSocket;
            this.f8159d = (String[]) this.f8157b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f8161f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f8160e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f8158c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f8163h;
    }

    public SSLContext getSslContext() {
        return this.f8156a;
    }

    public SSLSocket getSslSocket() {
        return this.f8157b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f8159d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f8162g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f8160e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f8161f = strArr;
    }

    public void setContext(Context context) {
        this.f8158c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f8163h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f8156a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f8162g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f8160e = x509TrustManager;
    }

    /* renamed from: a */
    static void m7917a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C2563e.m7987c(f8154i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8155j = new SecureSSLSocketFactory(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8154i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C2563e.m7986b(f8154i, "NoSuchAlgorithmException");
        }
        C2563e.m7984a(f8154i, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f8156a = null;
        this.f8157b = null;
        this.f8156a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8156a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        C2563e.m7987c(f8154i, "createSocket s host port autoClose");
        Socket createSocket = this.f8156a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            m7915a(createSocket);
            this.f8157b = (SSLSocket) createSocket;
            this.f8159d = (String[]) this.f8157b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureSSLSocketFactory getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f8155j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f8155j == null) {
                    f8155j = new SecureSSLSocketFactory(context, secureRandom);
                }
            }
        }
        if (f8155j.f8158c == null && context != null) {
            f8155j.setContext(context);
        }
        C2563e.m7984a(f8154i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f8155j;
    }

    /* renamed from: a */
    private void m7915a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (C2559a.m7955a(this.f8163h)) {
            z = false;
        } else {
            C2563e.m7987c(f8154i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f8163h);
            z = true;
        }
        if (C2559a.m7955a(this.f8162g) && C2559a.m7955a(this.f8161f)) {
            z2 = false;
        } else {
            C2563e.m7987c(f8154i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C2559a.m7955a(this.f8162g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f8162g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f8161f);
            }
        }
        if (!z) {
            C2563e.m7987c(f8154i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C2563e.m7987c(f8154i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    private SecureSSLSocketFactory(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f8156a = null;
        this.f8157b = null;
        if (context == null) {
            C2563e.m7986b(f8154i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f8160e = SecureX509SingleInstance.getInstance(context);
        this.f8156a.init(null, new X509TrustManager[]{this.f8160e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8156a = null;
        this.f8157b = null;
        this.f8156a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8156a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8156a = null;
        this.f8157b = null;
        this.f8156a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8156a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
