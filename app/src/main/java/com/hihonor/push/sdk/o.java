package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class o implements Callable<Boolean> {
    public final /* synthetic */ s a;

    public o(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.a.f4275b.getClass();
        try {
            c1 c1Var = new c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c1Var.f4254e = b.a();
            return Boolean.valueOf(((BooleanResult) b.a(z.f4293c.a(c1Var))).getStatus());
        } catch (Exception e2) {
            throw b.a(e2);
        }
    }
}
