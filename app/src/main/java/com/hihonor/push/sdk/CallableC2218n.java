package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.n */
/* loaded from: classes.dex */
public class CallableC2218n implements Callable<Void> {

    /* renamed from: a */
    public final /* synthetic */ C2228s f6808a;

    public CallableC2218n(C2228s c2228s) {
        this.f6808a = c2228s;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        C2228s c2228s = this.f6808a;
        C2184a0 c2184a0 = c2228s.f6824b;
        Context context = c2228s.f6823a;
        c2184a0.getClass();
        try {
            C2195d1 c2195d1 = new C2195d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            c2195d1.f6779e = C2186b.m6359a();
            C2186b.m6363a(C2242z.f6856c.m6403a(c2195d1));
            C2193d.f6759b.m6380a(context, null);
            return null;
        } catch (Exception e2) {
            throw C2186b.m6362a(e2);
        }
    }
}
