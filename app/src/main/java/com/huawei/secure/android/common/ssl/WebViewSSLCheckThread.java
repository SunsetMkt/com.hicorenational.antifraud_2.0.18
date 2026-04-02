package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import anet.channel.util.HttpConstant;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.d;
import com.huawei.secure.android.common.ssl.util.e;
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

/* JADX INFO: loaded from: classes.dex */
public class WebViewSSLCheckThread extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f5177i = WebViewSSLCheckThread.class.getSimpleName();
    private SSLSocketFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HostnameVerifier f5178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f5179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f5180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SslErrorHandler f5181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Callback f5183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f5184h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    static class a implements okhttp3.Callback {
        final /* synthetic */ Callback a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f5186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f5187d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.a = callback;
            this.f5185b = context;
            this.f5186c = str;
            this.f5187d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            e.b(WebViewSSLCheckThread.f5177i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.a;
            if (callback != null) {
                callback.onCancel(this.f5185b, this.f5186c);
            } else {
                this.f5187d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            e.b(WebViewSSLCheckThread.f5177i, "onResponse . proceed");
            Callback callback = this.a;
            if (callback != null) {
                callback.onProceed(this.f5185b, this.f5186c);
            } else {
                this.f5187d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        e.c(f5177i, "callbackCancel: ");
        Callback callback = this.f5183g;
        if (callback != null) {
            callback.onCancel(this.f5184h, this.f5182f);
        } else if (this.f5181e != null) {
            e.c(f5177i, "callbackCancel 2: ");
            this.f5181e.cancel();
        }
    }

    private void c() {
        e.c(f5177i, "callbackProceed: ");
        Callback callback = this.f5183g;
        if (callback != null) {
            callback.onProceed(this.f5184h, this.f5182f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f5181e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f5180d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f5179c;
    }

    public Callback getCallback() {
        return this.f5183g;
    }

    public Context getContext() {
        return this.f5184h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f5178b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f5181e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.a;
    }

    public String getUrl() {
        return this.f5182f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        Exception e2;
        HttpsURLConnection httpsURLConnection;
        super.run();
        if (this.f5179c != null && this.f5180d != null) {
            if (this.f5181e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f5182f)) {
                        try {
                            this.f5179c.setHostnameVerifier(this.f5180d);
                            if (this.f5179c instanceof SecureApacheSSLSocketFactory) {
                                ((SecureApacheSSLSocketFactory) this.f5179c).setContext(this.f5184h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme(HttpConstant.HTTPS, this.f5179c, Constants.PORT));
                            schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f5182f));
                            HttpResponse httpResponseExecute = defaultHttpClient.execute(httpGet);
                            e.c(f5177i, "status code is : " + httpResponseExecute.getStatusLine().getStatusCode());
                            d.a((Reader) null);
                            c();
                            return;
                        } catch (Exception e3) {
                            e.b(f5177i, "run: exception : " + e3.getMessage());
                            b();
                            d.a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    d.a((Reader) null);
                    throw th;
                }
            }
            e.b(f5177i, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.a != null) {
            HttpsURLConnection httpsURLConnection2 = this.f5178b;
            try {
                if (httpsURLConnection2 != 0) {
                    try {
                        URLConnection uRLConnectionOpenConnection = new URL(this.f5182f).openConnection();
                        if (uRLConnectionOpenConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.a);
                                httpsURLConnection.setHostnameVerifier(this.f5178b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.connect();
                            } catch (Exception e4) {
                                e2 = e4;
                                e.b(f5177i, "exception : " + e2.getMessage());
                                b();
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
                        c();
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
        b();
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f5180d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f5179c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f5183g = callback;
    }

    public void setContext(Context context) {
        this.f5184h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f5178b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f5181e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f5182f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyManagementException, KeyStoreException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory(null, new c(context)));
        } catch (UnrecoverableKeyException e2) {
            e.b(f5177i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e2.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            e.b(f5177i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e2) {
            e.b(f5177i, "checkServerCertificateWithOK: exception : " + e2.getMessage());
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
        this.f5181e = sslErrorHandler;
        this.f5182f = str;
        this.f5179c = sSLSocketFactory;
        this.f5180d = x509HostnameVerifier;
        this.f5183g = callback;
        this.f5184h = context;
    }
}
