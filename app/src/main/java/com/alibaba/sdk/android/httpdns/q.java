package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
class q implements Callable<String[]> {
    private static Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private s f37a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2602d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private long f38d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f2603e;
    private Map<String, String> extra;
    private String hostName;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2604j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f2605k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f2606l;
    private static d hostManager = d.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f36a = new Object();

    q(String str, s sVar) {
        this.f2602d = 1;
        this.f2605k = null;
        this.f2603e = f.f20c;
        this.f2604j = false;
        this.f2606l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
    }

    q(String str, s sVar, Map<String, String> map, String str2) {
        this.f2602d = 1;
        this.f2605k = null;
        this.f2603e = f.f20c;
        this.f2604j = false;
        this.f2606l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
        this.f2606l = str2;
        this.extra.putAll(map);
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z2 = true;
        if (map != null) {
            z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!d(entry.getKey())) {
                    i.f("\u8bbe\u7f6e\u81ea\u5b9a\u4e49\u53c2\u6570\u5931\u8d25\uff0c\u81ea\u5b9a\u4e49key\u4e0d\u5408\u6cd5\uff1a" + entry.getKey());
                    z2 = false;
                }
                if (!e(entry.getValue())) {
                    i.f("\u8bbe\u7f6e\u81ea\u5b9a\u4e49\u53c2\u6570\u5931\u8d25\uff0c\u81ea\u5b9a\u4e49value\u4e0d\u5408\u6cd5\uff1a" + entry.getValue());
                    z = false;
                }
            }
        } else {
            z = true;
        }
        if (z2 && z) {
            String string = sb.toString();
            if (string.getBytes("UTF-8").length <= 1000) {
                return string;
            }
            i.f("\u8bbe\u7f6e\u81ea\u5b9a\u4e49\u53c2\u6570\u5931\u8d25\uff0c\u81ea\u5b9a\u4e49\u53c2\u6570\u8fc7\u957f");
        }
        return "";
    }

    static void setContext(Context context) {
        a = context;
    }

    public void a(int i2) {
        if (i2 >= 0) {
            this.f2602d = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c6 A[Catch: all -> 0x03f5, TryCatch #2 {all -> 0x03f5, blocks: (B:80:0x03b8, B:82:0x03c6, B:83:0x03cf), top: B:110:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03cf A[Catch: all -> 0x03f5, TRY_LEAVE, TryCatch #2 {all -> 0x03f5, blocks: (B:80:0x03b8, B:82:0x03c6, B:83:0x03cf), top: B:110:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03dc A[Catch: IOException -> 0x03e0, TRY_ENTER, TryCatch #6 {IOException -> 0x03e0, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03dc, B:91:0x03e4), top: B:114:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03e4 A[Catch: IOException -> 0x03e0, TRY_LEAVE, TryCatch #6 {IOException -> 0x03e0, blocks: (B:66:0x0392, B:68:0x0397, B:87:0x03dc, B:91:0x03e4), top: B:114:0x0046 }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] call() {
        ?? r3;
        ?? r4;
        StringBuilder sb;
        String string;
        int responseCode;
        InputStream inputStream;
        BufferedReader bufferedReader;
        StringBuilder sb2;
        this.f38d = System.currentTimeMillis();
        if (!this.f2604j) {
            synchronized (f36a) {
                if (hostManager.m17a(this.hostName)) {
                    i.d("host:" + this.hostName + " is already resolving");
                    return this.f2603e;
                }
                hostManager.m15a(this.hostName);
                this.f2604j = true;
            }
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    TrafficStats.setThreadStatsTag(40965);
                }
                this.f2605k = u.a(this.f37a);
                if (this.f2605k == null) {
                    i.d("serverIp is null, give up query for hostname:" + this.hostName);
                    inputStream = null;
                    bufferedReader = null;
                } else {
                    com.alibaba.sdk.android.httpdns.c.a.a().c(a);
                    if (a.a()) {
                        String timestamp = a.getTimestamp();
                        if (com.alibaba.sdk.android.httpdns.c.a.a().h()) {
                            sb2 = new StringBuilder();
                            sb2.append(f.PROTOCOL);
                            sb2.append(this.f2605k);
                            sb2.append(Constants.COLON_SEPARATOR);
                            sb2.append(f.f2574d);
                            sb2.append("/");
                            sb2.append(f.f2573c);
                            sb2.append("/sign_d?host=");
                            sb2.append(this.hostName);
                            sb2.append("&sdk=android_");
                            sb2.append("1.3.2.3-no-bssid-ssid");
                            sb2.append("&t=");
                            sb2.append(timestamp);
                            sb2.append("&s=");
                            sb2.append(a.a(this.hostName, timestamp));
                            sb2.append("&sid=");
                            sb2.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb2.append("&net=");
                            sb2.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb2.append(getExtra());
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(f.PROTOCOL);
                            sb2.append(this.f2605k);
                            sb2.append(Constants.COLON_SEPARATOR);
                            sb2.append(f.f2574d);
                            sb2.append("/");
                            sb2.append(f.f2573c);
                            sb2.append("/sign_d?host=");
                            sb2.append(this.hostName);
                            sb2.append("&sdk=android_");
                            sb2.append("1.3.2.3-no-bssid-ssid");
                            sb2.append("&t=");
                            sb2.append(timestamp);
                            sb2.append("&s=");
                            sb2.append(a.a(this.hostName, timestamp));
                            sb2.append("&sid=");
                            sb2.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb2.append("&net=");
                            sb2.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb2.append(getExtra());
                        }
                        string = sb2.toString();
                    } else {
                        if (com.alibaba.sdk.android.httpdns.c.a.a().h()) {
                            sb = new StringBuilder();
                            sb.append(f.PROTOCOL);
                            sb.append(this.f2605k);
                            sb.append(Constants.COLON_SEPARATOR);
                            sb.append(f.f2574d);
                            sb.append("/");
                            sb.append(f.f2573c);
                            sb.append("/d?host=");
                            sb.append(this.hostName);
                            sb.append("&sdk=android_");
                            sb.append("1.3.2.3-no-bssid-ssid");
                            sb.append("&sid=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb.append("&net=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb.append(getExtra());
                        } else {
                            sb = new StringBuilder();
                            sb.append(f.PROTOCOL);
                            sb.append(this.f2605k);
                            sb.append(Constants.COLON_SEPARATOR);
                            sb.append(f.f2574d);
                            sb.append("/");
                            sb.append(f.f2573c);
                            sb.append("/d?host=");
                            sb.append(this.hostName);
                            sb.append("&sdk=android_");
                            sb.append("1.3.2.3-no-bssid-ssid");
                            sb.append("&sid=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb.append("&net=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb.append(getExtra());
                        }
                        string = sb.toString();
                    }
                    if (com.alibaba.sdk.android.httpdns.net64.a.a().m26a()) {
                        string = string + "&query=4,6";
                    }
                    i.f("resolve url: " + string);
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(string).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(f.a);
                        httpURLConnection2.setReadTimeout(f.a);
                        if (httpURLConnection2 instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.sdk.android.httpdns.q.1
                                @Override // javax.net.ssl.HostnameVerifier
                                public boolean verify(String str, SSLSession sSLSession) {
                                    i.d("Https request, set hostnameVerifier");
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
                                }
                            });
                        }
                        responseCode = httpURLConnection2.getResponseCode();
                        r4 = 200;
                    } catch (Throwable th) {
                        r4 = 0;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        r3 = 0;
                    }
                    try {
                        try {
                            if (responseCode != 200) {
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getErrorStream(), "UTF-8"));
                                StringBuilder sb3 = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        i.f("response code is " + httpURLConnection2.getResponseCode() + " expect 200. response body is " + sb3.toString());
                                        throw new h(httpURLConnection2.getResponseCode(), new g(httpURLConnection2.getResponseCode(), sb3.toString()).b());
                                    }
                                    sb3.append(line);
                                }
                            } else {
                                inputStream = httpURLConnection2.getInputStream();
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                StringBuilder sb4 = new StringBuilder();
                                while (true) {
                                    String line2 = bufferedReader.readLine();
                                    if (line2 == null) {
                                        break;
                                    }
                                    sb4.append(line2);
                                }
                                i.d("resolve host: " + this.hostName + ", return: " + sb4.toString());
                                e eVar = new e(sb4.toString());
                                eVar.setCacheKey(this.f2606l);
                                if (hostManager.count() >= 100) {
                                    throw new Exception("the total number of hosts is exceed 100");
                                }
                                hostManager.m16a(this.hostName, eVar);
                                u.a(this.hostName, this.f2605k, System.currentTimeMillis() - this.f38d);
                                hostManager.b(this.hostName);
                                this.f2603e = eVar.getIps();
                                this.extra = eVar.m21a();
                                httpURLConnection = httpURLConnection2;
                            }
                        } catch (Throwable th2) {
                            r4 = 0;
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            r3 = responseCode;
                            try {
                                i.a(th);
                                u.a(this.hostName, this.f2605k, th);
                                if (this.f2602d <= 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                if (r3 != 0) {
                                }
                                if (r4 != 0) {
                                }
                                hostManager.b(this.hostName);
                                return this.f2603e;
                            } catch (Throwable th3) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (r3 != 0) {
                                    try {
                                        r3.close();
                                    } catch (IOException e2) {
                                        i.a(e2);
                                        throw th3;
                                    }
                                }
                                if (r4 != 0) {
                                    r4.close();
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection = httpURLConnection2;
                        r3 = responseCode;
                        i.a(th);
                        u.a(this.hostName, this.f2605k, th);
                        if (this.f2602d <= 0) {
                            this.f2602d--;
                            call();
                        } else {
                            u.reportHttpDnsSuccess(this.hostName, 0);
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                        if (r4 != 0) {
                            r4.close();
                        }
                        hostManager.b(this.hostName);
                        return this.f2603e;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Throwable th5) {
                th = th5;
                r3 = 0;
                r4 = 0;
            }
        } catch (IOException e3) {
            i.a(e3);
        }
        hostManager.b(this.hostName);
        return this.f2603e;
    }
}
