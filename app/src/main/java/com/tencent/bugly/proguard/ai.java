package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.socialize.common.SocializeConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class ai {

    /* renamed from: c, reason: collision with root package name */
    private static ai f9210c;

    /* renamed from: a, reason: collision with root package name */
    protected Context f9211a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f9212b = null;

    private ai(Context context) {
        this.f9211a = context;
    }

    public static ai a(Context context) {
        if (f9210c == null) {
            f9210c = new ai(context);
        }
        return f9210c;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    protected boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 307;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:23|24|25|(7:97|98|(1:100)(1:111)|101|103|104|105)(11:27|(3:59|60|(5:78|79|81|82|83)(9:62|63|64|65|66|67|68|69|70))(1:29)|30|31|32|(1:34)|35|36|38|39|40)|93|47|(1:49)|50|51|40) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0170, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r6) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0172, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0191, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0192, code lost:
    
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0197, code lost:
    
        if (com.tencent.bugly.proguard.an.a(r6) != false) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018a A[Catch: all -> 0x017c, TRY_LEAVE, TryCatch #12 {all -> 0x017c, blocks: (B:24:0x009e, B:98:0x00a6, B:101:0x00b7, B:111:0x00b5, B:27:0x00d1, B:60:0x00d7, B:79:0x00df, B:66:0x0113, B:69:0x011d, B:31:0x013d, B:36:0x0163, B:47:0x0184, B:49:0x018a), top: B:23:0x009e }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r23, byte[] r24, com.tencent.bugly.proguard.al r25, java.util.Map<java.lang.String, java.lang.String> r26) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ai.a(java.lang.String, byte[], com.tencent.bugly.proguard.al, java.util.Map):byte[]");
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
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
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
        HttpURLConnection a2 = a(str2, str);
        if (a2 == null) {
            an.e("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a2.setRequestProperty("wup_version", SocializeConstants.PROTOCOL_VERSON);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a2.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            a2.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a2.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a2.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a2;
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
