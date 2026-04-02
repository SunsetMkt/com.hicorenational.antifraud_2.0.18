package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private String a = "10.0.0.172";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7658b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7659c;

    public c(Context context) {
        this.f7659c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f7659c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.f7644i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f7659c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f7659c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.f7643h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.f7646k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.f7644i = a.f7646k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f7663b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f7663b.startsWith(d.c.a.b.a.a.K) || com.umeng.commonsdk.statistics.b.f7663b.startsWith("461")) {
            a.f7644i = a.f7643h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f A[PHI: r1 r3 r11
  0x012f: PHI (r1v1 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v2 boolean) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x012f: PHI (r3v9 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v10 java.io.OutputStream) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE]
  0x012f: PHI (r11v7 ??) = (r11v5 javax.net.ssl.HttpsURLConnection), (r11v6 javax.net.ssl.HttpsURLConnection), (r11v8 ??) binds: [B:38:0x011b, B:47:0x012c, B:25:0x0102] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, String str2, String str3) {
        boolean z = false;
        if (bArr != null && str != null) {
            if (SdkVersion.SDK_TYPE == 0) {
                a();
            } else {
                a.f7643h = a.f7646k;
                b();
            }
            String str4 = a.f7644i;
            HttpsURLConnection httpsURLConnection = str2;
            if (!com.umeng.commonsdk.vchannel.a.f7864c.equalsIgnoreCase(str)) {
                httpsURLConnection = str4;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u65e0\u72b6\u6001\u6536\u6570\u57df\u540d\uff1a" + ((String) httpsURLConnection));
            OutputStream outputStream = null;
            try {
                try {
                    httpsURLConnection = (HttpsURLConnection) new URL(((String) httpsURLConnection) + File.separator + str).openConnection();
                    try {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                        httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                        httpsURLConnection.setRequestProperty("Content-Type", bh.aT + str3);
                        httpsURLConnection.setRequestProperty("SM-IMP", "1");
                        httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, DeviceConfig.getCustomAgt());
                        httpsURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        httpsURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        httpsURLConnection.setRequestMethod("POST");
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setUseCaches(false);
                        outputStream = httpsURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        httpsURLConnection.connect();
                        if (httpsURLConnection.getResponseCode() == 200) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + a.f7644i + "/" + str);
                            z = true;
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (SSLHandshakeException e2) {
                        e = e2;
                        MLog.e("SSLHandshakeException, Failed to send message.", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (httpsURLConnection != 0) {
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        MLog.e("Exception,Failed to send message.", th);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (httpsURLConnection != 0) {
                        }
                        return z;
                    }
                } catch (SSLHandshakeException e3) {
                    e = e3;
                    httpsURLConnection = 0;
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection = 0;
                }
                if (httpsURLConnection != 0) {
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                        httpsURLConnection.disconnect();
                    } catch (Throwable unused4) {
                    }
                }
                return z;
            } finally {
            }
        } else {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
    }
}
