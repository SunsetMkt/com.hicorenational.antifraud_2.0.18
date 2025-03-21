package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.w */
/* loaded from: classes.dex */
public abstract class AbstractC2454w {

    /* renamed from: com.huawei.hms.hatool.w$a */
    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static C2434n0 m7392a(String str, byte[] bArr, Map<String, String> map) {
        return m7393a(str, bArr, map, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0148  */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.io.BufferedOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.hatool.C2434n0 m7393a(java.lang.String r6, byte[] r7, java.util.Map<java.lang.String, java.lang.String> r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.AbstractC2454w.m7393a(java.lang.String, byte[], java.util.Map, java.lang.String):com.huawei.hms.hatool.n0");
    }

    /* renamed from: a */
    private static HttpURLConnection m7394a(String str, int i2, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            C2452v.m7382b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        m7395a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i2));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m7395a(java.net.HttpURLConnection r3) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = r3 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L39
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            r1 = 0
            android.content.Context r2 = com.huawei.hms.hatool.AbstractC2443q0.m7311i()     // Catch: java.lang.IllegalAccessException -> L12 java.io.IOException -> L15 java.security.GeneralSecurityException -> L18 java.security.KeyStoreException -> L1b java.security.NoSuchAlgorithmException -> L1e
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r1 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(r2)     // Catch: java.lang.IllegalAccessException -> L12 java.io.IOException -> L15 java.security.GeneralSecurityException -> L18 java.security.KeyStoreException -> L1b java.security.NoSuchAlgorithmException -> L1e
            goto L23
        L12:
            java.lang.String r2 = "getSocketFactory(): Illegal Access Exception "
            goto L20
        L15:
            java.lang.String r2 = "getSocketFactory(): IO Exception!"
            goto L20
        L18:
            java.lang.String r2 = "getSocketFactory(): General Security Exception"
            goto L20
        L1b:
            java.lang.String r2 = "getSocketFactory(): Key Store exception"
            goto L20
        L1e:
            java.lang.String r2 = "getSocketFactory(): Algorithm Exception!"
        L20:
            com.huawei.hms.hatool.C2452v.m7390f(r0, r2)
        L23:
            if (r1 == 0) goto L31
            r3.setSSLSocketFactory(r1)
            com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier r0 = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
            r0.<init>()
            r3.setHostnameVerifier(r0)
            goto L39
        L31:
            com.huawei.hms.hatool.w$a r3 = new com.huawei.hms.hatool.w$a
            java.lang.String r0 = "No ssl socket factory set"
            r3.<init>(r0)
            throw r3
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.AbstractC2454w.m7395a(java.net.HttpURLConnection):void");
    }

    /* renamed from: b */
    private static String m7396b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return C2426k1.m7201a(inputStream);
            } catch (IOException unused) {
                C2452v.m7390f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
                C2426k1.m7202a((Closeable) inputStream);
                return "";
            }
        } finally {
            C2426k1.m7202a((Closeable) inputStream);
        }
    }
}
