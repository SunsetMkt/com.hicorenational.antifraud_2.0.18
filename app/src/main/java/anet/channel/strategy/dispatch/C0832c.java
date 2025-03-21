package anet.channel.strategy.dispatch;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.dispatch.c */
/* loaded from: classes.dex */
final class C0832c implements HostnameVerifier {
    C0832c() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(DispatchConstants.getAmdcServerDomain(), sSLSession);
    }
}
