package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements IAmdcSign {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ISecurity f1400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionCenter f1401c;

    d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f1401c = sessionCenter;
        this.a = str;
        this.f1400b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f1400b.sign(this.f1401c.f1358b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f1400b.isSecOff();
    }
}
