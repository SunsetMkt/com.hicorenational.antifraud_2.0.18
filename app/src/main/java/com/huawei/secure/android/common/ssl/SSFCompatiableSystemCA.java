package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.C2559a;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import java.io.IOException;
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

/* loaded from: classes.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f8124i = SSFCompatiableSystemCA.class.getSimpleName();

    /* renamed from: j */
    private static volatile SSFCompatiableSystemCA f8125j = null;

    /* renamed from: a */
    private SSLContext f8126a;

    /* renamed from: b */
    private SSLSocket f8127b;

    /* renamed from: c */
    private Context f8128c;

    /* renamed from: d */
    private String[] f8129d;

    /* renamed from: e */
    private X509TrustManager f8130e;

    /* renamed from: f */
    private String[] f8131f;

    /* renamed from: g */
    private String[] f8132g;

    /* renamed from: h */
    private String[] f8133h;

    private SSFCompatiableSystemCA(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f8126a = null;
        this.f8127b = null;
        if (context == null) {
            C2563e.m7986b(f8124i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f8130e = SSFSecureX509SingleInstance.getInstance(context);
        this.f8126a.init(null, new X509TrustManager[]{this.f8130e}, secureRandom);
    }

    @Deprecated
    /* renamed from: a */
    static void m7910a(X509TrustManager x509TrustManager) {
        C2563e.m7987c(f8124i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8125j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8124i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C2563e.m7986b(f8124i, "NoSuchAlgorithmException");
        }
        C2563e.m7984a(f8124i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Deprecated
    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8125j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f8125j == null) {
                    f8125j = new SSFCompatiableSystemCA(context, (SecureRandom) null);
                }
            }
        }
        if (f8125j.f8128c == null && context != null) {
            f8125j.setContext(context);
        }
        return f8125j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        C2563e.m7987c(f8124i, "createSocket: host , port");
        Socket createSocket = this.f8126a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            m7909a(createSocket);
            this.f8127b = (SSLSocket) createSocket;
            this.f8129d = (String[]) this.f8127b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f8131f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f8130e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f8128c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f8133h;
    }

    public SSLContext getSslContext() {
        return this.f8126a;
    }

    public SSLSocket getSslSocket() {
        return this.f8127b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f8129d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f8132g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f8130e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f8131f = strArr;
    }

    public void setContext(Context context) {
        this.f8128c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f8133h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f8126a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f8132g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f8130e = x509TrustManager;
    }

    /* renamed from: a */
    static void m7911a(X509TrustManager x509TrustManager, SecureRandom secureRandom) {
        C2563e.m7987c(f8124i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f8125j = new SSFCompatiableSystemCA(x509TrustManager, secureRandom);
        } catch (KeyManagementException unused) {
            C2563e.m7986b(f8124i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            C2563e.m7986b(f8124i, "NoSuchAlgorithmException");
        }
        C2563e.m7984a(f8124i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return createSocket(str, i2);
    }

    @Deprecated
    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8126a = null;
        this.f8127b = null;
        this.f8126a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8126a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public static SSFCompatiableSystemCA getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        ContextUtil.setContext(context);
        if (f8125j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f8125j == null) {
                    f8125j = new SSFCompatiableSystemCA(context, secureRandom);
                }
            }
        }
        if (f8125j.f8128c == null && context != null) {
            f8125j.setContext(context);
        }
        return f8125j;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        C2563e.m7987c(f8124i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f8126a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            m7909a(createSocket);
            this.f8127b = (SSLSocket) createSocket;
            this.f8129d = (String[]) this.f8127b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    /* renamed from: a */
    private void m7909a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (C2559a.m7955a(this.f8133h)) {
            z = false;
        } else {
            C2563e.m7987c(f8124i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f8133h);
            z = true;
        }
        if (C2559a.m7955a(this.f8132g) && C2559a.m7955a(this.f8131f)) {
            z2 = false;
        } else {
            C2563e.m7987c(f8124i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!C2559a.m7955a(this.f8132g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f8132g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f8131f);
            }
        }
        if (!z) {
            C2563e.m7987c(f8124i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C2563e.m7987c(f8124i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8126a = null;
        this.f8127b = null;
        this.f8126a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8126a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
