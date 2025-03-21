package com.umeng.p221ut.p222a.p224b;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.p221ut.p222a.p225c.C3810e;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.umeng.ut.a.b.e */
/* loaded from: classes2.dex */
class C3803e extends SSLSocketFactory {

    /* renamed from: b */
    private String f13865b;

    /* renamed from: a */
    private Method f13864a = null;
    private HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public C3803e(String str) {
        this.f13865b = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        SSLSocket sSLSocket;
        C3810e.m12787b("", "peerHost", this.f13865b, Constants.KEY_HOST, str, "port", Integer.valueOf(i2), "autoClose", Boolean.valueOf(z));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        if (Build.VERSION.SDK_INT < 24) {
            sSLCertificateSocketFactory.setTrustManagers(C3804f.getTrustManagers());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(C3801c.getTrustManagers());
        }
        C3810e.m12784a("", "createSocket");
        if (Build.VERSION.SDK_INT < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f13865b, i2, true);
        }
        C3810e.m12784a("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f13865b);
        } else {
            try {
                if (this.f13864a == null) {
                    this.f13864a = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f13864a.setAccessible(true);
                }
                this.f13864a.invoke(sSLSocket, this.f13865b);
            } catch (Exception e2) {
                C3810e.m12784a("", "SNI not useable", e2);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (this.hostnameVerifier.verify(this.f13865b, session)) {
            C3810e.m12787b("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f13865b);
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f13865b) || !(obj instanceof C3803e)) {
            return false;
        }
        String str = ((C3803e) obj).f13865b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f13865b.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
