package com.umeng.ut.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.open.SocialOperation;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static d a;

    /* JADX INFO: renamed from: a */
    private static e f58a;

    static {
        System.setProperty("http.keepAlive", b.a.u.a.f1908j);
        f58a = null;
        a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:358:0x023d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, String str2, boolean z) throws Throwable {
        DataOutputStream dataOutputStream;
        Throwable th;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        Context contextM39a = com.umeng.ut.a.a.a().m39a();
        String appkey = UMUtils.getAppkey(contextM39a);
        if (TextUtils.isEmpty(appkey)) {
            return aVar;
        }
        try {
            URL url = new URL(str);
            if (TextUtils.isEmpty(url.getHost())) {
                return aVar;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (f58a == null) {
                    f58a = new e(url.getHost());
                }
                if (a == null) {
                    a = new d(url.getHost());
                }
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(f58a);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(a);
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoInput(true);
                if (z) {
                    httpURLConnection.setDoOutput(true);
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e2) {
                        com.umeng.ut.a.c.e.a("", e2, new Object[0]);
                        return aVar;
                    }
                } else {
                    try {
                        httpURLConnection.setRequestMethod("GET");
                    } catch (ProtocolException e3) {
                        com.umeng.ut.a.c.e.a("", e3, new Object[0]);
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                StringBuilder sb = new StringBuilder();
                httpURLConnection.setRequestProperty("x-audid-appkey", appkey);
                sb.append(appkey);
                String packageName = contextM39a.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    try {
                        httpURLConnection.setRequestProperty("x-audid-appname", URLEncoder.encode(packageName, "UTF-8"));
                        sb.append(packageName);
                    } catch (Exception unused) {
                    }
                }
                httpURLConnection.setRequestProperty("x-audid-sdk", "1.0.0");
                sb.append("1.0.0");
                String strM40a = com.umeng.ut.a.a.a().m40a();
                httpURLConnection.setRequestProperty("x-audid-timestamp", strM40a);
                com.umeng.ut.a.c.e.m42a("", "timestamp:" + strM40a);
                sb.append(strM40a);
                sb.append(str2);
                httpURLConnection.setRequestProperty(SocialOperation.GAME_SIGNATURE, com.umeng.ut.b.a.a.a.a(com.umeng.ut.a.c.b.c(sb.toString()).getBytes(), 2));
                long jCurrentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                DataInputStream dataInputStream = null;
                DataInputStream dataInputStream2 = null;
                try {
                    httpURLConnection.connect();
                    if (str2 == null || str2.length() <= 0) {
                        dataOutputStream = null;
                    } else {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.writeBytes(str2);
                            dataOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                            try {
                                com.umeng.ut.a.c.e.m42a("", th);
                                aVar.f8420b = System.currentTimeMillis() - jCurrentTimeMillis;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e4) {
                                        com.umeng.ut.a.c.e.m42a("", e4);
                                    }
                                }
                                return aVar;
                            } finally {
                            }
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e5) {
                            com.umeng.ut.a.c.e.m42a("", e5);
                        }
                    }
                    try {
                        aVar.a = httpURLConnection.getResponseCode();
                        aVar.signature = httpURLConnection.getHeaderField(SocialOperation.GAME_SIGNATURE);
                    } catch (Exception e6) {
                        com.umeng.ut.a.c.e.m42a("", e6);
                    }
                    try {
                        aVar.timestamp = Long.parseLong(httpURLConnection.getHeaderField("x-audid-timestamp"));
                        com.umeng.ut.a.c.e.m42a("", "repsonse.timestamp:" + aVar.timestamp);
                        long jM38a = com.umeng.ut.a.a.a().m38a();
                        if (aVar.timestamp > 0 && (aVar.timestamp > jM38a + 1800000 || aVar.timestamp < jM38a - 1800000)) {
                            com.umeng.ut.a.a.a().a(aVar.timestamp);
                        }
                    } catch (Exception unused2) {
                    }
                    aVar.f8420b = System.currentTimeMillis() - jCurrentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            DataInputStream dataInputStream3 = new DataInputStream(httpURLConnection.getInputStream());
                            try {
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int i2 = dataInputStream3.read(bArr, 0, 2048);
                                        if (i2 != -1) {
                                            byteArrayOutputStream.write(bArr, 0, i2);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e7) {
                                                com.umeng.ut.a.c.e.m42a("", e7);
                                            }
                                        }
                                    }
                                    dataInputStream3.close();
                                } catch (Throwable th3) {
                                    th = th3;
                                    dataInputStream = dataInputStream3;
                                    if (dataInputStream != null) {
                                    }
                                }
                            } catch (IOException e8) {
                                e = e8;
                                dataInputStream2 = dataInputStream3;
                                com.umeng.ut.a.c.e.m42a("", e);
                                try {
                                    dataInputStream3 = new DataInputStream(httpURLConnection.getErrorStream());
                                } catch (Exception e9) {
                                    e = e9;
                                }
                                try {
                                    byte[] bArr2 = new byte[2048];
                                    while (true) {
                                        int i3 = dataInputStream3.read(bArr2, 0, 2048);
                                        if (i3 != -1) {
                                            byteArrayOutputStream.write(bArr2, 0, i3);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e10) {
                                                com.umeng.ut.a.c.e.m42a("", e10);
                                            }
                                        }
                                    }
                                    dataInputStream3.close();
                                } catch (Exception e11) {
                                    e = e11;
                                    dataInputStream2 = dataInputStream3;
                                    com.umeng.ut.a.c.e.m42a("", e);
                                    if (dataInputStream2 != null) {
                                        try {
                                            dataInputStream2.close();
                                        } catch (Exception e12) {
                                            com.umeng.ut.a.c.e.m42a("", e12);
                                        }
                                    }
                                    return aVar;
                                }
                            }
                        } catch (IOException e13) {
                            e = e13;
                        }
                        if (byteArrayOutputStream.size() > 0) {
                            aVar.data = byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (dataInputStream != null) {
                            throw th;
                        }
                        try {
                            dataInputStream.close();
                            throw th;
                        } catch (Exception e14) {
                            com.umeng.ut.a.c.e.m42a("", e14);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            return aVar;
        } catch (MalformedURLException e15) {
            com.umeng.ut.a.c.e.a("", e15, new Object[0]);
            return aVar;
        } catch (IOException e16) {
            com.umeng.ut.a.c.e.a("", e16, new Object[0]);
            return aVar;
        } catch (Throwable th6) {
            com.umeng.ut.a.c.e.a("", th6, new Object[0]);
            return aVar;
        }
    }
}
