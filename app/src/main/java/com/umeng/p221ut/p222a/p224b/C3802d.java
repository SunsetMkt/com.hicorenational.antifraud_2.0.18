package com.umeng.p221ut.p222a.p224b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* renamed from: com.umeng.ut.a.b.d */
/* loaded from: classes2.dex */
class C3802d implements HostnameVerifier {

    /* renamed from: a */
    public String f13863a;

    public C3802d(String str) {
        this.f13863a = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f13863a) || !(obj instanceof C3802d)) {
            return false;
        }
        String str = ((C3802d) obj).f13863a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f13863a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f13863a, sSLSession);
    }
}
