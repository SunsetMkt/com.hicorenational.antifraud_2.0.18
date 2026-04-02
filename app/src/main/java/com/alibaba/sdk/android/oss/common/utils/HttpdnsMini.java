package com.alibaba.sdk.android.oss.common.utils;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.just.agentweb.DefaultWebClient;
import com.taobao.accs.common.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpdnsMini {
    private static final String ACCOUNT_ID = "181345";
    private static final int EMPTY_RESULT_HOST_TTL = 30;
    private static final int MAX_HOLD_HOST_NUM = 100;
    private static final int MAX_THREAD_NUM = 5;
    private static final int RESOLVE_TIMEOUT_IN_SEC = 10;
    private static final String SERVER_IP = "203.107.1.1";
    private static final String TAG = "HttpDnsMini";
    private static HttpdnsMini instance;
    private ConcurrentMap<String, HostObject> hostManager = new ConcurrentHashMap();
    private ExecutorService pool = Executors.newFixedThreadPool(5);

    class HostObject {
        private String hostName;
        private String ip;
        private long queryTime;
        private long ttl;

        HostObject() {
        }

        public String getHostName() {
            return this.hostName;
        }

        public String getIp() {
            return this.ip;
        }

        public long getQueryTime() {
            return this.queryTime;
        }

        public long getTtl() {
            return this.ttl;
        }

        public boolean isExpired() {
            return getQueryTime() + this.ttl < System.currentTimeMillis() / 1000;
        }

        public boolean isStillAvailable() {
            return (getQueryTime() + this.ttl) + 600 > System.currentTimeMillis() / 1000;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setQueryTime(long j2) {
            this.queryTime = j2;
        }

        public void setTtl(long j2) {
            this.ttl = j2;
        }

        public String toString() {
            return "[hostName=" + getHostName() + ", ip=" + this.ip + ", ttl=" + getTtl() + ", queryTime=" + this.queryTime + "]";
        }
    }

    class QueryHostTask implements Callable<String> {
        private boolean hasRetryed = false;
        private String hostName;

        public QueryHostTask(String str) {
            this.hostName = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.util.concurrent.Callable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String call() throws Throwable {
            Throwable th;
            InputStream inputStream;
            Exception e2;
            HttpURLConnection httpURLConnection;
            BufferedReader bufferedReader;
            StringBuilder sb;
            String str = DefaultWebClient.HTTPS_SCHEME + HttpdnsMini.SERVER_IP + "/" + HttpdnsMini.ACCOUNT_ID + "/d?host=" + this.hostName;
            OSSLog.logDebug("[httpdnsmini] - buildUrl: " + str);
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (httpURLConnection.getResponseCode() != 200) {
                OSSLog.logError("[httpdnsmini] - responseCodeNot 200, but: " + httpURLConnection.getResponseCode());
                inputStream = null;
            } else {
                inputStream = httpURLConnection.getInputStream();
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        sb = new StringBuilder();
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    if (OSSLog.isEnableLog()) {
                        e2.printStackTrace();
                        OSSLog.logThrowable2Local(e2);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.hasRetryed) {
                    }
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    if (this.hasRetryed) {
                        return null;
                    }
                    this.hasRetryed = true;
                    return call();
                }
                JSONObject jSONObject = new JSONObject(sb.toString());
                String string = jSONObject.getString(Constants.KEY_HOST);
                long j2 = jSONObject.getLong(RemoteMessageConst.TTL);
                JSONArray jSONArray = jSONObject.getJSONArray("ips");
                OSSLog.logDebug("[httpdnsmini] - ips:" + jSONArray.toString());
                if (string != null && jSONArray != null && jSONArray.length() > 0) {
                    if (j2 == 0) {
                        j2 = 30;
                    }
                    HostObject hostObject = HttpdnsMini.this.new HostObject();
                    String string2 = jSONArray == null ? null : jSONArray.getString(0);
                    hostObject.setHostName(string);
                    hostObject.setTtl(j2);
                    hostObject.setIp(string2);
                    hostObject.setQueryTime(System.currentTimeMillis() / 1000);
                    OSSLog.logDebug("[httpdnsmini] - resolve result:" + hostObject.toString());
                    if (HttpdnsMini.this.hostManager.size() < 100) {
                        HttpdnsMini.this.hostManager.put(this.hostName, hostObject);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return string2;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.hasRetryed) {
            }
        }
    }

    private HttpdnsMini() {
    }

    public static HttpdnsMini getInstance() {
        if (instance == null) {
            synchronized (HttpdnsMini.class) {
                if (instance == null) {
                    instance = new HttpdnsMini();
                }
            }
        }
        return instance;
    }

    public String getIpByHostAsync(String str) {
        HostObject hostObject = this.hostManager.get(str);
        if (hostObject == null || hostObject.isExpired()) {
            OSSLog.logDebug("[httpdnsmini] - refresh host: " + str);
            this.pool.submit(new QueryHostTask(str));
        }
        if (hostObject == null || !hostObject.isStillAvailable()) {
            return null;
        }
        return hostObject.getIp();
    }
}
