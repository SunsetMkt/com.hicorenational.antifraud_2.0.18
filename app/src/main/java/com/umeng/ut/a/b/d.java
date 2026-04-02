package com.umeng.ut.a.b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
class d implements HostnameVerifier {
    public String a;

    public d(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.a) || !(obj instanceof d)) {
            return false;
        }
        String str = ((d) obj).a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
    }
}
