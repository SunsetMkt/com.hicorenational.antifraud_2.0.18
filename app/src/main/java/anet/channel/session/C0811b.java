package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.C0752a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.C0855a;
import anet.channel.util.C0856b;
import anet.channel.util.C0861g;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* renamed from: anet.channel.session.b */
/* loaded from: classes.dex */
public class C0811b {

    /* compiled from: Taobao */
    /* renamed from: anet.channel.session.b$a */
    public static class a {

        /* renamed from: a */
        public int f981a;

        /* renamed from: b */
        public byte[] f982b;

        /* renamed from: c */
        public Map<String, List<String>> f983c;

        /* renamed from: d */
        public int f984d;

        /* renamed from: e */
        public boolean f985e;
    }

    private C0811b() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x020a, code lost:
    
        r23.onResponseCode(r9.f981a, r9.f983c);
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0230 A[Catch: SSLException -> 0x0266, SSLHandshakeException -> 0x0269, all -> 0x0272, Exception -> 0x0276, IOException -> 0x02bb, CancellationException -> 0x02f0, ConnectException -> 0x03e4, ConnectTimeoutException -> 0x040c, SocketTimeoutException -> 0x0432, UnknownHostException -> 0x0458, TryCatch #12 {ConnectException -> 0x03e4, blocks: (B:10:0x0032, B:12:0x003c, B:13:0x0083, B:16:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:37:0x0175, B:38:0x0189, B:40:0x01ad, B:42:0x01b3, B:44:0x01b9, B:46:0x01bf, B:49:0x01c6, B:51:0x01e5, B:53:0x01f5, B:54:0x01fc, B:55:0x0219, B:57:0x0230, B:59:0x024b, B:70:0x020a, B:71:0x0211), top: B:9:0x0032, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x024b A[Catch: SSLException -> 0x0266, SSLHandshakeException -> 0x0269, all -> 0x0272, Exception -> 0x0276, IOException -> 0x02bb, CancellationException -> 0x02f0, ConnectException -> 0x03e4, ConnectTimeoutException -> 0x040c, SocketTimeoutException -> 0x0432, UnknownHostException -> 0x0458, TRY_LEAVE, TryCatch #12 {ConnectException -> 0x03e4, blocks: (B:10:0x0032, B:12:0x003c, B:13:0x0083, B:16:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:37:0x0175, B:38:0x0189, B:40:0x01ad, B:42:0x01b3, B:44:0x01b9, B:46:0x01bf, B:49:0x01c6, B:51:0x01e5, B:53:0x01f5, B:54:0x01fc, B:55:0x0219, B:57:0x0230, B:59:0x024b, B:70:0x020a, B:71:0x0211), top: B:9:0x0032, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0256 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03ae A[Catch: all -> 0x0272, TRY_LEAVE, TryCatch #7 {all -> 0x0272, blocks: (B:10:0x0032, B:12:0x003c, B:13:0x0083, B:16:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:37:0x0175, B:38:0x0189, B:40:0x01ad, B:42:0x01b3, B:44:0x01b9, B:46:0x01bf, B:49:0x01c6, B:51:0x01e5, B:53:0x01f5, B:54:0x01fc, B:55:0x0219, B:57:0x0230, B:59:0x024b, B:70:0x020a, B:71:0x0211, B:87:0x031b, B:89:0x0346, B:76:0x0383, B:78:0x03ae, B:169:0x0278, B:171:0x027e, B:172:0x0282, B:174:0x028a, B:175:0x029e, B:182:0x0299, B:124:0x02bf, B:160:0x02f4, B:115:0x03e8, B:133:0x0410, B:151:0x0436, B:142:0x045c), top: B:9:0x0032, inners: #12, #15, #19, #20, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0346 A[Catch: all -> 0x0272, TRY_LEAVE, TryCatch #7 {all -> 0x0272, blocks: (B:10:0x0032, B:12:0x003c, B:13:0x0083, B:16:0x0097, B:19:0x00b3, B:21:0x00fc, B:23:0x0106, B:25:0x010c, B:37:0x0175, B:38:0x0189, B:40:0x01ad, B:42:0x01b3, B:44:0x01b9, B:46:0x01bf, B:49:0x01c6, B:51:0x01e5, B:53:0x01f5, B:54:0x01fc, B:55:0x0219, B:57:0x0230, B:59:0x024b, B:70:0x020a, B:71:0x0211, B:87:0x031b, B:89:0x0346, B:76:0x0383, B:78:0x03ae, B:169:0x0278, B:171:0x027e, B:172:0x0282, B:174:0x028a, B:175:0x029e, B:182:0x0299, B:124:0x02bf, B:160:0x02f4, B:115:0x03e8, B:133:0x0410, B:151:0x0436, B:142:0x045c), top: B:9:0x0032, inners: #12, #15, #19, #20, #22, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x036c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anet.channel.session.C0811b.a m602a(anet.channel.request.Request r22, anet.channel.RequestCb r23) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.C0811b.m602a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    /* renamed from: a */
    private static void m604a(Request request, a aVar, RequestCb requestCb, int i2, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i2);
        ALog.m715e("awcn.HttpConnector", "onException", request.getSeq(), Constants.KEY_ERROR_CODE, Integer.valueOf(i2), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.f981a = i2;
        }
        if (!request.f916a.isDone.get()) {
            RequestStatistic requestStatistic = request.f916a;
            requestStatistic.statusCode = i2;
            requestStatistic.msg = errMsg;
            requestStatistic.rspEnd = System.currentTimeMillis();
            if (i2 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i2, errMsg, request.f916a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i2, errMsg, request.f916a);
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m603a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        C0861g m736a = C0861g.m736a();
        if (NetworkStatusHelper.getStatus().isMobile() && m736a != null) {
            proxy = m736a.m737b();
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
        String str = headers.get("Host");
        if (str == null) {
            str = request.getHost();
        }
        String concatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(str, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, String.valueOf(request.getHttpUrl().getPort())) : str;
        httpURLConnection.setRequestProperty("Host", concatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, concatString);
        }
        if (!headers.containsKey(HttpConstant.ACCEPT_ENCODING)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        }
        if (m736a != null) {
            httpURLConnection.setRequestProperty("Authorization", m736a.m738c());
        }
        if (url.getProtocol().equalsIgnoreCase(HttpConstant.HTTPS)) {
            m606a(httpURLConnection, request, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m606a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.m715e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = C0856b.f1171a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.m716i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", C0856b.f1171a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = C0856b.f1172b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.m716i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", C0856b.f1172b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new C0812c(str));
    }

    /* renamed from: a */
    private static int m601a(HttpURLConnection httpURLConnection, Request request) {
        int i2 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int postBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.m714e("awcn.HttpConnector", "postData", request.getSeq(), e2, new Object[0]);
                        }
                    }
                    i2 = postBody;
                } catch (Exception e3) {
                    ALog.m714e("awcn.HttpConnector", "postData error", request.getSeq(), e3, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e4) {
                            ALog.m714e("awcn.HttpConnector", "postData", request.getSeq(), e4, new Object[0]);
                        }
                    }
                }
                RequestStatistic requestStatistic = request.f916a;
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
                        ALog.m714e("awcn.HttpConnector", "postData", request.getSeq(), e5, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static void m605a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws IOException, CancellationException {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        C0855a c0855a;
        httpURLConnection.getURL().toString();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                ALog.m718w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e3) {
                ALog.m714e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e3, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            m604a(request, aVar, requestCb, -404, null);
            return;
        }
        if (requestCb == null) {
            int i2 = aVar.f984d;
            if (i2 <= 0) {
                i2 = 1024;
            } else if (aVar.f985e) {
                i2 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i2);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            c0855a = new C0855a(inputStream);
        } catch (Throwable th) {
            th = th;
            c0855a = null;
        }
        try {
            InputStream gZIPInputStream = aVar.f985e ? new GZIPInputStream(c0855a) : c0855a;
            ByteArray byteArray = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArray == null) {
                    byteArray = C0752a.a.f765a.m446a(2048);
                }
                int readFrom = byteArray.readFrom(gZIPInputStream);
                if (readFrom != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArray.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArray, false);
                        byteArray = null;
                    }
                    long j2 = readFrom;
                    request.f916a.recDataSize += j2;
                    request.f916a.rspBodyInflateSize += j2;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArray.recycle();
                    } else {
                        requestCb.onDataReceive(byteArray, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.f982b = byteArrayOutputStream.toByteArray();
                    }
                    request.f916a.recDataTime = System.currentTimeMillis() - request.f916a.rspStart;
                    request.f916a.rspBodyDeflateSize = c0855a.m719a();
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
            request.f916a.recDataTime = System.currentTimeMillis() - request.f916a.rspStart;
            request.f916a.rspBodyDeflateSize = c0855a.m719a();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
