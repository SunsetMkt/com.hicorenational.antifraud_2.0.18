package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* compiled from: HttpManager.java */
/* renamed from: com.umeng.analytics.pro.am */
/* loaded from: classes2.dex */
public class C3329am {

    /* renamed from: a */
    private static HostnameVerifier f11462a;

    /* renamed from: a */
    private static HostnameVerifier m10849a() {
        if (f11462a == null) {
            f11462a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.am.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str);
                }
            };
        }
        return f11462a;
    }

    /* renamed from: b */
    public static void m10853b(String str, byte[] bArr) {
        byte[] bArr2;
        HttpsURLConnection httpsURLConnection = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                C3335as.m10862a(bArr, byteArrayOutputStream);
                bArr2 = C3335as.m10863a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArr2 = null;
            }
            httpsURLConnection = m10850a(str, "appkey", bArr2);
            if (httpsURLConnection != null) {
                int responseCode = httpsURLConnection.getResponseCode();
                if (responseCode != 200) {
                    String str2 = "SC event report error, http error code: " + responseCode;
                } else {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "SC event report successful.");
                }
            }
            if (httpsURLConnection == null) {
                return;
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (0 == 0) {
                    return;
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        httpsURLConnection.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        try {
            httpsURLConnection.disconnect();
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: a */
    public static byte[] m10851a(String str, String str2) {
        return m10852a(str, str2.getBytes());
    }

    /* renamed from: a */
    public static byte[] m10852a(String str, byte[] bArr) {
        byte[] readStreamToByteArray;
        byte[] bArr2 = null;
        try {
            HttpsURLConnection m10850a = m10850a(str, SocializeProtocolConstants.PROTOCOL_KEY_AK, C3335as.m10863a(bArr, UMConfigure.sAppkey.getBytes()));
            if (m10850a != null && m10850a.getResponseCode() == 200) {
                InputStream inputStream = m10850a.getInputStream();
                try {
                    readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = m10850a.getHeaderField(SocializeProtocolConstants.PROTOCOL_KEY_AK);
                    if (!TextUtils.isEmpty(headerField)) {
                        bArr2 = C3335as.m10863a(readStreamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    }
                    HelperUtils.safeClose(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return bArr2;
    }

    /* renamed from: a */
    private static HttpsURLConnection m10850a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(m10849a());
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.addRequestProperty("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                httpsURLConnection.addRequestProperty(str2, UMConfigure.sAppkey);
                httpsURLConnection.connect();
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e3) {
            e = e3;
            httpsURLConnection = null;
        }
        return httpsURLConnection;
    }
}
