package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.o */
/* loaded from: classes.dex */
public class CallableC2220o implements Callable<Boolean> {

    /* renamed from: a */
    public final /* synthetic */ C2228s f6810a;

    public CallableC2220o(C2228s c2228s) {
        this.f6810a = c2228s;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.f6810a.f6824b.getClass();
        try {
            C2191c1 c2191c1 = new C2191c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c2191c1.f6779e = C2186b.m6359a();
            return Boolean.valueOf(((BooleanResult) C2186b.m6363a(C2242z.f6856c.m6403a(c2191c1))).getStatus());
        } catch (Exception e2) {
            throw C2186b.m6362a(e2);
        }
    }
}
