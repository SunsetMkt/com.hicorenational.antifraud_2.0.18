package com.sina.weibo.sdk.p193a;

import android.content.Context;
import com.sina.weibo.sdk.net.C2931b;
import com.sina.weibo.sdk.net.C2934e;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.InterfaceC2932c;
import com.tencent.open.SocialConstants;

/* renamed from: com.sina.weibo.sdk.a.d */
/* loaded from: classes.dex */
public final class C2910d extends AbstractC2909c<Void, Void, String> {

    /* renamed from: Z */
    private Context f9287Z;

    /* renamed from: aa */
    private InterfaceC2932c<String> f9288aa;

    /* renamed from: ab */
    private Throwable f9289ab;

    /* renamed from: ac */
    private String f9290ac;

    /* renamed from: ad */
    private String f9291ad;

    /* renamed from: ae */
    private String f9292ae;

    public C2910d(Context context, String str, String str2, String str3, InterfaceC2932c<String> interfaceC2932c) {
        this.f9287Z = context;
        this.f9290ac = str;
        this.f9291ad = str2;
        this.f9292ae = str3;
        this.f9288aa = interfaceC2932c;
    }

    /* renamed from: d */
    private String m8811d(String str) {
        return HttpManager.m8850a(this.f9287Z, "", this.f9292ae, this.f9291ad, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.p193a.AbstractC2909c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String mo8809l() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            C2934e.a aVar = new C2934e.a();
            aVar.f9316i = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new C2931b().mo8851a(aVar.m8856a("oauth_timestamp", valueOf).m8856a("oauth_sign", m8811d(valueOf)).m8857b("appKey", this.f9291ad).m8857b("oauth_timestamp", valueOf).m8857b("oauth_sign", m8811d(valueOf)).m8857b(SocialConstants.PARAM_IMG_URL, this.f9290ac).m8858e()).mo8859f();
        } catch (Throwable th) {
            th.printStackTrace();
            this.f9289ab = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.p193a.AbstractC2909c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.f9289ab;
        if (th != null) {
            InterfaceC2932c<String> interfaceC2932c = this.f9288aa;
            if (interfaceC2932c != null) {
                interfaceC2932c.onError(th);
                return;
            }
            return;
        }
        InterfaceC2932c<String> interfaceC2932c2 = this.f9288aa;
        if (interfaceC2932c2 != null) {
            interfaceC2932c2.mo8814a(str2);
        }
    }
}
