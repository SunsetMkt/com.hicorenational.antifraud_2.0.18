package com.umeng.umzid;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.umeng.umzid.b */
/* loaded from: classes2.dex */
public final class C3793b implements HostnameVerifier {

    /* renamed from: a */
    public final /* synthetic */ String f13850a;

    public C3793b(String str) {
        this.f13850a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f13850a.equalsIgnoreCase(str) || "pre-aaid.umeng.com".equalsIgnoreCase(str);
    }
}
