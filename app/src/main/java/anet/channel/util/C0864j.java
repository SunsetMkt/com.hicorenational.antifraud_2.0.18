package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.j */
/* loaded from: classes.dex */
public class C0864j extends SSLSocketFactory {

    /* renamed from: a */
    private final String f1189a = "awcn.TlsSniSocketFactory";

    /* renamed from: b */
    private Method f1190b = null;

    /* renamed from: c */
    private String f1191c;

    public C0864j(String str) {
        this.f1191c = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
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
        if (this.f1191c == null) {
            this.f1191c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.m716i("awcn.TlsSniSocketFactory", "customized createSocket", null, Constants.KEY_HOST, this.f1191c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f1191c);
        } else {
            try {
                if (this.f1190b == null) {
                    this.f1190b = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f1190b.setAccessible(true);
                }
                this.f1190b.invoke(sSLSocket, this.f1191c);
            } catch (Exception e2) {
                ALog.m717w("awcn.TlsSniSocketFactory", "SNI not useable", null, e2, new Object[0]);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.m713d("awcn.TlsSniSocketFactory", null, null, "SSLSession PeerHost", session.getPeerHost());
        }
        return sSLSocket;
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
