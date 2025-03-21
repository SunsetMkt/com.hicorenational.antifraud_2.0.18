package com.tencent.open.p211a;

import com.tencent.open.log.SLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.h */
/* loaded from: classes2.dex */
public class C3257h extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f11157a;

    /* renamed from: b */
    private TrustManager[] f11158b;

    public C3257h() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        this.f11158b = m10426b();
        sSLContext.init(null, this.f11158b, null);
        this.f11157a = sSLContext.getSocketFactory();
    }

    /* renamed from: b */
    private TrustManager[] m10426b() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return trustManagers;
            }
            SLog.m10500e("openSDK_LOG.Tls2SupportedSocketFactory", "Unexpected default trust managers: " + Arrays.toString(trustManagers));
            return null;
        } catch (GeneralSecurityException unused) {
            SLog.m10500e("openSDK_LOG.Tls2SupportedSocketFactory", "The system has no TLS. Just give up.");
            return null;
        }
    }

    /* renamed from: a */
    public TrustManager m10427a() {
        TrustManager[] trustManagerArr = this.f11158b;
        if (trustManagerArr == null || trustManagerArr.length <= 0) {
            return null;
        }
        return trustManagerArr[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return m10425a(this.f11157a.createSocket(str, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f11157a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f11157a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return m10425a(this.f11157a.createSocket(str, i2, inetAddress, i3));
    }

    /* renamed from: a */
    private Socket m10425a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return m10425a(this.f11157a.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return m10425a(this.f11157a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return m10425a(this.f11157a.createSocket(socket, str, i2, z));
    }
}
