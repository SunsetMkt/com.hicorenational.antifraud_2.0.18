package com.huawei.hms.framework.network.grs.p178h.p179f;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.p178h.C2382a;
import com.huawei.hms.framework.network.grs.p178h.p180g.C2388a;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.huawei.hms.framework.network.grs.h.f.a */
/* loaded from: classes.dex */
public class C2387a {
    /* renamed from: a */
    public static HttpsURLConnection m6986a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection openConnection = new URL(str).openConnection();
        if (!(openConnection instanceof HttpsURLConnection)) {
            Logger.m6803w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(C2388a.m6989a(context));
            httpsURLConnection.setHostnameVerifier(C2388a.m6988a());
        } catch (IllegalArgumentException unused) {
            Logger.m6803w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        String m6975b = C2382a.m6975b(context, "NetworkKit-grs", str2);
        Logger.m6794d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + m6975b);
        httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, m6975b);
        return httpsURLConnection;
    }

    /* renamed from: a */
    public static void m6987a(HttpsURLConnection httpsURLConnection, String str) {
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else {
            if (httpsURLConnection != null) {
                OutputStream outputStream = null;
                try {
                    outputStream = httpsURLConnection.getOutputStream();
                    outputStream.write(str.getBytes("UTF-8"));
                    outputStream.flush();
                    return;
                } finally {
                    IoUtils.closeSecure(outputStream);
                }
            }
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        }
        Logger.m6799i("URLConnectionHelper", str2);
    }
}
