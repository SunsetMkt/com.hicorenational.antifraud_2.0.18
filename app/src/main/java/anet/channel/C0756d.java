package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* compiled from: Taobao */
/* renamed from: anet.channel.d */
/* loaded from: classes.dex */
class C0756d implements IAmdcSign {

    /* renamed from: a */
    final /* synthetic */ String f770a;

    /* renamed from: b */
    final /* synthetic */ ISecurity f771b;

    /* renamed from: c */
    final /* synthetic */ SessionCenter f772c;

    C0756d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f772c = sessionCenter;
        this.f770a = str;
        this.f771b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.f770a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f771b.sign(this.f772c.f711b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f771b.isSecOff();
    }
}
