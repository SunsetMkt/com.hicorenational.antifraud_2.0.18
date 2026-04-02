package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.c;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f1535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f1536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1538e;
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0347 A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #8 {all -> 0x0273, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0176, B:33:0x018a, B:35:0x01ae, B:37:0x01b4, B:39:0x01ba, B:41:0x01c0, B:44:0x01c7, B:46:0x01e6, B:48:0x01f6, B:49:0x01fd, B:53:0x021a, B:55:0x0231, B:57:0x024c, B:51:0x020b, B:52:0x0212, B:108:0x031c, B:110:0x0347, B:120:0x0384, B:122:0x03af, B:75:0x0279, B:77:0x027f, B:78:0x0283, B:80:0x028b, B:82:0x029f, B:81:0x029a, B:90:0x02c0, B:98:0x02f5, B:130:0x03e9, B:138:0x0411, B:146:0x0437, B:154:0x045d), top: B:177:0x0032, inners: #12, #15, #19, #21, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03af A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #8 {all -> 0x0273, blocks: (B:12:0x0032, B:14:0x003c, B:15:0x0083, B:17:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:32:0x0176, B:33:0x018a, B:35:0x01ae, B:37:0x01b4, B:39:0x01ba, B:41:0x01c0, B:44:0x01c7, B:46:0x01e6, B:48:0x01f6, B:49:0x01fd, B:53:0x021a, B:55:0x0231, B:57:0x024c, B:51:0x020b, B:52:0x0212, B:108:0x031c, B:110:0x0347, B:120:0x0384, B:122:0x03af, B:75:0x0279, B:77:0x027f, B:78:0x0283, B:80:0x028b, B:82:0x029f, B:81:0x029a, B:90:0x02c0, B:98:0x02f5, B:130:0x03e9, B:138:0x0411, B:146:0x0437, B:154:0x045d), top: B:177:0x0032, inners: #12, #15, #19, #21, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x036d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(Request request, RequestCb requestCb) {
        String str;
        String str2;
        String str3;
        String singleHeaderFieldByKey;
        String str4 = "hostnameVerifier";
        String str5 = "sslSocketFactory";
        String str6 = "SSL Error Info.";
        a aVar = new a();
        Throwable th = null;
        if (request == null || request.getUrl() == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), new RequestStatistic(null, null));
            }
            return aVar;
        }
        Request requestBuild = request;
        HttpURLConnection httpURLConnectionA = null;
        while (NetworkStatusHelper.isConnected()) {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            httpURLConnectionA = a(requestBuild);
                                            if (ALog.isPrintLog(2)) {
                                                ALog.i("awcn.HttpConnector", "", requestBuild.getSeq(), "request URL", httpURLConnectionA.getURL().toString());
                                                ALog.i("awcn.HttpConnector", "", requestBuild.getSeq(), "request Method", httpURLConnectionA.getRequestMethod());
                                                ALog.i("awcn.HttpConnector", "", requestBuild.getSeq(), "request headers", httpURLConnectionA.getRequestProperties().toString());
                                            }
                                            requestBuild.a.sendStart = System.currentTimeMillis();
                                            str = str4;
                                            str2 = str5;
                                        } catch (SSLHandshakeException e2) {
                                            e = e2;
                                            str = str4;
                                            str2 = str5;
                                        } catch (SSLException e3) {
                                            e = e3;
                                            str = str4;
                                            str2 = str5;
                                        }
                                        try {
                                            requestBuild.a.processTime = requestBuild.a.sendStart - requestBuild.a.start;
                                            httpURLConnectionA.connect();
                                            a(httpURLConnectionA, requestBuild);
                                            requestBuild.a.sendEnd = System.currentTimeMillis();
                                            str3 = str6;
                                        } catch (SSLHandshakeException e4) {
                                            e = e4;
                                            str3 = str6;
                                            SSLHandshakeException sSLHandshakeException = e;
                                            c.a.a.b(requestBuild.getHost());
                                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException);
                                            ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), sSLHandshakeException);
                                            if (httpURLConnectionA instanceof HttpsURLConnection) {
                                            }
                                            if (httpURLConnectionA != null) {
                                            }
                                            return aVar;
                                        } catch (SSLException e5) {
                                            e = e5;
                                            str3 = str6;
                                            SSLException sSLException = e;
                                            c.a.a.b(requestBuild.getHost());
                                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLException);
                                            ALog.e("awcn.HttpConnector", "connect SSLException", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), sSLException);
                                            if (httpURLConnectionA instanceof HttpsURLConnection) {
                                            }
                                            if (httpURLConnectionA != null) {
                                            }
                                            return aVar;
                                        }
                                        try {
                                            requestBuild.a.sendDataTime = requestBuild.a.sendEnd - requestBuild.a.sendStart;
                                            aVar.a = httpURLConnectionA.getResponseCode();
                                            aVar.f1536c = HttpHelper.cloneMap(httpURLConnectionA.getHeaderFields());
                                            ALog.i("awcn.HttpConnector", "", requestBuild.getSeq(), "response code", Integer.valueOf(aVar.a));
                                            ALog.i("awcn.HttpConnector", "", requestBuild.getSeq(), "response headers", aVar.f1536c);
                                            if (HttpHelper.checkRedirect(requestBuild, aVar.a) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(aVar.f1536c, "Location")) != null) {
                                                HttpUrl httpUrl = HttpUrl.parse(singleHeaderFieldByKey);
                                                if (httpUrl != null) {
                                                    ALog.i("awcn.HttpConnector", "redirect", requestBuild.getSeq(), "to url", httpUrl.toString());
                                                    requestBuild = requestBuild.newBuilder().setMethod("GET").setBody(null).setUrl(httpUrl).setRedirectTimes(requestBuild.getRedirectTimes() + 1).setSslSocketFactory(null).setHostnameVerifier(null).build();
                                                    requestBuild.a.recordRedirect(aVar.a, httpUrl.simpleUrlString());
                                                    requestBuild.a.locationUrl = singleHeaderFieldByKey;
                                                    if (httpURLConnectionA != null) {
                                                        try {
                                                            httpURLConnectionA.disconnect();
                                                        } catch (Exception e6) {
                                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e6, new Object[0]);
                                                        }
                                                    }
                                                    str6 = str3;
                                                    str4 = str;
                                                    str5 = str2;
                                                    th = null;
                                                } else {
                                                    ALog.e("awcn.HttpConnector", "redirect url is invalid!", requestBuild.getSeq(), "redirect url", singleHeaderFieldByKey);
                                                }
                                            }
                                            requestBuild.a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(aVar.f1536c, "Content-Encoding");
                                            requestBuild.a.contentType = HttpHelper.getSingleHeaderFieldByKey(aVar.f1536c, "Content-Type");
                                            if (Request.Method.HEAD.equals(requestBuild.getMethod()) || aVar.a == 304 || aVar.a == 204 || (aVar.a >= 100 && aVar.a < 200)) {
                                                if (requestCb != null) {
                                                    requestCb.onResponseCode(aVar.a, aVar.f1536c);
                                                }
                                                requestBuild.a.rspStart = System.currentTimeMillis();
                                            } else {
                                                aVar.f1537d = HttpHelper.parseContentLength(aVar.f1536c);
                                                requestBuild.a.contentLength = aVar.f1537d;
                                                aVar.f1538e = HttpConstant.GZIP.equalsIgnoreCase(requestBuild.a.contentEncoding);
                                                if (aVar.f1538e) {
                                                    aVar.f1536c.remove("Content-Encoding");
                                                    aVar.f1536c.remove("Content-Length");
                                                }
                                                if (requestCb != null) {
                                                    requestCb.onResponseCode(aVar.a, aVar.f1536c);
                                                }
                                                requestBuild.a.rspStart = System.currentTimeMillis();
                                                a(httpURLConnectionA, requestBuild, aVar, requestCb);
                                            }
                                            requestBuild.a.firstDataTime = requestBuild.a.rspStart - requestBuild.a.sendEnd;
                                            if (!requestBuild.a.isDone.get()) {
                                                requestBuild.a.ret = 1;
                                                requestBuild.a.statusCode = aVar.a;
                                                requestBuild.a.msg = HttpConstant.SUCCESS;
                                                requestBuild.a.rspEnd = System.currentTimeMillis();
                                            }
                                            if (requestCb != null) {
                                                requestCb.onFinish(aVar.a, HttpConstant.SUCCESS, requestBuild.a);
                                            }
                                            if (httpURLConnectionA != null) {
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                } catch (Exception e7) {
                                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e7, new Object[0]);
                                                }
                                            }
                                        } catch (SSLHandshakeException e8) {
                                            e = e8;
                                            SSLHandshakeException sSLHandshakeException2 = e;
                                            c.a.a.b(requestBuild.getHost());
                                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLHandshakeException2);
                                            ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), sSLHandshakeException2);
                                            if (httpURLConnectionA instanceof HttpsURLConnection) {
                                                ALog.e("awcn.HttpConnector", str3, requestBuild.getSeq(), str2, ((HttpsURLConnection) httpURLConnectionA).getSSLSocketFactory(), str, ((HttpsURLConnection) httpURLConnectionA).getHostnameVerifier());
                                            }
                                            if (httpURLConnectionA != null) {
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                } catch (Exception e9) {
                                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e9, new Object[0]);
                                                }
                                            }
                                        } catch (SSLException e10) {
                                            e = e10;
                                            SSLException sSLException2 = e;
                                            c.a.a.b(requestBuild.getHost());
                                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_SSL_ERROR, sSLException2);
                                            ALog.e("awcn.HttpConnector", "connect SSLException", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), sSLException2);
                                            if (httpURLConnectionA instanceof HttpsURLConnection) {
                                                ALog.e("awcn.HttpConnector", str3, requestBuild.getSeq(), str2, ((HttpsURLConnection) httpURLConnectionA).getSSLSocketFactory(), str, ((HttpsURLConnection) httpURLConnectionA).getHostnameVerifier());
                                            }
                                            if (httpURLConnectionA != null) {
                                                try {
                                                    httpURLConnectionA.disconnect();
                                                } catch (Exception e11) {
                                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e11, new Object[0]);
                                                }
                                            }
                                        }
                                    } catch (CancellationException e12) {
                                        a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_REQUEST_CANCEL, e12);
                                        ALog.e("awcn.HttpConnector", "HTTP Request Cancel", requestBuild.getSeq(), e12, new Object[0]);
                                        if (httpURLConnectionA != null) {
                                            try {
                                                httpURLConnectionA.disconnect();
                                            } catch (Exception e13) {
                                                ALog.e("awcn.HttpConnector", "http disconnect", null, e13, new Object[0]);
                                            }
                                        }
                                    } catch (Exception e14) {
                                        if ((e14.getMessage() != null ? e14.getMessage() : "").contains("not verified")) {
                                            c.a.a.b(requestBuild.getHost());
                                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR, e14);
                                        } else {
                                            a(requestBuild, aVar, requestCb, -101, e14);
                                        }
                                        ALog.e("awcn.HttpConnector", "HTTP Exception", requestBuild.getSeq(), e14, new Object[0]);
                                        if (httpURLConnectionA != null) {
                                            try {
                                                httpURLConnectionA.disconnect();
                                            } catch (Exception e15) {
                                                ALog.e("awcn.HttpConnector", "http disconnect", null, e15, new Object[0]);
                                            }
                                        }
                                    }
                                } catch (SocketTimeoutException e16) {
                                    a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_SOCKET_TIME_OUT, e16);
                                    ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", requestBuild.getSeq(), e16, new Object[0]);
                                    NetworkStatusHelper.printNetworkDetail();
                                    if (httpURLConnectionA != null) {
                                        try {
                                            httpURLConnectionA.disconnect();
                                        } catch (Exception e17) {
                                            ALog.e("awcn.HttpConnector", "http disconnect", null, e17, new Object[0]);
                                        }
                                    }
                                }
                            } catch (UnknownHostException e18) {
                                a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, e18);
                                ALog.e("awcn.HttpConnector", "Unknown Host Exception", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), e18);
                                NetworkStatusHelper.printNetworkDetail();
                                if (httpURLConnectionA != null) {
                                    try {
                                        httpURLConnectionA.disconnect();
                                    } catch (Exception e19) {
                                        ALog.e("awcn.HttpConnector", "http disconnect", null, e19, new Object[0]);
                                    }
                                }
                            }
                        } catch (ConnectTimeoutException e20) {
                            a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_CONN_TIME_OUT, e20);
                            ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", requestBuild.getSeq(), e20, new Object[0]);
                            NetworkStatusHelper.printNetworkDetail();
                            if (httpURLConnectionA != null) {
                                try {
                                    httpURLConnectionA.disconnect();
                                } catch (Exception e21) {
                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e21, new Object[0]);
                                }
                            }
                        }
                    } catch (IOException e22) {
                        a(requestBuild, aVar, requestCb, -404, e22);
                        ALog.e("awcn.HttpConnector", "IO Exception", requestBuild.getSeq(), Constants.KEY_HOST, requestBuild.getHost(), e22);
                        NetworkStatusHelper.printNetworkDetail();
                        if (httpURLConnectionA != null) {
                            try {
                                httpURLConnectionA.disconnect();
                            } catch (Exception e23) {
                                ALog.e("awcn.HttpConnector", "http disconnect", null, e23, new Object[0]);
                            }
                        }
                    }
                } catch (ConnectException e24) {
                    a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_CONNECT_EXCEPTION, e24);
                    ALog.e("awcn.HttpConnector", "HTTP Connect Exception", requestBuild.getSeq(), e24, new Object[0]);
                    NetworkStatusHelper.printNetworkDetail();
                    if (httpURLConnectionA != null) {
                        try {
                            httpURLConnectionA.disconnect();
                        } catch (Exception e25) {
                            ALog.e("awcn.HttpConnector", "http disconnect", null, e25, new Object[0]);
                        }
                    }
                }
                return aVar;
            } finally {
            }
        }
        a(requestBuild, aVar, requestCb, ErrorConstant.ERROR_NO_NETWORK, th);
        return aVar;
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i2, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i2);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), Constants.KEY_ERROR_CODE, Integer.valueOf(i2), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.a = i2;
        }
        if (!request.a.isDone.get()) {
            RequestStatistic requestStatistic = request.a;
            requestStatistic.statusCode = i2;
            requestStatistic.msg = errMsg;
            requestStatistic.rspEnd = System.currentTimeMillis();
            if (i2 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i2, errMsg, request.a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i2, errMsg, request.a);
        }
    }

    private static HttpURLConnection a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g gVarA = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && gVarA != null) {
            proxy = gVarA.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String host = headers.get("Host");
        if (host == null) {
            host = request.getHost();
        }
        String strConcatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(host, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, String.valueOf(request.getHttpUrl().getPort())) : host;
        httpURLConnection.setRequestProperty("Host", strConcatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, strConcatString);
        }
        if (!headers.containsKey(HttpConstant.ACCEPT_ENCODING)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        }
        if (gVarA != null) {
            httpURLConnection.setRequestProperty("Authorization", gVarA.c());
        }
        if (url.getProtocol().equalsIgnoreCase(HttpConstant.HTTPS)) {
            a(httpURLConnection, request, host);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo \u4ee5\u4e0b\u7248\u672c\u4e0d\u652f\u6301https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f1649b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f1649b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i2 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int iPostBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e2, new Object[0]);
                        }
                    }
                    i2 = iPostBody;
                } catch (Exception e3) {
                    ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e3, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e4) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e4, new Object[0]);
                        }
                    }
                }
                RequestStatistic requestStatistic = request.a;
                long j2 = i2;
                requestStatistic.reqBodyInflateSize = j2;
                requestStatistic.reqBodyDeflateSize = j2;
                requestStatistic.sendDataSize = j2;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e5) {
                        ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e5, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i2;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws Throwable {
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Exception e3) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e3, new Object[0]);
                errorStream = null;
            }
        }
        if (errorStream == null) {
            a(request, aVar, requestCb, -404, null);
            return;
        }
        if (requestCb == null) {
            int i2 = aVar.f1537d;
            if (i2 <= 0) {
                i2 = 1024;
            } else if (aVar.f1538e) {
                i2 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i2);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(errorStream);
        } catch (Throwable th) {
            th = th;
            aVar2 = null;
        }
        try {
            InputStream gZIPInputStream = aVar.f1538e ? new GZIPInputStream(aVar2) : aVar2;
            ByteArray byteArrayA = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArrayA == null) {
                    byteArrayA = a.C0008a.a.a(2048);
                }
                int from = byteArrayA.readFrom(gZIPInputStream);
                if (from != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArrayA, false);
                        byteArrayA = null;
                    }
                    long j2 = from;
                    request.a.recDataSize += j2;
                    request.a.rspBodyInflateSize += j2;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.recycle();
                    } else {
                        requestCb.onDataReceive(byteArrayA, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.f1535b = byteArrayOutputStream.toByteArray();
                    }
                    request.a.recDataTime = System.currentTimeMillis() - request.a.rspStart;
                    request.a.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            request.a.recDataTime = System.currentTimeMillis() - request.a.rspStart;
            request.a.rspBodyDeflateSize = aVar2.a();
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
