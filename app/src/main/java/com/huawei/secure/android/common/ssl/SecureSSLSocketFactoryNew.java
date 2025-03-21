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

/* loaded from: classes.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* renamed from: i */
    private static final String f8164i = "SSLFNew";

    /* renamed from: j */
    private static volatile SecureSSLSocketFactoryNew f8165j;

    /* renamed from: a */
    protected SSLContext f8166a;

    /* renamed from: b */
    protected SSLSocket f8167b;

    /* renamed from: c */
    protected Context f8168c;

    /* renamed from: d */
    protected String[] f8169d;

    /* renamed from: e */
    protected X509TrustManager f8170e;

    /* renamed from: f */
    protected String[] f8171f;

    /* renamed from: g */
    protected String[] f8172g;

    /* renamed from: h */
    protected String[] f8173h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f8166a = null;
        this.f8167b = null;
        this.f8166a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8166a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    /* renamed from: a */
    private void m7918a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (C2559a.m7955a(this.f8173h)) {
            z = false;
        } else {
            C2563e.m7987c(f8164i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f8173h);
            z = true;
        }
        if (C2559a.m7955a(this.f8172g) && C2559a.m7955a(this.f8171f)) {
            z2 = false;
        } else {
            C2563e.m7987c(f8164i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (C2559a.m7955a(this.f8172g)) {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f8171f);
            } else {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f8172g);
            }
        }
        if (!z) {
            C2563e.m7987c(f8164i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        C2563e.m7987c(f8164i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f8165j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f8165j == null) {
                    f8165j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                }
            }
        }
        if (f8165j.f8168c == null && context != null) {
            f8165j.setContext(context);
        }
        C2563e.m7984a(f8164i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f8165j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        C2563e.m7987c(f8164i, "createSocket: host , port");
        Socket createSocket = this.f8166a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            m7918a(createSocket);
            this.f8167b = (SSLSocket) createSocket;
            this.f8169d = (String[]) this.f8167b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f8171f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f8170e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f8168c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f8173h;
    }

    public SSLContext getSslContext() {
        return this.f8166a;
    }

    public SSLSocket getSslSocket() {
        return this.f8167b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f8169d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f8172g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f8170e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f8171f = strArr;
    }

    public void setContext(Context context) {
        this.f8168c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f8173h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f8166a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f8172g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f8170e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f8166a = null;
        this.f8167b = null;
        this.f8166a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f8166a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, secureRandom);
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
        C2563e.m7987c(f8164i, "createSocket");
        Socket createSocket = this.f8166a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            m7918a(createSocket);
            this.f8167b = (SSLSocket) createSocket;
            this.f8169d = (String[]) this.f8167b.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f8165j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f8165j == null) {
                    f8165j = new SecureSSLSocketFactoryNew(context, secureRandom);
                }
            }
        }
        if (f8165j.f8168c == null && context != null) {
            f8165j.setContext(context);
        }
        C2563e.m7984a(f8164i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f8165j;
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f8166a = null;
        this.f8167b = null;
        if (context == null) {
            C2563e.m7986b(f8164i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f8170e = SecureX509SingleInstance.getInstance(context);
        this.f8166a.init(null, new X509TrustManager[]{this.f8170e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8166a = null;
        this.f8167b = null;
        this.f8166a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8166a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f8166a = null;
        this.f8167b = null;
        this.f8166a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f8166a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
