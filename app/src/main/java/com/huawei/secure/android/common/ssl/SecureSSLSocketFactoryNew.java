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

/* JADX INFO: loaded from: classes.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* JADX INFO: renamed from: i */
    private static final String f5160i = "SSLFNew";

    /* JADX INFO: renamed from: j */
    private static volatile SecureSSLSocketFactoryNew f5161j;
    protected SSLContext a;

    /* JADX INFO: renamed from: b */
    protected SSLSocket f5162b;

    /* JADX INFO: renamed from: c */
    protected Context f5163c;

    /* JADX INFO: renamed from: d */
    protected String[] f5164d;

    /* JADX INFO: renamed from: e */
    protected X509TrustManager f5165e;

    /* JADX INFO: renamed from: f */
    protected String[] f5166f;

    /* JADX INFO: renamed from: g */
    protected String[] f5167g;

    /* JADX INFO: renamed from: h */
    protected String[] f5168h;

    @Deprecated
    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = null;
        this.f5162b = null;
        this.a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5168h)) {
            z = false;
        } else {
            e.c(f5160i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f5168h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f5167g) && com.huawei.secure.android.common.ssl.util.a.a(this.f5166f)) {
            z2 = false;
        } else {
            e.c(f5160i, "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.a.a(this.f5167g)) {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f5166f);
            } else {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f5167g);
            }
        }
        if (!z) {
            e.c(f5160i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c(f5160i, "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Deprecated
    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f5161j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f5161j == null) {
                    f5161j = new SecureSSLSocketFactoryNew(context, (SecureRandom) null);
                }
            }
        }
        if (f5161j.f5163c == null && context != null) {
            f5161j.setContext(context);
        }
        e.a(f5160i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f5161j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.c(f5160i, "createSocket: host , port");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5162b = (SSLSocket) socketCreateSocket;
            this.f5164d = (String[]) this.f5162b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public String[] getBlackCiphers() {
        return this.f5166f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f5165e;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public Context getContext() {
        return this.f5163c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f5168h;
    }

    public SSLContext getSslContext() {
        return this.a;
    }

    public SSLSocket getSslSocket() {
        return this.f5162b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f5164d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f5167g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f5165e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f5166f = strArr;
    }

    public void setContext(Context context) {
        this.f5163c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f5168h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f5167g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f5165e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = null;
        this.f5162b = null;
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
        e.c(f5160i, "createSocket");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            this.f5162b = (SSLSocket) socketCreateSocket;
            this.f5164d = (String[]) this.f5162b.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context, SecureRandom secureRandom) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContextUtil.setContext(context);
        if (f5161j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f5161j == null) {
                    f5161j = new SecureSSLSocketFactoryNew(context, secureRandom);
                }
            }
        }
        if (f5161j.f5163c == null && context != null) {
            f5161j.setContext(context);
        }
        e.a(f5160i, "getInstance: cost : " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return f5161j;
    }

    private SecureSSLSocketFactoryNew(Context context, SecureRandom secureRandom) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException {
        this.a = null;
        this.f5162b = null;
        if (context == null) {
            e.b(f5160i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        this.f5165e = SecureX509SingleInstance.getInstance(context);
        this.a.init(null, new X509TrustManager[]{this.f5165e}, secureRandom);
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5162b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.f5162b = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, secureRandom);
    }
}
