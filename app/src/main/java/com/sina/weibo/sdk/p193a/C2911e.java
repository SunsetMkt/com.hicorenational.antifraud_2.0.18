package com.sina.weibo.sdk.p193a;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.C2931b;
import com.sina.weibo.sdk.net.C2934e;
import com.sina.weibo.sdk.net.InterfaceC2932c;
import com.tencent.connect.common.Constants;

/* renamed from: com.sina.weibo.sdk.a.e */
/* loaded from: classes.dex */
public final class C2911e extends AbstractC2909c<Void, Void, String> {

    /* renamed from: aa */
    private InterfaceC2932c<String> f9293aa;

    /* renamed from: ab */
    private Throwable f9294ab;

    /* renamed from: ad */
    private String f9295ad;

    /* renamed from: af */
    private Oauth2AccessToken f9296af;

    public C2911e(String str, Oauth2AccessToken oauth2AccessToken, InterfaceC2932c<String> interfaceC2932c) {
        this.f9295ad = str;
        this.f9296af = oauth2AccessToken;
        this.f9293aa = interfaceC2932c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.p193a.AbstractC2909c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String mo8809l() {
        try {
            C2934e.a aVar = new C2934e.a();
            aVar.f9316i = "https://api.weibo.com/oauth2/access_token";
            return new C2931b().mo8851a(aVar.m8857b(Constants.PARAM_CLIENT_ID, this.f9295ad).m8857b("appKey", this.f9295ad).m8857b("grant_type", "refresh_token").m8857b("refresh_token", this.f9296af.getRefreshToken()).m8858e()).mo8859f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.f9294ab = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.p193a.AbstractC2909c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.f9294ab;
        if (th != null) {
            InterfaceC2932c<String> interfaceC2932c = this.f9293aa;
            if (interfaceC2932c != null) {
                interfaceC2932c.onError(th);
                return;
            }
            return;
        }
        InterfaceC2932c<String> interfaceC2932c2 = this.f9293aa;
        if (interfaceC2932c2 != null) {
            interfaceC2932c2.mo8814a(str2);
        }
    }
}
