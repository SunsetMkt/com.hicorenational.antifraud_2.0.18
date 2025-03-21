package anet.channel.session;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.c */
/* loaded from: classes.dex */
final class C0812c implements HostnameVerifier {

    /* renamed from: a */
    final /* synthetic */ String f986a;

    C0812c(String str) {
        this.f986a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f986a, sSLSession);
    }
}
