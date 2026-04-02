package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import android.util.Base64InputStream;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ENV;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.j;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b {
    static AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b */
    static HostnameVerifier f1595b = new c();

    /* JADX INFO: renamed from: c */
    static Random f1596c = new Random();

    b() {
    }

    static List<IConnStrategy> a(String str) {
        List<IConnStrategy> connStrategyListByHost = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = connStrategyListByHost.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return connStrategyListByHost;
    }

    public static void a(Map map) {
        String strA;
        IConnStrategy iConnStrategyRemove;
        String strA2;
        if (map == null) {
            return;
        }
        String schemeByHost = AmdcRuntimeInfo.isForceHttps() ? HttpConstant.HTTPS : StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        List<IConnStrategy> listA = a(schemeByHost);
        for (int i2 = 0; i2 < 3; i2++) {
            HashMap map2 = new HashMap(map);
            if (i2 != 2) {
                iConnStrategyRemove = !listA.isEmpty() ? listA.remove(0) : null;
                if (iConnStrategyRemove != null) {
                    strA2 = a(schemeByHost, iConnStrategyRemove.getIp(), iConnStrategyRemove.getPort(), map2, i2);
                } else {
                    strA2 = a(schemeByHost, (String) null, 0, map2, i2);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp != null && amdcServerFixIp.length > 0) {
                    strA = a(schemeByHost, amdcServerFixIp[f1596c.nextInt(amdcServerFixIp.length)], 0, map2, i2);
                } else {
                    strA = a(schemeByHost, (String) null, 0, map2, i2);
                }
                String str = strA;
                iConnStrategyRemove = null;
                strA2 = str;
            }
            int iA = a(strA2, map2, i2);
            if (iConnStrategyRemove != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = iA == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategyRemove, connEvent);
            }
            if (iA == 0 || iA == 2) {
                return;
            }
        }
    }

    private static String a(String str, String str2, int i2, Map<String, String> map, int i3) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i3 == 2 && HttpConstant.HTTPS.equalsIgnoreCase(str) && f1596c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(str2)) {
                try {
                    str2 = anet.channel.util.c.a(str2);
                } catch (Exception unused) {
                }
            }
            if (anet.channel.strategy.utils.c.b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i2 == 0) {
                i2 = HttpConstant.HTTPS.equalsIgnoreCase(str) ? Constants.PORT : 80;
            }
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(i2);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put("platform", map.remove("platform"));
        sb.append('?');
        sb.append(anet.channel.strategy.utils.c.a(treeMap, "utf-8"));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:307:0x02bb A[Catch: all -> 0x02db, TryCatch #13 {all -> 0x02db, blocks: (B:305:0x02b1, B:307:0x02bb, B:308:0x02bf), top: B:347:0x02b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [long] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.net.URL] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, Map map, int i2) {
        String str2;
        ?? length;
        HttpURLConnection httpURLConnection;
        String message;
        URL url;
        String str3 = "AMDC" + String.valueOf(a.incrementAndGet());
        int i3 = 2;
        ALog.i("awcn.DispatchCore", "send amdc request", str3, "url", str, "\nhost", map.get(DispatchConstants.DOMAIN).toString());
        ENV env = (ENV) map.remove("Env");
        try {
            url = new URL(str);
        } catch (Throwable th) {
            th = th;
            str2 = "awcn.DispatchCore";
            length = 0;
        }
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.addRequestProperty("Connection", "close");
                httpURLConnection.addRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
                httpURLConnection.addRequestProperty("Host", DispatchConstants.getAmdcServerDomain());
                httpURLConnection.setInstanceFollowRedirects(false);
                if (url.getProtocol().equals(HttpConstant.HTTPS)) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f1595b);
                    if (AwcnConfig.isHttpsSniEnable()) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new j(DispatchConstants.getAmdcServerDomain()));
                    }
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc request.", str3, "headers", httpURLConnection.getRequestProperties().toString());
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                byte[] bytes = anet.channel.strategy.utils.c.a(map, "utf-8").getBytes();
                outputStream.write(bytes);
                int responseCode = httpURLConnection.getResponseCode();
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc response. code: " + responseCode, str3, "\nheaders", httpURLConnection.getHeaderFields());
                }
                if (responseCode != 200) {
                    if (responseCode != 302 && responseCode != 307) {
                        i3 = 1;
                    }
                    a(String.valueOf(responseCode), "response code not 200", url, i2, i3);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                            ALog.e("awcn.DispatchCore", "http disconnect failed", null, e2, new Object[0]);
                        }
                    }
                    return i3;
                }
                String headerField = httpURLConnection.getHeaderField("x-am-code");
                if (!com.tencent.connect.common.Constants.DEFAULT_UIN.equals(headerField)) {
                    if (!"1007".equals(headerField) && !"1008".equals(headerField)) {
                        i3 = 1;
                    }
                    a(headerField, "return code: " + headerField, url, i2, i3);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e3) {
                            ALog.e("awcn.DispatchCore", "http disconnect failed", null, e3, new Object[0]);
                        }
                    }
                    return i3;
                }
                String headerField2 = httpURLConnection.getHeaderField("x-am-sign");
                if (TextUtils.isEmpty(headerField2)) {
                    a("-1001", "response sign is empty", url, i2, 1);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e4) {
                            ALog.e("awcn.DispatchCore", "http disconnect failed", null, e4, new Object[0]);
                        }
                    }
                    return 1;
                }
                String strA = a(httpURLConnection.getInputStream(), HttpConstant.GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding()));
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.DispatchCore", "amdc response body", str3, "\nbody", strA);
                }
                str2 = "awcn.DispatchCore";
                length = bytes.length;
                try {
                    try {
                        a(str, (long) length, httpURLConnection.getContentLength());
                    } catch (Throwable th2) {
                        th = th2;
                        length = url;
                    }
                    try {
                        if (TextUtils.isEmpty(strA)) {
                            a("-1002", "read answer error", url, i2, 1);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e5) {
                                    ALog.e(str2, "http disconnect failed", null, e5, new Object[0]);
                                }
                            }
                            return 1;
                        }
                        length = url;
                        IAmdcSign sign = AmdcRuntimeInfo.getSign();
                        String strSign = sign != null ? sign.sign(strA) : null;
                        if (!strSign.equalsIgnoreCase(headerField2)) {
                            ALog.e(str2, "check ret sign failed", str3, "retSign", headerField2, "checkSign", strSign);
                            a("-1003", "check sign failed", (URL) length, i2, 1);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e6) {
                                    ALog.e(str2, "http disconnect failed", null, e6, new Object[0]);
                                }
                            }
                            return 1;
                        }
                        try {
                            JSONObject jSONObject = (JSONObject) new JSONTokener(strA).nextValue();
                            if (GlobalAppRuntimeInfo.getEnv() != env) {
                                ALog.w(str2, "env change, do not notify result", str3, new Object[0]);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e7) {
                                        ALog.e(str2, "http disconnect failed", null, e7, new Object[0]);
                                    }
                                }
                                return 0;
                            }
                            HttpDispatcher.getInstance().a(new DispatchEvent(1, jSONObject));
                            a(headerField, "request success", (URL) length, i2, 0);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e8) {
                                    ALog.e(str2, "http disconnect failed", null, e8, new Object[0]);
                                }
                            }
                            return 0;
                        } catch (JSONException unused) {
                            HttpDispatcher.getInstance().a(new DispatchEvent(0, null));
                            ALog.e(str2, "resolve amdc anser failed", str3, new Object[0]);
                            a("-1004", "resolve answer failed", (URL) length, i2, 1);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e9) {
                                    ALog.e(str2, "http disconnect failed", null, e9, new Object[0]);
                                }
                            }
                            return 1;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            message = th.getMessage();
                            if (TextUtils.isEmpty(message)) {
                            }
                            a("-1000", message, (URL) length, i2, 1);
                            ALog.e(str2, "amdc request fail", str3, th, new Object[0]);
                            if (httpURLConnection != null) {
                            }
                            return 1;
                        } finally {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    length = url;
                    message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = th.toString();
                    }
                    a("-1000", message, (URL) length, i2, 1);
                    ALog.e(str2, "amdc request fail", str3, th, new Object[0]);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e10) {
                            ALog.e(str2, "http disconnect failed", null, e10, new Object[0]);
                        }
                    }
                    return 1;
                }
            } catch (Throwable th5) {
                th = th5;
                str2 = "awcn.DispatchCore";
            }
        } catch (Throwable th6) {
            th = th6;
            str2 = "awcn.DispatchCore";
            length = url;
            httpURLConnection = null;
            message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
            }
            a("-1000", message, (URL) length, i2, 1);
            ALog.e(str2, "amdc request fail", str3, th, new Object[0]);
            if (httpURLConnection != null) {
            }
            return 1;
        }
    }

    static String a(InputStream inputStream, boolean z) throws Throwable {
        Throwable th;
        IOException e2;
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        if (z) {
            try {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e2 = e3;
                ALog.e("awcn.DispatchCore", "", null, e2, new Object[0]);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
                return null;
            }
        }
        Base64InputStream base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = base64InputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
            try {
                base64InputStream.close();
            } catch (IOException unused3) {
            }
            return str;
        } catch (IOException e4) {
            e2 = e4;
            bufferedInputStream = base64InputStream;
            ALog.e("awcn.DispatchCore", "", null, e2, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = base64InputStream;
            bufferedInputStream.close();
            throw th;
        }
    }

    static void a(String str, String str2, URL url, int i2, int i3) {
        if ((i3 != 1 || i2 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i2;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    static void a(String str, long j2, long j3) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j2;
            flowStat.downstream = j3;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e2) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", null, e2, new Object[0]);
        }
    }
}
