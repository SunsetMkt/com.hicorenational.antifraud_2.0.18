package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* renamed from: com.hihonor.push.sdk.a0 */
/* loaded from: classes.dex */
public class C2184a0 {
    /* renamed from: a */
    public Void m6352a(boolean z) throws ApiException {
        try {
            C2204g1 c2204g1 = new C2204g1(z ? UpMsgType.TURN_ON_PUSH : UpMsgType.TURN_OFF_PUSH, null);
            c2204g1.f6779e = C2186b.m6359a();
            C2186b.m6363a(C2242z.f6856c.m6403a(c2204g1));
            return null;
        } catch (Exception e2) {
            throw C2186b.m6362a(e2);
        }
    }
}
