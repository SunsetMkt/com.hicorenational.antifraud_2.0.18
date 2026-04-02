package com.umeng.socialize.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final String a = "NetClient";

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (m.a() && (z || a.f8165c)) {
                m.a(a, "req: ", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (m.a() && (z || a.f8165c)) {
                m.a(a, "req: ", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            throw th;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(str.getBytes(), byteArrayOutputStream);
        byte[] bArrA = i.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(bArrA);
            c.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (errorStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int i2 = errorStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i2);
                    } finally {
                        c.a(errorStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] bArrA2 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                l.b(bArrA2, byteArrayOutputStream);
            }
            String string = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return string;
            }
            throw new IOException("code:" + responseCode + " msg:" + string);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(JSONObject jSONObject, String str, String str2) throws Exception {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        int responseCode;
        String string = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(string.getBytes(), byteArrayOutputStream);
        byte[] bArrA = i.a(byteArrayOutputStream.toByteArray(), bytes);
        if (a.f8165c && string.length() > 0) {
            m.a(a, "src:", Integer.valueOf(string.length()), ", gzip:", Integer.valueOf(bArrA.length), ", ratio:", Integer.valueOf((bArrA.length * 100) / string.length()), "%");
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                httpURLConnection.addRequestProperty("appkey", str2);
                httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th) {
                th = th;
                outputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            httpURLConnection = null;
        }
        try {
            outputStream.write(bArrA);
            responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            c.a(outputStream);
            c.a(errorStream);
            if (httpURLConnection != null) {
            }
            throw th;
        }
        try {
            byteArrayOutputStream.reset();
            if (errorStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = errorStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
            }
            c.a(outputStream);
            c.a(errorStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
            }
            if (responseCode == 200) {
                byte[] bArrA2 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                l.b(bArrA2, byteArrayOutputStream);
            }
            String string2 = byteArrayOutputStream.toString();
            if (a.f8165c) {
                m.a(a, "req: ", str, "\n", string);
                if (responseCode == 200) {
                    string2 = new JSONObject(string2).toString();
                }
                m.a(a, "resp:\n", string2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            if (responseCode == 200) {
                return;
            }
            throw new Exception("response code " + responseCode);
        } catch (Throwable th4) {
            th = th4;
            c.a(outputStream);
            c.a(errorStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }
}
