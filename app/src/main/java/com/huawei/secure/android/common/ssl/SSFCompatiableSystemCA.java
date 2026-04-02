package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
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

/* JADX INFO: loaded from: classes.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* JADX INFO: renamed from: i */
    private static final String f5125i = SSFCompatiableSystemCA.class.getSimpleName();

    /* JADX INFO: renamed from: j */
    private static volatile SSFCompatiableSystemCA f5126j = null;
    private SSLContext a;

    /* JADX INFO: renamed from: b */
    private SSLSocket f5127b;

    /* JADX INFO: renamed from: c */
    private Context f5128c;

    /* JADX INFO: renamed from: d */
    private String[] f5129d;

    /* JADX INFO: renamed from: e */
    private X509TrustManager f5130e;

    /* JADX INFO: renamed from: f */
    private String[] f5131f;

    /* JADX INFO: renamed from: g */
    private String[] f5132g;

    /* JADX INFO: renamed from: h */
    private String[] f5133h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.a = null;
        this.f5127b = null;
        if (context == null) {
            e.b(f5125i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f5130e = SSFSecureX509SingleInstance.getInstance(context);
        this.a.init(null, new X509TrustManager[]{this.f5130e}, secureRandom);
    }

    @Deprecated
    static void a(X509TrustManager x509TrustManager) {
        e.c(f5125i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5126j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.b(f5125i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f5125i, "NoSuchAlgorithmException");
        }
        e.a(f5125i, "SSF system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5126j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f5126j == null) {
                    f5126j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                }
            }
        }
        if (f5126j.f5128c == null && context != null) {
            f5126j.setContext(context);
        }
        return f5126j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f5125i, "createSocket: host , port");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5127b = (SSLSocket) socketCreateSocket;
            this.f5129d = (String[]) this.f5127b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f5131f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f5130e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f5128c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f5133h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.f5127b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f5129d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f5132g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f5130e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f5131f = strArr;
    }

    public void setContext(Context context) {
        this.f5128c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f5133h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f5132g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f5130e = x509TrustManager;
    }

    static void a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        e.c(f5125i, "ssfc update socket factory trust manager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            f5126j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            e.b(f5125i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.b(f5125i, "NoSuchAlgorithmException");
        }
        e.a(f5125i, "SSF system ca update: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return createSocket(str, i2);
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5127b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f5126j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f5126j == null) {
                    f5126j = new SSFCompatiableSystemCA(context, secureRandom);
                }
            }
        }
        if (f5126j.f5128c == null && context != null) {
            f5126j.setContext(context);
        }
        return f5126j;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.c(f5125i, "createSocket: s , host , port , autoClose");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5127b = (SSLSocket) socketCreateSocket;
            this.f5129d = (String[]) this.f5127b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5133h)) {
            z = false;
        } else {
            e.c(f5125i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f5133h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5132g) && com.huawei.secure.android.common.ssl.util.a.a(this.f5131f)) {
            z2 = false;
        } else {
            e.c(f5125i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f5132g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f5132g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f5131f);
            }
        }
        if (!z) {
            e.c(f5125i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f5125i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5127b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
