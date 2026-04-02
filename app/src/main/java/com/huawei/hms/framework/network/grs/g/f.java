package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class f extends a implements Callable<d> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f4663i = "f";

    public f(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.c cVar2) {
        super(str, i2, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0139  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d call() throws Throwable {
        long jCurrentTimeMillis;
        long jElapsedRealtime;
        HttpsURLConnection httpsURLConnectionA;
        byte[] byteArray;
        Logger.i(f4663i, "Post call execute");
        long jCurrentTimeMillis2 = 0;
        HttpsURLConnection httpsURLConnection = null;
        InputStream inputStream = null;
        httpsURLConnection = null;
        httpsURLConnection = null;
        try {
        } catch (RuntimeException unused) {
            Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
        } catch (Throwable unused2) {
            Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
        }
        try {
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                    httpsURLConnectionA = com.huawei.hms.framework.network.grs.h.f.a.a(c(), a(), e());
                    try {
                    } catch (IOException e2) {
                        e = e2;
                        httpsURLConnection = httpsURLConnectionA;
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        jCurrentTimeMillis = System.currentTimeMillis();
                        Logger.w(f4663i, "RequestCallableV2 run task catch IOException", e);
                        this.a = new d(e, jElapsedRealtime2 - jElapsedRealtime);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        this.a.b(c());
                        this.a.a(d());
                        this.a.b(jCurrentTimeMillis2);
                        this.a.a(jCurrentTimeMillis);
                        if (b() != null) {
                        }
                        return this.a;
                    } catch (Throwable th) {
                        th = th;
                        if (httpsURLConnectionA != null) {
                            try {
                                httpsURLConnectionA.disconnect();
                            } catch (RuntimeException unused3) {
                                Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                            } catch (Throwable unused4) {
                                Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e = e4;
                jElapsedRealtime = 0;
            }
            if (httpsURLConnectionA == null) {
                Logger.w(f4663i, "create HttpsURLConnection instance by url return null.");
                if (httpsURLConnectionA != null) {
                    try {
                        httpsURLConnectionA.disconnect();
                    } catch (RuntimeException unused5) {
                        Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
                    } catch (Throwable unused6) {
                        Logger.w(f4663i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
                    }
                }
                return null;
            }
            httpsURLConnectionA.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnectionA.setRequestProperty("Connection", "close");
            httpsURLConnectionA.setRequestMethod("POST");
            httpsURLConnectionA.setDoOutput(true);
            httpsURLConnectionA.setDoInput(true);
            String strA = b() != null ? b().a() : "";
            if (TextUtils.isEmpty(strA)) {
                strA = "&";
            }
            httpsURLConnectionA.setRequestProperty("If-None-Match", strA);
            httpsURLConnectionA.connect();
            com.huawei.hms.framework.network.grs.h.f.a.a(httpsURLConnectionA, f().a("services", ""));
            int responseCode = httpsURLConnectionA.getResponseCode();
            Logger.i(f4663i, "httpsURLConnection result code:" + responseCode);
            if (responseCode == 200) {
                try {
                    inputStream = httpsURLConnectionA.getInputStream();
                    byteArray = IoUtils.toByteArray(inputStream);
                    IoUtils.closeSecure(inputStream);
                } catch (Throwable th2) {
                    IoUtils.closeSecure(inputStream);
                    throw th2;
                }
            } else {
                byteArray = null;
            }
            Map headerFields = httpsURLConnectionA.getHeaderFields();
            httpsURLConnectionA.disconnect();
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            jCurrentTimeMillis = System.currentTimeMillis();
            if (byteArray == null) {
                byteArray = new byte[0];
            }
            this.a = new d(responseCode, headerFields, byteArray, jElapsedRealtime3 - jElapsedRealtime);
            if (httpsURLConnectionA != null) {
                httpsURLConnectionA.disconnect();
            }
            this.a.b(c());
            this.a.a(d());
            this.a.b(jCurrentTimeMillis2);
            this.a.a(jCurrentTimeMillis);
            if (b() != null) {
                b().a(this.a);
            }
            return this.a;
            this.a.b(c());
            this.a.a(d());
            this.a.b(jCurrentTimeMillis2);
            this.a.a(jCurrentTimeMillis);
            if (b() != null) {
            }
            return this.a;
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnectionA = httpsURLConnection;
        }
    }
}
