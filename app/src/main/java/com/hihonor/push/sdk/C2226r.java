package com.hihonor.push.sdk;

import java.util.List;

/* renamed from: com.hihonor.push.sdk.r */
/* loaded from: classes.dex */
public class C2226r implements InterfaceC2213k0<List<HonorPushDataMsg>> {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f6818a;

    /* renamed from: b */
    public final /* synthetic */ C2228s f6819b;

    public C2226r(C2228s c2228s, HonorPushCallback honorPushCallback) {
        this.f6819b = c2228s;
        this.f6818a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2213k0
    /* renamed from: a */
    public void mo6351a(C2185a1<List<HonorPushDataMsg>> c2185a1) {
        if (!c2185a1.m6358e()) {
            C2228s.m6398a(this.f6819b, this.f6818a, -1, c2185a1.m6355b().toString());
            return;
        }
        C2228s c2228s = this.f6819b;
        HonorPushCallback honorPushCallback = this.f6818a;
        List<HonorPushDataMsg> m6356c = c2185a1.m6356c();
        c2228s.getClass();
        C2188b1.m6373a(new RunnableC2230t(c2228s, honorPushCallback, m6356c));
    }
}
