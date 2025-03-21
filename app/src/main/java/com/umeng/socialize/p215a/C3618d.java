package com.umeng.socialize.p215a;

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

/* compiled from: NetClient.java */
/* renamed from: com.umeng.socialize.a.d */
/* loaded from: classes2.dex */
public class C3618d {

    /* renamed from: a */
    private static final String f13482a = "NetClient";

    /* renamed from: a */
    public static JSONObject m12509a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(m12508a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (C3627m.m12564a() && (z || C3615a.f13470c)) {
                C3627m.m12562a(f13482a, "req: ", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th) {
            if (C3627m.m12564a() && (z || C3615a.f13470c)) {
                C3627m.m12562a(f13482a, "req: ", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m12508a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C3626l.m12556a(str.getBytes(), byteArrayOutputStream);
        byte[] m12539a = C3623i.m12539a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.setConnectTimeout(BuglyStrategy.C3070a.MAX_USERDATA_VALUE_LENGTH);
        httpURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(m12539a.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            outputStream.write(m12539a);
            C3617c.m12503a(outputStream);
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
                        C3617c.m12503a(inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] m12539a2 = C3623i.m12539a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                C3626l.m12557b(m12539a2, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m12510a(org.json.JSONObject r16, java.lang.String r17, java.lang.String r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.p215a.C3618d.m12510a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }
}
