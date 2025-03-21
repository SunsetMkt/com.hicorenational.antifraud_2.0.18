package com.hihonor.push.sdk;

import org.json.JSONException;

/* renamed from: com.hihonor.push.sdk.a */
/* loaded from: classes.dex */
public class C2183a implements InterfaceC2213k0<HonorPushDataMsg> {

    /* renamed from: a */
    public final /* synthetic */ HonorMessageService f6747a;

    public C2183a(HonorMessageService honorMessageService) {
        this.f6747a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.InterfaceC2213k0
    /* renamed from: a */
    public void mo6351a(C2185a1<HonorPushDataMsg> c2185a1) {
        if (!c2185a1.m6358e()) {
            boolean z = c2185a1.m6355b() instanceof JSONException;
            return;
        }
        HonorPushDataMsg m6356c = c2185a1.m6356c();
        if (m6356c != null) {
            String str = "onMessageReceived. msgId is " + m6356c.getMsgId();
            this.f6747a.onMessageReceived(m6356c);
        }
    }
}
