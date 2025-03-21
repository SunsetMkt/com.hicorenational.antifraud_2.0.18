package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import anet.channel.util.HttpConstant;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.AbstractC2562d;
import com.huawei.secure.android.common.ssl.util.C2563e;
import com.taobao.accs.common.Constants;
import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes.dex */
public class WebViewSSLCheckThread extends Thread {

    /* renamed from: i */
    private static final String f8185i = WebViewSSLCheckThread.class.getSimpleName();

    /* renamed from: a */
    private SSLSocketFactory f8186a;

    /* renamed from: b */
    private HostnameVerifier f8187b;

    /* renamed from: c */
    private org.apache.http.conn.ssl.SSLSocketFactory f8188c;

    /* renamed from: d */
    private X509HostnameVerifier f8189d;

    /* renamed from: e */
    private SslErrorHandler f8190e;

    /* renamed from: f */
    private String f8191f;

    /* renamed from: g */
    private Callback f8192g;

    /* renamed from: h */
    private Context f8193h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* renamed from: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread$a */
    static class C2553a implements okhttp3.Callback {

        /* renamed from: a */
        final /* synthetic */ Callback f8194a;

        /* renamed from: b */
        final /* synthetic */ Context f8195b;

        /* renamed from: c */
        final /* synthetic */ String f8196c;

        /* renamed from: d */
        final /* synthetic */ SslErrorHandler f8197d;

        C2553a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f8194a = callback;
            this.f8195b = context;
            this.f8196c = str;
            this.f8197d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            C2563e.m7986b(WebViewSSLCheckThread.f8185i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f8194a;
            if (callback != null) {
                callback.onCancel(this.f8195b, this.f8196c);
            } else {
                this.f8197d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            C2563e.m7986b(WebViewSSLCheckThread.f8185i, "onResponse . proceed");
            Callback callback = this.f8194a;
            if (callback != null) {
                callback.onProceed(this.f8195b, this.f8196c);
            } else {
                this.f8197d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    /* renamed from: b */
    private void m7924b() {
        C2563e.m7987c(f8185i, "callbackCancel: ");
        Callback callback = this.f8192g;
        if (callback != null) {
            callback.onCancel(this.f8193h, this.f8191f);
        } else if (this.f8190e != null) {
            C2563e.m7987c(f8185i, "callbackCancel 2: ");
            this.f8190e.cancel();
        }
    }

    /* renamed from: c */
    private void m7925c() {
        C2563e.m7987c(f8185i, "callbackProceed: ");
        Callback callback = this.f8192g;
        if (callback != null) {
            callback.onProceed(this.f8193h, this.f8191f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f8190e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f8189d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f8188c;
    }

    public Callback getCallback() {
        return this.f8192g;
    }

    public Context getContext() {
        return this.f8193h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f8187b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f8190e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f8186a;
    }

    public String getUrl() {
        return this.f8191f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Exception e2;
        HttpsURLConnection httpsURLConnection;
        super.run();
        if (this.f8188c != null && this.f8189d != null) {
            if (this.f8190e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f8191f)) {
                        try {
                            this.f8188c.setHostnameVerifier(this.f8189d);
                            if (this.f8188c instanceof SecureApacheSSLSocketFactory) {
                                ((SecureApacheSSLSocketFactory) this.f8188c).setContext(this.f8193h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme(HttpConstant.HTTPS, this.f8188c, Constants.PORT));
                            schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f8191f));
                            HttpResponse execute = defaultHttpClient.execute(httpGet);
                            C2563e.m7987c(f8185i, "status code is : " + execute.getStatusLine().getStatusCode());
                            AbstractC2562d.m7979a((Reader) null);
                            m7925c();
                            return;
                        } catch (Exception e3) {
                            C2563e.m7986b(f8185i, "run: exception : " + e3.getMessage());
                            m7924b();
                            AbstractC2562d.m7979a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    AbstractC2562d.m7979a((Reader) null);
                    throw th;
                }
            }
            C2563e.m7986b(f8185i, "sslErrorHandler or url is null");
            m7924b();
            return;
        }
        if (this.f8186a != null) {
            HttpsURLConnection httpsURLConnection2 = this.f8187b;
            try {
                if (httpsURLConnection2 != 0) {
                    try {
                        URLConnection openConnection = new URL(this.f8191f).openConnection();
                        if (openConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) openConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.f8186a);
                                httpsURLConnection.setHostnameVerifier(this.f8187b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.connect();
                            } catch (Exception e4) {
                                e2 = e4;
                                C2563e.m7986b(f8185i, "exception : " + e2.getMessage());
                                m7924b();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        } else {
                            httpsURLConnection = null;
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        m7925c();
                        return;
                    } catch (Exception e5) {
                        e2 = e5;
                        httpsURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection2 = 0;
                        if (httpsURLConnection2 != 0) {
                            httpsURLConnection2.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        m7924b();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f8189d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f8188c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f8192g = callback;
    }

    public void setContext(Context context) {
        this.f8193h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f8187b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f8190e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f8186a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f8191f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new C2556c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new C2556c(context)));
        } catch (UnrecoverableKeyException e2) {
            C2563e.m7986b(f8185i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e2.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            C2563e.m7986b(f8185i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new C2556c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new C2556c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new C2553a(callback, context, str, sslErrorHandler));
        } catch (Exception e2) {
            C2563e.m7986b(f8185i, "checkServerCertificateWithOK: exception : " + e2.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f8190e = sslErrorHandler;
        this.f8191f = str;
        this.f8188c = sSLSocketFactory;
        this.f8189d = x509HostnameVerifier;
        this.f8192g = callback;
        this.f8193h = context;
    }
}
