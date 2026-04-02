package com.alibaba.sdk.android.httpdns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public class m implements Callable<String[]> {
    private static m a;

    /* JADX INFO: renamed from: d */
    private int f2579d;

    /* JADX INFO: renamed from: d */
    private long f23d = 0;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.m$1 */
    class AnonymousClass1 implements HostnameVerifier {

        /* JADX INFO: renamed from: f */
        final /* synthetic */ String f2581f;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            i.d("StartIp Https request, set hostnameVerifier. StartIp url\uff1a" + str);
            return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
        }
    }

    /* JADX INFO: renamed from: com.alibaba.sdk.android.httpdns.m$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (n.f24h) {
                    return;
                }
                m.this.call();
            } catch (Exception e2) {
                i.a(e2);
            }
        }
    }

    public static m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    public void a(int i2) {
        this.f2579d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x011c A[Catch: all -> 0x014f, TRY_LEAVE, TryCatch #7 {all -> 0x014f, blocks: (B:123:0x0051, B:124:0x0056, B:126:0x005c, B:127:0x0060, B:128:0x009e, B:165:0x010e, B:167:0x011c, B:168:0x0122, B:171:0x0135, B:131:0x00af, B:132:0x00b4, B:134:0x00ba, B:135:0x00be), top: B:205:0x0008, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x013a A[Catch: all -> 0x0167, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:110:0x0001, B:173:0x013a, B:175:0x013f, B:179:0x0147, B:181:0x014b, B:157:0x00ff, B:186:0x0152, B:188:0x0157, B:192:0x015f, B:195:0x0166, B:194:0x0163, B:149:0x00ee, B:151:0x00f3, B:155:0x00fb), top: B:201:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0147 A[Catch: IOException -> 0x0143, all -> 0x0167, TRY_LEAVE, TryCatch #4 {, blocks: (B:110:0x0001, B:173:0x013a, B:175:0x013f, B:179:0x0147, B:181:0x014b, B:157:0x00ff, B:186:0x0152, B:188:0x0157, B:192:0x015f, B:195:0x0166, B:194:0x0163, B:149:0x00ee, B:151:0x00f3, B:155:0x00fb), top: B:201:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0152 A[Catch: all -> 0x0167, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:110:0x0001, B:173:0x013a, B:175:0x013f, B:179:0x0147, B:181:0x014b, B:157:0x00ff, B:186:0x0152, B:188:0x0157, B:192:0x015f, B:195:0x0166, B:194:0x0163, B:149:0x00ee, B:151:0x00f3, B:155:0x00fb), top: B:201:0x0001, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x015f A[Catch: IOException -> 0x015b, all -> 0x0167, TRY_LEAVE, TryCatch #12 {IOException -> 0x015b, blocks: (B:188:0x0157, B:192:0x015f), top: B:208:0x0157, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String[] call() {
        HttpURLConnection httpURLConnection;
        ?? r3;
        ?? responseCode;
        Exception e2;
        InputStream inputStream;
        BufferedReader bufferedReader;
        this.f23d = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                String strM25d = n.a().m25d();
                if (strM25d != null) {
                    i.d("StartIp call start");
                    httpURLConnection = (HttpURLConnection) new URL(strM25d).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(15000);
                        httpURLConnection.setReadTimeout(15000);
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.sdk.android.httpdns.m.1

                                /* JADX INFO: renamed from: f */
                                final /* synthetic */ String f2581f;

                                AnonymousClass1(String strM25d2) {
                                    str = strM25d2;
                                }

                                @Override // javax.net.ssl.HostnameVerifier
                                public boolean verify(String str, SSLSession sSLSession) {
                                    i.d("StartIp Https request, set hostnameVerifier. StartIp url\uff1a" + str);
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
                                }
                            });
                        }
                        responseCode = httpURLConnection.getResponseCode();
                        r3 = 200;
                    } catch (Exception e3) {
                        e = e3;
                        r3 = 0;
                        e2 = e;
                        responseCode = r3;
                        i.a(e2);
                        n.a().c(e2);
                        if (this.f2579d > 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (responseCode != 0) {
                        }
                        if (r3 != 0) {
                        }
                        return new String[0];
                    } catch (Throwable th) {
                        th = th;
                        r3 = 0;
                        th = th;
                        responseCode = r3;
                        if (httpURLConnection != null) {
                        }
                        if (responseCode != 0) {
                        }
                        if (r3 != 0) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            if (responseCode != 200) {
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "UTF-8"));
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        i.f("StartIp response code is " + httpURLConnection.getResponseCode() + " expect 200. response body is " + sb.toString());
                                        g gVar = new g(httpURLConnection.getResponseCode(), sb.toString());
                                        throw new h(gVar.getErrorCode(), gVar.b());
                                    }
                                    sb.append(line);
                                }
                            } else {
                                inputStream = httpURLConnection.getInputStream();
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    String line2 = bufferedReader.readLine();
                                    if (line2 == null) {
                                        break;
                                    }
                                    sb2.append(line2);
                                }
                                n.a().a(new o(sb2.toString()), System.currentTimeMillis() - this.f23d);
                                httpURLConnection2 = httpURLConnection;
                            }
                        } catch (Exception e4) {
                            r3 = 0;
                            e2 = e4;
                            i.a(e2);
                            n.a().c(e2);
                            if (this.f2579d > 0) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (responseCode != 0) {
                            }
                            if (r3 != 0) {
                            }
                            return new String[0];
                        } catch (Throwable th2) {
                            r3 = 0;
                            th = th2;
                            if (httpURLConnection != null) {
                            }
                            if (responseCode != 0) {
                            }
                            if (r3 != 0) {
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        i.a(e2);
                        n.a().c(e2);
                        if (this.f2579d > 0) {
                            this.f2579d--;
                            try {
                                j.a().schedule(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.m.2
                                    AnonymousClass2() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (n.f24h) {
                                                return;
                                            }
                                            m.this.call();
                                        } catch (Exception e22) {
                                            i.a(e22);
                                        }
                                    }
                                }, 300000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e6) {
                                i.a(e6);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (responseCode != 0) {
                            try {
                                responseCode.close();
                            } catch (IOException e7) {
                                e = e7;
                                i.a(e);
                            }
                        }
                        if (r3 != 0) {
                            r3.close();
                        }
                        return new String[0];
                    }
                } else {
                    inputStream = null;
                    bufferedReader = null;
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                        e = e8;
                        i.a(e);
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e9) {
                e = e9;
                httpURLConnection = null;
                r3 = 0;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                r3 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (responseCode != 0) {
                try {
                    responseCode.close();
                } catch (IOException e10) {
                    i.a(e10);
                    throw th;
                }
            }
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
        return new String[0];
    }
}
