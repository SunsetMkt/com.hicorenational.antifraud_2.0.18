package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class n implements Callable<Void> {
    public final /* synthetic */ s a;

    public n(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        s sVar = this.a;
        a0 a0Var = sVar.f4275b;
        Context context = sVar.a;
        a0Var.getClass();
        try {
            d1 d1Var = new d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            d1Var.f4254e = b.a();
            b.a(z.f4293c.a(d1Var));
            d.f4240b.a(context, null);
            return null;
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}
