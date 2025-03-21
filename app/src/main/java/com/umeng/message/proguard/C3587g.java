package com.umeng.message.proguard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.message.common.UPLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.g */
/* loaded from: classes2.dex */
public final class C3587g {
    /* renamed from: a */
    public static JSONObject m12400a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(m12397a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (UPLog.isEnable() && z) {
                UPLog.m12142d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (UPLog.isEnable() && z) {
                UPLog.m12142d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static void m12401b(JSONObject jSONObject, String str, String str2) throws Exception {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C3581bc.m12338a(jSONObject2.getBytes(), byteArrayOutputStream);
        byte[] m12318a = C3576ay.m12318a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        InputStream inputStream2 = null;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                httpURLConnection2.addRequestProperty("Connection", "close");
                httpURLConnection2.addRequestProperty("appkey", str2);
                httpURLConnection2.setFixedLengthStreamingMode(m12318a.length);
                httpURLConnection2.setDoOutput(true);
                outputStream = httpURLConnection2.getOutputStream();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            outputStream.write(m12318a);
            int responseCode = httpURLConnection2.getResponseCode();
            inputStream2 = responseCode < 400 ? httpURLConnection2.getInputStream() : httpURLConnection2.getErrorStream();
            byteArrayOutputStream.reset();
            if (inputStream2 != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            }
            C3586f.m12386a(outputStream);
            C3586f.m12386a(inputStream2);
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.disconnect();
                } catch (Throwable unused) {
                }
            }
            if (responseCode == 200) {
                byte[] m12318a2 = C3576ay.m12318a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                C3581bc.m12339b(m12318a2, byteArrayOutputStream);
            }
            if (responseCode != 200) {
                throw new Exception("response code:".concat(String.valueOf(responseCode)));
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = httpURLConnection2;
            inputStream = inputStream2;
            inputStream2 = outputStream;
            C3586f.m12386a(inputStream2);
            C3586f.m12386a(inputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static JSONObject m12398a(JSONObject jSONObject, String str, String str2) throws Exception {
        try {
            return m12400a(jSONObject, str, str2, true);
        } catch (UnknownHostException unused) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String host = new URL(str).getHost();
            String m12306a = C3572au.m12306a("174658", host);
            if (m12306a == null) {
                return null;
            }
            URL url = new URL(str.replaceFirst(host, m12306a));
            String jSONObject2 = jSONObject.toString();
            try {
                final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Host", host);
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.umeng.message.proguard.g.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public final boolean verify(String str3, SSLSession sSLSession) {
                            String requestProperty = httpURLConnection.getRequestProperty("Host");
                            if (requestProperty == null) {
                                requestProperty = httpURLConnection.getURL().getHost();
                            }
                            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
                        }
                    });
                }
                JSONObject jSONObject3 = new JSONObject(m12397a(jSONObject2, httpURLConnection, str2));
                if (UPLog.isEnable()) {
                    UPLog.m12142d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", jSONObject3, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                return jSONObject3;
            } catch (Throwable th) {
                if (UPLog.isEnable()) {
                    UPLog.m12142d("Net", "req:", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    private static String m12397a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C3581bc.m12338a(str.getBytes(), byteArrayOutputStream);
        byte[] m12318a = C3576ay.m12318a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setConnectTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("Connection", "close");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(m12318a.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(m12318a);
            C3586f.m12386a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        C3586f.m12386a(inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] m12318a2 = C3576ay.m12318a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                C3581bc.m12339b(m12318a2, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + "msg:" + byteArrayOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject m12399a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18, java.io.File r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.C3587g.m12399a(org.json.JSONObject, java.lang.String, java.lang.String, java.io.File):org.json.JSONObject");
    }
}
