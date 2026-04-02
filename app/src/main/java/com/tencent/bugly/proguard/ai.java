package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.socialize.common.SocializeConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class ai {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ai f6374c;
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f6375b = null;

    private ai(Context context) {
        this.a = context;
    }

    public static ai a(Context context) {
        if (f6374c == null) {
            f6374c = new ai(context);
        }
        return f6374c;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    protected boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 307;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:135|24|25|(7:127|27|(1:29)(1:30)|31|139|32|38)(11:42|(3:121|44|(5:131|46|137|47|48)(9:56|57|58|129|59|60|133|61|62))(1:74)|117|75|76|(1:78)|119|79|123|80|103)|41|94|(1:96)|125|97|103) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0192, code lost:
    
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0197, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r6) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0191, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0172 A[PHI: r5 r6 r10 r13 r14 r20
  0x0172: PHI (r5v4 int) = (r5v3 int), (r5v17 int) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r6v8 java.lang.Throwable) = (r6v7 java.lang.Throwable), (r6v12 java.lang.Throwable) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r10v8 int) = (r10v7 int), (r10v12 int) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r13v6 boolean) = (r13v5 boolean), (r13v13 boolean) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r14v3 java.lang.String) = (r14v2 java.lang.String), (r14v9 java.lang.String) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]
  0x0172: PHI (r20v2 long) = (r20v1 long), (r20v11 long) binds: [B:101:0x0197, B:84:0x0170] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a A[Catch: all -> 0x017c, TRY_LEAVE, TryCatch #12 {all -> 0x017c, blocks: (B:24:0x009e, B:27:0x00a6, B:31:0x00b7, B:30:0x00b5, B:42:0x00d1, B:44:0x00d7, B:46:0x00df, B:59:0x0113, B:61:0x011d, B:75:0x013d, B:79:0x0163, B:94:0x0184, B:96:0x018a), top: B:135:0x009e }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] a(String str, byte[] bArr, al alVar, Map<String, String> map) {
        int i2;
        long j2;
        int i3;
        int responseCode;
        byte[] bArr2 = null;
        int i4 = 0;
        if (str == null) {
            an.e("Failed for no URL.", new Object[0]);
            return null;
        }
        long length = bArr == null ? 0L : bArr.length;
        an.c("request: %s, send: %d (pid=%d | tid=%d)", str, Long.valueOf(length), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str2 = str;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        for (int i7 = 1; i5 < i7 && i6 < i7; i7 = 1) {
            if (z) {
                i2 = i5;
                z = false;
            } else {
                int i8 = i5 + 1;
                if (i8 > i7) {
                    an.c("try time: " + i8, new Object[i4]);
                    SystemClock.sleep(((long) new Random(System.currentTimeMillis()).nextInt(10000)) + com.heytap.mcssdk.constant.a.q);
                }
                i2 = i8;
            }
            String strF = com.tencent.bugly.crashreport.common.info.b.f(this.a);
            if (strF == null) {
                an.d("Failed to request for network not avail", new Object[i4]);
                i5 = i2;
            } else {
                alVar.a(str2, length, strF);
                HttpURLConnection httpURLConnectionA = a(str2, bArr, strF, map);
                if (httpURLConnectionA != null) {
                    try {
                        try {
                            responseCode = httpURLConnectionA.getResponseCode();
                        } finally {
                        }
                    } catch (IOException e2) {
                        e = e2;
                        j2 = length;
                        i3 = i2;
                    }
                    if (responseCode == 200) {
                        try {
                            this.f6375b = b(httpURLConnectionA);
                            byte[] bArrA = a(httpURLConnectionA);
                            alVar.a(bArrA == null ? 0L : bArrA.length);
                            try {
                                httpURLConnectionA.disconnect();
                            } catch (Throwable th) {
                                if (!an.a(th)) {
                                    th.printStackTrace();
                                }
                            }
                            return bArrA;
                        } catch (IOException e3) {
                            e = e3;
                            i3 = i2;
                            j2 = length;
                        }
                    } else {
                        if (a(responseCode)) {
                            try {
                                String headerField = httpURLConnectionA.getHeaderField("Location");
                                if (headerField == null) {
                                    try {
                                        an.e("Failed to redirect: %d" + responseCode, new Object[0]);
                                        try {
                                            httpURLConnectionA.disconnect();
                                            return null;
                                        } catch (Throwable th2) {
                                            if (an.a(th2)) {
                                                return null;
                                            }
                                            th2.printStackTrace();
                                            return null;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                        i3 = i2;
                                        j2 = length;
                                        z = true;
                                    }
                                } else {
                                    i6++;
                                    try {
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Integer.valueOf(responseCode);
                                        try {
                                            objArr[1] = headerField;
                                            an.c("redirect code: %d ,to:%s", objArr);
                                            str2 = headerField;
                                            i3 = 0;
                                            z = true;
                                        } catch (IOException e5) {
                                            e = e5;
                                            str2 = headerField;
                                            j2 = length;
                                            i3 = 0;
                                            z = true;
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                    }
                                }
                            } catch (IOException e7) {
                                e = e7;
                                i3 = i2;
                                j2 = length;
                            }
                        } else {
                            i3 = i2;
                        }
                        try {
                            an.d("response code " + responseCode, new Object[0]);
                            j2 = length;
                            long contentLength = httpURLConnectionA.getContentLength();
                            if (contentLength < 0) {
                                contentLength = 0;
                            }
                            try {
                                alVar.a(contentLength);
                                try {
                                    httpURLConnectionA.disconnect();
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    if (!an.a(th4)) {
                                        th4.printStackTrace();
                                    }
                                }
                            } catch (IOException e8) {
                                e = e8;
                                if (!an.a(e)) {
                                }
                                httpURLConnectionA.disconnect();
                            }
                        } catch (IOException e9) {
                            e = e9;
                            j2 = length;
                        }
                        i5 = i3;
                        i4 = 0;
                    }
                    if (!an.a(e)) {
                        e.printStackTrace();
                    }
                    httpURLConnectionA.disconnect();
                    i5 = i3;
                    i4 = 0;
                } else {
                    j2 = length;
                    an.c("Failed to execute post.", new Object[i4]);
                    alVar.a(0L);
                    i5 = i2;
                }
                length = j2;
                bArr2 = null;
            }
        }
        return bArr2;
    }

    protected byte[] a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                ak.a().b(true);
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    protected HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            an.e("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            an.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", SocializeConstants.PROTOCOL_VERSON);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionA.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionA.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionA;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            an.e("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    protected HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (ao.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(ao.a());
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (an.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
