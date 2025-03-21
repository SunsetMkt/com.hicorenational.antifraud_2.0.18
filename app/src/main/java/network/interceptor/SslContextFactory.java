package network.interceptor;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import util.C7301n1;

/* loaded from: classes2.dex */
public class SslContextFactory {
    private static final String CLIENT_AGREEMENT = "TLS";
    private static final String CLIENT_TRUST_KEYSTORE = "BKS";
    private static final String CLIENT_TRUST_MANAGER = "X509";
    private static final String CLIENT_TRUST_PASSWORD = "storepassword123";

    public SSLSocketFactory getSslSocket(Context context) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(CLIENT_AGREEMENT);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(CLIENT_TRUST_MANAGER);
            KeyStore keyStore = KeyStore.getInstance(CLIENT_TRUST_KEYSTORE);
            InputStream open = context.getAssets().open("fzlm.bks");
            try {
                keyStore.load(open, CLIENT_TRUST_PASSWORD.toCharArray());
                open.close();
                trustManagerFactory.init(keyStore);
                sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
                return sSLContext.getSocketFactory();
            } catch (Throwable th) {
                open.close();
                throw th;
            }
        } catch (Exception e2) {
            C7301n1.m26457b("SslContextFactory", e2.getMessage());
            return (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
    }
}
